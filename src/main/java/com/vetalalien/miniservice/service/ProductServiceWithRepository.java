package com.vetalalien.miniservice.service;


import com.vetalalien.miniservice.dto.Person;
import com.vetalalien.miniservice.entity.PersonEntity;
import com.vetalalien.miniservice.repository.BaseRepository;
import com.vetalalien.miniservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Primary
@Slf4j
@RequiredArgsConstructor //это lombok, он генерирует геттеры/сеттеры, конструкторы, ToString, HashCode, etc... - ну и автоматом инджектит имеющиеся бины
public class ProductServiceWithRepository extends AbstractCrudService<Person, PersonEntity>
        implements PersonService {



    private static final String PERCENTAGE_TYPE_CODE_FIELD = "percentRateTypeCode";

    private static final Long DEFAULT_RELEASE_VERSION = 1L;

    private static final String GROUP_BY_STATE = "statusId";

    private static final String GROUP_BY_TYPE = "typeId";

    private static final String LIST_OF_REVISIONS = "listOfRevisions";

    private final PersonRepository personRepository;


    private final PersonMapper personMapper;

    @Override
    protected PersonMapper getMapper() {
        return personMapper;
    }
/*
        protected BeanMapper<Option, ProductEntity> getOptionMapper() {
            return optionMapper;
        }

        protected BeanMapper<MaxCreditToPledge, MaxCreditToPledgeEntity> getMaxCreditToPledgeMapper() {
            return maxCreditToPledgeMapper;
        }
    */
    @Override
    protected BaseRepository<PersonEntity> getRepository() {
        return personRepository;
    }


//    @Autowired
//    public void setProductRepository(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

//    @Autowired
//    public void setProductMapper(ProductMapper productMapper) {
//        this.productMapper = productMapper;
//    }


            //that's mine code
            /*Person person = new Person();
            person.setId(entity.getId());
            person.setFirstName(entity.getFirstName());
            person.setLastName(entity.getLastName());
            person.setMiddleName(person.getMiddleName());*/
            // that's mine code
            //dtos.add(person);

    @Override
    @Transactional(readOnly = true)
    public Collection<Person> findAll() {
        Iterable<PersonEntity> entities = this.getRepository().findAll();
        Collection<Person> dtos = new ArrayList<>();
        for (PersonEntity entity : entities) {
            Person dto = personMapper.mapToDto(entity);
            dtos.add(dto);
        }
        return dtos;
    }

    //TODO: Change PersonEntity to Person (for the sake of depending excluding)
    @Override
    public PersonEntity findMyFirst() {
        return personRepository.findMyFirst();
    }
}

