package cat.wars.foodie.web.controller;

import cat.wars.foodie.framework.model.Carousel;
import cat.wars.foodie.framework.model.enums.YesOrNo;
import cat.wars.foodie.framework.model.response.FoodieCode;
import cat.wars.foodie.framework.model.response.QueryResponseResult;
import cat.wars.foodie.framework.model.response.QueryResult;
import cat.wars.foodie.service.CarouselService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @ApiOperation(value = "获取首页轮播图列表", notes = "获取所有开启状态的轮播图")
    public QueryResponseResult<Carousel> carousel() {
        List<Carousel> resultList = service.findAll(YesOrNo.YES.value);
        return new QueryResponseResult<>(FoodieCode.SUCCESS, new QueryResult<>(resultList, resultList.size()));
    }
}
