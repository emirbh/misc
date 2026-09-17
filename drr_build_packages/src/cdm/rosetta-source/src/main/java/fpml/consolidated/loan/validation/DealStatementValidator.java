package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.Deal;
import fpml.consolidated.loan.DealStatement;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DealStatementValidator implements Validator<DealStatement> {

	private List<ComparisonResult> getComparisonResults(DealStatement o) {
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
				checkCardinality("deal", (Deal) o.getDeal() != null ? 1 : 0, 1, 1), 
				checkCardinality("party", (List<? extends Party>) o.getParty() == null ? 0 : o.getParty().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DealStatement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DealStatement", ValidationResult.ValidationType.CARDINALITY, "DealStatement", path, "", res.getError());
				}
				return success("DealStatement", ValidationResult.ValidationType.CARDINALITY, "DealStatement", path, "");
			})
			.collect(toList());
	}

}
