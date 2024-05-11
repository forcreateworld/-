package io.github.pj.cattletraceabilitybackend.service.impl;

import io.github.pj.cattletraceabilitybackend.entity.FactoryUser;
import io.github.pj.cattletraceabilitybackend.mapper.FactoryUserMapper;
import io.github.pj.cattletraceabilitybackend.service.interfaces.FactoryUserService;
import io.github.pj.cattletraceabilitybackend.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FactoryUserServiceImpl implements FactoryUserService {

    @Autowired
    private FactoryUserMapper factoryUserMapper;

    @Override
    public FactoryUser findByUsername(String username) {
        return factoryUserMapper.findByUsername(username);
    }

    @Override
    public void register(String username, String password) {
        String md5Pass = Md5Util.getMD5String(password);
        FactoryUser user = new FactoryUser();
        user.setUsername(username);
        user.setPassword(md5Pass);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        factoryUserMapper.register(user);
    }
}