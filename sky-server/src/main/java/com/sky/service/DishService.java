package com.sky.service;

import java.util.List;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;


public interface DishService {
    public void saveWithFlavor(DishDTO dishDTO);

    public PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    public void deleteBatch(List<Long> ids);

    public DishVO getByIdWithFlavor(Long id);

	public void updateWithFlavor(DishDTO dishDTO);

    public List<Dish> list(Long categoryId);

    public void startOrStop(Integer status, Long id);
}
