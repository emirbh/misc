package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.InterestAdjustment;
import cdm.legaldocumentation.csa.InterestAdjustmentPeriodicity;
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

public class InterestAdjustmentValidator implements Validator<InterestAdjustment> {

	private List<ComparisonResult> getComparisonResults(InterestAdjustment o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("isApplicable", (Boolean) o.getIsApplicable() != null ? 1 : 0, 1, 1), 
				checkCardinality("periodicity", (InterestAdjustmentPeriodicity) o.getPeriodicity() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestAdjustment o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestAdjustment", ValidationResult.ValidationType.CARDINALITY, "InterestAdjustment", path, "", res.getError());
				}
				return success("InterestAdjustment", ValidationResult.ValidationType.CARDINALITY, "InterestAdjustment", path, "");
			})
			.collect(toList());
	}

}
