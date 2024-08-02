import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import LoginView from "../views/LoginView.vue";
import SignUpView from "../views/SignUpView.vue";
import Registration from "../views/Registration.vue";
import DetailView from "../views/DetailView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/login",
      name: "login",
      component: LoginView,
      meta: { title: "ログイン", desc: "ログインページです。" },
    },
    {
      path: "/signup",
      name: "signup",
      component: SignUpView,
      meta: { title: "アカウント登録", desc: "アカウント登録ページです。" },
    },
    { path: "/", name: "home", component: HomeView },
    { path: "/registration", name: "registration", component: Registration },
    { path: "/detail/:id", name: "detail", component: DetailView, props: true },
    // { path: '/articleRegister',
    //   name: 'articleRegister',
    //   component: HomeView
    // },
    // { path: '/opinionRegister',
    //   name: opinionRegister,
    //   component: HomeView
    // },

    {
      //定義外のパスをリダイレクト
      path: "/:pathMatch(.*)*",
      redirect: "/",
    },
  ],
});

export default router;
