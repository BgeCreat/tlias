package com.itbge.controller;

import com.itbge.mapper.EmpMapper;
import com.itbge.pojo.Emp;
import com.itbge.pojo.PageBean;
import com.itbge.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmpController {
    @Autowired
    private EmpMapper empMapper;

    //根据具体信息查询页面
    @GetMapping("/emps")
    public Result findByConditionPage(
            String name,
            Integer gender,
            LocalDate begin,
            LocalDate end,
            Integer page,
            Integer pageSize
    ) {
        //创建row数据封装对象
        PageBean<Emp> pb = new PageBean<>();
        //查询所有数据返回查询总数
        Integer total = empMapper.selectTotal(name, gender, begin, end);
        //计算每页开始页数
        Integer start = (page-1)*pageSize;
        //查询操作返回查询结果
        List<Emp> rows = empMapper.selectPage(name,gender,begin,end,start,pageSize);

        //4.把查询到的数据封装到pb对象中
        pb.setTotal(total);
        pb.setRows(rows);
        return Result.success(pb);
    }

    //修改员工信息
    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp) {
        empMapper.update(emp);
        return Result.success();
    }

    //根据员工id查询信息
    @GetMapping("/emps/{id}")
    public Result selectById(@PathVariable("id") Integer id) {
        Emp emp = empMapper.selectById(id);
        return Result.success(emp);
    }

    //根据id删除员工信息
    @DeleteMapping("/emps/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids) {

        // 遍历列表并删除每个ID
        for (Integer id : ids) {
            empMapper.deleteById(id);
        }
        return Result.success();
    }

    //新增用户
    @PostMapping("/emps")
    public Result add(@RequestBody Emp emp) {
        empMapper.add(emp);
        return Result.success();
    }


}
