package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.Infinity;
import cdm.legaldocumentation.csa.ThresholdFixedAmount;
import cdm.legaldocumentation.csa.ThresholdRatingsBased;
import cdm.legaldocumentation.csa.ThresholdType;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ThresholdTypeValidator implements Validator<ThresholdType> {

	private List<ComparisonResult> getComparisonResults(ThresholdType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fixedAmount", (ThresholdFixedAmount) o.getFixedAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("ratingsBased", (ThresholdRatingsBased) o.getRatingsBased() != null ? 1 : 0, 0, 1), 
				checkCardinality("infinity", (Infinity) o.getInfinity() != null ? 1 : 0, 0, 1), 
				checkCardinality("other", (String) o.getOther() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ThresholdType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ThresholdType", ValidationResult.ValidationType.CARDINALITY, "ThresholdType", path, "", res.getError());
				}
				return success("ThresholdType", ValidationResult.ValidationType.CARDINALITY, "ThresholdType", path, "");
			})
			.collect(toList());
	}

}
