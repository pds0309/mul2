package com.example.api;


import com.example.common.Player;
import com.example.common.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PlayerService.class})
class PlayerServiceTest {


    @Autowired
    private PlayerService playerService;

    @MockBean
    private PlayerRepository playerRepository;

    @Test
    void getAllPlayersTest(){
        List<Player> pList = new ArrayList<>();
        pList.add(new Player(1,"김갑환"));
        pList.add(new Player(2,"최번개"));
        given(playerRepository.findAll()).willReturn(pList);

        assertEquals(pList,playerService.getAllPlayers());
        assertEquals("김갑환",playerService.getAllPlayers().get(0).getName());
    }
}
