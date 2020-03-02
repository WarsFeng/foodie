package cat.wars.foodie.framework.model.response.item;

import cat.wars.foodie.framework.model.response.ResponseResult;
import cat.wars.foodie.framework.model.response.ResultCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @program: foodie
 * @description:
 * @author: Wars
 * @created: 2020-03-02 13:11
 */
@Getter
@Setter
@ApiModel("商品评论数量响应")
public class ItemCommentCountsResult extends ResponseResult {

  public ItemCommentCountsResult(ResultCode resultCode, int total, int good, int normal, int low) {
    super(resultCode);
    this.total = total;
    this.good = good;
    this.normal = normal;
    this.low = low;
  }

  @ApiModelProperty("评价总数")
  private int total;

  @ApiModelProperty("好评数量")
  private int good;

  @ApiModelProperty("中评数量")
  private int normal;

  @ApiModelProperty("差评数量")
  private int low;
}
