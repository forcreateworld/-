package io.github.pj.cattletraceabilitybackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessingInfo {
    private Integer id;
    private Integer cattleId;
    private LocalDateTime processingTime;
    private Integer acidRemovalTime;
    private Double finalProductWeight;
}