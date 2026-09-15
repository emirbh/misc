package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.NotionalQuantity9__2;
import iso20022.auth030.esma.NotionalQuantityLegs5__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NotionalQuantityLegs5__2Validator implements Validator<NotionalQuantityLegs5__2> {

	private List<ComparisonResult> getComparisonResults(NotionalQuantityLegs5__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("frstLeg", (NotionalQuantity9__2) o.getFrstLeg() != null ? 1 : 0, 0, 1), 
				checkCardinality("scndLeg", (NotionalQuantity9__2) o.getScndLeg() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NotionalQuantityLegs5__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NotionalQuantityLegs5__2", ValidationResult.ValidationType.CARDINALITY, "NotionalQuantityLegs5__2", path, "", res.getError());
				}
				return success("NotionalQuantityLegs5__2", ValidationResult.ValidationType.CARDINALITY, "NotionalQuantityLegs5__2", path, "");
			})
			.collect(toList());
	}

}
