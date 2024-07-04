    FROM nginx:1.25.5-alpine3.19

    # 開発と本番でファイル名を分ける為にビルド引数を定義
    ARG NGINX_CONF=default.prod.conf

    RUN apk update \
        && apk add --no-cache tzdata \
        && cp /usr/share/zoneinfo/Asia/Tokyo /etc/localtime
    COPY ./docker/web/nginx.conf /etc/nginx/nginx.conf
    COPY ./docker/web/${NGINX_CONF} /etc/nginx/conf.d/default.conf

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

    CMD ["nginx", "-g", "daemon off;"]