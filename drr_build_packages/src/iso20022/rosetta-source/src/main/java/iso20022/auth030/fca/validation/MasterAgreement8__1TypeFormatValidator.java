package iso20022.auth030.fca.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.fca.MasterAgreement8__1;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class MasterAgreement8__1TypeFormatValidator implements Validator<MasterAgreement8__1> {

	private List<ComparisonResult> getComparisonResults(MasterAgreement8__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("othrMstrAgrmtDtls", o.getOthrMstrAgrmtDtls(), 1, of(50), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreement8__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MasterAgreement8__1", ValidationResult.ValidationType.TYPE_FORMAT, "MasterAgreement8__1", path, "", res.getError());
				}
				return success("MasterAgreement8__1", ValidationResult.ValidationType.TYPE_FORMAT, "MasterAgreement8__1", path, "");
			})
			.collect(toList());
	}

}
