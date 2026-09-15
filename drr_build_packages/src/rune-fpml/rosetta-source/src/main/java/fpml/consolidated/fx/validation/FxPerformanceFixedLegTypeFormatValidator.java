package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxPerformanceFixedLeg;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class FxPerformanceFixedLegTypeFormatValidator implements Validator<FxPerformanceFixedLeg> {

	private List<ComparisonResult> getComparisonResults(FxPerformanceFixedLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("fixedRate", o.getFixedRate(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxPerformanceFixedLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxPerformanceFixedLeg", ValidationResult.ValidationType.TYPE_FORMAT, "FxPerformanceFixedLeg", path, "", res.getError());
				}
				return success("FxPerformanceFixedLeg", ValidationResult.ValidationType.TYPE_FORMAT, "FxPerformanceFixedLeg", path, "");
			})
			.collect(toList());
	}

}
