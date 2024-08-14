package com.clawchat.alpha.web;

import com.clawchat.alpha.common.response.APIResponse;
import com.clawchat.alpha.dto.CreateDemoDTO;
import com.clawchat.alpha.dto.UpdateDemoDTO;
import com.clawchat.alpha.entity.Demo;
import com.clawchat.alpha.service.IDemoService;
import com.clawchat.alpha.util.BeanCopyUtil;
import com.google.common.collect.Lists;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(name = "Demo API", description = "演示实例")
@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @Operation(summary = "Post方法示例", description = "Post方法通常用于新增")
    @PostMapping
    public APIResponse<Integer> createDemo(@Validated @RequestBody CreateDemoDTO createDemoDTO) {
        Demo demo = BeanCopyUtil.copy(createDemoDTO, Demo.class);
        Integer id = demoService.createDemo(demo);
        return APIResponse.success(id);
    }

    @Operation(summary = "Delete方法示例", description = "Delete方法通常用于删除")
    @DeleteMapping("/{id}")
    public APIResponse<Integer> deleteDemoById(@PathVariable Integer id) {
        Integer rowsAffected = demoService.deleteDemoById(id);
        return APIResponse.success(rowsAffected);
    }

    @Operation(summary = "Put方法示例", description = "Put方法通常用于更新")
    @PutMapping
    public APIResponse<Integer> updateDemo(@RequestBody UpdateDemoDTO updateDemoDTO) {
        Demo demo = BeanCopyUtil.copy(updateDemoDTO, Demo.class);
        Integer rowsAffected = demoService.updateDemo(demo);
        return APIResponse.success(rowsAffected);
    }

    @Operation(summary = "Get方法示例 - PathVariable", description = "Get方法通常用于查询")
    @GetMapping("/{id}")
    public APIResponse<Demo> getDemoById(@PathVariable Integer id) {
        if (id <= 0) {
            throw new IllegalArgumentException("param id must be greater than 0");
        }
        Demo demo = demoService.getDemoById(id);
        return APIResponse.success(demo);
    }

    @Operation(summary = "Get方法示例 - RequestParam", description = "Get方法通常用于查询")
    @Parameter(name = "name", description = "名称")
    @GetMapping()
    public APIResponse<Demo> queryDemoByIds(@Nullable @RequestParam("name") String name) {
        Demo demo = demoService.getDemoByName(name);
        return APIResponse.success(demo);
    }

    @Operation(summary = "上传文件示例")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public APIResponse<String> upload(@RequestPart("file") MultipartFile file) {
        log.info("file name: {}", file.getName());
        log.info("content type: {}", file.getContentType());
        log.info("file size: {}", file.getSize());

        String url = "https://cos...";
        return APIResponse.success(url);
    }

    @Operation(summary = "批量上传文件示例")
    @PostMapping(value = "/batchUpload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public APIResponse<List<String>> batchUpload(@RequestPart("file") MultipartFile[] files) {
        for (MultipartFile file : files) {
            log.info("file name: {}, file size: {}", file.getName(), file.getSize());
        }

        List<String> urls = Lists.newArrayList("https://cos...", "https://cos...");
        return APIResponse.success(urls);
    }

}
