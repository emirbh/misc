package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.ActionApproval;
import fpml.consolidated.loan.DealReference;
import fpml.consolidated.loan.LoanLegalAction;
import fpml.consolidated.loan.LoanLegalActionDetails;
import fpml.consolidated.loan.LoanLegalStructureAfter;
import fpml.consolidated.loan.LoanLegalStructureBefore;
import fpml.consolidated.shared.PartyReference;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanLegalActionValidator implements Validator<LoanLegalAction> {

	private List<ComparisonResult> getComparisonResults(LoanLegalAction o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("actionDetails", (LoanLegalActionDetails) o.getActionDetails() != null ? 1 : 0, 1, 1), 
				checkCardinality("dealReference", (DealReference) o.getDealReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("approval", (ActionApproval) o.getApproval() != null ? 1 : 0, 1, 1), 
				checkCardinality("before", (LoanLegalStructureBefore) o.getBefore() != null ? 1 : 0, 0, 1), 
				checkCardinality("after", (LoanLegalStructureAfter) o.getAfter() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanLegalAction o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanLegalAction", ValidationResult.ValidationType.CARDINALITY, "LoanLegalAction", path, "", res.getError());
				}
				return success("LoanLegalAction", ValidationResult.ValidationType.CARDINALITY, "LoanLegalAction", path, "");
			})
			.collect(toList());
	}

}
