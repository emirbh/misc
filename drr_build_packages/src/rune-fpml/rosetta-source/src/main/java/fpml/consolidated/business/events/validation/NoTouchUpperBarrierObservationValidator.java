package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.NoTouchUpperBarrierObservation;
import fpml.consolidated.business.events.ObservedPrice;
import fpml.consolidated.business.events.ObservedRate;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class NoTouchUpperBarrierObservationValidator implements Validator<NoTouchUpperBarrierObservation> {

	private List<ComparisonResult> getComparisonResults(NoTouchUpperBarrierObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("triggerRate", (BigDecimal) o.getTriggerRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 0, 1), 
				checkCardinality("maximumObservedRate", (ObservedRate) o.getMaximumObservedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerPrice", (PositiveMoney) o.getTriggerPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("maximumObservedPrice", (ObservedPrice) o.getMaximumObservedPrice() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, NoTouchUpperBarrierObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("NoTouchUpperBarrierObservation", ValidationResult.ValidationType.CARDINALITY, "NoTouchUpperBarrierObservation", path, "", res.getError());
				}
				return success("NoTouchUpperBarrierObservation", ValidationResult.ValidationType.CARDINALITY, "NoTouchUpperBarrierObservation", path, "");
			})
			.collect(toList());
	}

}
