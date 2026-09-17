package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AbstractLoanLegalAction;
import fpml.consolidated.loan.DealReference;
import fpml.consolidated.loan.LoanLegalActionDetails;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AbstractLoanLegalActionValidator implements Validator<AbstractLoanLegalAction> {

	private List<ComparisonResult> getComparisonResults(AbstractLoanLegalAction o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("actionDetails", (LoanLegalActionDetails) o.getActionDetails() != null ? 1 : 0, 1, 1), 
				checkCardinality("dealReference", (DealReference) o.getDealReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractLoanLegalAction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractLoanLegalAction", ValidationResult.ValidationType.CARDINALITY, "AbstractLoanLegalAction", path, "", res.getError());
				}
				return success("AbstractLoanLegalAction", ValidationResult.ValidationType.CARDINALITY, "AbstractLoanLegalAction", path, "");
			})
			.collect(toList());
	}

}
