package com.fursuit_studio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("studioName", "梦幻兽装工作室");
        model.addAttribute("slogan", "为您打造独一无二的兽装形象");
        model.addAttribute("featuredSuits", new String[]{
                "火焰狐狸套装",
                "星空狼套装",
                "森林鹿套装"
        });
        model.addAttribute("services", new String[]{
                "全装定制",
                "部分配件制作",
                "兽装维修与保养",
                "3D打印服务"
        });
        return "index";
    }
}