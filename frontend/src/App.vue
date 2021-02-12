<template>
  <v-app>
    <div class="mainLayout">
      <Menu v-if="windowHeight>500" class="mainLayout"/>
      <router-view v-if="windowHeight>500" class="marginAllElements" />
      <v-card
      v-if="windowHeight<=500"
    class="mx-auto overflow-hidden"
    height="100%"
    width="100%"
  >
    <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>

    <v-navigation-drawer
      v-model="drawer"
      absolute
      bottom
      temporary
    >
      <v-list
        nav
        dense
      >
        <v-list-item-group
          v-model="group"
          active-class="deep-purple--text text--accent-4"
        >
          <v-list-item>
            <v-list-item-title>Foo</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Bar</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Fizz</v-list-item-title>
          </v-list-item>

          <v-list-item>
            <v-list-item-title>Buzz</v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
     <router-view class="marginAllElements" />
  </v-card>
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
  data() {
    return {
      windowHeight: window.innerWidth,
      txt: '',
      drawer: false,
      group: null
    }
  },
  watch: {
    windowHeight(newHeight, oldHeight) {
    this.txt = `it changed to ${newHeight} from ${oldHeight}`;
    },
    group() {
      this.drawer = false
    }
  },

  mounted() {
    this.$nextTick(() => {
      window.addEventListener('resize', this.onResize);
    })
  },

  beforeDestroy() { 
    window.removeEventListener('resize', this.onResize); 
  },

  methods: {  
    onResize() {
      this.windowHeight = window.innerWidth
    },
    showMenu (){
      if(this.windowHeight < 400){
        //this.drawer = !this.drawer
      }
    }
  }
};
</script>

<style scoped>

html, 
body {
  height: 100%;
  width: 100%;
}

.mainLayout {
  height: 100% !important;
}
@media screen and (max-width: 500px) {
  .marginAllElements {
    margin-left: 0px;
  }
}

@media screen and (min-width: 501px) {
  .marginAllElements {
    margin-left: 256px;
  }
}

</style>
