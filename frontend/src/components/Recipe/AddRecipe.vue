<template>
  <v-row justify="center">
    <v-dialog
      v-model="displayDialog"
      max-width="600"
    >
      <v-card>
        <v-card-text class="text-center">
          <div class="text-h4 pa-12">Ny oppskrift</div>
          <div v-if="!image" >
            <div class="text-subtitle-1">Legg til bilde</div>
            <input type="file" ref="uploadImage" @change="onImageUpload()">
          </div>
          <div v-else>
            <img :src="image"/>
            <v-btn text @click="removeImage">Fjern bilde</v-btn>
          </div>
           <v-container class="mt-10">
                <v-row>
                  <v-col xs="12" sm="6">
                    <v-select
                      v-model="difficultyValue"
                      class="dropdown"
                      :items="difficultyLevels" 
                      label="Vanskelighetsgrad"
                      solo
                      :rules="[rules.required]"
                      rounded/>
                  </v-col>
                  <v-col xs="12">
                    <v-select
                      v-model="categoryValue"
                      class="dropdown"
                      :items="categoryLevels" 
                      label="Kategori"
                      solo
                      :rules="[rules.required]"
                      rounded/>
                  </v-col>
                </v-row>
              </v-container>
          <div class="maxWidthTextfield mx-auto mt-5">
            <v-text-field
              v-model="name"
              dense
              :rules="[rules.required]"
              label="Overskrift"
              prepend-inner-icon="mdi-format-text"/>
            <v-container class="mt-3">
              <v-row>
                <v-col>
                  <v-text-field
                    v-model="minutes"
                    dense
                    :rules="[rules.required]"
                    type="number"
                    label="Minutt"
                    suffix="Min"
                    prepend-inner-icon="mdi-clock-time-nine-outline"/>
                </v-col>
                <v-col>
                  <v-text-field
                    v-model="portion"
                    dense
                    :rules="[rules.required]"
                    type="number"
                    label="Porsjoner"
                    prepend-inner-icon="mdi-currency-usd"/>
                </v-col>
              </v-row>
            </v-container>
            <v-textarea
              class="descriptionField mt-3"
              v-model="description"
              solo
              name="description"
              label="Beskrivelse"
            ></v-textarea>
            <v-divider/>
            <div class="text-h6">Ingredienser</div>
            <v-container>
              <v-row v-for="(value,index) in ingredientName" :key="index">
                <v-col sm="6">
                  <v-text-field
                    v-model="ingredientName[index]"
                    dense
                    :rules="[rules.required]"
                    label="Ingrediensnavn"/>
                </v-col>
                <v-col class="textAndIcon" sm="6">
                  <v-text-field
                    v-model="ingredientValue[index]"
                    dense
                    :rules="[rules.required]"
                    label="Ingrediensverdi"/>
                  <v-icon class="ml-3 float-right removeIcon" @click="removeIngredient(index)">mdi-close</v-icon>
                </v-col>
              </v-row>
            </v-container>
              <v-btn text class="float-right font-italic" @click="newIngredient">
                Ny ingrediens
                <v-icon right>
                  mdi-plus
                </v-icon>
              </v-btn>
          </div>
        </v-card-text>

        <v-divider class="mt-5"/>

        <v-card-actions class="justify-end">
          <v-btn
          color="red"
            text
            @click="hideDialog"
          >
            Avbryt
          </v-btn>
          <v-btn
            color="green darken-1"
            text
            @click="createRecipe()"
          >
            Legg til oppskrift
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
import RecipeDataService from '../../services/RecipeDataService'
import difficulty from './difficulty.json'
import category from './category.json'
  export default {
    props: {
      showDialog: {
        type: Boolean,
      }
    },
    data() {
      return {
        displayDialog: false,
        formData: null,
        image: false,
        name: "",
        description: "",
        category: "",
        difficulty: 0,
        minutes: 0,
        portion: 0,
        difficultyLevels: difficulty,
        difficultyValue: 0,
        categoryLevels: category,
        categoryValue: 0,
        rules: {
          required: value => !!value || 'Nødvendig'
        },
        ingredientName: [""],
        ingredientValue: [""]
      };
    },
    methods: {
      createRecipe() {
        /*if(this.difficultyValue !== 0 && this.categoryValue !== 0
          && this.portion !== 0 && this.minutes !== 0 && this.name !== ""
          && this.description !== "" && this.formData !== false && this.ingredientName.length > 0 && this.ingredientValue.length > 0) {
          console.log("Hei")
        }*/
        let ingredients = this.ingredientName.map( (e, index) => {
          return {
            "ingredientName" : e,
            "ingredientValue": this.ingredientValue[index]
          }
        })
        this.difficultyValue = difficulty.indexOf(this.difficultyValue)
        this.categoryValue = category.indexOf(this.categoryValue)
        RecipeDataService.sendImage(this.formData).then(res => {
          RecipeDataService.createRecipe({"name": this.name, "description": this.description, "minutes": this.minutes,
          "url": res.data, "category": this.categoryValue, "difficulty": this.difficultyValue, "ingredients": ingredients, "portion": this.portion}).then( res => {
            console.log(res)
          })
        }).catch(() => console.log("Noe gikk galt, prøv på nytt"))
      },
      newIngredient() {
        this.ingredientName.push("")
        this.ingredientValue.push("")
      },
      removeIngredient(index) {
        this.ingredientName.splice(index,1)
        this.ingredientValue.splice(index,1)
      },
      hideDialog() {
        this.displayDialog = false;
      },
      onImageUpload() {
        let file = this.$refs.uploadImage.files[0];
        this.formData = new FormData();
        this.formData.append("file", file);
        this.createImage(file)
      },
      createImage(file) {
      //var image = new Image();
      var reader = new FileReader();

      reader.onload = (e) => {
        this.image = e.target.result;
      };
      reader.readAsDataURL(file);
      },
      removeImage() {
        this.image = false
      }
    },
    watch: {
      showDialog(val) {
          this.displayDialog  = val;
      },
    }
  }
</script>
<style scoped>
img {
  width: 60%;
  margin: auto;
  display: block;
  margin-bottom: 10px;
}

.maxWidthTextfield {
  width: 400px
}

.textAndIcon {
  display: flex;
  justify-content: space-between;
}

.removeIcon {
  cursor: pointer;
}
</style>