package com.miraknowledge.api.repository.impl.knowledge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.object.entity.KnowledgeEntity;
import com.miraknowledge.api.repository.impl.KnowledgeRepositoryImpl;
import com.miraknowledge.api.repository.jpa.KnowledgeJpaRepository;

@ExtendWith(MockitoExtension.class)
public class KnowledgeRepositoryImplSetCreateKnowledgeEntityTest {
    @InjectMocks
    private KnowledgeRepositoryImpl knowledgeRepositoryImpl;
    @Mock
    private KnowledgeJpaRepository knowledgeJpaRepository;

    /**
     * 更新対象全て
     */
    public void testAll() {
        // 引数
        KnowledgeEntity knowledgeEntity = KnowledgeEntity
            .builder()
            .id(1)
            .name("name")
            .title("title")
            .content("content")
            .createdAt(null)
            .updatedAt(LocalDateTime.now())
            .build();

        // テスト
        tester(knowledgeEntity);
        assertNull(knowledgeEntity.getId());
        assertNotNull(knowledgeEntity.getCreatedAt());
        assertNull(knowledgeEntity.getUpdatedAt());
    }

    /**
     * Id isNull
     */
    @Test
    public void testIdIsNull() {
        // 引数
        KnowledgeEntity knowledgeEntity = KnowledgeEntity
            .builder()
            .id(null)
            .name("name")
            .title("title")
            .content("content")
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
            .build();

        // テスト
        tester(knowledgeEntity);
        assertNull(knowledgeEntity.getId());
    }

    /**
     * Id NonNull
     */
    @Test
    public void testIdNonNull() {
        // 引数
        KnowledgeEntity knowledgeEntity = KnowledgeEntity
            .builder()
            .id(1)
            .name("name")
            .title("title")
            .content("content")
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
            .build();

        // テスト
        tester(knowledgeEntity);
        assertNull(knowledgeEntity.getId());
    }

    /**
     * CreatedAt isNull
     */
    @Test
    public void testCreatedAtIsNull() {
        // 引数
        KnowledgeEntity knowledgeEntity = KnowledgeEntity
            .builder()
            .id(null)
            .name("name")
            .title("title")
            .content("content")
            .createdAt(null)
            .updatedAt(null)
            .build();

        // テスト
        tester(knowledgeEntity);
        assertNotNull(knowledgeEntity.getCreatedAt());
    }

    /**
     * CreatedAt nonNull
     */
    @Test
    public void testCreatedAtNonNull() {
        // 引数
        KnowledgeEntity knowledgeEntity = KnowledgeEntity
            .builder()
            .id(null)
            .name("name")
            .title("title")
            .content("content")
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
            .build();
        // 期待値
        LocalDateTime expected = knowledgeEntity.getCreatedAt();

        // テスト
        tester(knowledgeEntity);
        assertEquals(expected, knowledgeEntity.getCreatedAt());
    }

    /**
     * UpdatedAt isNull
     */
    @Test
    public void testUpdatedAtIsNull() {
        // 引数
        KnowledgeEntity knowledgeEntity = KnowledgeEntity
            .builder()
            .id(null)
            .name("name")
            .title("title")
            .content("content")
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
            .build();

        // テスト
        tester(knowledgeEntity);
        assertNull(knowledgeEntity.getUpdatedAt());
    }

    /**
     * UpdatedAt nonNull
     */
    @Test
    public void testUpdatedAtNonNull() {
        // 引数
        KnowledgeEntity knowledgeEntity = KnowledgeEntity
            .builder()
            .id(null)
            .name("name")
            .title("title")
            .content("content")
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

        // テスト
        tester(knowledgeEntity);
        assertNull(knowledgeEntity.getUpdatedAt());
    }

    /**
     * テスター
     * @param knowledgeEntity ナレッジ
     * @throws Exception 例外
     */
    private void tester(KnowledgeEntity knowledgeEntity) {
        try {
            Method method = createMethod();
            method.invoke(knowledgeRepositoryImpl, knowledgeEntity);
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
        Method method = KnowledgeRepositoryImpl.class.getDeclaredMethod("setCreateKnowledgeEntity", KnowledgeEntity.class);
        method.setAccessible(true);
        return method;
    }
}
