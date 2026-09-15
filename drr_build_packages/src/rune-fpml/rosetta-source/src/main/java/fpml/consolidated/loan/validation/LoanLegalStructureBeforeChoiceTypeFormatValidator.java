package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanLegalStructureBeforeChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanLegalStructureBeforeChoiceTypeFormatValidator implements Validator<LoanLegalStructureBeforeChoice> {

	private List<ComparisonResult> getComparisonResults(LoanLegalStructureBeforeChoice o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalStructureBeforeChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanLegalStructureBeforeChoice", ValidationResult.ValidationType.TYPE_FORMAT, "LoanLegalStructureBeforeChoice", path, "", res.getError());
				}
				return success("LoanLegalStructureBeforeChoice", ValidationResult.ValidationType.TYPE_FORMAT, "LoanLegalStructureBeforeChoice", path, "");
			})
			.collect(toList());
	}

}
