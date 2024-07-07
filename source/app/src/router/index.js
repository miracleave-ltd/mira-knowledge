import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/',
      component: HomeView
    },

    {
      //定義外のパスをリダイレクト
      path: '/:pathMatch(.*)*',
      redirect: '/',
    },
  ]
})

export default router;