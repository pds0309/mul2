# springbootmultimodule test
springboot 2.4.5  gradle 6.8.3  멀티모듈 구성 연습


<br>  

**멀티모듈 구성 예시**

* api : api 서버역할 모듈(8080)
    * /players : 모든 선수들에 대한 정보를 반환한다.

* common : 공통적으로 사용되는 도메인 등
    * player entity , repository

* schedule : 스케줄 작업 모듈(8081)
    * 1분마다 player repository 를 업데이트한다.
  
**gradle 7 미만**

> compile() , implementation() 모두 가능

```gradle
project(':api') {
    dependencies {
        compile project(':common')
    }
}
```

**gradle 7 이상에서는 compile() 사용 불가**

> compile() 사용시 : Could not find method compile() for arguments Gradle

```gradle
project(':api') {
    dependencies {
        implementation project(':common')
    }
}
```  

<br>  

**implementation 시 문제**

* 직접 의존하고 하고 있지 않은 의존성 사용 불가능

> 예시

* common 모듈은 공유 엔티티, 리포지토리를 다룬다. common 모듈에 JPA 의존성이 있다.
* api 의 로직에서 (common 모듈의) repository를 받아올 수 있지만 save() findbyid() 같은 메소드를 사용할 수 없다.  

<br> 
