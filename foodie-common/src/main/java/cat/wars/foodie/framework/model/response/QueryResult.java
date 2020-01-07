package cat.wars.foodie.framework.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: wars
 * Date: 10/25/19
 * Time: 5:21 PM
 * Common query result model
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QueryResult<T> {

    private List<T> list;
    private long total;
}
