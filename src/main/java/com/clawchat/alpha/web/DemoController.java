package com.clawchat.alpha.web;

import com.clawchat.alpha.common.response.Result;
import com.clawchat.alpha.dto.CreateDemoDTO;
import com.clawchat.alpha.dto.UpdateDemoDTO;
import com.clawchat.alpha.entity.Demo;
import com.clawchat.alpha.service.IDemoService;
import com.clawchat.alpha.util.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @PostMapping
    public Result<Integer> createDemo(@RequestBody CreateDemoDTO createDemoDTO) {
        Demo demo = BeanCopyUtil.copy(createDemoDTO, Demo.class);
        Integer id = demoService.createDemo(demo);
        return Result.success(id);
    }

    @DeleteMapping("/{id}")
    public Result<Integer> deleteDemoById(@PathVariable Integer id) {
        Integer rowsAffected = demoService.deleteDemoById(id);
        return Result.success(rowsAffected);
    }

    @PutMapping
    public Result<Integer> updateDemo(@RequestBody UpdateDemoDTO updateDemoDTO) {
        Demo demo = BeanCopyUtil.copy(updateDemoDTO, Demo.class);
        Integer rowsAffected = demoService.updateDemo(demo);
        return Result.success(rowsAffected);
    }

    @GetMapping("/{id}")
    public Result<Demo> getDemoById(@PathVariable Integer id) {
        Demo demo = demoService.getDemoById(id);
        return Result.success(demo);
    }

    @GetMapping()
    public Result<Demo> queryDemoByIds(@RequestParam("ids") List<Integer> ids) {
        List<Demo> demos = demoService.queryDemoByIds(ids);
        return Result.success(demos);
    }

}
