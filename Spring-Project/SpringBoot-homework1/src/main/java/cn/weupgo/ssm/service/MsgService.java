package cn.weupgo.ssm.service;


import cn.weupgo.ssm.po.Msg;

import java.util.List;


public interface MsgService {

    public void InsertMsg(Msg msg);

    public List<Msg> queryMsgByDistrict(String district);

    public List<Msg> queryAllMsg();
}
