package io.github.pj.cattletraceabilitybackend.mapper;

import io.github.pj.cattletraceabilitybackend.entity.Cattle;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CattleGrowMapper {

    @Insert("INSERT INTO cattle (cattle_name, breed, breed_pictures, weight, birth_date, quarantine_date, growth_cycle, create_time) VALUES (#{cattleName}, #{breed}, #{breedPictures}, #{weight}, #{birthDate}, #{quarantineDate}, #{growthCycle}, #{createTime})")
    void insert(Cattle cattle);

    @Select("SELECT * FROM cattle WHERE id = #{cattleId}")
    Cattle getCattleById(@Param("cattleId") Integer cattleId);

    @Update("UPDATE cattle SET slaughter_time = #{slaughterTime}, process_status = 1 WHERE id = #{id}")
    void updateSlaughterTime(Cattle cattle);

    @Select("SELECT * FROM cattle")
    List<Cattle> list();

    @Delete("DELETE FROM cattle WHERE id = #{id}")
    void delete(@Param("id") Integer id);
}

