package org.training360.finalexam.teams;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateWithExistingPlayerCommand {

    @Positive
    private Long id;
}
