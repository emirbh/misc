package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradingEventSummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradingEventSummaryTypeFormatValidator implements Validator<TradingEventSummary> {

	private List<ComparisonResult> getComparisonResults(TradingEventSummary o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradingEventSummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradingEventSummary", ValidationResult.ValidationType.TYPE_FORMAT, "TradingEventSummary", path, "", res.getError());
				}
				return success("TradingEventSummary", ValidationResult.ValidationType.TYPE_FORMAT, "TradingEventSummary", path, "");
			})
			.collect(toList());
	}

}
