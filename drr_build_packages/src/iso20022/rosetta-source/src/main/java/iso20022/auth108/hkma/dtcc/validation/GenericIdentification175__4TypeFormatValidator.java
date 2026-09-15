package iso20022.auth108.hkma.dtcc.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth108.hkma.dtcc.GenericIdentification175__4;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class GenericIdentification175__4TypeFormatValidator implements Validator<GenericIdentification175__4> {

	private List<ComparisonResult> getComparisonResults(GenericIdentification175__4 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("id", o.getId(), 1, of(72), empty()), 
				checkString("schmeNm", o.getSchmeNm(), 1, of(35), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericIdentification175__4 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericIdentification175__4", ValidationResult.ValidationType.TYPE_FORMAT, "GenericIdentification175__4", path, "", res.getError());
				}
				return success("GenericIdentification175__4", ValidationResult.ValidationType.TYPE_FORMAT, "GenericIdentification175__4", path, "");
			})
			.collect(toList());
	}

}
