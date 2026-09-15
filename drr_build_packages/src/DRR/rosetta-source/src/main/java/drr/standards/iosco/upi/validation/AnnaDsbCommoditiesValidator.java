package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbBaseProduct;
import drr.standards.iosco.upi.AnnaDsbCommodities;
import drr.standards.iosco.upi.AnnaDsbOtherUnderlying;
import drr.standards.iosco.upi.AnnaDsbReturnorPayoutTriggerEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlierCharacteristicEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlying;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbCommoditiesValidator implements Validator<AnnaDsbCommodities> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbCommodities o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("ReturnorPayoutTrigger", (AnnaDsbReturnorPayoutTriggerEnum) o.getReturnorPayoutTrigger() != null ? 1 : 0, 0, 1), 
				checkCardinality("SubProduct", (String) o.getSubProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierCharacteristic", (AnnaDsbUnderlierCharacteristicEnum) o.getUnderlierCharacteristic() != null ? 1 : 0, 0, 1), 
				checkCardinality("ReferenceRate", (String) o.getReferenceRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("AdditionalSubProduct", (String) o.getAdditionalSubProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherReferenceRate", (String) o.getOtherReferenceRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("NotionalCurrency", (String) o.getNotionalCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherNotionalCurrency", (String) o.getOtherNotionalCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherUnderlying", (AnnaDsbOtherUnderlying) o.getOtherUnderlying() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherUnderlierCharacteristic", (AnnaDsbUnderlierCharacteristicEnum) o.getOtherUnderlierCharacteristic() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherSubProduct", (String) o.getOtherSubProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("Underlying", (AnnaDsbUnderlying) o.getUnderlying() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherBaseProduct", (AnnaDsbBaseProduct) o.getOtherBaseProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentIndex", (String) o.getUnderlyingInstrumentIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlyingInstrumentIndexProp", (String) o.getUnderlyingInstrumentIndexProp() != null ? 1 : 0, 0, 1), 
				checkCardinality("BaseProduct", (AnnaDsbBaseProduct) o.getBaseProduct() != null ? 1 : 0, 0, 1), 
				checkCardinality("UnderlierName", (String) o.getUnderlierName() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherAdditionalSubProduct", (String) o.getOtherAdditionalSubProduct() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbCommodities o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbCommodities", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbCommodities", path, "", res.getError());
				}
				return success("AnnaDsbCommodities", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbCommodities", path, "");
			})
			.collect(toList());
	}

}
