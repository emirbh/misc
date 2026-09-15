package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.CalculationParameters;
import fpml.consolidated.shared.FallbackRate;
import fpml.consolidated.shared.FloatingRateIndex;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FallbackRateValidator implements Validator<FallbackRate> {

	private List<ComparisonResult> getComparisonResults(FallbackRate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (ZonedDateTime) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("floatingRateIndex", (FloatingRateIndex) o.getFloatingRateIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationParameters", (CalculationParameters) o.getCalculationParameters() != null ? 1 : 0, 0, 1), 
				checkCardinality("spreadAdjustment", (BigDecimal) o.getSpreadAdjustment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FallbackRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FallbackRate", ValidationResult.ValidationType.CARDINALITY, "FallbackRate", path, "", res.getError());
				}
				return success("FallbackRate", ValidationResult.ValidationType.CARDINALITY, "FallbackRate", path, "");
			})
			.collect(toList());
	}

}
