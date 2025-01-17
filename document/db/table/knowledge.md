# ナレッジ (knowledge)

## テーブル情報

| 項目                           | 値                                                                                                   |
|:-------------------------------|:-----------------------------------------------------------------------------------------------------|
| システム名                     |                                                                                                      |
| サブシステム名                 |                                                                                                      |
| 論理テーブル名                 | ナレッジ                                                                                             |
| 物理テーブル名                 | knowledge                                                                                            |
| 作成者                         |                                                                                                      |
| 作成日                         | 2024/05/01                                                                                           |
| RDBMS                          |  8.0.34                                                                                              |



## カラム情報

| No. | 論理名                         | 物理名                         | データ型                       | Not Null | デフォルト           | 備考                           |
|----:|:-------------------------------|:-------------------------------|:-------------------------------|:---------|:---------------------|:-------------------------------|
|   1 | ナレッジID                     | id                             | int auto_increment             | Yes (PK) |                      |                                |
|   2 | 投稿者名                       | name                           | varchar(60)                    | Yes      |                      |                                |
|   3 | タイトル                       | title                          | varchar(100)                   | Yes      |                      |                                |
|   4 | 本文                           | content                        | varchar(2000)                  | Yes      |                      |                                |
|   5 | 作成日時                       | created_at                     | datetime                       | Yes      |                      |                                |
|   6 | 更新日時                       | updated_at                     | datetime                       |          |                      |                                |



## インデックス情報

| No. | インデックス名                 | カラムリスト                             | ユニーク   | オプション                     |
|----:|:-------------------------------|:-----------------------------------------|:-----------|:-------------------------------|
|   1 | PRIMARY                        | id                                       | Yes        |                                |



## 制約情報

| No. | 制約名                         | 種類                           | 制約定義                       |
|----:|:-------------------------------|:-------------------------------|:-------------------------------|
|   1 | PRIMARY                        | PRIMARY KEY                    | id                             |



## 外部キー情報

| No. | 外部キー名                     | カラムリスト                             | 参照先                         | 参照先カラムリスト                       |
|----:|:-------------------------------|:-----------------------------------------|:-------------------------------|:-----------------------------------------|



## 外部キー情報(PK側)

| No. | 外部キー名                     | カラムリスト                             | 参照元                         | 参照元カラムリスト                       |
|----:|:-------------------------------|:-----------------------------------------|:-------------------------------|:-----------------------------------------|
|   1 | FK_opinions_knowledge          | id                                       | opinions                       | knowledge_id                             |



## トリガー情報

| No. | トリガー名                     | イベント                                 | タイミング           | 条件                           |
|----:|:-------------------------------|:-----------------------------------------|:---------------------|:-------------------------------|


