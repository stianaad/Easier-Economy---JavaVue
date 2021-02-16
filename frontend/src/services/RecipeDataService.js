import axios from 'axios'

const COURSE_API_URL = "http://localhost:8080"

class RecipeDataService {
  retriveAllRecipe(){
    return axios.get(`${COURSE_API_URL}/allRecipe`)
  }

  retriveOneRecipe(id){
    return axios.get(`${COURSE_API_URL}/recipe/${id}`)
  }
}

export default new RecipeDataService()