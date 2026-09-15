package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.OtherAgreementVersion;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class OtherAgreementVersionTypeFormatValidator implements Validator<OtherAgreementVersion> {

	private List<ComparisonResult> getComparisonResults(OtherAgreementVersion o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("agreementVersionScheme", o.getAgreementVersionScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OtherAgreementVersion o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OtherAgreementVersion", ValidationResult.ValidationType.TYPE_FORMAT, "OtherAgreementVersion", path, "", res.getError());
				}
				return success("OtherAgreementVersion", ValidationResult.ValidationType.TYPE_FORMAT, "OtherAgreementVersion", path, "");
			})
			.collect(toList());
	}

}
