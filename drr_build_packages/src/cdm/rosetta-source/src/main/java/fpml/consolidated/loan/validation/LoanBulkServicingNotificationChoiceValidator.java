package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.AbstractFacilityEvent;
import fpml.consolidated.loan.AbstractLcEvent;
import fpml.consolidated.loan.AbstractLoanServicingEvent;
import fpml.consolidated.loan.LoanBulkServicingNotificationChoice;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanBulkServicingNotificationChoiceValidator implements Validator<LoanBulkServicingNotificationChoice> {

	private List<ComparisonResult> getComparisonResults(LoanBulkServicingNotificationChoice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("facilityEventGroup", (AbstractFacilityEvent) o.getFacilityEventGroup() != null ? 1 : 0, 0, 1), 
				checkCardinality("lcEventGroup", (AbstractLcEvent) o.getLcEventGroup() != null ? 1 : 0, 0, 1), 
				checkCardinality("loanContractEventGroup", (AbstractLoanServicingEvent) o.getLoanContractEventGroup() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanBulkServicingNotificationChoice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanBulkServicingNotificationChoice", ValidationResult.ValidationType.CARDINALITY, "LoanBulkServicingNotificationChoice", path, "", res.getError());
				}
				return success("LoanBulkServicingNotificationChoice", ValidationResult.ValidationType.CARDINALITY, "LoanBulkServicingNotificationChoice", path, "");
			})
			.collect(toList());
	}

}
