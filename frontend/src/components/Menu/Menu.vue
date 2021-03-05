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
      <v-divider class="mb-10"/>
      <v-list dense nav>
        <v-list-item v-for="(route, index) in routes" :key="index" link>
          <router-link exact-active-class="active" :to="{name: route.name}" tag="h1">
            <v-list-item-content> 
              <v-list-item-title class="textColor">{{ route.name }}</v-list-item-title>
            </v-list-item-content>
          </router-link>
        </v-list-item>
        <v-list-item v-if="path=='login'" link @click="showLoginDialog">
            <v-list-item-content> 
              <v-list-item-title class="textColor">{{ login }}</v-list-item-title>
            </v-list-item-content>
        </v-list-item>
        <v-list-item v-if="path=='logout'" link @click="logout">
          <v-list-item-content>
            <v-list-item-title class="textColor">{{login}}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <Login v-if="clickedLogin"/>
    <SignUp v-if="clickedSignUp"/>
  </v-card>
</template>


<script>
import firebase from 'firebase'
import Login from '../../authentication/Login'
import SignUp from '../../authentication/SignUp'
  export default {
    name: "Menu",
    components: {
      Login,
      SignUp
    },
    methods: {
      logout() {
        firebase.auth().signOut().then(() => {
          console.log(firebase.auth().currentUser)
          //this.$router.replace("")
          this.$store.commit("setLogin", "Logg inn")
          this.$store.commit("setPath", "login")
        })
      },
      showLoginDialog(){
        this.$store.commit("setClickedLogin", true)
      }
    },
    computed: {
      routes() {
        return this.$router.options.routes.filter(i => i.name !== undefined)
      },
      login() {
        return this.$store.state.login
      },
      path() {
        return this.$store.state.path
      },
      clickedLogin() {
        return this.$store.state.clickedLogin
      },
      clickedSignUp() {
        return this.$store.state.clickedSignUp
      },
    },
  }
</script>

<style scoped> 
.v-card{
  float: left;
}

.backgroundGradient {
  background: linear-gradient(220deg, #0384ac 10%, #50A7C2 50%, #B7F8DB 90%);
}

.textColor {
  color: white;
  font-size: 1rem !important;
}
.logout {
  cursor: pointer;
}
</style>