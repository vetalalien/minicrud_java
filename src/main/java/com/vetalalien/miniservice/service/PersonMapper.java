package com.vetalalien.miniservice.service;


import com.vetalalien.miniservice.dto.Person;
import com.vetalalien.miniservice.entity.PersonEntity;
import com.vetalalien.miniservice.service.mapper.BeanMapper;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.IoC;
import fr.xebia.extras.selma.Mapper;

@Mapper(
        withIoC = IoC.SPRING,
        withIoCServiceName = "productMapper",
        withIgnoreNullValue = true,
        withIgnoreMissing = IgnoreMissing.ALL,
        withCustomFields = {
                @Field(value = {"interestCorrectionMethod", "interestCorrectionMethod"},
                        withCustom = InterestCorrectionMapper.class)
        }
)
public interface PersonMapper extends BeanMapper<Person, PersonEntity> {

}

