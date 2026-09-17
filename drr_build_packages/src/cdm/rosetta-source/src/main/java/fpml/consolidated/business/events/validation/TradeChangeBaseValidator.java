package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradeChangeBase;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.Trade;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeChangeBaseValidator implements Validator<TradeChangeBase> {

	private List<ComparisonResult> getComparisonResults(TradeChangeBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("originalTrade", (Trade) o.getOriginalTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("resultingTrade", (Trade) o.getResultingTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("agreementDate", (ZonedDateTime) o.getAgreementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionDateTime", (ExecutionDateTime) o.getExecutionDateTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (ZonedDateTime) o.getEffectiveDate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeChangeBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeChangeBase", ValidationResult.ValidationType.CARDINALITY, "TradeChangeBase", path, "", res.getError());
				}
				return success("TradeChangeBase", ValidationResult.ValidationType.CARDINALITY, "TradeChangeBase", path, "");
			})
			.collect(toList());
	}

}
