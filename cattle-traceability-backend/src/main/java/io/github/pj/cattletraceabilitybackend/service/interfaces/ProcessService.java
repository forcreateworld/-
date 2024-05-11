package io.github.pj.cattletraceabilitybackend.service.interfaces;

import io.github.pj.cattletraceabilitybackend.entity.ProcessingInfo;

public interface ProcessService {
    void add(ProcessingInfo process);
    ProcessingInfo getByCalttleId(Integer cattleId);
    void update(ProcessingInfo process);
    void deleteByCalttleId(Integer cattleId);
}
