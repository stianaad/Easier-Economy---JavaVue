<template>
  <v-dialog
    transition="dialog-bottom-transition"
    max-width="600"
    v-model="dialog"
  >
      <v-card>
        <v-card-text class="text-center">
          <div class="text-h2 pa-12">Logg inn</div>
          <v-text-field
            class="widthTextfield mx-auto"
            dense
            label="Brukernavn"
            prepend-inner-icon="mdi-account"/>
          <v-text-field
          class="widthTextfield mx-auto"
            dense
            label="Passord"
            prepend-inner-icon="mdi-key"/>
          <v-btn rounded light elevation="4" class="mt-5 loginButton">Logg inn</v-btn>
          <div class="text-h6 mt-5 mb-5 text-center">Eller logg inn med</div>
          <v-btn fab elevation="3" @click="socialLogin" class="mr-10">
            <img alt="Google logo" src="../assets/google.png" width="40" height="40" >
          </v-btn>
          <v-btn fab elevation="3" @click="facebookLogin" >
            <img alt="Google logo" src="../assets/facebook.png" width="70" height="50" >
          </v-btn>
        </v-card-text>
        <v-card-actions class="justify-end">
          <v-btn
            text
            @click="dialog = false">Close</v-btn>
        </v-card-actions>
      </v-card>
  </v-dialog>
</template>

<script>
import firebase from 'firebase'
export default {
  name: "login",
  data(){
    return {
      email: "",
      password: "",
      dialog: true,
    }
  },
  methods: {
    login() {
      firebase.auth().signInWithEmailAndPassword(this.email, this.password).then(
        () => {
          this.$router.replace("recipe")
        },
        (err) => {
          alert("OOPS" + err.message)
        }
      )
    },
    socialLogin() {
      const provider = new firebase.auth.GoogleAuthProvider();

      firebase.auth().signInWithPopup(provider).then( () => {
        this.$router.replace("/recipe");
      }).catch(err => {
        alert("OPPPS" + err.message);
      })
    },
    facebookLogin(){
      var provider = new firebase.auth.FacebookAuthProvider();

      firebase
      .auth()
      .signInWithPopup(provider)
      .then( () => {
        this.$router.replace("/recipe");
      })
      .catch((error) => {
        alert("error" + error.message)
      });
    }
  }
}
/**
 * <template>
  <div class="login">
    <h3>Sign in</h3>
    <input v-model="email" type="text" placeholder="Email"><br>
    <input v-model="password" type="password" placeholder="Password"><br>
    <button @click="login">Login</button>
    <p>
      Or sign in with Google <br>
      <button @click="socialLogin" class="social-button">
        GOOOGLE
      </button>
      <button @click="facebookLogin" class="social-button">
        FACEBOOK
      </button>
    </p>
    <p>Create account here</p>
  </div>
</template>
 */
</script>

<style scoped>
  .widthTextfield {
    max-width: 400px;
  }
  .dialogColor {
    color: white;
  }
  .loginButton {
    background: linear-gradient(40deg, #0384ac 10%, #50A7C2 50%, #B7F8DB 90%);
    width: 100%;
    max-width: 400px;
    color: white;
  }
  .login {
    margin-top: 40px;
  }
  input {
    margin: 10px 0;
    width: 20%;
    padding: 15px;
  }
  p {
    margin-top: 40px;
    font-size: 13px;
  }
  p a {
    text-decoration: underline;
    cursor: pointer;
  }
</style>