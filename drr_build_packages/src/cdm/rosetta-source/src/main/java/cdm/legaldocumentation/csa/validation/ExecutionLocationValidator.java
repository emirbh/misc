package cdm.legaldocumentation.csa.validation;

import cdm.legaldocumentation.common.ExecutionLocationEnum;
import cdm.legaldocumentation.csa.ExecutionLocation;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExecutionLocationValidator implements Validator<ExecutionLocation> {

	private List<ComparisonResult> getComparisonResults(ExecutionLocation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("executionLocation", (ExecutionLocationEnum) o.getExecutionLocation() != null ? 1 : 0, 1, 1), 
				checkCardinality("otherLanguage", (String) o.getOtherLanguage() != null ? 1 : 0, 0, 1), 
				checkCardinality("dutyPayer", (String) o.getDutyPayer() != null ? 1 : 0, 0, 1), 
				checkCardinality("dutyPayerLanguage", (String) o.getDutyPayerLanguage() != null ? 1 : 0, 0, 1), 
				checkCardinality("dutyPaymentDate", (Date) o.getDutyPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("dutyPaymentLanguage", (String) o.getDutyPaymentLanguage() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExecutionLocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExecutionLocation", ValidationResult.ValidationType.CARDINALITY, "ExecutionLocation", path, "", res.getError());
				}
				return success("ExecutionLocation", ValidationResult.ValidationType.CARDINALITY, "ExecutionLocation", path, "");
			})
			.collect(toList());
	}

}
