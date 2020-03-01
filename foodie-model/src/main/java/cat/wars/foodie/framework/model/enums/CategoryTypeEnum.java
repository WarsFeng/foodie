package cat.wars.foodie.framework.model.enums;

/**
 * @program: foodie
 * @description: Category type
 * @author: Wars
 * @created: 2020/01/26 15:15
 */
public enum CategoryTypeEnum {

    ROOT(1, "一级大分类");

    public final Integer type;
    public final String value;

    CategoryTypeEnum(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
