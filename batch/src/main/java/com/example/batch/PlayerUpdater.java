package com.example.batch;


import com.example.common.Player;
import com.example.common.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PlayerUpdater {

    private final PlayerRepository playerRepository;


    @Scheduled(cron = "10 * * * * ?")
    public Player updatePlayer(){

        int id = (int) (playerRepository.count()+1);
        Player player = new Player(id , "선수"+id);
        playerRepository.save(player);
        log.info("player : " + id + "추가");
        return player;
    }
}
