package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.InterestComputationMethod4Code;
import iso20022.auth030.hkma.tr.InterestComputationMethodFormat7__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class InterestComputationMethodFormat7__1Validator implements Validator<InterestComputationMethodFormat7__1> {

	private List<ComparisonResult> getComparisonResults(InterestComputationMethodFormat7__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cd", (InterestComputationMethod4Code) o.getCd() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, InterestComputationMethodFormat7__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("InterestComputationMethodFormat7__1", ValidationResult.ValidationType.CARDINALITY, "InterestComputationMethodFormat7__1", path, "", res.getError());
				}
				return success("InterestComputationMethodFormat7__1", ValidationResult.ValidationType.CARDINALITY, "InterestComputationMethodFormat7__1", path, "");
			})
			.collect(toList());
	}

}
