package com.miraknowledge.api.service.knowledge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.object.entity.KnowledgeEntity;
import com.miraknowledge.api.object.entity.OpinionEntity;
import com.miraknowledge.api.object.response.OpinionResponse;
import com.miraknowledge.api.service.KnowledgeService;

@ExtendWith(MockitoExtension.class)
public class KnowledgeServiceCreateOpinionResponseListTest {
    @InjectMocks
    KnowledgeService knowledgeService;

    /**
     * 作成
     */
    @Test
    public void createList() {
        // 引数
        List<OpinionEntity> entities = List.of(
            OpinionEntity
                .builder()
                .id(1)
                .knowledgeEntity(KnowledgeEntity.builder().id(10).build())
                .name("name1")
                .content("content1")
                .createdAt(LocalDateTime.of(2023, 10, 12, 1, 23, 45))
                .updatedAt(LocalDateTime.of(2024, 12, 31, 23, 59, 59))
                .build(),
            OpinionEntity
                .builder()
                .id(2)
                .knowledgeEntity(KnowledgeEntity.builder().id(10).build())
                .name("name2")
                .content("content2")
                .createdAt(LocalDateTime.of(2023, 10, 12, 1, 23, 45))
                .updatedAt(null)
                .build()
        );
        // 期待値
        List<OpinionResponse> expected = List.of(
            OpinionResponse
                .builder()
                .id(1)
                .name("name1")
                .content("content1")
                .createdAt(LocalDateTime.of(2023, 10, 12, 1, 23, 45))
                .updatedAt(LocalDateTime.of(2024, 12, 31, 23, 59, 59))
                .build(),
                OpinionResponse
                .builder()
                .id(2)
                .name("name2")
                .content("content2")
                .createdAt(LocalDateTime.of(2023, 10, 12, 1, 23, 45))
                .updatedAt(null)
                .build()
        );

        // テスト
        tester(entities, expected);
    }

    /**
     * isEmpty
     */
    @Test
    public void testEmpty() {
        // 引数
        List<OpinionEntity> entities = List.of();
        // 期待値
        List<OpinionResponse> expected = List.of();

        // テスト
        tester(entities, expected);
    }

    /**
     * isNull
     */
    @Test
    public void testNull() {
        // 引数
        List<OpinionEntity> entities = null;
        // 期待値
        List<OpinionResponse> expected = List.of();

        // テスト
        tester(entities, expected);
    }

    /**
     * テスター
     * @param opinionEntityList 意見一覧
     * @param expected 期待値
     */
    @SuppressWarnings("unchecked")
    private void tester(List<OpinionEntity> opinionEntityList, List<OpinionResponse> expected) {
        try {
            Method method = createMethod();
            List<OpinionResponse> actual = (List<OpinionResponse>)method.invoke(knowledgeService, opinionEntityList);
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
        Method method = KnowledgeService.class.getDeclaredMethod("createOpinionResponseList", List.class);
        method.setAccessible(true);
        return method;
    }
}
