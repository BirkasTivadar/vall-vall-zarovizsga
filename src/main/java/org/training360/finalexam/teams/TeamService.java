package org.training360.finalexam.teams;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeamService {

    private ModelMapper modelMapper;

    private TeamRepository teamRepository;
}
