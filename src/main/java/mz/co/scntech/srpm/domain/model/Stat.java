package mz.co.scntech.srpm.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Sidónio Goenha on 11/11/2020
 */
@Getter
@Setter
public class Stat {
    private int presbyteries;
    private int congregations;
    private int members;
    private LocalDateTime dateTime = LocalDateTime.now() ;
}
