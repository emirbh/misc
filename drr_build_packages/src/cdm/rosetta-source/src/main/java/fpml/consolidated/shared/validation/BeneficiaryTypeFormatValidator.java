package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.Beneficiary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class BeneficiaryTypeFormatValidator implements Validator<Beneficiary> {

	private List<ComparisonResult> getComparisonResults(Beneficiary o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Beneficiary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Beneficiary", ValidationResult.ValidationType.TYPE_FORMAT, "Beneficiary", path, "", res.getError());
				}
				return success("Beneficiary", ValidationResult.ValidationType.TYPE_FORMAT, "Beneficiary", path, "");
			})
			.collect(toList());
	}

}
