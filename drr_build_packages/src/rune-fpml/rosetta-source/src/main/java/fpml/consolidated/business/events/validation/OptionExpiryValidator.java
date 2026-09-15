package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ActionOnExpiration;
import fpml.consolidated.business.events.OptionExpiry;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.ExerciseProcedureOption;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionExpiryValidator implements Validator<OptionExpiry> {

	private List<ComparisonResult> getComparisonResults(OptionExpiry o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("originalTrade", (Trade) o.getOriginalTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("date", (ZonedDateTime) o.getDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("time", (LocalTime) o.getTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("exerciseProcedure", (ExerciseProcedureOption) o.getExerciseProcedure() != null ? 1 : 0, 0, 1), 
				checkCardinality("actionOnExpiration", (ActionOnExpiration) o.getActionOnExpiration() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionExpiry o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionExpiry", ValidationResult.ValidationType.CARDINALITY, "OptionExpiry", path, "", res.getError());
				}
				return success("OptionExpiry", ValidationResult.ValidationType.CARDINALITY, "OptionExpiry", path, "");
			})
			.collect(toList());
	}

}
