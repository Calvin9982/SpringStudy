package cn.weupgo.ssm.service;

import cn.weupgo.ssm.dao.MsgMapper;
import cn.weupgo.ssm.po.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsgServiceImpl implements MsgService{

    @Autowired
    private MsgMapper msgMapper;
    @Override
    public void InsertMsg(Msg msg) {
         msgMapper.insertMsg(msg);
    }

    @Override
    public List<Msg> queryMsgByDistrict(String district) {
        List<Msg> msg= msgMapper.queryMsgByDistrict(district);
        return msg;
    }

    @Override
    public List<Msg> queryAllMsg() {
        List<Msg> msg= msgMapper.queryAllMsg();
        return msg;
    }
}
