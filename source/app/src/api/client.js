import axios from "axios";
import { knowledge } from "./knowledge";

const instance = axios.create({
  baseURL: process.env.VUE_APP_BASE_URL || "http://localhost:8080",
  headers: {},
});

class APIclient {
  /* 
ユーザ認証やtokenの制御もこのクラス内に追記していく
*/

  constructor() {
    // フィールドにAPIコールを持たせる
    this.knowledge = knowledge(this);
  }
  async get(url) {
    try {
      const response = await instance.get(url);
      return response.data;
    } catch (e) {
      console.error("GETリクエストに失敗しました", e);
      throw e;
    }
  }
  async post(url, data) {
    try {
      const response = await instance.post(url, data);
      return response.data;
    } catch (e) {
      console.error("POSTリクエストに失敗しました", e);
      throw e;
    }
  }
}

export default APIclient;

/*
使い方

import APIclient from "@/api/client";
const client = new APIclient();

const fetchfunc = async () => {
  try {
    const response = await client.get.getAllKnowledge;
    ref.value = response;
  } catch (error) {
    console.error("knowledge一覧の取得に失敗しました", error);
  }
};




*/
