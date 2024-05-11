package io.github.pj.cattletraceabilitybackend.service.impl;

import io.github.pj.cattletraceabilitybackend.entity.ProcessingInfo;
import io.github.pj.cattletraceabilitybackend.mapper.ProcessMapper;
import io.github.pj.cattletraceabilitybackend.service.interfaces.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProcessMapper processMapper;

    @Override
    public void add(ProcessingInfo process) {
        process.setProcessingTime(LocalDateTime.now());
        processMapper.insert(process);
    }

    @Override
    public ProcessingInfo getByCalttleId(Integer cattleId) {
        return processMapper.getByCalttleId(cattleId);
    }

    @Override
    public void update(ProcessingInfo process) {
        processMapper.update(process);
    }

    @Override
    public void deleteByCalttleId(Integer cattleId) {
        processMapper.deleteByCalttleId(cattleId);
    }
}