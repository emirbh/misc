package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.FloatingRate13__1;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class FloatingRate13__1TypeFormatValidator implements Validator<FloatingRate13__1> {

	private List<ComparisonResult> getComparisonResults(FloatingRate13__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("id", o.getId(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}[A-Z0-9]{9,9}[0-9]{1,1}"))), 
				checkString("nm", o.getNm(), 1, of(350), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FloatingRate13__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FloatingRate13__1", ValidationResult.ValidationType.TYPE_FORMAT, "FloatingRate13__1", path, "", res.getError());
				}
				return success("FloatingRate13__1", ValidationResult.ValidationType.TYPE_FORMAT, "FloatingRate13__1", path, "");
			})
			.collect(toList());
	}

}
