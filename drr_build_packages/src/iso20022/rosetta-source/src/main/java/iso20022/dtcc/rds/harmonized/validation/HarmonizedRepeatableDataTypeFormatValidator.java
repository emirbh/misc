package iso20022.dtcc.rds.harmonized.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.dtcc.rds.harmonized.HarmonizedRepeatableData;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class HarmonizedRepeatableDataTypeFormatValidator implements Validator<HarmonizedRepeatableData> {

	private List<ComparisonResult> getComparisonResults(HarmonizedRepeatableData o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("tradeParty1ReportingDestination", o.getTradeParty1ReportingDestination(), 0, of(200), empty()), 
				checkString("tradeParty2ReportingDestination", o.getTradeParty2ReportingDestination(), 0, of(200), empty()), 
				checkString("tradeParty1ThirdPartyViewerId", o.getTradeParty1ThirdPartyViewerId(), 0, of(200), empty()), 
				checkString("tradeParty2ThirdPartyViewerId", o.getTradeParty2ThirdPartyViewerId(), 0, of(200), empty()), 
				checkString("tradeParty1ThirdPartyViewerIdType", o.getTradeParty1ThirdPartyViewerIdType(), 0, of(500), empty()), 
				checkString("tradeParty2ThirdPartyViewerIdType", o.getTradeParty2ThirdPartyViewerIdType(), 0, of(500), empty()), 
				checkString("leg1QuantityUnit", o.getLeg1QuantityUnit(), 0, of(500), empty()), 
				checkString("leg1QuantityFrequency", o.getLeg1QuantityFrequency(), 0, of(500), empty()), 
				checkString("deliveryPoint", o.getDeliveryPoint(), 0, of(40), empty()), 
				checkString("duration", o.getDuration(), 0, of(500), empty()), 
				checkString("deliveryCapacity", o.getDeliveryCapacity(), 0, of(50), empty()), 
				checkString("quantityUnit", o.getQuantityUnit(), 0, of(500), empty()), 
				checkString("electricityPhysicalLegDeliveryStepQuantityFrequency", o.getElectricityPhysicalLegDeliveryStepQuantityFrequency(), 0, of(500), empty()), 
				checkString("electricityPhysicalLegDeliveryStepQuantityUnit", o.getElectricityPhysicalLegDeliveryStepQuantityUnit(), 0, of(500), empty()), 
				checkString("productGrade", o.getProductGrade(), 0, of(50), empty()), 
				checkString("referenceObligationType", o.getReferenceObligationType(), 0, of(500), empty()), 
				checkString("underlyingAssetPlaceOfIncorporation", o.getUnderlyingAssetPlaceOfIncorporation(), 0, of(500), empty()), 
				checkString("underlyingAssetPlaceOfIssuance", o.getUnderlyingAssetPlaceOfIssuance(), 0, of(500), empty()), 
				checkString("referenceEntityId", o.getReferenceEntityId(), 0, of(200), empty()), 
				checkString("referenceEntityIdType", o.getReferenceEntityIdType(), 0, of(500), empty()), 
				checkString("underlyingAssetNotionalCurrency", o.getUnderlyingAssetNotionalCurrency(), 0, of(500), empty()), 
				checkString("underlyingAssetId", o.getUnderlyingAssetId(), 0, of(200), empty()), 
				checkString("underlyingAssetIdType", o.getUnderlyingAssetIdType(), 0, of(500), empty()), 
				checkString("underlyingAssetName", o.getUnderlyingAssetName(), 0, of(100), empty()), 
				checkString("mandatoryClearingJurisdiction", o.getMandatoryClearingJurisdiction(), 0, of(500), empty()), 
				checkString("clearingSwapUsiId", o.getClearingSwapUsiId(), 0, of(200), empty()), 
				checkString("clearingSwapUsiIdPrefix", o.getClearingSwapUsiIdPrefix(), 0, of(40), empty()), 
				checkString("tradeParty1LocalCounterpartyJurisdiction", o.getTradeParty1LocalCounterpartyJurisdiction(), 0, of(500), empty()), 
				checkString("tradeParty2LocalCounterpartyJurisdiction", o.getTradeParty2LocalCounterpartyJurisdiction(), 0, of(500), empty()), 
				checkString("clearingExceptionTypeParty2", o.getClearingExceptionTypeParty2(), 0, of(500), empty()), 
				checkString("cdeOtherPaymentPayer", o.getCdeOtherPaymentPayer(), 0, of(200), empty()), 
				checkString("cdeOtherPaymentReceiver", o.getCdeOtherPaymentReceiver(), 0, of(200), empty()), 
				checkString("cdeOtherPaymentType", o.getCdeOtherPaymentType(), 0, of(500), empty()), 
				checkString("cdeOtherPaymentCurrency", o.getCdeOtherPaymentCurrency(), 0, of(500), empty()), 
				checkString("otherPaymentPayerIdType", o.getOtherPaymentPayerIdType(), 0, of(500), empty()), 
				checkString("otherPaymentReceiverIdType", o.getOtherPaymentReceiverIdType(), 0, of(500), empty()), 
				checkString("cdeBasketConstituentsIdentifier", o.getCdeBasketConstituentsIdentifier(), 0, of(210), empty()), 
				checkString("cdeBasketConstituentsIdentifierSource", o.getCdeBasketConstituentsIdentifierSource(), 0, of(350), empty()), 
				checkString("cdeBasketConstituentsUnitOfMeasure", o.getCdeBasketConstituentsUnitOfMeasure(), 0, of(500), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, HarmonizedRepeatableData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("HarmonizedRepeatableData", ValidationResult.ValidationType.TYPE_FORMAT, "HarmonizedRepeatableData", path, "", res.getError());
				}
				return success("HarmonizedRepeatableData", ValidationResult.ValidationType.TYPE_FORMAT, "HarmonizedRepeatableData", path, "");
			})
			.collect(toList());
	}

}
