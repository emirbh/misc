package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.ReplacementValue;
import fpml.consolidated.ird.ReplacementValueCalculationAgentDeterminationMethod;
import fpml.consolidated.ird.ReplacementValueFirmQuotationsMethod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReplacementValueValidator implements Validator<ReplacementValue> {

	private List<ComparisonResult> getComparisonResults(ReplacementValue o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("firmQuotations", (ReplacementValueFirmQuotationsMethod) o.getFirmQuotations() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationAgentDetermination", (ReplacementValueCalculationAgentDeterminationMethod) o.getCalculationAgentDetermination() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReplacementValue o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReplacementValue", ValidationResult.ValidationType.CARDINALITY, "ReplacementValue", path, "", res.getError());
				}
				return success("ReplacementValue", ValidationResult.ValidationType.CARDINALITY, "ReplacementValue", path, "");
			})
			.collect(toList());
	}

}
