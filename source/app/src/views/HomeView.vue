<template>
  <div class="ly_main p-3">
    <div class="accordion" id="accordionSearch">
      <div class="accordion-item">
        <h2 class="accordion-header" id="headingOne">
          <button
            class="accordion-button collapsed"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#collapseTwo"
            aria-expanded="false"
            aria-controls="collapseTwo"
          >
            <span class="h5 mb-0">
              <fa icon="magnifying-glass" class="me-2" />詳細な条件で検索
            </span>
          </button>
        </h2>
        <div
          id="collapseTwo"
          class="accordion-collapse collapse"
          aria-labelledby="headingOne"
          data-bs-parent="#accordionSearch"
        >
          <div class="accordion-body">
            <form>
              <div class="row">
                <div class="col-lg-6 mb-3">
                  <label for="searchTag" class="form-label">タグ検索</label>
                  <input
                    type="text"
                    class="form-control"
                    id="searchTag"
                    placeholder="検索したいタグを入力してください"
                  />
                </div>
                <div class="col-lg-6 mb-3">
                  <label for="searchWord" class="form-label">ワード検索</label>
                  <input
                    type="text"
                    class="form-control"
                    id="searchWord"
                    placeholder="検索したいワードを入力してください"
                  />
                </div>
              </div>
              <button type="submit" class="btn btn-primary btn-block mb-4">
                検索
              </button>
            </form>
          </div>
        </div>
      </div>

      <div
        v-for="knowledge in knowledges"
        :key="knowledge.id"
        class="card mt-lg-4 mt-3"
        @click="goToDetail(knowledge.id)"
      >
        <div class="card-body">
          <div class="d-flex flex-column">
            <div class="d-flex align-items-center align-self-end gap-3">
              <div class="d-flex gap-2">
                <button
                  type="button"
                  class="btn btn-sm btn-outline-primary"
                  v-for="tag in knowledge.tags"
                  :key="tag"
                >
                  {{ tag }}
                </button>
              </div>
              <div
                class="d-flex align-items-center"
                v-if="knowledge.author && knowledge.author.avatarUrl"
              >
                <img
                  :src="knowledge.author.avatarUrl"
                  class="rounded-circle border border-primary"
                  alt="アカウントアイコン"
                />
              </div>
            </div>
            <h3 class="card-title pt-3">{{ knowledge.title }}</h3>
            <p class="card-text pt-3">{{ knowledge.content }}</p>
            <p class="pt-3">{{ knowledge.name }}</p>
            <div class="pt-3 align-self-end">
              <button type="button" class="btn btn-sm me-2">いいね</button>
              <button type="button" class="btn btn-sm">コメント</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import APIclient from "../api/client";
import { useRouter } from "vue-router";

const client = new APIclient();
const knowledges = ref([]);
const router = useRouter();

onMounted(async () => {
  try {
    const response = await client.knowledge.getAllKnowledges();
    knowledges.value = response;
    console.log(response);
  } catch (error) {
    console.error("ナレッジ情報の取得に失敗しました", error);
  }
});

const goToDetail = (knowledgeId) => {
  router.push({ name: "detail", params: { id: knowledgeId } });
};
</script>

<style scoped></style>
