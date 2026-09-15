package iso20022.auth030.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.mas.TradeData43__7;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeData43__7TypeFormatValidator implements Validator<TradeData43__7> {

	private List<ComparisonResult> getComparisonResults(TradeData43__7 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeData43__7 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeData43__7", ValidationResult.ValidationType.TYPE_FORMAT, "TradeData43__7", path, "", res.getError());
				}
				return success("TradeData43__7", ValidationResult.ValidationType.TYPE_FORMAT, "TradeData43__7", path, "");
			})
			.collect(toList());
	}

}
