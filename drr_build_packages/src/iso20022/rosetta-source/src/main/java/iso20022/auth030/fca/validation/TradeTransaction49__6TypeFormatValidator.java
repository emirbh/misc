package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.TradeTransaction49__6;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeTransaction49__6TypeFormatValidator implements Validator<TradeTransaction49__6> {

	private List<ComparisonResult> getComparisonResults(TradeTransaction49__6 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeTransaction49__6 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeTransaction49__6", ValidationResult.ValidationType.TYPE_FORMAT, "TradeTransaction49__6", path, "", res.getError());
				}
				return success("TradeTransaction49__6", ValidationResult.ValidationType.TYPE_FORMAT, "TradeTransaction49__6", path, "");
			})
			.collect(toList());
	}

}
