<template>
  <div >
    <h3 class="headerText">Oppskrifter</h3>
    <FilterMenu />
    <v-container align="center" class="scrollDiv">
      <v-row algin="center" justify="center">
        <v-col v-for="k in 6" :key="k" sm="6" md="6" algin="center" justify="center">
          <RecipeCard/>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import RecipeCard from "./RecipeCard"
import FilterMenu from './FilterMenu'
export default {
  name: "Recipe",
  components: {
    RecipeCard,
    FilterMenu
  },
}
</script>

<style scoped>
.headerText {
  font-size: 4rem;
  font-family: 'Roboto';
  text-align: center;
}

.scrollDiv {
  overflow-y: scroll;
  height: calc(66vh)
}

</style>