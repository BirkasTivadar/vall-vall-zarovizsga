package org.training360.finalexam.players;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    @Operation(summary = "Query all players")
    public List<PlayerDTO> getPlayers() {
        return playerService.getPlayers();
    }

    @PostMapping
    @Operation(summary = "Create a player")
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerDTO createPlayer(@Valid @RequestBody CreatePlayerCommand command) {
        return playerService.createPlayer(command);
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Delete a player by id")
    public void deletePlayerById(@PathVariable("id") long id) {
        playerService.deletePlayerById(id);
    }


}
