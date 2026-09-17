package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.CalendarSpread;
import fpml.consolidated.option.shared.StrategyFeature;
import fpml.consolidated.option.shared.StrikeSpread;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class StrategyFeatureValidator implements Validator<StrategyFeature> {

	private List<ComparisonResult> getComparisonResults(StrategyFeature o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("strikeSpread", (StrikeSpread) o.getStrikeSpread() != null ? 1 : 0, 0, 1), 
				checkCardinality("calendarSpread", (CalendarSpread) o.getCalendarSpread() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, StrategyFeature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("StrategyFeature", ValidationResult.ValidationType.CARDINALITY, "StrategyFeature", path, "", res.getError());
				}
				return success("StrategyFeature", ValidationResult.ValidationType.CARDINALITY, "StrategyFeature", path, "");
			})
			.collect(toList());
	}

}
