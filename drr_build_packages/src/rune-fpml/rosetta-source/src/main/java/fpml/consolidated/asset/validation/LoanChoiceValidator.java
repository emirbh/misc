package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.LoanChoice;
import fpml.consolidated.shared.LegalEntity;
import fpml.consolidated.shared.LegalEntityReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanChoiceValidator implements Validator<LoanChoice> {

	private List<ComparisonResult> getComparisonResults(LoanChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("borrower", (LegalEntity) o.getBorrower() != null ? 1 : 0, 0, 1), 
				checkCardinality("borrowerReference", (LegalEntityReference) o.getBorrowerReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanChoice", ValidationResult.ValidationType.CARDINALITY, "LoanChoice", path, "", res.getError());
				}
				return success("LoanChoice", ValidationResult.ValidationType.CARDINALITY, "LoanChoice", path, "");
			})
			.collect(toList());
	}

}
