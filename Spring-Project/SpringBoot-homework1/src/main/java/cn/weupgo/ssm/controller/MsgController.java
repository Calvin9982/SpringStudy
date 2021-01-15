package cn.weupgo.ssm.controller;

import cn.weupgo.ssm.po.Msg;
import cn.weupgo.ssm.service.MsgService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
public class MsgController {

    @Autowired(required = false)
    MsgService msgService;


    @RequestMapping("/addMsg")
    public String addMsg() {
        return "addMsg";
    }

    @RequestMapping("/insertMsg")

    public String add(HttpServletRequest request) throws ParseException {
        Msg msg = new Msg();

        String time = request.getParameter("monitor_time");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateTime = null;
        dateTime = simpleDateFormat.parse(time);
        msg.setMonitor_time(dateTime);

        msg.setPm10(Integer.valueOf(request.getParameter("pm10")));
        msg.setPm25(Integer.valueOf(request.getParameter("pm25")));
        msg.setDistrict(request.getParameter("district"));

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        msg.setCreate_date(simpleDateFormat.parse(dateFormat.format(calendar.getTime())));
        msg.setMonitoring_station(request.getParameter("monitoring_station"));
        msgService.InsertMsg(msg);
        return "index";
    }
    @RequestMapping("/index")
    public String index(){

        return "redirect:queryMsg";
    }

    @RequestMapping("/queryMsg")
    public ModelAndView queryMsg(String district){

        ModelAndView modelAndView = new ModelAndView();
        List<Msg> msg=null;
        if(district==null){
            msg=null;
        }
        else if (district.equals("不限")){
             msg= msgService.queryAllMsg();
        }
        else{
             msg= msgService.queryMsgByDistrict(district);
        }
        modelAndView.addObject("msg",msg);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
