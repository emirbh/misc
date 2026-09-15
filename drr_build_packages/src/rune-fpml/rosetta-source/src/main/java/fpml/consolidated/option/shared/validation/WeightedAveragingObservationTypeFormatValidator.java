package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.WeightedAveragingObservation;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class WeightedAveragingObservationTypeFormatValidator implements Validator<WeightedAveragingObservation> {

	private List<ComparisonResult> getComparisonResults(WeightedAveragingObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("observationNumber", o.getObservationNumber(), empty(), of(0), of(new BigDecimal("1")), empty()), 
				checkNumber("weight", o.getWeight(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, WeightedAveragingObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("WeightedAveragingObservation", ValidationResult.ValidationType.TYPE_FORMAT, "WeightedAveragingObservation", path, "", res.getError());
				}
				return success("WeightedAveragingObservation", ValidationResult.ValidationType.TYPE_FORMAT, "WeightedAveragingObservation", path, "");
			})
			.collect(toList());
	}

}
