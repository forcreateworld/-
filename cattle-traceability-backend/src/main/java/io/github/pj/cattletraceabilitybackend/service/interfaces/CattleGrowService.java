package io.github.pj.cattletraceabilitybackend.service.interfaces;

import io.github.pj.cattletraceabilitybackend.entity.Cattle;

import java.util.List;

public interface CattleGrowService {
    void add(Cattle cattle);
    Cattle getCattleById(Integer id);
    void updateSlaughterTime(Cattle cattle);
    List<Cattle> list();
    void delete(Integer id);
}