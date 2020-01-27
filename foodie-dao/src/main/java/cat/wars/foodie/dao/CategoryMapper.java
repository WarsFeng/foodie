package cat.wars.foodie.dao;

import cat.wars.foodie.framework.model.Category;
import cat.wars.foodie.framework.model.response.IndexRECCategoryResponseResult;
import cat.wars.foodie.framework.model.response.SubCategoryResult;
import cat.wars.foodie.mybatis.BasicMapper;

import java.util.List;

public interface CategoryMapper extends BasicMapper<Category> {

    List<SubCategoryResult> getSubList(int rootId);

    IndexRECCategoryResponseResult getIndexRECCategory(int rootId);
}