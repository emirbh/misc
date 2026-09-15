package iso20022.dtcc.rds.harmonized;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import com.rosetta.util.ListEquals;
import iso20022.dtcc.rds.harmonized.meta.HarmonizedRepeatableDataMeta;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="HarmonizedRepeatableData", builder=HarmonizedRepeatableData.HarmonizedRepeatableDataBuilderImpl.class, version="${project.version}")
@RuneDataType(value="HarmonizedRepeatableData", model="iso20022", builder=HarmonizedRepeatableData.HarmonizedRepeatableDataBuilderImpl.class, version="${project.version}")
public interface HarmonizedRepeatableData extends RosettaModelObject {

	HarmonizedRepeatableDataMeta metaData = new HarmonizedRepeatableDataMeta();

	/*********************** Getter Methods  ***********************/
	List<String> getTradeParty1ReportingDestination();
	List<String> getTradeParty2ReportingDestination();
	List<String> getTradeParty1ThirdPartyViewerId();
	List<String> getTradeParty2ThirdPartyViewerId();
	List<String> getTradeParty1ThirdPartyViewerIdType();
	List<String> getTradeParty2ThirdPartyViewerIdType();
	List<String> getLeg1QuantityUnit();
	List<String> getLeg1QuantityFrequency();
	List<BigDecimal> getLeg1Quantity();
	List<String> getDeliveryPoint();
	List<LocalTime> getLoadDeliveryIntervals();
	List<ZonedDateTime> getDeliveryEndDateAndTime();
	List<String> getDuration();
	List<String> getDeliveryCapacity();
	List<BigDecimal> getPriceTimeIntervalQuantities();
	List<ZonedDateTime> getDeliveryStartDateAndTime();
	List<String> getQuantityUnit();
	List<BigDecimal> getElectricityPhysicalLegDeliveryStepQuantity();
	List<String> getElectricityPhysicalLegDeliveryStepQuantityFrequency();
	List<String> getElectricityPhysicalLegDeliveryStepQuantityUnit();
	List<String> getProductGrade();
	List<BigDecimal> getBasketWeightPercentage();
	List<String> getReferenceObligationType();
	List<String> getUnderlyingAssetPlaceOfIncorporation();
	List<String> getUnderlyingAssetPlaceOfIssuance();
	List<String> getReferenceEntityId();
	List<String> getReferenceEntityIdType();
	List<BigDecimal> getUnderlyingAssetFixedRate();
	List<String> getUnderlyingAssetNotionalCurrency();
	List<Date> getPeriodStartDate();
	List<Date> getPeriodEndDate();
	List<BigDecimal> getPeriodFixedStrike();
	List<BigDecimal> getPeriodFixedAmount();
	List<BigDecimal> getUnderlyingAssetNotionalAmount();
	List<Date> getDividendPaymentDate();
	List<Date> getFixedAmountPaymentDate();
	List<Date> getLeg1PaymentDates();
	List<Date> getLeg2PaymentDates();
	List<BigDecimal> getUnderlyingAssetInitialPrice();
	List<Date> getCancelationOptionExerciseDates();
	List<Date> getCancelationOptionRelevantUnderlyingDates();
	List<Date> getCapRateStepDate();
	List<BigDecimal> getCapRateStepValues();
	List<Date> getExerciseDates();
	List<Date> getFloorRateStepDate();
	List<BigDecimal> getFloorRateStepValue();
	List<Date> getLeg1FixedRateStepDate();
	List<BigDecimal> getLeg1FixedRateStepValues();
	List<Date> getLeg1FloatingRateMultiplierStepDate();
	List<BigDecimal> getLeg1FloatingRateMultiplierStepValues();
	List<Date> getLeg1FloatingRateSpreadStepDate();
	List<BigDecimal> getLeg1FloatingRateSpreadStepValues();
	List<Date> getLeg1NotionalStepDate();
	List<BigDecimal> getLeg1NotionalStepValues();
	List<Date> getLeg2FixedRateStepDate();
	List<BigDecimal> getLeg2FixedRateStepValues();
	List<Date> getLeg2FloatingRateMultiplierStepDate();
	List<BigDecimal> getLeg2FloatingRateMultiplierStepValues();
	List<Date> getLeg2FloatingRateSpreadStepDate();
	List<BigDecimal> getLeg2FloatingRateSpreadStepValues();
	List<Date> getLeg2NotionalStepDate();
	List<BigDecimal> getLeg2NotionalStepValues();
	List<Date> getOptionalEarlyTerminationDates();
	List<Date> getOptionalEarlyTerminationExerciseDates();
	List<Date> getOptionalEarlyTerminationUnderlyingDates();
	List<Date> getRelevantUnderlyingDatesUnadjustedDates();
	List<Date> getOptionalEarlyTerminationExerciseAdjustedDates();
	List<String> getUnderlyingAssetId();
	List<String> getUnderlyingAssetIdType();
	List<String> getUnderlyingAssetName();
	List<String> getMandatoryClearingJurisdiction();
	List<String> getClearingSwapUsiId();
	List<String> getClearingSwapUsiIdPrefix();
	List<String> getTradeParty1LocalCounterpartyJurisdiction();
	List<String> getTradeParty2LocalCounterpartyJurisdiction();
	List<String> getClearingExceptionTypeParty2();
	List<String> getCdeOtherPaymentPayer();
	List<String> getCdeOtherPaymentReceiver();
	List<String> getCdeOtherPaymentType();
	List<BigDecimal> getCdeOtherPaymentAmount();
	List<String> getCdeOtherPaymentCurrency();
	List<Date> getCdeOtherPaymentDate();
	List<String> getOtherPaymentPayerIdType();
	List<String> getOtherPaymentReceiverIdType();
	List<Date> getCdeEffectiveDateOfNotionalQuantityOfLeg1();
	List<Date> getCdeEffectiveDateOfNotionalQuantityOfLeg2();
	List<Date> getCdeEndDateOfNotionalQuantityOfLeg1();
	List<Date> getCdeEndDateOfNotionalQuantityOfLeg2();
	List<BigDecimal> getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1();
	List<BigDecimal> getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2();
	List<String> getCdeBasketConstituentsIdentifier();
	List<String> getCdeBasketConstituentsIdentifierSource();
	List<BigDecimal> getCdeBasketConstituentsNumberOfUnits();
	List<String> getCdeBasketConstituentsUnitOfMeasure();

	/*********************** Build Methods  ***********************/
	HarmonizedRepeatableData build();
	
	HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder toBuilder();
	
	static HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder builder() {
		return new HarmonizedRepeatableData.HarmonizedRepeatableDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends HarmonizedRepeatableData> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends HarmonizedRepeatableData> getType() {
		return HarmonizedRepeatableData.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("tradeParty1ReportingDestination"), String.class, getTradeParty1ReportingDestination(), this);
		processor.processBasic(path.newSubPath("tradeParty2ReportingDestination"), String.class, getTradeParty2ReportingDestination(), this);
		processor.processBasic(path.newSubPath("tradeParty1ThirdPartyViewerId"), String.class, getTradeParty1ThirdPartyViewerId(), this);
		processor.processBasic(path.newSubPath("tradeParty2ThirdPartyViewerId"), String.class, getTradeParty2ThirdPartyViewerId(), this);
		processor.processBasic(path.newSubPath("tradeParty1ThirdPartyViewerIdType"), String.class, getTradeParty1ThirdPartyViewerIdType(), this);
		processor.processBasic(path.newSubPath("tradeParty2ThirdPartyViewerIdType"), String.class, getTradeParty2ThirdPartyViewerIdType(), this);
		processor.processBasic(path.newSubPath("leg1QuantityUnit"), String.class, getLeg1QuantityUnit(), this);
		processor.processBasic(path.newSubPath("leg1QuantityFrequency"), String.class, getLeg1QuantityFrequency(), this);
		processor.processBasic(path.newSubPath("leg1Quantity"), BigDecimal.class, getLeg1Quantity(), this);
		processor.processBasic(path.newSubPath("deliveryPoint"), String.class, getDeliveryPoint(), this);
		processor.processBasic(path.newSubPath("loadDeliveryIntervals"), LocalTime.class, getLoadDeliveryIntervals(), this);
		processor.processBasic(path.newSubPath("deliveryEndDateAndTime"), ZonedDateTime.class, getDeliveryEndDateAndTime(), this);
		processor.processBasic(path.newSubPath("duration"), String.class, getDuration(), this);
		processor.processBasic(path.newSubPath("deliveryCapacity"), String.class, getDeliveryCapacity(), this);
		processor.processBasic(path.newSubPath("priceTimeIntervalQuantities"), BigDecimal.class, getPriceTimeIntervalQuantities(), this);
		processor.processBasic(path.newSubPath("deliveryStartDateAndTime"), ZonedDateTime.class, getDeliveryStartDateAndTime(), this);
		processor.processBasic(path.newSubPath("quantityUnit"), String.class, getQuantityUnit(), this);
		processor.processBasic(path.newSubPath("electricityPhysicalLegDeliveryStepQuantity"), BigDecimal.class, getElectricityPhysicalLegDeliveryStepQuantity(), this);
		processor.processBasic(path.newSubPath("electricityPhysicalLegDeliveryStepQuantityFrequency"), String.class, getElectricityPhysicalLegDeliveryStepQuantityFrequency(), this);
		processor.processBasic(path.newSubPath("electricityPhysicalLegDeliveryStepQuantityUnit"), String.class, getElectricityPhysicalLegDeliveryStepQuantityUnit(), this);
		processor.processBasic(path.newSubPath("productGrade"), String.class, getProductGrade(), this);
		processor.processBasic(path.newSubPath("basketWeightPercentage"), BigDecimal.class, getBasketWeightPercentage(), this);
		processor.processBasic(path.newSubPath("referenceObligationType"), String.class, getReferenceObligationType(), this);
		processor.processBasic(path.newSubPath("underlyingAssetPlaceOfIncorporation"), String.class, getUnderlyingAssetPlaceOfIncorporation(), this);
		processor.processBasic(path.newSubPath("underlyingAssetPlaceOfIssuance"), String.class, getUnderlyingAssetPlaceOfIssuance(), this);
		processor.processBasic(path.newSubPath("referenceEntityId"), String.class, getReferenceEntityId(), this);
		processor.processBasic(path.newSubPath("referenceEntityIdType"), String.class, getReferenceEntityIdType(), this);
		processor.processBasic(path.newSubPath("underlyingAssetFixedRate"), BigDecimal.class, getUnderlyingAssetFixedRate(), this);
		processor.processBasic(path.newSubPath("underlyingAssetNotionalCurrency"), String.class, getUnderlyingAssetNotionalCurrency(), this);
		processor.processBasic(path.newSubPath("periodStartDate"), Date.class, getPeriodStartDate(), this);
		processor.processBasic(path.newSubPath("periodEndDate"), Date.class, getPeriodEndDate(), this);
		processor.processBasic(path.newSubPath("periodFixedStrike"), BigDecimal.class, getPeriodFixedStrike(), this);
		processor.processBasic(path.newSubPath("periodFixedAmount"), BigDecimal.class, getPeriodFixedAmount(), this);
		processor.processBasic(path.newSubPath("underlyingAssetNotionalAmount"), BigDecimal.class, getUnderlyingAssetNotionalAmount(), this);
		processor.processBasic(path.newSubPath("dividendPaymentDate"), Date.class, getDividendPaymentDate(), this);
		processor.processBasic(path.newSubPath("fixedAmountPaymentDate"), Date.class, getFixedAmountPaymentDate(), this);
		processor.processBasic(path.newSubPath("leg1PaymentDates"), Date.class, getLeg1PaymentDates(), this);
		processor.processBasic(path.newSubPath("leg2PaymentDates"), Date.class, getLeg2PaymentDates(), this);
		processor.processBasic(path.newSubPath("underlyingAssetInitialPrice"), BigDecimal.class, getUnderlyingAssetInitialPrice(), this);
		processor.processBasic(path.newSubPath("cancelationOptionExerciseDates"), Date.class, getCancelationOptionExerciseDates(), this);
		processor.processBasic(path.newSubPath("cancelationOptionRelevantUnderlyingDates"), Date.class, getCancelationOptionRelevantUnderlyingDates(), this);
		processor.processBasic(path.newSubPath("capRateStepDate"), Date.class, getCapRateStepDate(), this);
		processor.processBasic(path.newSubPath("capRateStepValues"), BigDecimal.class, getCapRateStepValues(), this);
		processor.processBasic(path.newSubPath("exerciseDates"), Date.class, getExerciseDates(), this);
		processor.processBasic(path.newSubPath("floorRateStepDate"), Date.class, getFloorRateStepDate(), this);
		processor.processBasic(path.newSubPath("floorRateStepValue"), BigDecimal.class, getFloorRateStepValue(), this);
		processor.processBasic(path.newSubPath("leg1FixedRateStepDate"), Date.class, getLeg1FixedRateStepDate(), this);
		processor.processBasic(path.newSubPath("leg1FixedRateStepValues"), BigDecimal.class, getLeg1FixedRateStepValues(), this);
		processor.processBasic(path.newSubPath("leg1FloatingRateMultiplierStepDate"), Date.class, getLeg1FloatingRateMultiplierStepDate(), this);
		processor.processBasic(path.newSubPath("leg1FloatingRateMultiplierStepValues"), BigDecimal.class, getLeg1FloatingRateMultiplierStepValues(), this);
		processor.processBasic(path.newSubPath("leg1FloatingRateSpreadStepDate"), Date.class, getLeg1FloatingRateSpreadStepDate(), this);
		processor.processBasic(path.newSubPath("leg1FloatingRateSpreadStepValues"), BigDecimal.class, getLeg1FloatingRateSpreadStepValues(), this);
		processor.processBasic(path.newSubPath("leg1NotionalStepDate"), Date.class, getLeg1NotionalStepDate(), this);
		processor.processBasic(path.newSubPath("leg1NotionalStepValues"), BigDecimal.class, getLeg1NotionalStepValues(), this);
		processor.processBasic(path.newSubPath("leg2FixedRateStepDate"), Date.class, getLeg2FixedRateStepDate(), this);
		processor.processBasic(path.newSubPath("leg2FixedRateStepValues"), BigDecimal.class, getLeg2FixedRateStepValues(), this);
		processor.processBasic(path.newSubPath("leg2FloatingRateMultiplierStepDate"), Date.class, getLeg2FloatingRateMultiplierStepDate(), this);
		processor.processBasic(path.newSubPath("leg2FloatingRateMultiplierStepValues"), BigDecimal.class, getLeg2FloatingRateMultiplierStepValues(), this);
		processor.processBasic(path.newSubPath("leg2FloatingRateSpreadStepDate"), Date.class, getLeg2FloatingRateSpreadStepDate(), this);
		processor.processBasic(path.newSubPath("leg2FloatingRateSpreadStepValues"), BigDecimal.class, getLeg2FloatingRateSpreadStepValues(), this);
		processor.processBasic(path.newSubPath("leg2NotionalStepDate"), Date.class, getLeg2NotionalStepDate(), this);
		processor.processBasic(path.newSubPath("leg2NotionalStepValues"), BigDecimal.class, getLeg2NotionalStepValues(), this);
		processor.processBasic(path.newSubPath("optionalEarlyTerminationDates"), Date.class, getOptionalEarlyTerminationDates(), this);
		processor.processBasic(path.newSubPath("optionalEarlyTerminationExerciseDates"), Date.class, getOptionalEarlyTerminationExerciseDates(), this);
		processor.processBasic(path.newSubPath("optionalEarlyTerminationUnderlyingDates"), Date.class, getOptionalEarlyTerminationUnderlyingDates(), this);
		processor.processBasic(path.newSubPath("relevantUnderlyingDatesUnadjustedDates"), Date.class, getRelevantUnderlyingDatesUnadjustedDates(), this);
		processor.processBasic(path.newSubPath("optionalEarlyTerminationExerciseAdjustedDates"), Date.class, getOptionalEarlyTerminationExerciseAdjustedDates(), this);
		processor.processBasic(path.newSubPath("underlyingAssetId"), String.class, getUnderlyingAssetId(), this);
		processor.processBasic(path.newSubPath("underlyingAssetIdType"), String.class, getUnderlyingAssetIdType(), this);
		processor.processBasic(path.newSubPath("underlyingAssetName"), String.class, getUnderlyingAssetName(), this);
		processor.processBasic(path.newSubPath("mandatoryClearingJurisdiction"), String.class, getMandatoryClearingJurisdiction(), this);
		processor.processBasic(path.newSubPath("clearingSwapUsiId"), String.class, getClearingSwapUsiId(), this);
		processor.processBasic(path.newSubPath("clearingSwapUsiIdPrefix"), String.class, getClearingSwapUsiIdPrefix(), this);
		processor.processBasic(path.newSubPath("tradeParty1LocalCounterpartyJurisdiction"), String.class, getTradeParty1LocalCounterpartyJurisdiction(), this);
		processor.processBasic(path.newSubPath("tradeParty2LocalCounterpartyJurisdiction"), String.class, getTradeParty2LocalCounterpartyJurisdiction(), this);
		processor.processBasic(path.newSubPath("clearingExceptionTypeParty2"), String.class, getClearingExceptionTypeParty2(), this);
		processor.processBasic(path.newSubPath("cdeOtherPaymentPayer"), String.class, getCdeOtherPaymentPayer(), this);
		processor.processBasic(path.newSubPath("cdeOtherPaymentReceiver"), String.class, getCdeOtherPaymentReceiver(), this);
		processor.processBasic(path.newSubPath("cdeOtherPaymentType"), String.class, getCdeOtherPaymentType(), this);
		processor.processBasic(path.newSubPath("cdeOtherPaymentAmount"), BigDecimal.class, getCdeOtherPaymentAmount(), this);
		processor.processBasic(path.newSubPath("cdeOtherPaymentCurrency"), String.class, getCdeOtherPaymentCurrency(), this);
		processor.processBasic(path.newSubPath("cdeOtherPaymentDate"), Date.class, getCdeOtherPaymentDate(), this);
		processor.processBasic(path.newSubPath("otherPaymentPayerIdType"), String.class, getOtherPaymentPayerIdType(), this);
		processor.processBasic(path.newSubPath("otherPaymentReceiverIdType"), String.class, getOtherPaymentReceiverIdType(), this);
		processor.processBasic(path.newSubPath("cdeEffectiveDateOfNotionalQuantityOfLeg1"), Date.class, getCdeEffectiveDateOfNotionalQuantityOfLeg1(), this);
		processor.processBasic(path.newSubPath("cdeEffectiveDateOfNotionalQuantityOfLeg2"), Date.class, getCdeEffectiveDateOfNotionalQuantityOfLeg2(), this);
		processor.processBasic(path.newSubPath("cdeEndDateOfNotionalQuantityOfLeg1"), Date.class, getCdeEndDateOfNotionalQuantityOfLeg1(), this);
		processor.processBasic(path.newSubPath("cdeEndDateOfNotionalQuantityOfLeg2"), Date.class, getCdeEndDateOfNotionalQuantityOfLeg2(), this);
		processor.processBasic(path.newSubPath("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1"), BigDecimal.class, getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1(), this);
		processor.processBasic(path.newSubPath("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2"), BigDecimal.class, getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2(), this);
		processor.processBasic(path.newSubPath("cdeBasketConstituentsIdentifier"), String.class, getCdeBasketConstituentsIdentifier(), this);
		processor.processBasic(path.newSubPath("cdeBasketConstituentsIdentifierSource"), String.class, getCdeBasketConstituentsIdentifierSource(), this);
		processor.processBasic(path.newSubPath("cdeBasketConstituentsNumberOfUnits"), BigDecimal.class, getCdeBasketConstituentsNumberOfUnits(), this);
		processor.processBasic(path.newSubPath("cdeBasketConstituentsUnitOfMeasure"), String.class, getCdeBasketConstituentsUnitOfMeasure(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface HarmonizedRepeatableDataBuilder extends HarmonizedRepeatableData, RosettaModelObjectBuilder {
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ReportingDestination(String tradeParty1ReportingDestination);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ReportingDestination(String tradeParty1ReportingDestination, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ReportingDestination(List<String> tradeParty1ReportingDestination);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty1ReportingDestination(List<String> tradeParty1ReportingDestination);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ReportingDestination(String tradeParty2ReportingDestination);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ReportingDestination(String tradeParty2ReportingDestination, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ReportingDestination(List<String> tradeParty2ReportingDestination);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty2ReportingDestination(List<String> tradeParty2ReportingDestination);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ThirdPartyViewerId(String tradeParty1ThirdPartyViewerId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ThirdPartyViewerId(String tradeParty1ThirdPartyViewerId, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ThirdPartyViewerId(List<String> tradeParty1ThirdPartyViewerId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty1ThirdPartyViewerId(List<String> tradeParty1ThirdPartyViewerId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ThirdPartyViewerId(String tradeParty2ThirdPartyViewerId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ThirdPartyViewerId(String tradeParty2ThirdPartyViewerId, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ThirdPartyViewerId(List<String> tradeParty2ThirdPartyViewerId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty2ThirdPartyViewerId(List<String> tradeParty2ThirdPartyViewerId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ThirdPartyViewerIdType(String tradeParty1ThirdPartyViewerIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ThirdPartyViewerIdType(String tradeParty1ThirdPartyViewerIdType, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ThirdPartyViewerIdType(List<String> tradeParty1ThirdPartyViewerIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty1ThirdPartyViewerIdType(List<String> tradeParty1ThirdPartyViewerIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ThirdPartyViewerIdType(String tradeParty2ThirdPartyViewerIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ThirdPartyViewerIdType(String tradeParty2ThirdPartyViewerIdType, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ThirdPartyViewerIdType(List<String> tradeParty2ThirdPartyViewerIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty2ThirdPartyViewerIdType(List<String> tradeParty2ThirdPartyViewerIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1QuantityUnit(String leg1QuantityUnit);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1QuantityUnit(String leg1QuantityUnit, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1QuantityUnit(List<String> leg1QuantityUnit);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1QuantityUnit(List<String> leg1QuantityUnit);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1QuantityFrequency(String leg1QuantityFrequency);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1QuantityFrequency(String leg1QuantityFrequency, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1QuantityFrequency(List<String> leg1QuantityFrequency);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1QuantityFrequency(List<String> leg1QuantityFrequency);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1Quantity(BigDecimal leg1Quantity);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1Quantity(BigDecimal leg1Quantity, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1Quantity(List<BigDecimal> leg1Quantity);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1Quantity(List<BigDecimal> leg1Quantity);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryPoint(String deliveryPoint);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryPoint(String deliveryPoint, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryPoint(List<String> deliveryPoint);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setDeliveryPoint(List<String> deliveryPoint);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLoadDeliveryIntervals(LocalTime loadDeliveryIntervals);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLoadDeliveryIntervals(LocalTime loadDeliveryIntervals, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLoadDeliveryIntervals(List<LocalTime> loadDeliveryIntervals);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLoadDeliveryIntervals(List<LocalTime> loadDeliveryIntervals);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryEndDateAndTime(ZonedDateTime deliveryEndDateAndTime);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryEndDateAndTime(ZonedDateTime deliveryEndDateAndTime, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryEndDateAndTime(List<ZonedDateTime> deliveryEndDateAndTime);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setDeliveryEndDateAndTime(List<ZonedDateTime> deliveryEndDateAndTime);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDuration(String duration);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDuration(String duration, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDuration(List<String> duration);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setDuration(List<String> duration);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryCapacity(String deliveryCapacity);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryCapacity(String deliveryCapacity, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryCapacity(List<String> deliveryCapacity);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setDeliveryCapacity(List<String> deliveryCapacity);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPriceTimeIntervalQuantities(BigDecimal priceTimeIntervalQuantities);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPriceTimeIntervalQuantities(BigDecimal priceTimeIntervalQuantities, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPriceTimeIntervalQuantities(List<BigDecimal> priceTimeIntervalQuantities);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setPriceTimeIntervalQuantities(List<BigDecimal> priceTimeIntervalQuantities);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryStartDateAndTime(ZonedDateTime deliveryStartDateAndTime);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryStartDateAndTime(ZonedDateTime deliveryStartDateAndTime, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryStartDateAndTime(List<ZonedDateTime> deliveryStartDateAndTime);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setDeliveryStartDateAndTime(List<ZonedDateTime> deliveryStartDateAndTime);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addQuantityUnit(String quantityUnit);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addQuantityUnit(String quantityUnit, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addQuantityUnit(List<String> quantityUnit);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setQuantityUnit(List<String> quantityUnit);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantity(BigDecimal electricityPhysicalLegDeliveryStepQuantity);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantity(BigDecimal electricityPhysicalLegDeliveryStepQuantity, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantity(List<BigDecimal> electricityPhysicalLegDeliveryStepQuantity);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setElectricityPhysicalLegDeliveryStepQuantity(List<BigDecimal> electricityPhysicalLegDeliveryStepQuantity);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantityFrequency(String electricityPhysicalLegDeliveryStepQuantityFrequency);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantityFrequency(String electricityPhysicalLegDeliveryStepQuantityFrequency, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantityFrequency(List<String> electricityPhysicalLegDeliveryStepQuantityFrequency);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setElectricityPhysicalLegDeliveryStepQuantityFrequency(List<String> electricityPhysicalLegDeliveryStepQuantityFrequency);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantityUnit(String electricityPhysicalLegDeliveryStepQuantityUnit);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantityUnit(String electricityPhysicalLegDeliveryStepQuantityUnit, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantityUnit(List<String> electricityPhysicalLegDeliveryStepQuantityUnit);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setElectricityPhysicalLegDeliveryStepQuantityUnit(List<String> electricityPhysicalLegDeliveryStepQuantityUnit);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addProductGrade(String productGrade);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addProductGrade(String productGrade, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addProductGrade(List<String> productGrade);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setProductGrade(List<String> productGrade);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addBasketWeightPercentage(BigDecimal basketWeightPercentage);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addBasketWeightPercentage(BigDecimal basketWeightPercentage, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addBasketWeightPercentage(List<BigDecimal> basketWeightPercentage);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setBasketWeightPercentage(List<BigDecimal> basketWeightPercentage);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceObligationType(String referenceObligationType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceObligationType(String referenceObligationType, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceObligationType(List<String> referenceObligationType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setReferenceObligationType(List<String> referenceObligationType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetPlaceOfIncorporation(String underlyingAssetPlaceOfIncorporation);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetPlaceOfIncorporation(String underlyingAssetPlaceOfIncorporation, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetPlaceOfIncorporation(List<String> underlyingAssetPlaceOfIncorporation);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetPlaceOfIncorporation(List<String> underlyingAssetPlaceOfIncorporation);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetPlaceOfIssuance(String underlyingAssetPlaceOfIssuance);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetPlaceOfIssuance(String underlyingAssetPlaceOfIssuance, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetPlaceOfIssuance(List<String> underlyingAssetPlaceOfIssuance);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetPlaceOfIssuance(List<String> underlyingAssetPlaceOfIssuance);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceEntityId(String referenceEntityId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceEntityId(String referenceEntityId, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceEntityId(List<String> referenceEntityId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setReferenceEntityId(List<String> referenceEntityId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceEntityIdType(String referenceEntityIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceEntityIdType(String referenceEntityIdType, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceEntityIdType(List<String> referenceEntityIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setReferenceEntityIdType(List<String> referenceEntityIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetFixedRate(BigDecimal underlyingAssetFixedRate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetFixedRate(BigDecimal underlyingAssetFixedRate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetFixedRate(List<BigDecimal> underlyingAssetFixedRate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetFixedRate(List<BigDecimal> underlyingAssetFixedRate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetNotionalCurrency(String underlyingAssetNotionalCurrency);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetNotionalCurrency(String underlyingAssetNotionalCurrency, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetNotionalCurrency(List<String> underlyingAssetNotionalCurrency);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetNotionalCurrency(List<String> underlyingAssetNotionalCurrency);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodStartDate(Date periodStartDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodStartDate(Date periodStartDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodStartDate(List<Date> periodStartDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setPeriodStartDate(List<Date> periodStartDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodEndDate(Date periodEndDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodEndDate(Date periodEndDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodEndDate(List<Date> periodEndDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setPeriodEndDate(List<Date> periodEndDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodFixedStrike(BigDecimal periodFixedStrike);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodFixedStrike(BigDecimal periodFixedStrike, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodFixedStrike(List<BigDecimal> periodFixedStrike);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setPeriodFixedStrike(List<BigDecimal> periodFixedStrike);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodFixedAmount(BigDecimal periodFixedAmount);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodFixedAmount(BigDecimal periodFixedAmount, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodFixedAmount(List<BigDecimal> periodFixedAmount);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setPeriodFixedAmount(List<BigDecimal> periodFixedAmount);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetNotionalAmount(BigDecimal underlyingAssetNotionalAmount);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetNotionalAmount(BigDecimal underlyingAssetNotionalAmount, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetNotionalAmount(List<BigDecimal> underlyingAssetNotionalAmount);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetNotionalAmount(List<BigDecimal> underlyingAssetNotionalAmount);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDividendPaymentDate(Date dividendPaymentDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDividendPaymentDate(Date dividendPaymentDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDividendPaymentDate(List<Date> dividendPaymentDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setDividendPaymentDate(List<Date> dividendPaymentDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFixedAmountPaymentDate(Date fixedAmountPaymentDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFixedAmountPaymentDate(Date fixedAmountPaymentDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFixedAmountPaymentDate(List<Date> fixedAmountPaymentDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setFixedAmountPaymentDate(List<Date> fixedAmountPaymentDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1PaymentDates(Date leg1PaymentDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1PaymentDates(Date leg1PaymentDates, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1PaymentDates(List<Date> leg1PaymentDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1PaymentDates(List<Date> leg1PaymentDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2PaymentDates(Date leg2PaymentDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2PaymentDates(Date leg2PaymentDates, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2PaymentDates(List<Date> leg2PaymentDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2PaymentDates(List<Date> leg2PaymentDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetInitialPrice(BigDecimal underlyingAssetInitialPrice);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetInitialPrice(BigDecimal underlyingAssetInitialPrice, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetInitialPrice(List<BigDecimal> underlyingAssetInitialPrice);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetInitialPrice(List<BigDecimal> underlyingAssetInitialPrice);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCancelationOptionExerciseDates(Date cancelationOptionExerciseDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCancelationOptionExerciseDates(Date cancelationOptionExerciseDates, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCancelationOptionExerciseDates(List<Date> cancelationOptionExerciseDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCancelationOptionExerciseDates(List<Date> cancelationOptionExerciseDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCancelationOptionRelevantUnderlyingDates(Date cancelationOptionRelevantUnderlyingDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCancelationOptionRelevantUnderlyingDates(Date cancelationOptionRelevantUnderlyingDates, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCancelationOptionRelevantUnderlyingDates(List<Date> cancelationOptionRelevantUnderlyingDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCancelationOptionRelevantUnderlyingDates(List<Date> cancelationOptionRelevantUnderlyingDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCapRateStepDate(Date capRateStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCapRateStepDate(Date capRateStepDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCapRateStepDate(List<Date> capRateStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCapRateStepDate(List<Date> capRateStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCapRateStepValues(BigDecimal capRateStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCapRateStepValues(BigDecimal capRateStepValues, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCapRateStepValues(List<BigDecimal> capRateStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCapRateStepValues(List<BigDecimal> capRateStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addExerciseDates(Date exerciseDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addExerciseDates(Date exerciseDates, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addExerciseDates(List<Date> exerciseDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setExerciseDates(List<Date> exerciseDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFloorRateStepDate(Date floorRateStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFloorRateStepDate(Date floorRateStepDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFloorRateStepDate(List<Date> floorRateStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setFloorRateStepDate(List<Date> floorRateStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFloorRateStepValue(BigDecimal floorRateStepValue);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFloorRateStepValue(BigDecimal floorRateStepValue, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFloorRateStepValue(List<BigDecimal> floorRateStepValue);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setFloorRateStepValue(List<BigDecimal> floorRateStepValue);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FixedRateStepDate(Date leg1FixedRateStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FixedRateStepDate(Date leg1FixedRateStepDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FixedRateStepDate(List<Date> leg1FixedRateStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1FixedRateStepDate(List<Date> leg1FixedRateStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FixedRateStepValues(BigDecimal leg1FixedRateStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FixedRateStepValues(BigDecimal leg1FixedRateStepValues, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FixedRateStepValues(List<BigDecimal> leg1FixedRateStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1FixedRateStepValues(List<BigDecimal> leg1FixedRateStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateMultiplierStepDate(Date leg1FloatingRateMultiplierStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateMultiplierStepDate(Date leg1FloatingRateMultiplierStepDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateMultiplierStepDate(List<Date> leg1FloatingRateMultiplierStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1FloatingRateMultiplierStepDate(List<Date> leg1FloatingRateMultiplierStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateMultiplierStepValues(BigDecimal leg1FloatingRateMultiplierStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateMultiplierStepValues(BigDecimal leg1FloatingRateMultiplierStepValues, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateMultiplierStepValues(List<BigDecimal> leg1FloatingRateMultiplierStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1FloatingRateMultiplierStepValues(List<BigDecimal> leg1FloatingRateMultiplierStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateSpreadStepDate(Date leg1FloatingRateSpreadStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateSpreadStepDate(Date leg1FloatingRateSpreadStepDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateSpreadStepDate(List<Date> leg1FloatingRateSpreadStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1FloatingRateSpreadStepDate(List<Date> leg1FloatingRateSpreadStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateSpreadStepValues(BigDecimal leg1FloatingRateSpreadStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateSpreadStepValues(BigDecimal leg1FloatingRateSpreadStepValues, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateSpreadStepValues(List<BigDecimal> leg1FloatingRateSpreadStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1FloatingRateSpreadStepValues(List<BigDecimal> leg1FloatingRateSpreadStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1NotionalStepDate(Date leg1NotionalStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1NotionalStepDate(Date leg1NotionalStepDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1NotionalStepDate(List<Date> leg1NotionalStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1NotionalStepDate(List<Date> leg1NotionalStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1NotionalStepValues(BigDecimal leg1NotionalStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1NotionalStepValues(BigDecimal leg1NotionalStepValues, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1NotionalStepValues(List<BigDecimal> leg1NotionalStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1NotionalStepValues(List<BigDecimal> leg1NotionalStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FixedRateStepDate(Date leg2FixedRateStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FixedRateStepDate(Date leg2FixedRateStepDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FixedRateStepDate(List<Date> leg2FixedRateStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2FixedRateStepDate(List<Date> leg2FixedRateStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FixedRateStepValues(BigDecimal leg2FixedRateStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FixedRateStepValues(BigDecimal leg2FixedRateStepValues, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FixedRateStepValues(List<BigDecimal> leg2FixedRateStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2FixedRateStepValues(List<BigDecimal> leg2FixedRateStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateMultiplierStepDate(Date leg2FloatingRateMultiplierStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateMultiplierStepDate(Date leg2FloatingRateMultiplierStepDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateMultiplierStepDate(List<Date> leg2FloatingRateMultiplierStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2FloatingRateMultiplierStepDate(List<Date> leg2FloatingRateMultiplierStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateMultiplierStepValues(BigDecimal leg2FloatingRateMultiplierStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateMultiplierStepValues(BigDecimal leg2FloatingRateMultiplierStepValues, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateMultiplierStepValues(List<BigDecimal> leg2FloatingRateMultiplierStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2FloatingRateMultiplierStepValues(List<BigDecimal> leg2FloatingRateMultiplierStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateSpreadStepDate(Date leg2FloatingRateSpreadStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateSpreadStepDate(Date leg2FloatingRateSpreadStepDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateSpreadStepDate(List<Date> leg2FloatingRateSpreadStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2FloatingRateSpreadStepDate(List<Date> leg2FloatingRateSpreadStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateSpreadStepValues(BigDecimal leg2FloatingRateSpreadStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateSpreadStepValues(BigDecimal leg2FloatingRateSpreadStepValues, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateSpreadStepValues(List<BigDecimal> leg2FloatingRateSpreadStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2FloatingRateSpreadStepValues(List<BigDecimal> leg2FloatingRateSpreadStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2NotionalStepDate(Date leg2NotionalStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2NotionalStepDate(Date leg2NotionalStepDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2NotionalStepDate(List<Date> leg2NotionalStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2NotionalStepDate(List<Date> leg2NotionalStepDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2NotionalStepValues(BigDecimal leg2NotionalStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2NotionalStepValues(BigDecimal leg2NotionalStepValues, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2NotionalStepValues(List<BigDecimal> leg2NotionalStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2NotionalStepValues(List<BigDecimal> leg2NotionalStepValues);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationDates(Date optionalEarlyTerminationDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationDates(Date optionalEarlyTerminationDates, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationDates(List<Date> optionalEarlyTerminationDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setOptionalEarlyTerminationDates(List<Date> optionalEarlyTerminationDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationExerciseDates(Date optionalEarlyTerminationExerciseDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationExerciseDates(Date optionalEarlyTerminationExerciseDates, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationExerciseDates(List<Date> optionalEarlyTerminationExerciseDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setOptionalEarlyTerminationExerciseDates(List<Date> optionalEarlyTerminationExerciseDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationUnderlyingDates(Date optionalEarlyTerminationUnderlyingDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationUnderlyingDates(Date optionalEarlyTerminationUnderlyingDates, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationUnderlyingDates(List<Date> optionalEarlyTerminationUnderlyingDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setOptionalEarlyTerminationUnderlyingDates(List<Date> optionalEarlyTerminationUnderlyingDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addRelevantUnderlyingDatesUnadjustedDates(Date relevantUnderlyingDatesUnadjustedDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addRelevantUnderlyingDatesUnadjustedDates(Date relevantUnderlyingDatesUnadjustedDates, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addRelevantUnderlyingDatesUnadjustedDates(List<Date> relevantUnderlyingDatesUnadjustedDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setRelevantUnderlyingDatesUnadjustedDates(List<Date> relevantUnderlyingDatesUnadjustedDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationExerciseAdjustedDates(Date optionalEarlyTerminationExerciseAdjustedDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationExerciseAdjustedDates(Date optionalEarlyTerminationExerciseAdjustedDates, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationExerciseAdjustedDates(List<Date> optionalEarlyTerminationExerciseAdjustedDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setOptionalEarlyTerminationExerciseAdjustedDates(List<Date> optionalEarlyTerminationExerciseAdjustedDates);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetId(String underlyingAssetId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetId(String underlyingAssetId, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetId(List<String> underlyingAssetId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetId(List<String> underlyingAssetId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetIdType(String underlyingAssetIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetIdType(String underlyingAssetIdType, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetIdType(List<String> underlyingAssetIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetIdType(List<String> underlyingAssetIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetName(String underlyingAssetName);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetName(String underlyingAssetName, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetName(List<String> underlyingAssetName);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetName(List<String> underlyingAssetName);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addMandatoryClearingJurisdiction(String mandatoryClearingJurisdiction);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addMandatoryClearingJurisdiction(String mandatoryClearingJurisdiction, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addMandatoryClearingJurisdiction(List<String> mandatoryClearingJurisdiction);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setMandatoryClearingJurisdiction(List<String> mandatoryClearingJurisdiction);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingSwapUsiId(String clearingSwapUsiId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingSwapUsiId(String clearingSwapUsiId, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingSwapUsiId(List<String> clearingSwapUsiId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setClearingSwapUsiId(List<String> clearingSwapUsiId);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingSwapUsiIdPrefix(String clearingSwapUsiIdPrefix);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingSwapUsiIdPrefix(String clearingSwapUsiIdPrefix, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingSwapUsiIdPrefix(List<String> clearingSwapUsiIdPrefix);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setClearingSwapUsiIdPrefix(List<String> clearingSwapUsiIdPrefix);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1LocalCounterpartyJurisdiction(String tradeParty1LocalCounterpartyJurisdiction);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1LocalCounterpartyJurisdiction(String tradeParty1LocalCounterpartyJurisdiction, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1LocalCounterpartyJurisdiction(List<String> tradeParty1LocalCounterpartyJurisdiction);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty1LocalCounterpartyJurisdiction(List<String> tradeParty1LocalCounterpartyJurisdiction);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2LocalCounterpartyJurisdiction(String tradeParty2LocalCounterpartyJurisdiction);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2LocalCounterpartyJurisdiction(String tradeParty2LocalCounterpartyJurisdiction, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2LocalCounterpartyJurisdiction(List<String> tradeParty2LocalCounterpartyJurisdiction);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty2LocalCounterpartyJurisdiction(List<String> tradeParty2LocalCounterpartyJurisdiction);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingExceptionTypeParty2(String clearingExceptionTypeParty2);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingExceptionTypeParty2(String clearingExceptionTypeParty2, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingExceptionTypeParty2(List<String> clearingExceptionTypeParty2);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setClearingExceptionTypeParty2(List<String> clearingExceptionTypeParty2);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentPayer(String cdeOtherPaymentPayer);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentPayer(String cdeOtherPaymentPayer, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentPayer(List<String> cdeOtherPaymentPayer);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeOtherPaymentPayer(List<String> cdeOtherPaymentPayer);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentReceiver(String cdeOtherPaymentReceiver);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentReceiver(String cdeOtherPaymentReceiver, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentReceiver(List<String> cdeOtherPaymentReceiver);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeOtherPaymentReceiver(List<String> cdeOtherPaymentReceiver);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentType(String cdeOtherPaymentType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentType(String cdeOtherPaymentType, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentType(List<String> cdeOtherPaymentType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeOtherPaymentType(List<String> cdeOtherPaymentType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentAmount(BigDecimal cdeOtherPaymentAmount);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentAmount(BigDecimal cdeOtherPaymentAmount, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentAmount(List<BigDecimal> cdeOtherPaymentAmount);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeOtherPaymentAmount(List<BigDecimal> cdeOtherPaymentAmount);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentCurrency(String cdeOtherPaymentCurrency);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentCurrency(String cdeOtherPaymentCurrency, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentCurrency(List<String> cdeOtherPaymentCurrency);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeOtherPaymentCurrency(List<String> cdeOtherPaymentCurrency);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentDate(Date cdeOtherPaymentDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentDate(Date cdeOtherPaymentDate, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentDate(List<Date> cdeOtherPaymentDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeOtherPaymentDate(List<Date> cdeOtherPaymentDate);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOtherPaymentPayerIdType(String otherPaymentPayerIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOtherPaymentPayerIdType(String otherPaymentPayerIdType, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOtherPaymentPayerIdType(List<String> otherPaymentPayerIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setOtherPaymentPayerIdType(List<String> otherPaymentPayerIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOtherPaymentReceiverIdType(String otherPaymentReceiverIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOtherPaymentReceiverIdType(String otherPaymentReceiverIdType, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOtherPaymentReceiverIdType(List<String> otherPaymentReceiverIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setOtherPaymentReceiverIdType(List<String> otherPaymentReceiverIdType);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEffectiveDateOfNotionalQuantityOfLeg1(Date cdeEffectiveDateOfNotionalQuantityOfLeg1);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEffectiveDateOfNotionalQuantityOfLeg1(Date cdeEffectiveDateOfNotionalQuantityOfLeg1, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEffectiveDateOfNotionalQuantityOfLeg1(List<Date> cdeEffectiveDateOfNotionalQuantityOfLeg1);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeEffectiveDateOfNotionalQuantityOfLeg1(List<Date> cdeEffectiveDateOfNotionalQuantityOfLeg1);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEffectiveDateOfNotionalQuantityOfLeg2(Date cdeEffectiveDateOfNotionalQuantityOfLeg2);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEffectiveDateOfNotionalQuantityOfLeg2(Date cdeEffectiveDateOfNotionalQuantityOfLeg2, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEffectiveDateOfNotionalQuantityOfLeg2(List<Date> cdeEffectiveDateOfNotionalQuantityOfLeg2);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeEffectiveDateOfNotionalQuantityOfLeg2(List<Date> cdeEffectiveDateOfNotionalQuantityOfLeg2);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEndDateOfNotionalQuantityOfLeg1(Date cdeEndDateOfNotionalQuantityOfLeg1);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEndDateOfNotionalQuantityOfLeg1(Date cdeEndDateOfNotionalQuantityOfLeg1, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEndDateOfNotionalQuantityOfLeg1(List<Date> cdeEndDateOfNotionalQuantityOfLeg1);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeEndDateOfNotionalQuantityOfLeg1(List<Date> cdeEndDateOfNotionalQuantityOfLeg1);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEndDateOfNotionalQuantityOfLeg2(Date cdeEndDateOfNotionalQuantityOfLeg2);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEndDateOfNotionalQuantityOfLeg2(Date cdeEndDateOfNotionalQuantityOfLeg2, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEndDateOfNotionalQuantityOfLeg2(List<Date> cdeEndDateOfNotionalQuantityOfLeg2);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeEndDateOfNotionalQuantityOfLeg2(List<Date> cdeEndDateOfNotionalQuantityOfLeg2);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1(BigDecimal cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1(BigDecimal cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1(List<BigDecimal> cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1(List<BigDecimal> cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2(BigDecimal cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2(BigDecimal cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2(List<BigDecimal> cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2(List<BigDecimal> cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsIdentifier(String cdeBasketConstituentsIdentifier);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsIdentifier(String cdeBasketConstituentsIdentifier, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsIdentifier(List<String> cdeBasketConstituentsIdentifier);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeBasketConstituentsIdentifier(List<String> cdeBasketConstituentsIdentifier);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsIdentifierSource(String cdeBasketConstituentsIdentifierSource);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsIdentifierSource(String cdeBasketConstituentsIdentifierSource, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsIdentifierSource(List<String> cdeBasketConstituentsIdentifierSource);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeBasketConstituentsIdentifierSource(List<String> cdeBasketConstituentsIdentifierSource);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsNumberOfUnits(BigDecimal cdeBasketConstituentsNumberOfUnits);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsNumberOfUnits(BigDecimal cdeBasketConstituentsNumberOfUnits, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsNumberOfUnits(List<BigDecimal> cdeBasketConstituentsNumberOfUnits);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeBasketConstituentsNumberOfUnits(List<BigDecimal> cdeBasketConstituentsNumberOfUnits);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsUnitOfMeasure(String cdeBasketConstituentsUnitOfMeasure);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsUnitOfMeasure(String cdeBasketConstituentsUnitOfMeasure, int idx);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsUnitOfMeasure(List<String> cdeBasketConstituentsUnitOfMeasure);
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeBasketConstituentsUnitOfMeasure(List<String> cdeBasketConstituentsUnitOfMeasure);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("tradeParty1ReportingDestination"), String.class, getTradeParty1ReportingDestination(), this);
			processor.processBasic(path.newSubPath("tradeParty2ReportingDestination"), String.class, getTradeParty2ReportingDestination(), this);
			processor.processBasic(path.newSubPath("tradeParty1ThirdPartyViewerId"), String.class, getTradeParty1ThirdPartyViewerId(), this);
			processor.processBasic(path.newSubPath("tradeParty2ThirdPartyViewerId"), String.class, getTradeParty2ThirdPartyViewerId(), this);
			processor.processBasic(path.newSubPath("tradeParty1ThirdPartyViewerIdType"), String.class, getTradeParty1ThirdPartyViewerIdType(), this);
			processor.processBasic(path.newSubPath("tradeParty2ThirdPartyViewerIdType"), String.class, getTradeParty2ThirdPartyViewerIdType(), this);
			processor.processBasic(path.newSubPath("leg1QuantityUnit"), String.class, getLeg1QuantityUnit(), this);
			processor.processBasic(path.newSubPath("leg1QuantityFrequency"), String.class, getLeg1QuantityFrequency(), this);
			processor.processBasic(path.newSubPath("leg1Quantity"), BigDecimal.class, getLeg1Quantity(), this);
			processor.processBasic(path.newSubPath("deliveryPoint"), String.class, getDeliveryPoint(), this);
			processor.processBasic(path.newSubPath("loadDeliveryIntervals"), LocalTime.class, getLoadDeliveryIntervals(), this);
			processor.processBasic(path.newSubPath("deliveryEndDateAndTime"), ZonedDateTime.class, getDeliveryEndDateAndTime(), this);
			processor.processBasic(path.newSubPath("duration"), String.class, getDuration(), this);
			processor.processBasic(path.newSubPath("deliveryCapacity"), String.class, getDeliveryCapacity(), this);
			processor.processBasic(path.newSubPath("priceTimeIntervalQuantities"), BigDecimal.class, getPriceTimeIntervalQuantities(), this);
			processor.processBasic(path.newSubPath("deliveryStartDateAndTime"), ZonedDateTime.class, getDeliveryStartDateAndTime(), this);
			processor.processBasic(path.newSubPath("quantityUnit"), String.class, getQuantityUnit(), this);
			processor.processBasic(path.newSubPath("electricityPhysicalLegDeliveryStepQuantity"), BigDecimal.class, getElectricityPhysicalLegDeliveryStepQuantity(), this);
			processor.processBasic(path.newSubPath("electricityPhysicalLegDeliveryStepQuantityFrequency"), String.class, getElectricityPhysicalLegDeliveryStepQuantityFrequency(), this);
			processor.processBasic(path.newSubPath("electricityPhysicalLegDeliveryStepQuantityUnit"), String.class, getElectricityPhysicalLegDeliveryStepQuantityUnit(), this);
			processor.processBasic(path.newSubPath("productGrade"), String.class, getProductGrade(), this);
			processor.processBasic(path.newSubPath("basketWeightPercentage"), BigDecimal.class, getBasketWeightPercentage(), this);
			processor.processBasic(path.newSubPath("referenceObligationType"), String.class, getReferenceObligationType(), this);
			processor.processBasic(path.newSubPath("underlyingAssetPlaceOfIncorporation"), String.class, getUnderlyingAssetPlaceOfIncorporation(), this);
			processor.processBasic(path.newSubPath("underlyingAssetPlaceOfIssuance"), String.class, getUnderlyingAssetPlaceOfIssuance(), this);
			processor.processBasic(path.newSubPath("referenceEntityId"), String.class, getReferenceEntityId(), this);
			processor.processBasic(path.newSubPath("referenceEntityIdType"), String.class, getReferenceEntityIdType(), this);
			processor.processBasic(path.newSubPath("underlyingAssetFixedRate"), BigDecimal.class, getUnderlyingAssetFixedRate(), this);
			processor.processBasic(path.newSubPath("underlyingAssetNotionalCurrency"), String.class, getUnderlyingAssetNotionalCurrency(), this);
			processor.processBasic(path.newSubPath("periodStartDate"), Date.class, getPeriodStartDate(), this);
			processor.processBasic(path.newSubPath("periodEndDate"), Date.class, getPeriodEndDate(), this);
			processor.processBasic(path.newSubPath("periodFixedStrike"), BigDecimal.class, getPeriodFixedStrike(), this);
			processor.processBasic(path.newSubPath("periodFixedAmount"), BigDecimal.class, getPeriodFixedAmount(), this);
			processor.processBasic(path.newSubPath("underlyingAssetNotionalAmount"), BigDecimal.class, getUnderlyingAssetNotionalAmount(), this);
			processor.processBasic(path.newSubPath("dividendPaymentDate"), Date.class, getDividendPaymentDate(), this);
			processor.processBasic(path.newSubPath("fixedAmountPaymentDate"), Date.class, getFixedAmountPaymentDate(), this);
			processor.processBasic(path.newSubPath("leg1PaymentDates"), Date.class, getLeg1PaymentDates(), this);
			processor.processBasic(path.newSubPath("leg2PaymentDates"), Date.class, getLeg2PaymentDates(), this);
			processor.processBasic(path.newSubPath("underlyingAssetInitialPrice"), BigDecimal.class, getUnderlyingAssetInitialPrice(), this);
			processor.processBasic(path.newSubPath("cancelationOptionExerciseDates"), Date.class, getCancelationOptionExerciseDates(), this);
			processor.processBasic(path.newSubPath("cancelationOptionRelevantUnderlyingDates"), Date.class, getCancelationOptionRelevantUnderlyingDates(), this);
			processor.processBasic(path.newSubPath("capRateStepDate"), Date.class, getCapRateStepDate(), this);
			processor.processBasic(path.newSubPath("capRateStepValues"), BigDecimal.class, getCapRateStepValues(), this);
			processor.processBasic(path.newSubPath("exerciseDates"), Date.class, getExerciseDates(), this);
			processor.processBasic(path.newSubPath("floorRateStepDate"), Date.class, getFloorRateStepDate(), this);
			processor.processBasic(path.newSubPath("floorRateStepValue"), BigDecimal.class, getFloorRateStepValue(), this);
			processor.processBasic(path.newSubPath("leg1FixedRateStepDate"), Date.class, getLeg1FixedRateStepDate(), this);
			processor.processBasic(path.newSubPath("leg1FixedRateStepValues"), BigDecimal.class, getLeg1FixedRateStepValues(), this);
			processor.processBasic(path.newSubPath("leg1FloatingRateMultiplierStepDate"), Date.class, getLeg1FloatingRateMultiplierStepDate(), this);
			processor.processBasic(path.newSubPath("leg1FloatingRateMultiplierStepValues"), BigDecimal.class, getLeg1FloatingRateMultiplierStepValues(), this);
			processor.processBasic(path.newSubPath("leg1FloatingRateSpreadStepDate"), Date.class, getLeg1FloatingRateSpreadStepDate(), this);
			processor.processBasic(path.newSubPath("leg1FloatingRateSpreadStepValues"), BigDecimal.class, getLeg1FloatingRateSpreadStepValues(), this);
			processor.processBasic(path.newSubPath("leg1NotionalStepDate"), Date.class, getLeg1NotionalStepDate(), this);
			processor.processBasic(path.newSubPath("leg1NotionalStepValues"), BigDecimal.class, getLeg1NotionalStepValues(), this);
			processor.processBasic(path.newSubPath("leg2FixedRateStepDate"), Date.class, getLeg2FixedRateStepDate(), this);
			processor.processBasic(path.newSubPath("leg2FixedRateStepValues"), BigDecimal.class, getLeg2FixedRateStepValues(), this);
			processor.processBasic(path.newSubPath("leg2FloatingRateMultiplierStepDate"), Date.class, getLeg2FloatingRateMultiplierStepDate(), this);
			processor.processBasic(path.newSubPath("leg2FloatingRateMultiplierStepValues"), BigDecimal.class, getLeg2FloatingRateMultiplierStepValues(), this);
			processor.processBasic(path.newSubPath("leg2FloatingRateSpreadStepDate"), Date.class, getLeg2FloatingRateSpreadStepDate(), this);
			processor.processBasic(path.newSubPath("leg2FloatingRateSpreadStepValues"), BigDecimal.class, getLeg2FloatingRateSpreadStepValues(), this);
			processor.processBasic(path.newSubPath("leg2NotionalStepDate"), Date.class, getLeg2NotionalStepDate(), this);
			processor.processBasic(path.newSubPath("leg2NotionalStepValues"), BigDecimal.class, getLeg2NotionalStepValues(), this);
			processor.processBasic(path.newSubPath("optionalEarlyTerminationDates"), Date.class, getOptionalEarlyTerminationDates(), this);
			processor.processBasic(path.newSubPath("optionalEarlyTerminationExerciseDates"), Date.class, getOptionalEarlyTerminationExerciseDates(), this);
			processor.processBasic(path.newSubPath("optionalEarlyTerminationUnderlyingDates"), Date.class, getOptionalEarlyTerminationUnderlyingDates(), this);
			processor.processBasic(path.newSubPath("relevantUnderlyingDatesUnadjustedDates"), Date.class, getRelevantUnderlyingDatesUnadjustedDates(), this);
			processor.processBasic(path.newSubPath("optionalEarlyTerminationExerciseAdjustedDates"), Date.class, getOptionalEarlyTerminationExerciseAdjustedDates(), this);
			processor.processBasic(path.newSubPath("underlyingAssetId"), String.class, getUnderlyingAssetId(), this);
			processor.processBasic(path.newSubPath("underlyingAssetIdType"), String.class, getUnderlyingAssetIdType(), this);
			processor.processBasic(path.newSubPath("underlyingAssetName"), String.class, getUnderlyingAssetName(), this);
			processor.processBasic(path.newSubPath("mandatoryClearingJurisdiction"), String.class, getMandatoryClearingJurisdiction(), this);
			processor.processBasic(path.newSubPath("clearingSwapUsiId"), String.class, getClearingSwapUsiId(), this);
			processor.processBasic(path.newSubPath("clearingSwapUsiIdPrefix"), String.class, getClearingSwapUsiIdPrefix(), this);
			processor.processBasic(path.newSubPath("tradeParty1LocalCounterpartyJurisdiction"), String.class, getTradeParty1LocalCounterpartyJurisdiction(), this);
			processor.processBasic(path.newSubPath("tradeParty2LocalCounterpartyJurisdiction"), String.class, getTradeParty2LocalCounterpartyJurisdiction(), this);
			processor.processBasic(path.newSubPath("clearingExceptionTypeParty2"), String.class, getClearingExceptionTypeParty2(), this);
			processor.processBasic(path.newSubPath("cdeOtherPaymentPayer"), String.class, getCdeOtherPaymentPayer(), this);
			processor.processBasic(path.newSubPath("cdeOtherPaymentReceiver"), String.class, getCdeOtherPaymentReceiver(), this);
			processor.processBasic(path.newSubPath("cdeOtherPaymentType"), String.class, getCdeOtherPaymentType(), this);
			processor.processBasic(path.newSubPath("cdeOtherPaymentAmount"), BigDecimal.class, getCdeOtherPaymentAmount(), this);
			processor.processBasic(path.newSubPath("cdeOtherPaymentCurrency"), String.class, getCdeOtherPaymentCurrency(), this);
			processor.processBasic(path.newSubPath("cdeOtherPaymentDate"), Date.class, getCdeOtherPaymentDate(), this);
			processor.processBasic(path.newSubPath("otherPaymentPayerIdType"), String.class, getOtherPaymentPayerIdType(), this);
			processor.processBasic(path.newSubPath("otherPaymentReceiverIdType"), String.class, getOtherPaymentReceiverIdType(), this);
			processor.processBasic(path.newSubPath("cdeEffectiveDateOfNotionalQuantityOfLeg1"), Date.class, getCdeEffectiveDateOfNotionalQuantityOfLeg1(), this);
			processor.processBasic(path.newSubPath("cdeEffectiveDateOfNotionalQuantityOfLeg2"), Date.class, getCdeEffectiveDateOfNotionalQuantityOfLeg2(), this);
			processor.processBasic(path.newSubPath("cdeEndDateOfNotionalQuantityOfLeg1"), Date.class, getCdeEndDateOfNotionalQuantityOfLeg1(), this);
			processor.processBasic(path.newSubPath("cdeEndDateOfNotionalQuantityOfLeg2"), Date.class, getCdeEndDateOfNotionalQuantityOfLeg2(), this);
			processor.processBasic(path.newSubPath("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1"), BigDecimal.class, getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1(), this);
			processor.processBasic(path.newSubPath("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2"), BigDecimal.class, getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2(), this);
			processor.processBasic(path.newSubPath("cdeBasketConstituentsIdentifier"), String.class, getCdeBasketConstituentsIdentifier(), this);
			processor.processBasic(path.newSubPath("cdeBasketConstituentsIdentifierSource"), String.class, getCdeBasketConstituentsIdentifierSource(), this);
			processor.processBasic(path.newSubPath("cdeBasketConstituentsNumberOfUnits"), BigDecimal.class, getCdeBasketConstituentsNumberOfUnits(), this);
			processor.processBasic(path.newSubPath("cdeBasketConstituentsUnitOfMeasure"), String.class, getCdeBasketConstituentsUnitOfMeasure(), this);
		}
		

		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder prune();
	}

	/*********************** Immutable Implementation of HarmonizedRepeatableData  ***********************/
	class HarmonizedRepeatableDataImpl implements HarmonizedRepeatableData {
		private final List<String> tradeParty1ReportingDestination;
		private final List<String> tradeParty2ReportingDestination;
		private final List<String> tradeParty1ThirdPartyViewerId;
		private final List<String> tradeParty2ThirdPartyViewerId;
		private final List<String> tradeParty1ThirdPartyViewerIdType;
		private final List<String> tradeParty2ThirdPartyViewerIdType;
		private final List<String> leg1QuantityUnit;
		private final List<String> leg1QuantityFrequency;
		private final List<BigDecimal> leg1Quantity;
		private final List<String> deliveryPoint;
		private final List<LocalTime> loadDeliveryIntervals;
		private final List<ZonedDateTime> deliveryEndDateAndTime;
		private final List<String> duration;
		private final List<String> deliveryCapacity;
		private final List<BigDecimal> priceTimeIntervalQuantities;
		private final List<ZonedDateTime> deliveryStartDateAndTime;
		private final List<String> quantityUnit;
		private final List<BigDecimal> electricityPhysicalLegDeliveryStepQuantity;
		private final List<String> electricityPhysicalLegDeliveryStepQuantityFrequency;
		private final List<String> electricityPhysicalLegDeliveryStepQuantityUnit;
		private final List<String> productGrade;
		private final List<BigDecimal> basketWeightPercentage;
		private final List<String> referenceObligationType;
		private final List<String> underlyingAssetPlaceOfIncorporation;
		private final List<String> underlyingAssetPlaceOfIssuance;
		private final List<String> referenceEntityId;
		private final List<String> referenceEntityIdType;
		private final List<BigDecimal> underlyingAssetFixedRate;
		private final List<String> underlyingAssetNotionalCurrency;
		private final List<Date> periodStartDate;
		private final List<Date> periodEndDate;
		private final List<BigDecimal> periodFixedStrike;
		private final List<BigDecimal> periodFixedAmount;
		private final List<BigDecimal> underlyingAssetNotionalAmount;
		private final List<Date> dividendPaymentDate;
		private final List<Date> fixedAmountPaymentDate;
		private final List<Date> leg1PaymentDates;
		private final List<Date> leg2PaymentDates;
		private final List<BigDecimal> underlyingAssetInitialPrice;
		private final List<Date> cancelationOptionExerciseDates;
		private final List<Date> cancelationOptionRelevantUnderlyingDates;
		private final List<Date> capRateStepDate;
		private final List<BigDecimal> capRateStepValues;
		private final List<Date> exerciseDates;
		private final List<Date> floorRateStepDate;
		private final List<BigDecimal> floorRateStepValue;
		private final List<Date> leg1FixedRateStepDate;
		private final List<BigDecimal> leg1FixedRateStepValues;
		private final List<Date> leg1FloatingRateMultiplierStepDate;
		private final List<BigDecimal> leg1FloatingRateMultiplierStepValues;
		private final List<Date> leg1FloatingRateSpreadStepDate;
		private final List<BigDecimal> leg1FloatingRateSpreadStepValues;
		private final List<Date> leg1NotionalStepDate;
		private final List<BigDecimal> leg1NotionalStepValues;
		private final List<Date> leg2FixedRateStepDate;
		private final List<BigDecimal> leg2FixedRateStepValues;
		private final List<Date> leg2FloatingRateMultiplierStepDate;
		private final List<BigDecimal> leg2FloatingRateMultiplierStepValues;
		private final List<Date> leg2FloatingRateSpreadStepDate;
		private final List<BigDecimal> leg2FloatingRateSpreadStepValues;
		private final List<Date> leg2NotionalStepDate;
		private final List<BigDecimal> leg2NotionalStepValues;
		private final List<Date> optionalEarlyTerminationDates;
		private final List<Date> optionalEarlyTerminationExerciseDates;
		private final List<Date> optionalEarlyTerminationUnderlyingDates;
		private final List<Date> relevantUnderlyingDatesUnadjustedDates;
		private final List<Date> optionalEarlyTerminationExerciseAdjustedDates;
		private final List<String> underlyingAssetId;
		private final List<String> underlyingAssetIdType;
		private final List<String> underlyingAssetName;
		private final List<String> mandatoryClearingJurisdiction;
		private final List<String> clearingSwapUsiId;
		private final List<String> clearingSwapUsiIdPrefix;
		private final List<String> tradeParty1LocalCounterpartyJurisdiction;
		private final List<String> tradeParty2LocalCounterpartyJurisdiction;
		private final List<String> clearingExceptionTypeParty2;
		private final List<String> cdeOtherPaymentPayer;
		private final List<String> cdeOtherPaymentReceiver;
		private final List<String> cdeOtherPaymentType;
		private final List<BigDecimal> cdeOtherPaymentAmount;
		private final List<String> cdeOtherPaymentCurrency;
		private final List<Date> cdeOtherPaymentDate;
		private final List<String> otherPaymentPayerIdType;
		private final List<String> otherPaymentReceiverIdType;
		private final List<Date> cdeEffectiveDateOfNotionalQuantityOfLeg1;
		private final List<Date> cdeEffectiveDateOfNotionalQuantityOfLeg2;
		private final List<Date> cdeEndDateOfNotionalQuantityOfLeg1;
		private final List<Date> cdeEndDateOfNotionalQuantityOfLeg2;
		private final List<BigDecimal> cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1;
		private final List<BigDecimal> cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2;
		private final List<String> cdeBasketConstituentsIdentifier;
		private final List<String> cdeBasketConstituentsIdentifierSource;
		private final List<BigDecimal> cdeBasketConstituentsNumberOfUnits;
		private final List<String> cdeBasketConstituentsUnitOfMeasure;
		
		protected HarmonizedRepeatableDataImpl(HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder builder) {
			this.tradeParty1ReportingDestination = ofNullable(builder.getTradeParty1ReportingDestination()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeParty2ReportingDestination = ofNullable(builder.getTradeParty2ReportingDestination()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeParty1ThirdPartyViewerId = ofNullable(builder.getTradeParty1ThirdPartyViewerId()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeParty2ThirdPartyViewerId = ofNullable(builder.getTradeParty2ThirdPartyViewerId()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeParty1ThirdPartyViewerIdType = ofNullable(builder.getTradeParty1ThirdPartyViewerIdType()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeParty2ThirdPartyViewerIdType = ofNullable(builder.getTradeParty2ThirdPartyViewerIdType()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg1QuantityUnit = ofNullable(builder.getLeg1QuantityUnit()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg1QuantityFrequency = ofNullable(builder.getLeg1QuantityFrequency()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg1Quantity = ofNullable(builder.getLeg1Quantity()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.deliveryPoint = ofNullable(builder.getDeliveryPoint()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.loadDeliveryIntervals = ofNullable(builder.getLoadDeliveryIntervals()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.deliveryEndDateAndTime = ofNullable(builder.getDeliveryEndDateAndTime()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.duration = ofNullable(builder.getDuration()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.deliveryCapacity = ofNullable(builder.getDeliveryCapacity()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.priceTimeIntervalQuantities = ofNullable(builder.getPriceTimeIntervalQuantities()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.deliveryStartDateAndTime = ofNullable(builder.getDeliveryStartDateAndTime()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.quantityUnit = ofNullable(builder.getQuantityUnit()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.electricityPhysicalLegDeliveryStepQuantity = ofNullable(builder.getElectricityPhysicalLegDeliveryStepQuantity()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.electricityPhysicalLegDeliveryStepQuantityFrequency = ofNullable(builder.getElectricityPhysicalLegDeliveryStepQuantityFrequency()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.electricityPhysicalLegDeliveryStepQuantityUnit = ofNullable(builder.getElectricityPhysicalLegDeliveryStepQuantityUnit()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.productGrade = ofNullable(builder.getProductGrade()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.basketWeightPercentage = ofNullable(builder.getBasketWeightPercentage()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.referenceObligationType = ofNullable(builder.getReferenceObligationType()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.underlyingAssetPlaceOfIncorporation = ofNullable(builder.getUnderlyingAssetPlaceOfIncorporation()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.underlyingAssetPlaceOfIssuance = ofNullable(builder.getUnderlyingAssetPlaceOfIssuance()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.referenceEntityId = ofNullable(builder.getReferenceEntityId()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.referenceEntityIdType = ofNullable(builder.getReferenceEntityIdType()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.underlyingAssetFixedRate = ofNullable(builder.getUnderlyingAssetFixedRate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.underlyingAssetNotionalCurrency = ofNullable(builder.getUnderlyingAssetNotionalCurrency()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.periodStartDate = ofNullable(builder.getPeriodStartDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.periodEndDate = ofNullable(builder.getPeriodEndDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.periodFixedStrike = ofNullable(builder.getPeriodFixedStrike()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.periodFixedAmount = ofNullable(builder.getPeriodFixedAmount()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.underlyingAssetNotionalAmount = ofNullable(builder.getUnderlyingAssetNotionalAmount()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.dividendPaymentDate = ofNullable(builder.getDividendPaymentDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.fixedAmountPaymentDate = ofNullable(builder.getFixedAmountPaymentDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg1PaymentDates = ofNullable(builder.getLeg1PaymentDates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg2PaymentDates = ofNullable(builder.getLeg2PaymentDates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.underlyingAssetInitialPrice = ofNullable(builder.getUnderlyingAssetInitialPrice()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cancelationOptionExerciseDates = ofNullable(builder.getCancelationOptionExerciseDates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cancelationOptionRelevantUnderlyingDates = ofNullable(builder.getCancelationOptionRelevantUnderlyingDates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.capRateStepDate = ofNullable(builder.getCapRateStepDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.capRateStepValues = ofNullable(builder.getCapRateStepValues()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.exerciseDates = ofNullable(builder.getExerciseDates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.floorRateStepDate = ofNullable(builder.getFloorRateStepDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.floorRateStepValue = ofNullable(builder.getFloorRateStepValue()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg1FixedRateStepDate = ofNullable(builder.getLeg1FixedRateStepDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg1FixedRateStepValues = ofNullable(builder.getLeg1FixedRateStepValues()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg1FloatingRateMultiplierStepDate = ofNullable(builder.getLeg1FloatingRateMultiplierStepDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg1FloatingRateMultiplierStepValues = ofNullable(builder.getLeg1FloatingRateMultiplierStepValues()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg1FloatingRateSpreadStepDate = ofNullable(builder.getLeg1FloatingRateSpreadStepDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg1FloatingRateSpreadStepValues = ofNullable(builder.getLeg1FloatingRateSpreadStepValues()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg1NotionalStepDate = ofNullable(builder.getLeg1NotionalStepDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg1NotionalStepValues = ofNullable(builder.getLeg1NotionalStepValues()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg2FixedRateStepDate = ofNullable(builder.getLeg2FixedRateStepDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg2FixedRateStepValues = ofNullable(builder.getLeg2FixedRateStepValues()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg2FloatingRateMultiplierStepDate = ofNullable(builder.getLeg2FloatingRateMultiplierStepDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg2FloatingRateMultiplierStepValues = ofNullable(builder.getLeg2FloatingRateMultiplierStepValues()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg2FloatingRateSpreadStepDate = ofNullable(builder.getLeg2FloatingRateSpreadStepDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg2FloatingRateSpreadStepValues = ofNullable(builder.getLeg2FloatingRateSpreadStepValues()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg2NotionalStepDate = ofNullable(builder.getLeg2NotionalStepDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.leg2NotionalStepValues = ofNullable(builder.getLeg2NotionalStepValues()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.optionalEarlyTerminationDates = ofNullable(builder.getOptionalEarlyTerminationDates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.optionalEarlyTerminationExerciseDates = ofNullable(builder.getOptionalEarlyTerminationExerciseDates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.optionalEarlyTerminationUnderlyingDates = ofNullable(builder.getOptionalEarlyTerminationUnderlyingDates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.relevantUnderlyingDatesUnadjustedDates = ofNullable(builder.getRelevantUnderlyingDatesUnadjustedDates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.optionalEarlyTerminationExerciseAdjustedDates = ofNullable(builder.getOptionalEarlyTerminationExerciseAdjustedDates()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.underlyingAssetId = ofNullable(builder.getUnderlyingAssetId()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.underlyingAssetIdType = ofNullable(builder.getUnderlyingAssetIdType()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.underlyingAssetName = ofNullable(builder.getUnderlyingAssetName()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.mandatoryClearingJurisdiction = ofNullable(builder.getMandatoryClearingJurisdiction()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.clearingSwapUsiId = ofNullable(builder.getClearingSwapUsiId()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.clearingSwapUsiIdPrefix = ofNullable(builder.getClearingSwapUsiIdPrefix()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeParty1LocalCounterpartyJurisdiction = ofNullable(builder.getTradeParty1LocalCounterpartyJurisdiction()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.tradeParty2LocalCounterpartyJurisdiction = ofNullable(builder.getTradeParty2LocalCounterpartyJurisdiction()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.clearingExceptionTypeParty2 = ofNullable(builder.getClearingExceptionTypeParty2()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeOtherPaymentPayer = ofNullable(builder.getCdeOtherPaymentPayer()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeOtherPaymentReceiver = ofNullable(builder.getCdeOtherPaymentReceiver()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeOtherPaymentType = ofNullable(builder.getCdeOtherPaymentType()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeOtherPaymentAmount = ofNullable(builder.getCdeOtherPaymentAmount()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeOtherPaymentCurrency = ofNullable(builder.getCdeOtherPaymentCurrency()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeOtherPaymentDate = ofNullable(builder.getCdeOtherPaymentDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.otherPaymentPayerIdType = ofNullable(builder.getOtherPaymentPayerIdType()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.otherPaymentReceiverIdType = ofNullable(builder.getOtherPaymentReceiverIdType()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeEffectiveDateOfNotionalQuantityOfLeg1 = ofNullable(builder.getCdeEffectiveDateOfNotionalQuantityOfLeg1()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeEffectiveDateOfNotionalQuantityOfLeg2 = ofNullable(builder.getCdeEffectiveDateOfNotionalQuantityOfLeg2()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeEndDateOfNotionalQuantityOfLeg1 = ofNullable(builder.getCdeEndDateOfNotionalQuantityOfLeg1()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeEndDateOfNotionalQuantityOfLeg2 = ofNullable(builder.getCdeEndDateOfNotionalQuantityOfLeg2()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1 = ofNullable(builder.getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2 = ofNullable(builder.getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeBasketConstituentsIdentifier = ofNullable(builder.getCdeBasketConstituentsIdentifier()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeBasketConstituentsIdentifierSource = ofNullable(builder.getCdeBasketConstituentsIdentifierSource()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeBasketConstituentsNumberOfUnits = ofNullable(builder.getCdeBasketConstituentsNumberOfUnits()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.cdeBasketConstituentsUnitOfMeasure = ofNullable(builder.getCdeBasketConstituentsUnitOfMeasure()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		public List<String> getTradeParty1ReportingDestination() {
			return tradeParty1ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2ReportingDestination")
		public List<String> getTradeParty2ReportingDestination() {
			return tradeParty2ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ThirdPartyViewerId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerId")
		public List<String> getTradeParty1ThirdPartyViewerId() {
			return tradeParty1ThirdPartyViewerId;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ThirdPartyViewerId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerId")
		public List<String> getTradeParty2ThirdPartyViewerId() {
			return tradeParty2ThirdPartyViewerId;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ThirdPartyViewerIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerIdType")
		public List<String> getTradeParty1ThirdPartyViewerIdType() {
			return tradeParty1ThirdPartyViewerIdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ThirdPartyViewerIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerIdType")
		public List<String> getTradeParty2ThirdPartyViewerIdType() {
			return tradeParty2ThirdPartyViewerIdType;
		}
		
		@Override
		@RosettaAttribute("leg1QuantityUnit")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1QuantityUnit")
		public List<String> getLeg1QuantityUnit() {
			return leg1QuantityUnit;
		}
		
		@Override
		@RosettaAttribute("leg1QuantityFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1QuantityFrequency")
		public List<String> getLeg1QuantityFrequency() {
			return leg1QuantityFrequency;
		}
		
		@Override
		@RosettaAttribute("leg1Quantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1Quantity")
		public List<BigDecimal> getLeg1Quantity() {
			return leg1Quantity;
		}
		
		@Override
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("deliveryPoint")
		public List<String> getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		@RosettaAttribute("loadDeliveryIntervals")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loadDeliveryIntervals")
		public List<LocalTime> getLoadDeliveryIntervals() {
			return loadDeliveryIntervals;
		}
		
		@Override
		@RosettaAttribute("deliveryEndDateAndTime")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("deliveryEndDateAndTime")
		public List<ZonedDateTime> getDeliveryEndDateAndTime() {
			return deliveryEndDateAndTime;
		}
		
		@Override
		@RosettaAttribute("duration")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("duration")
		public List<String> getDuration() {
			return duration;
		}
		
		@Override
		@RosettaAttribute("deliveryCapacity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("deliveryCapacity")
		public List<String> getDeliveryCapacity() {
			return deliveryCapacity;
		}
		
		@Override
		@RosettaAttribute("priceTimeIntervalQuantities")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("priceTimeIntervalQuantities")
		public List<BigDecimal> getPriceTimeIntervalQuantities() {
			return priceTimeIntervalQuantities;
		}
		
		@Override
		@RosettaAttribute("deliveryStartDateAndTime")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("deliveryStartDateAndTime")
		public List<ZonedDateTime> getDeliveryStartDateAndTime() {
			return deliveryStartDateAndTime;
		}
		
		@Override
		@RosettaAttribute("quantityUnit")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quantityUnit")
		public List<String> getQuantityUnit() {
			return quantityUnit;
		}
		
		@Override
		@RosettaAttribute("electricityPhysicalLegDeliveryStepQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("electricityPhysicalLegDeliveryStepQuantity")
		public List<BigDecimal> getElectricityPhysicalLegDeliveryStepQuantity() {
			return electricityPhysicalLegDeliveryStepQuantity;
		}
		
		@Override
		@RosettaAttribute("electricityPhysicalLegDeliveryStepQuantityFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("electricityPhysicalLegDeliveryStepQuantityFrequency")
		public List<String> getElectricityPhysicalLegDeliveryStepQuantityFrequency() {
			return electricityPhysicalLegDeliveryStepQuantityFrequency;
		}
		
		@Override
		@RosettaAttribute("electricityPhysicalLegDeliveryStepQuantityUnit")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("electricityPhysicalLegDeliveryStepQuantityUnit")
		public List<String> getElectricityPhysicalLegDeliveryStepQuantityUnit() {
			return electricityPhysicalLegDeliveryStepQuantityUnit;
		}
		
		@Override
		@RosettaAttribute("productGrade")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("productGrade")
		public List<String> getProductGrade() {
			return productGrade;
		}
		
		@Override
		@RosettaAttribute("basketWeightPercentage")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("basketWeightPercentage")
		public List<BigDecimal> getBasketWeightPercentage() {
			return basketWeightPercentage;
		}
		
		@Override
		@RosettaAttribute("referenceObligationType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("referenceObligationType")
		public List<String> getReferenceObligationType() {
			return referenceObligationType;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetPlaceOfIncorporation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetPlaceOfIncorporation")
		public List<String> getUnderlyingAssetPlaceOfIncorporation() {
			return underlyingAssetPlaceOfIncorporation;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetPlaceOfIssuance")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetPlaceOfIssuance")
		public List<String> getUnderlyingAssetPlaceOfIssuance() {
			return underlyingAssetPlaceOfIssuance;
		}
		
		@Override
		@RosettaAttribute("referenceEntityId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("referenceEntityId")
		public List<String> getReferenceEntityId() {
			return referenceEntityId;
		}
		
		@Override
		@RosettaAttribute("referenceEntityIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("referenceEntityIdType")
		public List<String> getReferenceEntityIdType() {
			return referenceEntityIdType;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetFixedRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetFixedRate")
		public List<BigDecimal> getUnderlyingAssetFixedRate() {
			return underlyingAssetFixedRate;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetNotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetNotionalCurrency")
		public List<String> getUnderlyingAssetNotionalCurrency() {
			return underlyingAssetNotionalCurrency;
		}
		
		@Override
		@RosettaAttribute("periodStartDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("periodStartDate")
		public List<Date> getPeriodStartDate() {
			return periodStartDate;
		}
		
		@Override
		@RosettaAttribute("periodEndDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("periodEndDate")
		public List<Date> getPeriodEndDate() {
			return periodEndDate;
		}
		
		@Override
		@RosettaAttribute("periodFixedStrike")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("periodFixedStrike")
		public List<BigDecimal> getPeriodFixedStrike() {
			return periodFixedStrike;
		}
		
		@Override
		@RosettaAttribute("periodFixedAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("periodFixedAmount")
		public List<BigDecimal> getPeriodFixedAmount() {
			return periodFixedAmount;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetNotionalAmount")
		public List<BigDecimal> getUnderlyingAssetNotionalAmount() {
			return underlyingAssetNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("dividendPaymentDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dividendPaymentDate")
		public List<Date> getDividendPaymentDate() {
			return dividendPaymentDate;
		}
		
		@Override
		@RosettaAttribute("fixedAmountPaymentDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixedAmountPaymentDate")
		public List<Date> getFixedAmountPaymentDate() {
			return fixedAmountPaymentDate;
		}
		
		@Override
		@RosettaAttribute("leg1PaymentDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1PaymentDates")
		public List<Date> getLeg1PaymentDates() {
			return leg1PaymentDates;
		}
		
		@Override
		@RosettaAttribute("leg2PaymentDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2PaymentDates")
		public List<Date> getLeg2PaymentDates() {
			return leg2PaymentDates;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetInitialPrice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetInitialPrice")
		public List<BigDecimal> getUnderlyingAssetInitialPrice() {
			return underlyingAssetInitialPrice;
		}
		
		@Override
		@RosettaAttribute("cancelationOptionExerciseDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cancelationOptionExerciseDates")
		public List<Date> getCancelationOptionExerciseDates() {
			return cancelationOptionExerciseDates;
		}
		
		@Override
		@RosettaAttribute("cancelationOptionRelevantUnderlyingDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cancelationOptionRelevantUnderlyingDates")
		public List<Date> getCancelationOptionRelevantUnderlyingDates() {
			return cancelationOptionRelevantUnderlyingDates;
		}
		
		@Override
		@RosettaAttribute("capRateStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("capRateStepDate")
		public List<Date> getCapRateStepDate() {
			return capRateStepDate;
		}
		
		@Override
		@RosettaAttribute("capRateStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("capRateStepValues")
		public List<BigDecimal> getCapRateStepValues() {
			return capRateStepValues;
		}
		
		@Override
		@RosettaAttribute("exerciseDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("exerciseDates")
		public List<Date> getExerciseDates() {
			return exerciseDates;
		}
		
		@Override
		@RosettaAttribute("floorRateStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("floorRateStepDate")
		public List<Date> getFloorRateStepDate() {
			return floorRateStepDate;
		}
		
		@Override
		@RosettaAttribute("floorRateStepValue")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("floorRateStepValue")
		public List<BigDecimal> getFloorRateStepValue() {
			return floorRateStepValue;
		}
		
		@Override
		@RosettaAttribute("leg1FixedRateStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1FixedRateStepDate")
		public List<Date> getLeg1FixedRateStepDate() {
			return leg1FixedRateStepDate;
		}
		
		@Override
		@RosettaAttribute("leg1FixedRateStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1FixedRateStepValues")
		public List<BigDecimal> getLeg1FixedRateStepValues() {
			return leg1FixedRateStepValues;
		}
		
		@Override
		@RosettaAttribute("leg1FloatingRateMultiplierStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1FloatingRateMultiplierStepDate")
		public List<Date> getLeg1FloatingRateMultiplierStepDate() {
			return leg1FloatingRateMultiplierStepDate;
		}
		
		@Override
		@RosettaAttribute("leg1FloatingRateMultiplierStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1FloatingRateMultiplierStepValues")
		public List<BigDecimal> getLeg1FloatingRateMultiplierStepValues() {
			return leg1FloatingRateMultiplierStepValues;
		}
		
		@Override
		@RosettaAttribute("leg1FloatingRateSpreadStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1FloatingRateSpreadStepDate")
		public List<Date> getLeg1FloatingRateSpreadStepDate() {
			return leg1FloatingRateSpreadStepDate;
		}
		
		@Override
		@RosettaAttribute("leg1FloatingRateSpreadStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1FloatingRateSpreadStepValues")
		public List<BigDecimal> getLeg1FloatingRateSpreadStepValues() {
			return leg1FloatingRateSpreadStepValues;
		}
		
		@Override
		@RosettaAttribute("leg1NotionalStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1NotionalStepDate")
		public List<Date> getLeg1NotionalStepDate() {
			return leg1NotionalStepDate;
		}
		
		@Override
		@RosettaAttribute("leg1NotionalStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1NotionalStepValues")
		public List<BigDecimal> getLeg1NotionalStepValues() {
			return leg1NotionalStepValues;
		}
		
		@Override
		@RosettaAttribute("leg2FixedRateStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2FixedRateStepDate")
		public List<Date> getLeg2FixedRateStepDate() {
			return leg2FixedRateStepDate;
		}
		
		@Override
		@RosettaAttribute("leg2FixedRateStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2FixedRateStepValues")
		public List<BigDecimal> getLeg2FixedRateStepValues() {
			return leg2FixedRateStepValues;
		}
		
		@Override
		@RosettaAttribute("leg2FloatingRateMultiplierStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2FloatingRateMultiplierStepDate")
		public List<Date> getLeg2FloatingRateMultiplierStepDate() {
			return leg2FloatingRateMultiplierStepDate;
		}
		
		@Override
		@RosettaAttribute("leg2FloatingRateMultiplierStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2FloatingRateMultiplierStepValues")
		public List<BigDecimal> getLeg2FloatingRateMultiplierStepValues() {
			return leg2FloatingRateMultiplierStepValues;
		}
		
		@Override
		@RosettaAttribute("leg2FloatingRateSpreadStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2FloatingRateSpreadStepDate")
		public List<Date> getLeg2FloatingRateSpreadStepDate() {
			return leg2FloatingRateSpreadStepDate;
		}
		
		@Override
		@RosettaAttribute("leg2FloatingRateSpreadStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2FloatingRateSpreadStepValues")
		public List<BigDecimal> getLeg2FloatingRateSpreadStepValues() {
			return leg2FloatingRateSpreadStepValues;
		}
		
		@Override
		@RosettaAttribute("leg2NotionalStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2NotionalStepDate")
		public List<Date> getLeg2NotionalStepDate() {
			return leg2NotionalStepDate;
		}
		
		@Override
		@RosettaAttribute("leg2NotionalStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2NotionalStepValues")
		public List<BigDecimal> getLeg2NotionalStepValues() {
			return leg2NotionalStepValues;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationDates")
		public List<Date> getOptionalEarlyTerminationDates() {
			return optionalEarlyTerminationDates;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationExerciseDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationExerciseDates")
		public List<Date> getOptionalEarlyTerminationExerciseDates() {
			return optionalEarlyTerminationExerciseDates;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationUnderlyingDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationUnderlyingDates")
		public List<Date> getOptionalEarlyTerminationUnderlyingDates() {
			return optionalEarlyTerminationUnderlyingDates;
		}
		
		@Override
		@RosettaAttribute("relevantUnderlyingDatesUnadjustedDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relevantUnderlyingDatesUnadjustedDates")
		public List<Date> getRelevantUnderlyingDatesUnadjustedDates() {
			return relevantUnderlyingDatesUnadjustedDates;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationExerciseAdjustedDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationExerciseAdjustedDates")
		public List<Date> getOptionalEarlyTerminationExerciseAdjustedDates() {
			return optionalEarlyTerminationExerciseAdjustedDates;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetId")
		public List<String> getUnderlyingAssetId() {
			return underlyingAssetId;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetIdType")
		public List<String> getUnderlyingAssetIdType() {
			return underlyingAssetIdType;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetName")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetName")
		public List<String> getUnderlyingAssetName() {
			return underlyingAssetName;
		}
		
		@Override
		@RosettaAttribute("mandatoryClearingJurisdiction")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("mandatoryClearingJurisdiction")
		public List<String> getMandatoryClearingJurisdiction() {
			return mandatoryClearingJurisdiction;
		}
		
		@Override
		@RosettaAttribute("clearingSwapUsiId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingSwapUsiId")
		public List<String> getClearingSwapUsiId() {
			return clearingSwapUsiId;
		}
		
		@Override
		@RosettaAttribute("clearingSwapUsiIdPrefix")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingSwapUsiIdPrefix")
		public List<String> getClearingSwapUsiIdPrefix() {
			return clearingSwapUsiIdPrefix;
		}
		
		@Override
		@RosettaAttribute("tradeParty1LocalCounterpartyJurisdiction")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty1LocalCounterpartyJurisdiction")
		public List<String> getTradeParty1LocalCounterpartyJurisdiction() {
			return tradeParty1LocalCounterpartyJurisdiction;
		}
		
		@Override
		@RosettaAttribute("tradeParty2LocalCounterpartyJurisdiction")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2LocalCounterpartyJurisdiction")
		public List<String> getTradeParty2LocalCounterpartyJurisdiction() {
			return tradeParty2LocalCounterpartyJurisdiction;
		}
		
		@Override
		@RosettaAttribute("clearingExceptionTypeParty2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingExceptionTypeParty2")
		public List<String> getClearingExceptionTypeParty2() {
			return clearingExceptionTypeParty2;
		}
		
		@Override
		@RosettaAttribute("cdeOtherPaymentPayer")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentPayer")
		public List<String> getCdeOtherPaymentPayer() {
			return cdeOtherPaymentPayer;
		}
		
		@Override
		@RosettaAttribute("cdeOtherPaymentReceiver")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentReceiver")
		public List<String> getCdeOtherPaymentReceiver() {
			return cdeOtherPaymentReceiver;
		}
		
		@Override
		@RosettaAttribute("cdeOtherPaymentType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentType")
		public List<String> getCdeOtherPaymentType() {
			return cdeOtherPaymentType;
		}
		
		@Override
		@RosettaAttribute("cdeOtherPaymentAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentAmount")
		public List<BigDecimal> getCdeOtherPaymentAmount() {
			return cdeOtherPaymentAmount;
		}
		
		@Override
		@RosettaAttribute("cdeOtherPaymentCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentCurrency")
		public List<String> getCdeOtherPaymentCurrency() {
			return cdeOtherPaymentCurrency;
		}
		
		@Override
		@RosettaAttribute("cdeOtherPaymentDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentDate")
		public List<Date> getCdeOtherPaymentDate() {
			return cdeOtherPaymentDate;
		}
		
		@Override
		@RosettaAttribute("otherPaymentPayerIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPaymentPayerIdType")
		public List<String> getOtherPaymentPayerIdType() {
			return otherPaymentPayerIdType;
		}
		
		@Override
		@RosettaAttribute("otherPaymentReceiverIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPaymentReceiverIdType")
		public List<String> getOtherPaymentReceiverIdType() {
			return otherPaymentReceiverIdType;
		}
		
		@Override
		@RosettaAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg1")
		public List<Date> getCdeEffectiveDateOfNotionalQuantityOfLeg1() {
			return cdeEffectiveDateOfNotionalQuantityOfLeg1;
		}
		
		@Override
		@RosettaAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg2")
		public List<Date> getCdeEffectiveDateOfNotionalQuantityOfLeg2() {
			return cdeEffectiveDateOfNotionalQuantityOfLeg2;
		}
		
		@Override
		@RosettaAttribute("cdeEndDateOfNotionalQuantityOfLeg1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeEndDateOfNotionalQuantityOfLeg1")
		public List<Date> getCdeEndDateOfNotionalQuantityOfLeg1() {
			return cdeEndDateOfNotionalQuantityOfLeg1;
		}
		
		@Override
		@RosettaAttribute("cdeEndDateOfNotionalQuantityOfLeg2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeEndDateOfNotionalQuantityOfLeg2")
		public List<Date> getCdeEndDateOfNotionalQuantityOfLeg2() {
			return cdeEndDateOfNotionalQuantityOfLeg2;
		}
		
		@Override
		@RosettaAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1")
		public List<BigDecimal> getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1() {
			return cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1;
		}
		
		@Override
		@RosettaAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2")
		public List<BigDecimal> getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2() {
			return cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2;
		}
		
		@Override
		@RosettaAttribute("cdeBasketConstituentsIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsIdentifier")
		public List<String> getCdeBasketConstituentsIdentifier() {
			return cdeBasketConstituentsIdentifier;
		}
		
		@Override
		@RosettaAttribute("cdeBasketConstituentsIdentifierSource")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsIdentifierSource")
		public List<String> getCdeBasketConstituentsIdentifierSource() {
			return cdeBasketConstituentsIdentifierSource;
		}
		
		@Override
		@RosettaAttribute("cdeBasketConstituentsNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsNumberOfUnits")
		public List<BigDecimal> getCdeBasketConstituentsNumberOfUnits() {
			return cdeBasketConstituentsNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("cdeBasketConstituentsUnitOfMeasure")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsUnitOfMeasure")
		public List<String> getCdeBasketConstituentsUnitOfMeasure() {
			return cdeBasketConstituentsUnitOfMeasure;
		}
		
		@Override
		public HarmonizedRepeatableData build() {
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder toBuilder() {
			HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder builder) {
			ofNullable(getTradeParty1ReportingDestination()).ifPresent(builder::setTradeParty1ReportingDestination);
			ofNullable(getTradeParty2ReportingDestination()).ifPresent(builder::setTradeParty2ReportingDestination);
			ofNullable(getTradeParty1ThirdPartyViewerId()).ifPresent(builder::setTradeParty1ThirdPartyViewerId);
			ofNullable(getTradeParty2ThirdPartyViewerId()).ifPresent(builder::setTradeParty2ThirdPartyViewerId);
			ofNullable(getTradeParty1ThirdPartyViewerIdType()).ifPresent(builder::setTradeParty1ThirdPartyViewerIdType);
			ofNullable(getTradeParty2ThirdPartyViewerIdType()).ifPresent(builder::setTradeParty2ThirdPartyViewerIdType);
			ofNullable(getLeg1QuantityUnit()).ifPresent(builder::setLeg1QuantityUnit);
			ofNullable(getLeg1QuantityFrequency()).ifPresent(builder::setLeg1QuantityFrequency);
			ofNullable(getLeg1Quantity()).ifPresent(builder::setLeg1Quantity);
			ofNullable(getDeliveryPoint()).ifPresent(builder::setDeliveryPoint);
			ofNullable(getLoadDeliveryIntervals()).ifPresent(builder::setLoadDeliveryIntervals);
			ofNullable(getDeliveryEndDateAndTime()).ifPresent(builder::setDeliveryEndDateAndTime);
			ofNullable(getDuration()).ifPresent(builder::setDuration);
			ofNullable(getDeliveryCapacity()).ifPresent(builder::setDeliveryCapacity);
			ofNullable(getPriceTimeIntervalQuantities()).ifPresent(builder::setPriceTimeIntervalQuantities);
			ofNullable(getDeliveryStartDateAndTime()).ifPresent(builder::setDeliveryStartDateAndTime);
			ofNullable(getQuantityUnit()).ifPresent(builder::setQuantityUnit);
			ofNullable(getElectricityPhysicalLegDeliveryStepQuantity()).ifPresent(builder::setElectricityPhysicalLegDeliveryStepQuantity);
			ofNullable(getElectricityPhysicalLegDeliveryStepQuantityFrequency()).ifPresent(builder::setElectricityPhysicalLegDeliveryStepQuantityFrequency);
			ofNullable(getElectricityPhysicalLegDeliveryStepQuantityUnit()).ifPresent(builder::setElectricityPhysicalLegDeliveryStepQuantityUnit);
			ofNullable(getProductGrade()).ifPresent(builder::setProductGrade);
			ofNullable(getBasketWeightPercentage()).ifPresent(builder::setBasketWeightPercentage);
			ofNullable(getReferenceObligationType()).ifPresent(builder::setReferenceObligationType);
			ofNullable(getUnderlyingAssetPlaceOfIncorporation()).ifPresent(builder::setUnderlyingAssetPlaceOfIncorporation);
			ofNullable(getUnderlyingAssetPlaceOfIssuance()).ifPresent(builder::setUnderlyingAssetPlaceOfIssuance);
			ofNullable(getReferenceEntityId()).ifPresent(builder::setReferenceEntityId);
			ofNullable(getReferenceEntityIdType()).ifPresent(builder::setReferenceEntityIdType);
			ofNullable(getUnderlyingAssetFixedRate()).ifPresent(builder::setUnderlyingAssetFixedRate);
			ofNullable(getUnderlyingAssetNotionalCurrency()).ifPresent(builder::setUnderlyingAssetNotionalCurrency);
			ofNullable(getPeriodStartDate()).ifPresent(builder::setPeriodStartDate);
			ofNullable(getPeriodEndDate()).ifPresent(builder::setPeriodEndDate);
			ofNullable(getPeriodFixedStrike()).ifPresent(builder::setPeriodFixedStrike);
			ofNullable(getPeriodFixedAmount()).ifPresent(builder::setPeriodFixedAmount);
			ofNullable(getUnderlyingAssetNotionalAmount()).ifPresent(builder::setUnderlyingAssetNotionalAmount);
			ofNullable(getDividendPaymentDate()).ifPresent(builder::setDividendPaymentDate);
			ofNullable(getFixedAmountPaymentDate()).ifPresent(builder::setFixedAmountPaymentDate);
			ofNullable(getLeg1PaymentDates()).ifPresent(builder::setLeg1PaymentDates);
			ofNullable(getLeg2PaymentDates()).ifPresent(builder::setLeg2PaymentDates);
			ofNullable(getUnderlyingAssetInitialPrice()).ifPresent(builder::setUnderlyingAssetInitialPrice);
			ofNullable(getCancelationOptionExerciseDates()).ifPresent(builder::setCancelationOptionExerciseDates);
			ofNullable(getCancelationOptionRelevantUnderlyingDates()).ifPresent(builder::setCancelationOptionRelevantUnderlyingDates);
			ofNullable(getCapRateStepDate()).ifPresent(builder::setCapRateStepDate);
			ofNullable(getCapRateStepValues()).ifPresent(builder::setCapRateStepValues);
			ofNullable(getExerciseDates()).ifPresent(builder::setExerciseDates);
			ofNullable(getFloorRateStepDate()).ifPresent(builder::setFloorRateStepDate);
			ofNullable(getFloorRateStepValue()).ifPresent(builder::setFloorRateStepValue);
			ofNullable(getLeg1FixedRateStepDate()).ifPresent(builder::setLeg1FixedRateStepDate);
			ofNullable(getLeg1FixedRateStepValues()).ifPresent(builder::setLeg1FixedRateStepValues);
			ofNullable(getLeg1FloatingRateMultiplierStepDate()).ifPresent(builder::setLeg1FloatingRateMultiplierStepDate);
			ofNullable(getLeg1FloatingRateMultiplierStepValues()).ifPresent(builder::setLeg1FloatingRateMultiplierStepValues);
			ofNullable(getLeg1FloatingRateSpreadStepDate()).ifPresent(builder::setLeg1FloatingRateSpreadStepDate);
			ofNullable(getLeg1FloatingRateSpreadStepValues()).ifPresent(builder::setLeg1FloatingRateSpreadStepValues);
			ofNullable(getLeg1NotionalStepDate()).ifPresent(builder::setLeg1NotionalStepDate);
			ofNullable(getLeg1NotionalStepValues()).ifPresent(builder::setLeg1NotionalStepValues);
			ofNullable(getLeg2FixedRateStepDate()).ifPresent(builder::setLeg2FixedRateStepDate);
			ofNullable(getLeg2FixedRateStepValues()).ifPresent(builder::setLeg2FixedRateStepValues);
			ofNullable(getLeg2FloatingRateMultiplierStepDate()).ifPresent(builder::setLeg2FloatingRateMultiplierStepDate);
			ofNullable(getLeg2FloatingRateMultiplierStepValues()).ifPresent(builder::setLeg2FloatingRateMultiplierStepValues);
			ofNullable(getLeg2FloatingRateSpreadStepDate()).ifPresent(builder::setLeg2FloatingRateSpreadStepDate);
			ofNullable(getLeg2FloatingRateSpreadStepValues()).ifPresent(builder::setLeg2FloatingRateSpreadStepValues);
			ofNullable(getLeg2NotionalStepDate()).ifPresent(builder::setLeg2NotionalStepDate);
			ofNullable(getLeg2NotionalStepValues()).ifPresent(builder::setLeg2NotionalStepValues);
			ofNullable(getOptionalEarlyTerminationDates()).ifPresent(builder::setOptionalEarlyTerminationDates);
			ofNullable(getOptionalEarlyTerminationExerciseDates()).ifPresent(builder::setOptionalEarlyTerminationExerciseDates);
			ofNullable(getOptionalEarlyTerminationUnderlyingDates()).ifPresent(builder::setOptionalEarlyTerminationUnderlyingDates);
			ofNullable(getRelevantUnderlyingDatesUnadjustedDates()).ifPresent(builder::setRelevantUnderlyingDatesUnadjustedDates);
			ofNullable(getOptionalEarlyTerminationExerciseAdjustedDates()).ifPresent(builder::setOptionalEarlyTerminationExerciseAdjustedDates);
			ofNullable(getUnderlyingAssetId()).ifPresent(builder::setUnderlyingAssetId);
			ofNullable(getUnderlyingAssetIdType()).ifPresent(builder::setUnderlyingAssetIdType);
			ofNullable(getUnderlyingAssetName()).ifPresent(builder::setUnderlyingAssetName);
			ofNullable(getMandatoryClearingJurisdiction()).ifPresent(builder::setMandatoryClearingJurisdiction);
			ofNullable(getClearingSwapUsiId()).ifPresent(builder::setClearingSwapUsiId);
			ofNullable(getClearingSwapUsiIdPrefix()).ifPresent(builder::setClearingSwapUsiIdPrefix);
			ofNullable(getTradeParty1LocalCounterpartyJurisdiction()).ifPresent(builder::setTradeParty1LocalCounterpartyJurisdiction);
			ofNullable(getTradeParty2LocalCounterpartyJurisdiction()).ifPresent(builder::setTradeParty2LocalCounterpartyJurisdiction);
			ofNullable(getClearingExceptionTypeParty2()).ifPresent(builder::setClearingExceptionTypeParty2);
			ofNullable(getCdeOtherPaymentPayer()).ifPresent(builder::setCdeOtherPaymentPayer);
			ofNullable(getCdeOtherPaymentReceiver()).ifPresent(builder::setCdeOtherPaymentReceiver);
			ofNullable(getCdeOtherPaymentType()).ifPresent(builder::setCdeOtherPaymentType);
			ofNullable(getCdeOtherPaymentAmount()).ifPresent(builder::setCdeOtherPaymentAmount);
			ofNullable(getCdeOtherPaymentCurrency()).ifPresent(builder::setCdeOtherPaymentCurrency);
			ofNullable(getCdeOtherPaymentDate()).ifPresent(builder::setCdeOtherPaymentDate);
			ofNullable(getOtherPaymentPayerIdType()).ifPresent(builder::setOtherPaymentPayerIdType);
			ofNullable(getOtherPaymentReceiverIdType()).ifPresent(builder::setOtherPaymentReceiverIdType);
			ofNullable(getCdeEffectiveDateOfNotionalQuantityOfLeg1()).ifPresent(builder::setCdeEffectiveDateOfNotionalQuantityOfLeg1);
			ofNullable(getCdeEffectiveDateOfNotionalQuantityOfLeg2()).ifPresent(builder::setCdeEffectiveDateOfNotionalQuantityOfLeg2);
			ofNullable(getCdeEndDateOfNotionalQuantityOfLeg1()).ifPresent(builder::setCdeEndDateOfNotionalQuantityOfLeg1);
			ofNullable(getCdeEndDateOfNotionalQuantityOfLeg2()).ifPresent(builder::setCdeEndDateOfNotionalQuantityOfLeg2);
			ofNullable(getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1()).ifPresent(builder::setCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1);
			ofNullable(getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2()).ifPresent(builder::setCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2);
			ofNullable(getCdeBasketConstituentsIdentifier()).ifPresent(builder::setCdeBasketConstituentsIdentifier);
			ofNullable(getCdeBasketConstituentsIdentifierSource()).ifPresent(builder::setCdeBasketConstituentsIdentifierSource);
			ofNullable(getCdeBasketConstituentsNumberOfUnits()).ifPresent(builder::setCdeBasketConstituentsNumberOfUnits);
			ofNullable(getCdeBasketConstituentsUnitOfMeasure()).ifPresent(builder::setCdeBasketConstituentsUnitOfMeasure);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			HarmonizedRepeatableData _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeParty1ReportingDestination, _that.getTradeParty1ReportingDestination())) return false;
			if (!ListEquals.listEquals(tradeParty2ReportingDestination, _that.getTradeParty2ReportingDestination())) return false;
			if (!ListEquals.listEquals(tradeParty1ThirdPartyViewerId, _that.getTradeParty1ThirdPartyViewerId())) return false;
			if (!ListEquals.listEquals(tradeParty2ThirdPartyViewerId, _that.getTradeParty2ThirdPartyViewerId())) return false;
			if (!ListEquals.listEquals(tradeParty1ThirdPartyViewerIdType, _that.getTradeParty1ThirdPartyViewerIdType())) return false;
			if (!ListEquals.listEquals(tradeParty2ThirdPartyViewerIdType, _that.getTradeParty2ThirdPartyViewerIdType())) return false;
			if (!ListEquals.listEquals(leg1QuantityUnit, _that.getLeg1QuantityUnit())) return false;
			if (!ListEquals.listEquals(leg1QuantityFrequency, _that.getLeg1QuantityFrequency())) return false;
			if (!ListEquals.listEquals(leg1Quantity, _that.getLeg1Quantity())) return false;
			if (!ListEquals.listEquals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!ListEquals.listEquals(loadDeliveryIntervals, _that.getLoadDeliveryIntervals())) return false;
			if (!ListEquals.listEquals(deliveryEndDateAndTime, _that.getDeliveryEndDateAndTime())) return false;
			if (!ListEquals.listEquals(duration, _that.getDuration())) return false;
			if (!ListEquals.listEquals(deliveryCapacity, _that.getDeliveryCapacity())) return false;
			if (!ListEquals.listEquals(priceTimeIntervalQuantities, _that.getPriceTimeIntervalQuantities())) return false;
			if (!ListEquals.listEquals(deliveryStartDateAndTime, _that.getDeliveryStartDateAndTime())) return false;
			if (!ListEquals.listEquals(quantityUnit, _that.getQuantityUnit())) return false;
			if (!ListEquals.listEquals(electricityPhysicalLegDeliveryStepQuantity, _that.getElectricityPhysicalLegDeliveryStepQuantity())) return false;
			if (!ListEquals.listEquals(electricityPhysicalLegDeliveryStepQuantityFrequency, _that.getElectricityPhysicalLegDeliveryStepQuantityFrequency())) return false;
			if (!ListEquals.listEquals(electricityPhysicalLegDeliveryStepQuantityUnit, _that.getElectricityPhysicalLegDeliveryStepQuantityUnit())) return false;
			if (!ListEquals.listEquals(productGrade, _that.getProductGrade())) return false;
			if (!ListEquals.listEquals(basketWeightPercentage, _that.getBasketWeightPercentage())) return false;
			if (!ListEquals.listEquals(referenceObligationType, _that.getReferenceObligationType())) return false;
			if (!ListEquals.listEquals(underlyingAssetPlaceOfIncorporation, _that.getUnderlyingAssetPlaceOfIncorporation())) return false;
			if (!ListEquals.listEquals(underlyingAssetPlaceOfIssuance, _that.getUnderlyingAssetPlaceOfIssuance())) return false;
			if (!ListEquals.listEquals(referenceEntityId, _that.getReferenceEntityId())) return false;
			if (!ListEquals.listEquals(referenceEntityIdType, _that.getReferenceEntityIdType())) return false;
			if (!ListEquals.listEquals(underlyingAssetFixedRate, _that.getUnderlyingAssetFixedRate())) return false;
			if (!ListEquals.listEquals(underlyingAssetNotionalCurrency, _that.getUnderlyingAssetNotionalCurrency())) return false;
			if (!ListEquals.listEquals(periodStartDate, _that.getPeriodStartDate())) return false;
			if (!ListEquals.listEquals(periodEndDate, _that.getPeriodEndDate())) return false;
			if (!ListEquals.listEquals(periodFixedStrike, _that.getPeriodFixedStrike())) return false;
			if (!ListEquals.listEquals(periodFixedAmount, _that.getPeriodFixedAmount())) return false;
			if (!ListEquals.listEquals(underlyingAssetNotionalAmount, _that.getUnderlyingAssetNotionalAmount())) return false;
			if (!ListEquals.listEquals(dividendPaymentDate, _that.getDividendPaymentDate())) return false;
			if (!ListEquals.listEquals(fixedAmountPaymentDate, _that.getFixedAmountPaymentDate())) return false;
			if (!ListEquals.listEquals(leg1PaymentDates, _that.getLeg1PaymentDates())) return false;
			if (!ListEquals.listEquals(leg2PaymentDates, _that.getLeg2PaymentDates())) return false;
			if (!ListEquals.listEquals(underlyingAssetInitialPrice, _that.getUnderlyingAssetInitialPrice())) return false;
			if (!ListEquals.listEquals(cancelationOptionExerciseDates, _that.getCancelationOptionExerciseDates())) return false;
			if (!ListEquals.listEquals(cancelationOptionRelevantUnderlyingDates, _that.getCancelationOptionRelevantUnderlyingDates())) return false;
			if (!ListEquals.listEquals(capRateStepDate, _that.getCapRateStepDate())) return false;
			if (!ListEquals.listEquals(capRateStepValues, _that.getCapRateStepValues())) return false;
			if (!ListEquals.listEquals(exerciseDates, _that.getExerciseDates())) return false;
			if (!ListEquals.listEquals(floorRateStepDate, _that.getFloorRateStepDate())) return false;
			if (!ListEquals.listEquals(floorRateStepValue, _that.getFloorRateStepValue())) return false;
			if (!ListEquals.listEquals(leg1FixedRateStepDate, _that.getLeg1FixedRateStepDate())) return false;
			if (!ListEquals.listEquals(leg1FixedRateStepValues, _that.getLeg1FixedRateStepValues())) return false;
			if (!ListEquals.listEquals(leg1FloatingRateMultiplierStepDate, _that.getLeg1FloatingRateMultiplierStepDate())) return false;
			if (!ListEquals.listEquals(leg1FloatingRateMultiplierStepValues, _that.getLeg1FloatingRateMultiplierStepValues())) return false;
			if (!ListEquals.listEquals(leg1FloatingRateSpreadStepDate, _that.getLeg1FloatingRateSpreadStepDate())) return false;
			if (!ListEquals.listEquals(leg1FloatingRateSpreadStepValues, _that.getLeg1FloatingRateSpreadStepValues())) return false;
			if (!ListEquals.listEquals(leg1NotionalStepDate, _that.getLeg1NotionalStepDate())) return false;
			if (!ListEquals.listEquals(leg1NotionalStepValues, _that.getLeg1NotionalStepValues())) return false;
			if (!ListEquals.listEquals(leg2FixedRateStepDate, _that.getLeg2FixedRateStepDate())) return false;
			if (!ListEquals.listEquals(leg2FixedRateStepValues, _that.getLeg2FixedRateStepValues())) return false;
			if (!ListEquals.listEquals(leg2FloatingRateMultiplierStepDate, _that.getLeg2FloatingRateMultiplierStepDate())) return false;
			if (!ListEquals.listEquals(leg2FloatingRateMultiplierStepValues, _that.getLeg2FloatingRateMultiplierStepValues())) return false;
			if (!ListEquals.listEquals(leg2FloatingRateSpreadStepDate, _that.getLeg2FloatingRateSpreadStepDate())) return false;
			if (!ListEquals.listEquals(leg2FloatingRateSpreadStepValues, _that.getLeg2FloatingRateSpreadStepValues())) return false;
			if (!ListEquals.listEquals(leg2NotionalStepDate, _that.getLeg2NotionalStepDate())) return false;
			if (!ListEquals.listEquals(leg2NotionalStepValues, _that.getLeg2NotionalStepValues())) return false;
			if (!ListEquals.listEquals(optionalEarlyTerminationDates, _that.getOptionalEarlyTerminationDates())) return false;
			if (!ListEquals.listEquals(optionalEarlyTerminationExerciseDates, _that.getOptionalEarlyTerminationExerciseDates())) return false;
			if (!ListEquals.listEquals(optionalEarlyTerminationUnderlyingDates, _that.getOptionalEarlyTerminationUnderlyingDates())) return false;
			if (!ListEquals.listEquals(relevantUnderlyingDatesUnadjustedDates, _that.getRelevantUnderlyingDatesUnadjustedDates())) return false;
			if (!ListEquals.listEquals(optionalEarlyTerminationExerciseAdjustedDates, _that.getOptionalEarlyTerminationExerciseAdjustedDates())) return false;
			if (!ListEquals.listEquals(underlyingAssetId, _that.getUnderlyingAssetId())) return false;
			if (!ListEquals.listEquals(underlyingAssetIdType, _that.getUnderlyingAssetIdType())) return false;
			if (!ListEquals.listEquals(underlyingAssetName, _that.getUnderlyingAssetName())) return false;
			if (!ListEquals.listEquals(mandatoryClearingJurisdiction, _that.getMandatoryClearingJurisdiction())) return false;
			if (!ListEquals.listEquals(clearingSwapUsiId, _that.getClearingSwapUsiId())) return false;
			if (!ListEquals.listEquals(clearingSwapUsiIdPrefix, _that.getClearingSwapUsiIdPrefix())) return false;
			if (!ListEquals.listEquals(tradeParty1LocalCounterpartyJurisdiction, _that.getTradeParty1LocalCounterpartyJurisdiction())) return false;
			if (!ListEquals.listEquals(tradeParty2LocalCounterpartyJurisdiction, _that.getTradeParty2LocalCounterpartyJurisdiction())) return false;
			if (!ListEquals.listEquals(clearingExceptionTypeParty2, _that.getClearingExceptionTypeParty2())) return false;
			if (!ListEquals.listEquals(cdeOtherPaymentPayer, _that.getCdeOtherPaymentPayer())) return false;
			if (!ListEquals.listEquals(cdeOtherPaymentReceiver, _that.getCdeOtherPaymentReceiver())) return false;
			if (!ListEquals.listEquals(cdeOtherPaymentType, _that.getCdeOtherPaymentType())) return false;
			if (!ListEquals.listEquals(cdeOtherPaymentAmount, _that.getCdeOtherPaymentAmount())) return false;
			if (!ListEquals.listEquals(cdeOtherPaymentCurrency, _that.getCdeOtherPaymentCurrency())) return false;
			if (!ListEquals.listEquals(cdeOtherPaymentDate, _that.getCdeOtherPaymentDate())) return false;
			if (!ListEquals.listEquals(otherPaymentPayerIdType, _that.getOtherPaymentPayerIdType())) return false;
			if (!ListEquals.listEquals(otherPaymentReceiverIdType, _that.getOtherPaymentReceiverIdType())) return false;
			if (!ListEquals.listEquals(cdeEffectiveDateOfNotionalQuantityOfLeg1, _that.getCdeEffectiveDateOfNotionalQuantityOfLeg1())) return false;
			if (!ListEquals.listEquals(cdeEffectiveDateOfNotionalQuantityOfLeg2, _that.getCdeEffectiveDateOfNotionalQuantityOfLeg2())) return false;
			if (!ListEquals.listEquals(cdeEndDateOfNotionalQuantityOfLeg1, _that.getCdeEndDateOfNotionalQuantityOfLeg1())) return false;
			if (!ListEquals.listEquals(cdeEndDateOfNotionalQuantityOfLeg2, _that.getCdeEndDateOfNotionalQuantityOfLeg2())) return false;
			if (!ListEquals.listEquals(cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1, _that.getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1())) return false;
			if (!ListEquals.listEquals(cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2, _that.getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2())) return false;
			if (!ListEquals.listEquals(cdeBasketConstituentsIdentifier, _that.getCdeBasketConstituentsIdentifier())) return false;
			if (!ListEquals.listEquals(cdeBasketConstituentsIdentifierSource, _that.getCdeBasketConstituentsIdentifierSource())) return false;
			if (!ListEquals.listEquals(cdeBasketConstituentsNumberOfUnits, _that.getCdeBasketConstituentsNumberOfUnits())) return false;
			if (!ListEquals.listEquals(cdeBasketConstituentsUnitOfMeasure, _that.getCdeBasketConstituentsUnitOfMeasure())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeParty1ReportingDestination != null ? tradeParty1ReportingDestination.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ReportingDestination != null ? tradeParty2ReportingDestination.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ThirdPartyViewerId != null ? tradeParty1ThirdPartyViewerId.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ThirdPartyViewerId != null ? tradeParty2ThirdPartyViewerId.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ThirdPartyViewerIdType != null ? tradeParty1ThirdPartyViewerIdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ThirdPartyViewerIdType != null ? tradeParty2ThirdPartyViewerIdType.hashCode() : 0);
			_result = 31 * _result + (leg1QuantityUnit != null ? leg1QuantityUnit.hashCode() : 0);
			_result = 31 * _result + (leg1QuantityFrequency != null ? leg1QuantityFrequency.hashCode() : 0);
			_result = 31 * _result + (leg1Quantity != null ? leg1Quantity.hashCode() : 0);
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (loadDeliveryIntervals != null ? loadDeliveryIntervals.hashCode() : 0);
			_result = 31 * _result + (deliveryEndDateAndTime != null ? deliveryEndDateAndTime.hashCode() : 0);
			_result = 31 * _result + (duration != null ? duration.hashCode() : 0);
			_result = 31 * _result + (deliveryCapacity != null ? deliveryCapacity.hashCode() : 0);
			_result = 31 * _result + (priceTimeIntervalQuantities != null ? priceTimeIntervalQuantities.hashCode() : 0);
			_result = 31 * _result + (deliveryStartDateAndTime != null ? deliveryStartDateAndTime.hashCode() : 0);
			_result = 31 * _result + (quantityUnit != null ? quantityUnit.hashCode() : 0);
			_result = 31 * _result + (electricityPhysicalLegDeliveryStepQuantity != null ? electricityPhysicalLegDeliveryStepQuantity.hashCode() : 0);
			_result = 31 * _result + (electricityPhysicalLegDeliveryStepQuantityFrequency != null ? electricityPhysicalLegDeliveryStepQuantityFrequency.hashCode() : 0);
			_result = 31 * _result + (electricityPhysicalLegDeliveryStepQuantityUnit != null ? electricityPhysicalLegDeliveryStepQuantityUnit.hashCode() : 0);
			_result = 31 * _result + (productGrade != null ? productGrade.hashCode() : 0);
			_result = 31 * _result + (basketWeightPercentage != null ? basketWeightPercentage.hashCode() : 0);
			_result = 31 * _result + (referenceObligationType != null ? referenceObligationType.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetPlaceOfIncorporation != null ? underlyingAssetPlaceOfIncorporation.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetPlaceOfIssuance != null ? underlyingAssetPlaceOfIssuance.hashCode() : 0);
			_result = 31 * _result + (referenceEntityId != null ? referenceEntityId.hashCode() : 0);
			_result = 31 * _result + (referenceEntityIdType != null ? referenceEntityIdType.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetFixedRate != null ? underlyingAssetFixedRate.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetNotionalCurrency != null ? underlyingAssetNotionalCurrency.hashCode() : 0);
			_result = 31 * _result + (periodStartDate != null ? periodStartDate.hashCode() : 0);
			_result = 31 * _result + (periodEndDate != null ? periodEndDate.hashCode() : 0);
			_result = 31 * _result + (periodFixedStrike != null ? periodFixedStrike.hashCode() : 0);
			_result = 31 * _result + (periodFixedAmount != null ? periodFixedAmount.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetNotionalAmount != null ? underlyingAssetNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (dividendPaymentDate != null ? dividendPaymentDate.hashCode() : 0);
			_result = 31 * _result + (fixedAmountPaymentDate != null ? fixedAmountPaymentDate.hashCode() : 0);
			_result = 31 * _result + (leg1PaymentDates != null ? leg1PaymentDates.hashCode() : 0);
			_result = 31 * _result + (leg2PaymentDates != null ? leg2PaymentDates.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetInitialPrice != null ? underlyingAssetInitialPrice.hashCode() : 0);
			_result = 31 * _result + (cancelationOptionExerciseDates != null ? cancelationOptionExerciseDates.hashCode() : 0);
			_result = 31 * _result + (cancelationOptionRelevantUnderlyingDates != null ? cancelationOptionRelevantUnderlyingDates.hashCode() : 0);
			_result = 31 * _result + (capRateStepDate != null ? capRateStepDate.hashCode() : 0);
			_result = 31 * _result + (capRateStepValues != null ? capRateStepValues.hashCode() : 0);
			_result = 31 * _result + (exerciseDates != null ? exerciseDates.hashCode() : 0);
			_result = 31 * _result + (floorRateStepDate != null ? floorRateStepDate.hashCode() : 0);
			_result = 31 * _result + (floorRateStepValue != null ? floorRateStepValue.hashCode() : 0);
			_result = 31 * _result + (leg1FixedRateStepDate != null ? leg1FixedRateStepDate.hashCode() : 0);
			_result = 31 * _result + (leg1FixedRateStepValues != null ? leg1FixedRateStepValues.hashCode() : 0);
			_result = 31 * _result + (leg1FloatingRateMultiplierStepDate != null ? leg1FloatingRateMultiplierStepDate.hashCode() : 0);
			_result = 31 * _result + (leg1FloatingRateMultiplierStepValues != null ? leg1FloatingRateMultiplierStepValues.hashCode() : 0);
			_result = 31 * _result + (leg1FloatingRateSpreadStepDate != null ? leg1FloatingRateSpreadStepDate.hashCode() : 0);
			_result = 31 * _result + (leg1FloatingRateSpreadStepValues != null ? leg1FloatingRateSpreadStepValues.hashCode() : 0);
			_result = 31 * _result + (leg1NotionalStepDate != null ? leg1NotionalStepDate.hashCode() : 0);
			_result = 31 * _result + (leg1NotionalStepValues != null ? leg1NotionalStepValues.hashCode() : 0);
			_result = 31 * _result + (leg2FixedRateStepDate != null ? leg2FixedRateStepDate.hashCode() : 0);
			_result = 31 * _result + (leg2FixedRateStepValues != null ? leg2FixedRateStepValues.hashCode() : 0);
			_result = 31 * _result + (leg2FloatingRateMultiplierStepDate != null ? leg2FloatingRateMultiplierStepDate.hashCode() : 0);
			_result = 31 * _result + (leg2FloatingRateMultiplierStepValues != null ? leg2FloatingRateMultiplierStepValues.hashCode() : 0);
			_result = 31 * _result + (leg2FloatingRateSpreadStepDate != null ? leg2FloatingRateSpreadStepDate.hashCode() : 0);
			_result = 31 * _result + (leg2FloatingRateSpreadStepValues != null ? leg2FloatingRateSpreadStepValues.hashCode() : 0);
			_result = 31 * _result + (leg2NotionalStepDate != null ? leg2NotionalStepDate.hashCode() : 0);
			_result = 31 * _result + (leg2NotionalStepValues != null ? leg2NotionalStepValues.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationDates != null ? optionalEarlyTerminationDates.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationExerciseDates != null ? optionalEarlyTerminationExerciseDates.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationUnderlyingDates != null ? optionalEarlyTerminationUnderlyingDates.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDatesUnadjustedDates != null ? relevantUnderlyingDatesUnadjustedDates.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationExerciseAdjustedDates != null ? optionalEarlyTerminationExerciseAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetId != null ? underlyingAssetId.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetIdType != null ? underlyingAssetIdType.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetName != null ? underlyingAssetName.hashCode() : 0);
			_result = 31 * _result + (mandatoryClearingJurisdiction != null ? mandatoryClearingJurisdiction.hashCode() : 0);
			_result = 31 * _result + (clearingSwapUsiId != null ? clearingSwapUsiId.hashCode() : 0);
			_result = 31 * _result + (clearingSwapUsiIdPrefix != null ? clearingSwapUsiIdPrefix.hashCode() : 0);
			_result = 31 * _result + (tradeParty1LocalCounterpartyJurisdiction != null ? tradeParty1LocalCounterpartyJurisdiction.hashCode() : 0);
			_result = 31 * _result + (tradeParty2LocalCounterpartyJurisdiction != null ? tradeParty2LocalCounterpartyJurisdiction.hashCode() : 0);
			_result = 31 * _result + (clearingExceptionTypeParty2 != null ? clearingExceptionTypeParty2.hashCode() : 0);
			_result = 31 * _result + (cdeOtherPaymentPayer != null ? cdeOtherPaymentPayer.hashCode() : 0);
			_result = 31 * _result + (cdeOtherPaymentReceiver != null ? cdeOtherPaymentReceiver.hashCode() : 0);
			_result = 31 * _result + (cdeOtherPaymentType != null ? cdeOtherPaymentType.hashCode() : 0);
			_result = 31 * _result + (cdeOtherPaymentAmount != null ? cdeOtherPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (cdeOtherPaymentCurrency != null ? cdeOtherPaymentCurrency.hashCode() : 0);
			_result = 31 * _result + (cdeOtherPaymentDate != null ? cdeOtherPaymentDate.hashCode() : 0);
			_result = 31 * _result + (otherPaymentPayerIdType != null ? otherPaymentPayerIdType.hashCode() : 0);
			_result = 31 * _result + (otherPaymentReceiverIdType != null ? otherPaymentReceiverIdType.hashCode() : 0);
			_result = 31 * _result + (cdeEffectiveDateOfNotionalQuantityOfLeg1 != null ? cdeEffectiveDateOfNotionalQuantityOfLeg1.hashCode() : 0);
			_result = 31 * _result + (cdeEffectiveDateOfNotionalQuantityOfLeg2 != null ? cdeEffectiveDateOfNotionalQuantityOfLeg2.hashCode() : 0);
			_result = 31 * _result + (cdeEndDateOfNotionalQuantityOfLeg1 != null ? cdeEndDateOfNotionalQuantityOfLeg1.hashCode() : 0);
			_result = 31 * _result + (cdeEndDateOfNotionalQuantityOfLeg2 != null ? cdeEndDateOfNotionalQuantityOfLeg2.hashCode() : 0);
			_result = 31 * _result + (cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1 != null ? cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1.hashCode() : 0);
			_result = 31 * _result + (cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2 != null ? cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2.hashCode() : 0);
			_result = 31 * _result + (cdeBasketConstituentsIdentifier != null ? cdeBasketConstituentsIdentifier.hashCode() : 0);
			_result = 31 * _result + (cdeBasketConstituentsIdentifierSource != null ? cdeBasketConstituentsIdentifierSource.hashCode() : 0);
			_result = 31 * _result + (cdeBasketConstituentsNumberOfUnits != null ? cdeBasketConstituentsNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (cdeBasketConstituentsUnitOfMeasure != null ? cdeBasketConstituentsUnitOfMeasure.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HarmonizedRepeatableData {" +
				"tradeParty1ReportingDestination=" + this.tradeParty1ReportingDestination + ", " +
				"tradeParty2ReportingDestination=" + this.tradeParty2ReportingDestination + ", " +
				"tradeParty1ThirdPartyViewerId=" + this.tradeParty1ThirdPartyViewerId + ", " +
				"tradeParty2ThirdPartyViewerId=" + this.tradeParty2ThirdPartyViewerId + ", " +
				"tradeParty1ThirdPartyViewerIdType=" + this.tradeParty1ThirdPartyViewerIdType + ", " +
				"tradeParty2ThirdPartyViewerIdType=" + this.tradeParty2ThirdPartyViewerIdType + ", " +
				"leg1QuantityUnit=" + this.leg1QuantityUnit + ", " +
				"leg1QuantityFrequency=" + this.leg1QuantityFrequency + ", " +
				"leg1Quantity=" + this.leg1Quantity + ", " +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"loadDeliveryIntervals=" + this.loadDeliveryIntervals + ", " +
				"deliveryEndDateAndTime=" + this.deliveryEndDateAndTime + ", " +
				"duration=" + this.duration + ", " +
				"deliveryCapacity=" + this.deliveryCapacity + ", " +
				"priceTimeIntervalQuantities=" + this.priceTimeIntervalQuantities + ", " +
				"deliveryStartDateAndTime=" + this.deliveryStartDateAndTime + ", " +
				"quantityUnit=" + this.quantityUnit + ", " +
				"electricityPhysicalLegDeliveryStepQuantity=" + this.electricityPhysicalLegDeliveryStepQuantity + ", " +
				"electricityPhysicalLegDeliveryStepQuantityFrequency=" + this.electricityPhysicalLegDeliveryStepQuantityFrequency + ", " +
				"electricityPhysicalLegDeliveryStepQuantityUnit=" + this.electricityPhysicalLegDeliveryStepQuantityUnit + ", " +
				"productGrade=" + this.productGrade + ", " +
				"basketWeightPercentage=" + this.basketWeightPercentage + ", " +
				"referenceObligationType=" + this.referenceObligationType + ", " +
				"underlyingAssetPlaceOfIncorporation=" + this.underlyingAssetPlaceOfIncorporation + ", " +
				"underlyingAssetPlaceOfIssuance=" + this.underlyingAssetPlaceOfIssuance + ", " +
				"referenceEntityId=" + this.referenceEntityId + ", " +
				"referenceEntityIdType=" + this.referenceEntityIdType + ", " +
				"underlyingAssetFixedRate=" + this.underlyingAssetFixedRate + ", " +
				"underlyingAssetNotionalCurrency=" + this.underlyingAssetNotionalCurrency + ", " +
				"periodStartDate=" + this.periodStartDate + ", " +
				"periodEndDate=" + this.periodEndDate + ", " +
				"periodFixedStrike=" + this.periodFixedStrike + ", " +
				"periodFixedAmount=" + this.periodFixedAmount + ", " +
				"underlyingAssetNotionalAmount=" + this.underlyingAssetNotionalAmount + ", " +
				"dividendPaymentDate=" + this.dividendPaymentDate + ", " +
				"fixedAmountPaymentDate=" + this.fixedAmountPaymentDate + ", " +
				"leg1PaymentDates=" + this.leg1PaymentDates + ", " +
				"leg2PaymentDates=" + this.leg2PaymentDates + ", " +
				"underlyingAssetInitialPrice=" + this.underlyingAssetInitialPrice + ", " +
				"cancelationOptionExerciseDates=" + this.cancelationOptionExerciseDates + ", " +
				"cancelationOptionRelevantUnderlyingDates=" + this.cancelationOptionRelevantUnderlyingDates + ", " +
				"capRateStepDate=" + this.capRateStepDate + ", " +
				"capRateStepValues=" + this.capRateStepValues + ", " +
				"exerciseDates=" + this.exerciseDates + ", " +
				"floorRateStepDate=" + this.floorRateStepDate + ", " +
				"floorRateStepValue=" + this.floorRateStepValue + ", " +
				"leg1FixedRateStepDate=" + this.leg1FixedRateStepDate + ", " +
				"leg1FixedRateStepValues=" + this.leg1FixedRateStepValues + ", " +
				"leg1FloatingRateMultiplierStepDate=" + this.leg1FloatingRateMultiplierStepDate + ", " +
				"leg1FloatingRateMultiplierStepValues=" + this.leg1FloatingRateMultiplierStepValues + ", " +
				"leg1FloatingRateSpreadStepDate=" + this.leg1FloatingRateSpreadStepDate + ", " +
				"leg1FloatingRateSpreadStepValues=" + this.leg1FloatingRateSpreadStepValues + ", " +
				"leg1NotionalStepDate=" + this.leg1NotionalStepDate + ", " +
				"leg1NotionalStepValues=" + this.leg1NotionalStepValues + ", " +
				"leg2FixedRateStepDate=" + this.leg2FixedRateStepDate + ", " +
				"leg2FixedRateStepValues=" + this.leg2FixedRateStepValues + ", " +
				"leg2FloatingRateMultiplierStepDate=" + this.leg2FloatingRateMultiplierStepDate + ", " +
				"leg2FloatingRateMultiplierStepValues=" + this.leg2FloatingRateMultiplierStepValues + ", " +
				"leg2FloatingRateSpreadStepDate=" + this.leg2FloatingRateSpreadStepDate + ", " +
				"leg2FloatingRateSpreadStepValues=" + this.leg2FloatingRateSpreadStepValues + ", " +
				"leg2NotionalStepDate=" + this.leg2NotionalStepDate + ", " +
				"leg2NotionalStepValues=" + this.leg2NotionalStepValues + ", " +
				"optionalEarlyTerminationDates=" + this.optionalEarlyTerminationDates + ", " +
				"optionalEarlyTerminationExerciseDates=" + this.optionalEarlyTerminationExerciseDates + ", " +
				"optionalEarlyTerminationUnderlyingDates=" + this.optionalEarlyTerminationUnderlyingDates + ", " +
				"relevantUnderlyingDatesUnadjustedDates=" + this.relevantUnderlyingDatesUnadjustedDates + ", " +
				"optionalEarlyTerminationExerciseAdjustedDates=" + this.optionalEarlyTerminationExerciseAdjustedDates + ", " +
				"underlyingAssetId=" + this.underlyingAssetId + ", " +
				"underlyingAssetIdType=" + this.underlyingAssetIdType + ", " +
				"underlyingAssetName=" + this.underlyingAssetName + ", " +
				"mandatoryClearingJurisdiction=" + this.mandatoryClearingJurisdiction + ", " +
				"clearingSwapUsiId=" + this.clearingSwapUsiId + ", " +
				"clearingSwapUsiIdPrefix=" + this.clearingSwapUsiIdPrefix + ", " +
				"tradeParty1LocalCounterpartyJurisdiction=" + this.tradeParty1LocalCounterpartyJurisdiction + ", " +
				"tradeParty2LocalCounterpartyJurisdiction=" + this.tradeParty2LocalCounterpartyJurisdiction + ", " +
				"clearingExceptionTypeParty2=" + this.clearingExceptionTypeParty2 + ", " +
				"cdeOtherPaymentPayer=" + this.cdeOtherPaymentPayer + ", " +
				"cdeOtherPaymentReceiver=" + this.cdeOtherPaymentReceiver + ", " +
				"cdeOtherPaymentType=" + this.cdeOtherPaymentType + ", " +
				"cdeOtherPaymentAmount=" + this.cdeOtherPaymentAmount + ", " +
				"cdeOtherPaymentCurrency=" + this.cdeOtherPaymentCurrency + ", " +
				"cdeOtherPaymentDate=" + this.cdeOtherPaymentDate + ", " +
				"otherPaymentPayerIdType=" + this.otherPaymentPayerIdType + ", " +
				"otherPaymentReceiverIdType=" + this.otherPaymentReceiverIdType + ", " +
				"cdeEffectiveDateOfNotionalQuantityOfLeg1=" + this.cdeEffectiveDateOfNotionalQuantityOfLeg1 + ", " +
				"cdeEffectiveDateOfNotionalQuantityOfLeg2=" + this.cdeEffectiveDateOfNotionalQuantityOfLeg2 + ", " +
				"cdeEndDateOfNotionalQuantityOfLeg1=" + this.cdeEndDateOfNotionalQuantityOfLeg1 + ", " +
				"cdeEndDateOfNotionalQuantityOfLeg2=" + this.cdeEndDateOfNotionalQuantityOfLeg2 + ", " +
				"cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1=" + this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1 + ", " +
				"cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2=" + this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2 + ", " +
				"cdeBasketConstituentsIdentifier=" + this.cdeBasketConstituentsIdentifier + ", " +
				"cdeBasketConstituentsIdentifierSource=" + this.cdeBasketConstituentsIdentifierSource + ", " +
				"cdeBasketConstituentsNumberOfUnits=" + this.cdeBasketConstituentsNumberOfUnits + ", " +
				"cdeBasketConstituentsUnitOfMeasure=" + this.cdeBasketConstituentsUnitOfMeasure +
			'}';
		}
	}

	/*********************** Builder Implementation of HarmonizedRepeatableData  ***********************/
	class HarmonizedRepeatableDataBuilderImpl implements HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder {
	
		protected List<String> tradeParty1ReportingDestination = new ArrayList<>();
		protected List<String> tradeParty2ReportingDestination = new ArrayList<>();
		protected List<String> tradeParty1ThirdPartyViewerId = new ArrayList<>();
		protected List<String> tradeParty2ThirdPartyViewerId = new ArrayList<>();
		protected List<String> tradeParty1ThirdPartyViewerIdType = new ArrayList<>();
		protected List<String> tradeParty2ThirdPartyViewerIdType = new ArrayList<>();
		protected List<String> leg1QuantityUnit = new ArrayList<>();
		protected List<String> leg1QuantityFrequency = new ArrayList<>();
		protected List<BigDecimal> leg1Quantity = new ArrayList<>();
		protected List<String> deliveryPoint = new ArrayList<>();
		protected List<LocalTime> loadDeliveryIntervals = new ArrayList<>();
		protected List<ZonedDateTime> deliveryEndDateAndTime = new ArrayList<>();
		protected List<String> duration = new ArrayList<>();
		protected List<String> deliveryCapacity = new ArrayList<>();
		protected List<BigDecimal> priceTimeIntervalQuantities = new ArrayList<>();
		protected List<ZonedDateTime> deliveryStartDateAndTime = new ArrayList<>();
		protected List<String> quantityUnit = new ArrayList<>();
		protected List<BigDecimal> electricityPhysicalLegDeliveryStepQuantity = new ArrayList<>();
		protected List<String> electricityPhysicalLegDeliveryStepQuantityFrequency = new ArrayList<>();
		protected List<String> electricityPhysicalLegDeliveryStepQuantityUnit = new ArrayList<>();
		protected List<String> productGrade = new ArrayList<>();
		protected List<BigDecimal> basketWeightPercentage = new ArrayList<>();
		protected List<String> referenceObligationType = new ArrayList<>();
		protected List<String> underlyingAssetPlaceOfIncorporation = new ArrayList<>();
		protected List<String> underlyingAssetPlaceOfIssuance = new ArrayList<>();
		protected List<String> referenceEntityId = new ArrayList<>();
		protected List<String> referenceEntityIdType = new ArrayList<>();
		protected List<BigDecimal> underlyingAssetFixedRate = new ArrayList<>();
		protected List<String> underlyingAssetNotionalCurrency = new ArrayList<>();
		protected List<Date> periodStartDate = new ArrayList<>();
		protected List<Date> periodEndDate = new ArrayList<>();
		protected List<BigDecimal> periodFixedStrike = new ArrayList<>();
		protected List<BigDecimal> periodFixedAmount = new ArrayList<>();
		protected List<BigDecimal> underlyingAssetNotionalAmount = new ArrayList<>();
		protected List<Date> dividendPaymentDate = new ArrayList<>();
		protected List<Date> fixedAmountPaymentDate = new ArrayList<>();
		protected List<Date> leg1PaymentDates = new ArrayList<>();
		protected List<Date> leg2PaymentDates = new ArrayList<>();
		protected List<BigDecimal> underlyingAssetInitialPrice = new ArrayList<>();
		protected List<Date> cancelationOptionExerciseDates = new ArrayList<>();
		protected List<Date> cancelationOptionRelevantUnderlyingDates = new ArrayList<>();
		protected List<Date> capRateStepDate = new ArrayList<>();
		protected List<BigDecimal> capRateStepValues = new ArrayList<>();
		protected List<Date> exerciseDates = new ArrayList<>();
		protected List<Date> floorRateStepDate = new ArrayList<>();
		protected List<BigDecimal> floorRateStepValue = new ArrayList<>();
		protected List<Date> leg1FixedRateStepDate = new ArrayList<>();
		protected List<BigDecimal> leg1FixedRateStepValues = new ArrayList<>();
		protected List<Date> leg1FloatingRateMultiplierStepDate = new ArrayList<>();
		protected List<BigDecimal> leg1FloatingRateMultiplierStepValues = new ArrayList<>();
		protected List<Date> leg1FloatingRateSpreadStepDate = new ArrayList<>();
		protected List<BigDecimal> leg1FloatingRateSpreadStepValues = new ArrayList<>();
		protected List<Date> leg1NotionalStepDate = new ArrayList<>();
		protected List<BigDecimal> leg1NotionalStepValues = new ArrayList<>();
		protected List<Date> leg2FixedRateStepDate = new ArrayList<>();
		protected List<BigDecimal> leg2FixedRateStepValues = new ArrayList<>();
		protected List<Date> leg2FloatingRateMultiplierStepDate = new ArrayList<>();
		protected List<BigDecimal> leg2FloatingRateMultiplierStepValues = new ArrayList<>();
		protected List<Date> leg2FloatingRateSpreadStepDate = new ArrayList<>();
		protected List<BigDecimal> leg2FloatingRateSpreadStepValues = new ArrayList<>();
		protected List<Date> leg2NotionalStepDate = new ArrayList<>();
		protected List<BigDecimal> leg2NotionalStepValues = new ArrayList<>();
		protected List<Date> optionalEarlyTerminationDates = new ArrayList<>();
		protected List<Date> optionalEarlyTerminationExerciseDates = new ArrayList<>();
		protected List<Date> optionalEarlyTerminationUnderlyingDates = new ArrayList<>();
		protected List<Date> relevantUnderlyingDatesUnadjustedDates = new ArrayList<>();
		protected List<Date> optionalEarlyTerminationExerciseAdjustedDates = new ArrayList<>();
		protected List<String> underlyingAssetId = new ArrayList<>();
		protected List<String> underlyingAssetIdType = new ArrayList<>();
		protected List<String> underlyingAssetName = new ArrayList<>();
		protected List<String> mandatoryClearingJurisdiction = new ArrayList<>();
		protected List<String> clearingSwapUsiId = new ArrayList<>();
		protected List<String> clearingSwapUsiIdPrefix = new ArrayList<>();
		protected List<String> tradeParty1LocalCounterpartyJurisdiction = new ArrayList<>();
		protected List<String> tradeParty2LocalCounterpartyJurisdiction = new ArrayList<>();
		protected List<String> clearingExceptionTypeParty2 = new ArrayList<>();
		protected List<String> cdeOtherPaymentPayer = new ArrayList<>();
		protected List<String> cdeOtherPaymentReceiver = new ArrayList<>();
		protected List<String> cdeOtherPaymentType = new ArrayList<>();
		protected List<BigDecimal> cdeOtherPaymentAmount = new ArrayList<>();
		protected List<String> cdeOtherPaymentCurrency = new ArrayList<>();
		protected List<Date> cdeOtherPaymentDate = new ArrayList<>();
		protected List<String> otherPaymentPayerIdType = new ArrayList<>();
		protected List<String> otherPaymentReceiverIdType = new ArrayList<>();
		protected List<Date> cdeEffectiveDateOfNotionalQuantityOfLeg1 = new ArrayList<>();
		protected List<Date> cdeEffectiveDateOfNotionalQuantityOfLeg2 = new ArrayList<>();
		protected List<Date> cdeEndDateOfNotionalQuantityOfLeg1 = new ArrayList<>();
		protected List<Date> cdeEndDateOfNotionalQuantityOfLeg2 = new ArrayList<>();
		protected List<BigDecimal> cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1 = new ArrayList<>();
		protected List<BigDecimal> cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2 = new ArrayList<>();
		protected List<String> cdeBasketConstituentsIdentifier = new ArrayList<>();
		protected List<String> cdeBasketConstituentsIdentifierSource = new ArrayList<>();
		protected List<BigDecimal> cdeBasketConstituentsNumberOfUnits = new ArrayList<>();
		protected List<String> cdeBasketConstituentsUnitOfMeasure = new ArrayList<>();
		
		@Override
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		public List<String> getTradeParty1ReportingDestination() {
			return tradeParty1ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ReportingDestination")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2ReportingDestination")
		public List<String> getTradeParty2ReportingDestination() {
			return tradeParty2ReportingDestination;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ThirdPartyViewerId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerId")
		public List<String> getTradeParty1ThirdPartyViewerId() {
			return tradeParty1ThirdPartyViewerId;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ThirdPartyViewerId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerId")
		public List<String> getTradeParty2ThirdPartyViewerId() {
			return tradeParty2ThirdPartyViewerId;
		}
		
		@Override
		@RosettaAttribute("tradeParty1ThirdPartyViewerIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerIdType")
		public List<String> getTradeParty1ThirdPartyViewerIdType() {
			return tradeParty1ThirdPartyViewerIdType;
		}
		
		@Override
		@RosettaAttribute("tradeParty2ThirdPartyViewerIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerIdType")
		public List<String> getTradeParty2ThirdPartyViewerIdType() {
			return tradeParty2ThirdPartyViewerIdType;
		}
		
		@Override
		@RosettaAttribute("leg1QuantityUnit")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1QuantityUnit")
		public List<String> getLeg1QuantityUnit() {
			return leg1QuantityUnit;
		}
		
		@Override
		@RosettaAttribute("leg1QuantityFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1QuantityFrequency")
		public List<String> getLeg1QuantityFrequency() {
			return leg1QuantityFrequency;
		}
		
		@Override
		@RosettaAttribute("leg1Quantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1Quantity")
		public List<BigDecimal> getLeg1Quantity() {
			return leg1Quantity;
		}
		
		@Override
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("deliveryPoint")
		public List<String> getDeliveryPoint() {
			return deliveryPoint;
		}
		
		@Override
		@RosettaAttribute("loadDeliveryIntervals")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("loadDeliveryIntervals")
		public List<LocalTime> getLoadDeliveryIntervals() {
			return loadDeliveryIntervals;
		}
		
		@Override
		@RosettaAttribute("deliveryEndDateAndTime")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("deliveryEndDateAndTime")
		public List<ZonedDateTime> getDeliveryEndDateAndTime() {
			return deliveryEndDateAndTime;
		}
		
		@Override
		@RosettaAttribute("duration")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("duration")
		public List<String> getDuration() {
			return duration;
		}
		
		@Override
		@RosettaAttribute("deliveryCapacity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("deliveryCapacity")
		public List<String> getDeliveryCapacity() {
			return deliveryCapacity;
		}
		
		@Override
		@RosettaAttribute("priceTimeIntervalQuantities")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("priceTimeIntervalQuantities")
		public List<BigDecimal> getPriceTimeIntervalQuantities() {
			return priceTimeIntervalQuantities;
		}
		
		@Override
		@RosettaAttribute("deliveryStartDateAndTime")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("deliveryStartDateAndTime")
		public List<ZonedDateTime> getDeliveryStartDateAndTime() {
			return deliveryStartDateAndTime;
		}
		
		@Override
		@RosettaAttribute("quantityUnit")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quantityUnit")
		public List<String> getQuantityUnit() {
			return quantityUnit;
		}
		
		@Override
		@RosettaAttribute("electricityPhysicalLegDeliveryStepQuantity")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("electricityPhysicalLegDeliveryStepQuantity")
		public List<BigDecimal> getElectricityPhysicalLegDeliveryStepQuantity() {
			return electricityPhysicalLegDeliveryStepQuantity;
		}
		
		@Override
		@RosettaAttribute("electricityPhysicalLegDeliveryStepQuantityFrequency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("electricityPhysicalLegDeliveryStepQuantityFrequency")
		public List<String> getElectricityPhysicalLegDeliveryStepQuantityFrequency() {
			return electricityPhysicalLegDeliveryStepQuantityFrequency;
		}
		
		@Override
		@RosettaAttribute("electricityPhysicalLegDeliveryStepQuantityUnit")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("electricityPhysicalLegDeliveryStepQuantityUnit")
		public List<String> getElectricityPhysicalLegDeliveryStepQuantityUnit() {
			return electricityPhysicalLegDeliveryStepQuantityUnit;
		}
		
		@Override
		@RosettaAttribute("productGrade")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("productGrade")
		public List<String> getProductGrade() {
			return productGrade;
		}
		
		@Override
		@RosettaAttribute("basketWeightPercentage")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("basketWeightPercentage")
		public List<BigDecimal> getBasketWeightPercentage() {
			return basketWeightPercentage;
		}
		
		@Override
		@RosettaAttribute("referenceObligationType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("referenceObligationType")
		public List<String> getReferenceObligationType() {
			return referenceObligationType;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetPlaceOfIncorporation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetPlaceOfIncorporation")
		public List<String> getUnderlyingAssetPlaceOfIncorporation() {
			return underlyingAssetPlaceOfIncorporation;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetPlaceOfIssuance")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetPlaceOfIssuance")
		public List<String> getUnderlyingAssetPlaceOfIssuance() {
			return underlyingAssetPlaceOfIssuance;
		}
		
		@Override
		@RosettaAttribute("referenceEntityId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("referenceEntityId")
		public List<String> getReferenceEntityId() {
			return referenceEntityId;
		}
		
		@Override
		@RosettaAttribute("referenceEntityIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("referenceEntityIdType")
		public List<String> getReferenceEntityIdType() {
			return referenceEntityIdType;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetFixedRate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetFixedRate")
		public List<BigDecimal> getUnderlyingAssetFixedRate() {
			return underlyingAssetFixedRate;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetNotionalCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetNotionalCurrency")
		public List<String> getUnderlyingAssetNotionalCurrency() {
			return underlyingAssetNotionalCurrency;
		}
		
		@Override
		@RosettaAttribute("periodStartDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("periodStartDate")
		public List<Date> getPeriodStartDate() {
			return periodStartDate;
		}
		
		@Override
		@RosettaAttribute("periodEndDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("periodEndDate")
		public List<Date> getPeriodEndDate() {
			return periodEndDate;
		}
		
		@Override
		@RosettaAttribute("periodFixedStrike")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("periodFixedStrike")
		public List<BigDecimal> getPeriodFixedStrike() {
			return periodFixedStrike;
		}
		
		@Override
		@RosettaAttribute("periodFixedAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("periodFixedAmount")
		public List<BigDecimal> getPeriodFixedAmount() {
			return periodFixedAmount;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetNotionalAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetNotionalAmount")
		public List<BigDecimal> getUnderlyingAssetNotionalAmount() {
			return underlyingAssetNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("dividendPaymentDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("dividendPaymentDate")
		public List<Date> getDividendPaymentDate() {
			return dividendPaymentDate;
		}
		
		@Override
		@RosettaAttribute("fixedAmountPaymentDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixedAmountPaymentDate")
		public List<Date> getFixedAmountPaymentDate() {
			return fixedAmountPaymentDate;
		}
		
		@Override
		@RosettaAttribute("leg1PaymentDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1PaymentDates")
		public List<Date> getLeg1PaymentDates() {
			return leg1PaymentDates;
		}
		
		@Override
		@RosettaAttribute("leg2PaymentDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2PaymentDates")
		public List<Date> getLeg2PaymentDates() {
			return leg2PaymentDates;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetInitialPrice")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetInitialPrice")
		public List<BigDecimal> getUnderlyingAssetInitialPrice() {
			return underlyingAssetInitialPrice;
		}
		
		@Override
		@RosettaAttribute("cancelationOptionExerciseDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cancelationOptionExerciseDates")
		public List<Date> getCancelationOptionExerciseDates() {
			return cancelationOptionExerciseDates;
		}
		
		@Override
		@RosettaAttribute("cancelationOptionRelevantUnderlyingDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cancelationOptionRelevantUnderlyingDates")
		public List<Date> getCancelationOptionRelevantUnderlyingDates() {
			return cancelationOptionRelevantUnderlyingDates;
		}
		
		@Override
		@RosettaAttribute("capRateStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("capRateStepDate")
		public List<Date> getCapRateStepDate() {
			return capRateStepDate;
		}
		
		@Override
		@RosettaAttribute("capRateStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("capRateStepValues")
		public List<BigDecimal> getCapRateStepValues() {
			return capRateStepValues;
		}
		
		@Override
		@RosettaAttribute("exerciseDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("exerciseDates")
		public List<Date> getExerciseDates() {
			return exerciseDates;
		}
		
		@Override
		@RosettaAttribute("floorRateStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("floorRateStepDate")
		public List<Date> getFloorRateStepDate() {
			return floorRateStepDate;
		}
		
		@Override
		@RosettaAttribute("floorRateStepValue")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("floorRateStepValue")
		public List<BigDecimal> getFloorRateStepValue() {
			return floorRateStepValue;
		}
		
		@Override
		@RosettaAttribute("leg1FixedRateStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1FixedRateStepDate")
		public List<Date> getLeg1FixedRateStepDate() {
			return leg1FixedRateStepDate;
		}
		
		@Override
		@RosettaAttribute("leg1FixedRateStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1FixedRateStepValues")
		public List<BigDecimal> getLeg1FixedRateStepValues() {
			return leg1FixedRateStepValues;
		}
		
		@Override
		@RosettaAttribute("leg1FloatingRateMultiplierStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1FloatingRateMultiplierStepDate")
		public List<Date> getLeg1FloatingRateMultiplierStepDate() {
			return leg1FloatingRateMultiplierStepDate;
		}
		
		@Override
		@RosettaAttribute("leg1FloatingRateMultiplierStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1FloatingRateMultiplierStepValues")
		public List<BigDecimal> getLeg1FloatingRateMultiplierStepValues() {
			return leg1FloatingRateMultiplierStepValues;
		}
		
		@Override
		@RosettaAttribute("leg1FloatingRateSpreadStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1FloatingRateSpreadStepDate")
		public List<Date> getLeg1FloatingRateSpreadStepDate() {
			return leg1FloatingRateSpreadStepDate;
		}
		
		@Override
		@RosettaAttribute("leg1FloatingRateSpreadStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1FloatingRateSpreadStepValues")
		public List<BigDecimal> getLeg1FloatingRateSpreadStepValues() {
			return leg1FloatingRateSpreadStepValues;
		}
		
		@Override
		@RosettaAttribute("leg1NotionalStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1NotionalStepDate")
		public List<Date> getLeg1NotionalStepDate() {
			return leg1NotionalStepDate;
		}
		
		@Override
		@RosettaAttribute("leg1NotionalStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg1NotionalStepValues")
		public List<BigDecimal> getLeg1NotionalStepValues() {
			return leg1NotionalStepValues;
		}
		
		@Override
		@RosettaAttribute("leg2FixedRateStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2FixedRateStepDate")
		public List<Date> getLeg2FixedRateStepDate() {
			return leg2FixedRateStepDate;
		}
		
		@Override
		@RosettaAttribute("leg2FixedRateStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2FixedRateStepValues")
		public List<BigDecimal> getLeg2FixedRateStepValues() {
			return leg2FixedRateStepValues;
		}
		
		@Override
		@RosettaAttribute("leg2FloatingRateMultiplierStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2FloatingRateMultiplierStepDate")
		public List<Date> getLeg2FloatingRateMultiplierStepDate() {
			return leg2FloatingRateMultiplierStepDate;
		}
		
		@Override
		@RosettaAttribute("leg2FloatingRateMultiplierStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2FloatingRateMultiplierStepValues")
		public List<BigDecimal> getLeg2FloatingRateMultiplierStepValues() {
			return leg2FloatingRateMultiplierStepValues;
		}
		
		@Override
		@RosettaAttribute("leg2FloatingRateSpreadStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2FloatingRateSpreadStepDate")
		public List<Date> getLeg2FloatingRateSpreadStepDate() {
			return leg2FloatingRateSpreadStepDate;
		}
		
		@Override
		@RosettaAttribute("leg2FloatingRateSpreadStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2FloatingRateSpreadStepValues")
		public List<BigDecimal> getLeg2FloatingRateSpreadStepValues() {
			return leg2FloatingRateSpreadStepValues;
		}
		
		@Override
		@RosettaAttribute("leg2NotionalStepDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2NotionalStepDate")
		public List<Date> getLeg2NotionalStepDate() {
			return leg2NotionalStepDate;
		}
		
		@Override
		@RosettaAttribute("leg2NotionalStepValues")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("leg2NotionalStepValues")
		public List<BigDecimal> getLeg2NotionalStepValues() {
			return leg2NotionalStepValues;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationDates")
		public List<Date> getOptionalEarlyTerminationDates() {
			return optionalEarlyTerminationDates;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationExerciseDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationExerciseDates")
		public List<Date> getOptionalEarlyTerminationExerciseDates() {
			return optionalEarlyTerminationExerciseDates;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationUnderlyingDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationUnderlyingDates")
		public List<Date> getOptionalEarlyTerminationUnderlyingDates() {
			return optionalEarlyTerminationUnderlyingDates;
		}
		
		@Override
		@RosettaAttribute("relevantUnderlyingDatesUnadjustedDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("relevantUnderlyingDatesUnadjustedDates")
		public List<Date> getRelevantUnderlyingDatesUnadjustedDates() {
			return relevantUnderlyingDatesUnadjustedDates;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationExerciseAdjustedDates")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationExerciseAdjustedDates")
		public List<Date> getOptionalEarlyTerminationExerciseAdjustedDates() {
			return optionalEarlyTerminationExerciseAdjustedDates;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetId")
		public List<String> getUnderlyingAssetId() {
			return underlyingAssetId;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetIdType")
		public List<String> getUnderlyingAssetIdType() {
			return underlyingAssetIdType;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetName")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyingAssetName")
		public List<String> getUnderlyingAssetName() {
			return underlyingAssetName;
		}
		
		@Override
		@RosettaAttribute("mandatoryClearingJurisdiction")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("mandatoryClearingJurisdiction")
		public List<String> getMandatoryClearingJurisdiction() {
			return mandatoryClearingJurisdiction;
		}
		
		@Override
		@RosettaAttribute("clearingSwapUsiId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingSwapUsiId")
		public List<String> getClearingSwapUsiId() {
			return clearingSwapUsiId;
		}
		
		@Override
		@RosettaAttribute("clearingSwapUsiIdPrefix")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingSwapUsiIdPrefix")
		public List<String> getClearingSwapUsiIdPrefix() {
			return clearingSwapUsiIdPrefix;
		}
		
		@Override
		@RosettaAttribute("tradeParty1LocalCounterpartyJurisdiction")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty1LocalCounterpartyJurisdiction")
		public List<String> getTradeParty1LocalCounterpartyJurisdiction() {
			return tradeParty1LocalCounterpartyJurisdiction;
		}
		
		@Override
		@RosettaAttribute("tradeParty2LocalCounterpartyJurisdiction")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeParty2LocalCounterpartyJurisdiction")
		public List<String> getTradeParty2LocalCounterpartyJurisdiction() {
			return tradeParty2LocalCounterpartyJurisdiction;
		}
		
		@Override
		@RosettaAttribute("clearingExceptionTypeParty2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingExceptionTypeParty2")
		public List<String> getClearingExceptionTypeParty2() {
			return clearingExceptionTypeParty2;
		}
		
		@Override
		@RosettaAttribute("cdeOtherPaymentPayer")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentPayer")
		public List<String> getCdeOtherPaymentPayer() {
			return cdeOtherPaymentPayer;
		}
		
		@Override
		@RosettaAttribute("cdeOtherPaymentReceiver")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentReceiver")
		public List<String> getCdeOtherPaymentReceiver() {
			return cdeOtherPaymentReceiver;
		}
		
		@Override
		@RosettaAttribute("cdeOtherPaymentType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentType")
		public List<String> getCdeOtherPaymentType() {
			return cdeOtherPaymentType;
		}
		
		@Override
		@RosettaAttribute("cdeOtherPaymentAmount")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentAmount")
		public List<BigDecimal> getCdeOtherPaymentAmount() {
			return cdeOtherPaymentAmount;
		}
		
		@Override
		@RosettaAttribute("cdeOtherPaymentCurrency")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentCurrency")
		public List<String> getCdeOtherPaymentCurrency() {
			return cdeOtherPaymentCurrency;
		}
		
		@Override
		@RosettaAttribute("cdeOtherPaymentDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentDate")
		public List<Date> getCdeOtherPaymentDate() {
			return cdeOtherPaymentDate;
		}
		
		@Override
		@RosettaAttribute("otherPaymentPayerIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPaymentPayerIdType")
		public List<String> getOtherPaymentPayerIdType() {
			return otherPaymentPayerIdType;
		}
		
		@Override
		@RosettaAttribute("otherPaymentReceiverIdType")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("otherPaymentReceiverIdType")
		public List<String> getOtherPaymentReceiverIdType() {
			return otherPaymentReceiverIdType;
		}
		
		@Override
		@RosettaAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg1")
		public List<Date> getCdeEffectiveDateOfNotionalQuantityOfLeg1() {
			return cdeEffectiveDateOfNotionalQuantityOfLeg1;
		}
		
		@Override
		@RosettaAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg2")
		public List<Date> getCdeEffectiveDateOfNotionalQuantityOfLeg2() {
			return cdeEffectiveDateOfNotionalQuantityOfLeg2;
		}
		
		@Override
		@RosettaAttribute("cdeEndDateOfNotionalQuantityOfLeg1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeEndDateOfNotionalQuantityOfLeg1")
		public List<Date> getCdeEndDateOfNotionalQuantityOfLeg1() {
			return cdeEndDateOfNotionalQuantityOfLeg1;
		}
		
		@Override
		@RosettaAttribute("cdeEndDateOfNotionalQuantityOfLeg2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeEndDateOfNotionalQuantityOfLeg2")
		public List<Date> getCdeEndDateOfNotionalQuantityOfLeg2() {
			return cdeEndDateOfNotionalQuantityOfLeg2;
		}
		
		@Override
		@RosettaAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1")
		public List<BigDecimal> getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1() {
			return cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1;
		}
		
		@Override
		@RosettaAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2")
		public List<BigDecimal> getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2() {
			return cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2;
		}
		
		@Override
		@RosettaAttribute("cdeBasketConstituentsIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsIdentifier")
		public List<String> getCdeBasketConstituentsIdentifier() {
			return cdeBasketConstituentsIdentifier;
		}
		
		@Override
		@RosettaAttribute("cdeBasketConstituentsIdentifierSource")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsIdentifierSource")
		public List<String> getCdeBasketConstituentsIdentifierSource() {
			return cdeBasketConstituentsIdentifierSource;
		}
		
		@Override
		@RosettaAttribute("cdeBasketConstituentsNumberOfUnits")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsNumberOfUnits")
		public List<BigDecimal> getCdeBasketConstituentsNumberOfUnits() {
			return cdeBasketConstituentsNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("cdeBasketConstituentsUnitOfMeasure")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsUnitOfMeasure")
		public List<String> getCdeBasketConstituentsUnitOfMeasure() {
			return cdeBasketConstituentsUnitOfMeasure;
		}
		
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ReportingDestination(String _tradeParty1ReportingDestination) {
			if (_tradeParty1ReportingDestination != null) {
				this.tradeParty1ReportingDestination.add(_tradeParty1ReportingDestination);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ReportingDestination(String _tradeParty1ReportingDestination, int idx) {
			getIndex(this.tradeParty1ReportingDestination, idx, () -> _tradeParty1ReportingDestination);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ReportingDestination(List<String> tradeParty1ReportingDestinations) {
			if (tradeParty1ReportingDestinations != null) {
				for (final String toAdd : tradeParty1ReportingDestinations) {
					this.tradeParty1ReportingDestination.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1ReportingDestination")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty1ReportingDestination")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty1ReportingDestination(List<String> tradeParty1ReportingDestinations) {
			if (tradeParty1ReportingDestinations == null) {
				this.tradeParty1ReportingDestination = new ArrayList<>();
			} else {
				this.tradeParty1ReportingDestination = tradeParty1ReportingDestinations.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2ReportingDestination")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty2ReportingDestination")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ReportingDestination(String _tradeParty2ReportingDestination) {
			if (_tradeParty2ReportingDestination != null) {
				this.tradeParty2ReportingDestination.add(_tradeParty2ReportingDestination);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ReportingDestination(String _tradeParty2ReportingDestination, int idx) {
			getIndex(this.tradeParty2ReportingDestination, idx, () -> _tradeParty2ReportingDestination);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ReportingDestination(List<String> tradeParty2ReportingDestinations) {
			if (tradeParty2ReportingDestinations != null) {
				for (final String toAdd : tradeParty2ReportingDestinations) {
					this.tradeParty2ReportingDestination.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2ReportingDestination")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty2ReportingDestination")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty2ReportingDestination(List<String> tradeParty2ReportingDestinations) {
			if (tradeParty2ReportingDestinations == null) {
				this.tradeParty2ReportingDestination = new ArrayList<>();
			} else {
				this.tradeParty2ReportingDestination = tradeParty2ReportingDestinations.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1ThirdPartyViewerId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerId")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ThirdPartyViewerId(String _tradeParty1ThirdPartyViewerId) {
			if (_tradeParty1ThirdPartyViewerId != null) {
				this.tradeParty1ThirdPartyViewerId.add(_tradeParty1ThirdPartyViewerId);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ThirdPartyViewerId(String _tradeParty1ThirdPartyViewerId, int idx) {
			getIndex(this.tradeParty1ThirdPartyViewerId, idx, () -> _tradeParty1ThirdPartyViewerId);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ThirdPartyViewerId(List<String> tradeParty1ThirdPartyViewerIds) {
			if (tradeParty1ThirdPartyViewerIds != null) {
				for (final String toAdd : tradeParty1ThirdPartyViewerIds) {
					this.tradeParty1ThirdPartyViewerId.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1ThirdPartyViewerId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerId")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty1ThirdPartyViewerId(List<String> tradeParty1ThirdPartyViewerIds) {
			if (tradeParty1ThirdPartyViewerIds == null) {
				this.tradeParty1ThirdPartyViewerId = new ArrayList<>();
			} else {
				this.tradeParty1ThirdPartyViewerId = tradeParty1ThirdPartyViewerIds.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2ThirdPartyViewerId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerId")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ThirdPartyViewerId(String _tradeParty2ThirdPartyViewerId) {
			if (_tradeParty2ThirdPartyViewerId != null) {
				this.tradeParty2ThirdPartyViewerId.add(_tradeParty2ThirdPartyViewerId);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ThirdPartyViewerId(String _tradeParty2ThirdPartyViewerId, int idx) {
			getIndex(this.tradeParty2ThirdPartyViewerId, idx, () -> _tradeParty2ThirdPartyViewerId);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ThirdPartyViewerId(List<String> tradeParty2ThirdPartyViewerIds) {
			if (tradeParty2ThirdPartyViewerIds != null) {
				for (final String toAdd : tradeParty2ThirdPartyViewerIds) {
					this.tradeParty2ThirdPartyViewerId.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2ThirdPartyViewerId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerId")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty2ThirdPartyViewerId(List<String> tradeParty2ThirdPartyViewerIds) {
			if (tradeParty2ThirdPartyViewerIds == null) {
				this.tradeParty2ThirdPartyViewerId = new ArrayList<>();
			} else {
				this.tradeParty2ThirdPartyViewerId = tradeParty2ThirdPartyViewerIds.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1ThirdPartyViewerIdType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerIdType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ThirdPartyViewerIdType(String _tradeParty1ThirdPartyViewerIdType) {
			if (_tradeParty1ThirdPartyViewerIdType != null) {
				this.tradeParty1ThirdPartyViewerIdType.add(_tradeParty1ThirdPartyViewerIdType);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ThirdPartyViewerIdType(String _tradeParty1ThirdPartyViewerIdType, int idx) {
			getIndex(this.tradeParty1ThirdPartyViewerIdType, idx, () -> _tradeParty1ThirdPartyViewerIdType);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1ThirdPartyViewerIdType(List<String> tradeParty1ThirdPartyViewerIdTypes) {
			if (tradeParty1ThirdPartyViewerIdTypes != null) {
				for (final String toAdd : tradeParty1ThirdPartyViewerIdTypes) {
					this.tradeParty1ThirdPartyViewerIdType.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1ThirdPartyViewerIdType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty1ThirdPartyViewerIdType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty1ThirdPartyViewerIdType(List<String> tradeParty1ThirdPartyViewerIdTypes) {
			if (tradeParty1ThirdPartyViewerIdTypes == null) {
				this.tradeParty1ThirdPartyViewerIdType = new ArrayList<>();
			} else {
				this.tradeParty1ThirdPartyViewerIdType = tradeParty1ThirdPartyViewerIdTypes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2ThirdPartyViewerIdType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerIdType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ThirdPartyViewerIdType(String _tradeParty2ThirdPartyViewerIdType) {
			if (_tradeParty2ThirdPartyViewerIdType != null) {
				this.tradeParty2ThirdPartyViewerIdType.add(_tradeParty2ThirdPartyViewerIdType);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ThirdPartyViewerIdType(String _tradeParty2ThirdPartyViewerIdType, int idx) {
			getIndex(this.tradeParty2ThirdPartyViewerIdType, idx, () -> _tradeParty2ThirdPartyViewerIdType);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2ThirdPartyViewerIdType(List<String> tradeParty2ThirdPartyViewerIdTypes) {
			if (tradeParty2ThirdPartyViewerIdTypes != null) {
				for (final String toAdd : tradeParty2ThirdPartyViewerIdTypes) {
					this.tradeParty2ThirdPartyViewerIdType.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2ThirdPartyViewerIdType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty2ThirdPartyViewerIdType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty2ThirdPartyViewerIdType(List<String> tradeParty2ThirdPartyViewerIdTypes) {
			if (tradeParty2ThirdPartyViewerIdTypes == null) {
				this.tradeParty2ThirdPartyViewerIdType = new ArrayList<>();
			} else {
				this.tradeParty2ThirdPartyViewerIdType = tradeParty2ThirdPartyViewerIdTypes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1QuantityUnit")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg1QuantityUnit")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1QuantityUnit(String _leg1QuantityUnit) {
			if (_leg1QuantityUnit != null) {
				this.leg1QuantityUnit.add(_leg1QuantityUnit);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1QuantityUnit(String _leg1QuantityUnit, int idx) {
			getIndex(this.leg1QuantityUnit, idx, () -> _leg1QuantityUnit);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1QuantityUnit(List<String> leg1QuantityUnits) {
			if (leg1QuantityUnits != null) {
				for (final String toAdd : leg1QuantityUnits) {
					this.leg1QuantityUnit.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg1QuantityUnit")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg1QuantityUnit")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1QuantityUnit(List<String> leg1QuantityUnits) {
			if (leg1QuantityUnits == null) {
				this.leg1QuantityUnit = new ArrayList<>();
			} else {
				this.leg1QuantityUnit = leg1QuantityUnits.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1QuantityFrequency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg1QuantityFrequency")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1QuantityFrequency(String _leg1QuantityFrequency) {
			if (_leg1QuantityFrequency != null) {
				this.leg1QuantityFrequency.add(_leg1QuantityFrequency);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1QuantityFrequency(String _leg1QuantityFrequency, int idx) {
			getIndex(this.leg1QuantityFrequency, idx, () -> _leg1QuantityFrequency);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1QuantityFrequency(List<String> leg1QuantityFrequencys) {
			if (leg1QuantityFrequencys != null) {
				for (final String toAdd : leg1QuantityFrequencys) {
					this.leg1QuantityFrequency.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg1QuantityFrequency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg1QuantityFrequency")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1QuantityFrequency(List<String> leg1QuantityFrequencys) {
			if (leg1QuantityFrequencys == null) {
				this.leg1QuantityFrequency = new ArrayList<>();
			} else {
				this.leg1QuantityFrequency = leg1QuantityFrequencys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1Quantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg1Quantity")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1Quantity(BigDecimal _leg1Quantity) {
			if (_leg1Quantity != null) {
				this.leg1Quantity.add(_leg1Quantity);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1Quantity(BigDecimal _leg1Quantity, int idx) {
			getIndex(this.leg1Quantity, idx, () -> _leg1Quantity);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1Quantity(List<BigDecimal> leg1Quantitys) {
			if (leg1Quantitys != null) {
				for (final BigDecimal toAdd : leg1Quantitys) {
					this.leg1Quantity.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg1Quantity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg1Quantity")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1Quantity(List<BigDecimal> leg1Quantitys) {
			if (leg1Quantitys == null) {
				this.leg1Quantity = new ArrayList<>();
			} else {
				this.leg1Quantity = leg1Quantitys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("deliveryPoint")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryPoint(String _deliveryPoint) {
			if (_deliveryPoint != null) {
				this.deliveryPoint.add(_deliveryPoint);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryPoint(String _deliveryPoint, int idx) {
			getIndex(this.deliveryPoint, idx, () -> _deliveryPoint);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryPoint(List<String> deliveryPoints) {
			if (deliveryPoints != null) {
				for (final String toAdd : deliveryPoints) {
					this.deliveryPoint.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("deliveryPoint")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("deliveryPoint")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setDeliveryPoint(List<String> deliveryPoints) {
			if (deliveryPoints == null) {
				this.deliveryPoint = new ArrayList<>();
			} else {
				this.deliveryPoint = deliveryPoints.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("loadDeliveryIntervals")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("loadDeliveryIntervals")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLoadDeliveryIntervals(LocalTime _loadDeliveryIntervals) {
			if (_loadDeliveryIntervals != null) {
				this.loadDeliveryIntervals.add(_loadDeliveryIntervals);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLoadDeliveryIntervals(LocalTime _loadDeliveryIntervals, int idx) {
			getIndex(this.loadDeliveryIntervals, idx, () -> _loadDeliveryIntervals);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLoadDeliveryIntervals(List<LocalTime> loadDeliveryIntervalss) {
			if (loadDeliveryIntervalss != null) {
				for (final LocalTime toAdd : loadDeliveryIntervalss) {
					this.loadDeliveryIntervals.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("loadDeliveryIntervals")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("loadDeliveryIntervals")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLoadDeliveryIntervals(List<LocalTime> loadDeliveryIntervalss) {
			if (loadDeliveryIntervalss == null) {
				this.loadDeliveryIntervals = new ArrayList<>();
			} else {
				this.loadDeliveryIntervals = loadDeliveryIntervalss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("deliveryEndDateAndTime")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("deliveryEndDateAndTime")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryEndDateAndTime(ZonedDateTime _deliveryEndDateAndTime) {
			if (_deliveryEndDateAndTime != null) {
				this.deliveryEndDateAndTime.add(_deliveryEndDateAndTime);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryEndDateAndTime(ZonedDateTime _deliveryEndDateAndTime, int idx) {
			getIndex(this.deliveryEndDateAndTime, idx, () -> _deliveryEndDateAndTime);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryEndDateAndTime(List<ZonedDateTime> deliveryEndDateAndTimes) {
			if (deliveryEndDateAndTimes != null) {
				for (final ZonedDateTime toAdd : deliveryEndDateAndTimes) {
					this.deliveryEndDateAndTime.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("deliveryEndDateAndTime")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("deliveryEndDateAndTime")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setDeliveryEndDateAndTime(List<ZonedDateTime> deliveryEndDateAndTimes) {
			if (deliveryEndDateAndTimes == null) {
				this.deliveryEndDateAndTime = new ArrayList<>();
			} else {
				this.deliveryEndDateAndTime = deliveryEndDateAndTimes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("duration")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("duration")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDuration(String _duration) {
			if (_duration != null) {
				this.duration.add(_duration);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDuration(String _duration, int idx) {
			getIndex(this.duration, idx, () -> _duration);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDuration(List<String> durations) {
			if (durations != null) {
				for (final String toAdd : durations) {
					this.duration.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("duration")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("duration")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setDuration(List<String> durations) {
			if (durations == null) {
				this.duration = new ArrayList<>();
			} else {
				this.duration = durations.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("deliveryCapacity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("deliveryCapacity")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryCapacity(String _deliveryCapacity) {
			if (_deliveryCapacity != null) {
				this.deliveryCapacity.add(_deliveryCapacity);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryCapacity(String _deliveryCapacity, int idx) {
			getIndex(this.deliveryCapacity, idx, () -> _deliveryCapacity);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryCapacity(List<String> deliveryCapacitys) {
			if (deliveryCapacitys != null) {
				for (final String toAdd : deliveryCapacitys) {
					this.deliveryCapacity.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("deliveryCapacity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("deliveryCapacity")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setDeliveryCapacity(List<String> deliveryCapacitys) {
			if (deliveryCapacitys == null) {
				this.deliveryCapacity = new ArrayList<>();
			} else {
				this.deliveryCapacity = deliveryCapacitys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("priceTimeIntervalQuantities")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("priceTimeIntervalQuantities")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPriceTimeIntervalQuantities(BigDecimal _priceTimeIntervalQuantities) {
			if (_priceTimeIntervalQuantities != null) {
				this.priceTimeIntervalQuantities.add(_priceTimeIntervalQuantities);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPriceTimeIntervalQuantities(BigDecimal _priceTimeIntervalQuantities, int idx) {
			getIndex(this.priceTimeIntervalQuantities, idx, () -> _priceTimeIntervalQuantities);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPriceTimeIntervalQuantities(List<BigDecimal> priceTimeIntervalQuantitiess) {
			if (priceTimeIntervalQuantitiess != null) {
				for (final BigDecimal toAdd : priceTimeIntervalQuantitiess) {
					this.priceTimeIntervalQuantities.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("priceTimeIntervalQuantities")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("priceTimeIntervalQuantities")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setPriceTimeIntervalQuantities(List<BigDecimal> priceTimeIntervalQuantitiess) {
			if (priceTimeIntervalQuantitiess == null) {
				this.priceTimeIntervalQuantities = new ArrayList<>();
			} else {
				this.priceTimeIntervalQuantities = priceTimeIntervalQuantitiess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("deliveryStartDateAndTime")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("deliveryStartDateAndTime")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryStartDateAndTime(ZonedDateTime _deliveryStartDateAndTime) {
			if (_deliveryStartDateAndTime != null) {
				this.deliveryStartDateAndTime.add(_deliveryStartDateAndTime);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryStartDateAndTime(ZonedDateTime _deliveryStartDateAndTime, int idx) {
			getIndex(this.deliveryStartDateAndTime, idx, () -> _deliveryStartDateAndTime);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDeliveryStartDateAndTime(List<ZonedDateTime> deliveryStartDateAndTimes) {
			if (deliveryStartDateAndTimes != null) {
				for (final ZonedDateTime toAdd : deliveryStartDateAndTimes) {
					this.deliveryStartDateAndTime.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("deliveryStartDateAndTime")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("deliveryStartDateAndTime")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setDeliveryStartDateAndTime(List<ZonedDateTime> deliveryStartDateAndTimes) {
			if (deliveryStartDateAndTimes == null) {
				this.deliveryStartDateAndTime = new ArrayList<>();
			} else {
				this.deliveryStartDateAndTime = deliveryStartDateAndTimes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("quantityUnit")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quantityUnit")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addQuantityUnit(String _quantityUnit) {
			if (_quantityUnit != null) {
				this.quantityUnit.add(_quantityUnit);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addQuantityUnit(String _quantityUnit, int idx) {
			getIndex(this.quantityUnit, idx, () -> _quantityUnit);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addQuantityUnit(List<String> quantityUnits) {
			if (quantityUnits != null) {
				for (final String toAdd : quantityUnits) {
					this.quantityUnit.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("quantityUnit")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("quantityUnit")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setQuantityUnit(List<String> quantityUnits) {
			if (quantityUnits == null) {
				this.quantityUnit = new ArrayList<>();
			} else {
				this.quantityUnit = quantityUnits.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("electricityPhysicalLegDeliveryStepQuantity")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("electricityPhysicalLegDeliveryStepQuantity")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantity(BigDecimal _electricityPhysicalLegDeliveryStepQuantity) {
			if (_electricityPhysicalLegDeliveryStepQuantity != null) {
				this.electricityPhysicalLegDeliveryStepQuantity.add(_electricityPhysicalLegDeliveryStepQuantity);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantity(BigDecimal _electricityPhysicalLegDeliveryStepQuantity, int idx) {
			getIndex(this.electricityPhysicalLegDeliveryStepQuantity, idx, () -> _electricityPhysicalLegDeliveryStepQuantity);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantity(List<BigDecimal> electricityPhysicalLegDeliveryStepQuantitys) {
			if (electricityPhysicalLegDeliveryStepQuantitys != null) {
				for (final BigDecimal toAdd : electricityPhysicalLegDeliveryStepQuantitys) {
					this.electricityPhysicalLegDeliveryStepQuantity.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("electricityPhysicalLegDeliveryStepQuantity")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("electricityPhysicalLegDeliveryStepQuantity")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setElectricityPhysicalLegDeliveryStepQuantity(List<BigDecimal> electricityPhysicalLegDeliveryStepQuantitys) {
			if (electricityPhysicalLegDeliveryStepQuantitys == null) {
				this.electricityPhysicalLegDeliveryStepQuantity = new ArrayList<>();
			} else {
				this.electricityPhysicalLegDeliveryStepQuantity = electricityPhysicalLegDeliveryStepQuantitys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("electricityPhysicalLegDeliveryStepQuantityFrequency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("electricityPhysicalLegDeliveryStepQuantityFrequency")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantityFrequency(String _electricityPhysicalLegDeliveryStepQuantityFrequency) {
			if (_electricityPhysicalLegDeliveryStepQuantityFrequency != null) {
				this.electricityPhysicalLegDeliveryStepQuantityFrequency.add(_electricityPhysicalLegDeliveryStepQuantityFrequency);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantityFrequency(String _electricityPhysicalLegDeliveryStepQuantityFrequency, int idx) {
			getIndex(this.electricityPhysicalLegDeliveryStepQuantityFrequency, idx, () -> _electricityPhysicalLegDeliveryStepQuantityFrequency);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantityFrequency(List<String> electricityPhysicalLegDeliveryStepQuantityFrequencys) {
			if (electricityPhysicalLegDeliveryStepQuantityFrequencys != null) {
				for (final String toAdd : electricityPhysicalLegDeliveryStepQuantityFrequencys) {
					this.electricityPhysicalLegDeliveryStepQuantityFrequency.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("electricityPhysicalLegDeliveryStepQuantityFrequency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("electricityPhysicalLegDeliveryStepQuantityFrequency")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setElectricityPhysicalLegDeliveryStepQuantityFrequency(List<String> electricityPhysicalLegDeliveryStepQuantityFrequencys) {
			if (electricityPhysicalLegDeliveryStepQuantityFrequencys == null) {
				this.electricityPhysicalLegDeliveryStepQuantityFrequency = new ArrayList<>();
			} else {
				this.electricityPhysicalLegDeliveryStepQuantityFrequency = electricityPhysicalLegDeliveryStepQuantityFrequencys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("electricityPhysicalLegDeliveryStepQuantityUnit")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("electricityPhysicalLegDeliveryStepQuantityUnit")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantityUnit(String _electricityPhysicalLegDeliveryStepQuantityUnit) {
			if (_electricityPhysicalLegDeliveryStepQuantityUnit != null) {
				this.electricityPhysicalLegDeliveryStepQuantityUnit.add(_electricityPhysicalLegDeliveryStepQuantityUnit);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantityUnit(String _electricityPhysicalLegDeliveryStepQuantityUnit, int idx) {
			getIndex(this.electricityPhysicalLegDeliveryStepQuantityUnit, idx, () -> _electricityPhysicalLegDeliveryStepQuantityUnit);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addElectricityPhysicalLegDeliveryStepQuantityUnit(List<String> electricityPhysicalLegDeliveryStepQuantityUnits) {
			if (electricityPhysicalLegDeliveryStepQuantityUnits != null) {
				for (final String toAdd : electricityPhysicalLegDeliveryStepQuantityUnits) {
					this.electricityPhysicalLegDeliveryStepQuantityUnit.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("electricityPhysicalLegDeliveryStepQuantityUnit")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("electricityPhysicalLegDeliveryStepQuantityUnit")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setElectricityPhysicalLegDeliveryStepQuantityUnit(List<String> electricityPhysicalLegDeliveryStepQuantityUnits) {
			if (electricityPhysicalLegDeliveryStepQuantityUnits == null) {
				this.electricityPhysicalLegDeliveryStepQuantityUnit = new ArrayList<>();
			} else {
				this.electricityPhysicalLegDeliveryStepQuantityUnit = electricityPhysicalLegDeliveryStepQuantityUnits.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("productGrade")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("productGrade")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addProductGrade(String _productGrade) {
			if (_productGrade != null) {
				this.productGrade.add(_productGrade);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addProductGrade(String _productGrade, int idx) {
			getIndex(this.productGrade, idx, () -> _productGrade);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addProductGrade(List<String> productGrades) {
			if (productGrades != null) {
				for (final String toAdd : productGrades) {
					this.productGrade.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("productGrade")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("productGrade")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setProductGrade(List<String> productGrades) {
			if (productGrades == null) {
				this.productGrade = new ArrayList<>();
			} else {
				this.productGrade = productGrades.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("basketWeightPercentage")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("basketWeightPercentage")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addBasketWeightPercentage(BigDecimal _basketWeightPercentage) {
			if (_basketWeightPercentage != null) {
				this.basketWeightPercentage.add(_basketWeightPercentage);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addBasketWeightPercentage(BigDecimal _basketWeightPercentage, int idx) {
			getIndex(this.basketWeightPercentage, idx, () -> _basketWeightPercentage);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addBasketWeightPercentage(List<BigDecimal> basketWeightPercentages) {
			if (basketWeightPercentages != null) {
				for (final BigDecimal toAdd : basketWeightPercentages) {
					this.basketWeightPercentage.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("basketWeightPercentage")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("basketWeightPercentage")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setBasketWeightPercentage(List<BigDecimal> basketWeightPercentages) {
			if (basketWeightPercentages == null) {
				this.basketWeightPercentage = new ArrayList<>();
			} else {
				this.basketWeightPercentage = basketWeightPercentages.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("referenceObligationType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("referenceObligationType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceObligationType(String _referenceObligationType) {
			if (_referenceObligationType != null) {
				this.referenceObligationType.add(_referenceObligationType);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceObligationType(String _referenceObligationType, int idx) {
			getIndex(this.referenceObligationType, idx, () -> _referenceObligationType);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceObligationType(List<String> referenceObligationTypes) {
			if (referenceObligationTypes != null) {
				for (final String toAdd : referenceObligationTypes) {
					this.referenceObligationType.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("referenceObligationType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("referenceObligationType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setReferenceObligationType(List<String> referenceObligationTypes) {
			if (referenceObligationTypes == null) {
				this.referenceObligationType = new ArrayList<>();
			} else {
				this.referenceObligationType = referenceObligationTypes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPlaceOfIncorporation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAssetPlaceOfIncorporation")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetPlaceOfIncorporation(String _underlyingAssetPlaceOfIncorporation) {
			if (_underlyingAssetPlaceOfIncorporation != null) {
				this.underlyingAssetPlaceOfIncorporation.add(_underlyingAssetPlaceOfIncorporation);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetPlaceOfIncorporation(String _underlyingAssetPlaceOfIncorporation, int idx) {
			getIndex(this.underlyingAssetPlaceOfIncorporation, idx, () -> _underlyingAssetPlaceOfIncorporation);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetPlaceOfIncorporation(List<String> underlyingAssetPlaceOfIncorporations) {
			if (underlyingAssetPlaceOfIncorporations != null) {
				for (final String toAdd : underlyingAssetPlaceOfIncorporations) {
					this.underlyingAssetPlaceOfIncorporation.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPlaceOfIncorporation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyingAssetPlaceOfIncorporation")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetPlaceOfIncorporation(List<String> underlyingAssetPlaceOfIncorporations) {
			if (underlyingAssetPlaceOfIncorporations == null) {
				this.underlyingAssetPlaceOfIncorporation = new ArrayList<>();
			} else {
				this.underlyingAssetPlaceOfIncorporation = underlyingAssetPlaceOfIncorporations.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPlaceOfIssuance")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAssetPlaceOfIssuance")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetPlaceOfIssuance(String _underlyingAssetPlaceOfIssuance) {
			if (_underlyingAssetPlaceOfIssuance != null) {
				this.underlyingAssetPlaceOfIssuance.add(_underlyingAssetPlaceOfIssuance);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetPlaceOfIssuance(String _underlyingAssetPlaceOfIssuance, int idx) {
			getIndex(this.underlyingAssetPlaceOfIssuance, idx, () -> _underlyingAssetPlaceOfIssuance);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetPlaceOfIssuance(List<String> underlyingAssetPlaceOfIssuances) {
			if (underlyingAssetPlaceOfIssuances != null) {
				for (final String toAdd : underlyingAssetPlaceOfIssuances) {
					this.underlyingAssetPlaceOfIssuance.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetPlaceOfIssuance")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyingAssetPlaceOfIssuance")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetPlaceOfIssuance(List<String> underlyingAssetPlaceOfIssuances) {
			if (underlyingAssetPlaceOfIssuances == null) {
				this.underlyingAssetPlaceOfIssuance = new ArrayList<>();
			} else {
				this.underlyingAssetPlaceOfIssuance = underlyingAssetPlaceOfIssuances.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("referenceEntityId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("referenceEntityId")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceEntityId(String _referenceEntityId) {
			if (_referenceEntityId != null) {
				this.referenceEntityId.add(_referenceEntityId);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceEntityId(String _referenceEntityId, int idx) {
			getIndex(this.referenceEntityId, idx, () -> _referenceEntityId);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceEntityId(List<String> referenceEntityIds) {
			if (referenceEntityIds != null) {
				for (final String toAdd : referenceEntityIds) {
					this.referenceEntityId.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("referenceEntityId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("referenceEntityId")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setReferenceEntityId(List<String> referenceEntityIds) {
			if (referenceEntityIds == null) {
				this.referenceEntityId = new ArrayList<>();
			} else {
				this.referenceEntityId = referenceEntityIds.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("referenceEntityIdType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("referenceEntityIdType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceEntityIdType(String _referenceEntityIdType) {
			if (_referenceEntityIdType != null) {
				this.referenceEntityIdType.add(_referenceEntityIdType);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceEntityIdType(String _referenceEntityIdType, int idx) {
			getIndex(this.referenceEntityIdType, idx, () -> _referenceEntityIdType);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addReferenceEntityIdType(List<String> referenceEntityIdTypes) {
			if (referenceEntityIdTypes != null) {
				for (final String toAdd : referenceEntityIdTypes) {
					this.referenceEntityIdType.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("referenceEntityIdType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("referenceEntityIdType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setReferenceEntityIdType(List<String> referenceEntityIdTypes) {
			if (referenceEntityIdTypes == null) {
				this.referenceEntityIdType = new ArrayList<>();
			} else {
				this.referenceEntityIdType = referenceEntityIdTypes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetFixedRate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAssetFixedRate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetFixedRate(BigDecimal _underlyingAssetFixedRate) {
			if (_underlyingAssetFixedRate != null) {
				this.underlyingAssetFixedRate.add(_underlyingAssetFixedRate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetFixedRate(BigDecimal _underlyingAssetFixedRate, int idx) {
			getIndex(this.underlyingAssetFixedRate, idx, () -> _underlyingAssetFixedRate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetFixedRate(List<BigDecimal> underlyingAssetFixedRates) {
			if (underlyingAssetFixedRates != null) {
				for (final BigDecimal toAdd : underlyingAssetFixedRates) {
					this.underlyingAssetFixedRate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetFixedRate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyingAssetFixedRate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetFixedRate(List<BigDecimal> underlyingAssetFixedRates) {
			if (underlyingAssetFixedRates == null) {
				this.underlyingAssetFixedRate = new ArrayList<>();
			} else {
				this.underlyingAssetFixedRate = underlyingAssetFixedRates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetNotionalCurrency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAssetNotionalCurrency")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetNotionalCurrency(String _underlyingAssetNotionalCurrency) {
			if (_underlyingAssetNotionalCurrency != null) {
				this.underlyingAssetNotionalCurrency.add(_underlyingAssetNotionalCurrency);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetNotionalCurrency(String _underlyingAssetNotionalCurrency, int idx) {
			getIndex(this.underlyingAssetNotionalCurrency, idx, () -> _underlyingAssetNotionalCurrency);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetNotionalCurrency(List<String> underlyingAssetNotionalCurrencys) {
			if (underlyingAssetNotionalCurrencys != null) {
				for (final String toAdd : underlyingAssetNotionalCurrencys) {
					this.underlyingAssetNotionalCurrency.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetNotionalCurrency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyingAssetNotionalCurrency")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetNotionalCurrency(List<String> underlyingAssetNotionalCurrencys) {
			if (underlyingAssetNotionalCurrencys == null) {
				this.underlyingAssetNotionalCurrency = new ArrayList<>();
			} else {
				this.underlyingAssetNotionalCurrency = underlyingAssetNotionalCurrencys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("periodStartDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("periodStartDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodStartDate(Date _periodStartDate) {
			if (_periodStartDate != null) {
				this.periodStartDate.add(_periodStartDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodStartDate(Date _periodStartDate, int idx) {
			getIndex(this.periodStartDate, idx, () -> _periodStartDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodStartDate(List<Date> periodStartDates) {
			if (periodStartDates != null) {
				for (final Date toAdd : periodStartDates) {
					this.periodStartDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("periodStartDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("periodStartDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setPeriodStartDate(List<Date> periodStartDates) {
			if (periodStartDates == null) {
				this.periodStartDate = new ArrayList<>();
			} else {
				this.periodStartDate = periodStartDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("periodEndDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("periodEndDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodEndDate(Date _periodEndDate) {
			if (_periodEndDate != null) {
				this.periodEndDate.add(_periodEndDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodEndDate(Date _periodEndDate, int idx) {
			getIndex(this.periodEndDate, idx, () -> _periodEndDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodEndDate(List<Date> periodEndDates) {
			if (periodEndDates != null) {
				for (final Date toAdd : periodEndDates) {
					this.periodEndDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("periodEndDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("periodEndDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setPeriodEndDate(List<Date> periodEndDates) {
			if (periodEndDates == null) {
				this.periodEndDate = new ArrayList<>();
			} else {
				this.periodEndDate = periodEndDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("periodFixedStrike")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("periodFixedStrike")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodFixedStrike(BigDecimal _periodFixedStrike) {
			if (_periodFixedStrike != null) {
				this.periodFixedStrike.add(_periodFixedStrike);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodFixedStrike(BigDecimal _periodFixedStrike, int idx) {
			getIndex(this.periodFixedStrike, idx, () -> _periodFixedStrike);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodFixedStrike(List<BigDecimal> periodFixedStrikes) {
			if (periodFixedStrikes != null) {
				for (final BigDecimal toAdd : periodFixedStrikes) {
					this.periodFixedStrike.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("periodFixedStrike")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("periodFixedStrike")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setPeriodFixedStrike(List<BigDecimal> periodFixedStrikes) {
			if (periodFixedStrikes == null) {
				this.periodFixedStrike = new ArrayList<>();
			} else {
				this.periodFixedStrike = periodFixedStrikes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("periodFixedAmount")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("periodFixedAmount")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodFixedAmount(BigDecimal _periodFixedAmount) {
			if (_periodFixedAmount != null) {
				this.periodFixedAmount.add(_periodFixedAmount);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodFixedAmount(BigDecimal _periodFixedAmount, int idx) {
			getIndex(this.periodFixedAmount, idx, () -> _periodFixedAmount);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addPeriodFixedAmount(List<BigDecimal> periodFixedAmounts) {
			if (periodFixedAmounts != null) {
				for (final BigDecimal toAdd : periodFixedAmounts) {
					this.periodFixedAmount.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("periodFixedAmount")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("periodFixedAmount")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setPeriodFixedAmount(List<BigDecimal> periodFixedAmounts) {
			if (periodFixedAmounts == null) {
				this.periodFixedAmount = new ArrayList<>();
			} else {
				this.periodFixedAmount = periodFixedAmounts.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetNotionalAmount")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAssetNotionalAmount")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetNotionalAmount(BigDecimal _underlyingAssetNotionalAmount) {
			if (_underlyingAssetNotionalAmount != null) {
				this.underlyingAssetNotionalAmount.add(_underlyingAssetNotionalAmount);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetNotionalAmount(BigDecimal _underlyingAssetNotionalAmount, int idx) {
			getIndex(this.underlyingAssetNotionalAmount, idx, () -> _underlyingAssetNotionalAmount);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetNotionalAmount(List<BigDecimal> underlyingAssetNotionalAmounts) {
			if (underlyingAssetNotionalAmounts != null) {
				for (final BigDecimal toAdd : underlyingAssetNotionalAmounts) {
					this.underlyingAssetNotionalAmount.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetNotionalAmount")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyingAssetNotionalAmount")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetNotionalAmount(List<BigDecimal> underlyingAssetNotionalAmounts) {
			if (underlyingAssetNotionalAmounts == null) {
				this.underlyingAssetNotionalAmount = new ArrayList<>();
			} else {
				this.underlyingAssetNotionalAmount = underlyingAssetNotionalAmounts.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("dividendPaymentDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("dividendPaymentDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDividendPaymentDate(Date _dividendPaymentDate) {
			if (_dividendPaymentDate != null) {
				this.dividendPaymentDate.add(_dividendPaymentDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDividendPaymentDate(Date _dividendPaymentDate, int idx) {
			getIndex(this.dividendPaymentDate, idx, () -> _dividendPaymentDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addDividendPaymentDate(List<Date> dividendPaymentDates) {
			if (dividendPaymentDates != null) {
				for (final Date toAdd : dividendPaymentDates) {
					this.dividendPaymentDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("dividendPaymentDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("dividendPaymentDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setDividendPaymentDate(List<Date> dividendPaymentDates) {
			if (dividendPaymentDates == null) {
				this.dividendPaymentDate = new ArrayList<>();
			} else {
				this.dividendPaymentDate = dividendPaymentDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("fixedAmountPaymentDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fixedAmountPaymentDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFixedAmountPaymentDate(Date _fixedAmountPaymentDate) {
			if (_fixedAmountPaymentDate != null) {
				this.fixedAmountPaymentDate.add(_fixedAmountPaymentDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFixedAmountPaymentDate(Date _fixedAmountPaymentDate, int idx) {
			getIndex(this.fixedAmountPaymentDate, idx, () -> _fixedAmountPaymentDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFixedAmountPaymentDate(List<Date> fixedAmountPaymentDates) {
			if (fixedAmountPaymentDates != null) {
				for (final Date toAdd : fixedAmountPaymentDates) {
					this.fixedAmountPaymentDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("fixedAmountPaymentDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fixedAmountPaymentDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setFixedAmountPaymentDate(List<Date> fixedAmountPaymentDates) {
			if (fixedAmountPaymentDates == null) {
				this.fixedAmountPaymentDate = new ArrayList<>();
			} else {
				this.fixedAmountPaymentDate = fixedAmountPaymentDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1PaymentDates")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg1PaymentDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1PaymentDates(Date _leg1PaymentDates) {
			if (_leg1PaymentDates != null) {
				this.leg1PaymentDates.add(_leg1PaymentDates);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1PaymentDates(Date _leg1PaymentDates, int idx) {
			getIndex(this.leg1PaymentDates, idx, () -> _leg1PaymentDates);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1PaymentDates(List<Date> leg1PaymentDatess) {
			if (leg1PaymentDatess != null) {
				for (final Date toAdd : leg1PaymentDatess) {
					this.leg1PaymentDates.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg1PaymentDates")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg1PaymentDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1PaymentDates(List<Date> leg1PaymentDatess) {
			if (leg1PaymentDatess == null) {
				this.leg1PaymentDates = new ArrayList<>();
			} else {
				this.leg1PaymentDates = leg1PaymentDatess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg2PaymentDates")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg2PaymentDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2PaymentDates(Date _leg2PaymentDates) {
			if (_leg2PaymentDates != null) {
				this.leg2PaymentDates.add(_leg2PaymentDates);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2PaymentDates(Date _leg2PaymentDates, int idx) {
			getIndex(this.leg2PaymentDates, idx, () -> _leg2PaymentDates);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2PaymentDates(List<Date> leg2PaymentDatess) {
			if (leg2PaymentDatess != null) {
				for (final Date toAdd : leg2PaymentDatess) {
					this.leg2PaymentDates.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg2PaymentDates")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg2PaymentDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2PaymentDates(List<Date> leg2PaymentDatess) {
			if (leg2PaymentDatess == null) {
				this.leg2PaymentDates = new ArrayList<>();
			} else {
				this.leg2PaymentDates = leg2PaymentDatess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetInitialPrice")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAssetInitialPrice")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetInitialPrice(BigDecimal _underlyingAssetInitialPrice) {
			if (_underlyingAssetInitialPrice != null) {
				this.underlyingAssetInitialPrice.add(_underlyingAssetInitialPrice);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetInitialPrice(BigDecimal _underlyingAssetInitialPrice, int idx) {
			getIndex(this.underlyingAssetInitialPrice, idx, () -> _underlyingAssetInitialPrice);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetInitialPrice(List<BigDecimal> underlyingAssetInitialPrices) {
			if (underlyingAssetInitialPrices != null) {
				for (final BigDecimal toAdd : underlyingAssetInitialPrices) {
					this.underlyingAssetInitialPrice.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetInitialPrice")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyingAssetInitialPrice")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetInitialPrice(List<BigDecimal> underlyingAssetInitialPrices) {
			if (underlyingAssetInitialPrices == null) {
				this.underlyingAssetInitialPrice = new ArrayList<>();
			} else {
				this.underlyingAssetInitialPrice = underlyingAssetInitialPrices.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cancelationOptionExerciseDates")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cancelationOptionExerciseDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCancelationOptionExerciseDates(Date _cancelationOptionExerciseDates) {
			if (_cancelationOptionExerciseDates != null) {
				this.cancelationOptionExerciseDates.add(_cancelationOptionExerciseDates);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCancelationOptionExerciseDates(Date _cancelationOptionExerciseDates, int idx) {
			getIndex(this.cancelationOptionExerciseDates, idx, () -> _cancelationOptionExerciseDates);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCancelationOptionExerciseDates(List<Date> cancelationOptionExerciseDatess) {
			if (cancelationOptionExerciseDatess != null) {
				for (final Date toAdd : cancelationOptionExerciseDatess) {
					this.cancelationOptionExerciseDates.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cancelationOptionExerciseDates")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cancelationOptionExerciseDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCancelationOptionExerciseDates(List<Date> cancelationOptionExerciseDatess) {
			if (cancelationOptionExerciseDatess == null) {
				this.cancelationOptionExerciseDates = new ArrayList<>();
			} else {
				this.cancelationOptionExerciseDates = cancelationOptionExerciseDatess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cancelationOptionRelevantUnderlyingDates")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cancelationOptionRelevantUnderlyingDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCancelationOptionRelevantUnderlyingDates(Date _cancelationOptionRelevantUnderlyingDates) {
			if (_cancelationOptionRelevantUnderlyingDates != null) {
				this.cancelationOptionRelevantUnderlyingDates.add(_cancelationOptionRelevantUnderlyingDates);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCancelationOptionRelevantUnderlyingDates(Date _cancelationOptionRelevantUnderlyingDates, int idx) {
			getIndex(this.cancelationOptionRelevantUnderlyingDates, idx, () -> _cancelationOptionRelevantUnderlyingDates);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCancelationOptionRelevantUnderlyingDates(List<Date> cancelationOptionRelevantUnderlyingDatess) {
			if (cancelationOptionRelevantUnderlyingDatess != null) {
				for (final Date toAdd : cancelationOptionRelevantUnderlyingDatess) {
					this.cancelationOptionRelevantUnderlyingDates.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cancelationOptionRelevantUnderlyingDates")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cancelationOptionRelevantUnderlyingDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCancelationOptionRelevantUnderlyingDates(List<Date> cancelationOptionRelevantUnderlyingDatess) {
			if (cancelationOptionRelevantUnderlyingDatess == null) {
				this.cancelationOptionRelevantUnderlyingDates = new ArrayList<>();
			} else {
				this.cancelationOptionRelevantUnderlyingDates = cancelationOptionRelevantUnderlyingDatess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("capRateStepDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("capRateStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCapRateStepDate(Date _capRateStepDate) {
			if (_capRateStepDate != null) {
				this.capRateStepDate.add(_capRateStepDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCapRateStepDate(Date _capRateStepDate, int idx) {
			getIndex(this.capRateStepDate, idx, () -> _capRateStepDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCapRateStepDate(List<Date> capRateStepDates) {
			if (capRateStepDates != null) {
				for (final Date toAdd : capRateStepDates) {
					this.capRateStepDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("capRateStepDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("capRateStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCapRateStepDate(List<Date> capRateStepDates) {
			if (capRateStepDates == null) {
				this.capRateStepDate = new ArrayList<>();
			} else {
				this.capRateStepDate = capRateStepDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("capRateStepValues")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("capRateStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCapRateStepValues(BigDecimal _capRateStepValues) {
			if (_capRateStepValues != null) {
				this.capRateStepValues.add(_capRateStepValues);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCapRateStepValues(BigDecimal _capRateStepValues, int idx) {
			getIndex(this.capRateStepValues, idx, () -> _capRateStepValues);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCapRateStepValues(List<BigDecimal> capRateStepValuess) {
			if (capRateStepValuess != null) {
				for (final BigDecimal toAdd : capRateStepValuess) {
					this.capRateStepValues.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("capRateStepValues")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("capRateStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCapRateStepValues(List<BigDecimal> capRateStepValuess) {
			if (capRateStepValuess == null) {
				this.capRateStepValues = new ArrayList<>();
			} else {
				this.capRateStepValues = capRateStepValuess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("exerciseDates")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("exerciseDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addExerciseDates(Date _exerciseDates) {
			if (_exerciseDates != null) {
				this.exerciseDates.add(_exerciseDates);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addExerciseDates(Date _exerciseDates, int idx) {
			getIndex(this.exerciseDates, idx, () -> _exerciseDates);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addExerciseDates(List<Date> exerciseDatess) {
			if (exerciseDatess != null) {
				for (final Date toAdd : exerciseDatess) {
					this.exerciseDates.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("exerciseDates")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("exerciseDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setExerciseDates(List<Date> exerciseDatess) {
			if (exerciseDatess == null) {
				this.exerciseDates = new ArrayList<>();
			} else {
				this.exerciseDates = exerciseDatess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("floorRateStepDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("floorRateStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFloorRateStepDate(Date _floorRateStepDate) {
			if (_floorRateStepDate != null) {
				this.floorRateStepDate.add(_floorRateStepDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFloorRateStepDate(Date _floorRateStepDate, int idx) {
			getIndex(this.floorRateStepDate, idx, () -> _floorRateStepDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFloorRateStepDate(List<Date> floorRateStepDates) {
			if (floorRateStepDates != null) {
				for (final Date toAdd : floorRateStepDates) {
					this.floorRateStepDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("floorRateStepDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("floorRateStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setFloorRateStepDate(List<Date> floorRateStepDates) {
			if (floorRateStepDates == null) {
				this.floorRateStepDate = new ArrayList<>();
			} else {
				this.floorRateStepDate = floorRateStepDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("floorRateStepValue")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("floorRateStepValue")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFloorRateStepValue(BigDecimal _floorRateStepValue) {
			if (_floorRateStepValue != null) {
				this.floorRateStepValue.add(_floorRateStepValue);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFloorRateStepValue(BigDecimal _floorRateStepValue, int idx) {
			getIndex(this.floorRateStepValue, idx, () -> _floorRateStepValue);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addFloorRateStepValue(List<BigDecimal> floorRateStepValues) {
			if (floorRateStepValues != null) {
				for (final BigDecimal toAdd : floorRateStepValues) {
					this.floorRateStepValue.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("floorRateStepValue")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("floorRateStepValue")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setFloorRateStepValue(List<BigDecimal> floorRateStepValues) {
			if (floorRateStepValues == null) {
				this.floorRateStepValue = new ArrayList<>();
			} else {
				this.floorRateStepValue = floorRateStepValues.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1FixedRateStepDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg1FixedRateStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FixedRateStepDate(Date _leg1FixedRateStepDate) {
			if (_leg1FixedRateStepDate != null) {
				this.leg1FixedRateStepDate.add(_leg1FixedRateStepDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FixedRateStepDate(Date _leg1FixedRateStepDate, int idx) {
			getIndex(this.leg1FixedRateStepDate, idx, () -> _leg1FixedRateStepDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FixedRateStepDate(List<Date> leg1FixedRateStepDates) {
			if (leg1FixedRateStepDates != null) {
				for (final Date toAdd : leg1FixedRateStepDates) {
					this.leg1FixedRateStepDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg1FixedRateStepDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg1FixedRateStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1FixedRateStepDate(List<Date> leg1FixedRateStepDates) {
			if (leg1FixedRateStepDates == null) {
				this.leg1FixedRateStepDate = new ArrayList<>();
			} else {
				this.leg1FixedRateStepDate = leg1FixedRateStepDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1FixedRateStepValues")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg1FixedRateStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FixedRateStepValues(BigDecimal _leg1FixedRateStepValues) {
			if (_leg1FixedRateStepValues != null) {
				this.leg1FixedRateStepValues.add(_leg1FixedRateStepValues);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FixedRateStepValues(BigDecimal _leg1FixedRateStepValues, int idx) {
			getIndex(this.leg1FixedRateStepValues, idx, () -> _leg1FixedRateStepValues);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FixedRateStepValues(List<BigDecimal> leg1FixedRateStepValuess) {
			if (leg1FixedRateStepValuess != null) {
				for (final BigDecimal toAdd : leg1FixedRateStepValuess) {
					this.leg1FixedRateStepValues.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg1FixedRateStepValues")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg1FixedRateStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1FixedRateStepValues(List<BigDecimal> leg1FixedRateStepValuess) {
			if (leg1FixedRateStepValuess == null) {
				this.leg1FixedRateStepValues = new ArrayList<>();
			} else {
				this.leg1FixedRateStepValues = leg1FixedRateStepValuess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1FloatingRateMultiplierStepDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg1FloatingRateMultiplierStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateMultiplierStepDate(Date _leg1FloatingRateMultiplierStepDate) {
			if (_leg1FloatingRateMultiplierStepDate != null) {
				this.leg1FloatingRateMultiplierStepDate.add(_leg1FloatingRateMultiplierStepDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateMultiplierStepDate(Date _leg1FloatingRateMultiplierStepDate, int idx) {
			getIndex(this.leg1FloatingRateMultiplierStepDate, idx, () -> _leg1FloatingRateMultiplierStepDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateMultiplierStepDate(List<Date> leg1FloatingRateMultiplierStepDates) {
			if (leg1FloatingRateMultiplierStepDates != null) {
				for (final Date toAdd : leg1FloatingRateMultiplierStepDates) {
					this.leg1FloatingRateMultiplierStepDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg1FloatingRateMultiplierStepDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg1FloatingRateMultiplierStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1FloatingRateMultiplierStepDate(List<Date> leg1FloatingRateMultiplierStepDates) {
			if (leg1FloatingRateMultiplierStepDates == null) {
				this.leg1FloatingRateMultiplierStepDate = new ArrayList<>();
			} else {
				this.leg1FloatingRateMultiplierStepDate = leg1FloatingRateMultiplierStepDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1FloatingRateMultiplierStepValues")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg1FloatingRateMultiplierStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateMultiplierStepValues(BigDecimal _leg1FloatingRateMultiplierStepValues) {
			if (_leg1FloatingRateMultiplierStepValues != null) {
				this.leg1FloatingRateMultiplierStepValues.add(_leg1FloatingRateMultiplierStepValues);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateMultiplierStepValues(BigDecimal _leg1FloatingRateMultiplierStepValues, int idx) {
			getIndex(this.leg1FloatingRateMultiplierStepValues, idx, () -> _leg1FloatingRateMultiplierStepValues);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateMultiplierStepValues(List<BigDecimal> leg1FloatingRateMultiplierStepValuess) {
			if (leg1FloatingRateMultiplierStepValuess != null) {
				for (final BigDecimal toAdd : leg1FloatingRateMultiplierStepValuess) {
					this.leg1FloatingRateMultiplierStepValues.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg1FloatingRateMultiplierStepValues")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg1FloatingRateMultiplierStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1FloatingRateMultiplierStepValues(List<BigDecimal> leg1FloatingRateMultiplierStepValuess) {
			if (leg1FloatingRateMultiplierStepValuess == null) {
				this.leg1FloatingRateMultiplierStepValues = new ArrayList<>();
			} else {
				this.leg1FloatingRateMultiplierStepValues = leg1FloatingRateMultiplierStepValuess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1FloatingRateSpreadStepDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg1FloatingRateSpreadStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateSpreadStepDate(Date _leg1FloatingRateSpreadStepDate) {
			if (_leg1FloatingRateSpreadStepDate != null) {
				this.leg1FloatingRateSpreadStepDate.add(_leg1FloatingRateSpreadStepDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateSpreadStepDate(Date _leg1FloatingRateSpreadStepDate, int idx) {
			getIndex(this.leg1FloatingRateSpreadStepDate, idx, () -> _leg1FloatingRateSpreadStepDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateSpreadStepDate(List<Date> leg1FloatingRateSpreadStepDates) {
			if (leg1FloatingRateSpreadStepDates != null) {
				for (final Date toAdd : leg1FloatingRateSpreadStepDates) {
					this.leg1FloatingRateSpreadStepDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg1FloatingRateSpreadStepDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg1FloatingRateSpreadStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1FloatingRateSpreadStepDate(List<Date> leg1FloatingRateSpreadStepDates) {
			if (leg1FloatingRateSpreadStepDates == null) {
				this.leg1FloatingRateSpreadStepDate = new ArrayList<>();
			} else {
				this.leg1FloatingRateSpreadStepDate = leg1FloatingRateSpreadStepDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1FloatingRateSpreadStepValues")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg1FloatingRateSpreadStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateSpreadStepValues(BigDecimal _leg1FloatingRateSpreadStepValues) {
			if (_leg1FloatingRateSpreadStepValues != null) {
				this.leg1FloatingRateSpreadStepValues.add(_leg1FloatingRateSpreadStepValues);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateSpreadStepValues(BigDecimal _leg1FloatingRateSpreadStepValues, int idx) {
			getIndex(this.leg1FloatingRateSpreadStepValues, idx, () -> _leg1FloatingRateSpreadStepValues);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1FloatingRateSpreadStepValues(List<BigDecimal> leg1FloatingRateSpreadStepValuess) {
			if (leg1FloatingRateSpreadStepValuess != null) {
				for (final BigDecimal toAdd : leg1FloatingRateSpreadStepValuess) {
					this.leg1FloatingRateSpreadStepValues.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg1FloatingRateSpreadStepValues")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg1FloatingRateSpreadStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1FloatingRateSpreadStepValues(List<BigDecimal> leg1FloatingRateSpreadStepValuess) {
			if (leg1FloatingRateSpreadStepValuess == null) {
				this.leg1FloatingRateSpreadStepValues = new ArrayList<>();
			} else {
				this.leg1FloatingRateSpreadStepValues = leg1FloatingRateSpreadStepValuess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1NotionalStepDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg1NotionalStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1NotionalStepDate(Date _leg1NotionalStepDate) {
			if (_leg1NotionalStepDate != null) {
				this.leg1NotionalStepDate.add(_leg1NotionalStepDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1NotionalStepDate(Date _leg1NotionalStepDate, int idx) {
			getIndex(this.leg1NotionalStepDate, idx, () -> _leg1NotionalStepDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1NotionalStepDate(List<Date> leg1NotionalStepDates) {
			if (leg1NotionalStepDates != null) {
				for (final Date toAdd : leg1NotionalStepDates) {
					this.leg1NotionalStepDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg1NotionalStepDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg1NotionalStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1NotionalStepDate(List<Date> leg1NotionalStepDates) {
			if (leg1NotionalStepDates == null) {
				this.leg1NotionalStepDate = new ArrayList<>();
			} else {
				this.leg1NotionalStepDate = leg1NotionalStepDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg1NotionalStepValues")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg1NotionalStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1NotionalStepValues(BigDecimal _leg1NotionalStepValues) {
			if (_leg1NotionalStepValues != null) {
				this.leg1NotionalStepValues.add(_leg1NotionalStepValues);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1NotionalStepValues(BigDecimal _leg1NotionalStepValues, int idx) {
			getIndex(this.leg1NotionalStepValues, idx, () -> _leg1NotionalStepValues);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg1NotionalStepValues(List<BigDecimal> leg1NotionalStepValuess) {
			if (leg1NotionalStepValuess != null) {
				for (final BigDecimal toAdd : leg1NotionalStepValuess) {
					this.leg1NotionalStepValues.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg1NotionalStepValues")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg1NotionalStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg1NotionalStepValues(List<BigDecimal> leg1NotionalStepValuess) {
			if (leg1NotionalStepValuess == null) {
				this.leg1NotionalStepValues = new ArrayList<>();
			} else {
				this.leg1NotionalStepValues = leg1NotionalStepValuess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg2FixedRateStepDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg2FixedRateStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FixedRateStepDate(Date _leg2FixedRateStepDate) {
			if (_leg2FixedRateStepDate != null) {
				this.leg2FixedRateStepDate.add(_leg2FixedRateStepDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FixedRateStepDate(Date _leg2FixedRateStepDate, int idx) {
			getIndex(this.leg2FixedRateStepDate, idx, () -> _leg2FixedRateStepDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FixedRateStepDate(List<Date> leg2FixedRateStepDates) {
			if (leg2FixedRateStepDates != null) {
				for (final Date toAdd : leg2FixedRateStepDates) {
					this.leg2FixedRateStepDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg2FixedRateStepDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg2FixedRateStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2FixedRateStepDate(List<Date> leg2FixedRateStepDates) {
			if (leg2FixedRateStepDates == null) {
				this.leg2FixedRateStepDate = new ArrayList<>();
			} else {
				this.leg2FixedRateStepDate = leg2FixedRateStepDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg2FixedRateStepValues")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg2FixedRateStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FixedRateStepValues(BigDecimal _leg2FixedRateStepValues) {
			if (_leg2FixedRateStepValues != null) {
				this.leg2FixedRateStepValues.add(_leg2FixedRateStepValues);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FixedRateStepValues(BigDecimal _leg2FixedRateStepValues, int idx) {
			getIndex(this.leg2FixedRateStepValues, idx, () -> _leg2FixedRateStepValues);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FixedRateStepValues(List<BigDecimal> leg2FixedRateStepValuess) {
			if (leg2FixedRateStepValuess != null) {
				for (final BigDecimal toAdd : leg2FixedRateStepValuess) {
					this.leg2FixedRateStepValues.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg2FixedRateStepValues")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg2FixedRateStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2FixedRateStepValues(List<BigDecimal> leg2FixedRateStepValuess) {
			if (leg2FixedRateStepValuess == null) {
				this.leg2FixedRateStepValues = new ArrayList<>();
			} else {
				this.leg2FixedRateStepValues = leg2FixedRateStepValuess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg2FloatingRateMultiplierStepDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg2FloatingRateMultiplierStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateMultiplierStepDate(Date _leg2FloatingRateMultiplierStepDate) {
			if (_leg2FloatingRateMultiplierStepDate != null) {
				this.leg2FloatingRateMultiplierStepDate.add(_leg2FloatingRateMultiplierStepDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateMultiplierStepDate(Date _leg2FloatingRateMultiplierStepDate, int idx) {
			getIndex(this.leg2FloatingRateMultiplierStepDate, idx, () -> _leg2FloatingRateMultiplierStepDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateMultiplierStepDate(List<Date> leg2FloatingRateMultiplierStepDates) {
			if (leg2FloatingRateMultiplierStepDates != null) {
				for (final Date toAdd : leg2FloatingRateMultiplierStepDates) {
					this.leg2FloatingRateMultiplierStepDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg2FloatingRateMultiplierStepDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg2FloatingRateMultiplierStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2FloatingRateMultiplierStepDate(List<Date> leg2FloatingRateMultiplierStepDates) {
			if (leg2FloatingRateMultiplierStepDates == null) {
				this.leg2FloatingRateMultiplierStepDate = new ArrayList<>();
			} else {
				this.leg2FloatingRateMultiplierStepDate = leg2FloatingRateMultiplierStepDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg2FloatingRateMultiplierStepValues")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg2FloatingRateMultiplierStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateMultiplierStepValues(BigDecimal _leg2FloatingRateMultiplierStepValues) {
			if (_leg2FloatingRateMultiplierStepValues != null) {
				this.leg2FloatingRateMultiplierStepValues.add(_leg2FloatingRateMultiplierStepValues);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateMultiplierStepValues(BigDecimal _leg2FloatingRateMultiplierStepValues, int idx) {
			getIndex(this.leg2FloatingRateMultiplierStepValues, idx, () -> _leg2FloatingRateMultiplierStepValues);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateMultiplierStepValues(List<BigDecimal> leg2FloatingRateMultiplierStepValuess) {
			if (leg2FloatingRateMultiplierStepValuess != null) {
				for (final BigDecimal toAdd : leg2FloatingRateMultiplierStepValuess) {
					this.leg2FloatingRateMultiplierStepValues.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg2FloatingRateMultiplierStepValues")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg2FloatingRateMultiplierStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2FloatingRateMultiplierStepValues(List<BigDecimal> leg2FloatingRateMultiplierStepValuess) {
			if (leg2FloatingRateMultiplierStepValuess == null) {
				this.leg2FloatingRateMultiplierStepValues = new ArrayList<>();
			} else {
				this.leg2FloatingRateMultiplierStepValues = leg2FloatingRateMultiplierStepValuess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg2FloatingRateSpreadStepDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg2FloatingRateSpreadStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateSpreadStepDate(Date _leg2FloatingRateSpreadStepDate) {
			if (_leg2FloatingRateSpreadStepDate != null) {
				this.leg2FloatingRateSpreadStepDate.add(_leg2FloatingRateSpreadStepDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateSpreadStepDate(Date _leg2FloatingRateSpreadStepDate, int idx) {
			getIndex(this.leg2FloatingRateSpreadStepDate, idx, () -> _leg2FloatingRateSpreadStepDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateSpreadStepDate(List<Date> leg2FloatingRateSpreadStepDates) {
			if (leg2FloatingRateSpreadStepDates != null) {
				for (final Date toAdd : leg2FloatingRateSpreadStepDates) {
					this.leg2FloatingRateSpreadStepDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg2FloatingRateSpreadStepDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg2FloatingRateSpreadStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2FloatingRateSpreadStepDate(List<Date> leg2FloatingRateSpreadStepDates) {
			if (leg2FloatingRateSpreadStepDates == null) {
				this.leg2FloatingRateSpreadStepDate = new ArrayList<>();
			} else {
				this.leg2FloatingRateSpreadStepDate = leg2FloatingRateSpreadStepDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg2FloatingRateSpreadStepValues")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg2FloatingRateSpreadStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateSpreadStepValues(BigDecimal _leg2FloatingRateSpreadStepValues) {
			if (_leg2FloatingRateSpreadStepValues != null) {
				this.leg2FloatingRateSpreadStepValues.add(_leg2FloatingRateSpreadStepValues);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateSpreadStepValues(BigDecimal _leg2FloatingRateSpreadStepValues, int idx) {
			getIndex(this.leg2FloatingRateSpreadStepValues, idx, () -> _leg2FloatingRateSpreadStepValues);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2FloatingRateSpreadStepValues(List<BigDecimal> leg2FloatingRateSpreadStepValuess) {
			if (leg2FloatingRateSpreadStepValuess != null) {
				for (final BigDecimal toAdd : leg2FloatingRateSpreadStepValuess) {
					this.leg2FloatingRateSpreadStepValues.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg2FloatingRateSpreadStepValues")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg2FloatingRateSpreadStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2FloatingRateSpreadStepValues(List<BigDecimal> leg2FloatingRateSpreadStepValuess) {
			if (leg2FloatingRateSpreadStepValuess == null) {
				this.leg2FloatingRateSpreadStepValues = new ArrayList<>();
			} else {
				this.leg2FloatingRateSpreadStepValues = leg2FloatingRateSpreadStepValuess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg2NotionalStepDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg2NotionalStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2NotionalStepDate(Date _leg2NotionalStepDate) {
			if (_leg2NotionalStepDate != null) {
				this.leg2NotionalStepDate.add(_leg2NotionalStepDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2NotionalStepDate(Date _leg2NotionalStepDate, int idx) {
			getIndex(this.leg2NotionalStepDate, idx, () -> _leg2NotionalStepDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2NotionalStepDate(List<Date> leg2NotionalStepDates) {
			if (leg2NotionalStepDates != null) {
				for (final Date toAdd : leg2NotionalStepDates) {
					this.leg2NotionalStepDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg2NotionalStepDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg2NotionalStepDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2NotionalStepDate(List<Date> leg2NotionalStepDates) {
			if (leg2NotionalStepDates == null) {
				this.leg2NotionalStepDate = new ArrayList<>();
			} else {
				this.leg2NotionalStepDate = leg2NotionalStepDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("leg2NotionalStepValues")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("leg2NotionalStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2NotionalStepValues(BigDecimal _leg2NotionalStepValues) {
			if (_leg2NotionalStepValues != null) {
				this.leg2NotionalStepValues.add(_leg2NotionalStepValues);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2NotionalStepValues(BigDecimal _leg2NotionalStepValues, int idx) {
			getIndex(this.leg2NotionalStepValues, idx, () -> _leg2NotionalStepValues);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addLeg2NotionalStepValues(List<BigDecimal> leg2NotionalStepValuess) {
			if (leg2NotionalStepValuess != null) {
				for (final BigDecimal toAdd : leg2NotionalStepValuess) {
					this.leg2NotionalStepValues.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("leg2NotionalStepValues")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("leg2NotionalStepValues")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setLeg2NotionalStepValues(List<BigDecimal> leg2NotionalStepValuess) {
			if (leg2NotionalStepValuess == null) {
				this.leg2NotionalStepValues = new ArrayList<>();
			} else {
				this.leg2NotionalStepValues = leg2NotionalStepValuess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("optionalEarlyTerminationDates")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationDates(Date _optionalEarlyTerminationDates) {
			if (_optionalEarlyTerminationDates != null) {
				this.optionalEarlyTerminationDates.add(_optionalEarlyTerminationDates);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationDates(Date _optionalEarlyTerminationDates, int idx) {
			getIndex(this.optionalEarlyTerminationDates, idx, () -> _optionalEarlyTerminationDates);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationDates(List<Date> optionalEarlyTerminationDatess) {
			if (optionalEarlyTerminationDatess != null) {
				for (final Date toAdd : optionalEarlyTerminationDatess) {
					this.optionalEarlyTerminationDates.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("optionalEarlyTerminationDates")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setOptionalEarlyTerminationDates(List<Date> optionalEarlyTerminationDatess) {
			if (optionalEarlyTerminationDatess == null) {
				this.optionalEarlyTerminationDates = new ArrayList<>();
			} else {
				this.optionalEarlyTerminationDates = optionalEarlyTerminationDatess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("optionalEarlyTerminationExerciseDates")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationExerciseDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationExerciseDates(Date _optionalEarlyTerminationExerciseDates) {
			if (_optionalEarlyTerminationExerciseDates != null) {
				this.optionalEarlyTerminationExerciseDates.add(_optionalEarlyTerminationExerciseDates);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationExerciseDates(Date _optionalEarlyTerminationExerciseDates, int idx) {
			getIndex(this.optionalEarlyTerminationExerciseDates, idx, () -> _optionalEarlyTerminationExerciseDates);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationExerciseDates(List<Date> optionalEarlyTerminationExerciseDatess) {
			if (optionalEarlyTerminationExerciseDatess != null) {
				for (final Date toAdd : optionalEarlyTerminationExerciseDatess) {
					this.optionalEarlyTerminationExerciseDates.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("optionalEarlyTerminationExerciseDates")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationExerciseDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setOptionalEarlyTerminationExerciseDates(List<Date> optionalEarlyTerminationExerciseDatess) {
			if (optionalEarlyTerminationExerciseDatess == null) {
				this.optionalEarlyTerminationExerciseDates = new ArrayList<>();
			} else {
				this.optionalEarlyTerminationExerciseDates = optionalEarlyTerminationExerciseDatess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("optionalEarlyTerminationUnderlyingDates")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationUnderlyingDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationUnderlyingDates(Date _optionalEarlyTerminationUnderlyingDates) {
			if (_optionalEarlyTerminationUnderlyingDates != null) {
				this.optionalEarlyTerminationUnderlyingDates.add(_optionalEarlyTerminationUnderlyingDates);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationUnderlyingDates(Date _optionalEarlyTerminationUnderlyingDates, int idx) {
			getIndex(this.optionalEarlyTerminationUnderlyingDates, idx, () -> _optionalEarlyTerminationUnderlyingDates);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationUnderlyingDates(List<Date> optionalEarlyTerminationUnderlyingDatess) {
			if (optionalEarlyTerminationUnderlyingDatess != null) {
				for (final Date toAdd : optionalEarlyTerminationUnderlyingDatess) {
					this.optionalEarlyTerminationUnderlyingDates.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("optionalEarlyTerminationUnderlyingDates")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationUnderlyingDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setOptionalEarlyTerminationUnderlyingDates(List<Date> optionalEarlyTerminationUnderlyingDatess) {
			if (optionalEarlyTerminationUnderlyingDatess == null) {
				this.optionalEarlyTerminationUnderlyingDates = new ArrayList<>();
			} else {
				this.optionalEarlyTerminationUnderlyingDates = optionalEarlyTerminationUnderlyingDatess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("relevantUnderlyingDatesUnadjustedDates")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("relevantUnderlyingDatesUnadjustedDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addRelevantUnderlyingDatesUnadjustedDates(Date _relevantUnderlyingDatesUnadjustedDates) {
			if (_relevantUnderlyingDatesUnadjustedDates != null) {
				this.relevantUnderlyingDatesUnadjustedDates.add(_relevantUnderlyingDatesUnadjustedDates);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addRelevantUnderlyingDatesUnadjustedDates(Date _relevantUnderlyingDatesUnadjustedDates, int idx) {
			getIndex(this.relevantUnderlyingDatesUnadjustedDates, idx, () -> _relevantUnderlyingDatesUnadjustedDates);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addRelevantUnderlyingDatesUnadjustedDates(List<Date> relevantUnderlyingDatesUnadjustedDatess) {
			if (relevantUnderlyingDatesUnadjustedDatess != null) {
				for (final Date toAdd : relevantUnderlyingDatesUnadjustedDatess) {
					this.relevantUnderlyingDatesUnadjustedDates.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("relevantUnderlyingDatesUnadjustedDates")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("relevantUnderlyingDatesUnadjustedDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setRelevantUnderlyingDatesUnadjustedDates(List<Date> relevantUnderlyingDatesUnadjustedDatess) {
			if (relevantUnderlyingDatesUnadjustedDatess == null) {
				this.relevantUnderlyingDatesUnadjustedDates = new ArrayList<>();
			} else {
				this.relevantUnderlyingDatesUnadjustedDates = relevantUnderlyingDatesUnadjustedDatess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("optionalEarlyTerminationExerciseAdjustedDates")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationExerciseAdjustedDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationExerciseAdjustedDates(Date _optionalEarlyTerminationExerciseAdjustedDates) {
			if (_optionalEarlyTerminationExerciseAdjustedDates != null) {
				this.optionalEarlyTerminationExerciseAdjustedDates.add(_optionalEarlyTerminationExerciseAdjustedDates);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationExerciseAdjustedDates(Date _optionalEarlyTerminationExerciseAdjustedDates, int idx) {
			getIndex(this.optionalEarlyTerminationExerciseAdjustedDates, idx, () -> _optionalEarlyTerminationExerciseAdjustedDates);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOptionalEarlyTerminationExerciseAdjustedDates(List<Date> optionalEarlyTerminationExerciseAdjustedDatess) {
			if (optionalEarlyTerminationExerciseAdjustedDatess != null) {
				for (final Date toAdd : optionalEarlyTerminationExerciseAdjustedDatess) {
					this.optionalEarlyTerminationExerciseAdjustedDates.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("optionalEarlyTerminationExerciseAdjustedDates")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("optionalEarlyTerminationExerciseAdjustedDates")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setOptionalEarlyTerminationExerciseAdjustedDates(List<Date> optionalEarlyTerminationExerciseAdjustedDatess) {
			if (optionalEarlyTerminationExerciseAdjustedDatess == null) {
				this.optionalEarlyTerminationExerciseAdjustedDates = new ArrayList<>();
			} else {
				this.optionalEarlyTerminationExerciseAdjustedDates = optionalEarlyTerminationExerciseAdjustedDatess.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAssetId")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetId(String _underlyingAssetId) {
			if (_underlyingAssetId != null) {
				this.underlyingAssetId.add(_underlyingAssetId);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetId(String _underlyingAssetId, int idx) {
			getIndex(this.underlyingAssetId, idx, () -> _underlyingAssetId);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetId(List<String> underlyingAssetIds) {
			if (underlyingAssetIds != null) {
				for (final String toAdd : underlyingAssetIds) {
					this.underlyingAssetId.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyingAssetId")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetId(List<String> underlyingAssetIds) {
			if (underlyingAssetIds == null) {
				this.underlyingAssetId = new ArrayList<>();
			} else {
				this.underlyingAssetId = underlyingAssetIds.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetIdType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAssetIdType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetIdType(String _underlyingAssetIdType) {
			if (_underlyingAssetIdType != null) {
				this.underlyingAssetIdType.add(_underlyingAssetIdType);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetIdType(String _underlyingAssetIdType, int idx) {
			getIndex(this.underlyingAssetIdType, idx, () -> _underlyingAssetIdType);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetIdType(List<String> underlyingAssetIdTypes) {
			if (underlyingAssetIdTypes != null) {
				for (final String toAdd : underlyingAssetIdTypes) {
					this.underlyingAssetIdType.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetIdType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyingAssetIdType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetIdType(List<String> underlyingAssetIdTypes) {
			if (underlyingAssetIdTypes == null) {
				this.underlyingAssetIdType = new ArrayList<>();
			} else {
				this.underlyingAssetIdType = underlyingAssetIdTypes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetName")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyingAssetName")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetName(String _underlyingAssetName) {
			if (_underlyingAssetName != null) {
				this.underlyingAssetName.add(_underlyingAssetName);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetName(String _underlyingAssetName, int idx) {
			getIndex(this.underlyingAssetName, idx, () -> _underlyingAssetName);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addUnderlyingAssetName(List<String> underlyingAssetNames) {
			if (underlyingAssetNames != null) {
				for (final String toAdd : underlyingAssetNames) {
					this.underlyingAssetName.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyingAssetName")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyingAssetName")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setUnderlyingAssetName(List<String> underlyingAssetNames) {
			if (underlyingAssetNames == null) {
				this.underlyingAssetName = new ArrayList<>();
			} else {
				this.underlyingAssetName = underlyingAssetNames.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("mandatoryClearingJurisdiction")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("mandatoryClearingJurisdiction")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addMandatoryClearingJurisdiction(String _mandatoryClearingJurisdiction) {
			if (_mandatoryClearingJurisdiction != null) {
				this.mandatoryClearingJurisdiction.add(_mandatoryClearingJurisdiction);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addMandatoryClearingJurisdiction(String _mandatoryClearingJurisdiction, int idx) {
			getIndex(this.mandatoryClearingJurisdiction, idx, () -> _mandatoryClearingJurisdiction);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addMandatoryClearingJurisdiction(List<String> mandatoryClearingJurisdictions) {
			if (mandatoryClearingJurisdictions != null) {
				for (final String toAdd : mandatoryClearingJurisdictions) {
					this.mandatoryClearingJurisdiction.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("mandatoryClearingJurisdiction")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("mandatoryClearingJurisdiction")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setMandatoryClearingJurisdiction(List<String> mandatoryClearingJurisdictions) {
			if (mandatoryClearingJurisdictions == null) {
				this.mandatoryClearingJurisdiction = new ArrayList<>();
			} else {
				this.mandatoryClearingJurisdiction = mandatoryClearingJurisdictions.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("clearingSwapUsiId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingSwapUsiId")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingSwapUsiId(String _clearingSwapUsiId) {
			if (_clearingSwapUsiId != null) {
				this.clearingSwapUsiId.add(_clearingSwapUsiId);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingSwapUsiId(String _clearingSwapUsiId, int idx) {
			getIndex(this.clearingSwapUsiId, idx, () -> _clearingSwapUsiId);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingSwapUsiId(List<String> clearingSwapUsiIds) {
			if (clearingSwapUsiIds != null) {
				for (final String toAdd : clearingSwapUsiIds) {
					this.clearingSwapUsiId.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("clearingSwapUsiId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("clearingSwapUsiId")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setClearingSwapUsiId(List<String> clearingSwapUsiIds) {
			if (clearingSwapUsiIds == null) {
				this.clearingSwapUsiId = new ArrayList<>();
			} else {
				this.clearingSwapUsiId = clearingSwapUsiIds.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("clearingSwapUsiIdPrefix")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingSwapUsiIdPrefix")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingSwapUsiIdPrefix(String _clearingSwapUsiIdPrefix) {
			if (_clearingSwapUsiIdPrefix != null) {
				this.clearingSwapUsiIdPrefix.add(_clearingSwapUsiIdPrefix);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingSwapUsiIdPrefix(String _clearingSwapUsiIdPrefix, int idx) {
			getIndex(this.clearingSwapUsiIdPrefix, idx, () -> _clearingSwapUsiIdPrefix);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingSwapUsiIdPrefix(List<String> clearingSwapUsiIdPrefixs) {
			if (clearingSwapUsiIdPrefixs != null) {
				for (final String toAdd : clearingSwapUsiIdPrefixs) {
					this.clearingSwapUsiIdPrefix.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("clearingSwapUsiIdPrefix")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("clearingSwapUsiIdPrefix")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setClearingSwapUsiIdPrefix(List<String> clearingSwapUsiIdPrefixs) {
			if (clearingSwapUsiIdPrefixs == null) {
				this.clearingSwapUsiIdPrefix = new ArrayList<>();
			} else {
				this.clearingSwapUsiIdPrefix = clearingSwapUsiIdPrefixs.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1LocalCounterpartyJurisdiction")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty1LocalCounterpartyJurisdiction")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1LocalCounterpartyJurisdiction(String _tradeParty1LocalCounterpartyJurisdiction) {
			if (_tradeParty1LocalCounterpartyJurisdiction != null) {
				this.tradeParty1LocalCounterpartyJurisdiction.add(_tradeParty1LocalCounterpartyJurisdiction);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1LocalCounterpartyJurisdiction(String _tradeParty1LocalCounterpartyJurisdiction, int idx) {
			getIndex(this.tradeParty1LocalCounterpartyJurisdiction, idx, () -> _tradeParty1LocalCounterpartyJurisdiction);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty1LocalCounterpartyJurisdiction(List<String> tradeParty1LocalCounterpartyJurisdictions) {
			if (tradeParty1LocalCounterpartyJurisdictions != null) {
				for (final String toAdd : tradeParty1LocalCounterpartyJurisdictions) {
					this.tradeParty1LocalCounterpartyJurisdiction.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty1LocalCounterpartyJurisdiction")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty1LocalCounterpartyJurisdiction")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty1LocalCounterpartyJurisdiction(List<String> tradeParty1LocalCounterpartyJurisdictions) {
			if (tradeParty1LocalCounterpartyJurisdictions == null) {
				this.tradeParty1LocalCounterpartyJurisdiction = new ArrayList<>();
			} else {
				this.tradeParty1LocalCounterpartyJurisdiction = tradeParty1LocalCounterpartyJurisdictions.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2LocalCounterpartyJurisdiction")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeParty2LocalCounterpartyJurisdiction")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2LocalCounterpartyJurisdiction(String _tradeParty2LocalCounterpartyJurisdiction) {
			if (_tradeParty2LocalCounterpartyJurisdiction != null) {
				this.tradeParty2LocalCounterpartyJurisdiction.add(_tradeParty2LocalCounterpartyJurisdiction);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2LocalCounterpartyJurisdiction(String _tradeParty2LocalCounterpartyJurisdiction, int idx) {
			getIndex(this.tradeParty2LocalCounterpartyJurisdiction, idx, () -> _tradeParty2LocalCounterpartyJurisdiction);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addTradeParty2LocalCounterpartyJurisdiction(List<String> tradeParty2LocalCounterpartyJurisdictions) {
			if (tradeParty2LocalCounterpartyJurisdictions != null) {
				for (final String toAdd : tradeParty2LocalCounterpartyJurisdictions) {
					this.tradeParty2LocalCounterpartyJurisdiction.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeParty2LocalCounterpartyJurisdiction")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeParty2LocalCounterpartyJurisdiction")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setTradeParty2LocalCounterpartyJurisdiction(List<String> tradeParty2LocalCounterpartyJurisdictions) {
			if (tradeParty2LocalCounterpartyJurisdictions == null) {
				this.tradeParty2LocalCounterpartyJurisdiction = new ArrayList<>();
			} else {
				this.tradeParty2LocalCounterpartyJurisdiction = tradeParty2LocalCounterpartyJurisdictions.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("clearingExceptionTypeParty2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingExceptionTypeParty2")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingExceptionTypeParty2(String _clearingExceptionTypeParty2) {
			if (_clearingExceptionTypeParty2 != null) {
				this.clearingExceptionTypeParty2.add(_clearingExceptionTypeParty2);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingExceptionTypeParty2(String _clearingExceptionTypeParty2, int idx) {
			getIndex(this.clearingExceptionTypeParty2, idx, () -> _clearingExceptionTypeParty2);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addClearingExceptionTypeParty2(List<String> clearingExceptionTypeParty2s) {
			if (clearingExceptionTypeParty2s != null) {
				for (final String toAdd : clearingExceptionTypeParty2s) {
					this.clearingExceptionTypeParty2.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("clearingExceptionTypeParty2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("clearingExceptionTypeParty2")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setClearingExceptionTypeParty2(List<String> clearingExceptionTypeParty2s) {
			if (clearingExceptionTypeParty2s == null) {
				this.clearingExceptionTypeParty2 = new ArrayList<>();
			} else {
				this.clearingExceptionTypeParty2 = clearingExceptionTypeParty2s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeOtherPaymentPayer")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeOtherPaymentPayer")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentPayer(String _cdeOtherPaymentPayer) {
			if (_cdeOtherPaymentPayer != null) {
				this.cdeOtherPaymentPayer.add(_cdeOtherPaymentPayer);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentPayer(String _cdeOtherPaymentPayer, int idx) {
			getIndex(this.cdeOtherPaymentPayer, idx, () -> _cdeOtherPaymentPayer);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentPayer(List<String> cdeOtherPaymentPayers) {
			if (cdeOtherPaymentPayers != null) {
				for (final String toAdd : cdeOtherPaymentPayers) {
					this.cdeOtherPaymentPayer.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeOtherPaymentPayer")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentPayer")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeOtherPaymentPayer(List<String> cdeOtherPaymentPayers) {
			if (cdeOtherPaymentPayers == null) {
				this.cdeOtherPaymentPayer = new ArrayList<>();
			} else {
				this.cdeOtherPaymentPayer = cdeOtherPaymentPayers.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeOtherPaymentReceiver")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeOtherPaymentReceiver")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentReceiver(String _cdeOtherPaymentReceiver) {
			if (_cdeOtherPaymentReceiver != null) {
				this.cdeOtherPaymentReceiver.add(_cdeOtherPaymentReceiver);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentReceiver(String _cdeOtherPaymentReceiver, int idx) {
			getIndex(this.cdeOtherPaymentReceiver, idx, () -> _cdeOtherPaymentReceiver);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentReceiver(List<String> cdeOtherPaymentReceivers) {
			if (cdeOtherPaymentReceivers != null) {
				for (final String toAdd : cdeOtherPaymentReceivers) {
					this.cdeOtherPaymentReceiver.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeOtherPaymentReceiver")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentReceiver")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeOtherPaymentReceiver(List<String> cdeOtherPaymentReceivers) {
			if (cdeOtherPaymentReceivers == null) {
				this.cdeOtherPaymentReceiver = new ArrayList<>();
			} else {
				this.cdeOtherPaymentReceiver = cdeOtherPaymentReceivers.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeOtherPaymentType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeOtherPaymentType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentType(String _cdeOtherPaymentType) {
			if (_cdeOtherPaymentType != null) {
				this.cdeOtherPaymentType.add(_cdeOtherPaymentType);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentType(String _cdeOtherPaymentType, int idx) {
			getIndex(this.cdeOtherPaymentType, idx, () -> _cdeOtherPaymentType);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentType(List<String> cdeOtherPaymentTypes) {
			if (cdeOtherPaymentTypes != null) {
				for (final String toAdd : cdeOtherPaymentTypes) {
					this.cdeOtherPaymentType.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeOtherPaymentType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeOtherPaymentType(List<String> cdeOtherPaymentTypes) {
			if (cdeOtherPaymentTypes == null) {
				this.cdeOtherPaymentType = new ArrayList<>();
			} else {
				this.cdeOtherPaymentType = cdeOtherPaymentTypes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeOtherPaymentAmount")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeOtherPaymentAmount")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentAmount(BigDecimal _cdeOtherPaymentAmount) {
			if (_cdeOtherPaymentAmount != null) {
				this.cdeOtherPaymentAmount.add(_cdeOtherPaymentAmount);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentAmount(BigDecimal _cdeOtherPaymentAmount, int idx) {
			getIndex(this.cdeOtherPaymentAmount, idx, () -> _cdeOtherPaymentAmount);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentAmount(List<BigDecimal> cdeOtherPaymentAmounts) {
			if (cdeOtherPaymentAmounts != null) {
				for (final BigDecimal toAdd : cdeOtherPaymentAmounts) {
					this.cdeOtherPaymentAmount.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeOtherPaymentAmount")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentAmount")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeOtherPaymentAmount(List<BigDecimal> cdeOtherPaymentAmounts) {
			if (cdeOtherPaymentAmounts == null) {
				this.cdeOtherPaymentAmount = new ArrayList<>();
			} else {
				this.cdeOtherPaymentAmount = cdeOtherPaymentAmounts.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeOtherPaymentCurrency")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeOtherPaymentCurrency")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentCurrency(String _cdeOtherPaymentCurrency) {
			if (_cdeOtherPaymentCurrency != null) {
				this.cdeOtherPaymentCurrency.add(_cdeOtherPaymentCurrency);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentCurrency(String _cdeOtherPaymentCurrency, int idx) {
			getIndex(this.cdeOtherPaymentCurrency, idx, () -> _cdeOtherPaymentCurrency);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentCurrency(List<String> cdeOtherPaymentCurrencys) {
			if (cdeOtherPaymentCurrencys != null) {
				for (final String toAdd : cdeOtherPaymentCurrencys) {
					this.cdeOtherPaymentCurrency.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeOtherPaymentCurrency")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentCurrency")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeOtherPaymentCurrency(List<String> cdeOtherPaymentCurrencys) {
			if (cdeOtherPaymentCurrencys == null) {
				this.cdeOtherPaymentCurrency = new ArrayList<>();
			} else {
				this.cdeOtherPaymentCurrency = cdeOtherPaymentCurrencys.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeOtherPaymentDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeOtherPaymentDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentDate(Date _cdeOtherPaymentDate) {
			if (_cdeOtherPaymentDate != null) {
				this.cdeOtherPaymentDate.add(_cdeOtherPaymentDate);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentDate(Date _cdeOtherPaymentDate, int idx) {
			getIndex(this.cdeOtherPaymentDate, idx, () -> _cdeOtherPaymentDate);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeOtherPaymentDate(List<Date> cdeOtherPaymentDates) {
			if (cdeOtherPaymentDates != null) {
				for (final Date toAdd : cdeOtherPaymentDates) {
					this.cdeOtherPaymentDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeOtherPaymentDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeOtherPaymentDate")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeOtherPaymentDate(List<Date> cdeOtherPaymentDates) {
			if (cdeOtherPaymentDates == null) {
				this.cdeOtherPaymentDate = new ArrayList<>();
			} else {
				this.cdeOtherPaymentDate = cdeOtherPaymentDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("otherPaymentPayerIdType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("otherPaymentPayerIdType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOtherPaymentPayerIdType(String _otherPaymentPayerIdType) {
			if (_otherPaymentPayerIdType != null) {
				this.otherPaymentPayerIdType.add(_otherPaymentPayerIdType);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOtherPaymentPayerIdType(String _otherPaymentPayerIdType, int idx) {
			getIndex(this.otherPaymentPayerIdType, idx, () -> _otherPaymentPayerIdType);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOtherPaymentPayerIdType(List<String> otherPaymentPayerIdTypes) {
			if (otherPaymentPayerIdTypes != null) {
				for (final String toAdd : otherPaymentPayerIdTypes) {
					this.otherPaymentPayerIdType.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("otherPaymentPayerIdType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("otherPaymentPayerIdType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setOtherPaymentPayerIdType(List<String> otherPaymentPayerIdTypes) {
			if (otherPaymentPayerIdTypes == null) {
				this.otherPaymentPayerIdType = new ArrayList<>();
			} else {
				this.otherPaymentPayerIdType = otherPaymentPayerIdTypes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("otherPaymentReceiverIdType")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("otherPaymentReceiverIdType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOtherPaymentReceiverIdType(String _otherPaymentReceiverIdType) {
			if (_otherPaymentReceiverIdType != null) {
				this.otherPaymentReceiverIdType.add(_otherPaymentReceiverIdType);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOtherPaymentReceiverIdType(String _otherPaymentReceiverIdType, int idx) {
			getIndex(this.otherPaymentReceiverIdType, idx, () -> _otherPaymentReceiverIdType);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addOtherPaymentReceiverIdType(List<String> otherPaymentReceiverIdTypes) {
			if (otherPaymentReceiverIdTypes != null) {
				for (final String toAdd : otherPaymentReceiverIdTypes) {
					this.otherPaymentReceiverIdType.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("otherPaymentReceiverIdType")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("otherPaymentReceiverIdType")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setOtherPaymentReceiverIdType(List<String> otherPaymentReceiverIdTypes) {
			if (otherPaymentReceiverIdTypes == null) {
				this.otherPaymentReceiverIdType = new ArrayList<>();
			} else {
				this.otherPaymentReceiverIdType = otherPaymentReceiverIdTypes.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg1")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEffectiveDateOfNotionalQuantityOfLeg1(Date _cdeEffectiveDateOfNotionalQuantityOfLeg1) {
			if (_cdeEffectiveDateOfNotionalQuantityOfLeg1 != null) {
				this.cdeEffectiveDateOfNotionalQuantityOfLeg1.add(_cdeEffectiveDateOfNotionalQuantityOfLeg1);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEffectiveDateOfNotionalQuantityOfLeg1(Date _cdeEffectiveDateOfNotionalQuantityOfLeg1, int idx) {
			getIndex(this.cdeEffectiveDateOfNotionalQuantityOfLeg1, idx, () -> _cdeEffectiveDateOfNotionalQuantityOfLeg1);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEffectiveDateOfNotionalQuantityOfLeg1(List<Date> cdeEffectiveDateOfNotionalQuantityOfLeg1s) {
			if (cdeEffectiveDateOfNotionalQuantityOfLeg1s != null) {
				for (final Date toAdd : cdeEffectiveDateOfNotionalQuantityOfLeg1s) {
					this.cdeEffectiveDateOfNotionalQuantityOfLeg1.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg1")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeEffectiveDateOfNotionalQuantityOfLeg1(List<Date> cdeEffectiveDateOfNotionalQuantityOfLeg1s) {
			if (cdeEffectiveDateOfNotionalQuantityOfLeg1s == null) {
				this.cdeEffectiveDateOfNotionalQuantityOfLeg1 = new ArrayList<>();
			} else {
				this.cdeEffectiveDateOfNotionalQuantityOfLeg1 = cdeEffectiveDateOfNotionalQuantityOfLeg1s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg2")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEffectiveDateOfNotionalQuantityOfLeg2(Date _cdeEffectiveDateOfNotionalQuantityOfLeg2) {
			if (_cdeEffectiveDateOfNotionalQuantityOfLeg2 != null) {
				this.cdeEffectiveDateOfNotionalQuantityOfLeg2.add(_cdeEffectiveDateOfNotionalQuantityOfLeg2);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEffectiveDateOfNotionalQuantityOfLeg2(Date _cdeEffectiveDateOfNotionalQuantityOfLeg2, int idx) {
			getIndex(this.cdeEffectiveDateOfNotionalQuantityOfLeg2, idx, () -> _cdeEffectiveDateOfNotionalQuantityOfLeg2);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEffectiveDateOfNotionalQuantityOfLeg2(List<Date> cdeEffectiveDateOfNotionalQuantityOfLeg2s) {
			if (cdeEffectiveDateOfNotionalQuantityOfLeg2s != null) {
				for (final Date toAdd : cdeEffectiveDateOfNotionalQuantityOfLeg2s) {
					this.cdeEffectiveDateOfNotionalQuantityOfLeg2.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeEffectiveDateOfNotionalQuantityOfLeg2")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeEffectiveDateOfNotionalQuantityOfLeg2(List<Date> cdeEffectiveDateOfNotionalQuantityOfLeg2s) {
			if (cdeEffectiveDateOfNotionalQuantityOfLeg2s == null) {
				this.cdeEffectiveDateOfNotionalQuantityOfLeg2 = new ArrayList<>();
			} else {
				this.cdeEffectiveDateOfNotionalQuantityOfLeg2 = cdeEffectiveDateOfNotionalQuantityOfLeg2s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeEndDateOfNotionalQuantityOfLeg1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeEndDateOfNotionalQuantityOfLeg1")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEndDateOfNotionalQuantityOfLeg1(Date _cdeEndDateOfNotionalQuantityOfLeg1) {
			if (_cdeEndDateOfNotionalQuantityOfLeg1 != null) {
				this.cdeEndDateOfNotionalQuantityOfLeg1.add(_cdeEndDateOfNotionalQuantityOfLeg1);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEndDateOfNotionalQuantityOfLeg1(Date _cdeEndDateOfNotionalQuantityOfLeg1, int idx) {
			getIndex(this.cdeEndDateOfNotionalQuantityOfLeg1, idx, () -> _cdeEndDateOfNotionalQuantityOfLeg1);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEndDateOfNotionalQuantityOfLeg1(List<Date> cdeEndDateOfNotionalQuantityOfLeg1s) {
			if (cdeEndDateOfNotionalQuantityOfLeg1s != null) {
				for (final Date toAdd : cdeEndDateOfNotionalQuantityOfLeg1s) {
					this.cdeEndDateOfNotionalQuantityOfLeg1.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeEndDateOfNotionalQuantityOfLeg1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeEndDateOfNotionalQuantityOfLeg1")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeEndDateOfNotionalQuantityOfLeg1(List<Date> cdeEndDateOfNotionalQuantityOfLeg1s) {
			if (cdeEndDateOfNotionalQuantityOfLeg1s == null) {
				this.cdeEndDateOfNotionalQuantityOfLeg1 = new ArrayList<>();
			} else {
				this.cdeEndDateOfNotionalQuantityOfLeg1 = cdeEndDateOfNotionalQuantityOfLeg1s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeEndDateOfNotionalQuantityOfLeg2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeEndDateOfNotionalQuantityOfLeg2")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEndDateOfNotionalQuantityOfLeg2(Date _cdeEndDateOfNotionalQuantityOfLeg2) {
			if (_cdeEndDateOfNotionalQuantityOfLeg2 != null) {
				this.cdeEndDateOfNotionalQuantityOfLeg2.add(_cdeEndDateOfNotionalQuantityOfLeg2);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEndDateOfNotionalQuantityOfLeg2(Date _cdeEndDateOfNotionalQuantityOfLeg2, int idx) {
			getIndex(this.cdeEndDateOfNotionalQuantityOfLeg2, idx, () -> _cdeEndDateOfNotionalQuantityOfLeg2);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeEndDateOfNotionalQuantityOfLeg2(List<Date> cdeEndDateOfNotionalQuantityOfLeg2s) {
			if (cdeEndDateOfNotionalQuantityOfLeg2s != null) {
				for (final Date toAdd : cdeEndDateOfNotionalQuantityOfLeg2s) {
					this.cdeEndDateOfNotionalQuantityOfLeg2.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeEndDateOfNotionalQuantityOfLeg2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeEndDateOfNotionalQuantityOfLeg2")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeEndDateOfNotionalQuantityOfLeg2(List<Date> cdeEndDateOfNotionalQuantityOfLeg2s) {
			if (cdeEndDateOfNotionalQuantityOfLeg2s == null) {
				this.cdeEndDateOfNotionalQuantityOfLeg2 = new ArrayList<>();
			} else {
				this.cdeEndDateOfNotionalQuantityOfLeg2 = cdeEndDateOfNotionalQuantityOfLeg2s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1(BigDecimal _cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1) {
			if (_cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1 != null) {
				this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1.add(_cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1(BigDecimal _cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1, int idx) {
			getIndex(this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1, idx, () -> _cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1(List<BigDecimal> cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1s) {
			if (cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1s != null) {
				for (final BigDecimal toAdd : cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1s) {
					this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1(List<BigDecimal> cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1s) {
			if (cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1s == null) {
				this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1 = new ArrayList<>();
			} else {
				this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1 = cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2(BigDecimal _cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2) {
			if (_cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2 != null) {
				this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2.add(_cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2(BigDecimal _cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2, int idx) {
			getIndex(this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2, idx, () -> _cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2(List<BigDecimal> cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2s) {
			if (cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2s != null) {
				for (final BigDecimal toAdd : cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2s) {
					this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2(List<BigDecimal> cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2s) {
			if (cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2s == null) {
				this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2 = new ArrayList<>();
			} else {
				this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2 = cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2s.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeBasketConstituentsIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsIdentifier")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsIdentifier(String _cdeBasketConstituentsIdentifier) {
			if (_cdeBasketConstituentsIdentifier != null) {
				this.cdeBasketConstituentsIdentifier.add(_cdeBasketConstituentsIdentifier);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsIdentifier(String _cdeBasketConstituentsIdentifier, int idx) {
			getIndex(this.cdeBasketConstituentsIdentifier, idx, () -> _cdeBasketConstituentsIdentifier);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsIdentifier(List<String> cdeBasketConstituentsIdentifiers) {
			if (cdeBasketConstituentsIdentifiers != null) {
				for (final String toAdd : cdeBasketConstituentsIdentifiers) {
					this.cdeBasketConstituentsIdentifier.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeBasketConstituentsIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsIdentifier")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeBasketConstituentsIdentifier(List<String> cdeBasketConstituentsIdentifiers) {
			if (cdeBasketConstituentsIdentifiers == null) {
				this.cdeBasketConstituentsIdentifier = new ArrayList<>();
			} else {
				this.cdeBasketConstituentsIdentifier = cdeBasketConstituentsIdentifiers.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeBasketConstituentsIdentifierSource")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsIdentifierSource")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsIdentifierSource(String _cdeBasketConstituentsIdentifierSource) {
			if (_cdeBasketConstituentsIdentifierSource != null) {
				this.cdeBasketConstituentsIdentifierSource.add(_cdeBasketConstituentsIdentifierSource);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsIdentifierSource(String _cdeBasketConstituentsIdentifierSource, int idx) {
			getIndex(this.cdeBasketConstituentsIdentifierSource, idx, () -> _cdeBasketConstituentsIdentifierSource);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsIdentifierSource(List<String> cdeBasketConstituentsIdentifierSources) {
			if (cdeBasketConstituentsIdentifierSources != null) {
				for (final String toAdd : cdeBasketConstituentsIdentifierSources) {
					this.cdeBasketConstituentsIdentifierSource.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeBasketConstituentsIdentifierSource")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsIdentifierSource")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeBasketConstituentsIdentifierSource(List<String> cdeBasketConstituentsIdentifierSources) {
			if (cdeBasketConstituentsIdentifierSources == null) {
				this.cdeBasketConstituentsIdentifierSource = new ArrayList<>();
			} else {
				this.cdeBasketConstituentsIdentifierSource = cdeBasketConstituentsIdentifierSources.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeBasketConstituentsNumberOfUnits")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsNumberOfUnits")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsNumberOfUnits(BigDecimal _cdeBasketConstituentsNumberOfUnits) {
			if (_cdeBasketConstituentsNumberOfUnits != null) {
				this.cdeBasketConstituentsNumberOfUnits.add(_cdeBasketConstituentsNumberOfUnits);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsNumberOfUnits(BigDecimal _cdeBasketConstituentsNumberOfUnits, int idx) {
			getIndex(this.cdeBasketConstituentsNumberOfUnits, idx, () -> _cdeBasketConstituentsNumberOfUnits);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsNumberOfUnits(List<BigDecimal> cdeBasketConstituentsNumberOfUnitss) {
			if (cdeBasketConstituentsNumberOfUnitss != null) {
				for (final BigDecimal toAdd : cdeBasketConstituentsNumberOfUnitss) {
					this.cdeBasketConstituentsNumberOfUnits.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeBasketConstituentsNumberOfUnits")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsNumberOfUnits")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeBasketConstituentsNumberOfUnits(List<BigDecimal> cdeBasketConstituentsNumberOfUnitss) {
			if (cdeBasketConstituentsNumberOfUnitss == null) {
				this.cdeBasketConstituentsNumberOfUnits = new ArrayList<>();
			} else {
				this.cdeBasketConstituentsNumberOfUnits = cdeBasketConstituentsNumberOfUnitss.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("cdeBasketConstituentsUnitOfMeasure")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsUnitOfMeasure")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsUnitOfMeasure(String _cdeBasketConstituentsUnitOfMeasure) {
			if (_cdeBasketConstituentsUnitOfMeasure != null) {
				this.cdeBasketConstituentsUnitOfMeasure.add(_cdeBasketConstituentsUnitOfMeasure);
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsUnitOfMeasure(String _cdeBasketConstituentsUnitOfMeasure, int idx) {
			getIndex(this.cdeBasketConstituentsUnitOfMeasure, idx, () -> _cdeBasketConstituentsUnitOfMeasure);
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder addCdeBasketConstituentsUnitOfMeasure(List<String> cdeBasketConstituentsUnitOfMeasures) {
			if (cdeBasketConstituentsUnitOfMeasures != null) {
				for (final String toAdd : cdeBasketConstituentsUnitOfMeasures) {
					this.cdeBasketConstituentsUnitOfMeasure.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("cdeBasketConstituentsUnitOfMeasure")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("cdeBasketConstituentsUnitOfMeasure")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder setCdeBasketConstituentsUnitOfMeasure(List<String> cdeBasketConstituentsUnitOfMeasures) {
			if (cdeBasketConstituentsUnitOfMeasures == null) {
				this.cdeBasketConstituentsUnitOfMeasure = new ArrayList<>();
			} else {
				this.cdeBasketConstituentsUnitOfMeasure = cdeBasketConstituentsUnitOfMeasures.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public HarmonizedRepeatableData build() {
			return new HarmonizedRepeatableData.HarmonizedRepeatableDataImpl(this);
		}
		
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeParty1ReportingDestination()!=null && !getTradeParty1ReportingDestination().isEmpty()) return true;
			if (getTradeParty2ReportingDestination()!=null && !getTradeParty2ReportingDestination().isEmpty()) return true;
			if (getTradeParty1ThirdPartyViewerId()!=null && !getTradeParty1ThirdPartyViewerId().isEmpty()) return true;
			if (getTradeParty2ThirdPartyViewerId()!=null && !getTradeParty2ThirdPartyViewerId().isEmpty()) return true;
			if (getTradeParty1ThirdPartyViewerIdType()!=null && !getTradeParty1ThirdPartyViewerIdType().isEmpty()) return true;
			if (getTradeParty2ThirdPartyViewerIdType()!=null && !getTradeParty2ThirdPartyViewerIdType().isEmpty()) return true;
			if (getLeg1QuantityUnit()!=null && !getLeg1QuantityUnit().isEmpty()) return true;
			if (getLeg1QuantityFrequency()!=null && !getLeg1QuantityFrequency().isEmpty()) return true;
			if (getLeg1Quantity()!=null && !getLeg1Quantity().isEmpty()) return true;
			if (getDeliveryPoint()!=null && !getDeliveryPoint().isEmpty()) return true;
			if (getLoadDeliveryIntervals()!=null && !getLoadDeliveryIntervals().isEmpty()) return true;
			if (getDeliveryEndDateAndTime()!=null && !getDeliveryEndDateAndTime().isEmpty()) return true;
			if (getDuration()!=null && !getDuration().isEmpty()) return true;
			if (getDeliveryCapacity()!=null && !getDeliveryCapacity().isEmpty()) return true;
			if (getPriceTimeIntervalQuantities()!=null && !getPriceTimeIntervalQuantities().isEmpty()) return true;
			if (getDeliveryStartDateAndTime()!=null && !getDeliveryStartDateAndTime().isEmpty()) return true;
			if (getQuantityUnit()!=null && !getQuantityUnit().isEmpty()) return true;
			if (getElectricityPhysicalLegDeliveryStepQuantity()!=null && !getElectricityPhysicalLegDeliveryStepQuantity().isEmpty()) return true;
			if (getElectricityPhysicalLegDeliveryStepQuantityFrequency()!=null && !getElectricityPhysicalLegDeliveryStepQuantityFrequency().isEmpty()) return true;
			if (getElectricityPhysicalLegDeliveryStepQuantityUnit()!=null && !getElectricityPhysicalLegDeliveryStepQuantityUnit().isEmpty()) return true;
			if (getProductGrade()!=null && !getProductGrade().isEmpty()) return true;
			if (getBasketWeightPercentage()!=null && !getBasketWeightPercentage().isEmpty()) return true;
			if (getReferenceObligationType()!=null && !getReferenceObligationType().isEmpty()) return true;
			if (getUnderlyingAssetPlaceOfIncorporation()!=null && !getUnderlyingAssetPlaceOfIncorporation().isEmpty()) return true;
			if (getUnderlyingAssetPlaceOfIssuance()!=null && !getUnderlyingAssetPlaceOfIssuance().isEmpty()) return true;
			if (getReferenceEntityId()!=null && !getReferenceEntityId().isEmpty()) return true;
			if (getReferenceEntityIdType()!=null && !getReferenceEntityIdType().isEmpty()) return true;
			if (getUnderlyingAssetFixedRate()!=null && !getUnderlyingAssetFixedRate().isEmpty()) return true;
			if (getUnderlyingAssetNotionalCurrency()!=null && !getUnderlyingAssetNotionalCurrency().isEmpty()) return true;
			if (getPeriodStartDate()!=null && !getPeriodStartDate().isEmpty()) return true;
			if (getPeriodEndDate()!=null && !getPeriodEndDate().isEmpty()) return true;
			if (getPeriodFixedStrike()!=null && !getPeriodFixedStrike().isEmpty()) return true;
			if (getPeriodFixedAmount()!=null && !getPeriodFixedAmount().isEmpty()) return true;
			if (getUnderlyingAssetNotionalAmount()!=null && !getUnderlyingAssetNotionalAmount().isEmpty()) return true;
			if (getDividendPaymentDate()!=null && !getDividendPaymentDate().isEmpty()) return true;
			if (getFixedAmountPaymentDate()!=null && !getFixedAmountPaymentDate().isEmpty()) return true;
			if (getLeg1PaymentDates()!=null && !getLeg1PaymentDates().isEmpty()) return true;
			if (getLeg2PaymentDates()!=null && !getLeg2PaymentDates().isEmpty()) return true;
			if (getUnderlyingAssetInitialPrice()!=null && !getUnderlyingAssetInitialPrice().isEmpty()) return true;
			if (getCancelationOptionExerciseDates()!=null && !getCancelationOptionExerciseDates().isEmpty()) return true;
			if (getCancelationOptionRelevantUnderlyingDates()!=null && !getCancelationOptionRelevantUnderlyingDates().isEmpty()) return true;
			if (getCapRateStepDate()!=null && !getCapRateStepDate().isEmpty()) return true;
			if (getCapRateStepValues()!=null && !getCapRateStepValues().isEmpty()) return true;
			if (getExerciseDates()!=null && !getExerciseDates().isEmpty()) return true;
			if (getFloorRateStepDate()!=null && !getFloorRateStepDate().isEmpty()) return true;
			if (getFloorRateStepValue()!=null && !getFloorRateStepValue().isEmpty()) return true;
			if (getLeg1FixedRateStepDate()!=null && !getLeg1FixedRateStepDate().isEmpty()) return true;
			if (getLeg1FixedRateStepValues()!=null && !getLeg1FixedRateStepValues().isEmpty()) return true;
			if (getLeg1FloatingRateMultiplierStepDate()!=null && !getLeg1FloatingRateMultiplierStepDate().isEmpty()) return true;
			if (getLeg1FloatingRateMultiplierStepValues()!=null && !getLeg1FloatingRateMultiplierStepValues().isEmpty()) return true;
			if (getLeg1FloatingRateSpreadStepDate()!=null && !getLeg1FloatingRateSpreadStepDate().isEmpty()) return true;
			if (getLeg1FloatingRateSpreadStepValues()!=null && !getLeg1FloatingRateSpreadStepValues().isEmpty()) return true;
			if (getLeg1NotionalStepDate()!=null && !getLeg1NotionalStepDate().isEmpty()) return true;
			if (getLeg1NotionalStepValues()!=null && !getLeg1NotionalStepValues().isEmpty()) return true;
			if (getLeg2FixedRateStepDate()!=null && !getLeg2FixedRateStepDate().isEmpty()) return true;
			if (getLeg2FixedRateStepValues()!=null && !getLeg2FixedRateStepValues().isEmpty()) return true;
			if (getLeg2FloatingRateMultiplierStepDate()!=null && !getLeg2FloatingRateMultiplierStepDate().isEmpty()) return true;
			if (getLeg2FloatingRateMultiplierStepValues()!=null && !getLeg2FloatingRateMultiplierStepValues().isEmpty()) return true;
			if (getLeg2FloatingRateSpreadStepDate()!=null && !getLeg2FloatingRateSpreadStepDate().isEmpty()) return true;
			if (getLeg2FloatingRateSpreadStepValues()!=null && !getLeg2FloatingRateSpreadStepValues().isEmpty()) return true;
			if (getLeg2NotionalStepDate()!=null && !getLeg2NotionalStepDate().isEmpty()) return true;
			if (getLeg2NotionalStepValues()!=null && !getLeg2NotionalStepValues().isEmpty()) return true;
			if (getOptionalEarlyTerminationDates()!=null && !getOptionalEarlyTerminationDates().isEmpty()) return true;
			if (getOptionalEarlyTerminationExerciseDates()!=null && !getOptionalEarlyTerminationExerciseDates().isEmpty()) return true;
			if (getOptionalEarlyTerminationUnderlyingDates()!=null && !getOptionalEarlyTerminationUnderlyingDates().isEmpty()) return true;
			if (getRelevantUnderlyingDatesUnadjustedDates()!=null && !getRelevantUnderlyingDatesUnadjustedDates().isEmpty()) return true;
			if (getOptionalEarlyTerminationExerciseAdjustedDates()!=null && !getOptionalEarlyTerminationExerciseAdjustedDates().isEmpty()) return true;
			if (getUnderlyingAssetId()!=null && !getUnderlyingAssetId().isEmpty()) return true;
			if (getUnderlyingAssetIdType()!=null && !getUnderlyingAssetIdType().isEmpty()) return true;
			if (getUnderlyingAssetName()!=null && !getUnderlyingAssetName().isEmpty()) return true;
			if (getMandatoryClearingJurisdiction()!=null && !getMandatoryClearingJurisdiction().isEmpty()) return true;
			if (getClearingSwapUsiId()!=null && !getClearingSwapUsiId().isEmpty()) return true;
			if (getClearingSwapUsiIdPrefix()!=null && !getClearingSwapUsiIdPrefix().isEmpty()) return true;
			if (getTradeParty1LocalCounterpartyJurisdiction()!=null && !getTradeParty1LocalCounterpartyJurisdiction().isEmpty()) return true;
			if (getTradeParty2LocalCounterpartyJurisdiction()!=null && !getTradeParty2LocalCounterpartyJurisdiction().isEmpty()) return true;
			if (getClearingExceptionTypeParty2()!=null && !getClearingExceptionTypeParty2().isEmpty()) return true;
			if (getCdeOtherPaymentPayer()!=null && !getCdeOtherPaymentPayer().isEmpty()) return true;
			if (getCdeOtherPaymentReceiver()!=null && !getCdeOtherPaymentReceiver().isEmpty()) return true;
			if (getCdeOtherPaymentType()!=null && !getCdeOtherPaymentType().isEmpty()) return true;
			if (getCdeOtherPaymentAmount()!=null && !getCdeOtherPaymentAmount().isEmpty()) return true;
			if (getCdeOtherPaymentCurrency()!=null && !getCdeOtherPaymentCurrency().isEmpty()) return true;
			if (getCdeOtherPaymentDate()!=null && !getCdeOtherPaymentDate().isEmpty()) return true;
			if (getOtherPaymentPayerIdType()!=null && !getOtherPaymentPayerIdType().isEmpty()) return true;
			if (getOtherPaymentReceiverIdType()!=null && !getOtherPaymentReceiverIdType().isEmpty()) return true;
			if (getCdeEffectiveDateOfNotionalQuantityOfLeg1()!=null && !getCdeEffectiveDateOfNotionalQuantityOfLeg1().isEmpty()) return true;
			if (getCdeEffectiveDateOfNotionalQuantityOfLeg2()!=null && !getCdeEffectiveDateOfNotionalQuantityOfLeg2().isEmpty()) return true;
			if (getCdeEndDateOfNotionalQuantityOfLeg1()!=null && !getCdeEndDateOfNotionalQuantityOfLeg1().isEmpty()) return true;
			if (getCdeEndDateOfNotionalQuantityOfLeg2()!=null && !getCdeEndDateOfNotionalQuantityOfLeg2().isEmpty()) return true;
			if (getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1()!=null && !getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1().isEmpty()) return true;
			if (getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2()!=null && !getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2().isEmpty()) return true;
			if (getCdeBasketConstituentsIdentifier()!=null && !getCdeBasketConstituentsIdentifier().isEmpty()) return true;
			if (getCdeBasketConstituentsIdentifierSource()!=null && !getCdeBasketConstituentsIdentifierSource().isEmpty()) return true;
			if (getCdeBasketConstituentsNumberOfUnits()!=null && !getCdeBasketConstituentsNumberOfUnits().isEmpty()) return true;
			if (getCdeBasketConstituentsUnitOfMeasure()!=null && !getCdeBasketConstituentsUnitOfMeasure().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder o = (HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder) other;
			
			
			merger.mergeBasic(getTradeParty1ReportingDestination(), o.getTradeParty1ReportingDestination(), (Consumer<String>) this::addTradeParty1ReportingDestination);
			merger.mergeBasic(getTradeParty2ReportingDestination(), o.getTradeParty2ReportingDestination(), (Consumer<String>) this::addTradeParty2ReportingDestination);
			merger.mergeBasic(getTradeParty1ThirdPartyViewerId(), o.getTradeParty1ThirdPartyViewerId(), (Consumer<String>) this::addTradeParty1ThirdPartyViewerId);
			merger.mergeBasic(getTradeParty2ThirdPartyViewerId(), o.getTradeParty2ThirdPartyViewerId(), (Consumer<String>) this::addTradeParty2ThirdPartyViewerId);
			merger.mergeBasic(getTradeParty1ThirdPartyViewerIdType(), o.getTradeParty1ThirdPartyViewerIdType(), (Consumer<String>) this::addTradeParty1ThirdPartyViewerIdType);
			merger.mergeBasic(getTradeParty2ThirdPartyViewerIdType(), o.getTradeParty2ThirdPartyViewerIdType(), (Consumer<String>) this::addTradeParty2ThirdPartyViewerIdType);
			merger.mergeBasic(getLeg1QuantityUnit(), o.getLeg1QuantityUnit(), (Consumer<String>) this::addLeg1QuantityUnit);
			merger.mergeBasic(getLeg1QuantityFrequency(), o.getLeg1QuantityFrequency(), (Consumer<String>) this::addLeg1QuantityFrequency);
			merger.mergeBasic(getLeg1Quantity(), o.getLeg1Quantity(), (Consumer<BigDecimal>) this::addLeg1Quantity);
			merger.mergeBasic(getDeliveryPoint(), o.getDeliveryPoint(), (Consumer<String>) this::addDeliveryPoint);
			merger.mergeBasic(getLoadDeliveryIntervals(), o.getLoadDeliveryIntervals(), (Consumer<LocalTime>) this::addLoadDeliveryIntervals);
			merger.mergeBasic(getDeliveryEndDateAndTime(), o.getDeliveryEndDateAndTime(), (Consumer<ZonedDateTime>) this::addDeliveryEndDateAndTime);
			merger.mergeBasic(getDuration(), o.getDuration(), (Consumer<String>) this::addDuration);
			merger.mergeBasic(getDeliveryCapacity(), o.getDeliveryCapacity(), (Consumer<String>) this::addDeliveryCapacity);
			merger.mergeBasic(getPriceTimeIntervalQuantities(), o.getPriceTimeIntervalQuantities(), (Consumer<BigDecimal>) this::addPriceTimeIntervalQuantities);
			merger.mergeBasic(getDeliveryStartDateAndTime(), o.getDeliveryStartDateAndTime(), (Consumer<ZonedDateTime>) this::addDeliveryStartDateAndTime);
			merger.mergeBasic(getQuantityUnit(), o.getQuantityUnit(), (Consumer<String>) this::addQuantityUnit);
			merger.mergeBasic(getElectricityPhysicalLegDeliveryStepQuantity(), o.getElectricityPhysicalLegDeliveryStepQuantity(), (Consumer<BigDecimal>) this::addElectricityPhysicalLegDeliveryStepQuantity);
			merger.mergeBasic(getElectricityPhysicalLegDeliveryStepQuantityFrequency(), o.getElectricityPhysicalLegDeliveryStepQuantityFrequency(), (Consumer<String>) this::addElectricityPhysicalLegDeliveryStepQuantityFrequency);
			merger.mergeBasic(getElectricityPhysicalLegDeliveryStepQuantityUnit(), o.getElectricityPhysicalLegDeliveryStepQuantityUnit(), (Consumer<String>) this::addElectricityPhysicalLegDeliveryStepQuantityUnit);
			merger.mergeBasic(getProductGrade(), o.getProductGrade(), (Consumer<String>) this::addProductGrade);
			merger.mergeBasic(getBasketWeightPercentage(), o.getBasketWeightPercentage(), (Consumer<BigDecimal>) this::addBasketWeightPercentage);
			merger.mergeBasic(getReferenceObligationType(), o.getReferenceObligationType(), (Consumer<String>) this::addReferenceObligationType);
			merger.mergeBasic(getUnderlyingAssetPlaceOfIncorporation(), o.getUnderlyingAssetPlaceOfIncorporation(), (Consumer<String>) this::addUnderlyingAssetPlaceOfIncorporation);
			merger.mergeBasic(getUnderlyingAssetPlaceOfIssuance(), o.getUnderlyingAssetPlaceOfIssuance(), (Consumer<String>) this::addUnderlyingAssetPlaceOfIssuance);
			merger.mergeBasic(getReferenceEntityId(), o.getReferenceEntityId(), (Consumer<String>) this::addReferenceEntityId);
			merger.mergeBasic(getReferenceEntityIdType(), o.getReferenceEntityIdType(), (Consumer<String>) this::addReferenceEntityIdType);
			merger.mergeBasic(getUnderlyingAssetFixedRate(), o.getUnderlyingAssetFixedRate(), (Consumer<BigDecimal>) this::addUnderlyingAssetFixedRate);
			merger.mergeBasic(getUnderlyingAssetNotionalCurrency(), o.getUnderlyingAssetNotionalCurrency(), (Consumer<String>) this::addUnderlyingAssetNotionalCurrency);
			merger.mergeBasic(getPeriodStartDate(), o.getPeriodStartDate(), (Consumer<Date>) this::addPeriodStartDate);
			merger.mergeBasic(getPeriodEndDate(), o.getPeriodEndDate(), (Consumer<Date>) this::addPeriodEndDate);
			merger.mergeBasic(getPeriodFixedStrike(), o.getPeriodFixedStrike(), (Consumer<BigDecimal>) this::addPeriodFixedStrike);
			merger.mergeBasic(getPeriodFixedAmount(), o.getPeriodFixedAmount(), (Consumer<BigDecimal>) this::addPeriodFixedAmount);
			merger.mergeBasic(getUnderlyingAssetNotionalAmount(), o.getUnderlyingAssetNotionalAmount(), (Consumer<BigDecimal>) this::addUnderlyingAssetNotionalAmount);
			merger.mergeBasic(getDividendPaymentDate(), o.getDividendPaymentDate(), (Consumer<Date>) this::addDividendPaymentDate);
			merger.mergeBasic(getFixedAmountPaymentDate(), o.getFixedAmountPaymentDate(), (Consumer<Date>) this::addFixedAmountPaymentDate);
			merger.mergeBasic(getLeg1PaymentDates(), o.getLeg1PaymentDates(), (Consumer<Date>) this::addLeg1PaymentDates);
			merger.mergeBasic(getLeg2PaymentDates(), o.getLeg2PaymentDates(), (Consumer<Date>) this::addLeg2PaymentDates);
			merger.mergeBasic(getUnderlyingAssetInitialPrice(), o.getUnderlyingAssetInitialPrice(), (Consumer<BigDecimal>) this::addUnderlyingAssetInitialPrice);
			merger.mergeBasic(getCancelationOptionExerciseDates(), o.getCancelationOptionExerciseDates(), (Consumer<Date>) this::addCancelationOptionExerciseDates);
			merger.mergeBasic(getCancelationOptionRelevantUnderlyingDates(), o.getCancelationOptionRelevantUnderlyingDates(), (Consumer<Date>) this::addCancelationOptionRelevantUnderlyingDates);
			merger.mergeBasic(getCapRateStepDate(), o.getCapRateStepDate(), (Consumer<Date>) this::addCapRateStepDate);
			merger.mergeBasic(getCapRateStepValues(), o.getCapRateStepValues(), (Consumer<BigDecimal>) this::addCapRateStepValues);
			merger.mergeBasic(getExerciseDates(), o.getExerciseDates(), (Consumer<Date>) this::addExerciseDates);
			merger.mergeBasic(getFloorRateStepDate(), o.getFloorRateStepDate(), (Consumer<Date>) this::addFloorRateStepDate);
			merger.mergeBasic(getFloorRateStepValue(), o.getFloorRateStepValue(), (Consumer<BigDecimal>) this::addFloorRateStepValue);
			merger.mergeBasic(getLeg1FixedRateStepDate(), o.getLeg1FixedRateStepDate(), (Consumer<Date>) this::addLeg1FixedRateStepDate);
			merger.mergeBasic(getLeg1FixedRateStepValues(), o.getLeg1FixedRateStepValues(), (Consumer<BigDecimal>) this::addLeg1FixedRateStepValues);
			merger.mergeBasic(getLeg1FloatingRateMultiplierStepDate(), o.getLeg1FloatingRateMultiplierStepDate(), (Consumer<Date>) this::addLeg1FloatingRateMultiplierStepDate);
			merger.mergeBasic(getLeg1FloatingRateMultiplierStepValues(), o.getLeg1FloatingRateMultiplierStepValues(), (Consumer<BigDecimal>) this::addLeg1FloatingRateMultiplierStepValues);
			merger.mergeBasic(getLeg1FloatingRateSpreadStepDate(), o.getLeg1FloatingRateSpreadStepDate(), (Consumer<Date>) this::addLeg1FloatingRateSpreadStepDate);
			merger.mergeBasic(getLeg1FloatingRateSpreadStepValues(), o.getLeg1FloatingRateSpreadStepValues(), (Consumer<BigDecimal>) this::addLeg1FloatingRateSpreadStepValues);
			merger.mergeBasic(getLeg1NotionalStepDate(), o.getLeg1NotionalStepDate(), (Consumer<Date>) this::addLeg1NotionalStepDate);
			merger.mergeBasic(getLeg1NotionalStepValues(), o.getLeg1NotionalStepValues(), (Consumer<BigDecimal>) this::addLeg1NotionalStepValues);
			merger.mergeBasic(getLeg2FixedRateStepDate(), o.getLeg2FixedRateStepDate(), (Consumer<Date>) this::addLeg2FixedRateStepDate);
			merger.mergeBasic(getLeg2FixedRateStepValues(), o.getLeg2FixedRateStepValues(), (Consumer<BigDecimal>) this::addLeg2FixedRateStepValues);
			merger.mergeBasic(getLeg2FloatingRateMultiplierStepDate(), o.getLeg2FloatingRateMultiplierStepDate(), (Consumer<Date>) this::addLeg2FloatingRateMultiplierStepDate);
			merger.mergeBasic(getLeg2FloatingRateMultiplierStepValues(), o.getLeg2FloatingRateMultiplierStepValues(), (Consumer<BigDecimal>) this::addLeg2FloatingRateMultiplierStepValues);
			merger.mergeBasic(getLeg2FloatingRateSpreadStepDate(), o.getLeg2FloatingRateSpreadStepDate(), (Consumer<Date>) this::addLeg2FloatingRateSpreadStepDate);
			merger.mergeBasic(getLeg2FloatingRateSpreadStepValues(), o.getLeg2FloatingRateSpreadStepValues(), (Consumer<BigDecimal>) this::addLeg2FloatingRateSpreadStepValues);
			merger.mergeBasic(getLeg2NotionalStepDate(), o.getLeg2NotionalStepDate(), (Consumer<Date>) this::addLeg2NotionalStepDate);
			merger.mergeBasic(getLeg2NotionalStepValues(), o.getLeg2NotionalStepValues(), (Consumer<BigDecimal>) this::addLeg2NotionalStepValues);
			merger.mergeBasic(getOptionalEarlyTerminationDates(), o.getOptionalEarlyTerminationDates(), (Consumer<Date>) this::addOptionalEarlyTerminationDates);
			merger.mergeBasic(getOptionalEarlyTerminationExerciseDates(), o.getOptionalEarlyTerminationExerciseDates(), (Consumer<Date>) this::addOptionalEarlyTerminationExerciseDates);
			merger.mergeBasic(getOptionalEarlyTerminationUnderlyingDates(), o.getOptionalEarlyTerminationUnderlyingDates(), (Consumer<Date>) this::addOptionalEarlyTerminationUnderlyingDates);
			merger.mergeBasic(getRelevantUnderlyingDatesUnadjustedDates(), o.getRelevantUnderlyingDatesUnadjustedDates(), (Consumer<Date>) this::addRelevantUnderlyingDatesUnadjustedDates);
			merger.mergeBasic(getOptionalEarlyTerminationExerciseAdjustedDates(), o.getOptionalEarlyTerminationExerciseAdjustedDates(), (Consumer<Date>) this::addOptionalEarlyTerminationExerciseAdjustedDates);
			merger.mergeBasic(getUnderlyingAssetId(), o.getUnderlyingAssetId(), (Consumer<String>) this::addUnderlyingAssetId);
			merger.mergeBasic(getUnderlyingAssetIdType(), o.getUnderlyingAssetIdType(), (Consumer<String>) this::addUnderlyingAssetIdType);
			merger.mergeBasic(getUnderlyingAssetName(), o.getUnderlyingAssetName(), (Consumer<String>) this::addUnderlyingAssetName);
			merger.mergeBasic(getMandatoryClearingJurisdiction(), o.getMandatoryClearingJurisdiction(), (Consumer<String>) this::addMandatoryClearingJurisdiction);
			merger.mergeBasic(getClearingSwapUsiId(), o.getClearingSwapUsiId(), (Consumer<String>) this::addClearingSwapUsiId);
			merger.mergeBasic(getClearingSwapUsiIdPrefix(), o.getClearingSwapUsiIdPrefix(), (Consumer<String>) this::addClearingSwapUsiIdPrefix);
			merger.mergeBasic(getTradeParty1LocalCounterpartyJurisdiction(), o.getTradeParty1LocalCounterpartyJurisdiction(), (Consumer<String>) this::addTradeParty1LocalCounterpartyJurisdiction);
			merger.mergeBasic(getTradeParty2LocalCounterpartyJurisdiction(), o.getTradeParty2LocalCounterpartyJurisdiction(), (Consumer<String>) this::addTradeParty2LocalCounterpartyJurisdiction);
			merger.mergeBasic(getClearingExceptionTypeParty2(), o.getClearingExceptionTypeParty2(), (Consumer<String>) this::addClearingExceptionTypeParty2);
			merger.mergeBasic(getCdeOtherPaymentPayer(), o.getCdeOtherPaymentPayer(), (Consumer<String>) this::addCdeOtherPaymentPayer);
			merger.mergeBasic(getCdeOtherPaymentReceiver(), o.getCdeOtherPaymentReceiver(), (Consumer<String>) this::addCdeOtherPaymentReceiver);
			merger.mergeBasic(getCdeOtherPaymentType(), o.getCdeOtherPaymentType(), (Consumer<String>) this::addCdeOtherPaymentType);
			merger.mergeBasic(getCdeOtherPaymentAmount(), o.getCdeOtherPaymentAmount(), (Consumer<BigDecimal>) this::addCdeOtherPaymentAmount);
			merger.mergeBasic(getCdeOtherPaymentCurrency(), o.getCdeOtherPaymentCurrency(), (Consumer<String>) this::addCdeOtherPaymentCurrency);
			merger.mergeBasic(getCdeOtherPaymentDate(), o.getCdeOtherPaymentDate(), (Consumer<Date>) this::addCdeOtherPaymentDate);
			merger.mergeBasic(getOtherPaymentPayerIdType(), o.getOtherPaymentPayerIdType(), (Consumer<String>) this::addOtherPaymentPayerIdType);
			merger.mergeBasic(getOtherPaymentReceiverIdType(), o.getOtherPaymentReceiverIdType(), (Consumer<String>) this::addOtherPaymentReceiverIdType);
			merger.mergeBasic(getCdeEffectiveDateOfNotionalQuantityOfLeg1(), o.getCdeEffectiveDateOfNotionalQuantityOfLeg1(), (Consumer<Date>) this::addCdeEffectiveDateOfNotionalQuantityOfLeg1);
			merger.mergeBasic(getCdeEffectiveDateOfNotionalQuantityOfLeg2(), o.getCdeEffectiveDateOfNotionalQuantityOfLeg2(), (Consumer<Date>) this::addCdeEffectiveDateOfNotionalQuantityOfLeg2);
			merger.mergeBasic(getCdeEndDateOfNotionalQuantityOfLeg1(), o.getCdeEndDateOfNotionalQuantityOfLeg1(), (Consumer<Date>) this::addCdeEndDateOfNotionalQuantityOfLeg1);
			merger.mergeBasic(getCdeEndDateOfNotionalQuantityOfLeg2(), o.getCdeEndDateOfNotionalQuantityOfLeg2(), (Consumer<Date>) this::addCdeEndDateOfNotionalQuantityOfLeg2);
			merger.mergeBasic(getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1(), o.getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1(), (Consumer<BigDecimal>) this::addCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1);
			merger.mergeBasic(getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2(), o.getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2(), (Consumer<BigDecimal>) this::addCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2);
			merger.mergeBasic(getCdeBasketConstituentsIdentifier(), o.getCdeBasketConstituentsIdentifier(), (Consumer<String>) this::addCdeBasketConstituentsIdentifier);
			merger.mergeBasic(getCdeBasketConstituentsIdentifierSource(), o.getCdeBasketConstituentsIdentifierSource(), (Consumer<String>) this::addCdeBasketConstituentsIdentifierSource);
			merger.mergeBasic(getCdeBasketConstituentsNumberOfUnits(), o.getCdeBasketConstituentsNumberOfUnits(), (Consumer<BigDecimal>) this::addCdeBasketConstituentsNumberOfUnits);
			merger.mergeBasic(getCdeBasketConstituentsUnitOfMeasure(), o.getCdeBasketConstituentsUnitOfMeasure(), (Consumer<String>) this::addCdeBasketConstituentsUnitOfMeasure);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			HarmonizedRepeatableData _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeParty1ReportingDestination, _that.getTradeParty1ReportingDestination())) return false;
			if (!ListEquals.listEquals(tradeParty2ReportingDestination, _that.getTradeParty2ReportingDestination())) return false;
			if (!ListEquals.listEquals(tradeParty1ThirdPartyViewerId, _that.getTradeParty1ThirdPartyViewerId())) return false;
			if (!ListEquals.listEquals(tradeParty2ThirdPartyViewerId, _that.getTradeParty2ThirdPartyViewerId())) return false;
			if (!ListEquals.listEquals(tradeParty1ThirdPartyViewerIdType, _that.getTradeParty1ThirdPartyViewerIdType())) return false;
			if (!ListEquals.listEquals(tradeParty2ThirdPartyViewerIdType, _that.getTradeParty2ThirdPartyViewerIdType())) return false;
			if (!ListEquals.listEquals(leg1QuantityUnit, _that.getLeg1QuantityUnit())) return false;
			if (!ListEquals.listEquals(leg1QuantityFrequency, _that.getLeg1QuantityFrequency())) return false;
			if (!ListEquals.listEquals(leg1Quantity, _that.getLeg1Quantity())) return false;
			if (!ListEquals.listEquals(deliveryPoint, _that.getDeliveryPoint())) return false;
			if (!ListEquals.listEquals(loadDeliveryIntervals, _that.getLoadDeliveryIntervals())) return false;
			if (!ListEquals.listEquals(deliveryEndDateAndTime, _that.getDeliveryEndDateAndTime())) return false;
			if (!ListEquals.listEquals(duration, _that.getDuration())) return false;
			if (!ListEquals.listEquals(deliveryCapacity, _that.getDeliveryCapacity())) return false;
			if (!ListEquals.listEquals(priceTimeIntervalQuantities, _that.getPriceTimeIntervalQuantities())) return false;
			if (!ListEquals.listEquals(deliveryStartDateAndTime, _that.getDeliveryStartDateAndTime())) return false;
			if (!ListEquals.listEquals(quantityUnit, _that.getQuantityUnit())) return false;
			if (!ListEquals.listEquals(electricityPhysicalLegDeliveryStepQuantity, _that.getElectricityPhysicalLegDeliveryStepQuantity())) return false;
			if (!ListEquals.listEquals(electricityPhysicalLegDeliveryStepQuantityFrequency, _that.getElectricityPhysicalLegDeliveryStepQuantityFrequency())) return false;
			if (!ListEquals.listEquals(electricityPhysicalLegDeliveryStepQuantityUnit, _that.getElectricityPhysicalLegDeliveryStepQuantityUnit())) return false;
			if (!ListEquals.listEquals(productGrade, _that.getProductGrade())) return false;
			if (!ListEquals.listEquals(basketWeightPercentage, _that.getBasketWeightPercentage())) return false;
			if (!ListEquals.listEquals(referenceObligationType, _that.getReferenceObligationType())) return false;
			if (!ListEquals.listEquals(underlyingAssetPlaceOfIncorporation, _that.getUnderlyingAssetPlaceOfIncorporation())) return false;
			if (!ListEquals.listEquals(underlyingAssetPlaceOfIssuance, _that.getUnderlyingAssetPlaceOfIssuance())) return false;
			if (!ListEquals.listEquals(referenceEntityId, _that.getReferenceEntityId())) return false;
			if (!ListEquals.listEquals(referenceEntityIdType, _that.getReferenceEntityIdType())) return false;
			if (!ListEquals.listEquals(underlyingAssetFixedRate, _that.getUnderlyingAssetFixedRate())) return false;
			if (!ListEquals.listEquals(underlyingAssetNotionalCurrency, _that.getUnderlyingAssetNotionalCurrency())) return false;
			if (!ListEquals.listEquals(periodStartDate, _that.getPeriodStartDate())) return false;
			if (!ListEquals.listEquals(periodEndDate, _that.getPeriodEndDate())) return false;
			if (!ListEquals.listEquals(periodFixedStrike, _that.getPeriodFixedStrike())) return false;
			if (!ListEquals.listEquals(periodFixedAmount, _that.getPeriodFixedAmount())) return false;
			if (!ListEquals.listEquals(underlyingAssetNotionalAmount, _that.getUnderlyingAssetNotionalAmount())) return false;
			if (!ListEquals.listEquals(dividendPaymentDate, _that.getDividendPaymentDate())) return false;
			if (!ListEquals.listEquals(fixedAmountPaymentDate, _that.getFixedAmountPaymentDate())) return false;
			if (!ListEquals.listEquals(leg1PaymentDates, _that.getLeg1PaymentDates())) return false;
			if (!ListEquals.listEquals(leg2PaymentDates, _that.getLeg2PaymentDates())) return false;
			if (!ListEquals.listEquals(underlyingAssetInitialPrice, _that.getUnderlyingAssetInitialPrice())) return false;
			if (!ListEquals.listEquals(cancelationOptionExerciseDates, _that.getCancelationOptionExerciseDates())) return false;
			if (!ListEquals.listEquals(cancelationOptionRelevantUnderlyingDates, _that.getCancelationOptionRelevantUnderlyingDates())) return false;
			if (!ListEquals.listEquals(capRateStepDate, _that.getCapRateStepDate())) return false;
			if (!ListEquals.listEquals(capRateStepValues, _that.getCapRateStepValues())) return false;
			if (!ListEquals.listEquals(exerciseDates, _that.getExerciseDates())) return false;
			if (!ListEquals.listEquals(floorRateStepDate, _that.getFloorRateStepDate())) return false;
			if (!ListEquals.listEquals(floorRateStepValue, _that.getFloorRateStepValue())) return false;
			if (!ListEquals.listEquals(leg1FixedRateStepDate, _that.getLeg1FixedRateStepDate())) return false;
			if (!ListEquals.listEquals(leg1FixedRateStepValues, _that.getLeg1FixedRateStepValues())) return false;
			if (!ListEquals.listEquals(leg1FloatingRateMultiplierStepDate, _that.getLeg1FloatingRateMultiplierStepDate())) return false;
			if (!ListEquals.listEquals(leg1FloatingRateMultiplierStepValues, _that.getLeg1FloatingRateMultiplierStepValues())) return false;
			if (!ListEquals.listEquals(leg1FloatingRateSpreadStepDate, _that.getLeg1FloatingRateSpreadStepDate())) return false;
			if (!ListEquals.listEquals(leg1FloatingRateSpreadStepValues, _that.getLeg1FloatingRateSpreadStepValues())) return false;
			if (!ListEquals.listEquals(leg1NotionalStepDate, _that.getLeg1NotionalStepDate())) return false;
			if (!ListEquals.listEquals(leg1NotionalStepValues, _that.getLeg1NotionalStepValues())) return false;
			if (!ListEquals.listEquals(leg2FixedRateStepDate, _that.getLeg2FixedRateStepDate())) return false;
			if (!ListEquals.listEquals(leg2FixedRateStepValues, _that.getLeg2FixedRateStepValues())) return false;
			if (!ListEquals.listEquals(leg2FloatingRateMultiplierStepDate, _that.getLeg2FloatingRateMultiplierStepDate())) return false;
			if (!ListEquals.listEquals(leg2FloatingRateMultiplierStepValues, _that.getLeg2FloatingRateMultiplierStepValues())) return false;
			if (!ListEquals.listEquals(leg2FloatingRateSpreadStepDate, _that.getLeg2FloatingRateSpreadStepDate())) return false;
			if (!ListEquals.listEquals(leg2FloatingRateSpreadStepValues, _that.getLeg2FloatingRateSpreadStepValues())) return false;
			if (!ListEquals.listEquals(leg2NotionalStepDate, _that.getLeg2NotionalStepDate())) return false;
			if (!ListEquals.listEquals(leg2NotionalStepValues, _that.getLeg2NotionalStepValues())) return false;
			if (!ListEquals.listEquals(optionalEarlyTerminationDates, _that.getOptionalEarlyTerminationDates())) return false;
			if (!ListEquals.listEquals(optionalEarlyTerminationExerciseDates, _that.getOptionalEarlyTerminationExerciseDates())) return false;
			if (!ListEquals.listEquals(optionalEarlyTerminationUnderlyingDates, _that.getOptionalEarlyTerminationUnderlyingDates())) return false;
			if (!ListEquals.listEquals(relevantUnderlyingDatesUnadjustedDates, _that.getRelevantUnderlyingDatesUnadjustedDates())) return false;
			if (!ListEquals.listEquals(optionalEarlyTerminationExerciseAdjustedDates, _that.getOptionalEarlyTerminationExerciseAdjustedDates())) return false;
			if (!ListEquals.listEquals(underlyingAssetId, _that.getUnderlyingAssetId())) return false;
			if (!ListEquals.listEquals(underlyingAssetIdType, _that.getUnderlyingAssetIdType())) return false;
			if (!ListEquals.listEquals(underlyingAssetName, _that.getUnderlyingAssetName())) return false;
			if (!ListEquals.listEquals(mandatoryClearingJurisdiction, _that.getMandatoryClearingJurisdiction())) return false;
			if (!ListEquals.listEquals(clearingSwapUsiId, _that.getClearingSwapUsiId())) return false;
			if (!ListEquals.listEquals(clearingSwapUsiIdPrefix, _that.getClearingSwapUsiIdPrefix())) return false;
			if (!ListEquals.listEquals(tradeParty1LocalCounterpartyJurisdiction, _that.getTradeParty1LocalCounterpartyJurisdiction())) return false;
			if (!ListEquals.listEquals(tradeParty2LocalCounterpartyJurisdiction, _that.getTradeParty2LocalCounterpartyJurisdiction())) return false;
			if (!ListEquals.listEquals(clearingExceptionTypeParty2, _that.getClearingExceptionTypeParty2())) return false;
			if (!ListEquals.listEquals(cdeOtherPaymentPayer, _that.getCdeOtherPaymentPayer())) return false;
			if (!ListEquals.listEquals(cdeOtherPaymentReceiver, _that.getCdeOtherPaymentReceiver())) return false;
			if (!ListEquals.listEquals(cdeOtherPaymentType, _that.getCdeOtherPaymentType())) return false;
			if (!ListEquals.listEquals(cdeOtherPaymentAmount, _that.getCdeOtherPaymentAmount())) return false;
			if (!ListEquals.listEquals(cdeOtherPaymentCurrency, _that.getCdeOtherPaymentCurrency())) return false;
			if (!ListEquals.listEquals(cdeOtherPaymentDate, _that.getCdeOtherPaymentDate())) return false;
			if (!ListEquals.listEquals(otherPaymentPayerIdType, _that.getOtherPaymentPayerIdType())) return false;
			if (!ListEquals.listEquals(otherPaymentReceiverIdType, _that.getOtherPaymentReceiverIdType())) return false;
			if (!ListEquals.listEquals(cdeEffectiveDateOfNotionalQuantityOfLeg1, _that.getCdeEffectiveDateOfNotionalQuantityOfLeg1())) return false;
			if (!ListEquals.listEquals(cdeEffectiveDateOfNotionalQuantityOfLeg2, _that.getCdeEffectiveDateOfNotionalQuantityOfLeg2())) return false;
			if (!ListEquals.listEquals(cdeEndDateOfNotionalQuantityOfLeg1, _that.getCdeEndDateOfNotionalQuantityOfLeg1())) return false;
			if (!ListEquals.listEquals(cdeEndDateOfNotionalQuantityOfLeg2, _that.getCdeEndDateOfNotionalQuantityOfLeg2())) return false;
			if (!ListEquals.listEquals(cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1, _that.getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1())) return false;
			if (!ListEquals.listEquals(cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2, _that.getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2())) return false;
			if (!ListEquals.listEquals(cdeBasketConstituentsIdentifier, _that.getCdeBasketConstituentsIdentifier())) return false;
			if (!ListEquals.listEquals(cdeBasketConstituentsIdentifierSource, _that.getCdeBasketConstituentsIdentifierSource())) return false;
			if (!ListEquals.listEquals(cdeBasketConstituentsNumberOfUnits, _that.getCdeBasketConstituentsNumberOfUnits())) return false;
			if (!ListEquals.listEquals(cdeBasketConstituentsUnitOfMeasure, _that.getCdeBasketConstituentsUnitOfMeasure())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeParty1ReportingDestination != null ? tradeParty1ReportingDestination.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ReportingDestination != null ? tradeParty2ReportingDestination.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ThirdPartyViewerId != null ? tradeParty1ThirdPartyViewerId.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ThirdPartyViewerId != null ? tradeParty2ThirdPartyViewerId.hashCode() : 0);
			_result = 31 * _result + (tradeParty1ThirdPartyViewerIdType != null ? tradeParty1ThirdPartyViewerIdType.hashCode() : 0);
			_result = 31 * _result + (tradeParty2ThirdPartyViewerIdType != null ? tradeParty2ThirdPartyViewerIdType.hashCode() : 0);
			_result = 31 * _result + (leg1QuantityUnit != null ? leg1QuantityUnit.hashCode() : 0);
			_result = 31 * _result + (leg1QuantityFrequency != null ? leg1QuantityFrequency.hashCode() : 0);
			_result = 31 * _result + (leg1Quantity != null ? leg1Quantity.hashCode() : 0);
			_result = 31 * _result + (deliveryPoint != null ? deliveryPoint.hashCode() : 0);
			_result = 31 * _result + (loadDeliveryIntervals != null ? loadDeliveryIntervals.hashCode() : 0);
			_result = 31 * _result + (deliveryEndDateAndTime != null ? deliveryEndDateAndTime.hashCode() : 0);
			_result = 31 * _result + (duration != null ? duration.hashCode() : 0);
			_result = 31 * _result + (deliveryCapacity != null ? deliveryCapacity.hashCode() : 0);
			_result = 31 * _result + (priceTimeIntervalQuantities != null ? priceTimeIntervalQuantities.hashCode() : 0);
			_result = 31 * _result + (deliveryStartDateAndTime != null ? deliveryStartDateAndTime.hashCode() : 0);
			_result = 31 * _result + (quantityUnit != null ? quantityUnit.hashCode() : 0);
			_result = 31 * _result + (electricityPhysicalLegDeliveryStepQuantity != null ? electricityPhysicalLegDeliveryStepQuantity.hashCode() : 0);
			_result = 31 * _result + (electricityPhysicalLegDeliveryStepQuantityFrequency != null ? electricityPhysicalLegDeliveryStepQuantityFrequency.hashCode() : 0);
			_result = 31 * _result + (electricityPhysicalLegDeliveryStepQuantityUnit != null ? electricityPhysicalLegDeliveryStepQuantityUnit.hashCode() : 0);
			_result = 31 * _result + (productGrade != null ? productGrade.hashCode() : 0);
			_result = 31 * _result + (basketWeightPercentage != null ? basketWeightPercentage.hashCode() : 0);
			_result = 31 * _result + (referenceObligationType != null ? referenceObligationType.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetPlaceOfIncorporation != null ? underlyingAssetPlaceOfIncorporation.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetPlaceOfIssuance != null ? underlyingAssetPlaceOfIssuance.hashCode() : 0);
			_result = 31 * _result + (referenceEntityId != null ? referenceEntityId.hashCode() : 0);
			_result = 31 * _result + (referenceEntityIdType != null ? referenceEntityIdType.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetFixedRate != null ? underlyingAssetFixedRate.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetNotionalCurrency != null ? underlyingAssetNotionalCurrency.hashCode() : 0);
			_result = 31 * _result + (periodStartDate != null ? periodStartDate.hashCode() : 0);
			_result = 31 * _result + (periodEndDate != null ? periodEndDate.hashCode() : 0);
			_result = 31 * _result + (periodFixedStrike != null ? periodFixedStrike.hashCode() : 0);
			_result = 31 * _result + (periodFixedAmount != null ? periodFixedAmount.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetNotionalAmount != null ? underlyingAssetNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (dividendPaymentDate != null ? dividendPaymentDate.hashCode() : 0);
			_result = 31 * _result + (fixedAmountPaymentDate != null ? fixedAmountPaymentDate.hashCode() : 0);
			_result = 31 * _result + (leg1PaymentDates != null ? leg1PaymentDates.hashCode() : 0);
			_result = 31 * _result + (leg2PaymentDates != null ? leg2PaymentDates.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetInitialPrice != null ? underlyingAssetInitialPrice.hashCode() : 0);
			_result = 31 * _result + (cancelationOptionExerciseDates != null ? cancelationOptionExerciseDates.hashCode() : 0);
			_result = 31 * _result + (cancelationOptionRelevantUnderlyingDates != null ? cancelationOptionRelevantUnderlyingDates.hashCode() : 0);
			_result = 31 * _result + (capRateStepDate != null ? capRateStepDate.hashCode() : 0);
			_result = 31 * _result + (capRateStepValues != null ? capRateStepValues.hashCode() : 0);
			_result = 31 * _result + (exerciseDates != null ? exerciseDates.hashCode() : 0);
			_result = 31 * _result + (floorRateStepDate != null ? floorRateStepDate.hashCode() : 0);
			_result = 31 * _result + (floorRateStepValue != null ? floorRateStepValue.hashCode() : 0);
			_result = 31 * _result + (leg1FixedRateStepDate != null ? leg1FixedRateStepDate.hashCode() : 0);
			_result = 31 * _result + (leg1FixedRateStepValues != null ? leg1FixedRateStepValues.hashCode() : 0);
			_result = 31 * _result + (leg1FloatingRateMultiplierStepDate != null ? leg1FloatingRateMultiplierStepDate.hashCode() : 0);
			_result = 31 * _result + (leg1FloatingRateMultiplierStepValues != null ? leg1FloatingRateMultiplierStepValues.hashCode() : 0);
			_result = 31 * _result + (leg1FloatingRateSpreadStepDate != null ? leg1FloatingRateSpreadStepDate.hashCode() : 0);
			_result = 31 * _result + (leg1FloatingRateSpreadStepValues != null ? leg1FloatingRateSpreadStepValues.hashCode() : 0);
			_result = 31 * _result + (leg1NotionalStepDate != null ? leg1NotionalStepDate.hashCode() : 0);
			_result = 31 * _result + (leg1NotionalStepValues != null ? leg1NotionalStepValues.hashCode() : 0);
			_result = 31 * _result + (leg2FixedRateStepDate != null ? leg2FixedRateStepDate.hashCode() : 0);
			_result = 31 * _result + (leg2FixedRateStepValues != null ? leg2FixedRateStepValues.hashCode() : 0);
			_result = 31 * _result + (leg2FloatingRateMultiplierStepDate != null ? leg2FloatingRateMultiplierStepDate.hashCode() : 0);
			_result = 31 * _result + (leg2FloatingRateMultiplierStepValues != null ? leg2FloatingRateMultiplierStepValues.hashCode() : 0);
			_result = 31 * _result + (leg2FloatingRateSpreadStepDate != null ? leg2FloatingRateSpreadStepDate.hashCode() : 0);
			_result = 31 * _result + (leg2FloatingRateSpreadStepValues != null ? leg2FloatingRateSpreadStepValues.hashCode() : 0);
			_result = 31 * _result + (leg2NotionalStepDate != null ? leg2NotionalStepDate.hashCode() : 0);
			_result = 31 * _result + (leg2NotionalStepValues != null ? leg2NotionalStepValues.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationDates != null ? optionalEarlyTerminationDates.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationExerciseDates != null ? optionalEarlyTerminationExerciseDates.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationUnderlyingDates != null ? optionalEarlyTerminationUnderlyingDates.hashCode() : 0);
			_result = 31 * _result + (relevantUnderlyingDatesUnadjustedDates != null ? relevantUnderlyingDatesUnadjustedDates.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTerminationExerciseAdjustedDates != null ? optionalEarlyTerminationExerciseAdjustedDates.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetId != null ? underlyingAssetId.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetIdType != null ? underlyingAssetIdType.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetName != null ? underlyingAssetName.hashCode() : 0);
			_result = 31 * _result + (mandatoryClearingJurisdiction != null ? mandatoryClearingJurisdiction.hashCode() : 0);
			_result = 31 * _result + (clearingSwapUsiId != null ? clearingSwapUsiId.hashCode() : 0);
			_result = 31 * _result + (clearingSwapUsiIdPrefix != null ? clearingSwapUsiIdPrefix.hashCode() : 0);
			_result = 31 * _result + (tradeParty1LocalCounterpartyJurisdiction != null ? tradeParty1LocalCounterpartyJurisdiction.hashCode() : 0);
			_result = 31 * _result + (tradeParty2LocalCounterpartyJurisdiction != null ? tradeParty2LocalCounterpartyJurisdiction.hashCode() : 0);
			_result = 31 * _result + (clearingExceptionTypeParty2 != null ? clearingExceptionTypeParty2.hashCode() : 0);
			_result = 31 * _result + (cdeOtherPaymentPayer != null ? cdeOtherPaymentPayer.hashCode() : 0);
			_result = 31 * _result + (cdeOtherPaymentReceiver != null ? cdeOtherPaymentReceiver.hashCode() : 0);
			_result = 31 * _result + (cdeOtherPaymentType != null ? cdeOtherPaymentType.hashCode() : 0);
			_result = 31 * _result + (cdeOtherPaymentAmount != null ? cdeOtherPaymentAmount.hashCode() : 0);
			_result = 31 * _result + (cdeOtherPaymentCurrency != null ? cdeOtherPaymentCurrency.hashCode() : 0);
			_result = 31 * _result + (cdeOtherPaymentDate != null ? cdeOtherPaymentDate.hashCode() : 0);
			_result = 31 * _result + (otherPaymentPayerIdType != null ? otherPaymentPayerIdType.hashCode() : 0);
			_result = 31 * _result + (otherPaymentReceiverIdType != null ? otherPaymentReceiverIdType.hashCode() : 0);
			_result = 31 * _result + (cdeEffectiveDateOfNotionalQuantityOfLeg1 != null ? cdeEffectiveDateOfNotionalQuantityOfLeg1.hashCode() : 0);
			_result = 31 * _result + (cdeEffectiveDateOfNotionalQuantityOfLeg2 != null ? cdeEffectiveDateOfNotionalQuantityOfLeg2.hashCode() : 0);
			_result = 31 * _result + (cdeEndDateOfNotionalQuantityOfLeg1 != null ? cdeEndDateOfNotionalQuantityOfLeg1.hashCode() : 0);
			_result = 31 * _result + (cdeEndDateOfNotionalQuantityOfLeg2 != null ? cdeEndDateOfNotionalQuantityOfLeg2.hashCode() : 0);
			_result = 31 * _result + (cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1 != null ? cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1.hashCode() : 0);
			_result = 31 * _result + (cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2 != null ? cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2.hashCode() : 0);
			_result = 31 * _result + (cdeBasketConstituentsIdentifier != null ? cdeBasketConstituentsIdentifier.hashCode() : 0);
			_result = 31 * _result + (cdeBasketConstituentsIdentifierSource != null ? cdeBasketConstituentsIdentifierSource.hashCode() : 0);
			_result = 31 * _result + (cdeBasketConstituentsNumberOfUnits != null ? cdeBasketConstituentsNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (cdeBasketConstituentsUnitOfMeasure != null ? cdeBasketConstituentsUnitOfMeasure.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HarmonizedRepeatableDataBuilder {" +
				"tradeParty1ReportingDestination=" + this.tradeParty1ReportingDestination + ", " +
				"tradeParty2ReportingDestination=" + this.tradeParty2ReportingDestination + ", " +
				"tradeParty1ThirdPartyViewerId=" + this.tradeParty1ThirdPartyViewerId + ", " +
				"tradeParty2ThirdPartyViewerId=" + this.tradeParty2ThirdPartyViewerId + ", " +
				"tradeParty1ThirdPartyViewerIdType=" + this.tradeParty1ThirdPartyViewerIdType + ", " +
				"tradeParty2ThirdPartyViewerIdType=" + this.tradeParty2ThirdPartyViewerIdType + ", " +
				"leg1QuantityUnit=" + this.leg1QuantityUnit + ", " +
				"leg1QuantityFrequency=" + this.leg1QuantityFrequency + ", " +
				"leg1Quantity=" + this.leg1Quantity + ", " +
				"deliveryPoint=" + this.deliveryPoint + ", " +
				"loadDeliveryIntervals=" + this.loadDeliveryIntervals + ", " +
				"deliveryEndDateAndTime=" + this.deliveryEndDateAndTime + ", " +
				"duration=" + this.duration + ", " +
				"deliveryCapacity=" + this.deliveryCapacity + ", " +
				"priceTimeIntervalQuantities=" + this.priceTimeIntervalQuantities + ", " +
				"deliveryStartDateAndTime=" + this.deliveryStartDateAndTime + ", " +
				"quantityUnit=" + this.quantityUnit + ", " +
				"electricityPhysicalLegDeliveryStepQuantity=" + this.electricityPhysicalLegDeliveryStepQuantity + ", " +
				"electricityPhysicalLegDeliveryStepQuantityFrequency=" + this.electricityPhysicalLegDeliveryStepQuantityFrequency + ", " +
				"electricityPhysicalLegDeliveryStepQuantityUnit=" + this.electricityPhysicalLegDeliveryStepQuantityUnit + ", " +
				"productGrade=" + this.productGrade + ", " +
				"basketWeightPercentage=" + this.basketWeightPercentage + ", " +
				"referenceObligationType=" + this.referenceObligationType + ", " +
				"underlyingAssetPlaceOfIncorporation=" + this.underlyingAssetPlaceOfIncorporation + ", " +
				"underlyingAssetPlaceOfIssuance=" + this.underlyingAssetPlaceOfIssuance + ", " +
				"referenceEntityId=" + this.referenceEntityId + ", " +
				"referenceEntityIdType=" + this.referenceEntityIdType + ", " +
				"underlyingAssetFixedRate=" + this.underlyingAssetFixedRate + ", " +
				"underlyingAssetNotionalCurrency=" + this.underlyingAssetNotionalCurrency + ", " +
				"periodStartDate=" + this.periodStartDate + ", " +
				"periodEndDate=" + this.periodEndDate + ", " +
				"periodFixedStrike=" + this.periodFixedStrike + ", " +
				"periodFixedAmount=" + this.periodFixedAmount + ", " +
				"underlyingAssetNotionalAmount=" + this.underlyingAssetNotionalAmount + ", " +
				"dividendPaymentDate=" + this.dividendPaymentDate + ", " +
				"fixedAmountPaymentDate=" + this.fixedAmountPaymentDate + ", " +
				"leg1PaymentDates=" + this.leg1PaymentDates + ", " +
				"leg2PaymentDates=" + this.leg2PaymentDates + ", " +
				"underlyingAssetInitialPrice=" + this.underlyingAssetInitialPrice + ", " +
				"cancelationOptionExerciseDates=" + this.cancelationOptionExerciseDates + ", " +
				"cancelationOptionRelevantUnderlyingDates=" + this.cancelationOptionRelevantUnderlyingDates + ", " +
				"capRateStepDate=" + this.capRateStepDate + ", " +
				"capRateStepValues=" + this.capRateStepValues + ", " +
				"exerciseDates=" + this.exerciseDates + ", " +
				"floorRateStepDate=" + this.floorRateStepDate + ", " +
				"floorRateStepValue=" + this.floorRateStepValue + ", " +
				"leg1FixedRateStepDate=" + this.leg1FixedRateStepDate + ", " +
				"leg1FixedRateStepValues=" + this.leg1FixedRateStepValues + ", " +
				"leg1FloatingRateMultiplierStepDate=" + this.leg1FloatingRateMultiplierStepDate + ", " +
				"leg1FloatingRateMultiplierStepValues=" + this.leg1FloatingRateMultiplierStepValues + ", " +
				"leg1FloatingRateSpreadStepDate=" + this.leg1FloatingRateSpreadStepDate + ", " +
				"leg1FloatingRateSpreadStepValues=" + this.leg1FloatingRateSpreadStepValues + ", " +
				"leg1NotionalStepDate=" + this.leg1NotionalStepDate + ", " +
				"leg1NotionalStepValues=" + this.leg1NotionalStepValues + ", " +
				"leg2FixedRateStepDate=" + this.leg2FixedRateStepDate + ", " +
				"leg2FixedRateStepValues=" + this.leg2FixedRateStepValues + ", " +
				"leg2FloatingRateMultiplierStepDate=" + this.leg2FloatingRateMultiplierStepDate + ", " +
				"leg2FloatingRateMultiplierStepValues=" + this.leg2FloatingRateMultiplierStepValues + ", " +
				"leg2FloatingRateSpreadStepDate=" + this.leg2FloatingRateSpreadStepDate + ", " +
				"leg2FloatingRateSpreadStepValues=" + this.leg2FloatingRateSpreadStepValues + ", " +
				"leg2NotionalStepDate=" + this.leg2NotionalStepDate + ", " +
				"leg2NotionalStepValues=" + this.leg2NotionalStepValues + ", " +
				"optionalEarlyTerminationDates=" + this.optionalEarlyTerminationDates + ", " +
				"optionalEarlyTerminationExerciseDates=" + this.optionalEarlyTerminationExerciseDates + ", " +
				"optionalEarlyTerminationUnderlyingDates=" + this.optionalEarlyTerminationUnderlyingDates + ", " +
				"relevantUnderlyingDatesUnadjustedDates=" + this.relevantUnderlyingDatesUnadjustedDates + ", " +
				"optionalEarlyTerminationExerciseAdjustedDates=" + this.optionalEarlyTerminationExerciseAdjustedDates + ", " +
				"underlyingAssetId=" + this.underlyingAssetId + ", " +
				"underlyingAssetIdType=" + this.underlyingAssetIdType + ", " +
				"underlyingAssetName=" + this.underlyingAssetName + ", " +
				"mandatoryClearingJurisdiction=" + this.mandatoryClearingJurisdiction + ", " +
				"clearingSwapUsiId=" + this.clearingSwapUsiId + ", " +
				"clearingSwapUsiIdPrefix=" + this.clearingSwapUsiIdPrefix + ", " +
				"tradeParty1LocalCounterpartyJurisdiction=" + this.tradeParty1LocalCounterpartyJurisdiction + ", " +
				"tradeParty2LocalCounterpartyJurisdiction=" + this.tradeParty2LocalCounterpartyJurisdiction + ", " +
				"clearingExceptionTypeParty2=" + this.clearingExceptionTypeParty2 + ", " +
				"cdeOtherPaymentPayer=" + this.cdeOtherPaymentPayer + ", " +
				"cdeOtherPaymentReceiver=" + this.cdeOtherPaymentReceiver + ", " +
				"cdeOtherPaymentType=" + this.cdeOtherPaymentType + ", " +
				"cdeOtherPaymentAmount=" + this.cdeOtherPaymentAmount + ", " +
				"cdeOtherPaymentCurrency=" + this.cdeOtherPaymentCurrency + ", " +
				"cdeOtherPaymentDate=" + this.cdeOtherPaymentDate + ", " +
				"otherPaymentPayerIdType=" + this.otherPaymentPayerIdType + ", " +
				"otherPaymentReceiverIdType=" + this.otherPaymentReceiverIdType + ", " +
				"cdeEffectiveDateOfNotionalQuantityOfLeg1=" + this.cdeEffectiveDateOfNotionalQuantityOfLeg1 + ", " +
				"cdeEffectiveDateOfNotionalQuantityOfLeg2=" + this.cdeEffectiveDateOfNotionalQuantityOfLeg2 + ", " +
				"cdeEndDateOfNotionalQuantityOfLeg1=" + this.cdeEndDateOfNotionalQuantityOfLeg1 + ", " +
				"cdeEndDateOfNotionalQuantityOfLeg2=" + this.cdeEndDateOfNotionalQuantityOfLeg2 + ", " +
				"cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1=" + this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1 + ", " +
				"cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2=" + this.cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2 + ", " +
				"cdeBasketConstituentsIdentifier=" + this.cdeBasketConstituentsIdentifier + ", " +
				"cdeBasketConstituentsIdentifierSource=" + this.cdeBasketConstituentsIdentifierSource + ", " +
				"cdeBasketConstituentsNumberOfUnits=" + this.cdeBasketConstituentsNumberOfUnits + ", " +
				"cdeBasketConstituentsUnitOfMeasure=" + this.cdeBasketConstituentsUnitOfMeasure +
			'}';
		}
	}
}
