package cat.wars.foodie.framework.model.response;

/**
 * Created by IntelliJ IDEA.
 * User: wars
 * Date: 10/21/19
 * Time: 11:38 AM
 * <p>
 * 全局基础响应接口. 请实现它或其实现
 */

public interface Response {

    /**
     * 默认操作成功
     */
    boolean SUCCESS = true;

    /**
     * 默认代码(操作成功)
     */
    int SUCCESS_CODE = 10000;

    /**
     * 默认提示信息(操作成功)
     */
    String SUCCESS_MESSAGE = "操作成功！";
}
