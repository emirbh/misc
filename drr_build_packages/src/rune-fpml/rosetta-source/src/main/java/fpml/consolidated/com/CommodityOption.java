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
import fpml.consolidated.com.meta.CommodityOptionMeta;
import fpml.consolidated.fpmlenum.AveragingMethodEnum;
import fpml.consolidated.fpmlenum.CommodityBullionSettlementDisruptionEnum;
import fpml.consolidated.fpmlenum.PutCallEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableOrRelativeDate;
import fpml.consolidated.shared.AssetClass;
import fpml.consolidated.shared.EmbeddedOptionType;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import fpml.consolidated.shared.Product;
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
 * Provision Defines a commodity option product type. The product support for financially-settled exercises or exercise into physical forward contracts written on precious and non-precious metals. options in FpML is based on the creation of a 'commodityOption' product. The product references the 'commodity' underlyer in order to support the underlying asset of the option.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Defines a commodity option product type. The product support for financially-settled exercises or exercise into physical forward contracts written on precious and non-precious metals. options in FpML is based on the creation of a 'commodityOption' product. The product references the 'commodity' underlyer in order to support the underlying asset of the option.
 *
 */
@RosettaDataType(value="CommodityOption", builder=CommodityOption.CommodityOptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="CommodityOption", model="fpml", builder=CommodityOption.CommodityOptionBuilderImpl.class, version="2.1.1")
public interface CommodityOption extends Product {

	CommodityOptionMeta metaData = new CommodityOptionMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that buys this instrument, ie. pays for this instrument and receives the rights defined by it. See 2000 ISDA definitions Article 11.1 (b). In the case of FRAs this the fixed rate payer.
	 *
	 */
	PartyReference getBuyerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that buys this instrument.
	 *
	 */
	AccountReference getBuyerAccountReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the party that sells ("writes") this instrument, i.e. that grants the rights defined by this instrument and in return receives a payment for it. See 2000 ISDA definitions Article 11.1 (a). In the case of FRAs this is the floating rate payer.
	 *
	 */
	PartyReference getSellerPartyReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the account that sells this instrument.
	 *
	 */
	AccountReference getSellerAccountReference();
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
	 * Provision Defines a commodity option barrier product feature.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines a commodity option barrier product feature.
	 *
	 */
	CommodityBarrier getBarrier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Allows the documentation of a shaped notional trade where the notional changes over the life of the transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Allows the documentation of a shaped notional trade where the notional changes over the life of the transaction.
	 *
	 */
	CommodityNotionalQuantitySchedule getNotionalQuantitySchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Notional Quantity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Notional Quantity.
	 *
	 */
	CommodityNotionalQuantity getNotionalQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For an electricity transaction, the Notional Quantity for a one or more groups of Settlement Periods to which the Notional Quantity is based. If the schedule differs for different groups of Settlement Periods, this element should be repeated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision For an electricity transaction, the Notional Quantity for a one or more groups of Settlement Periods to which the Notional Quantity is based. If the schedule differs for different groups of Settlement Periods, this element should be repeated.
	 *
	 */
	List<? extends CommoditySettlementPeriodsNotionalQuantity> getSettlementPeriodsNotionalQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Total Notional Quantity.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Total Notional Quantity.
	 *
	 */
	BigDecimal getTotalNotionalQuantity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to a quantity defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to a quantity defined on another leg.
	 *
	 */
	QuantityReference getQuantityReference();
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
	CommodityExercise getExercise();
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
	 * Provision DEPRECATED. Defines a commodity swap product.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision DEPRECATED. Defines a commodity swap product.
	 *
	 */
	CommoditySwap getCommoditySwap();
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
	CommodityForward getCommodityForward();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The parameters for defining how the commodity option can be exercised into a physical transaction.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The parameters for defining how the commodity option can be exercised into a physical transaction.
	 *
	 */
	CommodityPhysicalExercise getPhysicalExercise();
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
	WeatherCalculationPeriods getWeatherCalculationPeriods();
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
	CalculationPeriodsReference getWeatherCalculationPeriodsReference();
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
	NonNegativeMoney getWeatherNotionalAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Weather Index strike price level is specified in terms of weather index units (e.g. 1 Days, 3 Inches, etc.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Weather Index strike price level is specified in terms of weather index units (e.g. 1 Days, 3 Inches, etc.)
	 *
	 */
	WeatherIndex getWeatherIndexStrikeLevel();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Contains parameters which figure in the calculation of payments on a Weather Index Option.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Contains parameters which figure in the calculation of payments on a Weather Index Option.
	 *
	 */
	WeatherLegCalculation getCalculation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies where the data (e.g. CPD) have been collected, an actual physical reference point (weather station) and various fall back arrangements.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies where the data (e.g. CPD) have been collected, an actual physical reference point (weather station) and various fall back arrangements.
	 *
	 */
	WeatherIndexData getWeatherIndexData();
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
	CommodityOption build();
	
	CommodityOption.CommodityOptionBuilder toBuilder();
	
	static CommodityOption.CommodityOptionBuilder builder() {
		return new CommodityOption.CommodityOptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityOption> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends CommodityOption> getType() {
		return CommodityOption.class;
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
		processRosetta(path.newSubPath("barrier"), processor, CommodityBarrier.class, getBarrier());
		processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, CommodityNotionalQuantitySchedule.class, getNotionalQuantitySchedule());
		processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.class, getNotionalQuantity());
		processRosetta(path.newSubPath("settlementPeriodsNotionalQuantity"), processor, CommoditySettlementPeriodsNotionalQuantity.class, getSettlementPeriodsNotionalQuantity());
		processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
		processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.class, getQuantityReference());
		processRosetta(path.newSubPath("exercise"), processor, CommodityExercise.class, getExercise());
		processRosetta(path.newSubPath("strikePricePerUnit"), processor, NonNegativeMoney.class, getStrikePricePerUnit());
		processRosetta(path.newSubPath("strikePricePerUnitSchedule"), processor, CommodityStrikeSchedule.class, getStrikePricePerUnitSchedule());
		processRosetta(path.newSubPath("floatingStrikePricePerUnit"), processor, FloatingStrikePrice.class, getFloatingStrikePricePerUnit());
		processRosetta(path.newSubPath("floatingStrikePricePerUnitSchedule"), processor, CommodityCalculationPeriodsSchedule.class, getFloatingStrikePricePerUnitSchedule());
		processRosetta(path.newSubPath("commoditySwap"), processor, CommoditySwap.class, getCommoditySwap());
		processRosetta(path.newSubPath("commodityForward"), processor, CommodityForward.class, getCommodityForward());
		processRosetta(path.newSubPath("physicalExercise"), processor, CommodityPhysicalExercise.class, getPhysicalExercise());
		processRosetta(path.newSubPath("weatherCalculationPeriods"), processor, WeatherCalculationPeriods.class, getWeatherCalculationPeriods());
		processRosetta(path.newSubPath("weatherCalculationPeriodsReference"), processor, CalculationPeriodsReference.class, getWeatherCalculationPeriodsReference());
		processRosetta(path.newSubPath("weatherNotionalAmount"), processor, NonNegativeMoney.class, getWeatherNotionalAmount());
		processRosetta(path.newSubPath("weatherIndexStrikeLevel"), processor, WeatherIndex.class, getWeatherIndexStrikeLevel());
		processRosetta(path.newSubPath("calculation"), processor, WeatherLegCalculation.class, getCalculation());
		processRosetta(path.newSubPath("weatherIndexData"), processor, WeatherIndexData.class, getWeatherIndexData());
		processRosetta(path.newSubPath("premium"), processor, CommodityPremium.class, getPremium());
		processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
		processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.class, getMarketDisruption());
		processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
		processRosetta(path.newSubPath("rounding"), processor, Rounding.class, getRounding());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityOptionBuilder extends CommodityOption, Product.ProductBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getBuyerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getBuyerAccountReference();
		PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference();
		@Override
		PartyReference.PartyReferenceBuilder getSellerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference();
		@Override
		AccountReference.AccountReferenceBuilder getSellerAccountReference();
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
		CommodityBarrier.CommodityBarrierBuilder getOrCreateBarrier();
		@Override
		CommodityBarrier.CommodityBarrierBuilder getBarrier();
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder getOrCreateNotionalQuantitySchedule();
		@Override
		CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder getNotionalQuantitySchedule();
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getOrCreateNotionalQuantity();
		@Override
		CommodityNotionalQuantity.CommodityNotionalQuantityBuilder getNotionalQuantity();
		CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder getOrCreateSettlementPeriodsNotionalQuantity(int index);
		@Override
		List<? extends CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder> getSettlementPeriodsNotionalQuantity();
		QuantityReference.QuantityReferenceBuilder getOrCreateQuantityReference();
		@Override
		QuantityReference.QuantityReferenceBuilder getQuantityReference();
		CommodityExercise.CommodityExerciseBuilder getOrCreateExercise();
		@Override
		CommodityExercise.CommodityExerciseBuilder getExercise();
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
		CommoditySwap.CommoditySwapBuilder getOrCreateCommoditySwap();
		@Override
		CommoditySwap.CommoditySwapBuilder getCommoditySwap();
		CommodityForward.CommodityForwardBuilder getOrCreateCommodityForward();
		@Override
		CommodityForward.CommodityForwardBuilder getCommodityForward();
		CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getOrCreatePhysicalExercise();
		@Override
		CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getPhysicalExercise();
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder getOrCreateWeatherCalculationPeriods();
		@Override
		WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder getWeatherCalculationPeriods();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateWeatherCalculationPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getWeatherCalculationPeriodsReference();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateWeatherNotionalAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getWeatherNotionalAmount();
		WeatherIndex.WeatherIndexBuilder getOrCreateWeatherIndexStrikeLevel();
		@Override
		WeatherIndex.WeatherIndexBuilder getWeatherIndexStrikeLevel();
		WeatherLegCalculation.WeatherLegCalculationBuilder getOrCreateCalculation();
		@Override
		WeatherLegCalculation.WeatherLegCalculationBuilder getCalculation();
		WeatherIndexData.WeatherIndexDataBuilder getOrCreateWeatherIndexData();
		@Override
		WeatherIndexData.WeatherIndexDataBuilder getWeatherIndexData();
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
		CommodityOption.CommodityOptionBuilder setId(String id);
		@Override
		CommodityOption.CommodityOptionBuilder setPrimaryAssetClass(AssetClass primaryAssetClass);
		@Override
		CommodityOption.CommodityOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass);
		@Override
		CommodityOption.CommodityOptionBuilder addSecondaryAssetClass(AssetClass secondaryAssetClass, int idx);
		@Override
		CommodityOption.CommodityOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CommodityOption.CommodityOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClass);
		@Override
		CommodityOption.CommodityOptionBuilder addProductType(ProductType productType);
		@Override
		CommodityOption.CommodityOptionBuilder addProductType(ProductType productType, int idx);
		@Override
		CommodityOption.CommodityOptionBuilder addProductType(List<? extends ProductType> productType);
		@Override
		CommodityOption.CommodityOptionBuilder setProductType(List<? extends ProductType> productType);
		@Override
		CommodityOption.CommodityOptionBuilder addProductId(ProductId productId);
		@Override
		CommodityOption.CommodityOptionBuilder addProductId(ProductId productId, int idx);
		@Override
		CommodityOption.CommodityOptionBuilder addProductId(List<? extends ProductId> productId);
		@Override
		CommodityOption.CommodityOptionBuilder setProductId(List<? extends ProductId> productId);
		@Override
		CommodityOption.CommodityOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType);
		@Override
		CommodityOption.CommodityOptionBuilder addEmbeddedOptionType(EmbeddedOptionType embeddedOptionType, int idx);
		@Override
		CommodityOption.CommodityOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CommodityOption.CommodityOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionType);
		@Override
		CommodityOption.CommodityOptionBuilder addAssetClass(AssetClass assetClass);
		@Override
		CommodityOption.CommodityOptionBuilder addAssetClass(AssetClass assetClass, int idx);
		@Override
		CommodityOption.CommodityOptionBuilder addAssetClass(List<? extends AssetClass> assetClass);
		@Override
		CommodityOption.CommodityOptionBuilder setAssetClass(List<? extends AssetClass> assetClass);
		CommodityOption.CommodityOptionBuilder setBuyerPartyReference(PartyReference buyerPartyReference);
		CommodityOption.CommodityOptionBuilder setBuyerAccountReference(AccountReference buyerAccountReference);
		CommodityOption.CommodityOptionBuilder setSellerPartyReference(PartyReference sellerPartyReference);
		CommodityOption.CommodityOptionBuilder setSellerAccountReference(AccountReference sellerAccountReference);
		CommodityOption.CommodityOptionBuilder setOptionType(PutCallEnum optionType);
		CommodityOption.CommodityOptionBuilder setCommodity(Commodity commodity);
		CommodityOption.CommodityOptionBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		CommodityOption.CommodityOptionBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		CommodityOption.CommodityOptionBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule calculationPeriodsSchedule);
		CommodityOption.CommodityOptionBuilder setCalculationPeriods(AdjustableDates calculationPeriods);
		CommodityOption.CommodityOptionBuilder setPricingDates(CommodityPricingDates pricingDates);
		CommodityOption.CommodityOptionBuilder setAveragingMethod(AveragingMethodEnum averagingMethod);
		CommodityOption.CommodityOptionBuilder setBarrier(CommodityBarrier barrier);
		CommodityOption.CommodityOptionBuilder setNotionalQuantitySchedule(CommodityNotionalQuantitySchedule notionalQuantitySchedule);
		CommodityOption.CommodityOptionBuilder setNotionalQuantity(CommodityNotionalQuantity notionalQuantity);
		CommodityOption.CommodityOptionBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity settlementPeriodsNotionalQuantity);
		CommodityOption.CommodityOptionBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity settlementPeriodsNotionalQuantity, int idx);
		CommodityOption.CommodityOptionBuilder addSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity);
		CommodityOption.CommodityOptionBuilder setSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity);
		CommodityOption.CommodityOptionBuilder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity);
		CommodityOption.CommodityOptionBuilder setQuantityReference(QuantityReference quantityReference);
		CommodityOption.CommodityOptionBuilder setExercise(CommodityExercise exercise);
		CommodityOption.CommodityOptionBuilder setStrikePricePerUnit(NonNegativeMoney strikePricePerUnit);
		CommodityOption.CommodityOptionBuilder setStrikePricePerUnitSchedule(CommodityStrikeSchedule strikePricePerUnitSchedule);
		CommodityOption.CommodityOptionBuilder setFloatingStrikePricePerUnit(FloatingStrikePrice floatingStrikePricePerUnit);
		CommodityOption.CommodityOptionBuilder setFloatingStrikePricePerUnitSchedule(CommodityCalculationPeriodsSchedule floatingStrikePricePerUnitSchedule);
		CommodityOption.CommodityOptionBuilder setCommoditySwap(CommoditySwap commoditySwap);
		CommodityOption.CommodityOptionBuilder setCommodityForward(CommodityForward commodityForward);
		CommodityOption.CommodityOptionBuilder setPhysicalExercise(CommodityPhysicalExercise physicalExercise);
		CommodityOption.CommodityOptionBuilder setWeatherCalculationPeriods(WeatherCalculationPeriods weatherCalculationPeriods);
		CommodityOption.CommodityOptionBuilder setWeatherCalculationPeriodsReference(CalculationPeriodsReference weatherCalculationPeriodsReference);
		CommodityOption.CommodityOptionBuilder setWeatherNotionalAmount(NonNegativeMoney weatherNotionalAmount);
		CommodityOption.CommodityOptionBuilder setWeatherIndexStrikeLevel(WeatherIndex weatherIndexStrikeLevel);
		CommodityOption.CommodityOptionBuilder setCalculation(WeatherLegCalculation calculation);
		CommodityOption.CommodityOptionBuilder setWeatherIndexData(WeatherIndexData weatherIndexData);
		CommodityOption.CommodityOptionBuilder addPremium(CommodityPremium premium);
		CommodityOption.CommodityOptionBuilder addPremium(CommodityPremium premium, int idx);
		CommodityOption.CommodityOptionBuilder addPremium(List<? extends CommodityPremium> premium);
		CommodityOption.CommodityOptionBuilder setPremium(List<? extends CommodityPremium> premium);
		CommodityOption.CommodityOptionBuilder setCommonPricing(Boolean commonPricing);
		CommodityOption.CommodityOptionBuilder setMarketDisruption(CommodityMarketDisruption marketDisruption);
		CommodityOption.CommodityOptionBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum settlementDisruption);
		CommodityOption.CommodityOptionBuilder setRounding(Rounding rounding);

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
			processRosetta(path.newSubPath("barrier"), processor, CommodityBarrier.CommodityBarrierBuilder.class, getBarrier());
			processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder.class, getNotionalQuantitySchedule());
			processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getNotionalQuantity());
			processRosetta(path.newSubPath("settlementPeriodsNotionalQuantity"), processor, CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder.class, getSettlementPeriodsNotionalQuantity());
			processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
			processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.QuantityReferenceBuilder.class, getQuantityReference());
			processRosetta(path.newSubPath("exercise"), processor, CommodityExercise.CommodityExerciseBuilder.class, getExercise());
			processRosetta(path.newSubPath("strikePricePerUnit"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getStrikePricePerUnit());
			processRosetta(path.newSubPath("strikePricePerUnitSchedule"), processor, CommodityStrikeSchedule.CommodityStrikeScheduleBuilder.class, getStrikePricePerUnitSchedule());
			processRosetta(path.newSubPath("floatingStrikePricePerUnit"), processor, FloatingStrikePrice.FloatingStrikePriceBuilder.class, getFloatingStrikePricePerUnit());
			processRosetta(path.newSubPath("floatingStrikePricePerUnitSchedule"), processor, CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder.class, getFloatingStrikePricePerUnitSchedule());
			processRosetta(path.newSubPath("commoditySwap"), processor, CommoditySwap.CommoditySwapBuilder.class, getCommoditySwap());
			processRosetta(path.newSubPath("commodityForward"), processor, CommodityForward.CommodityForwardBuilder.class, getCommodityForward());
			processRosetta(path.newSubPath("physicalExercise"), processor, CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder.class, getPhysicalExercise());
			processRosetta(path.newSubPath("weatherCalculationPeriods"), processor, WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder.class, getWeatherCalculationPeriods());
			processRosetta(path.newSubPath("weatherCalculationPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getWeatherCalculationPeriodsReference());
			processRosetta(path.newSubPath("weatherNotionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getWeatherNotionalAmount());
			processRosetta(path.newSubPath("weatherIndexStrikeLevel"), processor, WeatherIndex.WeatherIndexBuilder.class, getWeatherIndexStrikeLevel());
			processRosetta(path.newSubPath("calculation"), processor, WeatherLegCalculation.WeatherLegCalculationBuilder.class, getCalculation());
			processRosetta(path.newSubPath("weatherIndexData"), processor, WeatherIndexData.WeatherIndexDataBuilder.class, getWeatherIndexData());
			processRosetta(path.newSubPath("premium"), processor, CommodityPremium.CommodityPremiumBuilder.class, getPremium());
			processor.processBasic(path.newSubPath("commonPricing"), Boolean.class, getCommonPricing(), this);
			processRosetta(path.newSubPath("marketDisruption"), processor, CommodityMarketDisruption.CommodityMarketDisruptionBuilder.class, getMarketDisruption());
			processor.processBasic(path.newSubPath("settlementDisruption"), CommodityBullionSettlementDisruptionEnum.class, getSettlementDisruption(), this);
			processRosetta(path.newSubPath("rounding"), processor, Rounding.RoundingBuilder.class, getRounding());
		}
		

		CommodityOption.CommodityOptionBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityOption  ***********************/
	class CommodityOptionImpl extends Product.ProductImpl implements CommodityOption {
		private final PartyReference buyerPartyReference;
		private final AccountReference buyerAccountReference;
		private final PartyReference sellerPartyReference;
		private final AccountReference sellerAccountReference;
		private final PutCallEnum optionType;
		private final Commodity commodity;
		private final AdjustableOrRelativeDate effectiveDate;
		private final AdjustableOrRelativeDate terminationDate;
		private final CommodityCalculationPeriodsSchedule calculationPeriodsSchedule;
		private final AdjustableDates calculationPeriods;
		private final CommodityPricingDates pricingDates;
		private final AveragingMethodEnum averagingMethod;
		private final CommodityBarrier barrier;
		private final CommodityNotionalQuantitySchedule notionalQuantitySchedule;
		private final CommodityNotionalQuantity notionalQuantity;
		private final List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity;
		private final BigDecimal totalNotionalQuantity;
		private final QuantityReference quantityReference;
		private final CommodityExercise exercise;
		private final NonNegativeMoney strikePricePerUnit;
		private final CommodityStrikeSchedule strikePricePerUnitSchedule;
		private final FloatingStrikePrice floatingStrikePricePerUnit;
		private final CommodityCalculationPeriodsSchedule floatingStrikePricePerUnitSchedule;
		private final CommoditySwap commoditySwap;
		private final CommodityForward commodityForward;
		private final CommodityPhysicalExercise physicalExercise;
		private final WeatherCalculationPeriods weatherCalculationPeriods;
		private final CalculationPeriodsReference weatherCalculationPeriodsReference;
		private final NonNegativeMoney weatherNotionalAmount;
		private final WeatherIndex weatherIndexStrikeLevel;
		private final WeatherLegCalculation calculation;
		private final WeatherIndexData weatherIndexData;
		private final List<? extends CommodityPremium> premium;
		private final Boolean commonPricing;
		private final CommodityMarketDisruption marketDisruption;
		private final CommodityBullionSettlementDisruptionEnum settlementDisruption;
		private final Rounding rounding;
		
		protected CommodityOptionImpl(CommodityOption.CommodityOptionBuilder builder) {
			super(builder);
			this.buyerPartyReference = ofNullable(builder.getBuyerPartyReference()).map(f->f.build()).orElse(null);
			this.buyerAccountReference = ofNullable(builder.getBuyerAccountReference()).map(f->f.build()).orElse(null);
			this.sellerPartyReference = ofNullable(builder.getSellerPartyReference()).map(f->f.build()).orElse(null);
			this.sellerAccountReference = ofNullable(builder.getSellerAccountReference()).map(f->f.build()).orElse(null);
			this.optionType = builder.getOptionType();
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.calculationPeriodsSchedule = ofNullable(builder.getCalculationPeriodsSchedule()).map(f->f.build()).orElse(null);
			this.calculationPeriods = ofNullable(builder.getCalculationPeriods()).map(f->f.build()).orElse(null);
			this.pricingDates = ofNullable(builder.getPricingDates()).map(f->f.build()).orElse(null);
			this.averagingMethod = builder.getAveragingMethod();
			this.barrier = ofNullable(builder.getBarrier()).map(f->f.build()).orElse(null);
			this.notionalQuantitySchedule = ofNullable(builder.getNotionalQuantitySchedule()).map(f->f.build()).orElse(null);
			this.notionalQuantity = ofNullable(builder.getNotionalQuantity()).map(f->f.build()).orElse(null);
			this.settlementPeriodsNotionalQuantity = ofNullable(builder.getSettlementPeriodsNotionalQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.totalNotionalQuantity = builder.getTotalNotionalQuantity();
			this.quantityReference = ofNullable(builder.getQuantityReference()).map(f->f.build()).orElse(null);
			this.exercise = ofNullable(builder.getExercise()).map(f->f.build()).orElse(null);
			this.strikePricePerUnit = ofNullable(builder.getStrikePricePerUnit()).map(f->f.build()).orElse(null);
			this.strikePricePerUnitSchedule = ofNullable(builder.getStrikePricePerUnitSchedule()).map(f->f.build()).orElse(null);
			this.floatingStrikePricePerUnit = ofNullable(builder.getFloatingStrikePricePerUnit()).map(f->f.build()).orElse(null);
			this.floatingStrikePricePerUnitSchedule = ofNullable(builder.getFloatingStrikePricePerUnitSchedule()).map(f->f.build()).orElse(null);
			this.commoditySwap = ofNullable(builder.getCommoditySwap()).map(f->f.build()).orElse(null);
			this.commodityForward = ofNullable(builder.getCommodityForward()).map(f->f.build()).orElse(null);
			this.physicalExercise = ofNullable(builder.getPhysicalExercise()).map(f->f.build()).orElse(null);
			this.weatherCalculationPeriods = ofNullable(builder.getWeatherCalculationPeriods()).map(f->f.build()).orElse(null);
			this.weatherCalculationPeriodsReference = ofNullable(builder.getWeatherCalculationPeriodsReference()).map(f->f.build()).orElse(null);
			this.weatherNotionalAmount = ofNullable(builder.getWeatherNotionalAmount()).map(f->f.build()).orElse(null);
			this.weatherIndexStrikeLevel = ofNullable(builder.getWeatherIndexStrikeLevel()).map(f->f.build()).orElse(null);
			this.calculation = ofNullable(builder.getCalculation()).map(f->f.build()).orElse(null);
			this.weatherIndexData = ofNullable(builder.getWeatherIndexData()).map(f->f.build()).orElse(null);
			this.premium = ofNullable(builder.getPremium()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.commonPricing = builder.getCommonPricing();
			this.marketDisruption = ofNullable(builder.getMarketDisruption()).map(f->f.build()).orElse(null);
			this.settlementDisruption = builder.getSettlementDisruption();
			this.rounding = ofNullable(builder.getRounding()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		public PartyReference getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		public PartyReference getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference getSellerAccountReference() {
			return sellerAccountReference;
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
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrier")
		public CommodityBarrier getBarrier() {
			return barrier;
		}
		
		@Override
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantitySchedule")
		public CommodityNotionalQuantitySchedule getNotionalQuantitySchedule() {
			return notionalQuantitySchedule;
		}
		
		@Override
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantity")
		public CommodityNotionalQuantity getNotionalQuantity() {
			return notionalQuantity;
		}
		
		@Override
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantity")
		public List<? extends CommoditySettlementPeriodsNotionalQuantity> getSettlementPeriodsNotionalQuantity() {
			return settlementPeriodsNotionalQuantity;
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalNotionalQuantity")
		public BigDecimal getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@Override
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityReference")
		public QuantityReference getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exercise")
		public CommodityExercise getExercise() {
			return exercise;
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
		@RosettaAttribute("commoditySwap")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commoditySwap")
		public CommoditySwap getCommoditySwap() {
			return commoditySwap;
		}
		
		@Override
		@RosettaAttribute("commodityForward")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityForward")
		public CommodityForward getCommodityForward() {
			return commodityForward;
		}
		
		@Override
		@RosettaAttribute("physicalExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalExercise")
		public CommodityPhysicalExercise getPhysicalExercise() {
			return physicalExercise;
		}
		
		@Override
		@RosettaAttribute("weatherCalculationPeriods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherCalculationPeriods")
		public WeatherCalculationPeriods getWeatherCalculationPeriods() {
			return weatherCalculationPeriods;
		}
		
		@Override
		@RosettaAttribute("weatherCalculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherCalculationPeriodsReference")
		public CalculationPeriodsReference getWeatherCalculationPeriodsReference() {
			return weatherCalculationPeriodsReference;
		}
		
		@Override
		@RosettaAttribute("weatherNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherNotionalAmount")
		public NonNegativeMoney getWeatherNotionalAmount() {
			return weatherNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("weatherIndexStrikeLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherIndexStrikeLevel")
		public WeatherIndex getWeatherIndexStrikeLevel() {
			return weatherIndexStrikeLevel;
		}
		
		@Override
		@RosettaAttribute("calculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculation")
		public WeatherLegCalculation getCalculation() {
			return calculation;
		}
		
		@Override
		@RosettaAttribute("weatherIndexData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherIndexData")
		public WeatherIndexData getWeatherIndexData() {
			return weatherIndexData;
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
		public CommodityOption build() {
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder toBuilder() {
			CommodityOption.CommodityOptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityOption.CommodityOptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getBuyerPartyReference()).ifPresent(builder::setBuyerPartyReference);
			ofNullable(getBuyerAccountReference()).ifPresent(builder::setBuyerAccountReference);
			ofNullable(getSellerPartyReference()).ifPresent(builder::setSellerPartyReference);
			ofNullable(getSellerAccountReference()).ifPresent(builder::setSellerAccountReference);
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getCalculationPeriodsSchedule()).ifPresent(builder::setCalculationPeriodsSchedule);
			ofNullable(getCalculationPeriods()).ifPresent(builder::setCalculationPeriods);
			ofNullable(getPricingDates()).ifPresent(builder::setPricingDates);
			ofNullable(getAveragingMethod()).ifPresent(builder::setAveragingMethod);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
			ofNullable(getNotionalQuantitySchedule()).ifPresent(builder::setNotionalQuantitySchedule);
			ofNullable(getNotionalQuantity()).ifPresent(builder::setNotionalQuantity);
			ofNullable(getSettlementPeriodsNotionalQuantity()).ifPresent(builder::setSettlementPeriodsNotionalQuantity);
			ofNullable(getTotalNotionalQuantity()).ifPresent(builder::setTotalNotionalQuantity);
			ofNullable(getQuantityReference()).ifPresent(builder::setQuantityReference);
			ofNullable(getExercise()).ifPresent(builder::setExercise);
			ofNullable(getStrikePricePerUnit()).ifPresent(builder::setStrikePricePerUnit);
			ofNullable(getStrikePricePerUnitSchedule()).ifPresent(builder::setStrikePricePerUnitSchedule);
			ofNullable(getFloatingStrikePricePerUnit()).ifPresent(builder::setFloatingStrikePricePerUnit);
			ofNullable(getFloatingStrikePricePerUnitSchedule()).ifPresent(builder::setFloatingStrikePricePerUnitSchedule);
			ofNullable(getCommoditySwap()).ifPresent(builder::setCommoditySwap);
			ofNullable(getCommodityForward()).ifPresent(builder::setCommodityForward);
			ofNullable(getPhysicalExercise()).ifPresent(builder::setPhysicalExercise);
			ofNullable(getWeatherCalculationPeriods()).ifPresent(builder::setWeatherCalculationPeriods);
			ofNullable(getWeatherCalculationPeriodsReference()).ifPresent(builder::setWeatherCalculationPeriodsReference);
			ofNullable(getWeatherNotionalAmount()).ifPresent(builder::setWeatherNotionalAmount);
			ofNullable(getWeatherIndexStrikeLevel()).ifPresent(builder::setWeatherIndexStrikeLevel);
			ofNullable(getCalculation()).ifPresent(builder::setCalculation);
			ofNullable(getWeatherIndexData()).ifPresent(builder::setWeatherIndexData);
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
		
			CommodityOption _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(notionalQuantitySchedule, _that.getNotionalQuantitySchedule())) return false;
			if (!Objects.equals(notionalQuantity, _that.getNotionalQuantity())) return false;
			if (!ListEquals.listEquals(settlementPeriodsNotionalQuantity, _that.getSettlementPeriodsNotionalQuantity())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(strikePricePerUnit, _that.getStrikePricePerUnit())) return false;
			if (!Objects.equals(strikePricePerUnitSchedule, _that.getStrikePricePerUnitSchedule())) return false;
			if (!Objects.equals(floatingStrikePricePerUnit, _that.getFloatingStrikePricePerUnit())) return false;
			if (!Objects.equals(floatingStrikePricePerUnitSchedule, _that.getFloatingStrikePricePerUnitSchedule())) return false;
			if (!Objects.equals(commoditySwap, _that.getCommoditySwap())) return false;
			if (!Objects.equals(commodityForward, _that.getCommodityForward())) return false;
			if (!Objects.equals(physicalExercise, _that.getPhysicalExercise())) return false;
			if (!Objects.equals(weatherCalculationPeriods, _that.getWeatherCalculationPeriods())) return false;
			if (!Objects.equals(weatherCalculationPeriodsReference, _that.getWeatherCalculationPeriodsReference())) return false;
			if (!Objects.equals(weatherNotionalAmount, _that.getWeatherNotionalAmount())) return false;
			if (!Objects.equals(weatherIndexStrikeLevel, _that.getWeatherIndexStrikeLevel())) return false;
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(weatherIndexData, _that.getWeatherIndexData())) return false;
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
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (notionalQuantitySchedule != null ? notionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (notionalQuantity != null ? notionalQuantity.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsNotionalQuantity != null ? settlementPeriodsNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (strikePricePerUnit != null ? strikePricePerUnit.hashCode() : 0);
			_result = 31 * _result + (strikePricePerUnitSchedule != null ? strikePricePerUnitSchedule.hashCode() : 0);
			_result = 31 * _result + (floatingStrikePricePerUnit != null ? floatingStrikePricePerUnit.hashCode() : 0);
			_result = 31 * _result + (floatingStrikePricePerUnitSchedule != null ? floatingStrikePricePerUnitSchedule.hashCode() : 0);
			_result = 31 * _result + (commoditySwap != null ? commoditySwap.hashCode() : 0);
			_result = 31 * _result + (commodityForward != null ? commodityForward.hashCode() : 0);
			_result = 31 * _result + (physicalExercise != null ? physicalExercise.hashCode() : 0);
			_result = 31 * _result + (weatherCalculationPeriods != null ? weatherCalculationPeriods.hashCode() : 0);
			_result = 31 * _result + (weatherCalculationPeriodsReference != null ? weatherCalculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (weatherNotionalAmount != null ? weatherNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (weatherIndexStrikeLevel != null ? weatherIndexStrikeLevel.hashCode() : 0);
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (weatherIndexData != null ? weatherIndexData.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (commonPricing != null ? commonPricing.hashCode() : 0);
			_result = 31 * _result + (marketDisruption != null ? marketDisruption.hashCode() : 0);
			_result = 31 * _result + (settlementDisruption != null ? settlementDisruption.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityOption {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"optionType=" + this.optionType + ", " +
				"commodity=" + this.commodity + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"calculationPeriods=" + this.calculationPeriods + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"barrier=" + this.barrier + ", " +
				"notionalQuantitySchedule=" + this.notionalQuantitySchedule + ", " +
				"notionalQuantity=" + this.notionalQuantity + ", " +
				"settlementPeriodsNotionalQuantity=" + this.settlementPeriodsNotionalQuantity + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity + ", " +
				"quantityReference=" + this.quantityReference + ", " +
				"exercise=" + this.exercise + ", " +
				"strikePricePerUnit=" + this.strikePricePerUnit + ", " +
				"strikePricePerUnitSchedule=" + this.strikePricePerUnitSchedule + ", " +
				"floatingStrikePricePerUnit=" + this.floatingStrikePricePerUnit + ", " +
				"floatingStrikePricePerUnitSchedule=" + this.floatingStrikePricePerUnitSchedule + ", " +
				"commoditySwap=" + this.commoditySwap + ", " +
				"commodityForward=" + this.commodityForward + ", " +
				"physicalExercise=" + this.physicalExercise + ", " +
				"weatherCalculationPeriods=" + this.weatherCalculationPeriods + ", " +
				"weatherCalculationPeriodsReference=" + this.weatherCalculationPeriodsReference + ", " +
				"weatherNotionalAmount=" + this.weatherNotionalAmount + ", " +
				"weatherIndexStrikeLevel=" + this.weatherIndexStrikeLevel + ", " +
				"calculation=" + this.calculation + ", " +
				"weatherIndexData=" + this.weatherIndexData + ", " +
				"premium=" + this.premium + ", " +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityOption  ***********************/
	class CommodityOptionBuilderImpl extends Product.ProductBuilderImpl implements CommodityOption.CommodityOptionBuilder {
	
		protected PartyReference.PartyReferenceBuilder buyerPartyReference;
		protected AccountReference.AccountReferenceBuilder buyerAccountReference;
		protected PartyReference.PartyReferenceBuilder sellerPartyReference;
		protected AccountReference.AccountReferenceBuilder sellerAccountReference;
		protected PutCallEnum optionType;
		protected Commodity.CommodityBuilder commodity;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder calculationPeriodsSchedule;
		protected AdjustableDates.AdjustableDatesBuilder calculationPeriods;
		protected CommodityPricingDates.CommodityPricingDatesBuilder pricingDates;
		protected AveragingMethodEnum averagingMethod;
		protected CommodityBarrier.CommodityBarrierBuilder barrier;
		protected CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder notionalQuantitySchedule;
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder notionalQuantity;
		protected List<CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder> settlementPeriodsNotionalQuantity = new ArrayList<>();
		protected BigDecimal totalNotionalQuantity;
		protected QuantityReference.QuantityReferenceBuilder quantityReference;
		protected CommodityExercise.CommodityExerciseBuilder exercise;
		protected NonNegativeMoney.NonNegativeMoneyBuilder strikePricePerUnit;
		protected CommodityStrikeSchedule.CommodityStrikeScheduleBuilder strikePricePerUnitSchedule;
		protected FloatingStrikePrice.FloatingStrikePriceBuilder floatingStrikePricePerUnit;
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder floatingStrikePricePerUnitSchedule;
		protected CommoditySwap.CommoditySwapBuilder commoditySwap;
		protected CommodityForward.CommodityForwardBuilder commodityForward;
		protected CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder physicalExercise;
		protected WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder weatherCalculationPeriods;
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder weatherCalculationPeriodsReference;
		protected NonNegativeMoney.NonNegativeMoneyBuilder weatherNotionalAmount;
		protected WeatherIndex.WeatherIndexBuilder weatherIndexStrikeLevel;
		protected WeatherLegCalculation.WeatherLegCalculationBuilder calculation;
		protected WeatherIndexData.WeatherIndexDataBuilder weatherIndexData;
		protected List<CommodityPremium.CommodityPremiumBuilder> premium = new ArrayList<>();
		protected Boolean commonPricing;
		protected CommodityMarketDisruption.CommodityMarketDisruptionBuilder marketDisruption;
		protected CommodityBullionSettlementDisruptionEnum settlementDisruption;
		protected Rounding.RoundingBuilder rounding;
		
		@Override
		@RosettaAttribute("buyerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("buyerPartyReference")
		public PartyReference.PartyReferenceBuilder getBuyerPartyReference() {
			return buyerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateBuyerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (buyerPartyReference!=null) {
				result = buyerPartyReference;
			}
			else {
				result = buyerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("buyerAccountReference")
		public AccountReference.AccountReferenceBuilder getBuyerAccountReference() {
			return buyerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateBuyerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (buyerAccountReference!=null) {
				result = buyerAccountReference;
			}
			else {
				result = buyerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		public PartyReference.PartyReferenceBuilder getSellerPartyReference() {
			return sellerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateSellerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (sellerPartyReference!=null) {
				result = sellerPartyReference;
			}
			else {
				result = sellerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sellerAccountReference")
		public AccountReference.AccountReferenceBuilder getSellerAccountReference() {
			return sellerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateSellerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (sellerAccountReference!=null) {
				result = sellerAccountReference;
			}
			else {
				result = sellerAccountReference = AccountReference.builder();
			}
			
			return result;
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
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("barrier")
		public CommodityBarrier.CommodityBarrierBuilder getBarrier() {
			return barrier;
		}
		
		@Override
		public CommodityBarrier.CommodityBarrierBuilder getOrCreateBarrier() {
			CommodityBarrier.CommodityBarrierBuilder result;
			if (barrier!=null) {
				result = barrier;
			}
			else {
				result = barrier = CommodityBarrier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notionalQuantitySchedule")
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder getNotionalQuantitySchedule() {
			return notionalQuantitySchedule;
		}
		
		@Override
		public CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder getOrCreateNotionalQuantitySchedule() {
			CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder result;
			if (notionalQuantitySchedule!=null) {
				result = notionalQuantitySchedule;
			}
			else {
				result = notionalQuantitySchedule = CommodityNotionalQuantitySchedule.builder();
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
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantity")
		public List<? extends CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder> getSettlementPeriodsNotionalQuantity() {
			return settlementPeriodsNotionalQuantity;
		}
		
		@Override
		public CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder getOrCreateSettlementPeriodsNotionalQuantity(int index) {
			if (settlementPeriodsNotionalQuantity==null) {
				this.settlementPeriodsNotionalQuantity = new ArrayList<>();
			}
			return getIndex(settlementPeriodsNotionalQuantity, index, () -> {
						CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder newSettlementPeriodsNotionalQuantity = CommoditySettlementPeriodsNotionalQuantity.builder();
						return newSettlementPeriodsNotionalQuantity;
					});
		}
		
		@Override
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("totalNotionalQuantity")
		public BigDecimal getTotalNotionalQuantity() {
			return totalNotionalQuantity;
		}
		
		@Override
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("quantityReference")
		public QuantityReference.QuantityReferenceBuilder getQuantityReference() {
			return quantityReference;
		}
		
		@Override
		public QuantityReference.QuantityReferenceBuilder getOrCreateQuantityReference() {
			QuantityReference.QuantityReferenceBuilder result;
			if (quantityReference!=null) {
				result = quantityReference;
			}
			else {
				result = quantityReference = QuantityReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exercise")
		public CommodityExercise.CommodityExerciseBuilder getExercise() {
			return exercise;
		}
		
		@Override
		public CommodityExercise.CommodityExerciseBuilder getOrCreateExercise() {
			CommodityExercise.CommodityExerciseBuilder result;
			if (exercise!=null) {
				result = exercise;
			}
			else {
				result = exercise = CommodityExercise.builder();
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
		@RosettaAttribute("commoditySwap")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commoditySwap")
		public CommoditySwap.CommoditySwapBuilder getCommoditySwap() {
			return commoditySwap;
		}
		
		@Override
		public CommoditySwap.CommoditySwapBuilder getOrCreateCommoditySwap() {
			CommoditySwap.CommoditySwapBuilder result;
			if (commoditySwap!=null) {
				result = commoditySwap;
			}
			else {
				result = commoditySwap = CommoditySwap.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityForward")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("commodityForward")
		public CommodityForward.CommodityForwardBuilder getCommodityForward() {
			return commodityForward;
		}
		
		@Override
		public CommodityForward.CommodityForwardBuilder getOrCreateCommodityForward() {
			CommodityForward.CommodityForwardBuilder result;
			if (commodityForward!=null) {
				result = commodityForward;
			}
			else {
				result = commodityForward = CommodityForward.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalExercise")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("physicalExercise")
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getPhysicalExercise() {
			return physicalExercise;
		}
		
		@Override
		public CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder getOrCreatePhysicalExercise() {
			CommodityPhysicalExercise.CommodityPhysicalExerciseBuilder result;
			if (physicalExercise!=null) {
				result = physicalExercise;
			}
			else {
				result = physicalExercise = CommodityPhysicalExercise.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherCalculationPeriods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherCalculationPeriods")
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder getWeatherCalculationPeriods() {
			return weatherCalculationPeriods;
		}
		
		@Override
		public WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder getOrCreateWeatherCalculationPeriods() {
			WeatherCalculationPeriods.WeatherCalculationPeriodsBuilder result;
			if (weatherCalculationPeriods!=null) {
				result = weatherCalculationPeriods;
			}
			else {
				result = weatherCalculationPeriods = WeatherCalculationPeriods.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherCalculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherCalculationPeriodsReference")
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getWeatherCalculationPeriodsReference() {
			return weatherCalculationPeriodsReference;
		}
		
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateWeatherCalculationPeriodsReference() {
			CalculationPeriodsReference.CalculationPeriodsReferenceBuilder result;
			if (weatherCalculationPeriodsReference!=null) {
				result = weatherCalculationPeriodsReference;
			}
			else {
				result = weatherCalculationPeriodsReference = CalculationPeriodsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherNotionalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getWeatherNotionalAmount() {
			return weatherNotionalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateWeatherNotionalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (weatherNotionalAmount!=null) {
				result = weatherNotionalAmount;
			}
			else {
				result = weatherNotionalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherIndexStrikeLevel")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherIndexStrikeLevel")
		public WeatherIndex.WeatherIndexBuilder getWeatherIndexStrikeLevel() {
			return weatherIndexStrikeLevel;
		}
		
		@Override
		public WeatherIndex.WeatherIndexBuilder getOrCreateWeatherIndexStrikeLevel() {
			WeatherIndex.WeatherIndexBuilder result;
			if (weatherIndexStrikeLevel!=null) {
				result = weatherIndexStrikeLevel;
			}
			else {
				result = weatherIndexStrikeLevel = WeatherIndex.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculation")
		public WeatherLegCalculation.WeatherLegCalculationBuilder getCalculation() {
			return calculation;
		}
		
		@Override
		public WeatherLegCalculation.WeatherLegCalculationBuilder getOrCreateCalculation() {
			WeatherLegCalculation.WeatherLegCalculationBuilder result;
			if (calculation!=null) {
				result = calculation;
			}
			else {
				result = calculation = WeatherLegCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weatherIndexData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("weatherIndexData")
		public WeatherIndexData.WeatherIndexDataBuilder getWeatherIndexData() {
			return weatherIndexData;
		}
		
		@Override
		public WeatherIndexData.WeatherIndexDataBuilder getOrCreateWeatherIndexData() {
			WeatherIndexData.WeatherIndexDataBuilder result;
			if (weatherIndexData!=null) {
				result = weatherIndexData;
			}
			else {
				result = weatherIndexData = WeatherIndexData.builder();
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
		public CommodityOption.CommodityOptionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("primaryAssetClass")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("primaryAssetClass")
		@Override
		public CommodityOption.CommodityOptionBuilder setPrimaryAssetClass(AssetClass _primaryAssetClass) {
			this.primaryAssetClass = _primaryAssetClass == null ? null : _primaryAssetClass.toBuilder();
			return this;
		}
		
		@RosettaAttribute("secondaryAssetClass")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("secondaryAssetClass")
		@Override
		public CommodityOption.CommodityOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass) {
			if (_secondaryAssetClass != null) {
				this.secondaryAssetClass.add(_secondaryAssetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addSecondaryAssetClass(AssetClass _secondaryAssetClass, int idx) {
			getIndex(this.secondaryAssetClass, idx, () -> _secondaryAssetClass.toBuilder());
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CommodityOption.CommodityOptionBuilder setSecondaryAssetClass(List<? extends AssetClass> secondaryAssetClasss) {
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
		public CommodityOption.CommodityOptionBuilder addProductType(ProductType _productType) {
			if (_productType != null) {
				this.productType.add(_productType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addProductType(ProductType _productType, int idx) {
			getIndex(this.productType, idx, () -> _productType.toBuilder());
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addProductType(List<? extends ProductType> productTypes) {
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
		public CommodityOption.CommodityOptionBuilder setProductType(List<? extends ProductType> productTypes) {
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
		public CommodityOption.CommodityOptionBuilder addProductId(ProductId _productId) {
			if (_productId != null) {
				this.productId.add(_productId.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addProductId(ProductId _productId, int idx) {
			getIndex(this.productId, idx, () -> _productId.toBuilder());
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addProductId(List<? extends ProductId> productIds) {
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
		public CommodityOption.CommodityOptionBuilder setProductId(List<? extends ProductId> productIds) {
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
		public CommodityOption.CommodityOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType) {
			if (_embeddedOptionType != null) {
				this.embeddedOptionType.add(_embeddedOptionType.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addEmbeddedOptionType(EmbeddedOptionType _embeddedOptionType, int idx) {
			getIndex(this.embeddedOptionType, idx, () -> _embeddedOptionType.toBuilder());
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CommodityOption.CommodityOptionBuilder setEmbeddedOptionType(List<? extends EmbeddedOptionType> embeddedOptionTypes) {
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
		public CommodityOption.CommodityOptionBuilder addAssetClass(AssetClass _assetClass) {
			if (_assetClass != null) {
				this.assetClass.add(_assetClass.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addAssetClass(AssetClass _assetClass, int idx) {
			getIndex(this.assetClass, idx, () -> _assetClass.toBuilder());
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CommodityOption.CommodityOptionBuilder setAssetClass(List<? extends AssetClass> assetClasss) {
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
		public CommodityOption.CommodityOptionBuilder setBuyerPartyReference(PartyReference _buyerPartyReference) {
			this.buyerPartyReference = _buyerPartyReference == null ? null : _buyerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buyerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buyerAccountReference")
		@Override
		public CommodityOption.CommodityOptionBuilder setBuyerAccountReference(AccountReference _buyerAccountReference) {
			this.buyerAccountReference = _buyerAccountReference == null ? null : _buyerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("sellerPartyReference")
		@Override
		public CommodityOption.CommodityOptionBuilder setSellerPartyReference(PartyReference _sellerPartyReference) {
			this.sellerPartyReference = _sellerPartyReference == null ? null : _sellerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sellerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sellerAccountReference")
		@Override
		public CommodityOption.CommodityOptionBuilder setSellerAccountReference(AccountReference _sellerAccountReference) {
			this.sellerAccountReference = _sellerAccountReference == null ? null : _sellerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("optionType")
		@Override
		public CommodityOption.CommodityOptionBuilder setOptionType(PutCallEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodity")
		@Override
		public CommodityOption.CommodityOptionBuilder setCommodity(Commodity _commodity) {
			this.commodity = _commodity == null ? null : _commodity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("effectiveDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("effectiveDate")
		@Override
		public CommodityOption.CommodityOptionBuilder setEffectiveDate(AdjustableOrRelativeDate _effectiveDate) {
			this.effectiveDate = _effectiveDate == null ? null : _effectiveDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminationDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminationDate")
		@Override
		public CommodityOption.CommodityOptionBuilder setTerminationDate(AdjustableOrRelativeDate _terminationDate) {
			this.terminationDate = _terminationDate == null ? null : _terminationDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsSchedule")
		@Override
		public CommodityOption.CommodityOptionBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule _calculationPeriodsSchedule) {
			this.calculationPeriodsSchedule = _calculationPeriodsSchedule == null ? null : _calculationPeriodsSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriods")
		@Override
		public CommodityOption.CommodityOptionBuilder setCalculationPeriods(AdjustableDates _calculationPeriods) {
			this.calculationPeriods = _calculationPeriods == null ? null : _calculationPeriods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pricingDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingDates")
		@Override
		public CommodityOption.CommodityOptionBuilder setPricingDates(CommodityPricingDates _pricingDates) {
			this.pricingDates = _pricingDates == null ? null : _pricingDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("averagingMethod")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averagingMethod")
		@Override
		public CommodityOption.CommodityOptionBuilder setAveragingMethod(AveragingMethodEnum _averagingMethod) {
			this.averagingMethod = _averagingMethod == null ? null : _averagingMethod;
			return this;
		}
		
		@RosettaAttribute("barrier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("barrier")
		@Override
		public CommodityOption.CommodityOptionBuilder setBarrier(CommodityBarrier _barrier) {
			this.barrier = _barrier == null ? null : _barrier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantitySchedule")
		@Override
		public CommodityOption.CommodityOptionBuilder setNotionalQuantitySchedule(CommodityNotionalQuantitySchedule _notionalQuantitySchedule) {
			this.notionalQuantitySchedule = _notionalQuantitySchedule == null ? null : _notionalQuantitySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantity")
		@Override
		public CommodityOption.CommodityOptionBuilder setNotionalQuantity(CommodityNotionalQuantity _notionalQuantity) {
			this.notionalQuantity = _notionalQuantity == null ? null : _notionalQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantity")
		@Override
		public CommodityOption.CommodityOptionBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity _settlementPeriodsNotionalQuantity) {
			if (_settlementPeriodsNotionalQuantity != null) {
				this.settlementPeriodsNotionalQuantity.add(_settlementPeriodsNotionalQuantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity _settlementPeriodsNotionalQuantity, int idx) {
			getIndex(this.settlementPeriodsNotionalQuantity, idx, () -> _settlementPeriodsNotionalQuantity.toBuilder());
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantitys) {
			if (settlementPeriodsNotionalQuantitys != null) {
				for (final CommoditySettlementPeriodsNotionalQuantity toAdd : settlementPeriodsNotionalQuantitys) {
					this.settlementPeriodsNotionalQuantity.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantity")
		@Override
		public CommodityOption.CommodityOptionBuilder setSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantitys) {
			if (settlementPeriodsNotionalQuantitys == null) {
				this.settlementPeriodsNotionalQuantity = new ArrayList<>();
			} else {
				this.settlementPeriodsNotionalQuantity = settlementPeriodsNotionalQuantitys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("totalNotionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("totalNotionalQuantity")
		@Override
		public CommodityOption.CommodityOptionBuilder setTotalNotionalQuantity(BigDecimal _totalNotionalQuantity) {
			this.totalNotionalQuantity = _totalNotionalQuantity == null ? null : _totalNotionalQuantity;
			return this;
		}
		
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityReference")
		@Override
		public CommodityOption.CommodityOptionBuilder setQuantityReference(QuantityReference _quantityReference) {
			this.quantityReference = _quantityReference == null ? null : _quantityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("exercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exercise")
		@Override
		public CommodityOption.CommodityOptionBuilder setExercise(CommodityExercise _exercise) {
			this.exercise = _exercise == null ? null : _exercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePricePerUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePricePerUnit")
		@Override
		public CommodityOption.CommodityOptionBuilder setStrikePricePerUnit(NonNegativeMoney _strikePricePerUnit) {
			this.strikePricePerUnit = _strikePricePerUnit == null ? null : _strikePricePerUnit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("strikePricePerUnitSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("strikePricePerUnitSchedule")
		@Override
		public CommodityOption.CommodityOptionBuilder setStrikePricePerUnitSchedule(CommodityStrikeSchedule _strikePricePerUnitSchedule) {
			this.strikePricePerUnitSchedule = _strikePricePerUnitSchedule == null ? null : _strikePricePerUnitSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingStrikePricePerUnit")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingStrikePricePerUnit")
		@Override
		public CommodityOption.CommodityOptionBuilder setFloatingStrikePricePerUnit(FloatingStrikePrice _floatingStrikePricePerUnit) {
			this.floatingStrikePricePerUnit = _floatingStrikePricePerUnit == null ? null : _floatingStrikePricePerUnit.toBuilder();
			return this;
		}
		
		@RosettaAttribute("floatingStrikePricePerUnitSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("floatingStrikePricePerUnitSchedule")
		@Override
		public CommodityOption.CommodityOptionBuilder setFloatingStrikePricePerUnitSchedule(CommodityCalculationPeriodsSchedule _floatingStrikePricePerUnitSchedule) {
			this.floatingStrikePricePerUnitSchedule = _floatingStrikePricePerUnitSchedule == null ? null : _floatingStrikePricePerUnitSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commoditySwap")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commoditySwap")
		@Override
		public CommodityOption.CommodityOptionBuilder setCommoditySwap(CommoditySwap _commoditySwap) {
			this.commoditySwap = _commoditySwap == null ? null : _commoditySwap.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commodityForward")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("commodityForward")
		@Override
		public CommodityOption.CommodityOptionBuilder setCommodityForward(CommodityForward _commodityForward) {
			this.commodityForward = _commodityForward == null ? null : _commodityForward.toBuilder();
			return this;
		}
		
		@RosettaAttribute("physicalExercise")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("physicalExercise")
		@Override
		public CommodityOption.CommodityOptionBuilder setPhysicalExercise(CommodityPhysicalExercise _physicalExercise) {
			this.physicalExercise = _physicalExercise == null ? null : _physicalExercise.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherCalculationPeriods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherCalculationPeriods")
		@Override
		public CommodityOption.CommodityOptionBuilder setWeatherCalculationPeriods(WeatherCalculationPeriods _weatherCalculationPeriods) {
			this.weatherCalculationPeriods = _weatherCalculationPeriods == null ? null : _weatherCalculationPeriods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherCalculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherCalculationPeriodsReference")
		@Override
		public CommodityOption.CommodityOptionBuilder setWeatherCalculationPeriodsReference(CalculationPeriodsReference _weatherCalculationPeriodsReference) {
			this.weatherCalculationPeriodsReference = _weatherCalculationPeriodsReference == null ? null : _weatherCalculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherNotionalAmount")
		@Override
		public CommodityOption.CommodityOptionBuilder setWeatherNotionalAmount(NonNegativeMoney _weatherNotionalAmount) {
			this.weatherNotionalAmount = _weatherNotionalAmount == null ? null : _weatherNotionalAmount.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherIndexStrikeLevel")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherIndexStrikeLevel")
		@Override
		public CommodityOption.CommodityOptionBuilder setWeatherIndexStrikeLevel(WeatherIndex _weatherIndexStrikeLevel) {
			this.weatherIndexStrikeLevel = _weatherIndexStrikeLevel == null ? null : _weatherIndexStrikeLevel.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculation")
		@Override
		public CommodityOption.CommodityOptionBuilder setCalculation(WeatherLegCalculation _calculation) {
			this.calculation = _calculation == null ? null : _calculation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("weatherIndexData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("weatherIndexData")
		@Override
		public CommodityOption.CommodityOptionBuilder setWeatherIndexData(WeatherIndexData _weatherIndexData) {
			this.weatherIndexData = _weatherIndexData == null ? null : _weatherIndexData.toBuilder();
			return this;
		}
		
		@RosettaAttribute("premium")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("premium")
		@Override
		public CommodityOption.CommodityOptionBuilder addPremium(CommodityPremium _premium) {
			if (_premium != null) {
				this.premium.add(_premium.toBuilder());
			}
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addPremium(CommodityPremium _premium, int idx) {
			getIndex(this.premium, idx, () -> _premium.toBuilder());
			return this;
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder addPremium(List<? extends CommodityPremium> premiums) {
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
		public CommodityOption.CommodityOptionBuilder setPremium(List<? extends CommodityPremium> premiums) {
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
		public CommodityOption.CommodityOptionBuilder setCommonPricing(Boolean _commonPricing) {
			this.commonPricing = _commonPricing == null ? null : _commonPricing;
			return this;
		}
		
		@RosettaAttribute("marketDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("marketDisruption")
		@Override
		public CommodityOption.CommodityOptionBuilder setMarketDisruption(CommodityMarketDisruption _marketDisruption) {
			this.marketDisruption = _marketDisruption == null ? null : _marketDisruption.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementDisruption")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("settlementDisruption")
		@Override
		public CommodityOption.CommodityOptionBuilder setSettlementDisruption(CommodityBullionSettlementDisruptionEnum _settlementDisruption) {
			this.settlementDisruption = _settlementDisruption == null ? null : _settlementDisruption;
			return this;
		}
		
		@RosettaAttribute("rounding")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rounding")
		@Override
		public CommodityOption.CommodityOptionBuilder setRounding(Rounding _rounding) {
			this.rounding = _rounding == null ? null : _rounding.toBuilder();
			return this;
		}
		
		@Override
		public CommodityOption build() {
			return new CommodityOption.CommodityOptionImpl(this);
		}
		
		@Override
		public CommodityOption.CommodityOptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityOption.CommodityOptionBuilder prune() {
			super.prune();
			if (buyerPartyReference!=null && !buyerPartyReference.prune().hasData()) buyerPartyReference = null;
			if (buyerAccountReference!=null && !buyerAccountReference.prune().hasData()) buyerAccountReference = null;
			if (sellerPartyReference!=null && !sellerPartyReference.prune().hasData()) sellerPartyReference = null;
			if (sellerAccountReference!=null && !sellerAccountReference.prune().hasData()) sellerAccountReference = null;
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			if (calculationPeriodsSchedule!=null && !calculationPeriodsSchedule.prune().hasData()) calculationPeriodsSchedule = null;
			if (calculationPeriods!=null && !calculationPeriods.prune().hasData()) calculationPeriods = null;
			if (pricingDates!=null && !pricingDates.prune().hasData()) pricingDates = null;
			if (barrier!=null && !barrier.prune().hasData()) barrier = null;
			if (notionalQuantitySchedule!=null && !notionalQuantitySchedule.prune().hasData()) notionalQuantitySchedule = null;
			if (notionalQuantity!=null && !notionalQuantity.prune().hasData()) notionalQuantity = null;
			settlementPeriodsNotionalQuantity = settlementPeriodsNotionalQuantity.stream().filter(b->b!=null).<CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (quantityReference!=null && !quantityReference.prune().hasData()) quantityReference = null;
			if (exercise!=null && !exercise.prune().hasData()) exercise = null;
			if (strikePricePerUnit!=null && !strikePricePerUnit.prune().hasData()) strikePricePerUnit = null;
			if (strikePricePerUnitSchedule!=null && !strikePricePerUnitSchedule.prune().hasData()) strikePricePerUnitSchedule = null;
			if (floatingStrikePricePerUnit!=null && !floatingStrikePricePerUnit.prune().hasData()) floatingStrikePricePerUnit = null;
			if (floatingStrikePricePerUnitSchedule!=null && !floatingStrikePricePerUnitSchedule.prune().hasData()) floatingStrikePricePerUnitSchedule = null;
			if (commoditySwap!=null && !commoditySwap.prune().hasData()) commoditySwap = null;
			if (commodityForward!=null && !commodityForward.prune().hasData()) commodityForward = null;
			if (physicalExercise!=null && !physicalExercise.prune().hasData()) physicalExercise = null;
			if (weatherCalculationPeriods!=null && !weatherCalculationPeriods.prune().hasData()) weatherCalculationPeriods = null;
			if (weatherCalculationPeriodsReference!=null && !weatherCalculationPeriodsReference.prune().hasData()) weatherCalculationPeriodsReference = null;
			if (weatherNotionalAmount!=null && !weatherNotionalAmount.prune().hasData()) weatherNotionalAmount = null;
			if (weatherIndexStrikeLevel!=null && !weatherIndexStrikeLevel.prune().hasData()) weatherIndexStrikeLevel = null;
			if (calculation!=null && !calculation.prune().hasData()) calculation = null;
			if (weatherIndexData!=null && !weatherIndexData.prune().hasData()) weatherIndexData = null;
			premium = premium.stream().filter(b->b!=null).<CommodityPremium.CommodityPremiumBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (marketDisruption!=null && !marketDisruption.prune().hasData()) marketDisruption = null;
			if (rounding!=null && !rounding.prune().hasData()) rounding = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getBuyerPartyReference()!=null && getBuyerPartyReference().hasData()) return true;
			if (getBuyerAccountReference()!=null && getBuyerAccountReference().hasData()) return true;
			if (getSellerPartyReference()!=null && getSellerPartyReference().hasData()) return true;
			if (getSellerAccountReference()!=null && getSellerAccountReference().hasData()) return true;
			if (getOptionType()!=null) return true;
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getCalculationPeriodsSchedule()!=null && getCalculationPeriodsSchedule().hasData()) return true;
			if (getCalculationPeriods()!=null && getCalculationPeriods().hasData()) return true;
			if (getPricingDates()!=null && getPricingDates().hasData()) return true;
			if (getAveragingMethod()!=null) return true;
			if (getBarrier()!=null && getBarrier().hasData()) return true;
			if (getNotionalQuantitySchedule()!=null && getNotionalQuantitySchedule().hasData()) return true;
			if (getNotionalQuantity()!=null && getNotionalQuantity().hasData()) return true;
			if (getSettlementPeriodsNotionalQuantity()!=null && getSettlementPeriodsNotionalQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTotalNotionalQuantity()!=null) return true;
			if (getQuantityReference()!=null && getQuantityReference().hasData()) return true;
			if (getExercise()!=null && getExercise().hasData()) return true;
			if (getStrikePricePerUnit()!=null && getStrikePricePerUnit().hasData()) return true;
			if (getStrikePricePerUnitSchedule()!=null && getStrikePricePerUnitSchedule().hasData()) return true;
			if (getFloatingStrikePricePerUnit()!=null && getFloatingStrikePricePerUnit().hasData()) return true;
			if (getFloatingStrikePricePerUnitSchedule()!=null && getFloatingStrikePricePerUnitSchedule().hasData()) return true;
			if (getCommoditySwap()!=null && getCommoditySwap().hasData()) return true;
			if (getCommodityForward()!=null && getCommodityForward().hasData()) return true;
			if (getPhysicalExercise()!=null && getPhysicalExercise().hasData()) return true;
			if (getWeatherCalculationPeriods()!=null && getWeatherCalculationPeriods().hasData()) return true;
			if (getWeatherCalculationPeriodsReference()!=null && getWeatherCalculationPeriodsReference().hasData()) return true;
			if (getWeatherNotionalAmount()!=null && getWeatherNotionalAmount().hasData()) return true;
			if (getWeatherIndexStrikeLevel()!=null && getWeatherIndexStrikeLevel().hasData()) return true;
			if (getCalculation()!=null && getCalculation().hasData()) return true;
			if (getWeatherIndexData()!=null && getWeatherIndexData().hasData()) return true;
			if (getPremium()!=null && getPremium().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCommonPricing()!=null) return true;
			if (getMarketDisruption()!=null && getMarketDisruption().hasData()) return true;
			if (getSettlementDisruption()!=null) return true;
			if (getRounding()!=null && getRounding().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityOption.CommodityOptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			CommodityOption.CommodityOptionBuilder o = (CommodityOption.CommodityOptionBuilder) other;
			
			merger.mergeRosetta(getBuyerPartyReference(), o.getBuyerPartyReference(), this::setBuyerPartyReference);
			merger.mergeRosetta(getBuyerAccountReference(), o.getBuyerAccountReference(), this::setBuyerAccountReference);
			merger.mergeRosetta(getSellerPartyReference(), o.getSellerPartyReference(), this::setSellerPartyReference);
			merger.mergeRosetta(getSellerAccountReference(), o.getSellerAccountReference(), this::setSellerAccountReference);
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getCalculationPeriodsSchedule(), o.getCalculationPeriodsSchedule(), this::setCalculationPeriodsSchedule);
			merger.mergeRosetta(getCalculationPeriods(), o.getCalculationPeriods(), this::setCalculationPeriods);
			merger.mergeRosetta(getPricingDates(), o.getPricingDates(), this::setPricingDates);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::setBarrier);
			merger.mergeRosetta(getNotionalQuantitySchedule(), o.getNotionalQuantitySchedule(), this::setNotionalQuantitySchedule);
			merger.mergeRosetta(getNotionalQuantity(), o.getNotionalQuantity(), this::setNotionalQuantity);
			merger.mergeRosetta(getSettlementPeriodsNotionalQuantity(), o.getSettlementPeriodsNotionalQuantity(), this::getOrCreateSettlementPeriodsNotionalQuantity);
			merger.mergeRosetta(getQuantityReference(), o.getQuantityReference(), this::setQuantityReference);
			merger.mergeRosetta(getExercise(), o.getExercise(), this::setExercise);
			merger.mergeRosetta(getStrikePricePerUnit(), o.getStrikePricePerUnit(), this::setStrikePricePerUnit);
			merger.mergeRosetta(getStrikePricePerUnitSchedule(), o.getStrikePricePerUnitSchedule(), this::setStrikePricePerUnitSchedule);
			merger.mergeRosetta(getFloatingStrikePricePerUnit(), o.getFloatingStrikePricePerUnit(), this::setFloatingStrikePricePerUnit);
			merger.mergeRosetta(getFloatingStrikePricePerUnitSchedule(), o.getFloatingStrikePricePerUnitSchedule(), this::setFloatingStrikePricePerUnitSchedule);
			merger.mergeRosetta(getCommoditySwap(), o.getCommoditySwap(), this::setCommoditySwap);
			merger.mergeRosetta(getCommodityForward(), o.getCommodityForward(), this::setCommodityForward);
			merger.mergeRosetta(getPhysicalExercise(), o.getPhysicalExercise(), this::setPhysicalExercise);
			merger.mergeRosetta(getWeatherCalculationPeriods(), o.getWeatherCalculationPeriods(), this::setWeatherCalculationPeriods);
			merger.mergeRosetta(getWeatherCalculationPeriodsReference(), o.getWeatherCalculationPeriodsReference(), this::setWeatherCalculationPeriodsReference);
			merger.mergeRosetta(getWeatherNotionalAmount(), o.getWeatherNotionalAmount(), this::setWeatherNotionalAmount);
			merger.mergeRosetta(getWeatherIndexStrikeLevel(), o.getWeatherIndexStrikeLevel(), this::setWeatherIndexStrikeLevel);
			merger.mergeRosetta(getCalculation(), o.getCalculation(), this::setCalculation);
			merger.mergeRosetta(getWeatherIndexData(), o.getWeatherIndexData(), this::setWeatherIndexData);
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
		
			CommodityOption _that = getType().cast(o);
		
			if (!Objects.equals(buyerPartyReference, _that.getBuyerPartyReference())) return false;
			if (!Objects.equals(buyerAccountReference, _that.getBuyerAccountReference())) return false;
			if (!Objects.equals(sellerPartyReference, _that.getSellerPartyReference())) return false;
			if (!Objects.equals(sellerAccountReference, _that.getSellerAccountReference())) return false;
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			if (!Objects.equals(pricingDates, _that.getPricingDates())) return false;
			if (!Objects.equals(averagingMethod, _that.getAveragingMethod())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			if (!Objects.equals(notionalQuantitySchedule, _that.getNotionalQuantitySchedule())) return false;
			if (!Objects.equals(notionalQuantity, _that.getNotionalQuantity())) return false;
			if (!ListEquals.listEquals(settlementPeriodsNotionalQuantity, _that.getSettlementPeriodsNotionalQuantity())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			if (!Objects.equals(exercise, _that.getExercise())) return false;
			if (!Objects.equals(strikePricePerUnit, _that.getStrikePricePerUnit())) return false;
			if (!Objects.equals(strikePricePerUnitSchedule, _that.getStrikePricePerUnitSchedule())) return false;
			if (!Objects.equals(floatingStrikePricePerUnit, _that.getFloatingStrikePricePerUnit())) return false;
			if (!Objects.equals(floatingStrikePricePerUnitSchedule, _that.getFloatingStrikePricePerUnitSchedule())) return false;
			if (!Objects.equals(commoditySwap, _that.getCommoditySwap())) return false;
			if (!Objects.equals(commodityForward, _that.getCommodityForward())) return false;
			if (!Objects.equals(physicalExercise, _that.getPhysicalExercise())) return false;
			if (!Objects.equals(weatherCalculationPeriods, _that.getWeatherCalculationPeriods())) return false;
			if (!Objects.equals(weatherCalculationPeriodsReference, _that.getWeatherCalculationPeriodsReference())) return false;
			if (!Objects.equals(weatherNotionalAmount, _that.getWeatherNotionalAmount())) return false;
			if (!Objects.equals(weatherIndexStrikeLevel, _that.getWeatherIndexStrikeLevel())) return false;
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(weatherIndexData, _that.getWeatherIndexData())) return false;
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
			_result = 31 * _result + (buyerPartyReference != null ? buyerPartyReference.hashCode() : 0);
			_result = 31 * _result + (buyerAccountReference != null ? buyerAccountReference.hashCode() : 0);
			_result = 31 * _result + (sellerPartyReference != null ? sellerPartyReference.hashCode() : 0);
			_result = 31 * _result + (sellerAccountReference != null ? sellerAccountReference.hashCode() : 0);
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			_result = 31 * _result + (pricingDates != null ? pricingDates.hashCode() : 0);
			_result = 31 * _result + (averagingMethod != null ? averagingMethod.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			_result = 31 * _result + (notionalQuantitySchedule != null ? notionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (notionalQuantity != null ? notionalQuantity.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsNotionalQuantity != null ? settlementPeriodsNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			_result = 31 * _result + (exercise != null ? exercise.hashCode() : 0);
			_result = 31 * _result + (strikePricePerUnit != null ? strikePricePerUnit.hashCode() : 0);
			_result = 31 * _result + (strikePricePerUnitSchedule != null ? strikePricePerUnitSchedule.hashCode() : 0);
			_result = 31 * _result + (floatingStrikePricePerUnit != null ? floatingStrikePricePerUnit.hashCode() : 0);
			_result = 31 * _result + (floatingStrikePricePerUnitSchedule != null ? floatingStrikePricePerUnitSchedule.hashCode() : 0);
			_result = 31 * _result + (commoditySwap != null ? commoditySwap.hashCode() : 0);
			_result = 31 * _result + (commodityForward != null ? commodityForward.hashCode() : 0);
			_result = 31 * _result + (physicalExercise != null ? physicalExercise.hashCode() : 0);
			_result = 31 * _result + (weatherCalculationPeriods != null ? weatherCalculationPeriods.hashCode() : 0);
			_result = 31 * _result + (weatherCalculationPeriodsReference != null ? weatherCalculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (weatherNotionalAmount != null ? weatherNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (weatherIndexStrikeLevel != null ? weatherIndexStrikeLevel.hashCode() : 0);
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (weatherIndexData != null ? weatherIndexData.hashCode() : 0);
			_result = 31 * _result + (premium != null ? premium.hashCode() : 0);
			_result = 31 * _result + (commonPricing != null ? commonPricing.hashCode() : 0);
			_result = 31 * _result + (marketDisruption != null ? marketDisruption.hashCode() : 0);
			_result = 31 * _result + (settlementDisruption != null ? settlementDisruption.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (rounding != null ? rounding.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityOptionBuilder {" +
				"buyerPartyReference=" + this.buyerPartyReference + ", " +
				"buyerAccountReference=" + this.buyerAccountReference + ", " +
				"sellerPartyReference=" + this.sellerPartyReference + ", " +
				"sellerAccountReference=" + this.sellerAccountReference + ", " +
				"optionType=" + this.optionType + ", " +
				"commodity=" + this.commodity + ", " +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"calculationPeriods=" + this.calculationPeriods + ", " +
				"pricingDates=" + this.pricingDates + ", " +
				"averagingMethod=" + this.averagingMethod + ", " +
				"barrier=" + this.barrier + ", " +
				"notionalQuantitySchedule=" + this.notionalQuantitySchedule + ", " +
				"notionalQuantity=" + this.notionalQuantity + ", " +
				"settlementPeriodsNotionalQuantity=" + this.settlementPeriodsNotionalQuantity + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity + ", " +
				"quantityReference=" + this.quantityReference + ", " +
				"exercise=" + this.exercise + ", " +
				"strikePricePerUnit=" + this.strikePricePerUnit + ", " +
				"strikePricePerUnitSchedule=" + this.strikePricePerUnitSchedule + ", " +
				"floatingStrikePricePerUnit=" + this.floatingStrikePricePerUnit + ", " +
				"floatingStrikePricePerUnitSchedule=" + this.floatingStrikePricePerUnitSchedule + ", " +
				"commoditySwap=" + this.commoditySwap + ", " +
				"commodityForward=" + this.commodityForward + ", " +
				"physicalExercise=" + this.physicalExercise + ", " +
				"weatherCalculationPeriods=" + this.weatherCalculationPeriods + ", " +
				"weatherCalculationPeriodsReference=" + this.weatherCalculationPeriodsReference + ", " +
				"weatherNotionalAmount=" + this.weatherNotionalAmount + ", " +
				"weatherIndexStrikeLevel=" + this.weatherIndexStrikeLevel + ", " +
				"calculation=" + this.calculation + ", " +
				"weatherIndexData=" + this.weatherIndexData + ", " +
				"premium=" + this.premium + ", " +
				"commonPricing=" + this.commonPricing + ", " +
				"marketDisruption=" + this.marketDisruption + ", " +
				"settlementDisruption=" + this.settlementDisruption + ", " +
				"rounding=" + this.rounding +
			'}' + " " + super.toString();
		}
	}
}
