<script setup>
import { ref } from "vue";
import APIclient from "../api/client";

const client = new APIclient();
const name = ref("");
const title = ref("");
const content = ref("");
const errorMessage = ref("");

const submitKnowledge = async () => {
  errorMessage.value = ""; // エラーメッセージをクリア

  const knowledge = {
    name: name.value,
    title: title.value,
    content: content.value,
  };

  try {
    const response = client.knowledge.createKnowledge(knowledge);
    console.log(response.data);
  } catch (error) {
    console.log("knowledgeの投稿に失敗しました", error);
  }
};
</script>

<template>
  <div class="ly_main p-3">
    <div class="card mt-lg-4 mt-3">
      <div class="card-body">
        <h2 class="h5 mb-4">ナレッジを新規投稿</h2>
        <form @submit.prevent="submitKnowledge">
          <div class="mb-3">
            <label for="name" class="form-label">投稿者名</label>
            <input
              type="text"
              class="form-control"
              id="name"
              v-model="name"
              required
            />
          </div>
          <div class="mb-3">
            <label for="title" class="form-label">タイトル</label>
            <input
              type="text"
              class="form-control"
              id="title"
              v-model="title"
              required
            />
          </div>
          <div class="mb-3">
            <label for="content" class="form-label">本文</label>
            <textarea
              class="form-control"
              id="content"
              v-model="content"
              rows="4"
              required
            ></textarea>
          </div>
          <button type="submit" class="btn btn-primary">投稿</button>
        </form>
        <p v-if="errorMessage" class="text-danger mt-3">{{ errorMessage }}</p>
      </div>
    </div>
  </div>
</template>

<style></style>
