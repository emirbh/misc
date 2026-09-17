package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ResetCalculationDetails;
import fpml.consolidated.business.events.ResetCalculationElements;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ResetCalculationDetailsValidator implements Validator<ResetCalculationDetails> {

	private List<ComparisonResult> getComparisonResults(ResetCalculationDetails o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationElements", (ResetCalculationElements) o.getCalculationElements() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ResetCalculationDetails o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ResetCalculationDetails", ValidationResult.ValidationType.CARDINALITY, "ResetCalculationDetails", path, "", res.getError());
				}
				return success("ResetCalculationDetails", ValidationResult.ValidationType.CARDINALITY, "ResetCalculationDetails", path, "");
			})
			.collect(toList());
	}

}
