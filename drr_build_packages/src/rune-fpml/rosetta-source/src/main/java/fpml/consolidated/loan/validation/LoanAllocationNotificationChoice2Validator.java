package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LetterOfCredit;
import fpml.consolidated.loan.LetterOfCreditSummary;
import fpml.consolidated.loan.LoanAllocationNotificationChoice2;
import fpml.consolidated.loan.LoanContract;
import fpml.consolidated.loan.LoanContractIdentifier;
import fpml.consolidated.loan.LoanContractSummary;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanAllocationNotificationChoice2Validator implements Validator<LoanAllocationNotificationChoice2> {

	private List<ComparisonResult> getComparisonResults(LoanAllocationNotificationChoice2 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("letterOfCreditIdentifier", (LoanContractIdentifier) o.getLetterOfCreditIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("letterOfCreditSummary", (LetterOfCreditSummary) o.getLetterOfCreditSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("letterOfCredit", (LetterOfCredit) o.getLetterOfCredit() != null ? 1 : 0, 0, 1), 
				checkCardinality("contractIdentifier", (LoanContractIdentifier) o.getContractIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("contractSummary", (LoanContractSummary) o.getContractSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("contract", (LoanContract) o.getContract() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanAllocationNotificationChoice2 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanAllocationNotificationChoice2", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationNotificationChoice2", path, "", res.getError());
				}
				return success("LoanAllocationNotificationChoice2", ValidationResult.ValidationType.CARDINALITY, "LoanAllocationNotificationChoice2", path, "");
			})
			.collect(toList());
	}

}
