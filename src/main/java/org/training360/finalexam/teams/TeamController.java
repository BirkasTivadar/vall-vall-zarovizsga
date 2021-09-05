package org.training360.finalexam.teams;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private final  TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }
}
