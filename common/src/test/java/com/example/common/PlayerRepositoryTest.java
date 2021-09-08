package com.example.common;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@DataJpaTest
class PlayerRepositoryTest {
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    void addTest(){
        Player player = playerRepository.save(new Player(1,"김갑환"));
        assertEquals(1,player.getId());
        assertEquals(player,playerRepository.findById(1).orElse(null));
    }
}
