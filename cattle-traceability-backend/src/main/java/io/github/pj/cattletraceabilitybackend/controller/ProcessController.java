package io.github.pj.cattletraceabilitybackend.controller;

import io.github.pj.cattletraceabilitybackend.entity.ProcessingInfo;
import io.github.pj.cattletraceabilitybackend.service.interfaces.ProcessService;
import io.github.pj.cattletraceabilitybackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/process")
public class ProcessController {


    @Autowired
    private ProcessService processService;

    @PostMapping
    public Result add(@RequestBody ProcessingInfo process) {
        processService.add(process);
        return Result.success();
    }

    @GetMapping("/{cattleId}")
    public Result getByCalttleId(@PathVariable Integer cattleId) {
        ProcessingInfo process = processService.getByCalttleId(cattleId);
        return Result.success(process);
    }

    @PutMapping
    public Result update(@RequestBody ProcessingInfo process) {
        processService.update(process);
        return Result.success();
    }

    @DeleteMapping("/{cattleId}")
    public Result deleteByCalttleId(@PathVariable Integer cattleId) {
        processService.deleteByCalttleId(cattleId);
        return Result.success();
    }
}
