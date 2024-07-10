<script setup>
import GlobalHeader from './components/GlobalHeader.vue'
import GlobalSideBar from './components/GlobalSideBar.vue'

import { useShowComponentsStore } from './stores/showComponents.js'

// ログイン時コンポーネントの表示制御
const isSignIn = useShowComponentsStore()

</script>

<template>
  <main :class="{ly_mainContent:isSignIn.state}">
    <GlobalHeader v-show="isSignIn.state"/>
    <router-view></router-view>
  </main>
  <GlobalSideBar v-show="isSignIn.state"/>
  
</template>

<style>
@media screen and (768px <= width){
  .ly_mainContent {
    margin-left: 230px;
  }
}

/* ログイン画面用css設定 */
body:is(.bg_login, .bg_signup) {
  display: flex;
  align-items: center;
  justify-content: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f6f8fa !important;
  height: 100vh;
  text-align: center;
}

</style>
