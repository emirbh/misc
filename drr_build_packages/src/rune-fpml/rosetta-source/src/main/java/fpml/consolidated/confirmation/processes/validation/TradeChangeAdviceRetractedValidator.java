package fpml.consolidated.confirmation.processes.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradeChangeContent;
import fpml.consolidated.confirmation.processes.TradeChangeAdviceRetracted;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeChangeAdviceRetractedValidator implements Validator<TradeChangeAdviceRetracted> {

	private List<ComparisonResult> getComparisonResults(TradeChangeAdviceRetracted o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("fpmlVersion", (String) o.getFpmlVersion() != null ? 1 : 0, 1, 1), 
				checkCardinality("expectedBuild", (Integer) o.getExpectedBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("actualBuild", (Integer) o.getActualBuild() != null ? 1 : 0, 0, 1), 
				checkCardinality("header", (RequestMessageHeader) o.getHeader() != null ? 1 : 0, 0, 1), 
				checkCardinality("parentCorrelationId", (CorrelationId) o.getParentCorrelationId() != null ? 1 : 0, 0, 1), 
				checkCardinality("correlationId", (List<? extends CorrelationId>) o.getCorrelationId() == null ? 0 : o.getCorrelationId().size(), 0, 2), 
				checkCardinality("sequenceNumber", (Integer) o.getSequenceNumber() != null ? 1 : 0, 0, 1), 
				checkCardinality("onBehalfOf", (List<? extends OnBehalfOf>) o.getOnBehalfOf() == null ? 0 : o.getOnBehalfOf().size(), 0, 4), 
				checkCardinality("tradeIdentifier", (List<? extends PartyTradeIdentifier>) o.getTradeIdentifier() == null ? 0 : o.getTradeIdentifier().size(), 1, 0), 
				checkCardinality("change", (TradeChangeContent) o.getChange() != null ? 1 : 0, 0, 1), 
				checkCardinality("party", (List<? extends Party>) o.getParty() == null ? 0 : o.getParty().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeChangeAdviceRetracted o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeChangeAdviceRetracted", ValidationResult.ValidationType.CARDINALITY, "TradeChangeAdviceRetracted", path, "", res.getError());
				}
				return success("TradeChangeAdviceRetracted", ValidationResult.ValidationType.CARDINALITY, "TradeChangeAdviceRetracted", path, "");
			})
			.collect(toList());
	}

}
