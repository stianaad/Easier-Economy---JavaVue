import Vue from 'vue'
import App from './App.vue'
import router from "./routes"
import vuetify from './plugins/vuetify';
import firebase from 'firebase';
import Vuex from 'vuex'

Vue.config.productionTip = false

var firebaseConfig = {
  apiKey: "AIzaSyBByFrYg7g8twwmpA1krQKU5HJbM3qWNDU",
  authDomain: "easiereconomy.firebaseapp.com",
  databaseURL: "https://easiereconomy-default-rtdb.europe-west1.firebasedatabase.app",
  projectId: "easiereconomy",
  storageBucket: "easiereconomy.appspot.com",
  messagingSenderId: "212253441431",
  appId: "1:212253441431:web:87996c8e2ce99074b018d2",
  measurementId: "G-BLXMR1P3NV"
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);
firebase.analytics();
Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    login: "Logg inn",
    path: "login",
    clickedLogin: false,
    clickedSignUp: false
  },
  mutations: {
    setLogin (state, login) {
      state.login = login
    },
    setPath(state, path){
      state.path = path;
    },
    setClickedLogin(state, clickedLogin) {
      state.clickedLogin = clickedLogin
    },
    setClickedSignUp(state, clickedSignUp) {
      state.clickedSignUp = clickedSignUp
    }
  }
})

new Vue({
  store,
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')
