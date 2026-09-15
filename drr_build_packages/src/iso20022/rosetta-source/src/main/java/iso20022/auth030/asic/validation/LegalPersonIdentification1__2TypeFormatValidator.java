package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.LegalPersonIdentification1__2;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class LegalPersonIdentification1__2TypeFormatValidator implements Validator<LegalPersonIdentification1__2> {

	private List<ComparisonResult> getComparisonResults(LegalPersonIdentification1__2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("ctry", o.getCtry(), 0, empty(), of(Pattern.compile("[A-Z]{2,2}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegalPersonIdentification1__2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegalPersonIdentification1__2", ValidationResult.ValidationType.TYPE_FORMAT, "LegalPersonIdentification1__2", path, "", res.getError());
				}
				return success("LegalPersonIdentification1__2", ValidationResult.ValidationType.TYPE_FORMAT, "LegalPersonIdentification1__2", path, "");
			})
			.collect(toList());
	}

}
