package cn.weupgo.homework.dao;

import cn.weupgo.homework.po.PeItems;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

     List<PeItems> queryItemsByName(String itemName);

     List<PeItems> queryAllItems();

     void updateItem(PeItems peItems);

     PeItems queryItemsById(int itemId);


     List<String> queryAllItemName();
}
