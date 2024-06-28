package com.itbge.mapper;
import com.itbge.pojo.Emp;
import com.itbge.pojo.Result;
import org.apache.ibatis.annotations.Mapper;
import java.time.LocalDate;
import java.util.List;
@Mapper//这个注解会让Spring帮我们创建对象，存放到IOC容器中
public interface EmpMapper {

    //查询总条数
    Integer selectTotal(String name, Integer gender, LocalDate begin, LocalDate end);
    //查询当前页数据
    List<Emp> selectPage(String name, Integer gender, LocalDate begin, LocalDate end,
                         Integer start, Integer pageSize);

    //根据id查找用户
    Emp selectById(Integer id);
    //修改信息
    void update(Emp emp);

    //根据多个id删除用户
    void deleteById(Integer ids);

    //新增用户
    void add(Emp emp);
}