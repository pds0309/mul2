package com.example.api;


import com.example.common.Player;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringJUnitConfig
@WebMvcTest(controllers = PlayerController.class)
class PlayerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PlayerService playerService;

    @BeforeEach
    void setMvc() {
        this.mvc = MockMvcBuilders.standaloneSetup(new PlayerController(playerService))
                .addFilter(new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true))
                .alwaysDo(print())
                .build();
    }

    @Test
    void getAllPlayerTest() throws Exception {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player(1, "김갑환"));
        playerList.add(new Player(2, "최번개"));
        given(playerService.getAllPlayers()).willReturn(playerList);
        mvc.perform(get("/players")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[{\"id\":1,\"name\":\"김갑환\"},{\"id\":2,\"name\":\"최번개\"}]"));
    }
}
