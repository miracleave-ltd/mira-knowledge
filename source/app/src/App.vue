<script setup>
import GlobalHeader from './components/GlobalHeader.vue'
import GlobalSideBar from './components/GlobalSideBar.vue'
</script>

<template>
  <main class="ly_mainContent">
    <GlobalHeader/>
    <router-view></router-view>
  </main>
  <GlobalSideBar/>
  
</template>

<style scoped>
@media screen and (768px <= width){
  .ly_mainContent {
    margin-left: 230px;
  }
}

</style>
