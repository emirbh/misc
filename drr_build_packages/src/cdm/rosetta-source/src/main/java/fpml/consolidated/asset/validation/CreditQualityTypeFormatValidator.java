package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.CreditQuality;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CreditQualityTypeFormatValidator implements Validator<CreditQuality> {

	private List<ComparisonResult> getComparisonResults(CreditQuality o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("creditQualityScheme", o.getCreditQualityScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CreditQuality o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CreditQuality", ValidationResult.ValidationType.TYPE_FORMAT, "CreditQuality", path, "", res.getError());
				}
				return success("CreditQuality", ValidationResult.ValidationType.TYPE_FORMAT, "CreditQuality", path, "");
			})
			.collect(toList());
	}

}
