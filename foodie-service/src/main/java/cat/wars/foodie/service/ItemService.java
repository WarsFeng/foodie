package cat.wars.foodie.service;

import cat.wars.foodie.framework.model.Items;
import cat.wars.foodie.framework.model.ItemsImg;
import cat.wars.foodie.framework.model.ItemsParam;
import cat.wars.foodie.framework.model.ItemsSpec;

import java.util.List;

/**
 * @program: foodie
 * @description: Item service interface
 * @author: Wars
 * @created: 2020/01/27 21:52
 */
public interface ItemService {

    /**
     * Get item by id
     *
     * @param id item id
     * @return cat.wars.foodie.framework.model.Items
     */
    Items getItem(String id);

    /**
     * Query item img
     *
     * @param id item id
     * @return java.util.List {@link ItemsImg}
     */
    List<ItemsImg> queryItemImgList(String id);

    /**
     * Query item spec
     *
     * @param id item id
     * @return java.util.List {@link ItemsSpec}
     */
    List<ItemsSpec> queryItemSpecList(String id);

    /**
     * Get item param
     *
     * @param id item id
     * @return cat.wars.foodie.framework.model.ItemsParam
     */
    ItemsParam getItemParam(String id);
}
