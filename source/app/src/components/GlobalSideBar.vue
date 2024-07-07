<script setup>


</script>

<template>
  <div class="ly_sidebar">
    <div class="bl_sidebar d-md-block collapse">
      <div class="bl_sidebar_inner">
        <div class="bl_sidebar_item">
          <figure class="bl_slider_logo p-md-3">
            <img src="../assets/images/logo.webp" alt="">
          </figure>
          <nav class="position-sticky">
            <ul class="nav flex-column">
              <li class="nav-item">
                <router-link class="nav-link" to="/">
                  <fa class="el_sideBar_icon" icon="house"/>
                  <span class="ml-2">ナレッジ一覧</span>
                </router-link>
              </li>
              <li class="nav-item">
                <router-link class="nav-link" to="/">
                  <fa class="el_sideBar_icon" icon="address-book"/>
                  <span class="ml-2">仮</span>
                </router-link>
              </li>
              <li class="nav-item">
                <router-link class="nav-link" to="/" >
                  <fa class="el_sideBar_icon" icon="user-plus"/>
                  <span class="ml-2">仮</span>
                </router-link>
              </li>
            </ul>
          </nav>
        </div>
        <footer class="bl_sidebar_item _footer p-3">
          <a href="#" class="nav-link bl_sidebar_logout">
            <fa class="el_sideBar_icon _logout" icon="arrow-right-from-bracket"/>
            <span>サインアウト</span>
          </a>

          <div class="bl_sideCopyRight ">
            <small>&copy; 2024 炎龍 ~Fire Dragon~</small>
          </div>
        </footer>
      </div>
    </div>
  </div>
</template>


<style scoped>
.bl_sidebar_inner {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  color: #fff;
  height: 100%;
  min-height: 600px;
}

.bl_sideCopyRight {

  color:rgba(255,255,255,0.85);
}

.bl_slider_logo {
  display: flex;
  flex-direction: column;
  align-items: center;
  row-gap: 15px 0;
  min-height: 176px;
}

.bl_slider_logo:after {
  content: '';
  position: relative;
  margin-top: 15px;
  width: 80px;
  height: 0.5px;
  background-color: rgba(255,255,255, .5);
}

.bl_slider_logo > img {
  display: block;
  pointer-events: none;
  width: 100%;
  -webkit-filter: brightness(0) invert(1);
  filter: brightness(0) invert(1);
}

.bl_sidebar {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  width: 230px;
  z-index: 100;

  box-shadow: inset -1px 0 0 rgba(0, 0, 0, .1);
  background-image: linear-gradient(to bottom, #0d305e 0%, #1d6fb6 100%);
}

@media (max-width: 767.98px) {
  .bl_sidebar {
    top: 11.5rem;
    padding: 0;
  }
}

/* .bl_sideNavBar {
  box-shadow: inset 0 -1px 0 rgba(0, 0, 0, .1);
}

@media (min-width: 767.98px) {
  .bl_sideNavBar {
    top: 0;
    position: sticky;
    z-index: 999;
  }
} */

.bl_sidebar .nav-link, .bl_sidebar_logout {
  display: flex;
  align-items: baseline;
  gap: .5em;
  color: #fff;
}

/* .bl_sidebar .nav-link.active {
  color: #c1d9ff;
} */

.el_sideBar_icon {
  width: 24px;
  font-size: 1.2rem;
}
.el_sideBar_icon._logout {
  font-size: 1.4rem;
}

.bl_sidebar_item._footer {
  display: flex;
  flex-direction: column;
  gap: 24px 0;
}

</style>