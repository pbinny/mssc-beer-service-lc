package com.nims.msscbeerservice.web.mappers;

import com.nims.msscbeerservice.domain.Beer;
import com.nims.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

//@Mapper(componentModel = "spring", uses = DateMapper.class)
@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);

}
