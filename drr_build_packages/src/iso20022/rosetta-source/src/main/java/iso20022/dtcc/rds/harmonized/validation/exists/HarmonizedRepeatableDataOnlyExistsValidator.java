package iso20022.dtcc.rds.harmonized.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.HarmonizedRepeatableData;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class HarmonizedRepeatableDataOnlyExistsValidator implements ValidatorWithArg<HarmonizedRepeatableData, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends HarmonizedRepeatableData> ValidationResult<HarmonizedRepeatableData> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("tradeParty1ReportingDestination", ExistenceChecker.isSet((List<String>) o.getTradeParty1ReportingDestination()))
				.put("tradeParty2ReportingDestination", ExistenceChecker.isSet((List<String>) o.getTradeParty2ReportingDestination()))
				.put("tradeParty1ThirdPartyViewerId", ExistenceChecker.isSet((List<String>) o.getTradeParty1ThirdPartyViewerId()))
				.put("tradeParty2ThirdPartyViewerId", ExistenceChecker.isSet((List<String>) o.getTradeParty2ThirdPartyViewerId()))
				.put("tradeParty1ThirdPartyViewerIdType", ExistenceChecker.isSet((List<String>) o.getTradeParty1ThirdPartyViewerIdType()))
				.put("tradeParty2ThirdPartyViewerIdType", ExistenceChecker.isSet((List<String>) o.getTradeParty2ThirdPartyViewerIdType()))
				.put("leg1QuantityUnit", ExistenceChecker.isSet((List<String>) o.getLeg1QuantityUnit()))
				.put("leg1QuantityFrequency", ExistenceChecker.isSet((List<String>) o.getLeg1QuantityFrequency()))
				.put("leg1Quantity", ExistenceChecker.isSet((List<BigDecimal>) o.getLeg1Quantity()))
				.put("deliveryPoint", ExistenceChecker.isSet((List<String>) o.getDeliveryPoint()))
				.put("loadDeliveryIntervals", ExistenceChecker.isSet((List<LocalTime>) o.getLoadDeliveryIntervals()))
				.put("deliveryEndDateAndTime", ExistenceChecker.isSet((List<ZonedDateTime>) o.getDeliveryEndDateAndTime()))
				.put("duration", ExistenceChecker.isSet((List<String>) o.getDuration()))
				.put("deliveryCapacity", ExistenceChecker.isSet((List<String>) o.getDeliveryCapacity()))
				.put("priceTimeIntervalQuantities", ExistenceChecker.isSet((List<BigDecimal>) o.getPriceTimeIntervalQuantities()))
				.put("deliveryStartDateAndTime", ExistenceChecker.isSet((List<ZonedDateTime>) o.getDeliveryStartDateAndTime()))
				.put("quantityUnit", ExistenceChecker.isSet((List<String>) o.getQuantityUnit()))
				.put("electricityPhysicalLegDeliveryStepQuantity", ExistenceChecker.isSet((List<BigDecimal>) o.getElectricityPhysicalLegDeliveryStepQuantity()))
				.put("electricityPhysicalLegDeliveryStepQuantityFrequency", ExistenceChecker.isSet((List<String>) o.getElectricityPhysicalLegDeliveryStepQuantityFrequency()))
				.put("electricityPhysicalLegDeliveryStepQuantityUnit", ExistenceChecker.isSet((List<String>) o.getElectricityPhysicalLegDeliveryStepQuantityUnit()))
				.put("productGrade", ExistenceChecker.isSet((List<String>) o.getProductGrade()))
				.put("basketWeightPercentage", ExistenceChecker.isSet((List<BigDecimal>) o.getBasketWeightPercentage()))
				.put("referenceObligationType", ExistenceChecker.isSet((List<String>) o.getReferenceObligationType()))
				.put("underlyingAssetPlaceOfIncorporation", ExistenceChecker.isSet((List<String>) o.getUnderlyingAssetPlaceOfIncorporation()))
				.put("underlyingAssetPlaceOfIssuance", ExistenceChecker.isSet((List<String>) o.getUnderlyingAssetPlaceOfIssuance()))
				.put("referenceEntityId", ExistenceChecker.isSet((List<String>) o.getReferenceEntityId()))
				.put("referenceEntityIdType", ExistenceChecker.isSet((List<String>) o.getReferenceEntityIdType()))
				.put("underlyingAssetFixedRate", ExistenceChecker.isSet((List<BigDecimal>) o.getUnderlyingAssetFixedRate()))
				.put("underlyingAssetNotionalCurrency", ExistenceChecker.isSet((List<String>) o.getUnderlyingAssetNotionalCurrency()))
				.put("periodStartDate", ExistenceChecker.isSet((List<Date>) o.getPeriodStartDate()))
				.put("periodEndDate", ExistenceChecker.isSet((List<Date>) o.getPeriodEndDate()))
				.put("periodFixedStrike", ExistenceChecker.isSet((List<BigDecimal>) o.getPeriodFixedStrike()))
				.put("periodFixedAmount", ExistenceChecker.isSet((List<BigDecimal>) o.getPeriodFixedAmount()))
				.put("underlyingAssetNotionalAmount", ExistenceChecker.isSet((List<BigDecimal>) o.getUnderlyingAssetNotionalAmount()))
				.put("dividendPaymentDate", ExistenceChecker.isSet((List<Date>) o.getDividendPaymentDate()))
				.put("fixedAmountPaymentDate", ExistenceChecker.isSet((List<Date>) o.getFixedAmountPaymentDate()))
				.put("leg1PaymentDates", ExistenceChecker.isSet((List<Date>) o.getLeg1PaymentDates()))
				.put("leg2PaymentDates", ExistenceChecker.isSet((List<Date>) o.getLeg2PaymentDates()))
				.put("underlyingAssetInitialPrice", ExistenceChecker.isSet((List<BigDecimal>) o.getUnderlyingAssetInitialPrice()))
				.put("cancelationOptionExerciseDates", ExistenceChecker.isSet((List<Date>) o.getCancelationOptionExerciseDates()))
				.put("cancelationOptionRelevantUnderlyingDates", ExistenceChecker.isSet((List<Date>) o.getCancelationOptionRelevantUnderlyingDates()))
				.put("capRateStepDate", ExistenceChecker.isSet((List<Date>) o.getCapRateStepDate()))
				.put("capRateStepValues", ExistenceChecker.isSet((List<BigDecimal>) o.getCapRateStepValues()))
				.put("exerciseDates", ExistenceChecker.isSet((List<Date>) o.getExerciseDates()))
				.put("floorRateStepDate", ExistenceChecker.isSet((List<Date>) o.getFloorRateStepDate()))
				.put("floorRateStepValue", ExistenceChecker.isSet((List<BigDecimal>) o.getFloorRateStepValue()))
				.put("leg1FixedRateStepDate", ExistenceChecker.isSet((List<Date>) o.getLeg1FixedRateStepDate()))
				.put("leg1FixedRateStepValues", ExistenceChecker.isSet((List<BigDecimal>) o.getLeg1FixedRateStepValues()))
				.put("leg1FloatingRateMultiplierStepDate", ExistenceChecker.isSet((List<Date>) o.getLeg1FloatingRateMultiplierStepDate()))
				.put("leg1FloatingRateMultiplierStepValues", ExistenceChecker.isSet((List<BigDecimal>) o.getLeg1FloatingRateMultiplierStepValues()))
				.put("leg1FloatingRateSpreadStepDate", ExistenceChecker.isSet((List<Date>) o.getLeg1FloatingRateSpreadStepDate()))
				.put("leg1FloatingRateSpreadStepValues", ExistenceChecker.isSet((List<BigDecimal>) o.getLeg1FloatingRateSpreadStepValues()))
				.put("leg1NotionalStepDate", ExistenceChecker.isSet((List<Date>) o.getLeg1NotionalStepDate()))
				.put("leg1NotionalStepValues", ExistenceChecker.isSet((List<BigDecimal>) o.getLeg1NotionalStepValues()))
				.put("leg2FixedRateStepDate", ExistenceChecker.isSet((List<Date>) o.getLeg2FixedRateStepDate()))
				.put("leg2FixedRateStepValues", ExistenceChecker.isSet((List<BigDecimal>) o.getLeg2FixedRateStepValues()))
				.put("leg2FloatingRateMultiplierStepDate", ExistenceChecker.isSet((List<Date>) o.getLeg2FloatingRateMultiplierStepDate()))
				.put("leg2FloatingRateMultiplierStepValues", ExistenceChecker.isSet((List<BigDecimal>) o.getLeg2FloatingRateMultiplierStepValues()))
				.put("leg2FloatingRateSpreadStepDate", ExistenceChecker.isSet((List<Date>) o.getLeg2FloatingRateSpreadStepDate()))
				.put("leg2FloatingRateSpreadStepValues", ExistenceChecker.isSet((List<BigDecimal>) o.getLeg2FloatingRateSpreadStepValues()))
				.put("leg2NotionalStepDate", ExistenceChecker.isSet((List<Date>) o.getLeg2NotionalStepDate()))
				.put("leg2NotionalStepValues", ExistenceChecker.isSet((List<BigDecimal>) o.getLeg2NotionalStepValues()))
				.put("optionalEarlyTerminationDates", ExistenceChecker.isSet((List<Date>) o.getOptionalEarlyTerminationDates()))
				.put("optionalEarlyTerminationExerciseDates", ExistenceChecker.isSet((List<Date>) o.getOptionalEarlyTerminationExerciseDates()))
				.put("optionalEarlyTerminationUnderlyingDates", ExistenceChecker.isSet((List<Date>) o.getOptionalEarlyTerminationUnderlyingDates()))
				.put("relevantUnderlyingDatesUnadjustedDates", ExistenceChecker.isSet((List<Date>) o.getRelevantUnderlyingDatesUnadjustedDates()))
				.put("optionalEarlyTerminationExerciseAdjustedDates", ExistenceChecker.isSet((List<Date>) o.getOptionalEarlyTerminationExerciseAdjustedDates()))
				.put("underlyingAssetId", ExistenceChecker.isSet((List<String>) o.getUnderlyingAssetId()))
				.put("underlyingAssetIdType", ExistenceChecker.isSet((List<String>) o.getUnderlyingAssetIdType()))
				.put("underlyingAssetName", ExistenceChecker.isSet((List<String>) o.getUnderlyingAssetName()))
				.put("mandatoryClearingJurisdiction", ExistenceChecker.isSet((List<String>) o.getMandatoryClearingJurisdiction()))
				.put("clearingSwapUsiId", ExistenceChecker.isSet((List<String>) o.getClearingSwapUsiId()))
				.put("clearingSwapUsiIdPrefix", ExistenceChecker.isSet((List<String>) o.getClearingSwapUsiIdPrefix()))
				.put("tradeParty1LocalCounterpartyJurisdiction", ExistenceChecker.isSet((List<String>) o.getTradeParty1LocalCounterpartyJurisdiction()))
				.put("tradeParty2LocalCounterpartyJurisdiction", ExistenceChecker.isSet((List<String>) o.getTradeParty2LocalCounterpartyJurisdiction()))
				.put("clearingExceptionTypeParty2", ExistenceChecker.isSet((List<String>) o.getClearingExceptionTypeParty2()))
				.put("cdeOtherPaymentPayer", ExistenceChecker.isSet((List<String>) o.getCdeOtherPaymentPayer()))
				.put("cdeOtherPaymentReceiver", ExistenceChecker.isSet((List<String>) o.getCdeOtherPaymentReceiver()))
				.put("cdeOtherPaymentType", ExistenceChecker.isSet((List<String>) o.getCdeOtherPaymentType()))
				.put("cdeOtherPaymentAmount", ExistenceChecker.isSet((List<BigDecimal>) o.getCdeOtherPaymentAmount()))
				.put("cdeOtherPaymentCurrency", ExistenceChecker.isSet((List<String>) o.getCdeOtherPaymentCurrency()))
				.put("cdeOtherPaymentDate", ExistenceChecker.isSet((List<Date>) o.getCdeOtherPaymentDate()))
				.put("otherPaymentPayerIdType", ExistenceChecker.isSet((List<String>) o.getOtherPaymentPayerIdType()))
				.put("otherPaymentReceiverIdType", ExistenceChecker.isSet((List<String>) o.getOtherPaymentReceiverIdType()))
				.put("cdeEffectiveDateOfNotionalQuantityOfLeg1", ExistenceChecker.isSet((List<Date>) o.getCdeEffectiveDateOfNotionalQuantityOfLeg1()))
				.put("cdeEffectiveDateOfNotionalQuantityOfLeg2", ExistenceChecker.isSet((List<Date>) o.getCdeEffectiveDateOfNotionalQuantityOfLeg2()))
				.put("cdeEndDateOfNotionalQuantityOfLeg1", ExistenceChecker.isSet((List<Date>) o.getCdeEndDateOfNotionalQuantityOfLeg1()))
				.put("cdeEndDateOfNotionalQuantityOfLeg2", ExistenceChecker.isSet((List<Date>) o.getCdeEndDateOfNotionalQuantityOfLeg2()))
				.put("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1", ExistenceChecker.isSet((List<BigDecimal>) o.getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1()))
				.put("cdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2", ExistenceChecker.isSet((List<BigDecimal>) o.getCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2()))
				.put("cdeBasketConstituentsIdentifier", ExistenceChecker.isSet((List<String>) o.getCdeBasketConstituentsIdentifier()))
				.put("cdeBasketConstituentsIdentifierSource", ExistenceChecker.isSet((List<String>) o.getCdeBasketConstituentsIdentifierSource()))
				.put("cdeBasketConstituentsNumberOfUnits", ExistenceChecker.isSet((List<BigDecimal>) o.getCdeBasketConstituentsNumberOfUnits()))
				.put("cdeBasketConstituentsUnitOfMeasure", ExistenceChecker.isSet((List<String>) o.getCdeBasketConstituentsUnitOfMeasure()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("HarmonizedRepeatableData", ValidationResult.ValidationType.ONLY_EXISTS, "HarmonizedRepeatableData", path, "");
		}
		return failure("HarmonizedRepeatableData", ValidationResult.ValidationType.ONLY_EXISTS, "HarmonizedRepeatableData", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
