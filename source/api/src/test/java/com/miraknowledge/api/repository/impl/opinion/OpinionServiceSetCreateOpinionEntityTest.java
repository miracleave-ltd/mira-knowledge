package com.miraknowledge.api.repository.impl.opinion;

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
import com.miraknowledge.api.object.entity.OpinionEntity;
import com.miraknowledge.api.repository.impl.OpinionRepositoryImpl;
import com.miraknowledge.api.repository.jpa.KnowledgeJpaRepository;
import com.miraknowledge.api.repository.jpa.OpinionJpaRepository;

@ExtendWith(MockitoExtension.class)
public class OpinionServiceSetCreateOpinionEntityTest {
    @InjectMocks
    private OpinionRepositoryImpl opinionRepositoryImpl;
    @Mock
    private KnowledgeJpaRepository knowledgeJpaRepository;
    @Mock
    private OpinionJpaRepository opinionJpaRepository;

    /**
     * 更新対象全て
     */
    public void testAll() {
        // 引数
        OpinionEntity opinionEntity = OpinionEntity
            .builder()
            .id(1)
            .knowledgeEntity(KnowledgeEntity.builder().id(10).build())
            .name("name")
            .content("content")
            .createdAt(null)
            .updatedAt(LocalDateTime.now())
            .build();

        // テスト
        tester(opinionEntity);
        assertNull(opinionEntity.getId());
        assertNotNull(opinionEntity.getCreatedAt());
        assertNull(opinionEntity.getUpdatedAt());
    }

    /**
     * Id isNull
     */
    @Test
    public void testIdIsNull() {
        // 引数
        OpinionEntity opinionEntity = OpinionEntity
            .builder()
            .id(null)
            .knowledgeEntity(KnowledgeEntity.builder().id(10).build())
            .name("name")
            .content("content")
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
            .build();

        // テスト
        tester(opinionEntity);
        assertNull(opinionEntity.getId());
    }

    /**
     * Id NonNull
     */
    @Test
    public void testIdNonNull() {
        // 引数
        OpinionEntity opinionEntity = OpinionEntity
            .builder()
            .id(1)
            .knowledgeEntity(KnowledgeEntity.builder().id(10).build())
            .name("name")
            .content("content")
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
            .build();

        // テスト
        tester(opinionEntity);
        assertNull(opinionEntity.getId());
    }

    /**
     * CreatedAt isNull
     */
    @Test
    public void testCreatedAtIsNull() {
        // 引数
        OpinionEntity opinionEntity = OpinionEntity
            .builder()
            .id(null)
            .knowledgeEntity(KnowledgeEntity.builder().id(10).build())
            .name("name")
            .content("content")
            .createdAt(null)
            .updatedAt(null)
            .build();

        // テスト
        tester(opinionEntity);
        assertNotNull(opinionEntity.getCreatedAt());
    }

    /**
     * CreatedAt nonNull
     */
    @Test
    public void testCreatedAtNonNull() {
        // 引数
        OpinionEntity opinionEntity = OpinionEntity
            .builder()
            .id(null)
            .knowledgeEntity(KnowledgeEntity.builder().id(10).build())
            .name("name")
            .content("content")
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
            .build();
        // 期待値
        LocalDateTime expected = opinionEntity.getCreatedAt();

        // テスト
        tester(opinionEntity);
        assertEquals(expected, opinionEntity.getCreatedAt());
    }

    /**
     * UpdatedAt isNull
     */
    @Test
    public void testUpdatedAtIsNull() {
        // 引数
        OpinionEntity opinionEntity = OpinionEntity
            .builder()
            .id(null)
            .knowledgeEntity(KnowledgeEntity.builder().id(10).build())
            .name("name")
            .content("content")
            .createdAt(LocalDateTime.now())
            .updatedAt(null)
            .build();

        // テスト
        tester(opinionEntity);
        assertNull(opinionEntity.getUpdatedAt());
    }

    /**
     * UpdatedAt nonNull
     */
    @Test
    public void testUpdatedAtNonNull() {
        // 引数
        OpinionEntity opinionEntity = OpinionEntity
            .builder()
            .id(null)
            .knowledgeEntity(KnowledgeEntity.builder().id(10).build())
            .name("name")
            .content("content")
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

        // テスト
        tester(opinionEntity);
        assertNull(opinionEntity.getUpdatedAt());
    }

    /**
     * テスター
     * @param opinionEntity 意見
     * @throws Exception 例外
     */
    private void tester(OpinionEntity opinionEntity) {
        try {
            Method method = createMethod();
            method.invoke(opinionRepositoryImpl, opinionEntity);
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
        Method method = OpinionRepositoryImpl.class.getDeclaredMethod("setCreateOpinionEntity", OpinionEntity.class);
        method.setAccessible(true);
        return method;
    }
}
