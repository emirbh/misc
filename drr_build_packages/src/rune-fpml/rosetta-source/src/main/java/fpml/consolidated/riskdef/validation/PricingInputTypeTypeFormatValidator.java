package fpml.consolidated.riskdef.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.riskdef.PricingInputType;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class PricingInputTypeTypeFormatValidator implements Validator<PricingInputType> {

	private List<ComparisonResult> getComparisonResults(PricingInputType o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("pricingInputTypeScheme", o.getPricingInputTypeScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PricingInputType o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PricingInputType", ValidationResult.ValidationType.TYPE_FORMAT, "PricingInputType", path, "", res.getError());
				}
				return success("PricingInputType", ValidationResult.ValidationType.TYPE_FORMAT, "PricingInputType", path, "");
			})
			.collect(toList());
	}

}
