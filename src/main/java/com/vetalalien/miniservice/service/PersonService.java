package com.vetalalien.miniservice.service;


import com.vetalalien.miniservice.controllers.CrudService;
import com.vetalalien.miniservice.dto.Person;

public interface PersonService extends CrudService<Person> {
/*
    Product approve(Long id);

    void removeOption(Long productId, List<Long> optionIds);

    void insertOption(Long productId, List<Long> optionIds);

    Collection<Product> getOptionProducts(Long optionId);

    void removeOptionProducts(Long optionId, List<Long> productIds);

    void insertOptionProducts(Long optionId, List<Long> productIds);

    Product cloneProduct(Long productId, Integer typeId, boolean newRelease);

    Product correction(Long productId);

    Collection<String> getProductPurchaseRegions(Long productId);

    void removePurchaseRegion(Long productId, List<String> regionIds);

    void insertPurchaseRegion(Long productId, List<String> regionIds);

    Collection<String> getProductMortgageRegions(Long productId);

    void removeMortgageRegion(Long productId, List<String> regionIds);

    void insertMortgageRegion(Long productId, List<String> regionIds);

    Collection<NamedDto> findParents(Long productId);

    Collection<NamedDto> findSuitableProduct(Long productId);

    Collection<NamedDto> findCreditPurpose(Long productId);

    Collection<NamedDto> findActiveProducts();

    Collection<ExtendedNamedDto> findActiveProducts(ProductType productType);

    Map<Long, String> findProductCodesById(List<Long> ids);

    NamedDto findLastProductReleaseByCode(String code);

    Collection<Product> findReleasesForProduct(Long productId);

    Collection<AuditDto> getAudit(Long productId);

    Collection<ProductEntity> findActiveProductsWithOptions(ProductType productType);

    Collection<ActiveProductDto> findListActiveProduct(ActiveProductFilterDto filter);

    Collection<OptionWithSubOptions> findProductOptions(Long productId, ProductOptionFilterDto filter);

    Collection<ActiveProductDto> findListActiveProductExpress(ActiveProductFilterDto filter);

    Collection<OptionWithSubOptions> findProductOptionsExpress(Long productId,
                                                               ProductOptionFilterDto filter);

    Collection<MaxCreditToPledge> findMaxCreditToPledge(Long productId, String realtyTypeCode,
                                                        String regionCode, String creditPurposeTypeCode, String employmentTypeCode);

    Product findProductByCodeAndReview(String code, LocalDate review);

    Collection<LkiProduct> findByProductTypeAndStatus(ProductType productType, ProductStatus productStatus);

 */
}

