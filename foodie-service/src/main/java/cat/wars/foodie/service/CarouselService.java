package cat.wars.foodie.service;

import cat.wars.foodie.framework.model.Carousel;
import cat.wars.foodie.framework.model.response.QueryResult;

/**
 * @program: foodie
 * @description: Index carousel service interface
 * @author: Wars
 * @created: 2019/12/29 20:09
 */
public interface CarouselService {

    QueryResult<Carousel> queryAll(int isShow);
}
