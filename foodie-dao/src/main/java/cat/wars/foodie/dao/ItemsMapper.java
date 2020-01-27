package cat.wars.foodie.dao;

import cat.wars.foodie.framework.model.Items;
import cat.wars.foodie.framework.model.response.IndexRECItemResult;
import cat.wars.foodie.mybatis.BasicMapper;

import java.util.List;

public interface ItemsMapper extends BasicMapper<Items> {

    List<IndexRECItemResult> getIndexRecommendItems(int categoryRootId);
}