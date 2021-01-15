package cn.weupgo.homework.service;

import cn.weupgo.homework.po.PeItems;

import java.util.List;

public interface ItemService {

    List<PeItems> queryItemsByName(String itemName);

    void updateItem(PeItems peItems);

    PeItems queryItemsById(int itemId);

    List<PeItems> queryAllItems();

    List<String> queryAllItemName();
}
