package cat.wars.foodie.framework.model.response;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * User: wars
 * Date: 10/25/19
 * Time: 5:20 PM
 * Common query result result
 */

@Getter
@Setter
public class QueryResponseResult<T> extends ResponseResult {

    // T - list type
    private QueryResult<T> queryResult;

    public QueryResponseResult(ResultCode resultCode, QueryResult<T> queryResult) {
        super(resultCode);
        this.queryResult = queryResult;
    }
}
