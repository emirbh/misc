package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LetterOfCreditReference;
import fpml.consolidated.loan.LoanContractReference;
import fpml.consolidated.loan.LoanLegalStructureAfterChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanLegalStructureAfterChoiceValidator implements Validator<LoanLegalStructureAfterChoice> {

	private List<ComparisonResult> getComparisonResults(LoanLegalStructureAfterChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("contractReference", (LoanContractReference) o.getContractReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("letterOfCreditReference", (LetterOfCreditReference) o.getLetterOfCreditReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalStructureAfterChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanLegalStructureAfterChoice", ValidationResult.ValidationType.CARDINALITY, "LoanLegalStructureAfterChoice", path, "", res.getError());
				}
				return success("LoanLegalStructureAfterChoice", ValidationResult.ValidationType.CARDINALITY, "LoanLegalStructureAfterChoice", path, "");
			})
			.collect(toList());
	}

}
