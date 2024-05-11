package io.github.pj.cattletraceabilitybackend.mapper;

import io.github.pj.cattletraceabilitybackend.entity.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CustomerMapper {

    @Insert("INSERT INTO customer(username, password, create_time, update_time) VALUES (#{username}, #{password}, #{createTime}, #{updateTime})")
    void register(Customer customer);

    @Select("SELECT * FROM customer WHERE username = #{username}")
    Customer findByUsername(@Param("username") String username);
}
