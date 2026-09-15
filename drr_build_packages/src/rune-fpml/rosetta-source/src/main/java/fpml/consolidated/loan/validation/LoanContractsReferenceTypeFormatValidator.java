package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanContractsReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanContractsReferenceTypeFormatValidator implements Validator<LoanContractsReference> {

	private List<ComparisonResult> getComparisonResults(LoanContractsReference o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanContractsReference o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanContractsReference", ValidationResult.ValidationType.TYPE_FORMAT, "LoanContractsReference", path, "", res.getError());
				}
				return success("LoanContractsReference", ValidationResult.ValidationType.TYPE_FORMAT, "LoanContractsReference", path, "");
			})
			.collect(toList());
	}

}
