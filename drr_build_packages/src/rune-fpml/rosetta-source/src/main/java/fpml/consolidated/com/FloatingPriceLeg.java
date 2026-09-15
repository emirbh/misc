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
import fpml.consolidated.com.meta.FloatingPriceLegMeta;
import fpml.consolidated.fpmlenum.FlatRateEnum;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.AdjustableDates;
import fpml.consolidated.shared.AdjustableDatesOrRelativeDateOffset;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
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
 * Provision Floating Price Leg of a Commodity Swap. Each 'floatingLeg' defines a series of financial payments for a commodity the value of which is derived from a floating price such as an exchange or an index publication.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Floating Price Leg of a Commodity Swap. Each 'floatingLeg' defines a series of financial payments for a commodity the value of which is derived from a floating price such as an exchange or an index publication.
 *
 */
@RosettaDataType(value="FloatingPriceLeg", builder=FloatingPriceLeg.FloatingPriceLegBuilderImpl.class, version="2.1.1")
@RuneDataType(value="FloatingPriceLeg", model="fpml", builder=FloatingPriceLeg.FloatingPriceLegBuilderImpl.class, version="2.1.1")
public interface FloatingPriceLeg extends FinancialSwapLeg {

	FloatingPriceLegMeta metaData = new FloatingPriceLegMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Calculation Period dates for this leg of the trade where the Calculation Periods are all one day long. Only dates explicitly included determine the Calculation Periods and there is a Calculation Period for each date specified. As such one-day Calculation Period are typical a physically-settled emissions or metals trades it is expected that this element will not be used in performance swaps.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Calculation Period dates for this leg of the trade where the Calculation Periods are all one day long. Only dates explicitly included determine the Calculation Periods and there is a Calculation Period for each date specified. As such one-day Calculation Period are typical a physically-settled emissions or metals trades it is expected that this element will not be used in performance swaps.
	 *
	 */
	AdjustableDates getCalculationDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Calculation Period start dates for this leg of the swap. This type is only intended to be used if the Calculation Periods differ on each leg. If Calculation Periods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on that leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Calculation Period start dates for this leg of the swap. This type is only intended to be used if the Calculation Periods differ on each leg. If Calculation Periods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on that leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 *
	 */
	AdjustableDates getCalculationPeriods();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Calculation Periods for this leg of the swap. This type is only intended to be used if the Calculation Periods differ on each leg. If Calculation Periods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on the other leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Calculation Periods for this leg of the swap. This type is only intended to be used if the Calculation Periods differ on each leg. If Calculation Periods mirror another leg, then the calculationPeriodsReference element should be used to point to the Calculation Periods on the other leg - or the calculationPeriodsScheduleReference can be used to point to the Calculation Periods Schedule for that leg.
	 *
	 */
	CommodityCalculationPeriodsSchedule getCalculationPeriodsSchedule();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods defined on another leg.
	 *
	 */
	CalculationPeriodsReference getCalculationPeriodsReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to the Calculation Periods Schedule defined on another leg.
	 *
	 */
	CalculationPeriodsScheduleReference getCalculationPeriodsScheduleReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A pointer style reference to single-day-duration Calculation Periods defined on another leg.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A pointer style reference to single-day-duration Calculation Periods defined on another leg.
	 *
	 */
	CalculationPeriodsDatesReference getCalculationPeriodsDatesReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Specifies the underlying instrument. Only underlyers of type Commodity are supported.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specifies the underlying instrument. Only underlyers of type Commodity are supported.
	 *
	 */
	Commodity getCommodity();
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
	 * Provision Defines details relevant to the calculation of the floating price.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Defines details relevant to the calculation of the floating price.
	 *
	 */
	FloatingLegCalculation getCalculation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The Payment Dates of the trade relative to the Calculation Periods.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The Payment Dates of the trade relative to the Calculation Periods.
	 *
	 */
	CommodityRelativePaymentDates getRelativePaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Dates on which payments will be made.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Dates on which payments will be made.
	 *
	 */
	AdjustableDatesOrRelativeDateOffset getPaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If present and true indicates that the Payment Date(s) are specified in the relevant master agreement.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If present and true indicates that the Payment Date(s) are specified in the relevant master agreement.
	 *
	 */
	Boolean getMasterAgreementPaymentDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Whether the Flat Rate is the New Worldwide Tanker Nominal Freight Scale for the Freight Index Route taken at the Trade Date of the transaction or taken on each Pricing Date.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Whether the Flat Rate is the New Worldwide Tanker Nominal Freight Scale for the Freight Index Route taken at the Trade Date of the transaction or taken on each Pricing Date.
	 *
	 */
	FlatRateEnum getFlatRate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision If flatRate is set to "Fixed", the actual value of the Flat Rate.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision If flatRate is set to "Fixed", the actual value of the Flat Rate.
	 *
	 */
	NonNegativeMoney getFlatRateAmount();

	/*********************** Build Methods  ***********************/
	FloatingPriceLeg build();
	
	FloatingPriceLeg.FloatingPriceLegBuilder toBuilder();
	
	static FloatingPriceLeg.FloatingPriceLegBuilder builder() {
		return new FloatingPriceLeg.FloatingPriceLegBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingPriceLeg> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingPriceLeg> getType() {
		return FloatingPriceLeg.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
		processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.class, getReceiverPartyReference());
		processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.class, getReceiverAccountReference());
		processRosetta(path.newSubPath("calculationDates"), processor, AdjustableDates.class, getCalculationDates());
		processRosetta(path.newSubPath("calculationPeriods"), processor, AdjustableDates.class, getCalculationPeriods());
		processRosetta(path.newSubPath("calculationPeriodsSchedule"), processor, CommodityCalculationPeriodsSchedule.class, getCalculationPeriodsSchedule());
		processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.class, getCalculationPeriodsReference());
		processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.class, getCalculationPeriodsScheduleReference());
		processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.class, getCalculationPeriodsDatesReference());
		processRosetta(path.newSubPath("commodity"), processor, Commodity.class, getCommodity());
		processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, CommodityNotionalQuantitySchedule.class, getNotionalQuantitySchedule());
		processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.class, getNotionalQuantity());
		processRosetta(path.newSubPath("settlementPeriodsNotionalQuantity"), processor, CommoditySettlementPeriodsNotionalQuantity.class, getSettlementPeriodsNotionalQuantity());
		processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
		processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.class, getQuantityReference());
		processRosetta(path.newSubPath("calculation"), processor, FloatingLegCalculation.class, getCalculation());
		processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.class, getRelativePaymentDates());
		processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.class, getPaymentDates());
		processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
		processor.processBasic(path.newSubPath("flatRate"), FlatRateEnum.class, getFlatRate(), this);
		processRosetta(path.newSubPath("flatRateAmount"), processor, NonNegativeMoney.class, getFlatRateAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingPriceLegBuilder extends FloatingPriceLeg, FinancialSwapLeg.FinancialSwapLegBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationDates();
		@Override
		AdjustableDates.AdjustableDatesBuilder getCalculationDates();
		AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationPeriods();
		@Override
		AdjustableDates.AdjustableDatesBuilder getCalculationPeriods();
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getOrCreateCalculationPeriodsSchedule();
		@Override
		CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder getCalculationPeriodsSchedule();
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference();
		@Override
		CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference();
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference();
		@Override
		CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference();
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference();
		@Override
		CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference();
		Commodity.CommodityBuilder getOrCreateCommodity();
		@Override
		Commodity.CommodityBuilder getCommodity();
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
		FloatingLegCalculation.FloatingLegCalculationBuilder getOrCreateCalculation();
		@Override
		FloatingLegCalculation.FloatingLegCalculationBuilder getCalculation();
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreateRelativePaymentDates();
		@Override
		CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getRelativePaymentDates();
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getOrCreatePaymentDates();
		@Override
		AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getPaymentDates();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateFlatRateAmount();
		@Override
		NonNegativeMoney.NonNegativeMoneyBuilder getFlatRateAmount();
		@Override
		FloatingPriceLeg.FloatingPriceLegBuilder setId(String id);
		@Override
		FloatingPriceLeg.FloatingPriceLegBuilder setPayerPartyReference(PartyReference payerPartyReference);
		@Override
		FloatingPriceLeg.FloatingPriceLegBuilder setPayerAccountReference(AccountReference payerAccountReference);
		@Override
		FloatingPriceLeg.FloatingPriceLegBuilder setReceiverPartyReference(PartyReference receiverPartyReference);
		@Override
		FloatingPriceLeg.FloatingPriceLegBuilder setReceiverAccountReference(AccountReference receiverAccountReference);
		FloatingPriceLeg.FloatingPriceLegBuilder setCalculationDates(AdjustableDates calculationDates);
		FloatingPriceLeg.FloatingPriceLegBuilder setCalculationPeriods(AdjustableDates calculationPeriods);
		FloatingPriceLeg.FloatingPriceLegBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule calculationPeriodsSchedule);
		FloatingPriceLeg.FloatingPriceLegBuilder setCalculationPeriodsReference(CalculationPeriodsReference calculationPeriodsReference);
		FloatingPriceLeg.FloatingPriceLegBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference calculationPeriodsScheduleReference);
		FloatingPriceLeg.FloatingPriceLegBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference calculationPeriodsDatesReference);
		FloatingPriceLeg.FloatingPriceLegBuilder setCommodity(Commodity commodity);
		FloatingPriceLeg.FloatingPriceLegBuilder setNotionalQuantitySchedule(CommodityNotionalQuantitySchedule notionalQuantitySchedule);
		FloatingPriceLeg.FloatingPriceLegBuilder setNotionalQuantity(CommodityNotionalQuantity notionalQuantity);
		FloatingPriceLeg.FloatingPriceLegBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity settlementPeriodsNotionalQuantity);
		FloatingPriceLeg.FloatingPriceLegBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity settlementPeriodsNotionalQuantity, int idx);
		FloatingPriceLeg.FloatingPriceLegBuilder addSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity);
		FloatingPriceLeg.FloatingPriceLegBuilder setSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity);
		FloatingPriceLeg.FloatingPriceLegBuilder setTotalNotionalQuantity(BigDecimal totalNotionalQuantity);
		FloatingPriceLeg.FloatingPriceLegBuilder setQuantityReference(QuantityReference quantityReference);
		FloatingPriceLeg.FloatingPriceLegBuilder setCalculation(FloatingLegCalculation calculation);
		FloatingPriceLeg.FloatingPriceLegBuilder setRelativePaymentDates(CommodityRelativePaymentDates relativePaymentDates);
		FloatingPriceLeg.FloatingPriceLegBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset paymentDates);
		FloatingPriceLeg.FloatingPriceLegBuilder setMasterAgreementPaymentDates(Boolean masterAgreementPaymentDates);
		FloatingPriceLeg.FloatingPriceLegBuilder setFlatRate(FlatRateEnum flatRate);
		FloatingPriceLeg.FloatingPriceLegBuilder setFlatRateAmount(NonNegativeMoney flatRateAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
			processRosetta(path.newSubPath("receiverPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getReceiverPartyReference());
			processRosetta(path.newSubPath("receiverAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getReceiverAccountReference());
			processRosetta(path.newSubPath("calculationDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getCalculationDates());
			processRosetta(path.newSubPath("calculationPeriods"), processor, AdjustableDates.AdjustableDatesBuilder.class, getCalculationPeriods());
			processRosetta(path.newSubPath("calculationPeriodsSchedule"), processor, CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder.class, getCalculationPeriodsSchedule());
			processRosetta(path.newSubPath("calculationPeriodsReference"), processor, CalculationPeriodsReference.CalculationPeriodsReferenceBuilder.class, getCalculationPeriodsReference());
			processRosetta(path.newSubPath("calculationPeriodsScheduleReference"), processor, CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder.class, getCalculationPeriodsScheduleReference());
			processRosetta(path.newSubPath("calculationPeriodsDatesReference"), processor, CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder.class, getCalculationPeriodsDatesReference());
			processRosetta(path.newSubPath("commodity"), processor, Commodity.CommodityBuilder.class, getCommodity());
			processRosetta(path.newSubPath("notionalQuantitySchedule"), processor, CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder.class, getNotionalQuantitySchedule());
			processRosetta(path.newSubPath("notionalQuantity"), processor, CommodityNotionalQuantity.CommodityNotionalQuantityBuilder.class, getNotionalQuantity());
			processRosetta(path.newSubPath("settlementPeriodsNotionalQuantity"), processor, CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder.class, getSettlementPeriodsNotionalQuantity());
			processor.processBasic(path.newSubPath("totalNotionalQuantity"), BigDecimal.class, getTotalNotionalQuantity(), this);
			processRosetta(path.newSubPath("quantityReference"), processor, QuantityReference.QuantityReferenceBuilder.class, getQuantityReference());
			processRosetta(path.newSubPath("calculation"), processor, FloatingLegCalculation.FloatingLegCalculationBuilder.class, getCalculation());
			processRosetta(path.newSubPath("relativePaymentDates"), processor, CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder.class, getRelativePaymentDates());
			processRosetta(path.newSubPath("paymentDates"), processor, AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder.class, getPaymentDates());
			processor.processBasic(path.newSubPath("masterAgreementPaymentDates"), Boolean.class, getMasterAgreementPaymentDates(), this);
			processor.processBasic(path.newSubPath("flatRate"), FlatRateEnum.class, getFlatRate(), this);
			processRosetta(path.newSubPath("flatRateAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getFlatRateAmount());
		}
		

		FloatingPriceLeg.FloatingPriceLegBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingPriceLeg  ***********************/
	class FloatingPriceLegImpl extends FinancialSwapLeg.FinancialSwapLegImpl implements FloatingPriceLeg {
		private final AdjustableDates calculationDates;
		private final AdjustableDates calculationPeriods;
		private final CommodityCalculationPeriodsSchedule calculationPeriodsSchedule;
		private final CalculationPeriodsReference calculationPeriodsReference;
		private final CalculationPeriodsScheduleReference calculationPeriodsScheduleReference;
		private final CalculationPeriodsDatesReference calculationPeriodsDatesReference;
		private final Commodity commodity;
		private final CommodityNotionalQuantitySchedule notionalQuantitySchedule;
		private final CommodityNotionalQuantity notionalQuantity;
		private final List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantity;
		private final BigDecimal totalNotionalQuantity;
		private final QuantityReference quantityReference;
		private final FloatingLegCalculation calculation;
		private final CommodityRelativePaymentDates relativePaymentDates;
		private final AdjustableDatesOrRelativeDateOffset paymentDates;
		private final Boolean masterAgreementPaymentDates;
		private final FlatRateEnum flatRate;
		private final NonNegativeMoney flatRateAmount;
		
		protected FloatingPriceLegImpl(FloatingPriceLeg.FloatingPriceLegBuilder builder) {
			super(builder);
			this.calculationDates = ofNullable(builder.getCalculationDates()).map(f->f.build()).orElse(null);
			this.calculationPeriods = ofNullable(builder.getCalculationPeriods()).map(f->f.build()).orElse(null);
			this.calculationPeriodsSchedule = ofNullable(builder.getCalculationPeriodsSchedule()).map(f->f.build()).orElse(null);
			this.calculationPeriodsReference = ofNullable(builder.getCalculationPeriodsReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsScheduleReference = ofNullable(builder.getCalculationPeriodsScheduleReference()).map(f->f.build()).orElse(null);
			this.calculationPeriodsDatesReference = ofNullable(builder.getCalculationPeriodsDatesReference()).map(f->f.build()).orElse(null);
			this.commodity = ofNullable(builder.getCommodity()).map(f->f.build()).orElse(null);
			this.notionalQuantitySchedule = ofNullable(builder.getNotionalQuantitySchedule()).map(f->f.build()).orElse(null);
			this.notionalQuantity = ofNullable(builder.getNotionalQuantity()).map(f->f.build()).orElse(null);
			this.settlementPeriodsNotionalQuantity = ofNullable(builder.getSettlementPeriodsNotionalQuantity()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.totalNotionalQuantity = builder.getTotalNotionalQuantity();
			this.quantityReference = ofNullable(builder.getQuantityReference()).map(f->f.build()).orElse(null);
			this.calculation = ofNullable(builder.getCalculation()).map(f->f.build()).orElse(null);
			this.relativePaymentDates = ofNullable(builder.getRelativePaymentDates()).map(f->f.build()).orElse(null);
			this.paymentDates = ofNullable(builder.getPaymentDates()).map(f->f.build()).orElse(null);
			this.masterAgreementPaymentDates = builder.getMasterAgreementPaymentDates();
			this.flatRate = builder.getFlatRate();
			this.flatRateAmount = ofNullable(builder.getFlatRateAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDates")
		public AdjustableDates getCalculationDates() {
			return calculationDates;
		}
		
		@Override
		@RosettaAttribute("calculationPeriods")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriods")
		public AdjustableDates getCalculationPeriods() {
			return calculationPeriods;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsSchedule")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsSchedule")
		public CommodityCalculationPeriodsSchedule getCalculationPeriodsSchedule() {
			return calculationPeriodsSchedule;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsReference")
		public CalculationPeriodsReference getCalculationPeriodsReference() {
			return calculationPeriodsReference;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference getCalculationPeriodsScheduleReference() {
			return calculationPeriodsScheduleReference;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		public CalculationPeriodsDatesReference getCalculationPeriodsDatesReference() {
			return calculationPeriodsDatesReference;
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
		@RosettaAttribute("calculation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("calculation")
		public FloatingLegCalculation getCalculation() {
			return calculation;
		}
		
		@Override
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativePaymentDates")
		public CommodityRelativePaymentDates getRelativePaymentDates() {
			return relativePaymentDates;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDates")
		public AdjustableDatesOrRelativeDateOffset getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		public Boolean getMasterAgreementPaymentDates() {
			return masterAgreementPaymentDates;
		}
		
		@Override
		@RosettaAttribute("flatRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("flatRate")
		public FlatRateEnum getFlatRate() {
			return flatRate;
		}
		
		@Override
		@RosettaAttribute("flatRateAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("flatRateAmount")
		public NonNegativeMoney getFlatRateAmount() {
			return flatRateAmount;
		}
		
		@Override
		public FloatingPriceLeg build() {
			return this;
		}
		
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder toBuilder() {
			FloatingPriceLeg.FloatingPriceLegBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingPriceLeg.FloatingPriceLegBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCalculationDates()).ifPresent(builder::setCalculationDates);
			ofNullable(getCalculationPeriods()).ifPresent(builder::setCalculationPeriods);
			ofNullable(getCalculationPeriodsSchedule()).ifPresent(builder::setCalculationPeriodsSchedule);
			ofNullable(getCalculationPeriodsReference()).ifPresent(builder::setCalculationPeriodsReference);
			ofNullable(getCalculationPeriodsScheduleReference()).ifPresent(builder::setCalculationPeriodsScheduleReference);
			ofNullable(getCalculationPeriodsDatesReference()).ifPresent(builder::setCalculationPeriodsDatesReference);
			ofNullable(getCommodity()).ifPresent(builder::setCommodity);
			ofNullable(getNotionalQuantitySchedule()).ifPresent(builder::setNotionalQuantitySchedule);
			ofNullable(getNotionalQuantity()).ifPresent(builder::setNotionalQuantity);
			ofNullable(getSettlementPeriodsNotionalQuantity()).ifPresent(builder::setSettlementPeriodsNotionalQuantity);
			ofNullable(getTotalNotionalQuantity()).ifPresent(builder::setTotalNotionalQuantity);
			ofNullable(getQuantityReference()).ifPresent(builder::setQuantityReference);
			ofNullable(getCalculation()).ifPresent(builder::setCalculation);
			ofNullable(getRelativePaymentDates()).ifPresent(builder::setRelativePaymentDates);
			ofNullable(getPaymentDates()).ifPresent(builder::setPaymentDates);
			ofNullable(getMasterAgreementPaymentDates()).ifPresent(builder::setMasterAgreementPaymentDates);
			ofNullable(getFlatRate()).ifPresent(builder::setFlatRate);
			ofNullable(getFlatRateAmount()).ifPresent(builder::setFlatRateAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingPriceLeg _that = getType().cast(o);
		
			if (!Objects.equals(calculationDates, _that.getCalculationDates())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(notionalQuantitySchedule, _that.getNotionalQuantitySchedule())) return false;
			if (!Objects.equals(notionalQuantity, _that.getNotionalQuantity())) return false;
			if (!ListEquals.listEquals(settlementPeriodsNotionalQuantity, _that.getSettlementPeriodsNotionalQuantity())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(relativePaymentDates, _that.getRelativePaymentDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(masterAgreementPaymentDates, _that.getMasterAgreementPaymentDates())) return false;
			if (!Objects.equals(flatRate, _that.getFlatRate())) return false;
			if (!Objects.equals(flatRateAmount, _that.getFlatRateAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (calculationDates != null ? calculationDates.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (notionalQuantitySchedule != null ? notionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (notionalQuantity != null ? notionalQuantity.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsNotionalQuantity != null ? settlementPeriodsNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (relativePaymentDates != null ? relativePaymentDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (masterAgreementPaymentDates != null ? masterAgreementPaymentDates.hashCode() : 0);
			_result = 31 * _result + (flatRate != null ? flatRate.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (flatRateAmount != null ? flatRateAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingPriceLeg {" +
				"calculationDates=" + this.calculationDates + ", " +
				"calculationPeriods=" + this.calculationPeriods + ", " +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference + ", " +
				"commodity=" + this.commodity + ", " +
				"notionalQuantitySchedule=" + this.notionalQuantitySchedule + ", " +
				"notionalQuantity=" + this.notionalQuantity + ", " +
				"settlementPeriodsNotionalQuantity=" + this.settlementPeriodsNotionalQuantity + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity + ", " +
				"quantityReference=" + this.quantityReference + ", " +
				"calculation=" + this.calculation + ", " +
				"relativePaymentDates=" + this.relativePaymentDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"masterAgreementPaymentDates=" + this.masterAgreementPaymentDates + ", " +
				"flatRate=" + this.flatRate + ", " +
				"flatRateAmount=" + this.flatRateAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FloatingPriceLeg  ***********************/
	class FloatingPriceLegBuilderImpl extends FinancialSwapLeg.FinancialSwapLegBuilderImpl implements FloatingPriceLeg.FloatingPriceLegBuilder {
	
		protected AdjustableDates.AdjustableDatesBuilder calculationDates;
		protected AdjustableDates.AdjustableDatesBuilder calculationPeriods;
		protected CommodityCalculationPeriodsSchedule.CommodityCalculationPeriodsScheduleBuilder calculationPeriodsSchedule;
		protected CalculationPeriodsReference.CalculationPeriodsReferenceBuilder calculationPeriodsReference;
		protected CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder calculationPeriodsScheduleReference;
		protected CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder calculationPeriodsDatesReference;
		protected Commodity.CommodityBuilder commodity;
		protected CommodityNotionalQuantitySchedule.CommodityNotionalQuantityScheduleBuilder notionalQuantitySchedule;
		protected CommodityNotionalQuantity.CommodityNotionalQuantityBuilder notionalQuantity;
		protected List<CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder> settlementPeriodsNotionalQuantity = new ArrayList<>();
		protected BigDecimal totalNotionalQuantity;
		protected QuantityReference.QuantityReferenceBuilder quantityReference;
		protected FloatingLegCalculation.FloatingLegCalculationBuilder calculation;
		protected CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder relativePaymentDates;
		protected AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder paymentDates;
		protected Boolean masterAgreementPaymentDates;
		protected FlatRateEnum flatRate;
		protected NonNegativeMoney.NonNegativeMoneyBuilder flatRateAmount;
		
		@Override
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationDates")
		public AdjustableDates.AdjustableDatesBuilder getCalculationDates() {
			return calculationDates;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateCalculationDates() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (calculationDates!=null) {
				result = calculationDates;
			}
			else {
				result = calculationDates = AdjustableDates.builder();
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
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsReference")
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getCalculationPeriodsReference() {
			return calculationPeriodsReference;
		}
		
		@Override
		public CalculationPeriodsReference.CalculationPeriodsReferenceBuilder getOrCreateCalculationPeriodsReference() {
			CalculationPeriodsReference.CalculationPeriodsReferenceBuilder result;
			if (calculationPeriodsReference!=null) {
				result = calculationPeriodsReference;
			}
			else {
				result = calculationPeriodsReference = CalculationPeriodsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getCalculationPeriodsScheduleReference() {
			return calculationPeriodsScheduleReference;
		}
		
		@Override
		public CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder getOrCreateCalculationPeriodsScheduleReference() {
			CalculationPeriodsScheduleReference.CalculationPeriodsScheduleReferenceBuilder result;
			if (calculationPeriodsScheduleReference!=null) {
				result = calculationPeriodsScheduleReference;
			}
			else {
				result = calculationPeriodsScheduleReference = CalculationPeriodsScheduleReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getCalculationPeriodsDatesReference() {
			return calculationPeriodsDatesReference;
		}
		
		@Override
		public CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder getOrCreateCalculationPeriodsDatesReference() {
			CalculationPeriodsDatesReference.CalculationPeriodsDatesReferenceBuilder result;
			if (calculationPeriodsDatesReference!=null) {
				result = calculationPeriodsDatesReference;
			}
			else {
				result = calculationPeriodsDatesReference = CalculationPeriodsDatesReference.builder();
			}
			
			return result;
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
		@RosettaAttribute("calculation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("calculation")
		public FloatingLegCalculation.FloatingLegCalculationBuilder getCalculation() {
			return calculation;
		}
		
		@Override
		public FloatingLegCalculation.FloatingLegCalculationBuilder getOrCreateCalculation() {
			FloatingLegCalculation.FloatingLegCalculationBuilder result;
			if (calculation!=null) {
				result = calculation;
			}
			else {
				result = calculation = FloatingLegCalculation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("relativePaymentDates")
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getRelativePaymentDates() {
			return relativePaymentDates;
		}
		
		@Override
		public CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder getOrCreateRelativePaymentDates() {
			CommodityRelativePaymentDates.CommodityRelativePaymentDatesBuilder result;
			if (relativePaymentDates!=null) {
				result = relativePaymentDates;
			}
			else {
				result = relativePaymentDates = CommodityRelativePaymentDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("paymentDates")
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getPaymentDates() {
			return paymentDates;
		}
		
		@Override
		public AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder getOrCreatePaymentDates() {
			AdjustableDatesOrRelativeDateOffset.AdjustableDatesOrRelativeDateOffsetBuilder result;
			if (paymentDates!=null) {
				result = paymentDates;
			}
			else {
				result = paymentDates = AdjustableDatesOrRelativeDateOffset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		public Boolean getMasterAgreementPaymentDates() {
			return masterAgreementPaymentDates;
		}
		
		@Override
		@RosettaAttribute("flatRate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("flatRate")
		public FlatRateEnum getFlatRate() {
			return flatRate;
		}
		
		@Override
		@RosettaAttribute("flatRateAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("flatRateAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getFlatRateAmount() {
			return flatRateAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateFlatRateAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (flatRateAmount!=null) {
				result = flatRateAmount;
			}
			else {
				result = flatRateAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("payerPartyReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("payerPartyReference")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setPayerPartyReference(PartyReference _payerPartyReference) {
			this.payerPartyReference = _payerPartyReference == null ? null : _payerPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("payerAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("payerAccountReference")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setPayerAccountReference(AccountReference _payerAccountReference) {
			this.payerAccountReference = _payerAccountReference == null ? null : _payerAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverPartyReference")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setReceiverPartyReference(PartyReference _receiverPartyReference) {
			this.receiverPartyReference = _receiverPartyReference == null ? null : _receiverPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("receiverAccountReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiverAccountReference")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setReceiverAccountReference(AccountReference _receiverAccountReference) {
			this.receiverAccountReference = _receiverAccountReference == null ? null : _receiverAccountReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationDates")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setCalculationDates(AdjustableDates _calculationDates) {
			this.calculationDates = _calculationDates == null ? null : _calculationDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriods")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriods")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setCalculationPeriods(AdjustableDates _calculationPeriods) {
			this.calculationPeriods = _calculationPeriods == null ? null : _calculationPeriods.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsSchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsSchedule")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setCalculationPeriodsSchedule(CommodityCalculationPeriodsSchedule _calculationPeriodsSchedule) {
			this.calculationPeriodsSchedule = _calculationPeriodsSchedule == null ? null : _calculationPeriodsSchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsReference")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setCalculationPeriodsReference(CalculationPeriodsReference _calculationPeriodsReference) {
			this.calculationPeriodsReference = _calculationPeriodsReference == null ? null : _calculationPeriodsReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsScheduleReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsScheduleReference")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setCalculationPeriodsScheduleReference(CalculationPeriodsScheduleReference _calculationPeriodsScheduleReference) {
			this.calculationPeriodsScheduleReference = _calculationPeriodsScheduleReference == null ? null : _calculationPeriodsScheduleReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculationPeriodsDatesReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationPeriodsDatesReference")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setCalculationPeriodsDatesReference(CalculationPeriodsDatesReference _calculationPeriodsDatesReference) {
			this.calculationPeriodsDatesReference = _calculationPeriodsDatesReference == null ? null : _calculationPeriodsDatesReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("commodity")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("commodity")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setCommodity(Commodity _commodity) {
			this.commodity = _commodity == null ? null : _commodity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalQuantitySchedule")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantitySchedule")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setNotionalQuantitySchedule(CommodityNotionalQuantitySchedule _notionalQuantitySchedule) {
			this.notionalQuantitySchedule = _notionalQuantitySchedule == null ? null : _notionalQuantitySchedule.toBuilder();
			return this;
		}
		
		@RosettaAttribute("notionalQuantity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notionalQuantity")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setNotionalQuantity(CommodityNotionalQuantity _notionalQuantity) {
			this.notionalQuantity = _notionalQuantity == null ? null : _notionalQuantity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("settlementPeriodsNotionalQuantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("settlementPeriodsNotionalQuantity")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity _settlementPeriodsNotionalQuantity) {
			if (_settlementPeriodsNotionalQuantity != null) {
				this.settlementPeriodsNotionalQuantity.add(_settlementPeriodsNotionalQuantity.toBuilder());
			}
			return this;
		}
		
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder addSettlementPeriodsNotionalQuantity(CommoditySettlementPeriodsNotionalQuantity _settlementPeriodsNotionalQuantity, int idx) {
			getIndex(this.settlementPeriodsNotionalQuantity, idx, () -> _settlementPeriodsNotionalQuantity.toBuilder());
			return this;
		}
		
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder addSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantitys) {
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
		public FloatingPriceLeg.FloatingPriceLegBuilder setSettlementPeriodsNotionalQuantity(List<? extends CommoditySettlementPeriodsNotionalQuantity> settlementPeriodsNotionalQuantitys) {
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
		public FloatingPriceLeg.FloatingPriceLegBuilder setTotalNotionalQuantity(BigDecimal _totalNotionalQuantity) {
			this.totalNotionalQuantity = _totalNotionalQuantity == null ? null : _totalNotionalQuantity;
			return this;
		}
		
		@RosettaAttribute("quantityReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("quantityReference")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setQuantityReference(QuantityReference _quantityReference) {
			this.quantityReference = _quantityReference == null ? null : _quantityReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("calculation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("calculation")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setCalculation(FloatingLegCalculation _calculation) {
			this.calculation = _calculation == null ? null : _calculation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("relativePaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("relativePaymentDates")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setRelativePaymentDates(CommodityRelativePaymentDates _relativePaymentDates) {
			this.relativePaymentDates = _relativePaymentDates == null ? null : _relativePaymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("paymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("paymentDates")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setPaymentDates(AdjustableDatesOrRelativeDateOffset _paymentDates) {
			this.paymentDates = _paymentDates == null ? null : _paymentDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("masterAgreementPaymentDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("masterAgreementPaymentDates")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setMasterAgreementPaymentDates(Boolean _masterAgreementPaymentDates) {
			this.masterAgreementPaymentDates = _masterAgreementPaymentDates == null ? null : _masterAgreementPaymentDates;
			return this;
		}
		
		@RosettaAttribute("flatRate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("flatRate")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setFlatRate(FlatRateEnum _flatRate) {
			this.flatRate = _flatRate == null ? null : _flatRate;
			return this;
		}
		
		@RosettaAttribute("flatRateAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("flatRateAmount")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder setFlatRateAmount(NonNegativeMoney _flatRateAmount) {
			this.flatRateAmount = _flatRateAmount == null ? null : _flatRateAmount.toBuilder();
			return this;
		}
		
		@Override
		public FloatingPriceLeg build() {
			return new FloatingPriceLeg.FloatingPriceLegImpl(this);
		}
		
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder prune() {
			super.prune();
			if (calculationDates!=null && !calculationDates.prune().hasData()) calculationDates = null;
			if (calculationPeriods!=null && !calculationPeriods.prune().hasData()) calculationPeriods = null;
			if (calculationPeriodsSchedule!=null && !calculationPeriodsSchedule.prune().hasData()) calculationPeriodsSchedule = null;
			if (calculationPeriodsReference!=null && !calculationPeriodsReference.prune().hasData()) calculationPeriodsReference = null;
			if (calculationPeriodsScheduleReference!=null && !calculationPeriodsScheduleReference.prune().hasData()) calculationPeriodsScheduleReference = null;
			if (calculationPeriodsDatesReference!=null && !calculationPeriodsDatesReference.prune().hasData()) calculationPeriodsDatesReference = null;
			if (commodity!=null && !commodity.prune().hasData()) commodity = null;
			if (notionalQuantitySchedule!=null && !notionalQuantitySchedule.prune().hasData()) notionalQuantitySchedule = null;
			if (notionalQuantity!=null && !notionalQuantity.prune().hasData()) notionalQuantity = null;
			settlementPeriodsNotionalQuantity = settlementPeriodsNotionalQuantity.stream().filter(b->b!=null).<CommoditySettlementPeriodsNotionalQuantity.CommoditySettlementPeriodsNotionalQuantityBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (quantityReference!=null && !quantityReference.prune().hasData()) quantityReference = null;
			if (calculation!=null && !calculation.prune().hasData()) calculation = null;
			if (relativePaymentDates!=null && !relativePaymentDates.prune().hasData()) relativePaymentDates = null;
			if (paymentDates!=null && !paymentDates.prune().hasData()) paymentDates = null;
			if (flatRateAmount!=null && !flatRateAmount.prune().hasData()) flatRateAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCalculationDates()!=null && getCalculationDates().hasData()) return true;
			if (getCalculationPeriods()!=null && getCalculationPeriods().hasData()) return true;
			if (getCalculationPeriodsSchedule()!=null && getCalculationPeriodsSchedule().hasData()) return true;
			if (getCalculationPeriodsReference()!=null && getCalculationPeriodsReference().hasData()) return true;
			if (getCalculationPeriodsScheduleReference()!=null && getCalculationPeriodsScheduleReference().hasData()) return true;
			if (getCalculationPeriodsDatesReference()!=null && getCalculationPeriodsDatesReference().hasData()) return true;
			if (getCommodity()!=null && getCommodity().hasData()) return true;
			if (getNotionalQuantitySchedule()!=null && getNotionalQuantitySchedule().hasData()) return true;
			if (getNotionalQuantity()!=null && getNotionalQuantity().hasData()) return true;
			if (getSettlementPeriodsNotionalQuantity()!=null && getSettlementPeriodsNotionalQuantity().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTotalNotionalQuantity()!=null) return true;
			if (getQuantityReference()!=null && getQuantityReference().hasData()) return true;
			if (getCalculation()!=null && getCalculation().hasData()) return true;
			if (getRelativePaymentDates()!=null && getRelativePaymentDates().hasData()) return true;
			if (getPaymentDates()!=null && getPaymentDates().hasData()) return true;
			if (getMasterAgreementPaymentDates()!=null) return true;
			if (getFlatRate()!=null) return true;
			if (getFlatRateAmount()!=null && getFlatRateAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingPriceLeg.FloatingPriceLegBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			FloatingPriceLeg.FloatingPriceLegBuilder o = (FloatingPriceLeg.FloatingPriceLegBuilder) other;
			
			merger.mergeRosetta(getCalculationDates(), o.getCalculationDates(), this::setCalculationDates);
			merger.mergeRosetta(getCalculationPeriods(), o.getCalculationPeriods(), this::setCalculationPeriods);
			merger.mergeRosetta(getCalculationPeriodsSchedule(), o.getCalculationPeriodsSchedule(), this::setCalculationPeriodsSchedule);
			merger.mergeRosetta(getCalculationPeriodsReference(), o.getCalculationPeriodsReference(), this::setCalculationPeriodsReference);
			merger.mergeRosetta(getCalculationPeriodsScheduleReference(), o.getCalculationPeriodsScheduleReference(), this::setCalculationPeriodsScheduleReference);
			merger.mergeRosetta(getCalculationPeriodsDatesReference(), o.getCalculationPeriodsDatesReference(), this::setCalculationPeriodsDatesReference);
			merger.mergeRosetta(getCommodity(), o.getCommodity(), this::setCommodity);
			merger.mergeRosetta(getNotionalQuantitySchedule(), o.getNotionalQuantitySchedule(), this::setNotionalQuantitySchedule);
			merger.mergeRosetta(getNotionalQuantity(), o.getNotionalQuantity(), this::setNotionalQuantity);
			merger.mergeRosetta(getSettlementPeriodsNotionalQuantity(), o.getSettlementPeriodsNotionalQuantity(), this::getOrCreateSettlementPeriodsNotionalQuantity);
			merger.mergeRosetta(getQuantityReference(), o.getQuantityReference(), this::setQuantityReference);
			merger.mergeRosetta(getCalculation(), o.getCalculation(), this::setCalculation);
			merger.mergeRosetta(getRelativePaymentDates(), o.getRelativePaymentDates(), this::setRelativePaymentDates);
			merger.mergeRosetta(getPaymentDates(), o.getPaymentDates(), this::setPaymentDates);
			merger.mergeRosetta(getFlatRateAmount(), o.getFlatRateAmount(), this::setFlatRateAmount);
			
			merger.mergeBasic(getTotalNotionalQuantity(), o.getTotalNotionalQuantity(), this::setTotalNotionalQuantity);
			merger.mergeBasic(getMasterAgreementPaymentDates(), o.getMasterAgreementPaymentDates(), this::setMasterAgreementPaymentDates);
			merger.mergeBasic(getFlatRate(), o.getFlatRate(), this::setFlatRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FloatingPriceLeg _that = getType().cast(o);
		
			if (!Objects.equals(calculationDates, _that.getCalculationDates())) return false;
			if (!Objects.equals(calculationPeriods, _that.getCalculationPeriods())) return false;
			if (!Objects.equals(calculationPeriodsSchedule, _that.getCalculationPeriodsSchedule())) return false;
			if (!Objects.equals(calculationPeriodsReference, _that.getCalculationPeriodsReference())) return false;
			if (!Objects.equals(calculationPeriodsScheduleReference, _that.getCalculationPeriodsScheduleReference())) return false;
			if (!Objects.equals(calculationPeriodsDatesReference, _that.getCalculationPeriodsDatesReference())) return false;
			if (!Objects.equals(commodity, _that.getCommodity())) return false;
			if (!Objects.equals(notionalQuantitySchedule, _that.getNotionalQuantitySchedule())) return false;
			if (!Objects.equals(notionalQuantity, _that.getNotionalQuantity())) return false;
			if (!ListEquals.listEquals(settlementPeriodsNotionalQuantity, _that.getSettlementPeriodsNotionalQuantity())) return false;
			if (!Objects.equals(totalNotionalQuantity, _that.getTotalNotionalQuantity())) return false;
			if (!Objects.equals(quantityReference, _that.getQuantityReference())) return false;
			if (!Objects.equals(calculation, _that.getCalculation())) return false;
			if (!Objects.equals(relativePaymentDates, _that.getRelativePaymentDates())) return false;
			if (!Objects.equals(paymentDates, _that.getPaymentDates())) return false;
			if (!Objects.equals(masterAgreementPaymentDates, _that.getMasterAgreementPaymentDates())) return false;
			if (!Objects.equals(flatRate, _that.getFlatRate())) return false;
			if (!Objects.equals(flatRateAmount, _that.getFlatRateAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (calculationDates != null ? calculationDates.hashCode() : 0);
			_result = 31 * _result + (calculationPeriods != null ? calculationPeriods.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsSchedule != null ? calculationPeriodsSchedule.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsReference != null ? calculationPeriodsReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsScheduleReference != null ? calculationPeriodsScheduleReference.hashCode() : 0);
			_result = 31 * _result + (calculationPeriodsDatesReference != null ? calculationPeriodsDatesReference.hashCode() : 0);
			_result = 31 * _result + (commodity != null ? commodity.hashCode() : 0);
			_result = 31 * _result + (notionalQuantitySchedule != null ? notionalQuantitySchedule.hashCode() : 0);
			_result = 31 * _result + (notionalQuantity != null ? notionalQuantity.hashCode() : 0);
			_result = 31 * _result + (settlementPeriodsNotionalQuantity != null ? settlementPeriodsNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (totalNotionalQuantity != null ? totalNotionalQuantity.hashCode() : 0);
			_result = 31 * _result + (quantityReference != null ? quantityReference.hashCode() : 0);
			_result = 31 * _result + (calculation != null ? calculation.hashCode() : 0);
			_result = 31 * _result + (relativePaymentDates != null ? relativePaymentDates.hashCode() : 0);
			_result = 31 * _result + (paymentDates != null ? paymentDates.hashCode() : 0);
			_result = 31 * _result + (masterAgreementPaymentDates != null ? masterAgreementPaymentDates.hashCode() : 0);
			_result = 31 * _result + (flatRate != null ? flatRate.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (flatRateAmount != null ? flatRateAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingPriceLegBuilder {" +
				"calculationDates=" + this.calculationDates + ", " +
				"calculationPeriods=" + this.calculationPeriods + ", " +
				"calculationPeriodsSchedule=" + this.calculationPeriodsSchedule + ", " +
				"calculationPeriodsReference=" + this.calculationPeriodsReference + ", " +
				"calculationPeriodsScheduleReference=" + this.calculationPeriodsScheduleReference + ", " +
				"calculationPeriodsDatesReference=" + this.calculationPeriodsDatesReference + ", " +
				"commodity=" + this.commodity + ", " +
				"notionalQuantitySchedule=" + this.notionalQuantitySchedule + ", " +
				"notionalQuantity=" + this.notionalQuantity + ", " +
				"settlementPeriodsNotionalQuantity=" + this.settlementPeriodsNotionalQuantity + ", " +
				"totalNotionalQuantity=" + this.totalNotionalQuantity + ", " +
				"quantityReference=" + this.quantityReference + ", " +
				"calculation=" + this.calculation + ", " +
				"relativePaymentDates=" + this.relativePaymentDates + ", " +
				"paymentDates=" + this.paymentDates + ", " +
				"masterAgreementPaymentDates=" + this.masterAgreementPaymentDates + ", " +
				"flatRate=" + this.flatRate + ", " +
				"flatRateAmount=" + this.flatRateAmount +
			'}' + " " + super.toString();
		}
	}
}
