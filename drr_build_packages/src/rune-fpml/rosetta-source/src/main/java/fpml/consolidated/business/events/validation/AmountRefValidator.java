package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.AmountRef;
import fpml.consolidated.shared.AmountReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AmountRefValidator implements Validator<AmountRef> {

	private List<ComparisonResult> getComparisonResults(AmountRef o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amount", (BigDecimal) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("amountReference", (AmountReference) o.getAmountReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AmountRef o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AmountRef", ValidationResult.ValidationType.CARDINALITY, "AmountRef", path, "", res.getError());
				}
				return success("AmountRef", ValidationResult.ValidationType.CARDINALITY, "AmountRef", path, "");
			})
			.collect(toList());
	}

}
