# syntax=docker/dockerfile:1.4

FROM node:lts as builder

RUN mkdir /project
WORKDIR /project

COPY ./src/main/webAngular /project

RUN npm install -g @angular/cli@13

#COPY ./src/main/webAngular/package*.json ./
#COPY ./src/main/webAngular/proxy-conf.json ./
#COPY ./src/main/webAngular/tsconfig*.json ./
#COPY ./src/main/webAngular/angular.json ./
RUN npm ci

#COPY . .
CMD ["npm", "start"]

#FROM builder as dev-envs


#CMD ["ng", "serve", "--host", "0.0.0.0"]