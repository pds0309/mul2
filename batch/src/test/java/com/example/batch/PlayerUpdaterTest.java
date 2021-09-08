package com.example.batch;


import com.example.common.Player;
import com.example.common.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {PlayerUpdater.class})
class PlayerUpdaterTest {

    @Autowired
    private PlayerUpdater playerUpdater;

    @MockBean
    private PlayerRepository playerRepository;
    @Test
    void updatePlayerTest(){
        Player player = new Player(3,"선수"+3);
        given(playerRepository.count()).willReturn(2L);
        given(playerRepository.save(player)).willReturn(player);
        assertEquals(player.getName(),playerUpdater.updatePlayer().getName());
        assertEquals(player.getId(),playerUpdater.updatePlayer().getId());
    }
}
