package org.training360.finalexam.players;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {

    private ModelMapper modelMapper;

    private PlayerRepository repository;

    public List<PlayerDTO> getPlayers() {
        return repository.findAll().stream()
                .map(player -> modelMapper.map(player, PlayerDTO.class))
                .toList();
    }

    public PlayerDTO createPlayer(CreatePlayerCommand command) {
        Player player = new Player(command.getName(), command.getDateOfBirth(), command.getPosition());
        repository.save(player);
        return modelMapper.map(player, PlayerDTO.class);
    }

    public void deletePlayerById(long id) {
        repository.deleteById(id);
    }
}
