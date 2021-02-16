<template>
  <div >
    <h3 class="headerText">Oppskrifter</h3>
    <FilterMenu />
    <v-container align="center" class="scrollDiv">
      <v-row algin="center" justify="center">
        <v-col v-for="recipe in recipes" :key="recipe.name" sm="6" md="6" algin="center" justify="center">
          <RecipeCard :title="recipe.name"
                      :rating="recipe.rating"
                      :description="recipe.description"
                      :minutes="recipe.minutes"
                      :price="recipe.price"
                      :url="recipe.url" />
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import RecipeCard from "./RecipeCard"
import FilterMenu from './FilterMenu'
import RecipeDataService from '../../services/RecipeDataService'
import firebase from 'firebase'
export default {
  name: "Recipe",
  components: {
    RecipeCard,
    FilterMenu 
  },
  data(){
    return{
      recipes: []
    }
  },
  methods: {
    fetchAllRecipes(){
      RecipeDataService.retriveAllRecipe().then(res => {
        console.log(res.data)
        this.recipes = res.data
        })
    }
  },
  created(){
    this.fetchAllRecipes()
    console.log(firebase.auth().currentUser)
  }
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