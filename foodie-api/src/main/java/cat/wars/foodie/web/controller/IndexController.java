package cat.wars.foodie.web.controller;

import cat.wars.foodie.framework.model.Carousel;
import cat.wars.foodie.framework.model.Category;
import cat.wars.foodie.framework.model.enums.YesOrNo;
import cat.wars.foodie.framework.model.response.FoodieCode;
import cat.wars.foodie.framework.model.response.QueryResponseResult;
import cat.wars.foodie.framework.model.response.SubCategoryResult;
import cat.wars.foodie.service.CarouselService;
import cat.wars.foodie.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: foodie
 * @description: Index controller
 * @author: Wars
 * @created: 2019/12/29 20:22
 */
@Api(tags = "客户端首页相关接口")
@RestController
@RequestMapping("/index")
public class IndexController {

    private final CarouselService service;

    public IndexController(CarouselService service) {
        this.service = service;
    }

    @GetMapping("/carousel")
    @ApiOperation(value = "首页轮播图列表", notes = "获取所有开启状态的轮播图")
    public QueryResponseResult<Carousel> carousel() {
        return new QueryResponseResult<>(FoodieCode.SUCCESS, carouselService.queryAll(YesOrNo.YES.value));
    }
}
