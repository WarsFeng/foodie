package cat.wars.foodie.service.impl;

import cat.wars.foodie.dao.CarouselMapper;
import cat.wars.foodie.framework.model.Carousel;
import cat.wars.foodie.service.CarouselService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: foodie
 * @description: Index carousel basic implementation
 * @author: Wars
 * @created: 2019/12/29 20:10
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    private final CarouselMapper mapper;

    public CarouselServiceImpl(CarouselMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Carousel> findAll(int isShow) {
        Example example = new Example(Carousel.class);
        example.createCriteria()
                .andEqualTo("isShow", isShow);

        example.orderBy("sort");
        return mapper.selectByExample(example);
    }
}
