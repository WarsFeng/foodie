package cat.wars.foodie.framework.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @program: foodie
 * @description: Two level category result
 * @author: Wars
 * @created: 2020/01/26 23:04
 */

@Getter
@Setter
public class SubCategoryResult {

    @ApiModelProperty("分类 Id")
    private Integer id;

    @ApiModelProperty("分类父 Id")
    private Integer pid;

    @ApiModelProperty("分类名称")
    private String name;

    @ApiModelProperty("子分类列表")
    private List<SubCategoryResult> children;
}
