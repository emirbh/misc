package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LetterOfCredit;
import fpml.consolidated.loan.LoanContract;
import fpml.consolidated.loan.OutstandingContractsStatementChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OutstandingContractsStatementChoiceValidator implements Validator<OutstandingContractsStatementChoice> {

	private List<ComparisonResult> getComparisonResults(OutstandingContractsStatementChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("loanContract", (LoanContract) o.getLoanContract() != null ? 1 : 0, 0, 1), 
				checkCardinality("letterOfCredit", (LetterOfCredit) o.getLetterOfCredit() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OutstandingContractsStatementChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OutstandingContractsStatementChoice", ValidationResult.ValidationType.CARDINALITY, "OutstandingContractsStatementChoice", path, "", res.getError());
				}
				return success("OutstandingContractsStatementChoice", ValidationResult.ValidationType.CARDINALITY, "OutstandingContractsStatementChoice", path, "");
			})
			.collect(toList());
	}

}
