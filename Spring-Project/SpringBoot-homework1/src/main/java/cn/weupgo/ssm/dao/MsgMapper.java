package cn.weupgo.ssm.dao;

import cn.weupgo.ssm.po.Msg;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MsgMapper {

    List<Msg> queryMsgByDistrict(String district);
    List<Msg> queryAllMsg();
    public void insertMsg(Msg msg);
}
