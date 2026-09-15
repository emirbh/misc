package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.CalculationAgentPartyEnum;
import fpml.consolidated.shared.CalculationAgent;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CalculationAgentValidator implements Validator<CalculationAgent> {

	private List<ComparisonResult> getComparisonResults(CalculationAgent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("calculationAgentParty", (CalculationAgentPartyEnum) o.getCalculationAgentParty() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationAgent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationAgent", ValidationResult.ValidationType.CARDINALITY, "CalculationAgent", path, "", res.getError());
				}
				return success("CalculationAgent", ValidationResult.ValidationType.CARDINALITY, "CalculationAgent", path, "");
			})
			.collect(toList());
	}

}
