# mira-knowledge ～ナレッジ投稿プロジェクト～
## プロジェクトについて
ユニット課題の一環としてプロジェクト始動！  
ナレッジ投稿からプログラム開発の一助になれば・・・

## 環境
| 言語・フレームワーク  | バージョン |
| --------------------- | ---------- |
| Docker                | 24.0.6     |
| Docker Compose        | 2.21.0     |
| Nginx                 | 1.25.5     |
| Spring Boot           | 3.2.5      |
| Gradle                | 8.7.0      |
| Java                  | 17         |
| MySQL                 | 8.0.36     |
| Node.js               | 20.12.2    |
| npm                   | 10.5.0     |
| Vite                  | 5.2.3      |
| Vue.js                | 3.4.21     |

## ディレクトリ構成
<pre>
.
├── docker                               Docker開発環境
│   ├── api                             Spring Boot
│   │   └── Dockerfile
│   ├── app                             Vue.js
│   │   └── Dockerfile
│   ├── db                              MySQL
│   │   ├── initdb.d
│   │   │   └── initdb.sql            DB初期データ
│   │   ├── Dockerfile
│   │   └── my.cnf                     設定ファイル
│   ├── web                             Nginx
│   │   ├── default.conf               設定ファイル
│   │   └── Dockerfile
│   ├── .env                            環境変数関連
│   └── compose.yml                     Docker Compose設定
├── document                             ドキュメント
│   └── db                              データベース関連
│       ├── ddl                         テーブルDDL
│       └── table                       テーブル定義書
└── source                               ソースコード
    ├── api                              API（Spring Boot）
    └── app                              Webアプリ（Vue.js）
</pre>

## 環境変数一覧
| 変数名                 | 役割                                  | デフォルト値       |
| ---------------------- | ------------------------------------- | ------------------ |
| APP_MODE               | アプリケーションモード                | dev                |
| APP_LOG_LEVEL          | アプリケーションログ出力レベル        | debug              |
| MYSQL_ROOT_PASSWORD    | MySQLのルートパスワード               | root               |
| MYSQL_DATABASE         | MySQLのデータベース名                 | miraedge           |
| MYSQL_USER             | MySQLのユーザ名                       | mira               |
| MYSQL_PASSWORD         | MySQLのパスワード                     | mira               |
