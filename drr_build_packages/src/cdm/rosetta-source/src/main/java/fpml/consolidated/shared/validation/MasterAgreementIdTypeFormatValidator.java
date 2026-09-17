package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.MasterAgreementId;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class MasterAgreementIdTypeFormatValidator implements Validator<MasterAgreementId> {

	private List<ComparisonResult> getComparisonResults(MasterAgreementId o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("masterAgreementIdScheme", o.getMasterAgreementIdScheme(), 1, empty(), of(Pattern.compile("\\w+:(\\/?\\/?)[^\\s]+")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreementId o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreementId", ValidationResult.ValidationType.TYPE_FORMAT, "MasterAgreementId", path, "", res.getError());
				}
				return success("MasterAgreementId", ValidationResult.ValidationType.TYPE_FORMAT, "MasterAgreementId", path, "");
			})
			.collect(toList());
	}

}
