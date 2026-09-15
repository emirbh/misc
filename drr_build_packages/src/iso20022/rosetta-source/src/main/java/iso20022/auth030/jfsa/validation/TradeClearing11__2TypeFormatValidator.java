package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.TradeClearing11__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeClearing11__2TypeFormatValidator implements Validator<TradeClearing11__2> {

	private List<ComparisonResult> getComparisonResults(TradeClearing11__2 o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeClearing11__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeClearing11__2", ValidationResult.ValidationType.TYPE_FORMAT, "TradeClearing11__2", path, "", res.getError());
				}
				return success("TradeClearing11__2", ValidationResult.ValidationType.TYPE_FORMAT, "TradeClearing11__2", path, "");
			})
			.collect(toList());
	}

}
