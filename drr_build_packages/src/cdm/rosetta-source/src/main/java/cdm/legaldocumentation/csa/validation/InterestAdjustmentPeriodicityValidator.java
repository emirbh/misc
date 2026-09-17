package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.InterestAdjustmentPeriodicity;
import cdm.legaldocumentation.csa.InterestAdjustmentPeriodicityEnum;
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

public class InterestAdjustmentPeriodicityValidator implements Validator<InterestAdjustmentPeriodicity> {

	private List<ComparisonResult> getComparisonResults(InterestAdjustmentPeriodicity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("standardElection", (InterestAdjustmentPeriodicityEnum) o.getStandardElection() != null ? 1 : 0, 0, 1), 
				checkCardinality("customElection", (String) o.getCustomElection() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestAdjustmentPeriodicity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestAdjustmentPeriodicity", ValidationResult.ValidationType.CARDINALITY, "InterestAdjustmentPeriodicity", path, "", res.getError());
				}
				return success("InterestAdjustmentPeriodicity", ValidationResult.ValidationType.CARDINALITY, "InterestAdjustmentPeriodicity", path, "");
			})
			.collect(toList());
	}

}
