package cn.weupgo.homework.controller;

import cn.weupgo.homework.po.ItemTypes;
import cn.weupgo.homework.po.PeItems;
import cn.weupgo.homework.service.ItemService;
import cn.weupgo.homework.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ExamController {
    @Autowired
    ItemService itemService;
    @Autowired
    TypeService typeService;

    /*
       主页进入的入口
     */
    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam(defaultValue = "2") int pageSize){
        PageHelper.startPage(pageNum,3);

        ModelAndView modelAndView=new ModelAndView();
//        List<String> nameLists= itemService.queryAllItemName();
//        modelAndView.addObject("nameLists",nameLists);

        List<PeItems> items = itemService.queryAllItems();
//        modelAndView.addObject("items",items);

        PageInfo<PeItems> pageInfo = new PageInfo<>(items);

        System.out.println(pageInfo);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /*
        主页中的查询功能
     */

    @RequestMapping("/queryItem")
    public ModelAndView queryItem(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        String itemName=request.getParameter("itemName");
        List<String> nameLists= itemService.queryAllItemName();
        modelAndView.addObject("nameLists",nameLists);
        List<PeItems> items = itemService.queryItemsByName(itemName);
        modelAndView.setViewName("index");
        modelAndView.addObject("items",items);
        return modelAndView;
    }
    /*
         修改体检项目信息前
         进行信息查询
         并显示到修改信息的页面
     */
    @RequestMapping("/updateItem")
    public ModelAndView updateItem(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView();
        int itemId =  Integer.parseInt(request.getParameter("itemId"));
        PeItems peItems=itemService.queryItemsById(itemId);
        List<ItemTypes> list = typeService.queryAllType();
        modelAndView.addObject("peItems",peItems);
        modelAndView.addObject("typeLists",list);
        modelAndView.addObject("itemId",itemId);
        modelAndView.setViewName("updateMsg");
        return modelAndView;
    }

    /*
       对信息进行修改
     */

    @RequestMapping(value = "/updateMsg")
    public String updateMsg(HttpServletRequest request){
        PeItems peItems =new PeItems();

        String itemName=request.getParameter("itemName");
        peItems.setItemName(itemName);

        peItems.setItemId( Integer.parseInt(request.getParameter("itemId")));
        peItems.setInfo(request.getParameter("info"));
        peItems.setPrice(Double.parseDouble(request.getParameter("price")));
        peItems.setRef(request.getParameter("ref"));

        String typeName=request.getParameter("typeName");
        int typeId=typeService.queryTypeIdByName(typeName);
        peItems.setTypeId(typeId);

        int neccssary=1;
        if(request.getParameter("isNeccssary")==null)
        {
            neccssary=0;
        }
        peItems.setNeccssary(neccssary);

        itemService.updateItem(peItems);
        return "redirect:index";
    }
    /*
        进入增加信息的页面
     */
    @RequestMapping("/addMsg")
    public ModelAndView addMsg(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("addMsg");
        List<ItemTypes> list = typeService.queryAllType();
        modelAndView.addObject("typeLists",list);
        return modelAndView;
    }

}
