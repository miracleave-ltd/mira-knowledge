export const knowledge = (client) => {
  const getAllKnowledges = async () => {
    return await client.get("/api/knowledge");
  };
  const getKnowledge = async (id) => {
    return await client.get(`/api/knowledge/${id}`);
  };
  const createKnowledgeOpinion = async (id, data) => {
    return await client.post(`/api/knowledge/${id}/opinions`, data);
  };
  const createKnowledge = async (data) => {
    return await client.post("/api/knowledge", data);
  };
  return {
    getAllKnowledges,
    getKnowledge,
    createKnowledgeOpinion,
    createKnowledge,
  };
};
