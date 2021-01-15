package cn.weupgo.homework.service.Impl;

import cn.weupgo.homework.dao.TypeMapper;
import cn.weupgo.homework.po.ItemTypes;
import cn.weupgo.homework.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class typeImpl implements TypeService {

    @Autowired(required = false)
    TypeMapper typeMapper;

    @Override
    public List<ItemTypes> queryAllType() {
        List<ItemTypes> list=typeMapper.queryAllType();
        return list;
    }

    @Override
    public int queryTypeIdByName(String typeName) {
        int typeId=typeMapper.queryTypeIdByName(typeName);
        return typeId;
    }
}
