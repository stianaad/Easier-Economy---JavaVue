<template>
  <div>
    <v-text-field
      label="Søk"
      placeholder="Spaghetti"
      rounded
      outlined
      dense
      v-model="text"
      @input="update"
      class="mx-auto"
      prepend-inner-icon="mdi-magnify"/>
    <v-container class="mx-20 mt-7">
      <v-row align="center" >
        <v-col xs="12" sm="6" md="4">
          <v-select
        v-model="difficultyValue"
        class="dropdown mx-auto"
        :items="difficulty" 
        label="Vanskelighetsgrad"
        solo
        rounded/>
        </v-col>
        <v-col xs="12" sm="6" md="4" class="mx-auto">
          <v-select 
        class="dropdown mx-auto"
        :items="rating"
        v-model="ratingValue"
        label="Rangering"
        solo
        rounded/>
        </v-col>
        <v-col xs="12" sm="12" md="4">
          <v-slider
        class="slider mx-auto"
        v-model="ex1.val"
        :color="ex1.color"
        :track-color="ex1.trackColor"
        :label="ex1.label"
        min="0"
        max="200"
        thumb-label="always"/>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
  export default {
    name: "FilterMenu",
    data(){
      return {
        ex1: { label: 'Tid', val: 125, color: 'blue light-1', trackColor: "black"},
        text: "",
        difficultyValue: "",
        difficulty: ['Alle', 'Lett', 'Middels', 'Vanskelig'],
        rating: ["Alle",1, 2, 3, 4, 5],
        ratingValue: 0
        }
    },
    methods: {
      update(){
        console.log(this.text)
      },
    },
    watch: {
      difficultyValue(){
        this.$emit('clicked', this.difficultyValue)
      },
      ratingValue() {
        this.$emit('rating', this.ratingValue)
      }
    }
  }
</script>

<style scoped>
.v-text-field {
  width: 70vh;
}

.slider {
  width: 30vh;
}

.dropdown {
  width: 30vh;
}
</style>