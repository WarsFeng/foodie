package cat.wars.foodie.framework.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @program: foodie
 * @description: Index recommened category response model
 * @author: Wars
 * @created: 2020/01/27 22:38
 */

@Getter
@Setter
@ApiModel("首页分类推荐")
public class IndexRECCategoryResponseResult extends ResponseResult {

    @ApiModelProperty("分类 Id")
    private Integer id;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("分类口号")
    private String slogan;

    @ApiModelProperty("分类图片")
    private String img;

    @ApiModelProperty("分类背景颜色")
    private String bgColor;

    @ApiModelProperty("分类推荐商品")
    private List<IndexRECItemResult> items;
}
