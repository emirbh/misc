package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.EnforcementEvent;
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

public class EnforcementEventValidator implements Validator<EnforcementEvent> {

	private List<ComparisonResult> getComparisonResults(EnforcementEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("earlyTerminationDate", (Boolean) o.getEarlyTerminationDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("failureToPay", (Boolean) o.getFailureToPay() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, EnforcementEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("EnforcementEvent", ValidationResult.ValidationType.CARDINALITY, "EnforcementEvent", path, "", res.getError());
				}
				return success("EnforcementEvent", ValidationResult.ValidationType.CARDINALITY, "EnforcementEvent", path, "");
			})
			.collect(toList());
	}

}
