package fpml.consolidated.confirmation.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.confirmation.processes.TradeWrapper;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeWrapperTypeFormatValidator implements Validator<TradeWrapper> {

	private List<ComparisonResult> getComparisonResults(TradeWrapper o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeWrapper o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeWrapper", ValidationResult.ValidationType.TYPE_FORMAT, "TradeWrapper", path, "", res.getError());
				}
				return success("TradeWrapper", ValidationResult.ValidationType.TYPE_FORMAT, "TradeWrapper", path, "");
			})
			.collect(toList());
	}

}
