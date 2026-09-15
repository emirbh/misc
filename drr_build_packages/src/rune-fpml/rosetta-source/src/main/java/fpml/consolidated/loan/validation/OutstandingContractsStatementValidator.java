package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.DealIdentifier;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.loan.FacilityIdentifier;
import fpml.consolidated.loan.OutstandingContractsStatement;
import fpml.consolidated.loan.OutstandingContractsStatementChoice;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OutstandingContractsStatementValidator implements Validator<OutstandingContractsStatement> {

	private List<ComparisonResult> getComparisonResults(OutstandingContractsStatement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fpmlVersion", (String) o.getFpmlVersion() != null ? 1 : 0, 1, 1), 
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 0, 1), 
				checkCardinality("isCorrection", (Boolean) o.getIsCorrection() != null ? 1 : 0, 0, 1), 
				checkCardinality("parentCorrelationId", (CorrelationId) o.getParentCorrelationId() != null ? 1 : 0, 0, 1), 
				checkCardinality("correlationId", (List<? extends CorrelationId>) o.getCorrelationId() == null ? 0 : o.getCorrelationId().size(), 0, 2), 
				checkCardinality("sequenceNumber", (Integer) o.getSequenceNumber() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOf", (List<? extends OnBehalfOf>) o.getOnBehalfOf() == null ? 0 : o.getOnBehalfOf().size(), 0, 4), 
				checkCardinality("statementDate", (ZonedDateTime) o.getStatementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("comments", (String) o.getComments() != null ? 1 : 0, 0, 1), 
				checkCardinality("dealIdentifier", (DealIdentifier) o.getDealIdentifier() != null ? 1 : 0, 0, 1), 
				checkCardinality("dealSummary", (DealSummary) o.getDealSummary() != null ? 1 : 0, 0, 1), 
				checkCardinality("facilityIdentifier", (FacilityIdentifier) o.getFacilityIdentifier() != null ? 1 : 0, 1, 1), 
				checkCardinality("outstandingContractsStatementChoice", (List<? extends OutstandingContractsStatementChoice>) o.getOutstandingContractsStatementChoice() == null ? 0 : o.getOutstandingContractsStatementChoice().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OutstandingContractsStatement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OutstandingContractsStatement", ValidationResult.ValidationType.CARDINALITY, "OutstandingContractsStatement", path, "", res.getError());
				}
				return success("OutstandingContractsStatement", ValidationResult.ValidationType.CARDINALITY, "OutstandingContractsStatement", path, "");
			})
			.collect(toList());
	}

}
