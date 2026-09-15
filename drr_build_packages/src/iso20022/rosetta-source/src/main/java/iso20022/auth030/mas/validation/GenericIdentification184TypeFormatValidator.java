package iso20022.auth030.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.mas.GenericIdentification184;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class GenericIdentification184TypeFormatValidator implements Validator<GenericIdentification184> {

	private List<ComparisonResult> getComparisonResults(GenericIdentification184 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("id", o.getId(), 1, of(210), empty()), 
				checkString("src", o.getSrc(), 1, of(100), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericIdentification184 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericIdentification184", ValidationResult.ValidationType.TYPE_FORMAT, "GenericIdentification184", path, "", res.getError());
				}
				return success("GenericIdentification184", ValidationResult.ValidationType.TYPE_FORMAT, "GenericIdentification184", path, "");
			})
			.collect(toList());
	}

}
