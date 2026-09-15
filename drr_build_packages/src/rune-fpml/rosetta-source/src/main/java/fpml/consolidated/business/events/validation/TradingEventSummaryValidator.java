package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.EventType;
import fpml.consolidated.business.events.TradingEventSummary;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.fpmlenum.NotionalChangeEnum;
import fpml.consolidated.shared.NonNegativePayment;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradingEventSummaryValidator implements Validator<TradingEventSummary> {

	private List<ComparisonResult> getComparisonResults(TradingEventSummary o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("eventType", (EventType) o.getEventType() != null ? 1 : 0, 1, 1), 
				checkCardinality("agreementDate", (ZonedDateTime) o.getAgreementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionDateTime", (ExecutionDateTime) o.getExecutionDateTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (ZonedDateTime) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalChange", (NotionalChangeEnum) o.getNotionalChange() != null ? 1 : 0, 0, 1), 
				checkCardinality("payment", (NonNegativePayment) o.getPayment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradingEventSummary o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradingEventSummary", ValidationResult.ValidationType.CARDINALITY, "TradingEventSummary", path, "", res.getError());
				}
				return success("TradingEventSummary", ValidationResult.ValidationType.CARDINALITY, "TradingEventSummary", path, "");
			})
			.collect(toList());
	}

}
