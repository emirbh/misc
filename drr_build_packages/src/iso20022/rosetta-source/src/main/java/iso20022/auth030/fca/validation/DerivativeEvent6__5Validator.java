package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.DateAndDateTime2Choice__1;
import iso20022.auth030.fca.DerivativeEvent6__5;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DerivativeEvent6__5Validator implements Validator<DerivativeEvent6__5> {

	private List<ComparisonResult> getComparisonResults(DerivativeEvent6__5 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tmStmp", (DateAndDateTime2Choice__1) o.getTmStmp() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativeEvent6__5 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativeEvent6__5", ValidationResult.ValidationType.CARDINALITY, "DerivativeEvent6__5", path, "", res.getError());
				}
				return success("DerivativeEvent6__5", ValidationResult.ValidationType.CARDINALITY, "DerivativeEvent6__5", path, "");
			})
			.collect(toList());
	}

}
