package com.example.common;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void playerTest(){
        Player player = new Player(1,"김갑환");
        assertNotNull(player);
    }
}
