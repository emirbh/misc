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
import fpml.consolidated.com.meta.CommodityBasketOptionMeta;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.fpmlenum.PutCallEnum;
import fpml.consolidated.option.shared.Option;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.ProductId;
import fpml.consolidated.shared.ProductType;
import fpml.consolidated.shared.Rounding;
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
 * Provision Defines a commodity basket option product.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines a commodity basket option product.
 *
 */
@RosettaDataType(value="CommodityBasketOption", builder=CommodityBasketOption.CommodityBasketOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityBasketOption", model="fpml", builder=CommodityBasketOption.CommodityBasketOptionBuilderImpl.class, version="2.1.1")
public interface CommodityBasketOption extends Option {

	CommodityBasketOptionMeta metaData = new CommodityBasketOptionMeta();

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
	CommodityBasketByNotional getNotionalQuantityBasket();
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
	CommodityBasketByPercentage getNotionalAmountBasket();
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
	StrikePriceUnderlyingReference getStrikePriceUnderlyingReference();
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
	StrikePriceBasketReference getStrikePriceBasketReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency amount of the strike price per unit.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency amount of the strike price per unit.
	 *
	 */
	NonNegativeMoney getStrikePricePerUnit();
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
	CommodityStrikeSchedule getStrikePricePerUnitSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The currency amount of the strike price per unit.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The currency amount of the strike price per unit.
	 *
	 */
	FloatingStrikePrice getFloatingStrikePricePerUnit();
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
	CommodityCalculationPeriodsSchedule getFloatingStrikePricePerUnitSchedule();
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
	CommodityExerciseBasket getExercise();
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
	CommodityBasketOption build();
	
	CommodityBasketOption.CommodityBasketOptionBuilder toBuilder();
	
	static CommodityBasketOption.CommodityBasketOptionBuilder builder() {
		return new CommodityBasketOption.CommodityBasketOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityBasketOption> getType() {
		return CommodityBasketOption.class;
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
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("calculationPeriodsSchedule"), processor, CommodityCalculationPeriodsSchedule.class, getCalculationPeriodsSchedule());
		processRosetta(path.newSubPath("calculationPeriods"), processor, AdjustableDates.class, getCalculationPeriods());
		processRosetta(path.newSubPath("notionalQuantityBasket"), processor, CommodityBasketByNotional.class, getNotionalQuantityBasket());
		processRosetta(path.newSubPath("notionalAmountBasket"), processor, CommodityBasketByPercentage.class, getNotionalAmountBasket());
		processRosetta(path.newSubPath("strikePriceUnderlyingReference"), processor, StrikePriceUnderlyingReference.class, getStrikePriceUnderlyingReference());
		processRosetta(path.newSubPath("strikePriceBasketReference"), processor, StrikePriceBasketReference.class, getStrikePriceBasketReference());
		processRosetta(path.newSubPath("strikePricePerUnit"), processor, NonNegativeMoney.class, getStrikePricePerUnit());
		processRosetta(path.newSubPath("strikePricePerUnitSchedule"), processor, CommodityStrikeSchedule.class, getStrikePricePerUnitSchedule());
		processRosetta(path.newSubPath("floatingStrikePricePerUnit"), processor, FloatingStrikePrice.class, getFloatingStrikePricePerUnit());
		processRosetta(path.newSubPath("floatingStrikePricePerUnitSchedule"), processor, CommodityCalculationPeriodsSchedule.class, getFloatingStrikePricePerUnitSchedule());
		processRosetta(path.newSubPath("exercise"), processor, CommodityExerciseBasket.class, getExercise());
		processRosetta(path.newSubPath("premium"), processor, CommodityPremium.class, getPremium());
		processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
		processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.class, getMarketDisruption());
		processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
		processRosetta(path.newSubPath("rounding"), processor, Rounding.class, getRounding());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketOptionBuilder extends CommodityBasketOption, Option.OptionBuilder {
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
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder getOrCreateNotionalQuantityBasket();
		@Override
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder getNotionalQuantityBasket();
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder getOrCreateNotionalAmountBasket();
		@Override
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder getNotionalAmountBasket();
		StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder getOrCreateStrikePriceUnderlyingReference();
		@Override
		StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder getStrikePriceUnderlyingReference();
		StrikePriceBasketReference.StrikePriceBasketReferenceBuilder getOrCreateStrikePriceBasketReference();
		@Override
		StrikePriceBasketReference.StrikePriceBasketReferenceBuilder getStrikePriceBasketReference();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateStrikePricePerUnit();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getStrikePricePerUnit();
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder getOrCreateStrikePricePerUnitSchedule();
		@Override
		CommodityStrikeSchedule.CommodityStrikeScheduleBuilder getStrikePricePerUnitSchedule();
		FloatingStrikePrice.FloatingStrikePriceBuilder getOrCreateFloatingStrikePricePerUnit();
		@Override
		FloatingStrikePrice.FloatingStrikePriceBuilder getFloatingStrikePricePerUnit();
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateFloatingStrikePricePerUnitSchedule();
		@Override
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getFloatingStrikePricePerUnitSchedule();
		CommodityExerciseBasket.CommodityExerciseBasketBuilder getOrCreateExercise();
		@Override
		CommodityExerciseBasket.CommodityExerciseBasketBuilder getExercise();
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
		CommodityBasketOption.CommodityBasketOptionBuilder setId(String id);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addProductType(ProductType productType);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addProductType(ProductType productType, int idx);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addProductType(List<? extends ProductType> productType);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder setProductType(List<? extends ProductType> productType);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addProductId(ProductId productId);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addProductId(ProductId productId, int idx);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addProductId(List<? extends ProductId> productId);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder setProductId(List<? extends ProductId> productId);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addAssetClass(AssetClass assetClass);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder setAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		@Override
		CommodityBasketOption.CommodityBasketOptionBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		CommodityBasketOption.CommodityBasketOptionBuilder setOptionType(PutCallEnum optionType);
		CommodityBasketOption.CommodityBasketOptionBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		CommodityBasketOption.CommodityBasketOptionBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		CommodityBasketOption.CommodityBasketOptionBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule calculationPeriodsSchedule);
		CommodityBasketOption.CommodityBasketOptionBuilder setCalculationPeriods(AdjustableDates calculationPeriods);
		CommodityBasketOption.CommodityBasketOptionBuilder setNotionalQuantityBasket(CommodityBasketByNotional notionalQuantityBasket);
		CommodityBasketOption.CommodityBasketOptionBuilder setNotionalAmountBasket(CommodityBasketByPercentage notionalAmountBasket);
		CommodityBasketOption.CommodityBasketOptionBuilder setStrikePriceUnderlyingReference(StrikePriceUnderlyingReference strikePriceUnderlyingReference);
		CommodityBasketOption.CommodityBasketOptionBuilder setStrikePriceBasketReference(StrikePriceBasketReference strikePriceBasketReference);
		CommodityBasketOption.CommodityBasketOptionBuilder setStrikePricePerUnit(NonNegativeMoney strikePricePerUnit);
		CommodityBasketOption.CommodityBasketOptionBuilder setStrikePricePerUnitSchedule(CommodityStrikeSchedule strikePricePerUnitSchedule);
		CommodityBasketOption.CommodityBasketOptionBuilder setFloatingStrikePricePerUnit(FloatingStrikePrice floatingStrikePricePerUnit);
		CommodityBasketOption.CommodityBasketOptionBuilder setFloatingStrikePricePerUnitSchedule(CommodityCalculationPeriodsSchedule floatingStrikePricePerUnitSchedule);
		CommodityBasketOption.CommodityBasketOptionBuilder setExercise(CommodityExerciseBasket exercise);
		CommodityBasketOption.CommodityBasketOptionBuilder addPremium(CommodityPremium premium);
		CommodityBasketOption.CommodityBasketOptionBuilder addPremium(CommodityPremium premium, int idx);
		CommodityBasketOption.CommodityBasketOptionBuilder addPremium(List<? extends CommodityPremium> premium);
		CommodityBasketOption.CommodityBasketOptionBuilder setPremium(List<? extends CommodityPremium> premium);
		CommodityBasketOption.CommodityBasketOptionBuilder setCommonPricing(Boolean commonPricing);
		CommodityBasketOption.CommodityBasketOptionBuilder setMarketDisruption(CommodityMarketDisruption marketDisruption);
		CommodityBasketOption.CommodityBasketOptionBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum settlementDisruption);
		CommodityBasketOption.CommodityBasketOptionBuilder setRounding(Rounding rounding);

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
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("calculationPeriodsSchedule"), processor, CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder.class, getCalculationPeriodsSchedule());
			processRosetta(path.newSubPath("calculationPeriods"), processor, AdjustableDates.AdjustableDatesBuilder.class, getCalculationPeriods());
			processRosetta(path.newSubPath("notionalQuantityBasket"), processor, CommodityBasketByNotional.CommodityBasketByNotionalBuilder.class, getNotionalQuantityBasket());
			processRosetta(path.newSubPath("notionalAmountBasket"), processor, CommodityBasketByPercentage.CommodityBasketByPercentageBuilder.class, getNotionalAmountBasket());
			processRosetta(path.newSubPath("strikePriceUnderlyingReference"), processor, StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder.class, getStrikePriceUnderlyingReference());
			processRosetta(path.newSubPath("strikePriceBasketReference"), processor, StrikePriceBasketReference.StrikePriceBasketReferenceBuilder.class, getStrikePriceBasketReference());
			processRosetta(path.newSubPath("strikePricePerUnit"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getStrikePricePerUnit());
			processRosetta(path.newSubPath("strikePricePerUnitSchedule"), processor, CommodityStrikeSchedule.CommodityStrikeScheduleBuilder.class, getStrikePricePerUnitSchedule());
			processRosetta(path.newSubPath("floatingStrikePricePerUnit"), processor, FloatingStrikePrice.FloatingStrikePriceBuilder.class, getFloatingStrikePricePerUnit());
			processRosetta(path.newSubPath("floatingStrikePricePerUnitSchedule"), processor, CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder.class, getFloatingStrikePricePerUnitSchedule());
			processRosetta(path.newSubPath("exercise"), processor, CommodityExerciseBasket.CommodityExerciseBasketBuilder.class, getExercise());
			processRosetta(path.newSubPath("premium"), processor, CommodityPremium.CommodityPremiumBuilder.class, getPremium());
			processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
			processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.CommodityMarketDisruptionBuilder.class, getMarketDisruption());
			processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
			processRosetta(path.newSubPath("rounding"), processor, Rounding.RoundingBuilder.class, getRounding());
		}
		

		CommodityBasketOption.CommodityBasketOptionBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketOption  ***********************/
	class CommodityBasketOptionImpl extends Option.OptionImpl implements CommodityBasketOption {
		private final PutCallEnum optionType;
		private final AdjustableOrRelativeDate effectiveDate;
		private final AdjustableOrRelativeDate terminationDate;
		private final CommodityCalculationPeriodsSchedule calculationPeriodsSchedule;
		private final AdjustableDates calculationPeriods;
		private final CommodityBasketByNotional notionalQuantityBasket;
		private final CommodityBasketByPercentage notionalAmountBasket;
		private final StrikePriceUnderlyingReference strikePriceUnderlyingReference;
		private final StrikePriceBasketReference strikePriceBasketReference;
		private final NonNegativeMoney strikePricePerUnit;
		private final CommodityStrikeSchedule strikePricePerUnitSchedule;
		private final FloatingStrikePrice floatingStrikePricePerUnit;
		private final CommodityCalculationPeriodsSchedule floatingStrikePricePerUnitSchedule;
		private final CommodityExerciseBasket exercise;
		private final List<? extends CommodityPremium> premium;
		private final Boolean commonPricing;
		private final CommodityMarketDisruption marketDisruption;
		private final CommodityBullionSettlementDisruptionEnum settlementDisruption;
		private final Rounding rounding;
		
		protected CommodityBasketOptionImpl(CommodityBasketOption.CommodityBasketOptionBuilder builder) {
			super(builder);
			this.optionType = builder.getOptionType();
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.calculationPeriodsSchedule = ofNullable(builder.getCalculationPeriodsSchedule()).map(f->f.build()).orElse(null);
			this.calculationPeriods = ofNullable(builder.getCalculationPeriods()).map(f->f.build()).orElse(null);
			this.notionalQuantityBasket = ofNullable(builder.getNotionalQuantityBasket()).map(f->f.build()).orElse(null);
			this.notionalAmountBasket = ofNullable(builder.getNotionalAmountBasket()).map(f->f.build()).orElse(null);
			this.strikePriceUnderlyingReference = ofNullable(builder.getStrikePriceUnderlyingReference()).map(f->f.build()).orElse(null);
			this.strikePriceBasketReference = ofNullable(builder.getStrikePriceBasketReference()).map(f->f.build()).orElse(null);
			this.strikePricePerUnit = ofNullable(builder.getStrikePricePerUnit()).map(f->f.build()).orElse(null);
			this.strikePricePerUnitSchedule = ofNullable(builder.getStrikePricePerUnitSchedule()).map(f->f.build()).orElse(null);
			this.floatingStrikePricePerUnit = ofNullable(builder.getFloatingStrikePricePerUnit()).map(f->f.build()).orElse(null);
			this.floatingStrikePricePerUnitSchedule = ofNullable(builder.getFloatingStrikePricePerUnitSchedule()).map(f->f.build()).orElse(null);
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
		@RosettaAttribute("notionalQuantityBasket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantityBasket")
		public CommodityBasketByNotional getNotionalQuantityBasket() {
			return notionalQuantityBasket;
		}
		
		@Override
		@RosettaAttribute("notionalAmountBasket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmountBasket")
		public CommodityBasketByPercentage getNotionalAmountBasket() {
			return notionalAmountBasket;
		}
		
		@Override
		@RosettaAttribute("strikePriceUnderlyingReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePriceUnderlyingReference")
		public StrikePriceUnderlyingReference getStrikePriceUnderlyingReference() {
			return strikePriceUnderlyingReference;
		}
		
		@Override
		@RosettaAttribute("strikePriceBasketReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePriceBasketReference")
		public StrikePriceBasketReference getStrikePriceBasketReference() {
			return strikePriceBasketReference;
		}
		
		@Override
		@RosettaAttribute("strikePricePerUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePricePerUnit")
		public NonNegativeMoney getStrikePricePerUnit() {
			return strikePricePerUnit;
		}
		
		@Override
		@RosettaAttribute("strikePricePerUnitSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePricePerUnitSchedule")
		public CommodityStrikeSchedule getStrikePricePerUnitSchedule() {
			return strikePricePerUnitSchedule;
		}
		
		@Override
		@RosettaAttribute("floatingStrikePricePerUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingStrikePricePerUnit")
		public FloatingStrikePrice getFloatingStrikePricePerUnit() {
			return floatingStrikePricePerUnit;
		}
		
		@Override
		@RosettaAttribute("floatingStrikePricePerUnitSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingStrikePricePerUnitSchedule")
		public CommodityCalculationPeriodsSchedule getFloatingStrikePricePerUnitSchedule() {
			return floatingStrikePricePerUnitSchedule;
		}
		
		@Override
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exercise")
		public CommodityExerciseBasket getExercise() {
			return exercise;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@Required
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
		public CommodityBasketOption build() {
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder toBuilder() {
			CommodityBasketOption.CommodityBasketOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketOption.CommodityBasketOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getCalculationPeriodsSchedule()).ifPresent(builder::setCalculationPeriodsSchedule);
			ofNullable(getCalculationPeriods()).ifPresent(builder::setCalculationPeriods);
			ofNullable(getNotionalQuantityBasket()).ifPresent(builder::setNotionalQuantityBasket);
			ofNullable(getNotionalAmountBasket()).ifPresent(builder::setNotionalAmountBasket);
			ofNullable(getStrikePriceUnderlyingReference()).ifPresent(builder::setStrikePriceUnderlyingReference);
			ofNullable(getStrikePriceBasketReference()).ifPresent(builder::setStrikePriceBasketReference);
			ofNullable(getStrikePricePerUnit()).ifPresent(builder::setStrikePricePerUnit);
			ofNullable(getStrikePricePerUnitSchedule()).ifPresent(builder::setStrikePricePerUnitSchedule);
			ofNullable(getFloatingStrikePricePerUnit()).ifPresent(builder::setFloatingStrikePricePerUnit);
			ofNullable(getFloatingStrikePricePerUnitSchedule()).ifPresent(builder::setFloatingStrikePricePerUnitSchedule);
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
		
			CommodityBasketOption _that = getType().cast(o);
		
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			if (!Objects.equals(notionalQuantityBasket, _that.getNotionalQuantityBasket())) return false;
			if (!Objects.equals(notionalAmountBasket, _that.getNotionalAmountBasket())) return false;
			if (!Objects.equals(strikePriceUnderlyingReference, _that.getStrikePriceUnderlyingReference())) return false;
			if (!Objects.equals(strikePriceBasketReference, _that.getStrikePriceBasketReference())) return false;
			if (!Objects.equals(strikePricePerUnit, _that.getStrikePricePerUnit())) return false;
			if (!Objects.equals(strikePricePerUnitSchedule, _that.getStrikePricePerUnitSchedule())) return false;
			if (!Objects.equals(floatingStrikePricePerUnit, _that.getFloatingStrikePricePerUnit())) return false;
			if (!Objects.equals(floatingStrikePricePerUnitSchedule, _that.getFloatingStrikePricePerUnitSchedule())) return false;
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
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			_result = 31 * _result + (notionalQuantityBasket != null ? notionalQuantityBasket.hashCode() : 0);
			_result = 31 * _result + (notionalAmountBasket != null ? notionalAmountBasket.hashCode() : 0);
			_result = 31 * _result + (strikePriceUnderlyingReference != null ? strikePriceUnderlyingReference.hashCode() : 0);
			_result = 31 * _result + (strikePriceBasketReference != null ? strikePriceBasketReference.hashCode() : 0);
			_result = 31 * _result + (strikePricePerUnit != null ? strikePricePerUnit.hashCode() : 0);
			_result = 31 * _result + (strikePricePerUnitSchedule != null ? strikePricePerUnitSchedule.hashCode() : 0);
			_result = 31 * _result + (floatingStrikePricePerUnit != null ? floatingStrikePricePerUnit.hashCode() : 0);
			_result = 31 * _result + (floatingStrikePricePerUnitSchedule != null ? floatingStrikePricePerUnitSchedule.hashCode() : 0);
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
			return "CommodityBasketOption {" +
				"optionType=" + this.optionType + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"calculationPeriods=" + this.calculationPeriods + ", " +
				"notionalQuantityBasket=" + this.notionalQuantityBasket + ", " +
				"notionalAmountBasket=" + this.notionalAmountBasket + ", " +
				"strikePriceUnderlyingReference=" + this.strikePriceUnderlyingReference + ", " +
				"strikePriceBasketReference=" + this.strikePriceBasketReference + ", " +
				"strikePricePerUnit=" + this.strikePricePerUnit + ", " +
				"strikePricePerUnitSchedule=" + this.strikePricePerUnitSchedule + ", " +
				"floatingStrikePricePerUnit=" + this.floatingStrikePricePerUnit + ", " +
				"floatingStrikePricePerUnitSchedule=" + this.floatingStrikePricePerUnitSchedule + ", " +
				"exercise=" + this.exercise + ", " +
				"premium=" + this.premium + ", " +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityBasketOption  ***********************/
	class CommodityBasketOptionBuilderImpl extends Option.OptionBuilderImpl implements CommodityBasketOption.CommodityBasketOptionBuilder {
	
		protected PutCallEnum optionType;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder calculationPeriodsSchedule;
		protected AdjustableDates.AdjustableDatesBuilder calculationPeriods;
		protected CommodityBasketByNotional.CommodityBasketByNotionalBuilder notionalQuantityBasket;
		protected CommodityBasketByPercentage.CommodityBasketByPercentageBuilder notionalAmountBasket;
		protected StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder strikePriceUnderlyingReference;
		protected StrikePriceBasketReference.StrikePriceBasketReferenceBuilder strikePriceBasketReference;
		protected NonNegativeMoney.NonNegativeMoneyBuilder strikePricePerUnit;
		protected CommodityStrikeSchedule.CommodityStrikeScheduleBuilder strikePricePerUnitSchedule;
		protected FloatingStrikePrice.FloatingStrikePriceBuilder floatingStrikePricePerUnit;
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder floatingStrikePricePerUnitSchedule;
		protected CommodityExerciseBasket.CommodityExerciseBasketBuilder exercise;
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
		@RosettaAttribute("notionalQuantityBasket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantityBasket")
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder getNotionalQuantityBasket() {
			return notionalQuantityBasket;
		}
		
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder getOrCreateNotionalQuantityBasket() {
			CommodityBasketByNotional.CommodityBasketByNotionalBuilder result;
			if (notionalQuantityBasket!=null) {
				result = notionalQuantityBasket;
			}
			else {
				result = notionalQuantityBasket = CommodityBasketByNotional.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalAmountBasket")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalAmountBasket")
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder getNotionalAmountBasket() {
			return notionalAmountBasket;
		}
		
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder getOrCreateNotionalAmountBasket() {
			CommodityBasketByPercentage.CommodityBasketByPercentageBuilder result;
			if (notionalAmountBasket!=null) {
				result = notionalAmountBasket;
			}
			else {
				result = notionalAmountBasket = CommodityBasketByPercentage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikePriceUnderlyingReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePriceUnderlyingReference")
		public StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder getStrikePriceUnderlyingReference() {
			return strikePriceUnderlyingReference;
		}
		
		@Override
		public StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder getOrCreateStrikePriceUnderlyingReference() {
			StrikePriceUnderlyingReference.StrikePriceUnderlyingReferenceBuilder result;
			if (strikePriceUnderlyingReference!=null) {
				result = strikePriceUnderlyingReference;
			}
			else {
				result = strikePriceUnderlyingReference = StrikePriceUnderlyingReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikePriceBasketReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePriceBasketReference")
		public StrikePriceBasketReference.StrikePriceBasketReferenceBuilder getStrikePriceBasketReference() {
			return strikePriceBasketReference;
		}
		
		@Override
		public StrikePriceBasketReference.StrikePriceBasketReferenceBuilder getOrCreateStrikePriceBasketReference() {
			StrikePriceBasketReference.StrikePriceBasketReferenceBuilder result;
			if (strikePriceBasketReference!=null) {
				result = strikePriceBasketReference;
			}
			else {
				result = strikePriceBasketReference = StrikePriceBasketReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikePricePerUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePricePerUnit")
		public NonNegativeMoney.NonNegativeMoneyBuilder getStrikePricePerUnit() {
			return strikePricePerUnit;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateStrikePricePerUnit() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (strikePricePerUnit!=null) {
				result = strikePricePerUnit;
			}
			else {
				result = strikePricePerUnit = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("strikePricePerUnitSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("strikePricePerUnitSchedule")
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder getStrikePricePerUnitSchedule() {
			return strikePricePerUnitSchedule;
		}
		
		@Override
		public CommodityStrikeSchedule.CommodityStrikeScheduleBuilder getOrCreateStrikePricePerUnitSchedule() {
			CommodityStrikeSchedule.CommodityStrikeScheduleBuilder result;
			if (strikePricePerUnitSchedule!=null) {
				result = strikePricePerUnitSchedule;
			}
			else {
				result = strikePricePerUnitSchedule = CommodityStrikeSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingStrikePricePerUnit")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingStrikePricePerUnit")
		public FloatingStrikePrice.FloatingStrikePriceBuilder getFloatingStrikePricePerUnit() {
			return floatingStrikePricePerUnit;
		}
		
		@Override
		public FloatingStrikePrice.FloatingStrikePriceBuilder getOrCreateFloatingStrikePricePerUnit() {
			FloatingStrikePrice.FloatingStrikePriceBuilder result;
			if (floatingStrikePricePerUnit!=null) {
				result = floatingStrikePricePerUnit;
			}
			else {
				result = floatingStrikePricePerUnit = FloatingStrikePrice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingStrikePricePerUnitSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("floatingStrikePricePerUnitSchedule")
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getFloatingStrikePricePerUnitSchedule() {
			return floatingStrikePricePerUnitSchedule;
		}
		
		@Override
		public CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateFloatingStrikePricePerUnitSchedule() {
			CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder result;
			if (floatingStrikePricePerUnitSchedule!=null) {
				result = floatingStrikePricePerUnitSchedule;
			}
			else {
				result = floatingStrikePricePerUnitSchedule = CommodityCalculationPeriodsSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("exercise")
		public CommodityExerciseBasket.CommodityExerciseBasketBuilder getExercise() {
			return exercise;
		}
		
		@Override
		public CommodityExerciseBasket.CommodityExerciseBasketBuilder getOrCreateExercise() {
			CommodityExerciseBasket.CommodityExerciseBasketBuilder result;
			if (exercise!=null) {
				result = exercise;
			}
			else {
				result = exercise = CommodityExerciseBasket.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("premium")
		@Accessor(AccessorType.GETTER)
		@Required
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
		public CommodityBasketOption.CommodityBasketOptionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CommodityBasketOption.CommodityBasketOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CommodityBasketOption.CommodityBasketOptionBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public CommodityBasketOption.CommodityBasketOptionBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public CommodityBasketOption.CommodityBasketOptionBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addProductId(List<? extends ProductId> productIds) {
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
		public CommodityBasketOption.CommodityBasketOptionBuilder setProductId(List<? extends ProductId> productIds) {
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
		public CommodityBasketOption.CommodityBasketOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CommodityBasketOption.CommodityBasketOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CommodityBasketOption.CommodityBasketOptionBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CommodityBasketOption.CommodityBasketOptionBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CommodityBasketOption.CommodityBasketOptionBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("optionType")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setOptionType(PutCallEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsSchedule")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule _calculationPeriodsSchedule) {
			this.calculationPeriodsSchedule = _calculationPeriodsSchedule == null ? null : _calculationPeriodsSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriods")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setCalculationPeriods(AdjustableDates _calculationPeriods) {
			this.calculationPeriods = _calculationPeriods == null ? null : _calculationPeriods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalQuantityBasket")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantityBasket")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setNotionalQuantityBasket(CommodityBasketByNotional _notionalQuantityBasket) {
			this.notionalQuantityBasket = _notionalQuantityBasket == null ? null : _notionalQuantityBasket.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalAmountBasket")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalAmountBasket")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setNotionalAmountBasket(CommodityBasketByPercentage _notionalAmountBasket) {
			this.notionalAmountBasket = _notionalAmountBasket == null ? null : _notionalAmountBasket.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePriceUnderlyingReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceUnderlyingReference")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setStrikePriceUnderlyingReference(StrikePriceUnderlyingReference _strikePriceUnderlyingReference) {
			this.strikePriceUnderlyingReference = _strikePriceUnderlyingReference == null ? null : _strikePriceUnderlyingReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePriceBasketReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePriceBasketReference")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setStrikePriceBasketReference(StrikePriceBasketReference _strikePriceBasketReference) {
			this.strikePriceBasketReference = _strikePriceBasketReference == null ? null : _strikePriceBasketReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePricePerUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePricePerUnit")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setStrikePricePerUnit(NonNegativeMoney _strikePricePerUnit) {
			this.strikePricePerUnit = _strikePricePerUnit == null ? null : _strikePricePerUnit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePricePerUnitSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePricePerUnitSchedule")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setStrikePricePerUnitSchedule(CommodityStrikeSchedule _strikePricePerUnitSchedule) {
			this.strikePricePerUnitSchedule = _strikePricePerUnitSchedule == null ? null : _strikePricePerUnitSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingStrikePricePerUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingStrikePricePerUnit")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setFloatingStrikePricePerUnit(FloatingStrikePrice _floatingStrikePricePerUnit) {
			this.floatingStrikePricePerUnit = _floatingStrikePricePerUnit == null ? null : _floatingStrikePricePerUnit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingStrikePricePerUnitSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingStrikePricePerUnitSchedule")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setFloatingStrikePricePerUnitSchedule(CommodityCalculationPeriodsSchedule _floatingStrikePricePerUnitSchedule) {
			this.floatingStrikePricePerUnitSchedule = _floatingStrikePricePerUnitSchedule == null ? null : _floatingStrikePricePerUnitSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("exercise")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setExercise(CommodityExerciseBasket _exercise) {
			this.exercise = _exercise == null ? null : _exercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("premium")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addPremium(CommodityPremium _premium) {
			if (_premium != null) {
				this.premium.add(_premium.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addPremium(CommodityPremium _premium, int idx) {
			getIndex(this.premium, idx, () -> _premium.toBuilder());
			return this;
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder addPremium(List<? extends CommodityPremium> premiums) {
			if (premiums != null) {
				for (final CommodityPremium toAdd : premiums) {
					this.premium.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("premium")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setPremium(List<? extends CommodityPremium> premiums) {
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
		public CommodityBasketOption.CommodityBasketOptionBuilder setCommonPricing(Boolean _commonPricing) {
			this.commonPricing = _commonPricing == null ? null : _commonPricing;
			return this;
		}
		
		@RosettaAttribute("marketDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketDisruption")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setMarketDisruption(CommodityMarketDisruption _marketDisruption) {
			this.marketDisruption = _marketDisruption == null ? null : _marketDisruption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDisruption")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum _settlementDisruption) {
			this.settlementDisruption = _settlementDisruption == null ? null : _settlementDisruption;
			return this;
		}
		
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rounding")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder setRounding(Rounding _rounding) {
			this.rounding = _rounding == null ? null : _rounding.toBuilder();
			return this;
		}
		
		@Override
		public CommodityBasketOption build() {
			return new CommodityBasketOption.CommodityBasketOptionImpl(this);
		}
		
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketOption.CommodityBasketOptionBuilder prune() {
			super.prune();
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			if (calculationPeriodsSchedule!=null && !calculationPeriodsSchedule.prune().hasData()) calculationPeriodsSchedule = null;
			if (calculationPeriods!=null && !calculationPeriods.prune().hasData()) calculationPeriods = null;
			if (notionalQuantityBasket!=null && !notionalQuantityBasket.prune().hasData()) notionalQuantityBasket = null;
			if (notionalAmountBasket!=null && !notionalAmountBasket.prune().hasData()) notionalAmountBasket = null;
			if (strikePriceUnderlyingReference!=null && !strikePriceUnderlyingReference.prune().hasData()) strikePriceUnderlyingReference = null;
			if (strikePriceBasketReference!=null && !strikePriceBasketReference.prune().hasData()) strikePriceBasketReference = null;
			if (strikePricePerUnit!=null && !strikePricePerUnit.prune().hasData()) strikePricePerUnit = null;
			if (strikePricePerUnitSchedule!=null && !strikePricePerUnitSchedule.prune().hasData()) strikePricePerUnitSchedule = null;
			if (floatingStrikePricePerUnit!=null && !floatingStrikePricePerUnit.prune().hasData()) floatingStrikePricePerUnit = null;
			if (floatingStrikePricePerUnitSchedule!=null && !floatingStrikePricePerUnitSchedule.prune().hasData()) floatingStrikePricePerUnitSchedule = null;
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
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getCalculationPeriodsSchedule()!=null && getCalculationPeriodsSchedule().hasData()) return true;
			if (getCalculationPeriods()!=null && getCalculationPeriods().hasData()) return true;
			if (getNotionalQuantityBasket()!=null && getNotionalQuantityBasket().hasData()) return true;
			if (getNotionalAmountBasket()!=null && getNotionalAmountBasket().hasData()) return true;
			if (getStrikePriceUnderlyingReference()!=null && getStrikePriceUnderlyingReference().hasData()) return true;
			if (getStrikePriceBasketReference()!=null && getStrikePriceBasketReference().hasData()) return true;
			if (getStrikePricePerUnit()!=null && getStrikePricePerUnit().hasData()) return true;
			if (getStrikePricePerUnitSchedule()!=null && getStrikePricePerUnitSchedule().hasData()) return true;
			if (getFloatingStrikePricePerUnit()!=null && getFloatingStrikePricePerUnit().hasData()) return true;
			if (getFloatingStrikePricePerUnitSchedule()!=null && getFloatingStrikePricePerUnitSchedule().hasData()) return true;
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
		public CommodityBasketOption.CommodityBasketOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityBasketOption.CommodityBasketOptionBuilder o = (CommodityBasketOption.CommodityBasketOptionBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getCalculationPeriodsSchedule(), o.getCalculationPeriodsSchedule(), this::setCalculationPeriodsSchedule);
			merger.mergeRosetta(getCalculationPeriods(), o.getCalculationPeriods(), this::setCalculationPeriods);
			merger.mergeRosetta(getNotionalQuantityBasket(), o.getNotionalQuantityBasket(), this::setNotionalQuantityBasket);
			merger.mergeRosetta(getNotionalAmountBasket(), o.getNotionalAmountBasket(), this::setNotionalAmountBasket);
			merger.mergeRosetta(getStrikePriceUnderlyingReference(), o.getStrikePriceUnderlyingReference(), this::setStrikePriceUnderlyingReference);
			merger.mergeRosetta(getStrikePriceBasketReference(), o.getStrikePriceBasketReference(), this::setStrikePriceBasketReference);
			merger.mergeRosetta(getStrikePricePerUnit(), o.getStrikePricePerUnit(), this::setStrikePricePerUnit);
			merger.mergeRosetta(getStrikePricePerUnitSchedule(), o.getStrikePricePerUnitSchedule(), this::setStrikePricePerUnitSchedule);
			merger.mergeRosetta(getFloatingStrikePricePerUnit(), o.getFloatingStrikePricePerUnit(), this::setFloatingStrikePricePerUnit);
			merger.mergeRosetta(getFloatingStrikePricePerUnitSchedule(), o.getFloatingStrikePricePerUnitSchedule(), this::setFloatingStrikePricePerUnitSchedule);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getPremium(), o.getPremium(), this::getOrCreatePremium);
			merger.mergeRosetta(getMarketDisruption(), o.getMarketDisruption(), this::setMarketDisruption);
			merger.mergeRosetta(getRounding(), o.getRounding(), this::setRounding);
			
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getCommonPricing(), o.getCommonPricing(), this::setCommonPricing);
			merger.mergeBasic(getSettlementDisruption(), o.getSettlementDisruption(), this::setSettlementDisruption);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketOption _that = getType().cast(o);
		
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			if (!Objects.equals(notionalQuantityBasket, _that.getNotionalQuantityBasket())) return false;
			if (!Objects.equals(notionalAmountBasket, _that.getNotionalAmountBasket())) return false;
			if (!Objects.equals(strikePriceUnderlyingReference, _that.getStrikePriceUnderlyingReference())) return false;
			if (!Objects.equals(strikePriceBasketReference, _that.getStrikePriceBasketReference())) return false;
			if (!Objects.equals(strikePricePerUnit, _that.getStrikePricePerUnit())) return false;
			if (!Objects.equals(strikePricePerUnitSchedule, _that.getStrikePricePerUnitSchedule())) return false;
			if (!Objects.equals(floatingStrikePricePerUnit, _that.getFloatingStrikePricePerUnit())) return false;
			if (!Objects.equals(floatingStrikePricePerUnitSchedule, _that.getFloatingStrikePricePerUnitSchedule())) return false;
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
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			_result = 31 * _result + (notionalQuantityBasket != null ? notionalQuantityBasket.hashCode() : 0);
			_result = 31 * _result + (notionalAmountBasket != null ? notionalAmountBasket.hashCode() : 0);
			_result = 31 * _result + (strikePriceUnderlyingReference != null ? strikePriceUnderlyingReference.hashCode() : 0);
			_result = 31 * _result + (strikePriceBasketReference != null ? strikePriceBasketReference.hashCode() : 0);
			_result = 31 * _result + (strikePricePerUnit != null ? strikePricePerUnit.hashCode() : 0);
			_result = 31 * _result + (strikePricePerUnitSchedule != null ? strikePricePerUnitSchedule.hashCode() : 0);
			_result = 31 * _result + (floatingStrikePricePerUnit != null ? floatingStrikePricePerUnit.hashCode() : 0);
			_result = 31 * _result + (floatingStrikePricePerUnitSchedule != null ? floatingStrikePricePerUnitSchedule.hashCode() : 0);
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
			return "CommodityBasketOptionBuilder {" +
				"optionType=" + this.optionType + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"calculationPeriods=" + this.calculationPeriods + ", " +
				"notionalQuantityBasket=" + this.notionalQuantityBasket + ", " +
				"notionalAmountBasket=" + this.notionalAmountBasket + ", " +
				"strikePriceUnderlyingReference=" + this.strikePriceUnderlyingReference + ", " +
				"strikePriceBasketReference=" + this.strikePriceBasketReference + ", " +
				"strikePricePerUnit=" + this.strikePricePerUnit + ", " +
				"strikePricePerUnitSchedule=" + this.strikePricePerUnitSchedule + ", " +
				"floatingStrikePricePerUnit=" + this.floatingStrikePricePerUnit + ", " +
				"floatingStrikePricePerUnitSchedule=" + this.floatingStrikePricePerUnitSchedule + ", " +
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
