<template>
  <div >
    <h3 class="headerText">Oppskrifte</h3>
    <FilterMenu @clicked="difficultyFilter" @rating="ratingFilter"/>
    <v-container align="center" class="scrollDiv">
      <v-row algin="center" justify="center">
        <v-col v-for="recipe in recipes" :key="recipe.name" sm="6" md="6" algin="center" justify="center">
          <RecipeCard :title="recipe.name"
                      :rating="recipe.rating"
                      :description="recipe.description"
                      :minutes="recipe.minutes"
                      :price="recipe.price"
                      :url="recipe.url"
                      :difficulty="recipe.difficulty" />
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import RecipeCard from "./RecipeCard"
import FilterMenu from './FilterMenu'
import RecipeDataService from '../../services/RecipeDataService'
export default {
  name: "Recipe",
  components: {
    RecipeCard,
    FilterMenu 
  },
  data(){
    return{
      recipes: [],
      allRecipes: [],
      difficultyValue: 0,
      ratingValue: 0,
      
    }
  },
  methods: {
    fetchAllRecipes(){
      RecipeDataService.retriveAllRecipe().then(res => {
        this.recipes = res.data
        this.allRecipes = res.data
        })
    },
    difficultyFilter(value) {
        const jsonTable = {"Alle": 0, "Lett": 1, "Middels": 2, "Vanskelig": 3}
        this.difficultyValue = jsonTable[value]
        this.filterFunction()
    },
    ratingFilter(value) {
      if (value == "Alle") {
        this.ratingValue = 0
      } else {
        this.ratingValue = value
      }
      this.filterFunction()
    },
    filterFunction() {
      this.recipes = this.allRecipes.filter( e => e.difficulty >= this.difficultyValue).filter(e => e.rating >= this.ratingValue)
    }
  },
  created(){
    this.fetchAllRecipes()
    //console.log(firebase.auth().currentUser)
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