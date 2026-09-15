package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.FloatingRate13__3;
import iso20022.auth030.asic.ResetDateAndValue1__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FloatingRate13__3Validator implements Validator<FloatingRate13__3> {

	private List<ComparisonResult> getComparisonResults(FloatingRate13__3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("nxtFltgRst", (ResetDateAndValue1__1) o.getNxtFltgRst() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRate13__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRate13__3", ValidationResult.ValidationType.CARDINALITY, "FloatingRate13__3", path, "", res.getError());
				}
				return success("FloatingRate13__3", ValidationResult.ValidationType.CARDINALITY, "FloatingRate13__3", path, "");
			})
			.collect(toList());
	}

}
