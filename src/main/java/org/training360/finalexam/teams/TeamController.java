package org.training360.finalexam.teams;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.training360.finalexam.players.CreatePlayerCommand;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    @Operation(summary = "Query all teams")
    public List<TeamDTO> getTeams() {
        return teamService.getTeams();
    }

    @PostMapping
    @Operation(summary = "Create a team")
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDTO createTeam(@Valid @RequestBody CreateTeamCommand command) {
        return teamService.createTeam(command);
    }

    @PostMapping("{id}/players")
    @Operation(summary = "Add a new player")
    public TeamDTO addNewPlayerToTeam(@PathVariable("id") long id, @Valid @RequestBody CreatePlayerCommand command) {
        return teamService.addNewPlayerToTeam(id, command);
    }

    @PutMapping("{id}/players")
    @Operation(summary = "Add an existing player")
    public void addExistingPlayerToTeam(@PathVariable("id") long id, @Valid @RequestBody UpdateWithExistingPlayerCommand command) {
        teamService.addExistingPlayerToTeam(id, command);
    }
}
