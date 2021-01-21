<template>
  <div>
    <h1>Course</h1>
    <div class="container">
      <form @submit="validateAndSubmit">
        <div v-if="errors.length">
          <div class="alert alert-warning" v-bind:key="index" v-for="(error, index) in errors">
            {{error}}
          </div>
        </div>
        <fieldset class="form-group">
          <label>Id</label>
          <input type="text" class="form-control" v-model="id" disabled>
        </fieldset>
        <fieldset class="form-group">
          <label>Description</label>
          <input type="text" class="form-control" v-model="description">
        </fieldset>
        <button class="btn btn-success" type="submit"> Save</button>
      </form>
    </div>
  </div>
</template>

<script>
import CourseDataService from '../services/CourseDataService'
export default {
  name: "courseDetails",
  data() {
    return {
      description: "",
      INSTRUCTOR: "in28minutes",
      errors: []
    }
  },
  computed: {
    id() {
      return this.$route.params.id;
    }
  },
  methods: {
    refreshCourseDetails() {
      CourseDataService.retrieveCourse(this.id).then(res => {
        this.description = res.data.description
      })
    },
    validateAndSubmit(e) {
      this.validate(e)
      if(this.errors.length === 0){
        if(this.id === -1){
          CourseDataService.createCourse({
            description: this.description
          }).then(() => {
            this.$router.push('/courses')
          })
        } else {
          CourseDataService.updateCourse(this.id, {
            id: this.id,
            description: this.description
          }).then(() => {
            this.$router.push('/courses')
          })
        }
      }
      console.log({
        id: this.id,
        description: this.description
      })

    },
    validate(e) {
      e.preventDefault();
      this.errors = []
      if(!this.description){
        this.errors.push("Enter valid values")
      } else if(this.description.length < 5){
        this.errors.push("Enter atleast 5 characters in Description")
      }
    }
  },
  created() {
    this.refreshCourseDetails()
  }
}
</script>

