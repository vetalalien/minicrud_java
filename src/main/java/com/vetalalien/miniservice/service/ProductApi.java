package com.vetalalien.miniservice.service;

import com.vetalalien.miniservice.dto.Person;
//import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * This "/product" is a workaround.
 * see for tails https://github.com/spring-cloud/spring-cloud-netflix/issues/537
 *
 * It appears that @RequestMapping is also required to be on this interface.
 * Definition on only method level mapping does not help.
 *
 * Also see thsi for details. RequestMapping is not actually used as clz.getInterfaces().length >0 in line 111:
 // https://github.com/spring-cloud/spring-cloud-netflix/commit/726f355e9c946273838a71c86a6287cb1272577b#diff-4572c388fb86bc5ec1836dc636735b03
 */
//@FeignClient("product-service/product")
public interface ProductApi extends CrudApiInterface<Person, Long> {
    /*

    @CrossOrigin
    @RequestMapping(
            value = {"/findByCode"},
            method = {RequestMethod.GET},
            produces = {"application/json"}
    )
    NamedDto findByCode(@RequestParam("code") String code);

    @CrossOrigin
    @RequestMapping(
            value = {"/findOptionByCode"},
            method = {RequestMethod.GET},
            produces = {"application/json"}
    )
    NamedDto findOptionByCode(@RequestParam("code") String code);

    @Deprecated
    @CrossOrigin
    @RequestMapping(
            value = {"/active"},
            method = {RequestMethod.GET},
            produces = {"application/json"}
    )
    Collection<ExtendedNamedDto> findActiveProduct();

    @CrossOrigin
    @RequestMapping(
            value = {"/active/{productType}"},
            method = {RequestMethod.GET},
            produces = {"application/json"}
    )
    Collection<ExtendedNamedDto> findActiveProduct(@PathVariable("productType") String productType);

    @CrossOrigin
    @RequestMapping(
            value = {"/findProductCodeByIds"},
            method = {RequestMethod.GET},
            produces = {"application/json"}
    )
    Map<Long, String> findProductCodesById(@RequestParam("ids") List<Long> ids);

    @RequestMapping(value = "/listActiveProducts", method = RequestMethod.POST)
    Collection<ActiveProductDto> getListActiveProducts(
            @RequestBody ActiveProductFilterDto filter);

    @RequestMapping(value = "/{productId}/activeOptions", method = RequestMethod.POST)
    Collection<OptionWithSubOptions> getActiveProductOptions(@PathVariable("productId") Long productId,
                                                             @RequestBody ProductOptionFilterDto filter);

    @RequestMapping(value = "/activeProductsExpress", method = RequestMethod.POST)
    Collection<ActiveProductDto> getActiveProductsExpress(
            @RequestBody ActiveProductFilterDto filter);

    @RequestMapping(value = "/{productId}/productOptionsExpress", method = RequestMethod.POST)
    Collection<OptionWithSubOptions> getProductOptionsExpress(@PathVariable("productId") Long productId,
                                                              @RequestBody ProductOptionFilterDto filter);

    @GetMapping(value = "/download")
    void downloadProducts(@RequestParam(value = "correlationId") String correlationId);

    @GetMapping(value = "/findProductByCodeAndReview")
    Product findProductByCodeAndReview(@RequestParam(value = "code") String code,
                                       @RequestParam(value = "relevanceDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate review);

    @GetMapping(value = "/releases")
    Collection<LkiProduct> findByProductTypeAndStatus(
            @RequestParam(value = "type", required = false) ProductType productType,
            @RequestParam(value = "status", required = false) ProductStatus status
    );

     */
}

