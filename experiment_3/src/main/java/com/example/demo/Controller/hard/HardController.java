package com.example.demo.Controller.hard;

import com.example.demo.Pojo.entity.HardEntity;
import com.example.demo.Pojo.ret.Result;
import com.example.demo.Service.hard.HardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MZ_Li
 * @date 2024/6/12 11:01
 */
@Controller
@Slf4j
@RequestMapping("/demo/hard")
public class HardController {
    private final String prefix = "/view/modules/management/hard";

    @Resource
    private HardService hardService;

    @GetMapping
    public String hard() {
        return prefix + "/list";
    }

    @ResponseBody
    @GetMapping("/list")
    public Result<List<HardEntity>> list() {
        return Result.success(hardService.list());
    }

    @ResponseBody
    @GetMapping("remove/{id}")
    public Result<?> remove(@PathVariable("id") Long id) {
        hardService.remove(id);
        return Result.success();
    }
}
