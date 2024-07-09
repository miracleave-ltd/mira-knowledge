package com.miraknowledge.api.repository.impl.knowledge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doReturn;

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
public class KnowledgeRepositoryImplCreateTest {
    @InjectMocks
    private KnowledgeRepositoryImpl knowledgeRepositoryImpl;
    @Mock
    private KnowledgeJpaRepository knowledgeJpaRepository;

    /**
     * 作成
     */
    @Test
    public void testCreate() {
        // 引数
        KnowledgeEntity knowledgeEntity = KnowledgeEntity
            .builder()
            .name("name")
            .title("title")
            .content("content")
            .createdAt(LocalDateTime.now())
            .build();

        // テスト
        try {
            doReturn(knowledgeEntity).when(knowledgeJpaRepository).save(knowledgeEntity);
            knowledgeRepositoryImpl.create(knowledgeEntity);
        }
        catch (Exception ex) {
            fail(ex);
        }
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
        String actual = assertThrows(IllegalArgumentException.class, () -> knowledgeRepositoryImpl.create(knowledgeEntity)).getMessage();
        assertEquals(expected, actual);
    }
}
