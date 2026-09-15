package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.PrincipalExchangeAmount;
import fpml.consolidated.shared.AmountReference;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PrincipalExchangeAmountValidator implements Validator<PrincipalExchangeAmount> {

	private List<ComparisonResult> getComparisonResults(PrincipalExchangeAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("amountRelativeTo", (AmountReference) o.getAmountRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("determinationMethod", (DeterminationMethod) o.getDeterminationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("principalAmount", (NonNegativeMoney) o.getPrincipalAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchangeAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalExchangeAmount", ValidationResult.ValidationType.CARDINALITY, "PrincipalExchangeAmount", path, "", res.getError());
				}
				return success("PrincipalExchangeAmount", ValidationResult.ValidationType.CARDINALITY, "PrincipalExchangeAmount", path, "");
			})
			.collect(toList());
	}

}
