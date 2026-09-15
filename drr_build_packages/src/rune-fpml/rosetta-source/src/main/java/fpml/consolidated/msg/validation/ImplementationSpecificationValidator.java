package fpml.consolidated.msg.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.msg.ImplementationSpecification;
import fpml.consolidated.msg.ImplementationSpecificationVersion;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ImplementationSpecificationValidator implements Validator<ImplementationSpecification> {

	private List<ComparisonResult> getComparisonResults(ImplementationSpecification o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("version", (ImplementationSpecificationVersion) o.getVersion() != null ? 1 : 0, 0, 1), 
				checkCardinality("date", (ZonedDateTime) o.getDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ImplementationSpecification o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ImplementationSpecification", ValidationResult.ValidationType.CARDINALITY, "ImplementationSpecification", path, "", res.getError());
				}
				return success("ImplementationSpecification", ValidationResult.ValidationType.CARDINALITY, "ImplementationSpecification", path, "");
			})
			.collect(toList());
	}

}
