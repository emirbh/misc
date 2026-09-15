package drr.enrichment.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.enrichment.upi.UpiData;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class UpiDataValidator implements Validator<UpiData> {

	private List<ComparisonResult> getComparisonResults(UpiData o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("upiRecord", (AnnaDsbUpiRecord) o.getUpiRecord() != null ? 1 : 0, 0, 1), 
				checkCardinality("upiOfUnderlying", (Boolean) o.getUpiOfUnderlying() != null ? 1 : 0, 0, 1), 
				checkCardinality("upiValidation", (Boolean) o.getUpiValidation() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UpiData o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UpiData", ValidationResult.ValidationType.CARDINALITY, "UpiData", path, "", res.getError());
				}
				return success("UpiData", ValidationResult.ValidationType.CARDINALITY, "UpiData", path, "");
			})
			.collect(toList());
	}

}
