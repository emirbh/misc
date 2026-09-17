package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradeLegPriceChange;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeLegPriceChangeTypeFormatValidator implements Validator<TradeLegPriceChange> {

	private List<ComparisonResult> getComparisonResults(TradeLegPriceChange o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeLegPriceChange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeLegPriceChange", ValidationResult.ValidationType.TYPE_FORMAT, "TradeLegPriceChange", path, "", res.getError());
				}
				return success("TradeLegPriceChange", ValidationResult.ValidationType.TYPE_FORMAT, "TradeLegPriceChange", path, "");
			})
			.collect(toList());
	}

}
