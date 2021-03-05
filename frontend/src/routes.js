import Vue from "vue"
import Router from "vue-router"

Vue.use(Router)

const router = new Router ({
  mode: 'history',
  routes: [
    {path: "/", redirect: {name: "Oppskrifter"}},
    /*{
      path: "/",
      name: "Home",
      component: () => import ("./components/Home"),
    },*/
    {
      path: "/recipe",
      name: "Oppskrifter",
      component: () => import ("./components/Recipe/Recipe"),
    },
    {
      path: "/list",
      name: "Handleliste",
      component: () => import ("./components/ShoppingList"),
    },
    {
      path: "/economy",
      name: "Økonomi",
      component: () => import ("./components/Economy"),
    },
    {
      path: "/courses",
      name: "Courses",
      component: () => import ("./components/ListCoursesComponent")
    },
    {
      path: "/courses/:id",
      name: "Course Details",
      component: () => import("./components/HelloWorld")
    },
    {
      path: "/login",
      //name: "Logg inn",
      component: () => import ("./authentication/Login"),
      meta: {
        //label: "Login"
      }
    },
    {
      path: "/signup",
      //name: "SignUp",
      component: () => import ("./authentication/SignUp"),
      meta: {
        //label: "SignUp"
      }
    },
  ]
})

export default router