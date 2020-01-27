package cat.wars.foodie.service.impl;

import cat.wars.foodie.dao.CarouselMapper;
import cat.wars.foodie.framework.model.Carousel;
import cat.wars.foodie.framework.model.response.QueryResult;
import cat.wars.foodie.service.CarouselService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: foodie
 * @description:
 * @author: Wars
 * @created: 2020/01/26 19:51
 */

@Service
public class CarouselServiceImpl implements CarouselService {

    private final CarouselMapper mapper;

    public CarouselServiceImpl(CarouselMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public QueryResult<Carousel> queryAll(int isShow) {
        Example example = new Example(Carousel.class);
        example.createCriteria()
                .andEqualTo("isShow", isShow);

        List<Carousel> carouselList = mapper.selectByExample(example);
        return new QueryResult<>(carouselList, carouselList.size());
    }
}
