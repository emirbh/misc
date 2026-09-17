package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.DualCurrencyFeature;
import fpml.consolidated.fx.TermDepositFeatures;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TermDepositFeaturesValidator implements Validator<TermDepositFeatures> {

	private List<ComparisonResult> getComparisonResults(TermDepositFeatures o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dualCurrency", (DualCurrencyFeature) o.getDualCurrency() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TermDepositFeatures o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TermDepositFeatures", ValidationResult.ValidationType.CARDINALITY, "TermDepositFeatures", path, "", res.getError());
				}
				return success("TermDepositFeatures", ValidationResult.ValidationType.CARDINALITY, "TermDepositFeatures", path, "");
			})
			.collect(toList());
	}

}
