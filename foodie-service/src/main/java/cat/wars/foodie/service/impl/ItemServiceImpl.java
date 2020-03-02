package cat.wars.foodie.service.impl;

import cat.wars.foodie.dao.ItemsImgMapper;
import cat.wars.foodie.dao.ItemsMapper;
import cat.wars.foodie.dao.ItemsParamMapper;
import cat.wars.foodie.dao.ItemsSpecMapper;
import cat.wars.foodie.framework.exception.ExceptionCast;
import cat.wars.foodie.framework.model.Items;
import cat.wars.foodie.framework.model.ItemsImg;
import cat.wars.foodie.framework.model.ItemsParam;
import cat.wars.foodie.framework.model.ItemsSpec;
import cat.wars.foodie.framework.model.response.FoodieCode;
import cat.wars.foodie.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: foodie
 * @description:
 * @author: Wars
 * @created: 2020/01/27 22:11
 */
@Service
public class ItemServiceImpl implements ItemService {

  private final ItemsMapper mapper;
  private final ItemsImgMapper itemsImgMapper;
  private final ItemsSpecMapper itemsSpecMapper;
  private final ItemsParamMapper itemsParamMapper;

  public ItemServiceImpl(
      ItemsMapper mapper,
      ItemsImgMapper itemsImgMapper,
      ItemsSpecMapper itemsSpecMapper,
      ItemsParamMapper itemsParamMapper) {
    this.mapper = mapper;
    this.itemsImgMapper = itemsImgMapper;
    this.itemsSpecMapper = itemsSpecMapper;
    this.itemsParamMapper = itemsParamMapper;
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public Items getItem(String id) {
    Items items;
    if (null == (items = mapper.selectByPrimaryKey(id)))
      ExceptionCast.cast(FoodieCode.ITEM_NOT_EXISTS);

    return items;
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public List<ItemsImg> queryItemImgList(String id) {
    if (!mapper.existsWithPrimaryKey(id)) ExceptionCast.cast(FoodieCode.ITEM_NOT_EXISTS);

    Example example = new Example(ItemsImg.class);
    example.createCriteria().andEqualTo("itemId", id);

    return itemsImgMapper.selectByExample(example);
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public List<ItemsSpec> queryItemSpecList(String id) {
    if (!mapper.existsWithPrimaryKey(id)) ExceptionCast.cast(FoodieCode.ITEM_NOT_EXISTS);

    Example example = new Example(ItemsSpec.class);
    example.createCriteria().andEqualTo("itemId", id);

    return itemsSpecMapper.selectByExample(example);
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public ItemsParam getItemParam(String id) {
    if (!mapper.existsWithPrimaryKey(id)) ExceptionCast.cast(FoodieCode.ITEM_NOT_EXISTS);

    Example example = new Example(ItemsParam.class);
    example.createCriteria().andEqualTo("itemId", id);

    return itemsParamMapper.selectOneByExample(example);
  }
}
