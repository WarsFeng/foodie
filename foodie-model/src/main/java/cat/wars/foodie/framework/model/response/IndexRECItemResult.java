package cat.wars.foodie.framework.model.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: foodie
 * @description: Index recommend item response model
 * @author: Wars
 * @created: 2020/01/27 22:07
 */

@Getter
@Setter
@ApiModel("首页推荐商品")
public class IndexRECItemResult {

    @ApiModelProperty("商品 Id")
    private String id;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品图片 Url")
    private String imageUrl;
}
