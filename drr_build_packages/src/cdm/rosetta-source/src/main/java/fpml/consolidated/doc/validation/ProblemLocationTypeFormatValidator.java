package fpml.consolidated.doc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ProblemLocation;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class ProblemLocationTypeFormatValidator implements Validator<ProblemLocation> {

	private List<ComparisonResult> getComparisonResults(ProblemLocation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("locationType", o.getLocationType(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ProblemLocation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ProblemLocation", ValidationResult.ValidationType.TYPE_FORMAT, "ProblemLocation", path, "", res.getError());
				}
				return success("ProblemLocation", ValidationResult.ValidationType.TYPE_FORMAT, "ProblemLocation", path, "");
			})
			.collect(toList());
	}

}
