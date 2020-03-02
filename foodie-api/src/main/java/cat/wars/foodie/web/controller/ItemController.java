package cat.wars.foodie.web.controller;

import cat.wars.foodie.framework.exception.ExceptionCast;
import cat.wars.foodie.framework.model.Items;
import cat.wars.foodie.framework.model.ItemsImg;
import cat.wars.foodie.framework.model.ItemsParam;
import cat.wars.foodie.framework.model.ItemsSpec;
import cat.wars.foodie.framework.model.response.FoodieCode;
import cat.wars.foodie.framework.model.response.ItemResult;
import cat.wars.foodie.framework.model.response.item.ItemCommentCountsResult;
import cat.wars.foodie.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isEmpty;

/**
 * @program: foodie
 * @description: Item controller
 * @author: Wars
 * @created: 2020/01/30 02:27
 */
@Api(tags = "客户端商品相关接口")
@RestController
@RequestMapping("/item")
public class ItemController {

  private final ItemService service;

  public ItemController(ItemService service) {
    this.service = service;
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "获取商品信息", notes = "商品展示数据获取")
  @ApiImplicitParam(
      name = "id",
      value = "Item id",
      required = true,
      paramType = "path",
      dataType = "string")
  public ItemResult getById(@PathVariable("id") String id) {
    if (isEmpty(id)) ExceptionCast.cast(FoodieCode.ITEM_NOT_EXISTS);

    Items item = service.getItem(id);
    List<ItemsImg> imgs = service.queryItemImgList(id);
    List<ItemsSpec> specs = service.queryItemSpecList(id);
    ItemsParam param = service.getItemParam(id);

    ItemResult result = new ItemResult();
    result.setItem(item);
    result.setImgs(imgs);
    result.setSpecs(specs);
    result.setParam(param);
    return result;
  }

  @GetMapping("/comment/counts/{itemId}")
  public ItemCommentCountsResult itemCommentCounts(@PathVariable("itemId") String id) {
    return service.itemCommentCounts(id);
  }
}
