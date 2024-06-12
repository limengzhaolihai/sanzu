package com.example.demo.Dao.hard;

import com.example.demo.Pojo.entity.HardEntity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author MZ_Li
 * @date 2024/6/12 11:04
 */
@Mapper
public interface HardMapper {

    @Select("select id, ifnull(num_f, 0) as numF, ifnull(num_s, 0) as numS from hard")
    List<HardEntity> list();

    @Delete("delete from hard where id = #{id}")
    void remove(@Param("id") Long id);
}
