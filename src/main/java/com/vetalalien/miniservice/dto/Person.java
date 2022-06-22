package com.vetalalien.miniservice.dto;


import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Person extends NamedDto {

    private String firstName;
    private String lastName;
    private String middleName;
    /*
    @NotEmpty(groups = {Create.class, Update.class}, message = "Код продукта должен быть указан.")
    private String code;

    private LocalDate saleStart;

    private LocalDate saleFinish;

    private Boolean saleStop;

    private LocalDate refinanceStart;

    private LocalDate refinanceFinish;

    private Boolean refinanceStop;

    private LocalDate reviewStart;

    private LocalDate reviewFinish;

    private Boolean reviewStop;

    @EnumWithIdValid(enumClass = ProductStatus.class, groups = {Create.class, Update.class})
    private Integer statusId;

    @NotNull(groups = {Create.class, Update.class}, message = "Тип продукта должен быть указан.")
    @EnumWithIdValid(enumClass = ProductType.class, groups = {Create.class, Update.class})
    private Integer typeId;

    private NamedDto firstRelease;

    private Long release;

    private Boolean lastRelease;

    private String comment;

    private NamedDto previousRelease;

    private NamedDto nextRelease;

    private NamedDto parent;

    private String percentageTypeCode;

    @EnumWithIdValid(enumClass = PaymentPlannedDateType.class, groups = {Create.class, Update.class})
    private Integer paymentPlannedDateTypeId;

    @Range(min = 1, max = 31, groups = {Create.class, Update.class})
    private Integer paymentPlannedDateDay;

    @EnumWithIdValid(enumClass = IssueProcedureType.class, groups = {Create.class, Update.class})
    private Integer issueProcedureTypeId;

    @EnumWithIdValid(enumClass = PaymentCalcType.class, groups = {Create.class, Update.class})
    private Integer paymentCalcTypeId;

    @Digits(integer = 10, fraction = 6, groups = {Create.class, Update.class},
            message = "Значение должно содержать не более 6 знаков после запятой.")
    private Double paymentFactor;

    @EnumWithIdValid(enumClass = PaymentFrequencyType.class, groups = {Create.class, Update.class})
    private Integer paymentFrequencyTypeId;

    @EnumWithIdValid(enumClass = FirstPaymentPeriodType.class, groups = {Create.class, Update.class})
    private Integer firstPaymentPeriodTypeId;

    @EnumWithIdValid(enumClass = PaymentRoundingRuleType.class, groups = {Create.class, Update.class})
    private Integer paymentRoundingRuleTypeId;

    @EnumWithIdValid(enumClass = AdvancedPaymentType.class, groups = {Create.class, Update.class})
    private Integer advancedPaymentTypeId;

    @EnumWithIdValid(enumClass = PledgeValueCalcType.class, groups = {Create.class, Update.class})
    private Integer pledgeValueCalcTypeId;

    @Valid
    private ProductChangeablePercentageRate changeablePercentageRate;

    @Valid
    private BorrowerReqs borrowerReqs;

    @Valid
    private RealtyObjectReqs realtyObjectReqs;

    @EnumValid(enumClass = InterestCorrectionMethod.class, groups = {Create.class, Update.class})
    private EnumDto interestCorrectionMethod;

    @DecimalMin(value = "-100.00", groups = {Create.class, Update.class},
            message = "Минимальное значение коэффициента коррекции ставки: -100.00")
    @DecimalMax(value = "100.00", groups = {Create.class, Update.class},
            message = "Максимальное значение коэффициента коррекции ставки: 100.00")
    private Double interestCorrectionValue;

    */
    /**
     * Перерасчёт платежеспособности
     */
    //private boolean solvencyRecalculation;

    //private Boolean enabledForExpress;

    //private Long applicationLevelCode;

}

