package cn.weupgo.homework.service.Impl;

import cn.weupgo.homework.dao.ItemMapper;
import cn.weupgo.homework.po.PeItems;
import cn.weupgo.homework.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class itemImpl implements ItemService {

    @Autowired
    ItemMapper itemMapper ;

    @Override
    public List<PeItems> queryItemsByName(String itemName) {
        List<PeItems> items=itemMapper.queryItemsByName(itemName);
        return  items;
    }

    @Override
    public void updateItem(PeItems peItems) {
        itemMapper.updateItem(peItems);
    }

    @Override
    public PeItems queryItemsById(int itemId) {
        PeItems peItems=itemMapper.queryItemsById(itemId);
        return peItems;
    }

    @Override
    public List<PeItems> queryAllItems() {
       List<PeItems> items=itemMapper.queryAllItems();
       return items;
    }


    @Override
    public List<String> queryAllItemName() {
        List<String> lists= itemMapper.queryAllItemName();
        return lists;
    }
}
