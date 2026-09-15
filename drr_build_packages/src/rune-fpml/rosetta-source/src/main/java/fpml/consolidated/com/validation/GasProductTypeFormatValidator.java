package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.GasProduct;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class GasProductTypeFormatValidator implements Validator<GasProduct> {

	private List<ComparisonResult> getComparisonResults(GasProduct o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("calorificValue", o.getCalorificValue(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GasProduct o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GasProduct", ValidationResult.ValidationType.TYPE_FORMAT, "GasProduct", path, "", res.getError());
				}
				return success("GasProduct", ValidationResult.ValidationType.TYPE_FORMAT, "GasProduct", path, "");
			})
			.collect(toList());
	}

}
