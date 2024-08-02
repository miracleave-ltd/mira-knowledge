<template>
  <div class="ly_main p-3">
    <div class="card mt-lg-4 mt-3">
      <div class="card-body">
        <h2 class="h5 mb-4">{{ knowledge.title }}</h2>
        <div class="d-flex flex-column">
          <div class="d-flex gap-2 mb-3">
            <button
              type="button"
              class="btn btn-sm btn-outline-primary"
              v-for="tag in knowledge.tags"
              :key="tag"
            >
              {{ tag }}
            </button>
          </div>
          <div class="mb-3">
            <p class="mb-1">投稿者: {{ knowledge.name }}</p>
            <p class="mb-1">作成日時: {{ knowledge.created_at }}</p>
            <p>更新日時: {{ knowledge.updated_at }}</p>
          </div>
          <p class="card-text pt-3">{{ knowledge.content }}</p>
          <div class="d-flex align-items-center align-self-end gap-3">
            <div
              class="d-flex align-items-center"
              v-if="knowledge.author && knowledge.author.avatarUrl"
            >
              <img
                :src="knowledge.author.avatarUrl"
                class="rounded-circle border border-primary me-2"
                alt="アカウントアイコン"
              />
            </div>
          </div>
          <div class="pt-3 align-self-end">
            <button type="button" class="btn btn-sm me-2">いいね</button>
            <button type="button" class="btn btn-sm">コメント</button>
          </div>
        </div>
      </div>
    </div>
    <div class="card mt-4">
      <div class="card-body">
        <h3 class="h6 mb-4">コメント一覧</h3>
        <ul class="list-group list-group-flush">
          <li
            class="list-group-item"
            v-for="opinion in opinions"
            :key="opinion.id"
          >
            <p>
              <strong>{{ opinion.name }}</strong> ({{ opinion.created_at }}):
            </p>
            <p>{{ opinion.content }}</p>
          </li>
        </ul>
      </div>
    </div>
    <div class="card mt-4">
      <div class="card-body">
        <h3 class="h6 mb-4">コメントを追加</h3>
        <form @submit.prevent="">
          <div class="mb-3">
            <label for="opinionName" class="form-label">名前</label>
            <input
              type="text"
              class="form-control"
              id="opinionName"
              v-model="newOpinion.name"
              required
            />
          </div>
          <div class="mb-3">
            <label for="opinionContent" class="form-label">コメント</label>
            <textarea
              class="form-control"
              id="opinionContent"
              v-model="newOpinion.content"
              required
            ></textarea>
          </div>
          <button type="submit" class="btn btn-primary">送信</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import APIclient from "../api/client";
import { useRoute } from "vue-router";

const client = new APIclient();
const knowledge = ref({});
const newOpinion = ref({ name: "", content: "" });
const route = useRoute();

const loadKnowledge = async () => {
  try {
    const knowledgeId = route.params.id;
    const response = await client.knowledge.getKnowledge(knowledgeId);
    knowledge.value = response;
  } catch (error) {
    console.error("ナレッジ情報の取得に失敗しました", error);
  }
};

onMounted(() => {
  loadKnowledge();
});
</script>

<style scoped></style>
