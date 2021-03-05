FROM node:lts-alpine as build-stage

WORKDIR /app

COPY . .

RUN yarn install && yarn build

FROM nginx:stable-alpine
WORKDIR /usr/share/nginx/html
# Remove default nginx static assets
RUN rm -rf ./*
# Copy static assets from builder stage
COPY --from=build-stage /app/dist .
# Containers run nginx with global directives and daemon off
ENTRYPOINT ["nginx", "-g", "daemon off;"]

#Build docker image
#docker build -t name_app .

#Run docker container
#docker run -dp 8080:8080 name_app

#Restart docker
#docker rm -f <container_id>

#Get docker id
# docker ps

#Stop
#Docker stop