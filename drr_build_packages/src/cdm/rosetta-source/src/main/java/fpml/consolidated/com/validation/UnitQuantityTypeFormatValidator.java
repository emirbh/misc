package fpml.consolidated.com.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.com.UnitQuantity;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class UnitQuantityTypeFormatValidator implements Validator<UnitQuantity> {

	private List<ComparisonResult> getComparisonResults(UnitQuantity o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("quantity", o.getQuantity(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, UnitQuantity o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("UnitQuantity", ValidationResult.ValidationType.TYPE_FORMAT, "UnitQuantity", path, "", res.getError());
				}
				return success("UnitQuantity", ValidationResult.ValidationType.TYPE_FORMAT, "UnitQuantity", path, "");
			})
			.collect(toList());
	}

}
