package drr.enrichment.upi.functions;

import cdm.base.datetime.AdjustableDate;
import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.datetime.CalculationPeriodFrequency;
import cdm.base.datetime.Frequency;
import cdm.base.datetime.Period;
import cdm.base.datetime.PeriodEnum;
import cdm.base.datetime.PeriodExtendedEnum;
import cdm.base.math.DatedValue;
import cdm.base.math.NonNegativeQuantity;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.base.staticdata.asset.common.metafields.FieldWithMetaAssetClassEnum;
import cdm.base.staticdata.asset.rates.InflationRateIndexEnum;
import cdm.event.common.BusinessEvent;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.event.workflow.WorkflowStep;
import cdm.observable.asset.InflationIndex;
import cdm.observable.asset.InterestRateIndex;
import cdm.observable.asset.Observable;
import cdm.observable.asset.Price;
import cdm.observable.asset.PriceQuantity;
import cdm.observable.asset.metafields.FieldWithMetaObservable;
import cdm.observable.asset.metafields.ReferenceWithMetaInterestRateIndex;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.observable.asset.util.ObservableDeepPathUtil;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.FloatingRateSpecification;
import cdm.product.asset.InflationRateSpecification;
import cdm.product.asset.InterestRatePayout;
import cdm.product.asset.RateSpecification;
import cdm.product.common.schedule.CalculationPeriodDates;
import cdm.product.common.schedule.PaymentDates;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import cdm.product.common.settlement.metafields.ReferenceWithMetaResolvablePriceQuantity;
import cdm.product.qualification.functions.Qualify_AssetClass_Credit;
import cdm.product.qualification.functions.Qualify_AssetClass_InterestRate;
import cdm.product.qualification.functions.Qualify_BaseProduct_CrossCurrency;
import cdm.product.qualification.functions.Qualify_BaseProduct_EquitySwap;
import cdm.product.qualification.functions.Qualify_BaseProduct_Fra;
import cdm.product.qualification.functions.Qualify_BaseProduct_IRSwap;
import cdm.product.qualification.functions.Qualify_BaseProduct_Inflation;
import cdm.product.qualification.functions.Qualify_Commodity_Forward;
import cdm.product.qualification.functions.Qualify_Commodity_Option;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Basket;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Index;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_IndexTranche;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_Loan;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwap_SingleName;
import cdm.product.qualification.functions.Qualify_CreditDefaultSwaption;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDF;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDS;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Spot_Forward;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Swap;
import cdm.product.qualification.functions.Qualify_ForeignExchange_VanillaOption;
import cdm.product.qualification.functions.Qualify_InterestRate_CapFloor;
import cdm.product.qualification.functions.Qualify_InterestRate_CrossCurrency_Basis;
import cdm.product.qualification.functions.Qualify_InterestRate_CrossCurrency_FixedFixed;
import cdm.product.qualification.functions.Qualify_InterestRate_CrossCurrency_FixedFloat;
import cdm.product.qualification.functions.Qualify_InterestRate_Fra;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_Basis;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_Basis_OIS;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFixed;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFloat;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFloat_OIS;
import cdm.product.qualification.functions.Qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_Basis_YearOn_Year;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_Basis_ZeroCoupon;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year;
import cdm.product.qualification.functions.Qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon;
import cdm.product.qualification.functions.Qualify_InterestRate_Option_DebtOption;
import cdm.product.qualification.functions.Qualify_InterestRate_Option_Swaption;
import cdm.product.qualification.functions.Qualify_SubProduct_Basis;
import cdm.product.template.EconomicTerms;
import cdm.product.template.ExerciseTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionExerciseStyleEnum;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionStrike;
import cdm.product.template.OptionTypeEnum;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.SettlementPayout;
import cdm.product.template.TradeLot;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsCallOption;
import drr.base.qualification.product.functions.IsCap;
import drr.base.qualification.product.functions.IsCapFloor;
import drr.base.qualification.product.functions.IsCredit;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.qualification.product.functions.IsFXForward;
import drr.base.qualification.product.functions.IsFXOption;
import drr.base.qualification.product.functions.IsFloor;
import drr.base.qualification.product.functions.IsIRSwaption;
import drr.base.qualification.product.functions.IsOption;
import drr.base.qualification.product.functions.IsPutOption;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.quantity.reports.InterestRateNotionalCurrencyRule;
import drr.base.trade.quantity.reports.QuantityScheduleRule;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.base.util.string.functions.ReplaceAll;
import drr.base.util.string.functions.StringContains;
import drr.regulation.common.functions.FXLeg1;
import drr.regulation.common.functions.FXLeg2;
import drr.regulation.common.functions.FXSwapLeg1;
import drr.regulation.common.functions.FXSwapLeg2;
import drr.regulation.common.functions.InterestRateLeg1;
import drr.regulation.common.functions.InterestRateLeg1CapFloor;
import drr.regulation.common.functions.InterestRateLeg2;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.standards.iosco.cde.version3.execution.reports.SettlementTermsRule;
import drr.standards.iosco.upi.AnnaDsbAssetClassEnum;
import drr.standards.iosco.upi.AnnaDsbBaseProduct;
import drr.standards.iosco.upi.AnnaDsbContractSpecificationEnum;
import drr.standards.iosco.upi.AnnaDsbDebtSeniorityEnum;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbHeader;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbLevelEnum;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import drr.standards.iosco.upi.AnnaDsbOptionExerciseStyleEnum;
import drr.standards.iosco.upi.AnnaDsbOptionTypeEnum;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlying;
import drr.standards.iosco.upi.AnnaDsbOtherUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbPlaceofSettlementEnum;
import drr.standards.iosco.upi.AnnaDsbReturnorPayoutTriggerEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlying;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingIssuerTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUpiRequest;
import drr.standards.iosco.upi.AnnaDsbUseCaseEnum;
import drr.standards.iosco.upi.AnnaDsbValuationMethodorTriggerEnum;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_AnnaDsbUpiRequestFromReportableEventAndUnderlying.Create_AnnaDsbUpiRequestFromReportableEventAndUnderlyingDefault.class)
public abstract class Create_AnnaDsbUpiRequestFromReportableEventAndUnderlying implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Compute_IndexTermValue compute_IndexTermValue;
	@Inject protected Compute_NotionalScheduleType compute_NotionalScheduleType;
	@Inject protected ConvertCurrency convertCurrency;
	@Inject protected Create_AnnaDsbUpiRequestBaseProductForCommodity create_AnnaDsbUpiRequestBaseProductForCommodity;
	@Inject protected Create_AnnaDsbUpiRequestOtherLegUnderlyingForRate create_AnnaDsbUpiRequestOtherLegUnderlyingForRate;
	@Inject protected Create_AnnaDsbUpiRequestUnderlyingForCredit create_AnnaDsbUpiRequestUnderlyingForCredit;
	@Inject protected Create_AnnaDsbUpiRequestUnderlyingForCreditNonStandard create_AnnaDsbUpiRequestUnderlyingForCreditNonStandard;
	@Inject protected Create_AnnaDsbUpiRequestUnderlyingForRate create_AnnaDsbUpiRequestUnderlyingForRate;
	@Inject protected DebtSeniority debtSeniority;
	@Inject protected FXLeg1 fXLeg1;
	@Inject protected FXLeg2 fXLeg2;
	@Inject protected FXSwapLeg1 fXSwapLeg1;
	@Inject protected FXSwapLeg2 fXSwapLeg2;
	@Inject protected FloatingRateIndex floatingRateIndex;
	@Inject protected InflationRateIndex inflationRateIndex;
	@Inject protected InterestRateLeg1 interestRateLeg1;
	@Inject protected InterestRateLeg1CapFloor interestRateLeg1CapFloor;
	@Inject protected InterestRateLeg2 interestRateLeg2;
	@Inject protected InterestRateNotionalCurrencyRule interestRateNotionalCurrencyRule;
	@Inject protected IsCallOption isCallOption;
	@Inject protected IsCap isCap;
	@Inject protected IsCapFloor isCapFloor;
	@Inject protected IsCredit isCredit;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected IsFXForward isFXForward;
	@Inject protected IsFXOption isFXOption;
	@Inject protected IsFloor isFloor;
	@Inject protected IsIRSwaption isIRSwaption;
	@Inject protected IsOption isOption0;
	@Inject protected IsPutOption isPutOption;
	@Inject protected ObservableDeepPathUtil observableDeepPathUtil;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected Qualify_AssetClass_Credit qualify_AssetClass_Credit;
	@Inject protected Qualify_AssetClass_InterestRate qualify_AssetClass_InterestRate;
	@Inject protected Qualify_BaseProduct_CrossCurrency qualify_BaseProduct_CrossCurrency;
	@Inject protected Qualify_BaseProduct_EquitySwap qualify_BaseProduct_EquitySwap;
	@Inject protected Qualify_BaseProduct_Fra qualify_BaseProduct_Fra;
	@Inject protected Qualify_BaseProduct_IRSwap qualify_BaseProduct_IRSwap;
	@Inject protected Qualify_BaseProduct_Inflation qualify_BaseProduct_Inflation;
	@Inject protected Qualify_Commodity_Forward qualify_Commodity_Forward;
	@Inject protected Qualify_Commodity_Option qualify_Commodity_Option;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;
	@Inject protected Qualify_CreditDefaultSwap_Basket qualify_CreditDefaultSwap_Basket;
	@Inject protected Qualify_CreditDefaultSwap_Index qualify_CreditDefaultSwap_Index;
	@Inject protected Qualify_CreditDefaultSwap_IndexTranche qualify_CreditDefaultSwap_IndexTranche;
	@Inject protected Qualify_CreditDefaultSwap_Loan qualify_CreditDefaultSwap_Loan;
	@Inject protected Qualify_CreditDefaultSwap_SingleName qualify_CreditDefaultSwap_SingleName;
	@Inject protected Qualify_CreditDefaultSwaption qualify_CreditDefaultSwaption;
	@Inject protected Qualify_ForeignExchange_NDF qualify_ForeignExchange_NDF;
	@Inject protected Qualify_ForeignExchange_NDS qualify_ForeignExchange_NDS;
	@Inject protected Qualify_ForeignExchange_Spot_Forward qualify_ForeignExchange_Spot_Forward;
	@Inject protected Qualify_ForeignExchange_Swap qualify_ForeignExchange_Swap;
	@Inject protected Qualify_ForeignExchange_VanillaOption qualify_ForeignExchange_VanillaOption;
	@Inject protected Qualify_InterestRate_CapFloor qualify_InterestRate_CapFloor;
	@Inject protected Qualify_InterestRate_CrossCurrency_Basis qualify_InterestRate_CrossCurrency_Basis;
	@Inject protected Qualify_InterestRate_CrossCurrency_FixedFixed qualify_InterestRate_CrossCurrency_FixedFixed;
	@Inject protected Qualify_InterestRate_CrossCurrency_FixedFloat qualify_InterestRate_CrossCurrency_FixedFloat;
	@Inject protected Qualify_InterestRate_Fra qualify_InterestRate_Fra;
	@Inject protected Qualify_InterestRate_IRSwap_Basis qualify_InterestRate_IRSwap_Basis;
	@Inject protected Qualify_InterestRate_IRSwap_Basis_OIS qualify_InterestRate_IRSwap_Basis_OIS;
	@Inject protected Qualify_InterestRate_IRSwap_FixedFixed qualify_InterestRate_IRSwap_FixedFixed;
	@Inject protected Qualify_InterestRate_IRSwap_FixedFloat qualify_InterestRate_IRSwap_FixedFloat;
	@Inject protected Qualify_InterestRate_IRSwap_FixedFloat_OIS qualify_InterestRate_IRSwap_FixedFloat_OIS;
	@Inject protected Qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon;
	@Inject protected Qualify_InterestRate_InflationSwap_Basis_YearOn_Year qualify_InterestRate_InflationSwap_Basis_YearOn_Year;
	@Inject protected Qualify_InterestRate_InflationSwap_Basis_ZeroCoupon qualify_InterestRate_InflationSwap_Basis_ZeroCoupon;
	@Inject protected Qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year;
	@Inject protected Qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon;
	@Inject protected Qualify_InterestRate_Option_DebtOption qualify_InterestRate_Option_DebtOption;
	@Inject protected Qualify_InterestRate_Option_Swaption qualify_InterestRate_Option_Swaption;
	@Inject protected Qualify_SubProduct_Basis qualify_SubProduct_Basis;
	@Inject protected QuantityScheduleRule quantityScheduleRule;
	@Inject protected ReplaceAll replaceAll;
	@Inject protected SettlementTermsRule settlementTermsRule;
	@Inject protected StringContains stringContains;
	@Inject protected TranslateAssetClass translateAssetClass;
	@Inject protected TranslatePeriodEnum translatePeriodEnum;
	@Inject protected TranslatePeriodExtendedEnum translatePeriodExtendedEnum;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param reportableEvent 
	* @return request 
	*/
	public AnnaDsbUpiRequest evaluate(ReportableEventBase reportableEvent) {
		AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder requestBuilder = doEvaluate(reportableEvent);
		
		final AnnaDsbUpiRequest request;
		if (requestBuilder == null) {
			request = null;
		} else {
			request = requestBuilder.build();
			objectValidator.validate(AnnaDsbUpiRequest.class, request);
		}
		
		return request;
	}

	protected abstract AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends Trade> TradeForEvent(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends FieldWithMetaString> isdaTaxonomy(ReportableEventBase reportableEvent);

	protected abstract MapperS<Boolean> isSwaption(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	protected abstract MapperS<Boolean> isOption1(ReportableEventBase reportableEvent);

	protected abstract MapperS<AnnaDsbUseCaseEnum> useCase(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends SettlementTerms> settlementTerms(ReportableEventBase reportableEvent);

	protected abstract MapperS<AnnaDsbNotionalScheduleEnum> leg1(ReportableEventBase reportableEvent);

	protected abstract MapperS<AnnaDsbNotionalScheduleEnum> leg2(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends InterestRatePayout> interestRatePayoutFloatingLeg(ReportableEventBase reportableEvent);

	protected abstract MapperS<AnnaDsbInstrumentTypeEnum> instrumentType(ReportableEventBase reportableEvent);

	public static class Create_AnnaDsbUpiRequestFromReportableEventAndUnderlyingDefault extends Create_AnnaDsbUpiRequestFromReportableEventAndUnderlying {
		@Override
		protected AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder doEvaluate(ReportableEventBase reportableEvent) {
			AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder request = AnnaDsbUpiRequest.builder();
			return assignOutput(request, reportableEvent);
		}
		
		protected AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder assignOutput(AnnaDsbUpiRequest.AnnaDsbUpiRequestBuilder request, ReportableEventBase reportableEvent) {
			final AnnaDsbAssetClassEnum ifThenElseResult0;
			if (exists(product(reportableEvent).<ProductTaxonomy>mapC("getTaxonomy", nonTransferableProduct -> nonTransferableProduct.getTaxonomy()).<FieldWithMetaAssetClassEnum>map("getPrimaryAssetClass", productTaxonomy -> productTaxonomy.getPrimaryAssetClass())).getOrDefault(false)) {
				final FieldWithMetaAssetClassEnum fieldWithMetaAssetClassEnum0 = product(reportableEvent).<ProductTaxonomy>mapC("getTaxonomy", nonTransferableProduct -> nonTransferableProduct.getTaxonomy()).<FieldWithMetaAssetClassEnum>map("getPrimaryAssetClass", productTaxonomy -> productTaxonomy.getPrimaryAssetClass()).get();
				ifThenElseResult0 = translateAssetClass.evaluate((fieldWithMetaAssetClassEnum0 == null ? null : fieldWithMetaAssetClassEnum0.getValue()));
			} else if (isSwaption(reportableEvent).getOrDefault(false)) {
				final FieldWithMetaAssetClassEnum fieldWithMetaAssetClassEnum1 = TradeForEvent(reportableEvent).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<ProductTaxonomy>mapC("getTaxonomy", nonTransferableProduct -> nonTransferableProduct.getTaxonomy()).<FieldWithMetaAssetClassEnum>map("getPrimaryAssetClass", productTaxonomy -> productTaxonomy.getPrimaryAssetClass()).get();
				ifThenElseResult0 = translateAssetClass.evaluate((fieldWithMetaAssetClassEnum1 == null ? null : fieldWithMetaAssetClassEnum1.getValue()));
			} else {
				ifThenElseResult0 = null;
			}
			request
				.setHeader(AnnaDsbHeader.builder()
					.setLevel(AnnaDsbLevelEnum.UPI)
					.setAssetClass(ifThenElseResult0)
					.setUseCase(useCase(reportableEvent).get())
					.setInstrumentType(instrumentType(reportableEvent).get())
					.build());
			
			final MapperS<? extends NonTransferableProduct> thenArg0 = product(reportableEvent);
			final Boolean boolean0 = isOption0.evaluate(thenArg0.get());
			final MapperS<AnnaDsbOptionExerciseStyleEnum> ifThenElseResult1;
			if ((boolean0 == null ? false : boolean0)) {
				ifThenElseResult1 = MapperS.of(economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<ExerciseTerms>map("getExerciseTerms", optionPayout -> optionPayout.getExerciseTerms()).<OptionExerciseStyleEnum>map("getStyle", exerciseTerms -> exerciseTerms.getStyle())
					.mapSingleToItem(item -> {
						if (areEqual(item, MapperS.of(OptionExerciseStyleEnum.AMERICAN), CardinalityOperator.All).getOrDefault(false)) {
							return MapperS.of(AnnaDsbOptionExerciseStyleEnum.AMER);
						}
						if (areEqual(item, MapperS.of(OptionExerciseStyleEnum.EUROPEAN), CardinalityOperator.All).getOrDefault(false)) {
							return MapperS.of(AnnaDsbOptionExerciseStyleEnum.EURO);
						}
						if (areEqual(item, MapperS.of(OptionExerciseStyleEnum.BERMUDA), CardinalityOperator.All).getOrDefault(false)) {
							return MapperS.of(AnnaDsbOptionExerciseStyleEnum.BERM);
						}
						return MapperS.<AnnaDsbOptionExerciseStyleEnum>ofNull();
					});
			} else {
				ifThenElseResult1 = MapperS.<AnnaDsbOptionExerciseStyleEnum>ofNull();
			}
			request
				.getOrCreateAttributes()
				.setOptionExerciseStyle(ifThenElseResult1.get());
			
			final MapperS<? extends NonTransferableProduct> thenArg1 = product(reportableEvent);
			final MapperS<AnnaDsbOptionTypeEnum> ifThenElseResult2;
			if (areEqual(economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<OptionTypeEnum>map("getOptionType", optionPayout -> optionPayout.getOptionType()), MapperS.of(OptionTypeEnum.STRADDLE), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(AnnaDsbOptionTypeEnum.OPTL);
			} else if (ComparisonResult.ofNullSafe(MapperS.of(isFloor.evaluate(thenArg1.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isPutOption.evaluate(thenArg1.get())))).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(AnnaDsbOptionTypeEnum.PUTO);
			} else if (ComparisonResult.ofNullSafe(MapperS.of(isCallOption.evaluate(thenArg1.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCap.evaluate(thenArg1.get())))).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(AnnaDsbOptionTypeEnum.CALL);
			} else {
				ifThenElseResult2 = MapperS.<AnnaDsbOptionTypeEnum>ofNull();
			}
			request
				.getOrCreateAttributes()
				.setOptionType(ifThenElseResult2.get());
			
			final Boolean boolean1 = qualify_InterestRate_Option_Swaption.evaluate(product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get());
			final MapperS<InterestRatePayout> thenArg2;
			if ((boolean1 == null ? false : boolean1)) {
				thenArg2 = MapperS.of(interestRateLeg1.evaluate(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get()));
			} else {
				final Boolean boolean2 = qualify_AssetClass_InterestRate.evaluate(product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get());
				if ((boolean2 == null ? false : boolean2)) {
					thenArg2 = MapperS.of(interestRateLeg1.evaluate(product(reportableEvent).get()));
				} else {
					thenArg2 = MapperS.<InterestRatePayout>ofNull();
				}
			}
			final MapperS<String> ifThenElseResult3;
			if (exists(thenArg2.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule())).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString0 = thenArg2.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule0 -> referenceWithMetaNonNegativeQuantitySchedule0 == null ? null : referenceWithMetaNonNegativeQuantitySchedule0.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
				ifThenElseResult3 = MapperS.of(convertCurrency.evaluate((fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue())));
			} else if (exists(thenArg2.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaResolvablePriceQuantity>map("getQuantityReference", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantityReference())).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString1 = thenArg2.<ResolvablePriceQuantity>map("getPriceQuantity", interestRatePayout -> interestRatePayout.getPriceQuantity()).<ReferenceWithMetaResolvablePriceQuantity>map("getQuantityReference", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantityReference()).<ResolvablePriceQuantity>map("Type coercion", referenceWithMetaResolvablePriceQuantity -> referenceWithMetaResolvablePriceQuantity == null ? null : referenceWithMetaResolvablePriceQuantity.getValue()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule1 -> referenceWithMetaNonNegativeQuantitySchedule1 == null ? null : referenceWithMetaNonNegativeQuantitySchedule1.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
				ifThenElseResult3 = MapperS.of(convertCurrency.evaluate((fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue())));
			} else if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.DEBT_OPTION), CardinalityOperator.All).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.DEBT), CardinalityOperator.All)).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString2 = TradeForEvent(reportableEvent).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
					.first().<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
				ifThenElseResult3 = MapperS.of(convertCurrency.evaluate((fieldWithMetaString2 == null ? null : fieldWithMetaString2.getValue())));
			} else {
				ifThenElseResult3 = MapperS.<String>ofNull();
			}
			request
				.getOrCreateAttributes()
				.setNotionalCurrency(ifThenElseResult3.get());
			
			String ifThenElseResult4 = null;
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_CrossCurrency_FixedFloat.evaluate(product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_CrossCurrency_FixedFixed.evaluate(product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_CrossCurrency_Basis.evaluate(product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get())))).getOrDefault(false)) {
				ifThenElseResult4 = interestRateNotionalCurrencyRule.evaluate(interestRateLeg2.evaluate(product(reportableEvent).get()));
			}
			request
				.getOrCreateAttributes()
				.setOtherNotionalCurrency(ifThenElseResult4);
			
			final String ifThenElseResult5;
			if (ComparisonResult.ofNullSafe(MapperS.of(isIRSwaption.evaluate(product(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isCreditSwaption.evaluate(product(reportableEvent).get())))).getOrDefault(false)) {
				final MapperC<ProductIdentifier> thenArg3 = MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier())
					.filterItemNullSafe(item -> areEqual(item.<ProductIdTypeEnum>map("getSource", productIdentifier -> productIdentifier.getSource()), MapperS.of(ProductIdTypeEnum.UPI), CardinalityOperator.All).get());
				final MapperS<ProductIdentifier> thenArg4 = thenArg3
					.first();
				final FieldWithMetaString fieldWithMetaString3 = thenArg4.<FieldWithMetaString>map("getIdentifier", productIdentifier -> productIdentifier.getIdentifier()).get();
				ifThenElseResult5 = fieldWithMetaString3 == null ? null : fieldWithMetaString3.getValue();
			} else if (ComparisonResult.ofNullSafe(MapperS.of(isFXForward.evaluate(product(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXOption.evaluate(product(reportableEvent).get())))).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString4 = MapperS.of(fXLeg1.evaluate(product(reportableEvent).get(), TradeForEvent(reportableEvent).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get())).<NonNegativeQuantity>map("getQuantity", cashflow -> cashflow.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
				ifThenElseResult5 = convertCurrency.evaluate((fieldWithMetaString4 == null ? null : fieldWithMetaString4.getValue()));
			} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Swap.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDS.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString5 = MapperS.of(fXSwapLeg1.evaluate(product(reportableEvent).get(), TradeForEvent(reportableEvent).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get())).<NonNegativeQuantity>map("getQuantity", cashflow -> cashflow.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
				ifThenElseResult5 = convertCurrency.evaluate((fieldWithMetaString5 == null ? null : fieldWithMetaString5.getValue()));
			} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Forward.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				final MapperC<AssetIdentifier> thenArg5 = economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier())
					.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISDACRP), CardinalityOperator.All).get());
				if (thenArg5
					.first()
					.mapSingleToItem(item -> exists(item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())).asMapper()).getOrDefault(false)) {
					final MapperC<AssetIdentifier> thenArg6 = economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<Underlier>map("getUnderlier", commodityPayout -> commodityPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier())
						.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISDACRP), CardinalityOperator.All).get());
					final FieldWithMetaString fieldWithMetaString6 = thenArg6
						.first()
						.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())).get();
					ifThenElseResult5 = fieldWithMetaString6 == null ? null : fieldWithMetaString6.getValue();
				} else {
					ifThenElseResult5 = "OTHER";
				}
			} else {
				final Boolean boolean3 = qualify_Commodity_Option.evaluate(economicTerms(reportableEvent).get());
				if ((boolean3 == null ? false : boolean3)) {
					final MapperC<AssetIdentifier> thenArg7 = economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier())
						.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISDACRP), CardinalityOperator.All).get());
					if (thenArg7
						.first()
						.mapSingleToItem(item -> exists(item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())).asMapper()).getOrDefault(false)) {
						final MapperC<AssetIdentifier> thenArg8 = economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity()).<AssetIdentifier>mapC("getIdentifier", commodity -> commodity.getIdentifier())
							.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISDACRP), CardinalityOperator.All).get());
						final FieldWithMetaString fieldWithMetaString7 = thenArg8
							.first()
							.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())).get();
						ifThenElseResult5 = fieldWithMetaString7 == null ? null : fieldWithMetaString7.getValue();
					} else {
						ifThenElseResult5 = null;
					}
				} else if (exists(MapperS.of(interestRateLeg1.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP), CardinalityOperator.Any)).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.Any)).getOrDefault(false)) {
					final MapperS<InterestRatePayout> thenArg9 = MapperS.of(interestRateLeg1.evaluate(product(reportableEvent).get()));
					ifThenElseResult5 = thenArg9
						.mapSingleToItem(item -> MapperS.of(floatingRateIndex.evaluate(item.get()))).get();
				} else if (exists(MapperS.of(interestRateLeg1.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification())).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP), CardinalityOperator.Any)).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.Any)).getOrDefault(false)) {
					final MapperS<InterestRatePayout> thenArg10 = MapperS.of(interestRateLeg1.evaluate(product(reportableEvent).get()));
					ifThenElseResult5 = thenArg10
						.mapSingleToItem(item -> MapperS.of(inflationRateIndex.evaluate(item.get())).map("to-string", InflationRateIndexEnum::toDisplayString)).get();
				} else if (exists(MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP), CardinalityOperator.Any)).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.Any)).getOrDefault(false)) {
					final MapperS<InterestRatePayout> thenArg11 = MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get()));
					ifThenElseResult5 = thenArg11
						.mapSingleToItem(item -> MapperS.of(floatingRateIndex.evaluate(item.get()))).get();
				} else if (exists(MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification())).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP), CardinalityOperator.Any)).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.Any)).getOrDefault(false)) {
					final MapperS<InterestRatePayout> thenArg12 = MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get()));
					ifThenElseResult5 = thenArg12
						.mapSingleToItem(item -> MapperS.of(inflationRateIndex.evaluate(item.get())).map("to-string", InflationRateIndexEnum::toDisplayString)).get();
				} else if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.DEBT_OPTION), CardinalityOperator.All).getOrDefault(false)) {
					final MapperC<AssetIdentifier> thenArg13 = TradeForEvent(reportableEvent).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaObservable>map("getObservable", priceQuantity -> priceQuantity.getObservable()).<Observable>map("Type coercion", fieldWithMetaObservable -> fieldWithMetaObservable.getValue()).<AssetIdentifier>mapC("chooseIdentifier", observable -> observableDeepPathUtil.chooseIdentifier(observable))
						.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.All).get());
					final FieldWithMetaString fieldWithMetaString8 = thenArg13
						.first()
						.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())).get();
					ifThenElseResult5 = fieldWithMetaString8 == null ? null : fieldWithMetaString8.getValue();
				} else {
					ifThenElseResult5 = null;
				}
			}
			request
				.getOrCreateAttributes()
				.setUnderlierID(ifThenElseResult5);
			
			final AnnaDsbUnderlierIDSourceEnum ifThenElseResult6;
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_InterestRate.evaluate(product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get()))).andNullSafe(exists(MapperS.of(interestRateLeg1.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).orNullSafe(exists(MapperS.of(interestRateLeg1.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification()))).orNullSafe(exists(MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()))).orNullSafe(exists(MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification())))).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.Any)).getOrDefault(false)) {
				ifThenElseResult6 = AnnaDsbUnderlierIDSourceEnum.FPML;
			} else if (ComparisonResult.ofNullSafe(MapperS.of(isFXForward.evaluate(product(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXOption.evaluate(product(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Swap.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDS.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				ifThenElseResult6 = AnnaDsbUnderlierIDSourceEnum.CCY;
			} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwaption.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_Option_Swaption.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.SINGLE_NAME_SWAPTION), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult6 = AnnaDsbUnderlierIDSourceEnum.UPI;
			} else {
				final Boolean boolean4 = qualify_InterestRate_Option_DebtOption.evaluate(economicTerms(reportableEvent).get());
				if ((boolean4 == null ? false : boolean4)) {
					ifThenElseResult6 = AnnaDsbUnderlierIDSourceEnum.ISIN;
				} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Option.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Forward.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
					ifThenElseResult6 = AnnaDsbUnderlierIDSourceEnum.COMM;
				} else {
					ifThenElseResult6 = null;
				}
			}
			request
				.getOrCreateAttributes()
				.setUnderlierIDSource(ifThenElseResult6);
			
			final MapperS<InterestRatePayout> thenArg14;
			if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.INFLATION_SWAP), CardinalityOperator.All).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.All)).getOrDefault(false)) {
				thenArg14 = MapperS.<InterestRatePayout>ofNull();
			} else {
				final Boolean boolean5 = qualify_SubProduct_Basis.evaluate(product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get());
				if ((boolean5 == null ? false : boolean5)) {
					thenArg14 = MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get()));
				} else {
					thenArg14 = MapperS.<InterestRatePayout>ofNull();
				}
			}
			request
				.getOrCreateAttributes()
				.setOtherLegUnderlierID(thenArg14
					.mapSingleToItem(item -> MapperS.of(floatingRateIndex.evaluate(item.get()))).get());
			
			final String ifThenElseResult7;
			if (ComparisonResult.ofNullSafe(MapperS.of(isFXForward.evaluate(product(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXOption.evaluate(product(reportableEvent).get())))).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString9 = MapperS.of(fXLeg2.evaluate(product(reportableEvent).get(), TradeForEvent(reportableEvent).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get())).<NonNegativeQuantity>map("getQuantity", cashflow -> cashflow.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
				ifThenElseResult7 = convertCurrency.evaluate((fieldWithMetaString9 == null ? null : fieldWithMetaString9.getValue()));
			} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Swap.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDS.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString10 = MapperS.of(fXSwapLeg2.evaluate(product(reportableEvent).get(), TradeForEvent(reportableEvent).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get())).<NonNegativeQuantity>map("getQuantity", cashflow -> cashflow.getQuantity()).<UnitType>map("getUnit", nonNegativeQuantity -> nonNegativeQuantity.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
				ifThenElseResult7 = convertCurrency.evaluate((fieldWithMetaString10 == null ? null : fieldWithMetaString10.getValue()));
			} else {
				ifThenElseResult7 = null;
			}
			request
				.getOrCreateAttributes()
				.setOtherUnderlierID(ifThenElseResult7);
			
			AnnaDsbOtherUnderlierIDSourceEnum ifThenElseResult8 = null;
			if (ComparisonResult.ofNullSafe(MapperS.of(isFXForward.evaluate(product(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXOption.evaluate(product(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Swap.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDS.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				ifThenElseResult8 = AnnaDsbOtherUnderlierIDSourceEnum.CCY;
			}
			request
				.getOrCreateAttributes()
				.setOtherUnderlierIDSource(ifThenElseResult8);
			
			final AnnaDsbOtherLegUnderlierIDSourceEnum ifThenElseResult9;
			if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.INFLATION_SWAP), CardinalityOperator.All).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult9 = null;
			} else {
				final Boolean boolean6 = qualify_SubProduct_Basis.evaluate(product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get());
				if ((boolean6 == null ? false : boolean6)) {
					ifThenElseResult9 = AnnaDsbOtherLegUnderlierIDSourceEnum.FPML;
				} else {
					ifThenElseResult9 = null;
				}
			}
			request
				.getOrCreateAttributes()
				.setOtherLegUnderlierIDSource(ifThenElseResult9);
			
			final AnnaDsbDeliveryTypeEnum ifThenElseResult10;
			if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NDF), CardinalityOperator.All).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NDO), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult10 = null;
			} else {
				final Boolean boolean7 = qualify_ForeignExchange_NDS.evaluate(economicTerms(reportableEvent).get());
				if ((boolean7 == null ? false : boolean7)) {
					ifThenElseResult10 = AnnaDsbDeliveryTypeEnum.CASH;
				} else {
					final Boolean boolean8 = qualify_ForeignExchange_Swap.evaluate(economicTerms(reportableEvent).get());
					if ((boolean8 == null ? false : boolean8)) {
						ifThenElseResult10 = AnnaDsbDeliveryTypeEnum.PHYS;
					} else if (areEqual(settlementTerms(reportableEvent).<SettlementTypeEnum>map("getSettlementType", _settlementTerms -> _settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult10 = AnnaDsbDeliveryTypeEnum.CASH;
					} else if (areEqual(settlementTerms(reportableEvent).<SettlementTypeEnum>map("getSettlementType", _settlementTerms -> _settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH_OR_PHYSICAL), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult10 = AnnaDsbDeliveryTypeEnum.OPTL;
					} else if (areEqual(settlementTerms(reportableEvent).<SettlementTypeEnum>map("getSettlementType", _settlementTerms -> _settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.PHYSICAL), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult10 = AnnaDsbDeliveryTypeEnum.PHYS;
					} else if (areEqual(settlementTerms(reportableEvent).<SettlementTypeEnum>map("getSettlementType", _settlementTerms -> _settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.ELECTION), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult10 = AnnaDsbDeliveryTypeEnum.OPTL;
					} else if (notExists(settlementTerms(reportableEvent).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms())).andNullSafe(exists(settlementTerms(reportableEvent).<CashSettlementTerms>mapC("getCashSettlementTerms", _settlementTerms -> _settlementTerms.getCashSettlementTerms()))).getOrDefault(false)) {
						ifThenElseResult10 = AnnaDsbDeliveryTypeEnum.CASH;
					} else if (exists(settlementTerms(reportableEvent).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms())).andNullSafe(exists(settlementTerms(reportableEvent).<CashSettlementTerms>mapC("getCashSettlementTerms", _settlementTerms -> _settlementTerms.getCashSettlementTerms()))).getOrDefault(false)) {
						ifThenElseResult10 = AnnaDsbDeliveryTypeEnum.OPTL;
					} else if (exists(settlementTerms(reportableEvent).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms())).andNullSafe(notExists(settlementTerms(reportableEvent).<CashSettlementTerms>mapC("getCashSettlementTerms", _settlementTerms -> _settlementTerms.getCashSettlementTerms()))).getOrDefault(false)) {
						ifThenElseResult10 = AnnaDsbDeliveryTypeEnum.PHYS;
					} else if (areEqual(instrumentType(reportableEvent), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All).orNullSafe(areEqual(instrumentType(reportableEvent), MapperS.of(AnnaDsbInstrumentTypeEnum.FORWARD), CardinalityOperator.All)).getOrDefault(false)) {
						ifThenElseResult10 = AnnaDsbDeliveryTypeEnum.PHYS;
					} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_IRSwap.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_CrossCurrency.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_Inflation.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
						ifThenElseResult10 = AnnaDsbDeliveryTypeEnum.PHYS;
					} else {
						final Boolean boolean9 = qualify_AssetClass_Credit.evaluate(economicTerms(reportableEvent).get());
						if ((boolean9 == null ? false : boolean9)) {
							ifThenElseResult10 = AnnaDsbDeliveryTypeEnum.OPTL;
						} else {
							ifThenElseResult10 = AnnaDsbDeliveryTypeEnum.CASH;
						}
					}
				}
			}
			request
				.getOrCreateAttributes()
				.setDeliveryType(ifThenElseResult10);
			
			final MapperS<SettlementTerms> thenArg15;
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_InterestRate.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_AssetClass_Credit.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Option.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Spot_Forward.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.VANILLA_OPTION), CardinalityOperator.All)).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.FORWARD), CardinalityOperator.All)).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.FX_SWAP), CardinalityOperator.All)).getOrDefault(false)) {
				thenArg15 = MapperS.<SettlementTerms>ofNull();
			} else {
				thenArg15 = MapperS.of(settlementTermsRule.evaluate(payoutLeg1Rule.evaluate(reportableEvent)));
			}
			request
				.getOrCreateAttributes()
				.setSettlementCurrency(thenArg15
					.mapSingleToItem(item -> {
						if (areEqual(item.<SettlementTypeEnum>map("getSettlementType", _settlementTerms -> _settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH), CardinalityOperator.All).orNullSafe(exists(item.<CashSettlementTerms>mapC("getCashSettlementTerms", _settlementTerms -> _settlementTerms.getCashSettlementTerms())).andNullSafe(areEqual(MapperS.of(qualify_BaseProduct_CrossCurrency.evaluate(economicTerms(reportableEvent).get())), MapperS.of(false), CardinalityOperator.All))).getOrDefault(false)) {
							final FieldWithMetaString _fieldWithMetaString0 = item.<FieldWithMetaString>map("getSettlementCurrency", _settlementTerms -> _settlementTerms.getSettlementCurrency()).get();
							return MapperS.of(convertCurrency.evaluate((_fieldWithMetaString0 == null ? null : _fieldWithMetaString0.getValue())));
						}
						if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.DIGITAL_OPTION), CardinalityOperator.All).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.BARRIER_OPTION), CardinalityOperator.All)).getOrDefault(false)) {
							final MapperS<FieldWithMetaString> thenArg = economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<OptionStrike>map("getStrike", optionPayout -> optionPayout.getStrike()).<Price>map("getStrikePrice", optionStrike -> optionStrike.getStrikePrice()).<UnitType>map("getUnit", price -> price.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())
								.first();
							final FieldWithMetaString _fieldWithMetaString1 = thenArg.get();
							return MapperS.of(convertCurrency.evaluate((_fieldWithMetaString1 == null ? null : _fieldWithMetaString1.getValue())));
						}
						return MapperS.<String>ofNull();
					}).get());
			
			request
				.getOrCreateAttributes()
				.setPlaceofSettlement(MapperS.of(settlementTermsRule.evaluate(payoutLeg1Rule.evaluate(reportableEvent)))
					.mapSingleToItem(item -> {
						if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", _fieldWithMetaString0 -> _fieldWithMetaString0 == null ? null : _fieldWithMetaString0.getValue()), MapperS.of("ForeignExchange:ComplexExotic"), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXForward.evaluate(product(reportableEvent).get())))).andNullSafe(areEqual(item.<SettlementTypeEnum>map("getSettlementType", _settlementTerms -> _settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH), CardinalityOperator.All)).orNullSafe(exists(settlementTerms(reportableEvent).<CashSettlementTerms>mapC("getCashSettlementTerms", _settlementTerms -> _settlementTerms.getCashSettlementTerms())).andNullSafe(areEqual(settlementTerms(reportableEvent).<FieldWithMetaString>map("getSettlementCurrency", _settlementTerms -> _settlementTerms.getSettlementCurrency()).<String>map("Type coercion", _fieldWithMetaString1 -> _fieldWithMetaString1 == null ? null : _fieldWithMetaString1.getValue()), MapperS.of("CNH"), CardinalityOperator.All))).getOrDefault(false)) {
							return MapperS.of(AnnaDsbPlaceofSettlementEnum.HONG_KONG);
						}
						return MapperS.<AnnaDsbPlaceofSettlementEnum>ofNull();
					}).get());
			
			final AnnaDsbValuationMethodorTriggerEnum ifThenElseResult11;
			if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.DIGITAL_OPTION), CardinalityOperator.All).orNullSafe(areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString11 -> fieldWithMetaString11 == null ? null : fieldWithMetaString11.getValue()), MapperS.of("ForeignExchange:ComplexExotic"), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult11 = AnnaDsbValuationMethodorTriggerEnum.DIGITAL_BINARY;
			} else if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.SWAPTION), CardinalityOperator.All).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.SINGLE_NAME_SWAPTION), CardinalityOperator.All)).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.INDEX_SWAPTION), CardinalityOperator.All)).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NDO), CardinalityOperator.All)).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.DEBT_OPTION), CardinalityOperator.All)).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Option.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				ifThenElseResult11 = AnnaDsbValuationMethodorTriggerEnum.VANILLA;
			} else {
				ifThenElseResult11 = null;
			}
			request
				.getOrCreateAttributes()
				.setValuationMethodorTrigger(ifThenElseResult11);
			
			final Integer ifThenElseResult12;
			if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.CROSS_CURRENCY_FIXED_FIXED), CardinalityOperator.All).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.All)).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP), CardinalityOperator.All)).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.FIXED_FIXED), CardinalityOperator.All)).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_CapFloor.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				ifThenElseResult12 = null;
			} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_Fra.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.FIXED_FLOAT_ZERO_COUPON), CardinalityOperator.All)).getOrDefault(false)) {
				if (exists(MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex0 -> referenceWithMetaInterestRateIndex0 == null ? null : referenceWithMetaInterestRateIndex0.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier())).getOrDefault(false)) {
					ifThenElseResult12 = MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex1 -> referenceWithMetaInterestRateIndex1 == null ? null : referenceWithMetaInterestRateIndex1.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier()).get();
				} else {
					final MapperC<InterestRatePayout> thenArg16 = economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
						.filterItemNullSafe(item -> exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).get());
					final MapperC<InterestRatePayout> thenArg17 = economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
						.filterItemNullSafe(item -> exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).get());
					ifThenElseResult12 = compute_IndexTermValue.evaluate(MapperS.of(thenArg16.get()).<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getTerminationDate", calculationPeriodDates -> calculationPeriodDates.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get(), MapperS.of(thenArg17.get()).<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getEffectiveDate", calculationPeriodDates -> calculationPeriodDates.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get());
				}
			} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_Inflation.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_InflationSwap_Basis_YearOn_Year.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				final MapperC<InterestRatePayout> thenArg18 = economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
					.filterItemNullSafe(item -> exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification())).get());
				final MapperC<InterestRatePayout> thenArg19 = economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
					.filterItemNullSafe(item -> exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification())).get());
				ifThenElseResult12 = compute_IndexTermValue.evaluate(thenArg18
					.first().<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getTerminationDate", calculationPeriodDates -> calculationPeriodDates.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get(), thenArg19
					.first().<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getEffectiveDate", calculationPeriodDates -> calculationPeriodDates.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get());
			} else {
				final Boolean boolean10 = qualify_InterestRate_CrossCurrency_Basis.evaluate(economicTerms(reportableEvent).get());
				if ((boolean10 == null ? false : boolean10)) {
					ifThenElseResult12 = MapperS.of(interestRateLeg1.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex2 -> referenceWithMetaInterestRateIndex2 == null ? null : referenceWithMetaInterestRateIndex2.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier()).get();
				} else {
					final Boolean boolean11 = qualify_InterestRate_CrossCurrency_FixedFloat.evaluate(economicTerms(reportableEvent).get());
					if ((boolean11 == null ? false : boolean11)) {
						if (exists(interestRatePayoutFloatingLeg(reportableEvent).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex3 -> referenceWithMetaInterestRateIndex3 == null ? null : referenceWithMetaInterestRateIndex3.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier())).getOrDefault(false)) {
							ifThenElseResult12 = interestRatePayoutFloatingLeg(reportableEvent).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex4 -> referenceWithMetaInterestRateIndex4 == null ? null : referenceWithMetaInterestRateIndex4.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier()).get();
						} else if (exists(interestRatePayoutFloatingLeg(reportableEvent).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<Integer>map("getPeriodMultiplier", frequency -> frequency.getPeriodMultiplier())).getOrDefault(false)) {
							ifThenElseResult12 = interestRatePayoutFloatingLeg(reportableEvent).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<Integer>map("getPeriodMultiplier", frequency -> frequency.getPeriodMultiplier()).get();
						} else {
							ifThenElseResult12 = interestRatePayoutFloatingLeg(reportableEvent).<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).<Integer>map("getPeriodMultiplier", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriodMultiplier()).get();
						}
					} else {
						ifThenElseResult12 = MapperS.of(interestRateLeg1.evaluate(product(reportableEvent).get()))
							.mapSingleToItem(item -> {
								if (areEqual(MapperS.of(qualify_AssetClass_Credit.evaluate(economicTerms(reportableEvent).get())), MapperS.of(false), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(qualify_InterestRate_CapFloor.evaluate(economicTerms(reportableEvent).get())), MapperS.of(false), CardinalityOperator.All).andNullSafe(exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).orNullSafe(exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification())))).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP), CardinalityOperator.Any))).getOrDefault(false)) {
									if (exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", _referenceWithMetaInterestRateIndex0 -> _referenceWithMetaInterestRateIndex0 == null ? null : _referenceWithMetaInterestRateIndex0.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier())).getOrDefault(false)) {
										return item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", _referenceWithMetaInterestRateIndex1 -> _referenceWithMetaInterestRateIndex1 == null ? null : _referenceWithMetaInterestRateIndex1.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier());
									}
									if (exists(item.<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<Integer>map("getPeriodMultiplier", frequency -> frequency.getPeriodMultiplier())).getOrDefault(false)) {
										return item.<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<Integer>map("getPeriodMultiplier", frequency -> frequency.getPeriodMultiplier());
									}
									return item.<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).<Integer>map("getPeriodMultiplier", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriodMultiplier());
								}
								return MapperS.<Integer>ofNull();
							}).get();
					}
				}
			}
			request
				.getOrCreateAttributes()
				.setReferenceRateTermValue(ifThenElseResult12);
			
			final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum ifThenElseResult13;
			if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.CROSS_CURRENCY_FIXED_FIXED), CardinalityOperator.All).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.All)).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP), CardinalityOperator.All)).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_CapFloor.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_IRSwap_FixedFixed.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				ifThenElseResult13 = null;
			} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_Fra.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.FIXED_FLOAT_ZERO_COUPON), CardinalityOperator.All)).getOrDefault(false)) {
				if (exists(MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex5 -> referenceWithMetaInterestRateIndex5 == null ? null : referenceWithMetaInterestRateIndex5.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<PeriodEnum>map("getPeriod", period -> period.getPeriod())).getOrDefault(false)) {
					ifThenElseResult13 = translatePeriodEnum.evaluate(MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex6 -> referenceWithMetaInterestRateIndex6 == null ? null : referenceWithMetaInterestRateIndex6.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<PeriodEnum>map("getPeriod", period -> period.getPeriod()).get());
				} else {
					ifThenElseResult13 = AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.YEAR;
				}
			} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_Inflation.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_InflationSwap_Basis_YearOn_Year.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				if (exists(economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", inflationRateSpecification -> inflationRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex()).<Period>map("getIndexTenor", inflationIndex -> inflationIndex.getIndexTenor())).getOrDefault(false)) {
					final MapperS<Period> thenArg20 = economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", inflationRateSpecification -> inflationRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<InflationIndex>map("getInflationIndex", interestRateIndex -> interestRateIndex.getInflationIndex()).<Period>map("getIndexTenor", inflationIndex -> inflationIndex.getIndexTenor())
						.first();
					ifThenElseResult13 = MapperS.of(translatePeriodEnum.evaluate(thenArg20.<PeriodEnum>map("getPeriod", period -> period.getPeriod()).get())).get();
				} else {
					ifThenElseResult13 = AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.YEAR;
				}
			} else {
				final Boolean boolean12 = qualify_InterestRate_IRSwap_FixedFloat_OIS.evaluate(economicTerms(reportableEvent).get());
				if ((boolean12 == null ? false : boolean12)) {
					final MapperS<Period> thenArg21 = economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex -> referenceWithMetaInterestRateIndex.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor())
						.first();
					ifThenElseResult13 = MapperS.of(translatePeriodEnum.evaluate(thenArg21.<PeriodEnum>map("getPeriod", period -> period.getPeriod()).get())).get();
				} else {
					final Boolean boolean13 = qualify_InterestRate_CrossCurrency_Basis.evaluate(economicTerms(reportableEvent).get());
					if ((boolean13 == null ? false : boolean13)) {
						ifThenElseResult13 = translatePeriodEnum.evaluate(MapperS.of(interestRateLeg1.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex7 -> referenceWithMetaInterestRateIndex7 == null ? null : referenceWithMetaInterestRateIndex7.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<PeriodEnum>map("getPeriod", period -> period.getPeriod()).get());
					} else {
						final Boolean boolean14 = qualify_InterestRate_CrossCurrency_FixedFloat.evaluate(economicTerms(reportableEvent).get());
						if ((boolean14 == null ? false : boolean14)) {
							if (exists(interestRatePayoutFloatingLeg(reportableEvent).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex8 -> referenceWithMetaInterestRateIndex8 == null ? null : referenceWithMetaInterestRateIndex8.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<PeriodEnum>map("getPeriod", period -> period.getPeriod())).getOrDefault(false)) {
								ifThenElseResult13 = translatePeriodEnum.evaluate(interestRatePayoutFloatingLeg(reportableEvent).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", referenceWithMetaInterestRateIndex9 -> referenceWithMetaInterestRateIndex9 == null ? null : referenceWithMetaInterestRateIndex9.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<PeriodEnum>map("getPeriod", period -> period.getPeriod()).get());
							} else if (exists(interestRatePayoutFloatingLeg(reportableEvent).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod())).getOrDefault(false)) {
								ifThenElseResult13 = translatePeriodExtendedEnum.evaluate(interestRatePayoutFloatingLeg(reportableEvent).<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod()).get());
							} else {
								ifThenElseResult13 = translatePeriodExtendedEnum.evaluate(interestRatePayoutFloatingLeg(reportableEvent).<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).<PeriodExtendedEnum>map("getPeriod", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriod()).get());
							}
						} else {
							ifThenElseResult13 = MapperS.of(interestRateLeg1.evaluate(product(reportableEvent).get()))
								.mapSingleToItem(item -> {
									if (areEqual(MapperS.of(qualify_AssetClass_Credit.evaluate(economicTerms(reportableEvent).get())), MapperS.of(false), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(qualify_InterestRate_CapFloor.evaluate(economicTerms(reportableEvent).get())), MapperS.of(false), CardinalityOperator.All).andNullSafe(exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).orNullSafe(exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<InflationRateSpecification>map("getInflationRateSpecification", rateSpecification -> rateSpecification.getInflationRateSpecification())))).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP), CardinalityOperator.Any))).getOrDefault(false)) {
										if (exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", _referenceWithMetaInterestRateIndex0 -> _referenceWithMetaInterestRateIndex0 == null ? null : _referenceWithMetaInterestRateIndex0.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<PeriodEnum>map("getPeriod", period -> period.getPeriod())).getOrDefault(false)) {
											return MapperS.of(translatePeriodEnum.evaluate(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", _referenceWithMetaInterestRateIndex1 -> _referenceWithMetaInterestRateIndex1 == null ? null : _referenceWithMetaInterestRateIndex1.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<PeriodEnum>map("getPeriod", period -> period.getPeriod()).get()));
										}
										if (exists(item.<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod())).getOrDefault(false)) {
											return MapperS.of(translatePeriodExtendedEnum.evaluate(item.<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod()).get()));
										}
										return MapperS.of(translatePeriodExtendedEnum.evaluate(item.<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).<PeriodExtendedEnum>map("getPeriod", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriod()).get()));
									}
									return MapperS.<AnnaDsbUnderlyingInstrumentIndexTermUnitEnum>ofNull();
								}).get();
						}
					}
				}
			}
			request
				.getOrCreateAttributes()
				.setReferenceRateTermUnit(ifThenElseResult13);
			
			final Integer ifThenElseResult14;
			if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.INFLATION_SWAP), CardinalityOperator.All).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult14 = null;
			} else {
				ifThenElseResult14 = MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get()))
					.mapSingleToItem(item -> {
						final Boolean _boolean = qualify_SubProduct_Basis.evaluate(product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get());
						if ((_boolean == null ? false : _boolean)) {
							if (exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", _referenceWithMetaInterestRateIndex0 -> _referenceWithMetaInterestRateIndex0 == null ? null : _referenceWithMetaInterestRateIndex0.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier())).getOrDefault(false)) {
								return item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", _referenceWithMetaInterestRateIndex1 -> _referenceWithMetaInterestRateIndex1 == null ? null : _referenceWithMetaInterestRateIndex1.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<Integer>map("getPeriodMultiplier", period -> period.getPeriodMultiplier());
							}
							return item.<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<Integer>map("getPeriodMultiplier", frequency -> frequency.getPeriodMultiplier());
						}
						return MapperS.<Integer>ofNull();
					}).get();
			}
			request
				.getOrCreateAttributes()
				.setOtherLegReferenceRateTermValue(ifThenElseResult14);
			
			final AnnaDsbUnderlyingInstrumentIndexTermUnitEnum ifThenElseResult15;
			if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.INFLATION_SWAP), CardinalityOperator.All).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult15 = null;
			} else {
				ifThenElseResult15 = MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get()))
					.mapSingleToItem(item -> {
						final Boolean _boolean = qualify_SubProduct_Basis.evaluate(product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get());
						if ((_boolean == null ? false : _boolean)) {
							if (exists(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", _referenceWithMetaInterestRateIndex0 -> _referenceWithMetaInterestRateIndex0 == null ? null : _referenceWithMetaInterestRateIndex0.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<PeriodEnum>map("getPeriod", period -> period.getPeriod())).getOrDefault(false)) {
								return MapperS.of(translatePeriodEnum.evaluate(item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification()).<ReferenceWithMetaInterestRateIndex>map("getRateOption", floatingRateSpecification -> floatingRateSpecification.getRateOption()).<InterestRateIndex>map("Type coercion", _referenceWithMetaInterestRateIndex1 -> _referenceWithMetaInterestRateIndex1 == null ? null : _referenceWithMetaInterestRateIndex1.getValue()).<cdm.observable.asset.FloatingRateIndex>map("getFloatingRateIndex", interestRateIndex -> interestRateIndex.getFloatingRateIndex()).<Period>map("getIndexTenor", _floatingRateIndex -> _floatingRateIndex.getIndexTenor()).<PeriodEnum>map("getPeriod", period -> period.getPeriod()).get()));
							}
							if (exists(item.<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod())).getOrDefault(false)) {
								if (areEqual(item.<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.C), CardinalityOperator.All).getOrDefault(false)) {
									return MapperS.of(translatePeriodExtendedEnum.evaluate(item.<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).<PeriodExtendedEnum>map("getPeriod", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriod()).get()));
								}
								return MapperS.of(translatePeriodExtendedEnum.evaluate(item.<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod()).get()));
							}
							return MapperS.<AnnaDsbUnderlyingInstrumentIndexTermUnitEnum>ofNull();
						}
						return MapperS.<AnnaDsbUnderlyingInstrumentIndexTermUnitEnum>ofNull();
					}).get();
			}
			request
				.getOrCreateAttributes()
				.setOtherLegReferenceRateTermUnit(ifThenElseResult15);
			
			request
				.getOrCreateAttributes()
				.setUnderlyingInstrumentIndexTermValue(MapperS.of(interestRateLeg1CapFloor.evaluate(product(reportableEvent).get()))
					.mapSingleToItem(item -> {
						final Boolean _boolean = isCapFloor.evaluate(product(reportableEvent).get());
						if ((_boolean == null ? false : _boolean)) {
							final MapperC<InterestRatePayout> _thenArg0 = economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
								.filterItemNullSafe(_item -> exists(_item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).get());
							if (exists(_thenArg0
								.first()).asMapper().getOrDefault(false)) {
								final MapperC<InterestRatePayout> _thenArg1 = economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
									.filterItemNullSafe(_item -> exists(_item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).get());
								final MapperC<InterestRatePayout> _thenArg2 = economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout())
									.filterItemNullSafe(_item -> exists(_item.<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).get());
								return MapperS.of(compute_IndexTermValue.evaluate(_thenArg1
									.first().<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getTerminationDate", calculationPeriodDates -> calculationPeriodDates.getTerminationDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get(), _thenArg2
									.first().<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<AdjustableOrRelativeDate>map("getEffectiveDate", calculationPeriodDates -> calculationPeriodDates.getEffectiveDate()).<AdjustableDate>map("getAdjustableDate", adjustableOrRelativeDate -> adjustableOrRelativeDate.getAdjustableDate()).<Date>map("getUnadjustedDate", adjustableDate -> adjustableDate.getUnadjustedDate()).get()));
							}
							return item.<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<Integer>map("getPeriodMultiplier", frequency -> frequency.getPeriodMultiplier());
						}
						return MapperS.<Integer>ofNull();
					}).get());
			
			request
				.getOrCreateAttributes()
				.setUnderlyingInstrumentIndexTermUnit(MapperS.of(interestRateLeg1CapFloor.evaluate(product(reportableEvent).get()))
					.mapSingleToItem(item -> {
						final Boolean _boolean = isCapFloor.evaluate(product(reportableEvent).get());
						if ((_boolean == null ? false : _boolean)) {
							if (areEqual(item.<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.T), CardinalityOperator.All).getOrDefault(false)) {
								return MapperS.of(AnnaDsbUnderlyingInstrumentIndexTermUnitEnum.YEAR);
							}
							if (areEqual(item.<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod()), MapperS.of(PeriodExtendedEnum.C), CardinalityOperator.All).getOrDefault(false)) {
								return MapperS.of(translatePeriodExtendedEnum.evaluate(item.<CalculationPeriodDates>map("getCalculationPeriodDates", interestRatePayout -> interestRatePayout.getCalculationPeriodDates()).<CalculationPeriodFrequency>map("getCalculationPeriodFrequency", calculationPeriodDates -> calculationPeriodDates.getCalculationPeriodFrequency()).<PeriodExtendedEnum>map("getPeriod", calculationPeriodFrequency -> calculationPeriodFrequency.getPeriod()).get()));
							}
							return MapperS.of(translatePeriodExtendedEnum.evaluate(item.<PaymentDates>map("getPaymentDates", interestRatePayout -> interestRatePayout.getPaymentDates()).<Frequency>map("getPaymentFrequency", paymentDates -> paymentDates.getPaymentFrequency()).<PeriodExtendedEnum>map("getPeriod", frequency -> frequency.getPeriod()).get()));
						}
						return MapperS.<AnnaDsbUnderlyingInstrumentIndexTermUnitEnum>ofNull();
					}).get());
			
			final AnnaDsbDebtSeniorityEnum ifThenElseResult16;
			if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.All).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult16 = null;
			} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_SingleName.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Loan.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				ifThenElseResult16 = debtSeniority.evaluate(product(reportableEvent).get(), useCase(reportableEvent).get());
			} else {
				ifThenElseResult16 = null;
			}
			request
				.getOrCreateAttributes()
				.setDebtSeniority(ifThenElseResult16);
			
			final Boolean boolean15 = qualify_CreditDefaultSwap_SingleName.evaluate(economicTerms(reportableEvent).get());
			AnnaDsbContractSpecificationEnum ifThenElseResult17 = null;
			if ((boolean15 == null ? false : boolean15)) {
				final FieldWithMetaString fieldWithMetaString12 = isdaTaxonomy(reportableEvent).get();
				ifThenElseResult17 = MapperS.of(replaceAll.evaluate((fieldWithMetaString12 == null ? null : fieldWithMetaString12.getValue()), "[^:]+:", "")).checkedMap("to-enum", AnnaDsbContractSpecificationEnum::fromDisplayName, IllegalArgumentException.class).get();
			}
			request
				.getOrCreateAttributes()
				.setContractSpecification(ifThenElseResult17);
			
			final AnnaDsbReturnorPayoutTriggerEnum ifThenElseResult18;
			if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString13 -> fieldWithMetaString13 == null ? null : fieldWithMetaString13.getValue()), MapperS.of("ForeignExchange:ComplexExotic"), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isFXForward.evaluate(product(reportableEvent).get())))).getOrDefault(false)) {
				ifThenElseResult18 = AnnaDsbReturnorPayoutTriggerEnum.FORWARD_PRICE_OF_UNDERLYING_INSTRUMENT;
			} else if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.DEBT), CardinalityOperator.All).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Forward.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				ifThenElseResult18 = AnnaDsbReturnorPayoutTriggerEnum.FORWARD_PRICE_OF_UNDERLYING_INSTRUMENT;
			} else if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_SingleName.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Basket.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Index.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(reportableEvent).get()))))).getOrDefault(false)) {
				ifThenElseResult18 = AnnaDsbReturnorPayoutTriggerEnum.OTHER;
			} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				ifThenElseResult18 = AnnaDsbReturnorPayoutTriggerEnum.TOTAL_RETURN;
			} else {
				ifThenElseResult18 = null;
			}
			request
				.getOrCreateAttributes()
				.setReturnorPayoutTrigger(ifThenElseResult18);
			
			AnnaDsbUnderlyingAssetTypeEnum ifThenElseResult19 = null;
			if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString14 -> fieldWithMetaString14 == null ? null : fieldWithMetaString14.getValue()), MapperS.of("ForeignExchange:ComplexExotic"), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult19 = AnnaDsbUnderlyingAssetTypeEnum.SPOT;
			}
			request
				.getOrCreateAttributes()
				.setUnderlyingAssetType(ifThenElseResult19);
			
			AnnaDsbUnderlyingIssuerTypeEnum ifThenElseResult20 = null;
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Index.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Loan.evaluate(economicTerms(reportableEvent).get())))).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP), CardinalityOperator.Any)).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.Any)).getOrDefault(false)) {
				ifThenElseResult20 = AnnaDsbUnderlyingIssuerTypeEnum.CORPORATE;
			}
			request
				.getOrCreateAttributes()
				.setUnderlyingIssuerType(ifThenElseResult20);
			
			final AnnaDsbUnderlying ifThenElseResult21;
			if (ComparisonResult.ofNullSafe(MapperS.of(isCredit.evaluate(product(reportableEvent).get()))).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.SINGLE_NAME_SWAPTION), CardinalityOperator.Any)).andNullSafe(notEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.INDEX_SWAPTION), CardinalityOperator.Any)).getOrDefault(false)) {
				if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult21 = create_AnnaDsbUpiRequestUnderlyingForCreditNonStandard.evaluate(product(reportableEvent).get());
				} else {
					ifThenElseResult21 = create_AnnaDsbUpiRequestUnderlyingForCredit.evaluate(product(reportableEvent).get(), useCase(reportableEvent).get());
				}
			} else if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.DEBT), CardinalityOperator.All).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult21 = create_AnnaDsbUpiRequestUnderlyingForRate.evaluate(product(reportableEvent).get(), TradeForEvent(reportableEvent).get(), useCase(reportableEvent).get());
			} else {
				ifThenElseResult21 = null;
			}
			request
				.getOrCreateAttributes()
				.setUnderlying(ifThenElseResult21);
			
			AnnaDsbOtherLegUnderlying ifThenElseResult22 = null;
			if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.All).andNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_SubProduct_Basis.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				ifThenElseResult22 = create_AnnaDsbUpiRequestOtherLegUnderlyingForRate.evaluate(product(reportableEvent).get(), TradeForEvent(reportableEvent).get(), useCase(reportableEvent).get());
			}
			request
				.getOrCreateAttributes()
				.setOtherLegUnderlying(ifThenElseResult22);
			
			AnnaDsbNotionalScheduleEnum ifThenElseResult23 = null;
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_IRSwap.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_Inflation.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_CrossCurrency_Basis.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_CrossCurrency_FixedFloat.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_CrossCurrency_FixedFixed.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				if (exists(leg1(reportableEvent)).andNullSafe(areEqual(leg1(reportableEvent), leg2(reportableEvent), CardinalityOperator.All)).getOrDefault(false)) {
					ifThenElseResult23 = leg1(reportableEvent).get();
				} else {
					ifThenElseResult23 = AnnaDsbNotionalScheduleEnum.CUSTOM;
				}
			}
			request
				.getOrCreateAttributes()
				.setNotionalSchedule(ifThenElseResult23);
			
			AnnaDsbBaseProduct ifThenElseResult24 = null;
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Option.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Forward.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				ifThenElseResult24 = create_AnnaDsbUpiRequestBaseProductForCommodity.evaluate(product(reportableEvent).get());
			}
			request
				.getOrCreateAttributes()
				.setBaseProduct(ifThenElseResult24);
			
			return Optional.ofNullable(request)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends Trade> TradeForEvent(ReportableEventBase reportableEvent) {
			if (exists(MapperS.of(reportableEvent).<TradeState>map("getReportableTrade", reportableEventBase -> reportableEventBase.getReportableTrade())).getOrDefault(false)) {
				return MapperS.of(reportableEvent).<TradeState>map("getReportableTrade", reportableEventBase -> reportableEventBase.getReportableTrade()).<Trade>map("getTrade", tradeState -> tradeState.getTrade());
			}
			return MapperS.of(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<TradeState>mapC("getAfter", businessEvent -> businessEvent.getAfter()).<Trade>map("getTrade", tradeState -> tradeState.getTrade()).get());
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent) {
			return product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> isdaTaxonomy(ReportableEventBase reportableEvent) {
			final MapperC<ProductTaxonomy> thenArg0 = product(reportableEvent).<ProductTaxonomy>mapC("getTaxonomy", nonTransferableProduct -> nonTransferableProduct.getTaxonomy())
				.filterItemNullSafe(item -> areEqual(item.<TaxonomySourceEnum>map("getSource", productTaxonomy -> productTaxonomy.getSource()), MapperS.of(TaxonomySourceEnum.ISDA), CardinalityOperator.All).andNullSafe(exists(item.<TaxonomyValue>map("getValue", productTaxonomy -> productTaxonomy.getValue()).<FieldWithMetaString>map("getName", taxonomyValue -> taxonomyValue.getName()))).get());
			final MapperS<ProductTaxonomy> thenArg1 = thenArg0
				.first();
			return thenArg1.<TaxonomyValue>map("getValue", productTaxonomy -> productTaxonomy.getValue()).<FieldWithMetaString>map("getName", taxonomyValue -> taxonomyValue.getName());
		}
		
		@Override
		protected MapperS<Boolean> isSwaption(ReportableEventBase reportableEvent) {
			return ComparisonResult.ofNullSafe(MapperS.of(isCreditSwaption.evaluate(TradeForEvent(reportableEvent).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(isIRSwaption.evaluate(TradeForEvent(reportableEvent).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).get())))).asMapper();
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			if (isSwaption(reportableEvent).getOrDefault(false)) {
				final MapperC<ProductIdentifier> thenArg = MapperS.of(TradeForEvent(reportableEvent).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).<ProductIdentifier>mapC("getIdentifier", nonTransferableProduct -> nonTransferableProduct.getIdentifier())
					.filterItemNullSafe(item -> areEqual(item.<ProductIdTypeEnum>map("getSource", productIdentifier -> productIdentifier.getSource()), MapperS.of(ProductIdTypeEnum.UPI), CardinalityOperator.All).get());
				if (notExists(thenArg).asMapper().getOrDefault(false)) {
					return MapperS.of(TradeForEvent(reportableEvent).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct());
				}
				return TradeForEvent(reportableEvent).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct());
			}
			return TradeForEvent(reportableEvent).<NonTransferableProduct>map("getProduct", trade -> trade.getProduct());
		}
		
		@Override
		protected MapperS<Boolean> isOption1(ReportableEventBase reportableEvent) {
			return MapperS.of(isOption0.evaluate(product(reportableEvent).get()));
		}
		
		@Override
		protected MapperS<AnnaDsbUseCaseEnum> useCase(ReportableEventBase reportableEvent) {
			if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), MapperS.of("ForeignExchange:SimpleExotic:Digital"), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(AnnaDsbUseCaseEnum.DIGITAL_OPTION);
			}
			if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), MapperS.of("ForeignExchange:SimpleExotic:Barrier"), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(AnnaDsbUseCaseEnum.BARRIER_OPTION);
			}
			if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString2 -> fieldWithMetaString2 == null ? null : fieldWithMetaString2.getValue()), MapperS.of("ForeignExchange:NDO"), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(AnnaDsbUseCaseEnum.NDO);
			}
			if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString3 -> fieldWithMetaString3 == null ? null : fieldWithMetaString3.getValue()), MapperS.of("ForeignExchange:ComplexExotic"), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD);
			}
			final Boolean boolean0 = qualify_ForeignExchange_VanillaOption.evaluate(economicTerms(reportableEvent).get());
			if ((boolean0 == null ? false : boolean0)) {
				return MapperS.of(AnnaDsbUseCaseEnum.VANILLA_OPTION);
			}
			final Boolean boolean1 = qualify_ForeignExchange_Spot_Forward.evaluate(economicTerms(reportableEvent).get());
			if ((boolean1 == null ? false : boolean1)) {
				return MapperS.of(AnnaDsbUseCaseEnum.FORWARD);
			}
			final Boolean boolean2 = qualify_ForeignExchange_Swap.evaluate(economicTerms(reportableEvent).get());
			if ((boolean2 == null ? false : boolean2)) {
				return MapperS.of(AnnaDsbUseCaseEnum.FX_SWAP);
			}
			final Boolean boolean3 = qualify_ForeignExchange_NDS.evaluate(economicTerms(reportableEvent).get());
			if ((boolean3 == null ? false : boolean3)) {
				return MapperS.of(AnnaDsbUseCaseEnum.NON_DELIVERABLE_FX_SWAP);
			}
			final Boolean boolean4 = qualify_ForeignExchange_NDF.evaluate(economicTerms(reportableEvent).get());
			if ((boolean4 == null ? false : boolean4)) {
				return MapperS.of(AnnaDsbUseCaseEnum.NDF);
			}
			if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString4 -> fieldWithMetaString4 == null ? null : fieldWithMetaString4.getValue()), MapperS.of("InterestRate:Exotic"), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD);
			}
			if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString5 -> fieldWithMetaString5 == null ? null : fieldWithMetaString5.getValue()), MapperS.of("InterestRate:Forward:Debt"), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(AnnaDsbUseCaseEnum.DEBT);
			}
			if (areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString6 -> fieldWithMetaString6 == null ? null : fieldWithMetaString6.getValue()), MapperS.of("InterestRate:FRA"), CardinalityOperator.All).getOrDefault(false)) {
				return MapperS.of(AnnaDsbUseCaseEnum.FRA_INDEX);
			}
			final Boolean boolean5 = qualify_InterestRate_IRSwap_FixedFloat.evaluate(economicTerms(reportableEvent).get());
			if ((boolean5 == null ? false : boolean5)) {
				return MapperS.of(AnnaDsbUseCaseEnum.FIXED_FLOAT);
			}
			final Boolean boolean6 = qualify_InterestRate_IRSwap_FixedFixed.evaluate(economicTerms(reportableEvent).get());
			if ((boolean6 == null ? false : boolean6)) {
				return MapperS.of(AnnaDsbUseCaseEnum.FIXED_FIXED);
			}
			final Boolean boolean7 = qualify_InterestRate_InflationSwap_FixedFloat_YearOn_Year.evaluate(economicTerms(reportableEvent).get());
			if ((boolean7 == null ? false : boolean7)) {
				return MapperS.of(AnnaDsbUseCaseEnum.INFLATION_FIXED_FLOAT_YO_Y);
			}
			final Boolean boolean8 = qualify_InterestRate_InflationSwap_FixedFloat_ZeroCoupon.evaluate(economicTerms(reportableEvent).get());
			if ((boolean8 == null ? false : boolean8)) {
				return MapperS.of(AnnaDsbUseCaseEnum.INFLATION_FIXED_FLOAT_ZERO_COUPON);
			}
			final Boolean boolean9 = qualify_InterestRate_InflationSwap_Basis_YearOn_Year.evaluate(economicTerms(reportableEvent).get());
			if ((boolean9 == null ? false : boolean9)) {
				return MapperS.of(AnnaDsbUseCaseEnum.INFLATION_BASIS_YO_Y);
			}
			final Boolean boolean10 = qualify_InterestRate_InflationSwap_Basis_ZeroCoupon.evaluate(economicTerms(reportableEvent).get());
			if ((boolean10 == null ? false : boolean10)) {
				return MapperS.of(AnnaDsbUseCaseEnum.INFLATION_BASIS_ZERO_COUPON);
			}
			final Boolean boolean11 = qualify_BaseProduct_Inflation.evaluate(economicTerms(reportableEvent).get());
			if ((boolean11 == null ? false : boolean11)) {
				return MapperS.of(AnnaDsbUseCaseEnum.INFLATION_SWAP);
			}
			final Boolean boolean12 = qualify_InterestRate_CrossCurrency_FixedFixed.evaluate(economicTerms(reportableEvent).get());
			if ((boolean12 == null ? false : boolean12)) {
				return MapperS.of(AnnaDsbUseCaseEnum.CROSS_CURRENCY_FIXED_FIXED);
			}
			final Boolean boolean13 = qualify_InterestRate_CrossCurrency_FixedFloat.evaluate(economicTerms(reportableEvent).get());
			if ((boolean13 == null ? false : boolean13)) {
				return MapperS.of(AnnaDsbUseCaseEnum.CROSS_CURRENCY_FIXED_FLOAT);
			}
			final Boolean boolean14 = qualify_InterestRate_IRSwap_Basis.evaluate(economicTerms(reportableEvent).get());
			if ((boolean14 == null ? false : boolean14)) {
				return MapperS.of(AnnaDsbUseCaseEnum.BASIS);
			}
			final Boolean boolean15 = qualify_InterestRate_IRSwap_Basis_OIS.evaluate(economicTerms(reportableEvent).get());
			if ((boolean15 == null ? false : boolean15)) {
				return MapperS.of(AnnaDsbUseCaseEnum.BASIS_OIS);
			}
			final Boolean boolean16 = qualify_InterestRate_IRSwap_FixedFloat_ZeroCoupon.evaluate(economicTerms(reportableEvent).get());
			if ((boolean16 == null ? false : boolean16)) {
				return MapperS.of(AnnaDsbUseCaseEnum.FIXED_FLOAT_ZERO_COUPON);
			}
			final Boolean boolean17 = qualify_InterestRate_IRSwap_FixedFloat_OIS.evaluate(economicTerms(reportableEvent).get());
			if ((boolean17 == null ? false : boolean17)) {
				return MapperS.of(AnnaDsbUseCaseEnum.FIXED_FLOAT_OIS);
			}
			final Boolean boolean18 = qualify_InterestRate_CrossCurrency_Basis.evaluate(economicTerms(reportableEvent).get());
			if ((boolean18 == null ? false : boolean18)) {
				return MapperS.of(AnnaDsbUseCaseEnum.CROSS_CURRENCY_BASIS);
			}
			final Boolean boolean19 = qualify_InterestRate_Option_Swaption.evaluate(economicTerms(reportableEvent).get());
			if ((boolean19 == null ? false : boolean19)) {
				return MapperS.of(AnnaDsbUseCaseEnum.SWAPTION);
			}
			final Boolean boolean20 = qualify_InterestRate_CapFloor.evaluate(economicTerms(reportableEvent).get());
			if ((boolean20 == null ? false : boolean20)) {
				return MapperS.of(AnnaDsbUseCaseEnum.CAP_FLOOR);
			}
			final Boolean boolean21 = qualify_InterestRate_Option_DebtOption.evaluate(economicTerms(reportableEvent).get());
			if ((boolean21 == null ? false : boolean21)) {
				return MapperS.of(AnnaDsbUseCaseEnum.DEBT_OPTION);
			}
			final Boolean boolean22 = qualify_CreditDefaultSwap_Loan.evaluate(economicTerms(reportableEvent).get());
			if ((boolean22 == null ? false : boolean22)) {
				return MapperS.of(AnnaDsbUseCaseEnum.LOAN);
			}
			final Boolean boolean23 = qualify_CreditDefaultSwap_Index.evaluate(economicTerms(reportableEvent).get());
			if ((boolean23 == null ? false : boolean23)) {
				return MapperS.of(AnnaDsbUseCaseEnum.INDEX);
			}
			final Boolean boolean24 = qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(reportableEvent).get());
			if ((boolean24 == null ? false : boolean24)) {
				return MapperS.of(AnnaDsbUseCaseEnum.INDEX_TRANCHE);
			}
			final Boolean boolean25 = qualify_CreditDefaultSwaption.evaluate(economicTerms(reportableEvent).get());
			if ((boolean25 == null ? false : boolean25)) {
				final Boolean boolean26 = qualify_CreditDefaultSwap_SingleName.evaluate(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get());
				if ((boolean26 == null ? false : boolean26)) {
					return MapperS.of(AnnaDsbUseCaseEnum.SINGLE_NAME_SWAPTION);
				}
				final Boolean boolean27 = qualify_CreditDefaultSwap_Index.evaluate(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms()).get());
				if ((boolean27 == null ? false : boolean27)) {
					return MapperS.of(AnnaDsbUseCaseEnum.INDEX_SWAPTION);
				}
				return MapperS.<AnnaDsbUseCaseEnum>ofNull();
			}
			final FieldWithMetaString fieldWithMetaString7 = isdaTaxonomy(reportableEvent).get();
			final Boolean boolean28 = stringContains.evaluate((fieldWithMetaString7 == null ? null : fieldWithMetaString7.getValue()), "^Credit:SingleName:Corporate:.*");
			if ((boolean28 == null ? false : boolean28)) {
				return MapperS.of(AnnaDsbUseCaseEnum.CORPORATE);
			}
			final FieldWithMetaString fieldWithMetaString8 = isdaTaxonomy(reportableEvent).get();
			final Boolean boolean29 = stringContains.evaluate((fieldWithMetaString8 == null ? null : fieldWithMetaString8.getValue()), "^Credit:SingleName:Sovereign:.*");
			if ((boolean29 == null ? false : boolean29)) {
				return MapperS.of(AnnaDsbUseCaseEnum.SOVEREIGN);
			}
			final FieldWithMetaString fieldWithMetaString9 = isdaTaxonomy(reportableEvent).get();
			final Boolean boolean30 = stringContains.evaluate((fieldWithMetaString9 == null ? null : fieldWithMetaString9.getValue()), "^Credit:SingleName:Muni:.*");
			if ((boolean30 == null ? false : boolean30)) {
				return MapperS.of(AnnaDsbUseCaseEnum.MUNICIPAL);
			}
			final FieldWithMetaString fieldWithMetaString10 = isdaTaxonomy(reportableEvent).get();
			final Boolean boolean31 = stringContains.evaluate((fieldWithMetaString10 == null ? null : fieldWithMetaString10.getValue()), "^Credit:TotalReturnSwap.*");
			if ((boolean31 == null ? false : boolean31)) {
				return MapperS.of(AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP);
			}
			final FieldWithMetaString fieldWithMetaString11 = isdaTaxonomy(reportableEvent).get();
			final Boolean boolean32 = stringContains.evaluate((fieldWithMetaString11 == null ? null : fieldWithMetaString11.getValue()), "^Credit:Exotic.*");
			if ((boolean32 == null ? false : boolean32)) {
				return MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD);
			}
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				return MapperS.of(AnnaDsbUseCaseEnum.SWAP);
			}
			final Boolean boolean33 = qualify_Commodity_Swaption.evaluate(economicTerms(reportableEvent).get());
			if ((boolean33 == null ? false : boolean33)) {
				return MapperS.of(AnnaDsbUseCaseEnum.SWAPTION);
			}
			final Boolean boolean34 = qualify_Commodity_Option.evaluate(economicTerms(reportableEvent).get());
			if ((boolean34 == null ? false : boolean34)) {
				return MapperS.of(AnnaDsbUseCaseEnum.OPTION);
			}
			final Boolean boolean35 = qualify_Commodity_Forward.evaluate(economicTerms(reportableEvent).get());
			if ((boolean35 == null ? false : boolean35)) {
				return MapperS.of(AnnaDsbUseCaseEnum.FORWARD);
			}
			return MapperS.<AnnaDsbUseCaseEnum>ofNull();
		}
		
		@Override
		protected MapperS<? extends SettlementTerms> settlementTerms(ReportableEventBase reportableEvent) {
			return MapperC.<SettlementTerms>of(economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()), economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<SettlementTerms>map("getSettlementTerms", optionPayout -> optionPayout.getSettlementTerms()), economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<SettlementTerms>map("getSettlementTerms", interestRatePayout -> interestRatePayout.getSettlementTerms()), economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", creditDefaultPayout -> creditDefaultPayout.getSettlementTerms()))
				.first();
		}
		
		@Override
		protected MapperS<AnnaDsbNotionalScheduleEnum> leg1(ReportableEventBase reportableEvent) {
			final Boolean _boolean = qualify_BaseProduct_IRSwap.evaluate(economicTerms(reportableEvent).get());
			if ((_boolean == null ? false : _boolean)) {
				return MapperS.of(compute_NotionalScheduleType.evaluate(MapperS.of(quantityScheduleRule.evaluate(payoutLeg1Rule.evaluate(reportableEvent))).<DatedValue>mapC("getDatedValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getDatedValue()).<BigDecimal>map("getValue", datedValue -> datedValue.getValue()).getMulti()));
			}
			return MapperS.<AnnaDsbNotionalScheduleEnum>ofNull();
		}
		
		@Override
		protected MapperS<AnnaDsbNotionalScheduleEnum> leg2(ReportableEventBase reportableEvent) {
			final Boolean _boolean = qualify_BaseProduct_IRSwap.evaluate(economicTerms(reportableEvent).get());
			if ((_boolean == null ? false : _boolean)) {
				return MapperS.of(compute_NotionalScheduleType.evaluate(MapperS.of(quantityScheduleRule.evaluate(payoutLeg2Rule.evaluate(reportableEvent))).<DatedValue>mapC("getDatedValue", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getDatedValue()).<BigDecimal>map("getValue", datedValue -> datedValue.getValue()).getMulti()));
			}
			return MapperS.<AnnaDsbNotionalScheduleEnum>ofNull();
		}
		
		@Override
		protected MapperS<? extends InterestRatePayout> interestRatePayoutFloatingLeg(ReportableEventBase reportableEvent) {
			if (exists(MapperS.of(interestRateLeg1.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).getOrDefault(false)) {
				return MapperS.of(interestRateLeg1.evaluate(product(reportableEvent).get()));
			}
			if (exists(MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get())).<RateSpecification>map("getRateSpecification", interestRatePayout -> interestRatePayout.getRateSpecification()).<FloatingRateSpecification>map("getFloatingRateSpecification", rateSpecification -> rateSpecification.getFloatingRateSpecification())).getOrDefault(false)) {
				return MapperS.of(interestRateLeg2.evaluate(product(reportableEvent).get()));
			}
			return MapperS.<InterestRatePayout>ofNull();
		}
		
		@Override
		protected MapperS<AnnaDsbInstrumentTypeEnum> instrumentType(ReportableEventBase reportableEvent) {
			if (ComparisonResult.ofNullSafe(isOption1(reportableEvent)).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_InterestRate_CapFloor.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwaption.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				return MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION);
			}
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Swap.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDS.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_EquitySwap.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_IRSwap.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_CrossCurrency.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_Inflation.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_SingleName.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Basket.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_Index.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_CreditDefaultSwap_IndexTranche.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP), CardinalityOperator.All)).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
				return MapperS.of(AnnaDsbInstrumentTypeEnum.SWAP);
			}
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_Fra.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_NDF.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_ForeignExchange_Spot_Forward.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Forward.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(areEqual(isdaTaxonomy(reportableEvent).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue()), MapperS.of("InterestRate:Forward:Debt"), CardinalityOperator.All)).getOrDefault(false)) {
				return MapperS.of(AnnaDsbInstrumentTypeEnum.FORWARD);
			}
			return MapperS.<AnnaDsbInstrumentTypeEnum>ofNull();
		}
	}
}
