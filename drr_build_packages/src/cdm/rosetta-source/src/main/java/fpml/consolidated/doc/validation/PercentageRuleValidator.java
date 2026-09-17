package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.PercentageRule;
import fpml.consolidated.shared.NotionalAmountReference;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PercentageRuleValidator implements Validator<PercentageRule> {

	private List<ComparisonResult> getComparisonResults(PercentageRule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("paymentPercent", (BigDecimal) o.getPaymentPercent() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalAmountReference", (NotionalAmountReference) o.getNotionalAmountReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PercentageRule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PercentageRule", ValidationResult.ValidationType.CARDINALITY, "PercentageRule", path, "", res.getError());
				}
				return success("PercentageRule", ValidationResult.ValidationType.CARDINALITY, "PercentageRule", path, "");
			})
			.collect(toList());
	}

}
