package io.github.pj.cattletraceabilitybackend.service.impl;

import io.github.pj.cattletraceabilitybackend.entity.Cattle;
import io.github.pj.cattletraceabilitybackend.mapper.CattleGrowMapper;
import io.github.pj.cattletraceabilitybackend.service.interfaces.CattleGrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CattleGrowServiceImpl implements CattleGrowService {

    @Autowired
    private CattleGrowMapper cattleGrowMapper;

    @Override
    public void add(Cattle cattle) {
        cattle.setCreateTime(LocalDateTime.now());
        cattleGrowMapper.insert(cattle);
    }

    @Override
    public Cattle getCattleById(Integer id) {
        return cattleGrowMapper.getCattleById(id);
    }

    @Override
    public void updateSlaughterTime(Cattle cattle) {
        cattle.setSlaughterTime(LocalDateTime.now());
        cattleGrowMapper.updateSlaughterTime(cattle);
    }

    @Override
    public List<Cattle> list() {
        return cattleGrowMapper.list();
    }

    @Override
    public void delete(Integer id) {
        cattleGrowMapper.delete(id);
    }
}