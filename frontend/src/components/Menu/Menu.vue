<template>
  <v-card
    width="256"
    class="mx-auto"
    height="100%"
  >
    <v-navigation-drawer permanent light class="backgroundGradient">
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
    data () {
      return {
        items: [
          { title: 'Oppskrifter', icon: 'mdi-view-dashboard' },
          { title: 'Handleliste', icon: 'mdi-image' },
          { title: 'Økonmi', icon: 'mdi-help-box' },
          { title: 'Logg inn', icon: 'mdi-help-box' },
        ],
        right: null,
      }
    },
  }
</script>

<style>
.v-card{
  float: left;
}

.backgroundGradient {
  background: linear-gradient(120deg, #50A18A 30%, #1D7F9D 90%);
}

.textColor {
  color: white;
  font-size: 1rem !important;
}
</style>