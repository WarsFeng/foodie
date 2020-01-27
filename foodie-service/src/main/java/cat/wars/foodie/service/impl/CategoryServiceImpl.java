package cat.wars.foodie.service.impl;

import cat.wars.foodie.dao.CategoryMapper;
import cat.wars.foodie.dao.ItemsMapper;
import cat.wars.foodie.framework.exception.ExceptionCast;
import cat.wars.foodie.framework.model.Category;
import cat.wars.foodie.framework.model.enums.CategoryType;
import cat.wars.foodie.framework.model.response.*;
import cat.wars.foodie.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: foodie
 * @description: Index category basic implementation
 * @author: Wars
 * @created: 2020/01/26 15:03
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper mapper;
    private final ItemsMapper itemsMapper;

    public CategoryServiceImpl(CategoryMapper mapper, ItemsMapper itemsMapper) {
        this.mapper = mapper;
        this.itemsMapper = itemsMapper;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public QueryResult<Category> queryAllRootCategory() {
        Example example = new Example(Category.class);
        example.createCriteria()
                .andEqualTo("type", CategoryType.ROOT.type); // Root level category

        List<Category> categoryList = mapper.selectByExample(example);
        return new QueryResult<>(categoryList, categoryList.size());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public QueryResult<SubCategoryResult> getSubCategoryByRoot(int rootId) {
        if (!mapper.existsWithPrimaryKey(rootId)) ExceptionCast.cast(FoodieCode.CATEGORY_NOT_EXISTS);

        List<SubCategoryResult> subList = mapper.getSubList(rootId);
        return new QueryResult<>(subList, subList.size());
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public IndexRECCategoryResponseResult getIndexRECCategory(int rootId) {
        if (!mapper.existsWithPrimaryKey(rootId)) ExceptionCast.cast(FoodieCode.CATEGORY_NOT_EXISTS);

        IndexRECCategoryResponseResult result = mapper.getIndexRECCategory(rootId);
        List<IndexRECItemResult> items = itemsMapper.getIndexRecommendItems(rootId);
        if (!items.isEmpty()) result.setItems(items);
        return result;
    }
}
