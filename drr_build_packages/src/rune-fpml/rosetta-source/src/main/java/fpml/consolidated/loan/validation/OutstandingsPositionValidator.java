package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FxTerms;
import fpml.consolidated.loan.LetterOfCreditReference;
import fpml.consolidated.loan.LoanContractReference;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.loan.OutstandingsPosition;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OutstandingsPositionValidator implements Validator<OutstandingsPosition> {

	private List<ComparisonResult> getComparisonResults(OutstandingsPosition o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("loanContractReference", (LoanContractReference) o.getLoanContractReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("letterOfCreditReference", (LetterOfCreditReference) o.getLetterOfCreditReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("amount", (MoneyWithParticipantShare) o.getAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("priorAmount", (MoneyWithParticipantShare) o.getPriorAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityFxRate", (FxTerms) o.getFacilityFxRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OutstandingsPosition o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OutstandingsPosition", ValidationResult.ValidationType.CARDINALITY, "OutstandingsPosition", path, "", res.getError());
				}
				return success("OutstandingsPosition", ValidationResult.ValidationType.CARDINALITY, "OutstandingsPosition", path, "");
			})
			.collect(toList());
	}

}
