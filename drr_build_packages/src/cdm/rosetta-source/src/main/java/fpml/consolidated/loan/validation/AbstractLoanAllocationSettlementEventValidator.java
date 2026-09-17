package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.AbstractLoanAllocationSettlementEvent;
import fpml.consolidated.loan.CashPayable;
import fpml.consolidated.loan.FacilityPosition;
import fpml.consolidated.loan.LoanAllocationReference;
import fpml.consolidated.loan.ParentEventIdentifier;
import fpml.consolidated.shared.NonNegativeMoney;
import fpml.consolidated.shared.PartyReference;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AbstractLoanAllocationSettlementEventValidator implements Validator<AbstractLoanAllocationSettlementEvent> {

	private List<ComparisonResult> getComparisonResults(AbstractLoanAllocationSettlementEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eventIdentifier", (List<? extends BusinessEventIdentifier>) o.getEventIdentifier() == null ? 0 : o.getEventIdentifier().size(), 1, 0), 
				checkCardinality("parentEventIdentifier", (ParentEventIdentifier) o.getParentEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("previousEventIdentifier", (BusinessEventIdentifier) o.getPreviousEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("correctedEventIdentifier", (BusinessEventIdentifier) o.getCorrectedEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("lenderPartyReference", (PartyReference) o.getLenderPartyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashPayable", (CashPayable) o.getCashPayable() != null ? 1 : 0, 0, 1), 
				checkCardinality("comment", (String) o.getComment() != null ? 1 : 0, 0, 1), 
				checkCardinality("allocationReference", (LoanAllocationReference) o.getAllocationReference() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementDate", (ZonedDateTime) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("allocationAmount", (NonNegativeMoney) o.getAllocationAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("facilityPosition", (FacilityPosition) o.getFacilityPosition() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AbstractLoanAllocationSettlementEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AbstractLoanAllocationSettlementEvent", ValidationResult.ValidationType.CARDINALITY, "AbstractLoanAllocationSettlementEvent", path, "", res.getError());
				}
				return success("AbstractLoanAllocationSettlementEvent", ValidationResult.ValidationType.CARDINALITY, "AbstractLoanAllocationSettlementEvent", path, "");
			})
			.collect(toList());
	}

}
