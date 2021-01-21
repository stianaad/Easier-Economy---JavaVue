<template>
  <div class="container">
    <h3>All Courses</h3>
    <div v-if="message" class="alert alert-success">
      {{message}}
    </div>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Description</th>
            <th>Update</th>
            <th>Delete</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="course in courses" v-bind:key="course.id">
            <td>{{course.id}}</td>
            <td>{{course.description}}</td>
            <td>
              <button class="btn btn-success" v-on:click="updateCourseCliked(course.id)">
                Update
              </button>
            </td>
            <td>
              <button class="btn btn-warning" v-on:click="deleteCourseCliked(course.id)">
                Delete
              </button>
            </td>        
          </tr>
        </tbody>
      </table>
      <div class="row">
        <button class="btn btn-success" v-on:click="addCourseCliked()">Add</button>
      </div>
    </div>
  </div>
</template>

<script>
import CourseDataService from '../services/CourseDataService'
  export default {
    name: "CoursesList",
    data(){
      return {
        courses: [],
        message: null,
        INSTRUCTOR: "in28minutes"
      }
    },
    methods: {
      refreshCourses() {
        CourseDataService.retrieveAllCourses(this.INSTRUCTOR)
        .then(response => {
          this.courses = response.data
        })
      },
      deleteCourseCliked(id) {
        CourseDataService.deleteCourse(id).then(() => {
          this.message = `Delete of course ${id} Successful`
          this.refreshCourses()
        })
      },
      updateCourseCliked(id) {
        this.$router.push(`/courses/${id}`)
      },
      addCourseCliked() {
        this.$router.push(`/courses/-1`)
      }
    },
    created(){
      this.refreshCourses()
    }
  }
</script>
