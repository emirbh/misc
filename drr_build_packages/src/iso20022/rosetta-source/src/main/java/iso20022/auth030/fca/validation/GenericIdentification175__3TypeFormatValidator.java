package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.GenericIdentification175__3;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class GenericIdentification175__3TypeFormatValidator implements Validator<GenericIdentification175__3> {

	private List<ComparisonResult> getComparisonResults(GenericIdentification175__3 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("id", o.getId(), 1, of(52), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericIdentification175__3 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericIdentification175__3", ValidationResult.ValidationType.TYPE_FORMAT, "GenericIdentification175__3", path, "", res.getError());
				}
				return success("GenericIdentification175__3", ValidationResult.ValidationType.TYPE_FORMAT, "GenericIdentification175__3", path, "");
			})
			.collect(toList());
	}

}
