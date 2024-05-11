package io.github.pj.cattletraceabilitybackend.controller;

import io.github.pj.cattletraceabilitybackend.entity.FactoryUser;
import io.github.pj.cattletraceabilitybackend.service.interfaces.FactoryUserService;
import io.github.pj.cattletraceabilitybackend.utils.JwtUtils;
import io.github.pj.cattletraceabilitybackend.utils.Md5Util;
import io.github.pj.cattletraceabilitybackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/factoryUser")
public class FactoryUserController {

    @Autowired
    private FactoryUserService factoryUserService;

    @PostMapping("/register")
    public Result register(@RequestBody RegisterRequest request) {
        factoryUserService.register(request.getUsername(), request.getPassword());
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest request) {
        FactoryUser user = factoryUserService.findByUsername(request.getUsername());
        if (user == null || !user.getPassword().equals(Md5Util.getMD5String(request.getPassword()))) {
            return Result.error("用户名或密码错误");
        }
        String token = JwtUtils.generateToken(user.getId(), user.getUsername());
        return Result.success(token);
    }
}