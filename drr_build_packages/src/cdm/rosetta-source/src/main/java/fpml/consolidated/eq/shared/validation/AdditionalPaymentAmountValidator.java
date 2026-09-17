package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.AdditionalPaymentAmount;
import fpml.consolidated.shared.Formula;
import fpml.consolidated.shared.NonNegativeMoney;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AdditionalPaymentAmountValidator implements Validator<AdditionalPaymentAmount> {

	private List<ComparisonResult> getComparisonResults(AdditionalPaymentAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("paymentAmount", (NonNegativeMoney) o.getPaymentAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("formula", (Formula) o.getFormula() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AdditionalPaymentAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AdditionalPaymentAmount", ValidationResult.ValidationType.CARDINALITY, "AdditionalPaymentAmount", path, "", res.getError());
				}
				return success("AdditionalPaymentAmount", ValidationResult.ValidationType.CARDINALITY, "AdditionalPaymentAmount", path, "");
			})
			.collect(toList());
	}

}
