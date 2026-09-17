package cdm.regulation.validation;

import cdm.regulation.Swp;
import cdm.regulation.SwpIn;
import cdm.regulation.SwpOut;
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

public class SwpValidator implements Validator<Swp> {

	private List<ComparisonResult> getComparisonResults(Swp o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("swpIn", (SwpIn) o.getSwpIn() != null ? 1 : 0, 1, 1), 
				checkCardinality("swpOut", (SwpOut) o.getSwpOut() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Swp o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Swp", ValidationResult.ValidationType.CARDINALITY, "Swp", path, "", res.getError());
				}
				return success("Swp", ValidationResult.ValidationType.CARDINALITY, "Swp", path, "");
			})
			.collect(toList());
	}

}
