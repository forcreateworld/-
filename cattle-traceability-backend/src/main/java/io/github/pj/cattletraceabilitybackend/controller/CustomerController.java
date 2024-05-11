package io.github.pj.cattletraceabilitybackend.controller;

import io.github.pj.cattletraceabilitybackend.entity.Customer;
import io.github.pj.cattletraceabilitybackend.service.interfaces.CustomerService;
import io.github.pj.cattletraceabilitybackend.utils.JwtUtils;
import io.github.pj.cattletraceabilitybackend.utils.Md5Util;
import io.github.pj.cattletraceabilitybackend.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public Result register(@RequestBody RegisterRequest request) {
        customerService.register(request.getUsername(), request.getPassword());
        return Result.success();
    }

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest request) {
        Customer customer = customerService.findByUsername(request.getUsername());
        if (customer == null || !customer.getPassword().equals(Md5Util.getMD5String(request.getPassword()))) {
            return Result.error("用户名或密码错误");
        }
        String token = JwtUtils.generateToken(customer.getId(), customer.getUsername());
        return Result.success(token);
    }
}
