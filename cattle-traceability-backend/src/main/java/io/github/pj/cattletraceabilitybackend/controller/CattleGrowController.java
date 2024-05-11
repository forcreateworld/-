package io.github.pj.cattletraceabilitybackend.controller;

import io.github.pj.cattletraceabilitybackend.entity.Cattle;
import io.github.pj.cattletraceabilitybackend.service.interfaces.CattleGrowService;
import io.github.pj.cattletraceabilitybackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cattleGrow")
public class CattleGrowController {

    @Autowired
    private CattleGrowService cattleGrowService;

    @PostMapping
    public Result add(@RequestBody Cattle cattle) {
        cattleGrowService.add(cattle);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        cattleGrowService.delete(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Cattle cattle = cattleGrowService.getCattleById(id);
        return Result.success(cattle);
    }

    @PutMapping
    public Result updateSlaughterTime(@RequestBody Cattle cattle) {
        cattleGrowService.updateSlaughterTime(cattle);
        return Result.success();
    }

    @GetMapping
    public Result list() {
        List<Cattle> cattleList = cattleGrowService.list();
        return Result.success(cattleList);
    }
}