package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxAsianFeature;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class FxAsianFeatureTypeFormatValidator implements Validator<FxAsianFeature> {

	private List<ComparisonResult> getComparisonResults(FxAsianFeature o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("payoutFormula", o.getPayoutFormula(), 1, empty(), empty()), 
				checkNumber("precision", o.getPrecision(), empty(), of(0), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAsianFeature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAsianFeature", ValidationResult.ValidationType.TYPE_FORMAT, "FxAsianFeature", path, "", res.getError());
				}
				return success("FxAsianFeature", ValidationResult.ValidationType.TYPE_FORMAT, "FxAsianFeature", path, "");
			})
			.collect(toList());
	}

}
