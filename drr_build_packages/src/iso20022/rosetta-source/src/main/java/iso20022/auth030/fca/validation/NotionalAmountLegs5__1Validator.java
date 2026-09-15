package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.NotionalAmount5__1;
import iso20022.auth030.fca.NotionalAmount6__1;
import iso20022.auth030.fca.NotionalAmountLegs5__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NotionalAmountLegs5__1Validator implements Validator<NotionalAmountLegs5__1> {

	private List<ComparisonResult> getComparisonResults(NotionalAmountLegs5__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("frstLeg", (NotionalAmount5__1) o.getFrstLeg() != null ? 1 : 0, 1, 1), 
				checkCardinality("scndLeg", (NotionalAmount6__1) o.getScndLeg() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalAmountLegs5__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotionalAmountLegs5__1", ValidationResult.ValidationType.CARDINALITY, "NotionalAmountLegs5__1", path, "", res.getError());
				}
				return success("NotionalAmountLegs5__1", ValidationResult.ValidationType.CARDINALITY, "NotionalAmountLegs5__1", path, "");
			})
			.collect(toList());
	}

}
