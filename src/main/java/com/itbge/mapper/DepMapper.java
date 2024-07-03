package com.itbge.mapper;

import com.itbge.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Mapper
public interface DepMapper {
    List<Dept> selectAll();

    void deleteById(Integer id);

    void add(Dept dept);

    Dept selectById(Integer id);

    void update(Dept dept);
}
