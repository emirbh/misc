package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbAttributesRecord;
import drr.standards.iosco.upi.AnnaDsbContractSpecificationEnum;
import drr.standards.iosco.upi.AnnaDsbDebtSeniorityEnum;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbNotionalScheduleEnum;
import drr.standards.iosco.upi.AnnaDsbOptionExerciseStyleEnum;
import drr.standards.iosco.upi.AnnaDsbOptionTypeEnum;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlierType;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlying;
import drr.standards.iosco.upi.AnnaDsbOtherUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbOtherUnderlying;
import drr.standards.iosco.upi.AnnaDsbPlaceofSettlementEnum;
import drr.standards.iosco.upi.AnnaDsbReturnorPayoutTriggerEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierCharacteristicEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlying;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetClass;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingIssuerTypeEnum;
import drr.standards.iosco.upi.AnnaDsbValuationMethodorTriggerEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbAttributesRecordValidator implements Validator<AnnaDsbAttributesRecord> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbAttributesRecord o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ReturnorPayoutTrigger", (AnnaDsbReturnorPayoutTriggerEnum) o.getReturnorPayoutTrigger() != null ? 1 : 0, 0, 1), 
				checkCardinality("AdditionalSubProduct", (String) o.getAdditionalSubProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentIndexTermUnit", (AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getUnderlyingInstrumentIndexTermUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("ValuationMethodorTrigger", (AnnaDsbValuationMethodorTriggerEnum) o.getValuationMethodorTrigger() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentISIN", (String) o.getUnderlyingInstrumentISIN() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegReferenceRateTermUnit", (AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getOtherLegReferenceRateTermUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("NotionalSchedule", (AnnaDsbNotionalScheduleEnum) o.getNotionalSchedule() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherUnderlying", (AnnaDsbOtherUnderlying) o.getOtherUnderlying() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingIssuerType", (AnnaDsbUnderlyingIssuerTypeEnum) o.getUnderlyingIssuerType() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierIDSource", (AnnaDsbUnderlierIDSourceEnum) o.getUnderlierIDSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("PlaceofSettlement", (AnnaDsbPlaceofSettlementEnum) o.getPlaceofSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentIndexTermValue", (Integer) o.getUnderlyingInstrumentIndexTermValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("SettlementCurrency", (String) o.getSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentIndex", (String) o.getUnderlyingInstrumentIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("BaseProduct", (String) o.getBaseProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentUPI", (String) o.getUnderlyingInstrumentUPI() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegUnderlierType", (AnnaDsbOtherLegUnderlierType) o.getOtherLegUnderlierType() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingAssetClass", (AnnaDsbUnderlyingAssetClass) o.getUnderlyingAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("OptionType", (AnnaDsbOptionTypeEnum) o.getOptionType() != null ? 1 : 0, 0, 1), 
				checkCardinality("DeliveryType", (AnnaDsbDeliveryTypeEnum) o.getDeliveryType() != null ? 1 : 0, 0, 1), 
				checkCardinality("ContractSpecification", (AnnaDsbContractSpecificationEnum) o.getContractSpecification() != null ? 1 : 0, 0, 1), 
				checkCardinality("SubProduct", (String) o.getSubProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("DebtSeniority", (AnnaDsbDebtSeniorityEnum) o.getDebtSeniority() != null ? 1 : 0, 0, 1), 
				checkCardinality("ReferenceRate", (String) o.getReferenceRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierCharacteristic", (AnnaDsbUnderlierCharacteristicEnum) o.getUnderlierCharacteristic() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherUnderlierID", (String) o.getOtherUnderlierID() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherUnderlierIDSource", (AnnaDsbOtherUnderlierIDSourceEnum) o.getOtherUnderlierIDSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierID", (String) o.getUnderlierID() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherReferenceRate", (String) o.getOtherReferenceRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("NotionalCurrency", (String) o.getNotionalCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegUnderlying", (AnnaDsbOtherLegUnderlying) o.getOtherLegUnderlying() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherNotionalCurrency", (String) o.getOtherNotionalCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("ReferenceRateTermUnit", (AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getReferenceRateTermUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("OptionExerciseStyle", (AnnaDsbOptionExerciseStyleEnum) o.getOptionExerciseStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingAssetType", (AnnaDsbUnderlyingAssetTypeEnum) o.getUnderlyingAssetType() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegReferenceRateTermValue", (Integer) o.getOtherLegReferenceRateTermValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherUnderlierCharacteristic", (AnnaDsbUnderlierCharacteristicEnum) o.getOtherUnderlierCharacteristic() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegUnderlierID", (String) o.getOtherLegUnderlierID() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherSubProduct", (String) o.getOtherSubProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegReferenceRate", (String) o.getOtherLegReferenceRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("Underlying", (AnnaDsbUnderlying) o.getUnderlying() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherBaseProduct", (String) o.getOtherBaseProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentIndexProp", (String) o.getUnderlyingInstrumentIndexProp() != null ? 1 : 0, 0, 1), 
				checkCardinality("ReferenceRateTermValue", (Integer) o.getReferenceRateTermValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegUnderlierIDSource", (AnnaDsbOtherLegUnderlierIDSourceEnum) o.getOtherLegUnderlierIDSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherAdditionalSubProduct", (String) o.getOtherAdditionalSubProduct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbAttributesRecord o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbAttributesRecord", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbAttributesRecord", path, "", res.getError());
				}
				return success("AnnaDsbAttributesRecord", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbAttributesRecord", path, "");
			})
			.collect(toList());
	}

}
