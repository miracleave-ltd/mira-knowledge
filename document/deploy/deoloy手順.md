## デプロイ手順

※少しずつアップデート予定

### デプロイ手順

1. EC2 インスタンスに ssh 接続をする

キーペアの pem ファイルを貰い、ローカルマシンの ssh ディレクトリ配下に配置する。  
その後、下記コマンドで ssh 接続を行う

```
ssh -i C:\\Users\\山田翔太\\.ssh\\test-key-pair.pem ec2-user@54.175.129.54
```

2. Docker と Docker compose を install する。あと git も。

パッケージリストの更新

```
sudo yum update -y
```

Docker のインストール

```
sudo dnf install docker
```

Docker サービスの開始

```
sudo service docker start
```

docker グループにユーザを追加。sudo 無しでも docker コマンドが実行出来るように。

```
sudo usermod -a -G docker ec2-user
```

公式の Git から Docker compose をインストール

```
sudo curl -L "https://github.com/docker/compose/releases/download/v2.21.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
```

実行権限を付与

```
sudo chmod +x /usr/local/bin/docker-compose
```

インストール出来ているか確認

```
docker-compose --version

```

git をインストールする

```
sudo dnf install git -y
```

入ったか確認

```
git --version
```

HTTPS を使用してクローンする。  
※一旦確認しているだけなのと、github アカウントに公開鍵を登録したくないため

```
git clone https://github.com/miracleave-ltd/mira-knowledge.git

```

Docker コンテナの状態を確認

```
sudo docker ps
```

各種ログ確認

```
sudo docker logs mira-knowledge-app
sudo docker logs mira-knowledge-api
```

コンテナ再起動

```
sudo  docker-compose build web
sudo docker-compose up -d web
```

最後に、docker ディレクトリ内に CD して下記のコンテナ作成コマンドを叩く。  
本番と検証で、env ファイルを分けて本番用の compose.yml も配置するのが丸いのかな。
あと、env ファイルを ignore したいんだがルートで.gitignore 作成しても良いか相談。

### コンテナ作成

本番用

```
docker-compose -f compose.prod.yml --env-file .env.production up -d
```

開発

```
docker-compose -f compose.yml --env-file .env up -d
```

### 本番環境用の Nginx の設定

#### default.conf

```
server {
    listen 80 default_server;
    listen [::]:80;
    server_name 54.175.129.54;  # EC2インスタンスのパブリックIPアドレス

    location / {
        proxy_pass http://mira-knowledge-app:5173/;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }

    location /api/ {
        proxy_pass http://mira-knowledge-api:8080/api/;
        proxy_set_header Host $host;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header X-Forwarded-Proto $scheme;
    }
}
```

### 本番環境用の app の docker ファイル

```
FROM node:20.12.2-buster

COPY ../../source/app /usr/src/app
WORKDIR /usr/src/app

ENV LANG=ja_JP.UTF-8 \
    LC_CTYPE=ja_JP.UTF-8 \
    LC_NUMERIC=ja_JP.UTF-8 \
    LC_TIME=ja_JP.UTF-8 \
    LC_COLLATE=ja_JP.UTF-8 \
    LC_MONETARY=ja_JP.UTF-8 \
    LC_MESSAGES=ja_JP.UTF-8 \
    LC_PAPER=ja_JP.UTF-8 \
    LC_NAME=ja_JP.UTF-8 \
    LC_ADDRESS=ja_JP.UTF-8 \
    LC_TELEPHONE=ja_JP.UTF-8 \
    LC_MEASUREMENT=ja_JP.UTF-8 \
    LC_IDENTIFICATION=ja_JP.UTF-8 \
    LC_ALL=

RUN npm install
RUN npm run build

CMD ["npm", "run", "start"]

```

### 本番環境用の api の docker ファイル

```
FROM gradle:8.7.0-jdk17-alpine
COPY --chown=gradle:gradle ../../source/api /home/gradle/src
WORKDIR /home/gradle/src

ENV LANG=ja_JP.UTF-8 \
    LC_CTYPE=ja_JP.UTF-8 \
    LC_NUMERIC=ja_JP.UTF-8 \
    LC_TIME=ja_JP.UTF-8 \
    LC_COLLATE=ja_JP.UTF-8 \
    LC_MONETARY=ja_JP.UTF-8 \
    LC_MESSAGES=ja_JP.UTF-8 \
    LC_PAPER=ja_JP.UTF-8 \
    LC_NAME=ja_JP.UTF-8 \
    LC_ADDRESS=ja_JP.UTF-8 \
    LC_TELEPHONE=ja_JP.UTF-8 \
    LC_MEASUREMENT=ja_JP.UTF-8 \
    LC_IDENTIFICATION=ja_JP.UTF-8 \
    LC_ALL=

RUN gradle build

CMD ["java", "-jar", "build/libs/api-0.0.1-SNAPSHOT.jar"]
```
