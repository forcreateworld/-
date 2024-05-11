package io.github.pj.cattletraceabilitybackend.mapper;

import io.github.pj.cattletraceabilitybackend.entity.FactoryUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FactoryUserMapper {

    @Insert("INSERT INTO factory_user(username, password, name, phone, create_time, update_time) VALUES (#{username}, #{password}, #{name}, #{phone}, #{createTime}, #{updateTime})")
    void register(FactoryUser user);

    @Select("SELECT * FROM factory_user WHERE username = #{username}")
    FactoryUser findByUsername(@Param("username") String username);
}