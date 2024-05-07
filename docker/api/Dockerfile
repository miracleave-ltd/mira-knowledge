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

ENTRYPOINT ["/bin/ash"]
