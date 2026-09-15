package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.TriggerRateObservation;
import fpml.consolidated.fpmlenum.TriggerConditionEnum;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.InformationSource;
import fpml.consolidated.shared.PositiveMoney;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class TriggerRateObservationValidator implements Validator<TriggerRateObservation> {

	private List<ComparisonResult> getComparisonResults(TriggerRateObservation o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("observationDate", (ZonedDateTime) o.getObservationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("observationTime", (BusinessCenterTime) o.getObservationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("informationSource", (InformationSource) o.getInformationSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerRate", (BigDecimal) o.getTriggerRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 0, 1), 
				checkCardinality("observedRate", (BigDecimal) o.getObservedRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerPrice", (PositiveMoney) o.getTriggerPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("observedPrice", (PositiveMoney) o.getObservedPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerCondition", (TriggerConditionEnum) o.getTriggerCondition() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, TriggerRateObservation o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("TriggerRateObservation", ValidationResult.ValidationType.CARDINALITY, "TriggerRateObservation", path, "", res.getError());
				}
				return success("TriggerRateObservation", ValidationResult.ValidationType.CARDINALITY, "TriggerRateObservation", path, "");
			})
			.collect(toList());
	}

}
