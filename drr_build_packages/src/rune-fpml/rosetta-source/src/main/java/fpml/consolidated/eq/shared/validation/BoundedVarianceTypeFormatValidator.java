package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.BoundedVariance;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class BoundedVarianceTypeFormatValidator implements Validator<BoundedVariance> {

	private List<ComparisonResult> getComparisonResults(BoundedVariance o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("upperBarrier", o.getUpperBarrier(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("lowerBarrier", o.getLowerBarrier(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, BoundedVariance o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("BoundedVariance", ValidationResult.ValidationType.TYPE_FORMAT, "BoundedVariance", path, "", res.getError());
				}
				return success("BoundedVariance", ValidationResult.ValidationType.TYPE_FORMAT, "BoundedVariance", path, "");
			})
			.collect(toList());
	}

}
