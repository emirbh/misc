package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.DigestMethodType;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DigestMethodTypeValidator implements Validator<DigestMethodType> {

	private List<ComparisonResult> getComparisonResults(DigestMethodType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("algorithm", (String) o.getAlgorithm() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DigestMethodType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DigestMethodType", ValidationResult.ValidationType.CARDINALITY, "DigestMethodType", path, "", res.getError());
				}
				return success("DigestMethodType", ValidationResult.ValidationType.CARDINALITY, "DigestMethodType", path, "");
			})
			.collect(toList());
	}

}
