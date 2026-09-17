package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.doc.ExecutionDateTime;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.fpmlenum.NotionalChangeEnum;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TradeAmendmentContentValidator implements Validator<TradeAmendmentContent> {

	private List<ComparisonResult> getComparisonResults(TradeAmendmentContent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("trade", (Trade) o.getTrade() != null ? 1 : 0, 1, 1), 
				checkCardinality("agreementDate", (ZonedDateTime) o.getAgreementDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("executionDateTime", (ExecutionDateTime) o.getExecutionDateTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("effectiveDate", (ZonedDateTime) o.getEffectiveDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("notionalChange", (NotionalChangeEnum) o.getNotionalChange() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TradeAmendmentContent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TradeAmendmentContent", ValidationResult.ValidationType.CARDINALITY, "TradeAmendmentContent", path, "", res.getError());
				}
				return success("TradeAmendmentContent", ValidationResult.ValidationType.CARDINALITY, "TradeAmendmentContent", path, "");
			})
			.collect(toList());
	}

}
