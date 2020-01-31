package cat.wars.foodie.framework.model.response;

import cat.wars.foodie.framework.model.Items;
import cat.wars.foodie.framework.model.ItemsImg;
import cat.wars.foodie.framework.model.ItemsParam;
import cat.wars.foodie.framework.model.ItemsSpec;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @program: foodie
 * @description: Item response model
 * @author: Wars
 * @created: 2020/01/30 02:30
 */

@Getter
@Setter
public class ItemResult extends ResponseResult {

    private Items item;
    private List<ItemsImg> imgs;
    private List<ItemsSpec> specs;
    private ItemsParam param;
}
