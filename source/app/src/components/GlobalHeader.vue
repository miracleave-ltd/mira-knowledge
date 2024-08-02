<script setup></script>

<template>
  <header class="ly_header">
    <nav class="navbar navbar-light p-3">
      <div
        class="d-flex col-12 col-md-8 col-lg-8 mb-lg-0 flex-wrap flex-md-nowrap justify-content-between"
      >
        <!-- <h1 class="h3 mb-0"></h1> -->
        <button
          class="navbar-toggler d-md-none collapsed mb-3"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div
          class="collapse d-md-none navbar-collapse"
          id="navbarSupportedContent"
        >
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <router-link class="nav-link" to="/">
                <span>ダッシュボード</span>
              </router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/">
                <span>モック</span>
              </router-link>
            </li>
            <li class="nav-item">
              <router-link class="nav-link" to="/">
                <span>モック</span>
              </router-link>
            </li>
          </ul>
        </div>
      </div>

      <div
        class="col-12 col-md-4 col-lg-4 d-flex align-items-center justify-content-md-end mt-3 mt-md-0"
      >
        <div class="dropdown">
          <img
            src="https://dummyimage.com/35x35/fff/000"
            class="rounded-circle border border-primary"
            alt="アカウントアイコン"
          />
          <button
            class="btn dropdown-toggle"
            type="button"
            id="dropdownMenuButton1"
            data-bs-toggle="dropdown"
            aria-expanded="false"
          >
            アカウント名
          </button>
          <ul
            class="dropdown-menu dropdown-menu-md-end dropdown-menu-lg-end"
            aria-labelledby="dropdownMenuButton1"
          >
            <li>
              <router-link class="dropdown-item" to="/user-profile"
                >アカウント詳細</router-link
              >
            </li>
            <li>
              <a class="dropdown-item" href="login">サインアウト</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </header>
</template>

<style scoped>
.ly_header {
  background-color: #fff;
  box-shadow: 0 0 0.5em rgba(0, 0, 0, 0.1);
}
</style>
