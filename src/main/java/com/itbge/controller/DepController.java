package com.itbge.controller;

import com.itbge.mapper.DepMapper;
import com.itbge.pojo.Dept;
import com.itbge.pojo.Emp;
import com.itbge.pojo.PageBean;
import com.itbge.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepController {
    @Autowired
    DepMapper depMapper;

    //查询所有部门信息
    @GetMapping("/depts")
    public Result selectAll() {
        List<Dept> rows = depMapper.selectAll();
        return Result.success(rows);
    }

    //根据id删除部门信息
    @DeleteMapping("/depts/{id}")
    public Result deleteById(@PathVariable Integer id) {
        depMapper.deleteById(id);
        return Result.success();
    }

    //增加部门
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept) {
        depMapper.add(dept);
        return Result.success();
    }

    //根据id查找部门信息
//  @GetMapping("/depts/{id}")
//    public Result selectById(Integer id) {
//        Dept dept = depMapper.selectById();
//        return Result.success(dept);
//    }

    //更改部门信息
    @PutMapping("/depts")
    public Result update(Dept dept) {
        depMapper.update(dept);
        return Result.success();
    }


}
