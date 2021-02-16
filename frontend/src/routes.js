import Vue from "vue"
import Router from "vue-router"

Vue.use(Router)

const router = new Router ({
  mode: 'history',
  routes: [
    {path: "/", redirect: {name: "Recipe"}},
    /*{
      path: "/",
      name: "Home",
      component: () => import ("./components/Home"),
    },*/
    {
      path: "/recipe",
      name: "Recipe",
      component: () => import ("./components/Recipe/Recipe"),
      meta: {
        label: "Recipe"
      }
    },
    {
      path: "/list",
      name: "ShoppingList",
      component: () => import ("./components/ShoppingList"),
      meta: {
        label: "ShoppingList"
      }
    },
    {
      path: "/economy",
      name: "Economy",
      component: () => import ("./components/Economy"),
      meta: {
        label: "Economy"
      }
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
      name: "Login",
      component: () => import ("./authentication/Login"),
      meta: {
        label: "Login"
      }
    },
    {
      path: "/signup",
      name: "SignUp",
      component: () => import ("./authentication/SignUp"),
      meta: {
        label: "SignUp"
      }
    },
  ]
})

export default router