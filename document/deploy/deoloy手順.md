## デプロイ手順

※少しずつアップデート予定

### デプロイ手順

1. EC2 インスタンスに ssh 接続をする

キーペアの pem ファイルを貰い、ローカルマシンの ssh ディレクトリ配下に配置する。  
その後、下記コマンドで ssh 接続を行う

```
ssh -i C:\\Users\\山田翔太\\.ssh\\mira-knowledge-key-pair.pem ec2-user@54.86.6.75
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

コンテナの再起動停止と、停止

```
sudo docker update --restart=no mira-knowledge-api
sudo docker stop mira-knowledge-api
```

最後に、docker ディレクトリ内に CD して下記のコンテナ作成コマンドを叩く。  
本番と検証で、env ファイルを分けて本番用の compose.yml も配置するのが丸いのかと推察し作成。

### 一括でコンテナ作成

本番用

```
docker-compose -f compose.prod.yml --env-file .env.production up -d
```

開発

```
docker-compose -f compose.yml --env-file .env up -d
```

# 現在動作しているコンテナを停止

docker-compose -f compose.prod.yml down

# 新しいイメージをビルド

docker-compose -f compose.prod.yml build

# 新しいコンテナを起動

docker-compose -f compose.prod.yml --env-file .env.production up -d

# 不要な Docker オブジェクトの削除

docker system prune -a --volumes

# ビルドキャッシュの削除

docker builder prune

## デバッグ用

コンテナ状態確認

```
docker ps -a
```

### EC2 インスタンス作成時

docker network connect mira-knowledge-network mira-knowledge-db

1.  docker network connect mira-knowledge-network mira-knowledge-web

## Nginx だけで完結するように修正して、成功したら他のコンテナに着手していく

2.  docker network connect mira-knowledge-network mira-knowledge-api
    docker network connect mira-knowledge-network mira-knowledge-app
