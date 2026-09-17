package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.doc.AdditionalData;
import fpml.consolidated.loan.LoanNotificationException;
import fpml.consolidated.loan.TaskIdentifier;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.ExceptionMessageHeader;
import fpml.consolidated.shared.Party;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LoanNotificationExceptionValidator implements Validator<LoanNotificationException> {

	private List<ComparisonResult> getComparisonResults(LoanNotificationException o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fpmlVersion", (String) o.getFpmlVersion() != null ? 1 : 0, 1, 1), 
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (ExceptionMessageHeader) o.getHeader() != null ? 1 : 0, 0, 1), 
				checkCardinality("parentCorrelationId", (CorrelationId) o.getParentCorrelationId() != null ? 1 : 0, 0, 1), 
				checkCardinality("correlationId", (List<? extends CorrelationId>) o.getCorrelationId() == null ? 0 : o.getCorrelationId().size(), 0, 2), 
				checkCardinality("sequenceNumber", (Integer) o.getSequenceNumber() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalData", (AdditionalData) o.getAdditionalData() != null ? 1 : 0, 0, 1), 
				checkCardinality("eventIdentifier", (BusinessEventIdentifier) o.getEventIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("taskIdentifier", (TaskIdentifier) o.getTaskIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("party", (Party) o.getParty() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanNotificationException o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LoanNotificationException", ValidationResult.ValidationType.CARDINALITY, "LoanNotificationException", path, "", res.getError());
				}
				return success("LoanNotificationException", ValidationResult.ValidationType.CARDINALITY, "LoanNotificationException", path, "");
			})
			.collect(toList());
	}

}
