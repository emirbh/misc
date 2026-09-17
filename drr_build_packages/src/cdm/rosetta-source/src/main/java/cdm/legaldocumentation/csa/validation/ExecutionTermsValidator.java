package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.csa.ExecutionLanguage;
import cdm.legaldocumentation.csa.ExecutionLocation;
import cdm.legaldocumentation.csa.ExecutionTerms;
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

public class ExecutionTermsValidator implements Validator<ExecutionTerms> {

	private List<ComparisonResult> getComparisonResults(ExecutionTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("executionLanguage", (ExecutionLanguage) o.getExecutionLanguage() != null ? 1 : 0, 1, 1), 
				checkCardinality("executionLocation", (ExecutionLocation) o.getExecutionLocation() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExecutionTerms", ValidationResult.ValidationType.CARDINALITY, "ExecutionTerms", path, "", res.getError());
				}
				return success("ExecutionTerms", ValidationResult.ValidationType.CARDINALITY, "ExecutionTerms", path, "");
			})
			.collect(toList());
	}

}
