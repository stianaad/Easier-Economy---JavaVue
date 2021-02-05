<template>
  <v-app>
    <v-container class="pa-0 ma-0 align-stretch mainLayout">
      <v-row class="mainLayout full-height align-stretch" dense="true">
        <v-col md="3" lg="3" class="menu mainLayout">
          <Menu/>
        </v-col>
        <v-col md="9" lg="9">
          <router-view/>
        </v-col>
      </v-row>
    </v-container>
    <div >
      
    </div>
    <div >
      
    </div>
  </v-app>
</template>

<script>
import Menu from './components/Menu/Menu';


export default {
  name: 'App',

  components: {
    Menu,
  },

  data: () => ({
    //
  }),
};
</script>

<style>
.menu {
  float: left;
}

.mainLayout {
  height: 100% !important;
}

.row {
  height: 100%;
  margin: 10px;
}
</style>