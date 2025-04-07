#! /bin/bash

jenv global 1.8

mvn install:install-file \
  -Dfile=libs/1.jar \
  -DgroupId=x.x \
  -DartifactId=a \
  -Dversion=1.0 \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile=libs/2.jar \
  -DgroupId=x.x \
  -DartifactId=b \
  -Dversion=1.0 \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile=libs/3.jar \
  -DgroupId=x.x \
  -DartifactId=c \
  -Dversion=1.0 \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile=libs/4.jar \
  -DgroupId=x.x \
  -DartifactId=d \
  -Dversion=1.0 \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile=libs/5.jar \
  -DgroupId=x.x \
  -DartifactId=e \
  -Dversion=1.0 \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile=libs/6.jar \
  -DgroupId=x.x \
  -DartifactId=f \
  -Dversion=1.0 \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile=libs/7.jar \
  -DgroupId=x.x \
  -DartifactId=g \
  -Dversion=1.0 \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile=libs/8.jar \
  -DgroupId=x.x \
  -DartifactId=h \
  -Dversion=1.0 \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile=libs/9.jar \
  -DgroupId=x.x \
  -DartifactId=i \
  -Dversion=1.0 \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile=libs/10.jar \
  -DgroupId=x.x \
  -DartifactId=j \
  -Dversion=1.0 \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile=libs/11.jar \
  -DgroupId=x.x \
  -DartifactId=k \
  -Dversion=1.0 \
  -Dpackaging=jar

mvn install:install-file \
  -Dfile=libs/12.jar \
  -DgroupId=x.x \
  -DartifactId=l \
  -Dversion=1.0 \
  -Dpackaging=jar

mvn clean package
