package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.TimestampTypeScheme;
import fpml.consolidated.doc.TradeTimestamp;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeTimestampValidator implements Validator<TradeTimestamp> {

	private List<ComparisonResult> getComparisonResults(TradeTimestamp o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("type", (TimestampTypeScheme) o._getType() != null ? 1 : 0, 0, 1), 
				checkCardinality("value", (ZonedDateTime) o.getValue() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeTimestamp o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeTimestamp", ValidationResult.ValidationType.CARDINALITY, "TradeTimestamp", path, "", res.getError());
				}
				return success("TradeTimestamp", ValidationResult.ValidationType.CARDINALITY, "TradeTimestamp", path, "");
			})
			.collect(toList());
	}

}
