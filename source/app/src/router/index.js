import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import LoginView from '../views/LoginView.vue'
import SignUpView from '../views/SignUpView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/login',
      name: 'login',
      component: LoginView,
      meta: { title: 'ログイン', desc: 'ログインページです。' }
    },
    {
      path: '/signup',
      name: 'signup',
      component: SignUpView,
      meta: { title: 'アカウント登録', desc: 'アカウント登録ページです。' }
    },
    { path: '/',
      name: 'home',
      component: HomeView
    },
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
      path: '/:pathMatch(.*)*',
      redirect: '/',
    },
  ]
})

export default router;