package io.github.pj.cattletraceabilitybackend.mapper;

import io.github.pj.cattletraceabilitybackend.entity.ProcessingInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProcessMapper {

    @Insert("INSERT INTO process (cattle_id, processing_time, acid_removal_time, final_product_weight) VALUES (#{cattleId}, #{processingTime}, #{acidRemovalTime}, #{finalProductWeight})")
    void insert(ProcessingInfo process);

    @Select("SELECT * FROM process WHERE cattle_id = #{cattleId}")
    ProcessingInfo getByCalttleId(@Param("cattleId") Integer cattleId);

    @Update("UPDATE process SET processing_time = #{processingTime}, acid_removal_time = #{acidRemovalTime}, final_product_weight = #{finalProductWeight} WHERE cattle_id = #{cattleId}")
    void update(ProcessingInfo process);

    @Delete("DELETE FROM process WHERE cattle_id = #{cattleId}")
    void deleteByCalttleId(@Param("cattleId") Integer cattleId);
}