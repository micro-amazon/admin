# admin

spring으로 작성된 관리자 서비스

Jenkins CI/CD가 적용되어 있습니다.

# API

- POST /login: 관리자 계정 로그인
- POST /register: 관리자 계정 가입

# Jenkins pipeline

- [Jenkinsfile](https://github.com/micro-amazon/admin/blob/main/Jenkinsfile)
  - git scm update
  - gradle build
  - [docker build and push](https://hub.docker.com/repository/docker/zwan2/micro-amazon-admin)
  - deploy kubernetes