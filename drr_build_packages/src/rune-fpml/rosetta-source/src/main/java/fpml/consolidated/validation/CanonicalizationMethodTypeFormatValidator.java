package fpml.consolidated.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.CanonicalizationMethod;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CanonicalizationMethodTypeFormatValidator implements Validator<CanonicalizationMethod> {

	private List<ComparisonResult> getComparisonResults(CanonicalizationMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("algorithm", o.getAlgorithm(), 0, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CanonicalizationMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CanonicalizationMethod", ValidationResult.ValidationType.TYPE_FORMAT, "CanonicalizationMethod", path, "", res.getError());
				}
				return success("CanonicalizationMethod", ValidationResult.ValidationType.TYPE_FORMAT, "CanonicalizationMethod", path, "");
			})
			.collect(toList());
	}

}
