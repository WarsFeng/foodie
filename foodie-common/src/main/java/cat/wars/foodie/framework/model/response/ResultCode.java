package cat.wars.foodie.framework.model.response;

/**
 * Created by IntelliJ IDEA.
 * User: wars
 * Date: 10/21/19
 * Time: 11:17 AM
 * 全局基础返回码
 */

public interface ResultCode {

    /**
     * 是否成功, true-操作成功, false-操作失败
     */
    boolean success();

    /**
     * 操作返回代码
     */
    int code();

    /**
     * 提示信息
     */
    String message();
}
