package drr.standards.iosco.upi.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.standards.iosco.upi.AnnaDsbCategory;
import drr.standards.iosco.upi.AnnaDsbRateGroup;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AnnaDsbCategoryValidator implements Validator<AnnaDsbCategory> {

	private List<ComparisonResult> getComparisonResults(AnnaDsbCategory o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("Swaps", (AnnaDsbRateGroup) o.getSwaps() != null ? 1 : 0, 0, 1), 
				checkCardinality("NonListedAndComplexListedOptions", (AnnaDsbRateGroup) o.getNonListedAndComplexListedOptions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AnnaDsbCategory o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AnnaDsbCategory", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbCategory", path, "", res.getError());
				}
				return success("AnnaDsbCategory", ValidationResult.ValidationType.CARDINALITY, "AnnaDsbCategory", path, "");
			})
			.collect(toList());
	}

}
