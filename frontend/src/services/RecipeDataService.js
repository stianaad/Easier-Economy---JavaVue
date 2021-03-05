import axios from 'axios'

const COURSE_API_URL = "http://localhost:8080"

class RecipeDataService {
  retriveAllRecipe(){
    return axios.get(`${COURSE_API_URL}/allRecipe`)
  }

  retriveOneRecipe(id){
    return axios.get(`${COURSE_API_URL}/recipe/${id}`)
  }

  sendImage(data){
    return axios.post(`${COURSE_API_URL}/profile/pic`, data)
  }

  getImage(name){
    //return 
  }
}

export default new RecipeDataService()