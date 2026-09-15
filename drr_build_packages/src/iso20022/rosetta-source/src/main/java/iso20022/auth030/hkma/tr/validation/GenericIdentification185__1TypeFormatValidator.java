package iso20022.auth030.hkma.tr.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.hkma.tr.GenericIdentification185__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class GenericIdentification185__1TypeFormatValidator implements Validator<GenericIdentification185__1> {

	private List<ComparisonResult> getComparisonResults(GenericIdentification185__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("id", o.getId(), 1, of(100), empty()), 
				checkString("schmeNm", o.getSchmeNm(), 1, of(35), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericIdentification185__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericIdentification185__1", ValidationResult.ValidationType.TYPE_FORMAT, "GenericIdentification185__1", path, "", res.getError());
				}
				return success("GenericIdentification185__1", ValidationResult.ValidationType.TYPE_FORMAT, "GenericIdentification185__1", path, "");
			})
			.collect(toList());
	}

}
