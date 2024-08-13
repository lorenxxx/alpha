package com.clawchat.alpha.web;

import com.clawchat.alpha.common.response.Result;
import com.clawchat.alpha.entity.Demo;
import com.clawchat.alpha.service.IDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @GetMapping()
    public Result<Demo> demo(@RequestParam Integer id) {
        Demo demo = demoService.getDemoByID(id);
        return Result.success("ok", demo);
    }

}
