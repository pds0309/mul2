package com.example.api;


import com.example.common.Player;
import com.example.common.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }
}
