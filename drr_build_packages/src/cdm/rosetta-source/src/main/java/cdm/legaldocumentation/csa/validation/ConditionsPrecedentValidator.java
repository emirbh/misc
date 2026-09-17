package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.AccessConditions;
import cdm.legaldocumentation.csa.ConditionsPrecedent;
import cdm.legaldocumentation.csa.ExceptionEnum;
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

public class ConditionsPrecedentValidator implements Validator<ConditionsPrecedent> {

	private List<ComparisonResult> getComparisonResults(ConditionsPrecedent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("conditionsPrecedentElection", (ExceptionEnum) o.getConditionsPrecedentElection() != null ? 1 : 0, 0, 1), 
				checkCardinality("customProvision", (String) o.getCustomProvision() != null ? 1 : 0, 0, 1), 
				checkCardinality("accessConditions", (AccessConditions) o.getAccessConditions() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ConditionsPrecedent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ConditionsPrecedent", ValidationResult.ValidationType.CARDINALITY, "ConditionsPrecedent", path, "", res.getError());
				}
				return success("ConditionsPrecedent", ValidationResult.ValidationType.CARDINALITY, "ConditionsPrecedent", path, "");
			})
			.collect(toList());
	}

}
