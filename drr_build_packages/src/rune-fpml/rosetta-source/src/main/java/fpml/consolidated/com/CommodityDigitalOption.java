package fpml.consolidated.com;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.asset.Commodity;
import fpml.consolidated.com.meta.CommodityDigitalOptionMeta;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.fpmlenum.PutCallEnum;
import fpml.consolidated.option.shared.Option;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NotionalAmount;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.Rounding;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Defines the digital commodity option product type. Digital options exercise when a barrier is breached and are financially settled. The 'commodityDigitalOption' type is an extension of the 'commodityOption' product.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines the digital commodity option product type. Digital options exercise when a barrier is breached and are financially settled. The 'commodityDigitalOption' type is an extension of the 'commodityOption' product.
 *
 */
@RosettaDataType(value="CommodityDigitalOption", builder=CommodityDigitalOption.CommodityDigitalOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityDigitalOption", model="fpml", builder=CommodityDigitalOption.CommodityDigitalOptionBuilderImpl.class, version="2.1.1")
public interface CommodityDigitalOption extends Option {

	CommodityDigitalOptionMeta metaData = new CommodityDigitalOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of option transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of option transaction.
	 *
	 */
	PutCallEnum getOptionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the underlying instrument. Usual content is an ISDA Commodity Reference Price Name. The 'commodity' underlyer component is specified using a reference to the 'commodity' asset (see description above at the Commodity Underlyer section).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the underlying instrument. Usual content is an ISDA Commodity Reference Price Name. The 'commodity' underlyer component is specified using a reference to the 'commodity' asset (see description above at the Commodity Underlyer section).
	 *
	 */
	Commodity getCommodity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The effective date of the Commodity Option Transaction. Note that the Termination/Expiration Date should be specified in expirationDate within the CommodityAmericanExercise type or the CommodityEuropeanExercise type, as applicable.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The effective date of the Commodity Option Transaction. Note that the Termination/Expiration Date should be specified in expirationDate within the CommodityAmericanExercise type or the CommodityEuropeanExercise type, as applicable.
	 *
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the termination date of the Commodity Option Transaction. In some confirmations this will be indicated as the second date in "Option Term" or "Term". Note: If provided, terminationDate should not be before specified expirationDate within the CommodityAmericanExercise type or the CommodityEuropeanExercise type.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the termination date of the Commodity Option Transaction. In some confirmations this will be indicated as the second date in "Option Term" or "Term". Note: If provided, terminationDate should not be before specified expirationDate within the CommodityAmericanExercise type or the CommodityEuropeanExercise type.
	 *
	 */
	AdjustableOrRelativeDate getTerminationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A parametric representation of the Calculation Periods of the Commodity Option Transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A parametric representation of the Calculation Periods of the Commodity Option Transaction.
	 *
	 */
	CommodityCalculationPeriodsSchedule getCalculationPeriodsSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An absolute representation of the Calculation Period start dates of the Commodity Option Transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An absolute representation of the Calculation Period start dates of the Commodity Option Transaction.
	 *
	 */
	AdjustableDates getCalculationPeriods();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The dates on which the option will price.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The dates on which the option will price.
	 *
	 */
	CommodityPricingDates getPricingDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Method of Averaging if there is more than one Pricing Date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Method of Averaging if there is more than one Pricing Date.
	 *
	 */
	AveragingMethodEnum getAveragingMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The barrier and cash payout features of the digital option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The barrier and cash payout features of the digital option.
	 *
	 */
	CommodityDigital getDigital();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Volume contracted when volume is specified as a currency-denominated amount.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Volume contracted when volume is specified as a currency-denominated amount.
	 *
	 */
	NotionalAmount getNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The volume contracted when the volume is specified as a quantity of commodity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The volume contracted when the volume is specified as a quantity of commodity.
	 *
	 */
	CommodityNotionalQuantity getNotionalQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	BigDecimal getTotalNotionalQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining how the commodity option can be exercised and how it is settled.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining how the commodity option can be exercised and how it is settled.
	 *
	 */
	CommodityDigitalExercise getExercise();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The option premium payable by the buyer to the seller.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The option premium payable by the buyer to the seller.
	 *
	 */
	List<? extends CommodityPremium> getPremium();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If Common Pricing is elected (“true”) for a Transaction with referencing more than one Commodity Reference Price then no date will be a Pricing Date unless such a date is a day on which all Commodity Reference Prices are scheduled to be published.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If Common Pricing is elected (“true”) for a Transaction with referencing more than one Commodity Reference Price then no date will be a Pricing Date unless such a date is a day on which all Commodity Reference Prices are scheduled to be published.
	 *
	 */
	Boolean getCommonPricing();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Contains contract terms related to triggers and responses to market disruptions as defined in the 1993 or 2005 Commodity Definitions.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Contains contract terms related to triggers and responses to market disruptions as defined in the 1993 or 2005 Commodity Definitions.
	 *
	 */
	CommodityMarketDisruption getMarketDisruption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Describes contract terms related to the consequences of Bullion Settlement Disruption Events.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Describes contract terms related to the consequences of Bullion Settlement Disruption Events.
	 *
	 */
	CommodityBullionSettlementDisruptionEnum getSettlementDisruption();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Rounding direction and precision for amounts.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Rounding direction and precision for amounts.
	 *
	 */
	Rounding getRounding();

	/*********************** Build Methods  ***********************/
	CommodityDigitalOption build();
	
	CommodityDigitalOption.CommodityDigitalOptionBuilder toBuilder();
	
	static CommodityDigitalOption.CommodityDigitalOptionBuilder builder() {
		return new CommodityDigitalOption.CommodityDigitalOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityDigitalOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityDigitalOption> getType() {
		return CommodityDigitalOption.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.class, getPrimaryAssetClass());
		processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.class, getSecondaryAssetClass());
		processRosetta(path.newSubPath("productType"), processor, ProductType.class, getProductType());
		processRosetta(path.newSubPath("productId"), processor, ProductId.class, getProductId());
		processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.class, getEmbeddedOptionType());
		processRosetta(path.newSubPath("assetClass"), processor, AssetClass.class, getAssetClass());
		processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.class, getBuyerPartyReference());
		processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.class, getBuyerAccountReference());
		processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.class, getSellerPartyReference());
		processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.class, getSellerAccountReference());
		processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("calculationPeriodsSchedule"), processor, CommodityCalculationPeriodsSchedule.class, getCalculationPeriodsSchedule());
		processRosetta(path.newSubPath("calculationPeriods"), processor, AdjustableDates.class, getCalculationPeriods());
		processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.class, getPricingDates());
		processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
		processRosetta(path.newSubPath("digital"), processor, CommodityDigital.class, getDigital());
		processRosetta(path.newSubPath("notionalAmount"), processor, NotionalAmount.class, getNotionalAmount());
		processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.class, getNotionalQuantity());
		processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
		processRosetta(path.newSubPath("exercise"), processor, CommodityDigitalExercise.class, getExercise());
		processRosetta(path.newSubPath("premium"), processor, CommodityPremium.class, getPremium());
		processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
		processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.class, getMarketDisruption());
		processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
		processRosetta(path.newSubPath("rounding"), processor, Rounding.class, getRounding());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityDigitalOptionBuilder extends CommodityDigitalOption, Option.OptionBuilder {
		Commodity.CommodityBuilder getOrCreateCommodity();
		@Override
		Commodity.CommodityBuilder getCommodity();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate();
		@Override
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate();
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateCalculationPeriodsSchedule();
		@Override
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getCalculationPeriodsSchedule();
		AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationPeriods();
		@Override
		AdjustableDates.AdjustableDatesBuilder getCalculationPeriods();
		CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates();
		@Override
		CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates();
		CommodityDigital.CommodityDigitalBuilder getOrCreateDigital();
		@Override
		CommodityDigital.CommodityDigitalBuilder getDigital();
		NotionalAmount.NotionalAmountBuilder getOrCreateNotionalAmount();
		@Override
		NotionalAmount.NotionalAmountBuilder getNotionalAmount();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateNotionalQuantity();
		@Override
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getNotionalQuantity();
		CommodityDigitalExercise.CommodityDigitalExerciseBuilder getOrCreateExercise();
		@Override
		CommodityDigitalExercise.CommodityDigitalExerciseBuilder getExercise();
		CommodityPremium.CommodityPremiumBuilder getOrCreatePremium(int index);
		@Override
		List<? extends CommodityPremium.CommodityPremiumBuilder> getPremium();
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder getOrCreateMarketDisruption();
		@Override
		CommodityMarketDisruption.CommodityMarketDisruptionBuilder getMarketDisruption();
		Rounding.RoundingBuilder getOrCreateRounding();
		@Override
		Rounding.RoundingBuilder getRounding();
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder setId(String id);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addProductType(ProductType productType);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addProductType(ProductType productType, int idx);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addProductType(List<? extends ProductType> productType);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder setProductType(List<? extends ProductType> productType);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addProductId(ProductId productId);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addProductId(ProductId productId, int idx);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addProductId(List<? extends ProductId> productId);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder setProductId(List<? extends ProductId> productId);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addAssetClass(AssetClass assetClass);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		CommodityDigitalOption.CommodityDigitalOptionBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setOptionType(PutCallEnum optionType);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setCommodity(Commodity commodity);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule calculationPeriodsSchedule);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setCalculationPeriods(AdjustableDates calculationPeriods);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setPricingDates(CommodityPricingDates pricingDates);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setDigital(CommodityDigital digital);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setNotionalAmount(NotionalAmount notionalAmount);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setNotionalQuantity(CommodityNotionalQuantity notionalQuantity);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setExercise(CommodityDigitalExercise exercise);
		CommodityDigitalOption.CommodityDigitalOptionBuilder addPremium(CommodityPremium premium);
		CommodityDigitalOption.CommodityDigitalOptionBuilder addPremium(CommodityPremium premium, int idx);
		CommodityDigitalOption.CommodityDigitalOptionBuilder addPremium(List<? extends CommodityPremium> premium);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setPremium(List<? extends CommodityPremium> premium);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setCommonPricing(Boolean commonPricing);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setMarketDisruption(CommodityMarketDisruption marketDisruption);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum settlementDisruption);
		CommodityDigitalOption.CommodityDigitalOptionBuilder setRounding(Rounding rounding);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("primaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getPrimaryAssetClass());
			processRosetta(path.newSubPath("secondaryAssetClass"), processor, AssetClass.AssetClassBuilder.class, getSecondaryAssetClass());
			processRosetta(path.newSubPath("productType"), processor, ProductType.ProductTypeBuilder.class, getProductType());
			processRosetta(path.newSubPath("productId"), processor, ProductId.ProductIdBuilder.class, getProductId());
			processRosetta(path.newSubPath("embeddedOptionType"), processor, EmbeddedOptionType.EmbeddedOptionTypeBuilder.class, getEmbeddedOptionType());
			processRosetta(path.newSubPath("assetClass"), processor, AssetClass.AssetClassBuilder.class, getAssetClass());
			processRosetta(path.newSubPath("buyerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getBuyerPartyReference());
			processRosetta(path.newSubPath("buyerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getBuyerAccountReference());
			processRosetta(path.newSubPath("sellerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getSellerPartyReference());
			processRosetta(path.newSubPath("sellerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getSellerAccountReference());
			processor.processBasic(path.newSubPath("optionType"), PutCallEnum.class, getOptionType(), this);
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("calculationPeriodsSchedule"), processor, CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder.class, getCalculationPeriodsSchedule());
			processRosetta(path.newSubPath("calculationPeriods"), processor, AdjustableDates.AdjustableDatesBuilder.class, getCalculationPeriods());
			processRosetta(path.newSubPath("pricingDates"), processor, CommodityPricingDates.CommodityPricingDatesBuilder.class, getPricingDates());
			processor.processBasic(path.newSubPath("averagingMethod"), AveragingMethodEnum.class, getAveragingMethod(), this);
			processRosetta(path.newSubPath("digital"), processor, CommodityDigital.CommodityDigitalBuilder.class, getDigital());
			processRosetta(path.newSubPath("notionalAmount"), processor, NotionalAmount.NotionalAmountBuilder.class, getNotionalAmount());
			processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getNotionalQuantity());
			processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
			processRosetta(path.newSubPath("exercise"), processor, CommodityDigitalExercise.CommodityDigitalExerciseBuilder.class, getExercise());
			processRosetta(path.newSubPath("premium"), processor, CommodityPremium.CommodityPremiumBuilder.class, getPremium());
			processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
			processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.CommodityMarketDisruptionBuilder.class, getMarketDisruption());
			processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
			processRosetta(path.newSubPath("rounding"), processor, Rounding.RoundingBuilder.class, getRounding());
		}
		

		CommodityDigitalOption.CommodityDigitalOptionBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityDigitalOption  ***********************/
	class CommodityDigitalOptionImpl extends Option.OptionImpl implements CommodityDigitalOption {
		private final PutCallEnum optionType;
		private final Commodity commodity;
		private final AdjustableOrRelativeDate effectiveDate;
		private final AdjustableOrRelativeDate terminationDate;
		private final CommodityCalculationPeriodsSchedule calculationPeriodsSchedule;
		private final AdjustableDates calculationPeriods;
		private final CommodityPricingDates pricingDates;
		private final AveragingMethodEnum averagingMethod;
		private final CommodityDigital digital;
		private final NotionalAmount notionalAmount;
		private final CommodityNotionalQuantity notionalQuantity;
		private final BigDecimal totalNotionalQuantity;
		private final CommodityDigitalExercise exercise;
		private final List<? extends CommodityPremium> premium;
		private final Boolean commonPricing;
		private final CommodityMarketDisruption marketDisruption;
		private final CommodityBullionSettlementDisruptionEnum settlementDisruption;
		private final Rounding rounding;
		
		protected CommodityDigitalOptionImpl(CommodityDigitalOption.CommodityDigitalOptionBuilder builder) {
			super(builder);
			this.optionType = builder.getOptionType();
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.calculationPeriodsSchedule = ofNullable(builder.getCalculationPeriodsSchedule()).map(f->f.build()).orElse(null);
			this.calculationPeriods = ofNullable(builder.getCalculationPeriods()).map(f->f.build()).orElse(null);
			this.pricingDates = ofNullable(builder.getPricingDates()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.digital = ofNullable(builder.getDigital()).map(f->f.build()).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
			this.notionalQuantity = ofNullable(builder.getNotionalQuantity()).map(f->f.build()).orElse(null);
			this.totalNotionalQuantity = builder.getTotalNotionalQuantity();
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commonPricing = builder.getCommonPricing();
			this.marketDisruption = ofNullable(builder.getMarketDisruption()).map(f->f.build()).orElse(null);
			this.settlementDisruption = builder.getSettlementDisruption();
			this.rounding = ofNullable(builder.getRounding()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("commodity")
		public Commodity getCommodity() {
			return commodity;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminationDate")
		public AdjustableOrRelativeDate getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsSchedule")
		public CommodityCalculationPeriodsSchedule getCalculationPeriodsSchedule() {
			return calculationPeriodsSchedule;
		}
		
		@Override
		@RosettaAttribute("calculationPeriods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriods")
		public AdjustableDates getCalculationPeriods() {
			return calculationPeriods;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingDates")
		public CommodityPricingDates getPricingDates() {
			return pricingDates;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("digital")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("digital")
		public CommodityDigital getDigital() {
			return digital;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public NotionalAmount getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantity")
		public CommodityNotionalQuantity getNotionalQuantity() {
			return notionalQuantity;
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalNotionalQuantity")
		public BigDecimal getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@Override
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exercise")
		public CommodityDigitalExercise getExercise() {
			return exercise;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("premium")
		public List<? extends CommodityPremium> getPremium() {
			return premium;
		}
		
		@Override
		@RosettaAttribute("commonPricing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commonPricing")
		public Boolean getCommonPricing() {
			return commonPricing;
		}
		
		@Override
		@RosettaAttribute("marketDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketDisruption")
		public CommodityMarketDisruption getMarketDisruption() {
			return marketDisruption;
		}
		
		@Override
		@RosettaAttribute("settlementDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDisruption")
		public CommodityBullionSettlementDisruptionEnum getSettlementDisruption() {
			return settlementDisruption;
		}
		
		@Override
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rounding")
		public Rounding getRounding() {
			return rounding;
		}
		
		@Override
		public CommodityDigitalOption build() {
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder toBuilder() {
			CommodityDigitalOption.CommodityDigitalOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityDigitalOption.CommodityDigitalOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getCalculationPeriodsSchedule()).ifPresent(builder::setCalculationPeriodsSchedule);
			ofNullable(getCalculationPeriods()).ifPresent(builder::setCalculationPeriods);
			ofNullable(getPricingDates()).ifPresent(builder::setPricingDates);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getDigital()).ifPresent(builder::setDigital);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
			ofNullable(getNotionalQuantity()).ifPresent(builder::setNotionalQuantity);
			ofNullable(getTotalNotionalQuantity()).ifPresent(builder::setTotalNotionalQuantity);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getPremium()).ifPresent(builder::setPremium);
			ofNullable(getCommonPricing()).ifPresent(builder::setCommonPricing);
			ofNullable(getMarketDisruption()).ifPresent(builder::setMarketDisruption);
			ofNullable(getSettlementDisruption()).ifPresent(builder::setSettlementDisruption);
			ofNullable(getRounding()).ifPresent(builder::setRounding);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityDigitalOption _that = getType().cast(o);
		
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(digital, _that.getDigital())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(notionalQuantity, _that.getNotionalQuantity())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(commonPricing, _that.getCommonPricing())) return false;
			if (!Objects.equals(marketDisruption, _that.getMarketDisruption())) return false;
			if (!Objects.equals(settlementDisruption, _that.getSettlementDisruption())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (digital != null ? digital.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalQuantity != null ? notionalQuantity.hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (commonPricing != null ? commonPricing.hashCode() : 0);
			_result = 31 * _result + (marketDisruption != null ? marketDisruption.hashCode() : 0);
			_result = 31 * _result + (settlementDisruption != null ? settlementDisruption.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDigitalOption {" +
				"optionType=" + this.optionType + ", " +
				"commodity=" + this.commodity + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"calculationPeriods=" + this.calculationPeriods + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"digital=" + this.digital + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"notionalQuantity=" + this.notionalQuantity + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity + ", " +
				"exercise=" + this.exercise + ", " +
				"premium=" + this.premium + ", " +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityDigitalOption  ***********************/
	class CommodityDigitalOptionBuilderImpl extends Option.OptionBuilderImpl implements CommodityDigitalOption.CommodityDigitalOptionBuilder {
	
		protected PutCallEnum optionType;
		protected Commodity.CommodityBuilder commodity;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder calculationPeriodsSchedule;
		protected AdjustableDates.AdjustableDatesBuilder calculationPeriods;
		protected CommodityPricingDates.CommodityPricingDatesBuilder pricingDates;
		protected AveragingMethodEnum averagingMethod;
		protected CommodityDigital.CommodityDigitalBuilder digital;
		protected NotionalAmount.NotionalAmountBuilder notionalAmount;
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder notionalQuantity;
		protected BigDecimal totalNotionalQuantity;
		protected CommodityDigitalExercise.CommodityDigitalExerciseBuilder exercise;
		protected List<CommodityPremium.CommodityPremiumBuilder> premium = new ArrayList<>();
		protected Boolean commonPricing;
		protected CommodityMarketDisruption.CommodityMarketDisruptionBuilder marketDisruption;
		protected CommodityBullionSettlementDisruptionEnum settlementDisruption;
		protected Rounding.RoundingBuilder rounding;
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("optionType")
		public PutCallEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("commodity")
		public Commodity.CommodityBuilder getCommodity() {
			return commodity;
		}
		
		@Override
		public Commodity.CommodityBuilder getOrCreateCommodity() {
			Commodity.CommodityBuilder result;
			if (commodity!=null) {
				result = commodity;
			}
			else {
				result = commodity = Commodity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("effectiveDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsSchedule")
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getCalculationPeriodsSchedule() {
			return calculationPeriodsSchedule;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateCalculationPeriodsSchedule() {
			CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder result;
			if (calculationPeriodsSchedule!=null) {
				result = calculationPeriodsSchedule;
			}
			else {
				result = calculationPeriodsSchedule = CommodityCalculationPeriodsSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriods")
		public AdjustableDates.AdjustableDatesBuilder getCalculationPeriods() {
			return calculationPeriods;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationPeriods() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (calculationPeriods!=null) {
				result = calculationPeriods;
			}
			else {
				result = calculationPeriods = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingDates")
		public CommodityPricingDates.CommodityPricingDatesBuilder getPricingDates() {
			return pricingDates;
		}
		
		@Override
		public CommodityPricingDates.CommodityPricingDatesBuilder getOrCreatePricingDates() {
			CommodityPricingDates.CommodityPricingDatesBuilder result;
			if (pricingDates!=null) {
				result = pricingDates;
			}
			else {
				result = pricingDates = CommodityPricingDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averagingMethod")
		public AveragingMethodEnum getAveragingMethod() {
			return averagingMethod;
		}
		
		@Override
		@RosettaAttribute("digital")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("digital")
		public CommodityDigital.CommodityDigitalBuilder getDigital() {
			return digital;
		}
		
		@Override
		public CommodityDigital.CommodityDigitalBuilder getOrCreateDigital() {
			CommodityDigital.CommodityDigitalBuilder result;
			if (digital!=null) {
				result = digital;
			}
			else {
				result = digital = CommodityDigital.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmount")
		public NotionalAmount.NotionalAmountBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NotionalAmount.NotionalAmountBuilder getOrCreateNotionalAmount() {
			NotionalAmount.NotionalAmountBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NotionalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantity")
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getNotionalQuantity() {
			return notionalQuantity;
		}
		
		@Override
		public CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateNotionalQuantity() {
			CommodityNotionalQuantity.CommodityNotionalQuantityBuilder result;
			if (notionalQuantity!=null) {
				result = notionalQuantity;
			}
			else {
				result = notionalQuantity = CommodityNotionalQuantity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalNotionalQuantity")
		public BigDecimal getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@Override
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exercise")
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder getExercise() {
			return exercise;
		}
		
		@Override
		public CommodityDigitalExercise.CommodityDigitalExerciseBuilder getOrCreateExercise() {
			CommodityDigitalExercise.CommodityDigitalExerciseBuilder result;
			if (exercise!=null) {
				result = exercise;
			}
			else {
				result = exercise = CommodityDigitalExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("premium")
		public List<? extends CommodityPremium.CommodityPremiumBuilder> getPremium() {
			return premium;
		}
		
		@Override
		public CommodityPremium.CommodityPremiumBuilder getOrCreatePremium(int index) {
			if (premium==null) {
				this.premium = new ArrayList<>();
			}
			return getIndex(premium, index, () -> {
						CommodityPremium.CommodityPremiumBuilder newPremium = CommodityPremium.builder();
						return newPremium;
					});
		}
		
		@Override
		@RosettaAttribute("commonPricing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commonPricing")
		public Boolean getCommonPricing() {
			return commonPricing;
		}
		
		@Override
		@RosettaAttribute("marketDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("marketDisruption")
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder getMarketDisruption() {
			return marketDisruption;
		}
		
		@Override
		public CommodityMarketDisruption.CommodityMarketDisruptionBuilder getOrCreateMarketDisruption() {
			CommodityMarketDisruption.CommodityMarketDisruptionBuilder result;
			if (marketDisruption!=null) {
				result = marketDisruption;
			}
			else {
				result = marketDisruption = CommodityMarketDisruption.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDisruption")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("settlementDisruption")
		public CommodityBullionSettlementDisruptionEnum getSettlementDisruption() {
			return settlementDisruption;
		}
		
		@Override
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rounding")
		public Rounding.RoundingBuilder getRounding() {
			return rounding;
		}
		
		@Override
		public Rounding.RoundingBuilder getOrCreateRounding() {
			Rounding.RoundingBuilder result;
			if (rounding!=null) {
				result = rounding;
			}
			else {
				result = rounding = Rounding.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss != null) {
				for (final AssetClass toAdd : secondaryAssetClasss) {
					this.secondaryAssetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
			if (secondaryAssetClasss == null) {
				this.secondaryAssetClass = new ArrayList<>();
			} else {
				this.secondaryAssetClass = secondaryAssetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addProductType(List<? extends ProductType> productTypes) {
			if (productTypes != null) {
				for (final ProductType toAdd : productTypes) {
					this.productType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productType")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setProductType(List<? extends ProductType> productTypes) {
			if (productTypes == null) {
				this.productType = new ArrayList<>();
			} else {
				this.productType = productTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addProductId(List<? extends ProductId> productIds) {
			if (productIds != null) {
				for (final ProductId toAdd : productIds) {
					this.productId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("productId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productId")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setProductId(List<? extends ProductId> productIds) {
			if (productIds == null) {
				this.productId = new ArrayList<>();
			} else {
				this.productId = productIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes != null) {
				for (final EmbeddedOptionType toAdd : embeddedOptionTypes) {
					this.embeddedOptionType.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("embeddedOptionType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("embeddedOptionType")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
			if (embeddedOptionTypes == null) {
				this.embeddedOptionType = new ArrayList<>();
			} else {
				this.embeddedOptionType = embeddedOptionTypes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss != null) {
				for (final AssetClass toAdd : assetClasss) {
					this.assetClass.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("assetClass")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("assetClass")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
			if (assetClasss == null) {
				this.assetClass = new ArrayList<>();
			} else {
				this.assetClass = assetClasss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("optionType")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setOptionType(PutCallEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("commodity")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setCommodity(Commodity _commodity) {
			this.commodity = _commodity == null ? null : _commodity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsSchedule")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule _calculationPeriodsSchedule) {
			this.calculationPeriodsSchedule = _calculationPeriodsSchedule == null ? null : _calculationPeriodsSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriods")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setCalculationPeriods(AdjustableDates _calculationPeriods) {
			this.calculationPeriods = _calculationPeriods == null ? null : _calculationPeriods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingDates")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setPricingDates(CommodityPricingDates _pricingDates) {
			this.pricingDates = _pricingDates == null ? null : _pricingDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagingMethod")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setAveragingMethod(AveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@RosettaAttribute("digital")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("digital")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setDigital(CommodityDigital _digital) {
			this.digital = _digital == null ? null : _digital.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmount")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setNotionalAmount(NotionalAmount _notionalAmount) {
			this.notionalAmount = _notionalAmount == null ? null : _notionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantity")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setNotionalQuantity(CommodityNotionalQuantity _notionalQuantity) {
			this.notionalQuantity = _notionalQuantity == null ? null : _notionalQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalNotionalQuantity")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setTotalNotionalQuantity(BigDecimal _totalNotionalQuantity) {
			this.totalNotionalQuantity = _totalNotionalQuantity == null ? null : _totalNotionalQuantity;
			return this;
		}
		
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exercise")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setExercise(CommodityDigitalExercise _exercise) {
			this.exercise = _exercise == null ? null : _exercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("premium")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addPremium(CommodityPremium _premium) {
			if (_premium != null) {
				this.premium.add(_premium.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addPremium(CommodityPremium _premium, int idx) {
			getIndex(this.premium, idx, () -> _premium.toBuilder());
			return this;
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder addPremium(List<? extends CommodityPremium> premiums) {
			if (premiums != null) {
				for (final CommodityPremium toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("premium")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setPremium(List<? extends CommodityPremium> premiums) {
			if (premiums == null) {
				this.premium = new ArrayList<>();
			} else {
				this.premium = premiums.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("commonPricing")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commonPricing")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setCommonPricing(Boolean _commonPricing) {
			this.commonPricing = _commonPricing == null ? null : _commonPricing;
			return this;
		}
		
		@RosettaAttribute("marketDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketDisruption")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setMarketDisruption(CommodityMarketDisruption _marketDisruption) {
			this.marketDisruption = _marketDisruption == null ? null : _marketDisruption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDisruption")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum _settlementDisruption) {
			this.settlementDisruption = _settlementDisruption == null ? null : _settlementDisruption;
			return this;
		}
		
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rounding")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder setRounding(Rounding _rounding) {
			this.rounding = _rounding == null ? null : _rounding.toBuilder();
			return this;
		}
		
		@Override
		public CommodityDigitalOption build() {
			return new CommodityDigitalOption.CommodityDigitalOptionImpl(this);
		}
		
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder prune() {
			super.prune();
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			if (calculationPeriodsSchedule!=null && !calculationPeriodsSchedule.prune().hasData()) calculationPeriodsSchedule = null;
			if (calculationPeriods!=null && !calculationPeriods.prune().hasData()) calculationPeriods = null;
			if (pricingDates!=null && !pricingDates.prune().hasData()) pricingDates = null;
			if (digital!=null && !digital.prune().hasData()) digital = null;
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			if (notionalQuantity!=null && !notionalQuantity.prune().hasData()) notionalQuantity = null;
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			premium = premium.stream().filter(b->b!=null).<CommodityPremium.CommodityPremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (marketDisruption!=null && !marketDisruption.prune().hasData()) marketDisruption = null;
			if (rounding!=null && !rounding.prune().hasData()) rounding = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getOptionType()!=null) return true;
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getCalculationPeriodsSchedule()!=null && getCalculationPeriodsSchedule().hasData()) return true;
			if (getCalculationPeriods()!=null && getCalculationPeriods().hasData()) return true;
			if (getPricingDates()!=null && getPricingDates().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getDigital()!=null && getDigital().hasData()) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			if (getNotionalQuantity()!=null && getNotionalQuantity().hasData()) return true;
			if (getTotalNotionalQuantity()!=null) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommonPricing()!=null) return true;
			if (getMarketDisruption()!=null && getMarketDisruption().hasData()) return true;
			if (getSettlementDisruption()!=null) return true;
			if (getRounding()!=null && getRounding().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityDigitalOption.CommodityDigitalOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityDigitalOption.CommodityDigitalOptionBuilder o = (CommodityDigitalOption.CommodityDigitalOptionBuilder) other;
			
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getCalculationPeriodsSchedule(), o.getCalculationPeriodsSchedule(), this::setCalculationPeriodsSchedule);
			merger.mergeRosetta(getCalculationPeriods(), o.getCalculationPeriods(), this::setCalculationPeriods);
			merger.mergeRosetta(getPricingDates(), o.getPricingDates(), this::setPricingDates);
			merger.mergeRosetta(getDigital(), o.getDigital(), this::setDigital);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			merger.mergeRosetta(getNotionalQuantity(), o.getNotionalQuantity(), this::setNotionalQuantity);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			merger.mergeRosetta(getMarketDisruption(), o.getMarketDisruption(), this::setMarketDisruption);
			merger.mergeRosetta(getRounding(), o.getRounding(), this::setRounding);
			
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getAveragingMethod(), o.getAveragingMethod(), this::setAveragingMethod);
			merger.mergeBasic(getTotalNotionalQuantity(), o.getTotalNotionalQuantity(), this::setTotalNotionalQuantity);
			merger.mergeBasic(getCommonPricing(), o.getCommonPricing(), this::setCommonPricing);
			merger.mergeBasic(getSettlementDisruption(), o.getSettlementDisruption(), this::setSettlementDisruption);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityDigitalOption _that = getType().cast(o);
		
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(digital, _that.getDigital())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			if (!Objects.equals(notionalQuantity, _that.getNotionalQuantity())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!ListEquals.listEquals(premium, _that.getPremium())) return false;
			if (!Objects.equals(commonPricing, _that.getCommonPricing())) return false;
			if (!Objects.equals(marketDisruption, _that.getMarketDisruption())) return false;
			if (!Objects.equals(settlementDisruption, _that.getSettlementDisruption())) return false;
			if (!Objects.equals(rounding, _that.getRounding())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (digital != null ? digital.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			_result = 31 * _result + (notionalQuantity != null ? notionalQuantity.hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (commonPricing != null ? commonPricing.hashCode() : 0);
			_result = 31 * _result + (marketDisruption != null ? marketDisruption.hashCode() : 0);
			_result = 31 * _result + (settlementDisruption != null ? settlementDisruption.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityDigitalOptionBuilder {" +
				"optionType=" + this.optionType + ", " +
				"commodity=" + this.commodity + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"calculationPeriods=" + this.calculationPeriods + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"digital=" + this.digital + ", " +
				"notionalAmount=" + this.notionalAmount + ", " +
				"notionalQuantity=" + this.notionalQuantity + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity + ", " +
				"exercise=" + this.exercise + ", " +
				"premium=" + this.premium + ", " +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}' + " " + super.toString();
		}
	}
}
