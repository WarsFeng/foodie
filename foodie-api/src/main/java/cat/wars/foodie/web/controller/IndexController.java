package cat.wars.foodie.web.controller;

import cat.wars.foodie.framework.model.Carousel;
import cat.wars.foodie.framework.model.Category;
import cat.wars.foodie.framework.model.enums.YesOrNoEnum;
import cat.wars.foodie.framework.model.response.FoodieCode;
import cat.wars.foodie.framework.model.response.IndexRECCategoryResponseResult;
import cat.wars.foodie.framework.model.response.QueryResponseResult;
import cat.wars.foodie.framework.model.response.SubCategoryResult;
import cat.wars.foodie.service.CarouselService;
import cat.wars.foodie.service.CategoryService;
import cat.wars.foodie.service.ItemService;
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

    private final CarouselService carouselService;
    private final CategoryService categoryService;
    private final ItemService itemService;

    public IndexController(CarouselService carouselService, CategoryService categoryService, ItemService itemService) {
        this.carouselService = carouselService;
        this.categoryService = categoryService;
        this.itemService = itemService;
    }

    @GetMapping("/carousel")
    @ApiOperation(value = "首页轮播图列表", notes = "获取所有开启状态的轮播图")
    public QueryResponseResult<Carousel> carousel() {
        return new QueryResponseResult<>(FoodieCode.SUCCESS, carouselService.queryAll(YesOrNoEnum.YES.value));
    }

    @GetMapping("/category")
    @ApiOperation(value = "商品分类列表（一级分类）", notes = "获取商品一级分类")
    public QueryResponseResult<Category> category() {
        return new QueryResponseResult<>(FoodieCode.SUCCESS, categoryService.queryAllRootCategory());
    }

    @GetMapping("/subCategory/{rootId}")
    @ApiOperation(value = "获取商品二级以及其子分类列表", notes = "获取商品二级以及其子分类列表")
    public QueryResponseResult<SubCategoryResult> subCategory(@PathVariable("rootId") int rootId) {
        return new QueryResponseResult<>(FoodieCode.SUCCESS, categoryService.getSubCategoryByRoot(rootId));
    }

    @GetMapping("/recommend/category/{rootId}")
    @ApiOperation(value = "获取首页分类商品推荐", notes = "分类 Id 获取首页商品推荐")
    public IndexRECCategoryResponseResult recommendCategory(@PathVariable("rootId") int rootId) {
        return categoryService.getIndexRECCategory(rootId);
    }
}
