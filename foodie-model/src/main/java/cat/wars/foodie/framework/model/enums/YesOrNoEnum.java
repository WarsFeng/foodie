package cat.wars.foodie.framework.model.enums;

/**
 * @program: foodie
 * @description: Yes or no enum
 * @author: Wars
 * @created: 2019/12/29 20:25
 */
public enum YesOrNoEnum {

    NO(0),
    YES(1);

    public final int value;

    YesOrNoEnum(int value) {
        this.value = value;
    }
}
