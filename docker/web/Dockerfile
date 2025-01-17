# FROM node:20.12.2-buster
# WORKDIR /usr/src/app
# COPY ../../source/app/package*.json ./
# RUN npm install
# COPY ../../source/app .
# RUN npm run build

# # nginxイメージを使用するステージ
# FROM nginx:1.25.5-alpine3.19

# # 開発と本番でファイル名を分ける為にビルド引数を定義
# ARG NGINX_CONF=default.prod.conf

# # システムのタイムゾーンを日本時間 (Asia/Tokyo) に設定
# RUN apk update \
#     && apk add --no-cache tzdata \
#     && cp /usr/share/zoneinfo/Asia/Tokyo /etc/localtime

# # nginx の設定ファイルをコピー
# COPY ./docker/web/nginx.conf /etc/nginx/nginx.conf
# COPY ./docker/web/${NGINX_CONF} /etc/nginx/conf.d/default.conf

# # appコンテナからビルドされた静的ファイルをコピー
# COPY --from=builder /app/build /usr/share/nginx/html

# # 環境変数を設定 (日本語環境)
# ENV LANG=ja_JP.UTF-8 \
#     LC_CTYPE=ja_JP.UTF-8 \
#     LC_NUMERIC=ja_JP.UTF-8 \
#     LC_TIME=ja_JP.UTF-8 \
#     LC_COLLATE=ja_JP.UTF-8 \
#     LC_MONETARY=ja_JP.UTF-8 \
#     LC_MESSAGES=ja_JP.UTF-8 \
#     LC_PAPER=ja_JP.UTF-8 \
#     LC_NAME=ja_JP.UTF-8 \
#     LC_ADDRESS=ja_JP.UTF-8 \
#     LC_TELEPHONE=ja_JP.UTF-8 \
#     LC_MEASUREMENT=ja_JP.UTF-8 \
#     LC_IDENTIFICATION=ja_JP.UTF-8 \
#     LC_ALL=

# # デーモンモードを無効にして nginx を実行
# CMD ["nginx", "-g", "daemon off;"]

FROM node:20.12.2-buster as build
WORKDIR /usr/src/app
COPY ../../source/app/package*.json ./
RUN npm install
COPY ../../source/app .
RUN npm run build

FROM nginx:1.25.5-alpine3.19
WORKDIR /usr/share/nginx/html
COPY --from=build /usr/src/app/dist .
RUN apk update \
    && apk add --no-cache tzdata \
    && cp /usr/share/zoneinfo/Asia/Tokyo /etc/localtime

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

COPY ./docker/web/default.prod.conf /etc/nginx/conf.d/default.conf

CMD ["nginx", "-g", "daemon off;"]