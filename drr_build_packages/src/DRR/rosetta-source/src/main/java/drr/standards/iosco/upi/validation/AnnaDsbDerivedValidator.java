package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbCFIDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbCFIOptionStyleandTypeEnum;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbDerived;
import drr.standards.iosco.upi.AnnaDsbOptionExerciseStyleEnum;
import drr.standards.iosco.upi.AnnaDsbReturnorPayoutTriggerEnum;
import drr.standards.iosco.upi.AnnaDsbSingleorMultiCurrencyEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetClass;
import drr.standards.iosco.upi.AnnaDsbUnderlyingAssetTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingIssuerTypeEnum;
import drr.standards.iosco.upi.AnnaDsbValuationMethodorTriggerEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbDerivedValidator implements Validator<AnnaDsbDerived> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbDerived o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ReturnorPayoutTrigger", (AnnaDsbReturnorPayoutTriggerEnum) o.getReturnorPayoutTrigger() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierCharacteristic", (String) o.getUnderlierCharacteristic() != null ? 1 : 0, 0, 1), 
				checkCardinality("ValuationMethodorTrigger", (AnnaDsbValuationMethodorTriggerEnum) o.getValuationMethodorTrigger() != null ? 1 : 0, 0, 1), 
				checkCardinality("ShortName", (String) o.getShortName() != null ? 1 : 0, 1, 1), 
				checkCardinality("UnderlyingIssuerType", (AnnaDsbUnderlyingIssuerTypeEnum) o.getUnderlyingIssuerType() != null ? 1 : 0, 0, 1), 
				checkCardinality("ClassificationType", (String) o.getClassificationType() != null ? 1 : 0, 1, 1), 
				checkCardinality("OptionExerciseStyle", (AnnaDsbOptionExerciseStyleEnum) o.getOptionExerciseStyle() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingAssetType", (AnnaDsbUnderlyingAssetTypeEnum) o.getUnderlyingAssetType() != null ? 1 : 0, 0, 1), 
				checkCardinality("SingleorMultiCurrency", (AnnaDsbSingleorMultiCurrencyEnum) o.getSingleorMultiCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("CFIDeliveryType", (AnnaDsbCFIDeliveryTypeEnum) o.getCFIDeliveryType() != null ? 1 : 0, 0, 1), 
				checkCardinality("CFIOptionStyleandType", (AnnaDsbCFIOptionStyleandTypeEnum) o.getCFIOptionStyleandType() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierName", (String) o.getUnderlierName() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingAssetClass", (AnnaDsbUnderlyingAssetClass) o.getUnderlyingAssetClass() != null ? 1 : 0, 0, 1), 
				checkCardinality("DeliveryType", (AnnaDsbDeliveryTypeEnum) o.getDeliveryType() != null ? 1 : 0, 0, 1), 
				checkCardinality("FurtherGrouping", (String) o.getFurtherGrouping() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbDerived o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbDerived", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbDerived", path, "", res.getError());
				}
				return success("AnnaDsbDerived", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbDerived", path, "");
			})
			.collect(toList());
	}

}
