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
  document.body.className = 'bg_signup';
  isShow.state = false
});


</script>

<template>
  <div class="form-signin">
    <img class="mb-4" src="../assets/images/logo.webp" alt="mira-knowledgeロゴ" width="150" height="97.5">
    <h1 class="h3 mb-4 fw-normal">新規登録</h1>
    <!-- <div v-show="isSubmitState">
      <p>メールアドレスにメールを送信しました</p>
    </div> -->
    <form>
      <!-- ユーザー名 -->
      <div class="form-floating">
        <input
          type="text"
          class="form-control username"
          id="floatingUsername"
          placeholder="Username"
          autocomplete="off"
        >
        <label for="floatingUsername">Username</label>
      </div>
      <!-- メールアドレス -->
      <div class="form-floating">
        <input
          type="email"
          class="form-control center"
          id="floatingEmail"
          placeholder="Email"
          autocomplete="off"
        >
        <label for="floatingEmail">Email</label>
      </div>
      <!-- メールアドレス -->
      <div class="form-floating">
        <input
          type="password"
          class="form-control center"
          id="floatingPassword1"
          placeholder="Password"
          autocomplete="off"
        >
        <label for="floatingPassword1">Password</label>
      </div>
      <!-- パスワード -->
      <div class="form-floating mb-4">
        <input
          type="password"
          class="form-control bottom"
          id="floatingPassword2"
          placeholder="Password (Repeat)"
        >
        <label for="floatingPassword2">Password (Repeat)</label>
      </div>
      <!-- <div 
        class="text-start"
        v-for="error of v$.$errors"
        :key="error.$uid"
      >
        <p class="el_inputError">{{ error.$message }}</p>
      </div>
      <div v-show="!isSameAsPassword" class="text-start">
        <p class="el_inputError">入力パスワードが一致していません</p>
      </div>
      <div v-show="messages" class="el_inputError text-start mb-4">
        <p v-if="messages.username">
          <span class="d-inline-block">{{ messages.username[0] }}</span>
        </p>
        <p v-if="messages.email">
          <span class="d-inline-block">{{ messages.email[0] }}</span>
        </p>
      </div> -->
      <button
        class="w-100 btn btn-lg btn-primary"
        type="button"
        @click.prevent=""
      >アカウント登録</button>
    </form>
    <div class="mt-4">
      <router-link to="/resend-email" class="">認証メールの再送信はこちら</router-link>
    </div>
    <div class="mt-2">
      <router-link to="/login" class="">サインインはこちら</router-link>
    </div>
    <p class="mt-4 mb-3 text-muted">&copy; 2024 炎龍 ~Fire Dragon~</p>
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

.form-signin input[type="text"].username {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin .center {
  margin: -1px 0;
  border-radius: 0;
}

.form-signin input[type="password"].bottom {
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