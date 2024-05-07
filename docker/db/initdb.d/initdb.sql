CREATE TABLE `knowledge` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ナレッジID',
  `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '投稿者名',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'タイトル',
  `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '本文',
  `created_at` datetime NOT NULL COMMENT '作成日時',
  `updated_at` datetime DEFAULT NULL COMMENT '更新日時',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='ナレッジ';

CREATE TABLE `opinions` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '意見ID',
  `knowledge_id` int NOT NULL COMMENT 'ナレッジID',
  `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '投稿者名',
  `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '本文',
  `created_at` datetime NOT NULL COMMENT '作成日時',
  `updated_at` datetime DEFAULT NULL COMMENT '更新日時',
  PRIMARY KEY (`id`),
  KEY `FK_opinions_knowledge_id` (`knowledge_id`),
  CONSTRAINT `FK_opinions_knowledge_id` FOREIGN KEY (`knowledge_id`) REFERENCES `knowledge` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='意見';
