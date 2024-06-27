package com.miraknowledge.api.service.opinion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.object.entity.KnowledgeEntity;
import com.miraknowledge.api.object.entity.OpinionEntity;
import com.miraknowledge.api.object.request.OpinionCreateRequest;
import com.miraknowledge.api.repository.KnowledgeRepository;
import com.miraknowledge.api.repository.OpinionRepository;
import com.miraknowledge.api.service.OpinionService;

@ExtendWith(MockitoExtension.class)
public class OpinionServiceCreateOpinionEntityTest {
    @InjectMocks
    OpinionService opinionService;
    @Mock
    KnowledgeRepository knowledgeRepository;
    @Mock
    OpinionRepository opinionRepository;

    /**
     * 作成
     */
    @Test
    public void testCreate() {
        // 引数
        OpinionCreateRequest opinionCreateRequest = OpinionCreateRequest
            .builder()
            .knowledgeId(10)
            .name("name1")
            .content("content1")
            .build();
        KnowledgeEntity knowledgeEntity = KnowledgeEntity
            .builder()
            .id(10)
            .build();
        LocalDateTime createdAt = LocalDateTime.now();
        // 期待値
        OpinionEntity expected = OpinionEntity
            .builder()
            .id(null)
            .knowledgeEntity(knowledgeEntity)
            .name("name1")
            .content("content1")
            .createdAt(createdAt)
            .updatedAt(null)
            .build();

        // テスト
        tester(opinionCreateRequest, knowledgeEntity, createdAt, expected);
    }
    
    /**
     * isNull
     */
    @Test
    public void testNullOpinionCreateRequest() {
        // 引数
        OpinionCreateRequest opinionCreateRequest = null;
        KnowledgeEntity knowledgeEntity = KnowledgeEntity
            .builder()
            .id(10)
            .build();
        LocalDateTime createdAt = LocalDateTime.now();
        // 期待値
        OpinionEntity expected = null;

        // テスト
        tester(opinionCreateRequest, knowledgeEntity, createdAt, expected);
    }
    
    /**
     * isNull
     */
    @Test
    public void testNullKnowledgeEntity() {
        // 引数
        OpinionCreateRequest opinionCreateRequest = OpinionCreateRequest
            .builder()
            .knowledgeId(10)
            .name("name1")
            .content("content1")
            .build();
        KnowledgeEntity knowledgeEntity = null;
        LocalDateTime createdAt = LocalDateTime.now();
        // 期待値
        OpinionEntity expected = null;

        // テスト
        tester(opinionCreateRequest, knowledgeEntity, createdAt, expected);
    }

    /**
     * isNull
     */
    @Test
    public void testNullCreatedAt() {
        // 引数
        OpinionCreateRequest opinionCreateRequest = OpinionCreateRequest
            .builder()
            .knowledgeId(10)
            .name("name1")
            .content("content1")
            .build();
        KnowledgeEntity knowledgeEntity = KnowledgeEntity
            .builder()
            .id(10)
            .build();
        LocalDateTime createdAt = null;
        // 期待値
        OpinionEntity expected = null;

        // テスト
        tester(opinionCreateRequest, knowledgeEntity, createdAt, expected);
    }

    /**
     * テスター
     * @param opinionCreateRequest 意見新規作成 リクエスト
     * @param knowledgeEntity ナレッジ
     * @param createdAt 作成日時
     * @param expected 期待値
     */
    private void tester(OpinionCreateRequest opinionCreateRequest, KnowledgeEntity knowledgeEntity, LocalDateTime createdAt, OpinionEntity expected) {
        try {
            Method method = createMethod();
            OpinionEntity actual = (OpinionEntity)method.invoke(opinionService, opinionCreateRequest, knowledgeEntity, createdAt);
            assertEquals(expected, actual);
            
        } catch (Exception ex) {
            fail(ex);
        }
    }

    /**
     * テストメソッド作成
     * @return テストメソッド
     * @throws NoSuchMethodException 例外
     */
    private Method createMethod() throws NoSuchMethodException {
        Method method = OpinionService.class.getDeclaredMethod("createOpinionEntity", OpinionCreateRequest.class, KnowledgeEntity.class, LocalDateTime.class);
        method.setAccessible(true);
        return method;
    }
}
