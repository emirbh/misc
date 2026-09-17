package fpml.consolidated.recordkeeping.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.ESMABenchmarkIndexCode;
import fpml.consolidated.recordkeeping.processes.ESMAIndexIdentification;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ESMAIndexIdentificationValidator implements Validator<ESMAIndexIdentification> {

	private List<ComparisonResult> getComparisonResults(ESMAIndexIdentification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("code", (ESMABenchmarkIndexCode) o.getCode() != null ? 1 : 0, 0, 1), 
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ESMAIndexIdentification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ESMAIndexIdentification", ValidationResult.ValidationType.CARDINALITY, "ESMAIndexIdentification", path, "", res.getError());
				}
				return success("ESMAIndexIdentification", ValidationResult.ValidationType.CARDINALITY, "ESMAIndexIdentification", path, "");
			})
			.collect(toList());
	}

}
