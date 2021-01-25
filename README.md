# pet-clinic
> 스프링을 이용한 sample project인 [spring-petclinic](https://github.com/spring-projects/spring-petclinic)을 클론 코딩한 프로젝트입니다.

[Spring Boot](https://spring.io/guides/gs/spring-boot/)와 [Spring Data JPA](https://spring.io/projects/spring-data-jpa)의 학습을 위해 만든 Java Web Application입니다.

# Screenshots
![main](https://user-images.githubusercontent.com/38418028/105668522-d578fb80-5f20-11eb-8365-4704b24d4b8e.png)
![addOwner](https://user-images.githubusercontent.com/38418028/105668527-d742bf00-5f20-11eb-89ed-64d45076e952.gif)
![addPet](https://user-images.githubusercontent.com/38418028/105668530-d873ec00-5f20-11eb-9563-da1e71279650.gif)
![addVisit](https://user-images.githubusercontent.com/38418028/105668532-d9a51900-5f20-11eb-9a6f-dd0156615b64.gif)
![vets](https://user-images.githubusercontent.com/38418028/105668534-da3daf80-5f20-11eb-9132-122996a03822.png)

# Tech/framework used
* <img src="https://img.shields.io/badge/Spring-6DB33F?logo=spring&logoColor=white" />

* <img src="https://img.shields.io/badge/Thymeleaf-005F0F?logo=thymeleaf&logoColor=white" />

* [H2 Database](http://h2database.com/html/main.html)

# Installation
이 프로젝트는 [Gradle](https://spring.io/guides/gs/gradle/)을 이용하여 빌드한 [Spring Boot](https://spring.io/guides/gs/spring-boot/) 어플리케이션입니다.

아래의 command line을 통해 jar 파일을 빌드하여 실행할 수 있습니다.

```
$ git clone https://github.com/Wooyongjeong/pet-clinic.git
$ cd pet-clinic
$ ./gradlew build
$ java -jar build/libs/petclinic-0.0.1-SNAPSHOT.jar
```
* [H2 DataBase](http://h2database.com/html/main.html) 콘솔이 켜져 있어야 합니다.

# Features
* 보호자를 등록 및 수정할 수 있습니다.
* 각 보호자마다 애완동물을 등록 및 수정할 수 있습니다.
* 각 애완동물마다 방문 이력을 등록 및 수정할 수 있습니다.
* 수의사 리스트를 조회할 수 있습니다.
