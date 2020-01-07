package cat.wars.foodie.service;

import cat.wars.foodie.framework.model.Carousel;

import java.util.List;

/**
 * @program: foodie
 * @description: Index carousel service interface
 * @author: Wars
 * @created: 2019/12/29 20:09
 */
public interface CarouselService {

    List<Carousel> findAll(int isShow);
}
