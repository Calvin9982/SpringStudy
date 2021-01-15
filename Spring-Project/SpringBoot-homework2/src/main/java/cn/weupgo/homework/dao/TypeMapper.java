package cn.weupgo.homework.dao;

import cn.weupgo.homework.po.ItemTypes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TypeMapper {

    List<ItemTypes> queryAllType();

    int queryTypeIdByName(String typeName);

}
