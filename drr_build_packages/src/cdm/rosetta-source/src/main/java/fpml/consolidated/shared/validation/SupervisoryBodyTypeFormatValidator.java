package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.SupervisoryBody;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class SupervisoryBodyTypeFormatValidator implements Validator<SupervisoryBody> {

	private List<ComparisonResult> getComparisonResults(SupervisoryBody o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("supervisoryBodyScheme", o.getSupervisoryBodyScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, SupervisoryBody o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("SupervisoryBody", ValidationResult.ValidationType.TYPE_FORMAT, "SupervisoryBody", path, "", res.getError());
				}
				return success("SupervisoryBody", ValidationResult.ValidationType.TYPE_FORMAT, "SupervisoryBody", path, "");
			})
			.collect(toList());
	}

}
