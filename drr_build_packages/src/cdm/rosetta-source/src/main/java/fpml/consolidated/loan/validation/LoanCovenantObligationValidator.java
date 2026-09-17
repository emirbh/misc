package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.DealReference;
import fpml.consolidated.loan.LoanCovenantObligation;
import fpml.consolidated.loan.LoanCovenantObligationAccountingDetails;
import fpml.consolidated.loan.LoanCovenantObligationCategoryType;
import fpml.consolidated.loan.LoanCovenantObligationReference;
import fpml.consolidated.loan.LoanCovenantObligationTriggerCriteriaDetails;
import fpml.consolidated.loan.LoanCovenantObligationType;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanCovenantObligationValidator implements Validator<LoanCovenantObligation> {

	private List<ComparisonResult> getComparisonResults(LoanCovenantObligation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("name", (String) o.getName() != null ? 1 : 0, 0, 1), 
				checkCardinality("partyReference", (PartyReference) o.getPartyReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("effectiveDate", (ZonedDateTime) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("obligatedParty", (PartyReference) o.getObligatedParty() != null ? 1 : 0, 1, 1), 
				checkCardinality("dealReference", (DealReference) o.getDealReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("deemedCovenantReference", (LoanCovenantObligationReference) o.getDeemedCovenantReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("category", (LoanCovenantObligationCategoryType) o.getCategory() != null ? 1 : 0, 0, 1), 
				checkCardinality("type", (LoanCovenantObligationType) o._getType() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerCriteria", (LoanCovenantObligationTriggerCriteriaDetails) o.getTriggerCriteria() != null ? 1 : 0, 0, 1), 
				checkCardinality("accountingDetails", (LoanCovenantObligationAccountingDetails) o.getAccountingDetails() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanCovenantObligation", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligation", path, "", res.getError());
				}
				return success("LoanCovenantObligation", ValidationResult.ValidationType.CARDINALITY, "LoanCovenantObligation", path, "");
			})
			.collect(toList());
	}

}
