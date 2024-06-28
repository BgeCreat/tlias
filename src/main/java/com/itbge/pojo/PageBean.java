package com.itbge.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
//用于封装响应数据中分页查询的"row"数据
public class PageBean<T> {
    private Integer total;//总条数
    private List<T> rows;//当前页数据
}
