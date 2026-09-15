package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.TradeSummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeSummaryTypeFormatValidator implements Validator<TradeSummary> {

	private List<ComparisonResult> getComparisonResults(TradeSummary o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeSummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeSummary", ValidationResult.ValidationType.TYPE_FORMAT, "TradeSummary", path, "", res.getError());
				}
				return success("TradeSummary", ValidationResult.ValidationType.TYPE_FORMAT, "TradeSummary", path, "");
			})
			.collect(toList());
	}

}
