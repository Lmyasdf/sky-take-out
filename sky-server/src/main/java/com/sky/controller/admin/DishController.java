package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @PostMapping
    public Result save(@RequestBody DishDTO dishDTO) {
        log.info("新增菜品：{}", dishDTO);
        // 调用服务层新增菜品
        dishService.saveWithFlavor(dishDTO);
        return Result.success();
    }

    @GetMapping("/page")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {
        log.info("分页查询菜品：{}", dishPageQueryDTO);
        return Result.success(dishService.page(dishPageQueryDTO));
    }

    @GetMapping()
    public Result delete(@RequestParam List<Long>ids){
        log.info("删除菜品：{}", ids);
        dishService.delete(ids);
        return Result.success();
    }

    //根据菜品id查询菜品
    @GetMapping("/{id}")
    public Result<DishDTO> getByID(@PathVariable Long id){
        log.info("根据菜品id查询菜品：{}", id);
        DishDTO dishDTO = dishService.getById(id);
        return Result.success(dishDTO);
    }

//    修改菜品
    @PutMapping()
    public Result update(@RequestBody DishDTO dishDTO){
        log.info("修改菜品：{}", dishDTO);
        dishService.updateWithFlavor(dishDTO);
        return Result.success();
    }

}
