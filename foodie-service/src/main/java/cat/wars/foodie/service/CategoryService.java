package cat.wars.foodie.service;

import cat.wars.foodie.framework.model.Category;
import cat.wars.foodie.framework.model.response.IndexRECCategoryResponseResult;
import cat.wars.foodie.framework.model.response.QueryResult;
import cat.wars.foodie.framework.model.response.SubCategoryResult;

/**
 * @program: foodie
 * @description: Index category service interface
 * @author: Wars
 * @created: 2020/01/26 15:03
 */
public interface CategoryService {

    /**
     * Query all root level category
     *
     * @return cat.wars.foodie.framework.model.response.QueryResponseResult {@link Category}
     */
    QueryResult<Category> queryAllRootCategory();

    /**
     * Get sub category list
     *
     * @param rootId root level id
     * @return cat.wars.foodie.framework.model.response.QueryResult {@link SubCategoryResult}
     */
    QueryResult<SubCategoryResult> getSubCategoryByRoot(int rootId);


    /**
     * Get index recommend category( include items )
     *
     * @param rootId root level id
     * @return cat.wars.foodie.framework.model.response.IndexRECCategoryResponseResult
     */
    IndexRECCategoryResponseResult getIndexRECCategory(int rootId);
}
