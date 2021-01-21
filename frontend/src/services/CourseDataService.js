import axios from 'axios'

const INSTRUCTOR = "in28minutes"
const COURSE_API_URL = "http://localhost:8080"
const INSTRUCTOR_API_URL = `${COURSE_API_URL}/instructors/${INSTRUCTOR}`


class CourseDataService {
  retrieveAllCourses() {
    return axios.get(`${INSTRUCTOR_API_URL}/courses`)
  }

  deleteCourse(id) {
    return axios.delete(`http://localhost:8080/instructors/in28minutes/courses/${id}`)
  }

  retrieveCourse(id){
    return axios.get(`${INSTRUCTOR_API_URL}/courses/${id}`)
  }

  updateCourse(id, course){
    return axios.put(`${INSTRUCTOR_API_URL}/courses/${id}`, course)
  }

  createCourse(course){
    return  axios.post(`${INSTRUCTOR_API_URL}/courses`, course)
  }
}

export default new CourseDataService()
