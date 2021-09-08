package com.example.common;


import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//요거 넣어야 단위 테스트 된다. 안넣으면 Autowired 로 주입 안됨
@SpringBootApplication
class CommonApplicationTest {
    @Test
    void contextLoads(){
        // no
    }
}
