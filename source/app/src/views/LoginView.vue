<script setup>
import { ref, onMounted, onBeforeUnmount } from 'vue'
import { useShowComponentsStore } from '../stores/showComponents.js'
// ストアオブジェクトを取得
const isShow = useShowComponentsStore()

// コンポーネント表示非表示制御
onBeforeUnmount(() => {
  document.body.className = '';
  isShow.state = true
})

onMounted(() => {
  document.body.className = 'bg_login';
  isShow.state = false
});

</script>

<template>
  <div class="form-signin">
    <!-- 入力フォーム -->
    <form method="POST">
      <img class="mb-4" src="../assets/images/logo.webp" alt="mria-knowledgeロゴ" width="150" height="97.5">
      <h1 class="h3 mb-4 fw-normal">Welcome</h1>

      <!-- ユーザー名 -->
      <div class="form-floating">
        <input
          v-model="loginInfo"
          type="text"
          class="form-control email"
          id="floatingEmail"
          placeholder="Username"
          autocomplete="off"
        >
        <label for="floatingEmail">Username</label>
      </div>
      <!-- パスワード -->
      <div class="form-floating mb-4">
        <input
          v-model="password"
          type="password"
          class="form-control"
          id="floatingPassword"
          placeholder="Password"
        >
        <label for="floatingPassword">Password</label>
      </div>

      <button
        class="w-100 btn btn-lg btn-primary"
        type="submit"
        @click.prevent="submitLogin"
      >
        <fa class="me-2" icon="arrow-right-to-bracket"/>
        <span>Sign in</span>
      </button>

      <!-- デバッグ -->
      <!-- <div class="mt-4">
        <pre>
email: {{ email }}
password: {{ password }}
authStore: {{ authStore }}
messageStore: {{ messageStore }}
        </pre>
      </div> -->

      <!-- アカウント登録へのリンク -->
      <div class="mt-4">
        <router-link to="/signup" class="">アカウントの作成はこちら</router-link>
      </div>
      <!-- パスワードの再設定 -->
      <div class="mt-2">
        <router-link to="/password-reset" class="">パスワードの再設定</router-link>
      </div>
      <p class="mt-4 mb-3 text-muted">&copy; 2024 炎龍 ~Fire Dragon~</p>
    </form>
  </div>

</template>

<style scoped>
.form-signin {
  padding: 15px;
  margin: auto;
  width: 100%;
  min-width: 330px;
}

.form-signin .checkbox {
  font-weight: 400;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="text"].email {
  margin-bottom: -2px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

.bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
}

@media (min-width: 768px) {
  .bd-placeholder-img-lg {
    font-size: 3.5rem;
  }
}

</style>