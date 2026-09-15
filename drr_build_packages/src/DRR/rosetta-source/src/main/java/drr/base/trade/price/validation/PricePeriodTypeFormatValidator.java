package drr.base.trade.price.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.price.PricePeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PricePeriodTypeFormatValidator implements Validator<PricePeriod> {

	private List<ComparisonResult> getComparisonResults(PricePeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricePeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricePeriod", ValidationResult.ValidationType.TYPE_FORMAT, "PricePeriod", path, "", res.getError());
				}
				return success("PricePeriod", ValidationResult.ValidationType.TYPE_FORMAT, "PricePeriod", path, "");
			})
			.collect(toList());
	}

}
