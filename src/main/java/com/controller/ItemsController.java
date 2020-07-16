package com.controller;

import com.pojo.Items;
import com.service.ItemsService;
import com.sun.deploy.net.HttpResponse;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ItemsController {
    @Autowired
    ItemsService itemsService;

    @RequestMapping("/findAll")
    public String findAll(String query, Integer pageNow,Model model){

        PageVo vo =itemsService.findAll(query,pageNow);
        model.addAttribute("vo",vo);
        return "itemsList";
    }

    @RequestMapping("/add")
    public String add(Items items, MultipartFile file) throws IOException{
        if (file!=null){
            String oldName=file.getOriginalFilename();
            if (oldName!=null&&oldName.length()>0){
                String newName= UUID.randomUUID()+oldName.substring(oldName.lastIndexOf("."));
                file.transferTo(new File("E:/SSM/day03/temp/"+newName));
                items.setPic("/pic/"+newName);
            }
        }
        itemsService.add(items);
        return "redirect:findAll";
    }

    @RequestMapping("/update")
    public String update(Items items,MultipartFile file) throws IOException {
        if (file!=null){
            String oldName=file.getOriginalFilename();
            if (oldName!=null&&oldName.length()>0){
                String newName= UUID.randomUUID()+oldName.substring(oldName.lastIndexOf("."));
                file.transferTo(new File("E:/SSM/day03/temp/"+newName));
                items.setPic("/pic/"+newName);
            }
        }
        itemsService.update(items);
        return "redirect:findAll";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") Integer[] ids) throws IOException {
        itemsService.delete(ids);
        return "redirect:findAll";
    }
    @RequestMapping("/findOne")
    public String findOne(Integer id,Model model){
        Items items=itemsService.findOne(id);
        model.addAttribute("items",items);
        return "editItem";
    }
}
