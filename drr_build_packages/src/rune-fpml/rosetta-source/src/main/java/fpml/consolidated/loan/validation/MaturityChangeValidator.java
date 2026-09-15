package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.CashPayable;
import fpml.consolidated.loan.LoanContractReference;
import fpml.consolidated.loan.LoanLegalActionReference;
import fpml.consolidated.loan.MaturityChange;
import fpml.consolidated.loan.ParentEventIdentifier;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MaturityChangeValidator implements Validator<MaturityChange> {

	private List<ComparisonResult> getComparisonResults(MaturityChange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eventIdentifier", (List<? extends BusinessEventIdentifier>) o.getEventIdentifier() == null ? 0 : o.getEventIdentifier().size(), 1, 0), 
				checkCardinality("parentEventIdentifier", (ParentEventIdentifier) o.getParentEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("previousEventIdentifier", (BusinessEventIdentifier) o.getPreviousEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("correctedEventIdentifier", (BusinessEventIdentifier) o.getCorrectedEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("lenderPartyReference", (PartyReference) o.getLenderPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashPayable", (CashPayable) o.getCashPayable() != null ? 1 : 0, 0, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("agentPartyReference", (PartyReference) o.getAgentPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("borrowerPartyReference", (PartyReference) o.getBorrowerPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (ZonedDateTime) o.getEffectiveDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("legalActionReference", (LoanLegalActionReference) o.getLegalActionReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanContractReference", (LoanContractReference) o.getLoanContractReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("currentMaturityDate", (ZonedDateTime) o.getCurrentMaturityDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("priorMaturityDate", (ZonedDateTime) o.getPriorMaturityDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MaturityChange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MaturityChange", ValidationResult.ValidationType.CARDINALITY, "MaturityChange", path, "", res.getError());
				}
				return success("MaturityChange", ValidationResult.ValidationType.CARDINALITY, "MaturityChange", path, "");
			})
			.collect(toList());
	}

}
