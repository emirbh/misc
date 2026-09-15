package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.Quantity47Choice__1;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class Quantity47Choice__1Validator implements Validator<Quantity47Choice__1> {

	private List<ComparisonResult> getComparisonResults(Quantity47Choice__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("qty", (BigDecimal) o.getQty() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Quantity47Choice__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Quantity47Choice__1", ValidationResult.ValidationType.CARDINALITY, "Quantity47Choice__1", path, "", res.getError());
				}
				return success("Quantity47Choice__1", ValidationResult.ValidationType.CARDINALITY, "Quantity47Choice__1", path, "");
			})
			.collect(toList());
	}

}
