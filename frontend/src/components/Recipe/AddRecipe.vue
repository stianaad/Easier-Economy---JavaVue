<template>
  <v-row justify="center">
    <v-dialog
      v-model="displayDialog"
      max-width="290"
    >
      <v-card>
        <input type="file" ref="uploadImage"
          @change="onImageUpload()" >
          <v-btn
            color="green darken-1"
            text
            @click="hideDialog"
          >
            Disagree
          </v-btn>

          <v-btn
            color="green darken-1"
            text
            @click="sendImage()"
          >
            Upload
          </v-btn>
      </v-card>
    </v-dialog>
  </v-row>
</template>

<script>
import RecipeDataService from '../../services/RecipeDataService'
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
      };
    },
    methods: {
      hideDialog() {
        this.displayDialog = false;
      },
      onImageUpload() {
        let file = this.$refs.uploadImage.files[0];
        this.formData = new FormData();
        this.formData.append("file", file);
      },
      sendImage() {
        RecipeDataService.sendImage(this.formData).then(res => {
          console.log(res)
        })
      }
    },
    watch: {
      showDialog(val) {
          this.displayDialog  = val;
          console.log(val)
      }
    }
  }
</script>