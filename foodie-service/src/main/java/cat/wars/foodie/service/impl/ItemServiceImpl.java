package cat.wars.foodie.service.impl;

import cat.wars.foodie.dao.*;
import cat.wars.foodie.framework.exception.ExceptionCast;
import cat.wars.foodie.framework.model.*;
import cat.wars.foodie.framework.model.enums.CommentLevelEnum;
import cat.wars.foodie.framework.model.response.FoodieCode;
import cat.wars.foodie.framework.model.response.item.ItemCommentCountsResult;
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
  private final ItemsCommentsMapper itemsCommentsMapper;

  public ItemServiceImpl(
      ItemsMapper mapper,
      ItemsImgMapper itemsImgMapper,
      ItemsSpecMapper itemsSpecMapper,
      ItemsParamMapper itemsParamMapper,
      ItemsCommentsMapper itemsCommentsMapper) {
    this.mapper = mapper;
    this.itemsImgMapper = itemsImgMapper;
    this.itemsSpecMapper = itemsSpecMapper;
    this.itemsParamMapper = itemsParamMapper;
    this.itemsCommentsMapper = itemsCommentsMapper;
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

  @Transactional(propagation = Propagation.SUPPORTS)
  int getItemCommentCountByLevel(String itemId, int level) {
    Example probe = new Example(ItemsComments.class);
    probe.createCriteria().andEqualTo("itemId", itemId).andEqualTo("commentLevel", level);

    return itemsCommentsMapper.selectCountByExample(probe);
  }

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public ItemCommentCountsResult itemCommentCounts(String id) {
    int goodCount = getItemCommentCountByLevel(id, CommentLevelEnum.GOOD.value);
    int normalCount = getItemCommentCountByLevel(id, CommentLevelEnum.NORMAL.value);
    int lowCount = getItemCommentCountByLevel(id, CommentLevelEnum.LOW.value);
    return new ItemCommentCountsResult(
        FoodieCode.SUCCESS, goodCount + normalCount + lowCount, goodCount, normalCount, lowCount);
  }
}
