package io.github.pj.cattletraceabilitybackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cattle {
    private Integer id;
    private String cattleName;
    private String breed;
    private String breedPictures;
    private Double weight;
    private LocalDate birthDate;
    private LocalDate quarantineDate;
    private String growthCycle;
    private LocalDateTime slaughterTime;
    private Integer processStatus;
    private LocalDateTime createTime;
}
