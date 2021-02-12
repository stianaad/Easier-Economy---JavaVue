<template>
  <v-card
    class="mx-auto"
    height="100%"
    width="256px"
  >
    <v-navigation-drawer permanent absolute class="backgroundGradient">
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="title textColor">
            Easier Economy
          </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-divider></v-divider>

      <v-list
        dense
        nav
      >
        <v-list-item
          v-for="(route, index) in routes"
          :key="index"
          link
        >
        <router-link exact-active-class="active" :to="{name: route.name}" tag="h1">
          <v-list-item-content> 
            <v-list-item-title class="textColor">{{ route.name }}</v-list-item-title>
          </v-list-item-content>
        </router-link>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-card>
</template>


<script>
//import MenuItem from "./MenuItem"
  export default {
    name: "Menu",
    components: {
      //MenuItem
    },
    computed: {
      routes() {
        return this.$router.options.routes
      }
    },
  }
</script>

<style scoped> 
.v-card{
  float: left;
}

.backgroundGradient {
  background: linear-gradient(220deg, #544a7d 20%, #ffd452 100%);
}

.textColor {
  color: white;
  font-size: 1rem !important;
}
</style>