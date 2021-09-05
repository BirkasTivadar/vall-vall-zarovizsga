package org.training360.finalexam.teams;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training360.finalexam.NotFoundException;
import org.training360.finalexam.players.CreatePlayerCommand;
import org.training360.finalexam.players.Player;
import org.training360.finalexam.players.PlayerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {

    private ModelMapper modelMapper;

    private TeamRepository repository;

    private PlayerRepository playerRepository;

    public List<TeamDTO> getTeams() {
        return repository.findAll().stream()
                .map(team -> modelMapper.map(team, TeamDTO.class))
                .toList();
    }

    public TeamDTO createTeam(CreateTeamCommand command) {
        Team team = new Team(command.getName());
        repository.save(team);
        return modelMapper.map(team, TeamDTO.class);
    }

    public TeamDTO addNewPlayerToTeam(long id, CreatePlayerCommand command) {
        Team team = repository.findById(id).orElseThrow(() -> new NotFoundException(id));
        Player player = new Player(command.getName(), command.getDateOfBirth(), command.getPosition());
        team.addPlayer(player);
        return modelMapper.map(team, TeamDTO.class);
    }

    @Transactional
    public void addExistingPlayerToTeam(long id, UpdateWithExistingPlayerCommand command) {
        Team team = repository.findById(id).orElseThrow(() -> new NotFoundException(id));
        Player player = playerRepository.findById(command.getId()).orElseThrow(() -> new NotFoundException(command.getId()));
        if (checkEligiblePlayer(team, player)) {
            team.addPlayer(player);
        }
    }

    private boolean checkEligiblePlayer(Team team, Player player) {
        long number = team.getPlayers().stream()
                .filter(p -> p.getPosition() == player.getPosition()).count();
        return player.getTeam() == null && number < 2;
    }


}
