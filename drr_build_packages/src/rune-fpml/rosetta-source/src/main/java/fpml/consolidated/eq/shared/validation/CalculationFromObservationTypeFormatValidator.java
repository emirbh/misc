package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.CalculationFromObservation;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CalculationFromObservationTypeFormatValidator implements Validator<CalculationFromObservation> {

	private List<ComparisonResult> getComparisonResults(CalculationFromObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("expectedN", o.getExpectedN(), empty(), of(0), of(new BigDecimal("1")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CalculationFromObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CalculationFromObservation", ValidationResult.ValidationType.TYPE_FORMAT, "CalculationFromObservation", path, "", res.getError());
				}
				return success("CalculationFromObservation", ValidationResult.ValidationType.TYPE_FORMAT, "CalculationFromObservation", path, "");
			})
			.collect(toList());
	}

}
