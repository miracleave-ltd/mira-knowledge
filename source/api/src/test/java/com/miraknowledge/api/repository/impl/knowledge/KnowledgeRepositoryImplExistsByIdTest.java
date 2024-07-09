package com.miraknowledge.api.repository.impl.knowledge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.object.entity.KnowledgeEntity;
import com.miraknowledge.api.repository.impl.KnowledgeRepositoryImpl;
import com.miraknowledge.api.repository.jpa.KnowledgeJpaRepository;

@ExtendWith(MockitoExtension.class)
public class KnowledgeRepositoryImplExistsByIdTest {
    @InjectMocks
    private KnowledgeRepositoryImpl knowledgeRepositoryImpl;
    @Mock
    private KnowledgeJpaRepository knowledgeJpaRepository;

    /**
     * 存在する
     */
    @Test
    public void testTrue() {
        // 引数
        Integer knowledgeId = 1;
        // リポジトリ取得
        Optional<KnowledgeEntity> optional = Optional.ofNullable(KnowledgeEntity.builder().build());

        // テスト
        doReturn(optional).when(knowledgeJpaRepository).findById(knowledgeId);
        assertTrue(knowledgeRepositoryImpl.existsById(knowledgeId));
    }

    /**
     * 存在しない
     */
    @Test
    public void testFalse() {
        // 引数
        Integer knowledgeId = -1;
        // リポジトリ取得
        Optional<KnowledgeEntity> optional = Optional.empty();

        // テスト
        doReturn(optional).when(knowledgeJpaRepository).findById(knowledgeId);
        assertFalse(knowledgeRepositoryImpl.existsById(knowledgeId));
    }

    /**
     * isNull
     */
    @Test
    public void testNull() {
        // 引数
        Integer knowledgeId = null;
        // 期待値
        String expected = null;

        // テスト
        String actual = assertThrows(IllegalArgumentException.class, () -> knowledgeRepositoryImpl.existsById(knowledgeId)).getMessage();
        assertEquals(expected, actual);
    }
}
