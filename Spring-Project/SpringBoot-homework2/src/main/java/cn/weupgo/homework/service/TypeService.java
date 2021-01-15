package cn.weupgo.homework.service;


import cn.weupgo.homework.po.ItemTypes;

import java.util.List;


public interface TypeService {

    List<ItemTypes> queryAllType();

    int queryTypeIdByName(String typeName);
}
