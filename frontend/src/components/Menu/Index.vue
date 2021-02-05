<template>
  <section class="menu">
    <div v-for="(route, index) in routes" :key="index">
      <router-link exact-active-class="active" :to="{name: route.name}" tag="li">
        <div>{{route.name}}</div>
      </router-link>
    </div>
  </section>
</template>

<script>
//import MenuItem from "./MenuItem"
export default {
  nane: "Index",
  components: {
    //MenuItem
  },
  computed: {
    routes() {
      console.log(this.$router.options.routes)
      return this.$router.options.routes;
    }
  }
}
</script>

<style scoped>
.menu {
  background-color: #F1F3F4;
  width: 300px;
  height: 100%;
}
</style>