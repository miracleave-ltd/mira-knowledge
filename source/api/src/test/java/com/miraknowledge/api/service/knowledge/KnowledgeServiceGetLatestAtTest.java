package com.miraknowledge.api.service.knowledge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.object.entity.KnowledgeEntity;
import com.miraknowledge.api.service.KnowledgeService;

@ExtendWith(MockitoExtension.class)
public class KnowledgeServiceGetLatestAtTest {
    @InjectMocks
    KnowledgeService knowledgeService;

    /**
     * 作成日取得
     */
    @Test
    public void testGetCreatedAt() {
        // 引数
        KnowledgeEntity knowledgeEntity = KnowledgeEntity
            .builder()
            .createdAt(LocalDateTime.of(2023, 10, 12, 1, 23, 45))
            .updatedAt(null)
            .build();
        // 期待値
        LocalDateTime expected = LocalDateTime.of(2023, 10, 12, 1, 23, 45);

        // テスト
        tester(knowledgeEntity, expected);
    }

    /**
     * 更新日取得
     */
    @Test
    public void testGetUpdatedAt() {
        // 引数
        KnowledgeEntity knowledgeEntity = KnowledgeEntity
            .builder()
            .createdAt(LocalDateTime.of(2023, 10, 12, 1, 23, 45))
            .updatedAt(LocalDateTime.of(2024, 12, 31, 23, 59, 59))
            .build();
        // 期待値
        LocalDateTime expected = LocalDateTime.of(2024, 12, 31, 23, 59, 59);

        // テスト
        tester(knowledgeEntity, expected);
    }

    /**
     * isNull
     */
    @Test
    public void testNull() {
        // 引数
        KnowledgeEntity knowledgeEntity = null;
        // 期待値
        String expected = null;

        // テスト
        InvocationTargetException ex = assertThrows(InvocationTargetException.class, () -> {
            Method method = createMethod();
            method.invoke(knowledgeService, knowledgeEntity);
        });
        assertEquals(NullPointerException.class, ex.getCause().getClass());
        assertEquals(expected, ex.getCause().getMessage());
    }

    /**
     * テスター
     * @param knowledgeEntity ナレッジ
     * @param expected 期待値
     * @throws Exception 例外
     */
    private void tester(KnowledgeEntity knowledgeEntity, LocalDateTime expected) {
        try {
            Method method = createMethod();
            LocalDateTime actual = (LocalDateTime)method.invoke(knowledgeService, knowledgeEntity);
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
        Method method = KnowledgeService.class.getDeclaredMethod("getLatestAt", KnowledgeEntity.class);
        method.setAccessible(true);
        return method;
    }
}
