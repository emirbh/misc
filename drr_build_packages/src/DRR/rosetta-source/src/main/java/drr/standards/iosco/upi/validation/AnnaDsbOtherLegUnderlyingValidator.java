package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbEmpty;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlierIDSourceEnum;
import drr.standards.iosco.upi.AnnaDsbOtherLegUnderlying;
import drr.standards.iosco.upi.AnnaDsbUnderlierCharacteristicEnum;
import drr.standards.iosco.upi.AnnaDsbUnderlyingInstrumentIndexTermUnitEnum;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbOtherLegUnderlyingValidator implements Validator<AnnaDsbOtherLegUnderlying> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbOtherLegUnderlying o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("OtherLegUnderlierID", (String) o.getOtherLegUnderlierID() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegReferenceRate", (String) o.getOtherLegReferenceRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegReferenceRateTermUnit", (AnnaDsbUnderlyingInstrumentIndexTermUnitEnum) o.getOtherLegReferenceRateTermUnit() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegUnderlierCharacteristic", (AnnaDsbUnderlierCharacteristicEnum) o.getOtherLegUnderlierCharacteristic() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegUnderlierIDSource", (AnnaDsbOtherLegUnderlierIDSourceEnum) o.getOtherLegUnderlierIDSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("Basket", (AnnaDsbEmpty) o.getBasket() != null ? 1 : 0, 0, 1), 
				checkCardinality("OtherLegReferenceRateTermValue", (Integer) o.getOtherLegReferenceRateTermValue() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbOtherLegUnderlying o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbOtherLegUnderlying", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbOtherLegUnderlying", path, "", res.getError());
				}
				return success("AnnaDsbOtherLegUnderlying", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbOtherLegUnderlying", path, "");
			})
			.collect(toList());
	}

}
