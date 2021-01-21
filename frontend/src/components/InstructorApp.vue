<template>
  <div>
    <h1>Instruct application</h1>
    <list-courses-component></list-courses-component>
  </div>
</template>

<script>
import ListCoursesComponent from './ListCoursesComponent.vue'
export default {
  components: { ListCoursesComponent },
  name: "InstructorApp"
}
</script>

<style scoped>
</style>