<template>
  <v-dialog
    transition="dialog-bottom-transition"
    max-width="600"
    v-model="dialog"
  >
      <v-card>
        <v-card-text class="text-center">
          <div class="text-h2 pa-12">Opprett bruker</div>
          <div class="widthTextfield mx-auto">
            <v-text-field
              v-model="email"
              dense
              label="E-post"
              prepend-inner-icon="mdi-account"/>
            <v-text-field
              v-model="password"
              type="password"
              dense
              label="Passord"
              prepend-inner-icon="mdi-key"/>
            <v-text-field
              v-model="repeatPassword"
              type="password"
              dense
              label="Gjenta passord"
              prepend-inner-icon="mdi-key"/>
          </div>
          <v-btn rounded light elevation="4" class="mt-5 loginButton" @click="signUp">Opprett bruker</v-btn>
          <div class="text-subtitle-1 mt-5 text-center"> 
            Allerede bruker? Logg inn <span class="link" @click="showLogin">her</span>
          </div>
        </v-card-text>
        <v-card-actions class="justify-end">
          <v-btn
            text
            @click="dialog = false">Lukk</v-btn>
        </v-card-actions>
      </v-card>
  </v-dialog>
</template>

<script>
/**
 * <div class="sign-up">
    <p>Create account</p>
    <input v-model="email" type="text" placeholder="Email"><br>
    <input v-model="password" type="password" placeholder="Password"><br>
    <button @click="signUp">Sign up</button>
    <span> Or go back to <router-link to="/login">login</router-link> </span>
  </div>
 */
import firebase from 'firebase';
export default {
  name: "signUp",
  data(){
    return{
      email: '',
      password: '',
      repeatPassword: '',
      dialog: true
    }
  },
  methods: {
    showLogin() {
      this.$store.commit("setClickedLogin", true)
      this.$store.commit("setClickedSignUp", false)
    },
    signUp() {
      if(this.repeatPassword === this.password){
        firebase.auth().createUserWithEmailAndPassword(this.email, this.password).then(
          () => {
            this.$store.commit("setLogin", "Logg ut")
            this.$store.commit("setPath", "logout")
            this.$store.commit("setClickedSignUp", false)
          },
          (err) => {
            alert("error" + err.message)
          }
        )
      } else {
        alert("Passord må være like!")
      }
    }
  }
}
</script>

<style scoped>
  .loginButton {
    background: linear-gradient(40deg, #0384ac 10%, #50A7C2 50%, #B7F8DB 90%);
    width: 100%;
    max-width: 400px;
    color: white;
  }
  .widthTextfield {
    max-width: 400px;
  }
  .signUp {
    margin-top: 40px;
  }
  input {
    margin: 10px 0;
    width: 20%;
    padding: 15px;
  }
  .link {
    color: rgb(77, 77, 255);
    text-decoration: underline;
    cursor: pointer;
  }
</style>