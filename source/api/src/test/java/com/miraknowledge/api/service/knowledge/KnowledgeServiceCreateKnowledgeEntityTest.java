package com.miraknowledge.api.service.knowledge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.object.entity.KnowledgeEntity;
import com.miraknowledge.api.object.request.KnowledgeCreateRequest;
import com.miraknowledge.api.service.KnowledgeService;

@ExtendWith(MockitoExtension.class)
public class KnowledgeServiceCreateKnowledgeEntityTest {
    @InjectMocks
    KnowledgeService knowledgeService;

    /**
     * 作成
     */
    @Test
    public void create() {
        // 引数
        KnowledgeCreateRequest knowledgeCreateRequest = KnowledgeCreateRequest
            .builder()
            .name("name1")
            .title("title1")
            .content("content1")
            .build();
        LocalDateTime createdAt = LocalDateTime.now();
        // 期待値
        KnowledgeEntity expected = KnowledgeEntity
            .builder()
            .id(null)
            .name("name1")
            .title("title1")
            .content("content1")
            .createdAt(createdAt)
            .updatedAt(null)
            .build();

        // テスト
        tester(knowledgeCreateRequest, createdAt, expected);
    }

    /**
     * isNull
     */
    @Test
    public void testNullKnowledgeCreateRequest() {
        // 引数
        KnowledgeCreateRequest knowledgeCreateRequest = null;
        LocalDateTime createdAt = LocalDateTime.now();
        // 期待値
        KnowledgeEntity expected = null;

        // テスト
        tester(knowledgeCreateRequest, createdAt, expected);
    }

    /**
     * isNull
     */
    @Test
    public void testNullCreatedAt() {
        // 引数
        KnowledgeCreateRequest knowledgeCreateRequest = KnowledgeCreateRequest
            .builder()
            .name("name1")
            .title("title1")
            .content("content1")
            .build();
        LocalDateTime createdAt = null;
        // 期待値
        KnowledgeEntity expected = null;

        // テスト
        tester(knowledgeCreateRequest, createdAt, expected);
    }

    /**
     * テスター
     * @param knowledgeCreateRequest ナレッジ新規作成 リクエスト
     * @param createdAt 作成日時
     * @param expected 期待値
     */
    private void tester(
        KnowledgeCreateRequest knowledgeCreateRequest,
        LocalDateTime createdAt,
        KnowledgeEntity expected) {
        try {
            Method method = createMethod();
            KnowledgeEntity actual = (KnowledgeEntity)method.invoke(knowledgeService, knowledgeCreateRequest, createdAt);
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
        Method method = KnowledgeService.class.getDeclaredMethod("createKnowledgeEntity", KnowledgeCreateRequest.class, LocalDateTime.class);
        method.setAccessible(true);
        return method;
    }
}
