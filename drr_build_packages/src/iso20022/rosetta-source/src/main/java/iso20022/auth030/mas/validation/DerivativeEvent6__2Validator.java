package iso20022.auth030.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.mas.DateAndDateTime2Choice__1;
import iso20022.auth030.mas.DerivativeEvent6__2;
import iso20022.auth030.mas.DerivativeEventType3Code;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DerivativeEvent6__2Validator implements Validator<DerivativeEvent6__2> {

	private List<ComparisonResult> getComparisonResults(DerivativeEvent6__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("tp", (DerivativeEventType3Code) o.getTp() != null ? 1 : 0, 0, 1), 
				checkCardinality("tmStmp", (DateAndDateTime2Choice__1) o.getTmStmp() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DerivativeEvent6__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DerivativeEvent6__2", ValidationResult.ValidationType.CARDINALITY, "DerivativeEvent6__2", path, "", res.getError());
				}
				return success("DerivativeEvent6__2", ValidationResult.ValidationType.CARDINALITY, "DerivativeEvent6__2", path, "");
			})
			.collect(toList());
	}

}
