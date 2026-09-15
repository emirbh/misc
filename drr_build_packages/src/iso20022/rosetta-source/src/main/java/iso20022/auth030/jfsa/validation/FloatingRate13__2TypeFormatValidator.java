package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.FloatingRate13__2;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class FloatingRate13__2TypeFormatValidator implements Validator<FloatingRate13__2> {

	private List<ComparisonResult> getComparisonResults(FloatingRate13__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("nm", o.getNm(), 1, of(50), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRate13__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRate13__2", ValidationResult.ValidationType.TYPE_FORMAT, "FloatingRate13__2", path, "", res.getError());
				}
				return success("FloatingRate13__2", ValidationResult.ValidationType.TYPE_FORMAT, "FloatingRate13__2", path, "");
			})
			.collect(toList());
	}

}
