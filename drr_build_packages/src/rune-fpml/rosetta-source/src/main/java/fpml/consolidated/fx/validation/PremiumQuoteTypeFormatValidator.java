package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.PremiumQuote;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PremiumQuoteTypeFormatValidator implements Validator<PremiumQuote> {

	private List<ComparisonResult> getComparisonResults(PremiumQuote o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PremiumQuote o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PremiumQuote", ValidationResult.ValidationType.TYPE_FORMAT, "PremiumQuote", path, "", res.getError());
				}
				return success("PremiumQuote", ValidationResult.ValidationType.TYPE_FORMAT, "PremiumQuote", path, "");
			})
			.collect(toList());
	}

}
