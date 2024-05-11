package io.github.pj.cattletraceabilitybackend.service.impl;

import io.github.pj.cattletraceabilitybackend.entity.Customer;
import io.github.pj.cattletraceabilitybackend.mapper.CustomerMapper;
import io.github.pj.cattletraceabilitybackend.service.interfaces.CustomerService;
import io.github.pj.cattletraceabilitybackend.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer findByUsername(String username) {
        return customerMapper.findByUsername(username);
    }

    @Override
    public void register(String username, String password) {
        String md5Pass = Md5Util.getMD5String(password);
        Customer customer = new Customer();
        customer.setUsername(username);
        customer.setPassword(md5Pass);
        customer.setCreateTime(LocalDateTime.now());
        customer.setUpdateTime(LocalDateTime.now());
        customerMapper.register(customer);
    }
}