package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.ObservationEvent;
import fpml.consolidated.business.events.ObservationSource;
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.shared.TimeZone;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ObservationEventValidator implements Validator<ObservationEvent> {

	private List<ComparisonResult> getComparisonResults(ObservationEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("date", (ZonedDateTime) o.getDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("time", (TimeZone) o.getTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("side", (QuotationRateTypeEnum) o.getSide() != null ? 1 : 0, 0, 1), 
				checkCardinality("observedValue", (BigDecimal) o.getObservedValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("source", (ObservationSource) o.getSource() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ObservationEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ObservationEvent", ValidationResult.ValidationType.CARDINALITY, "ObservationEvent", path, "", res.getError());
				}
				return success("ObservationEvent", ValidationResult.ValidationType.CARDINALITY, "ObservationEvent", path, "");
			})
			.collect(toList());
	}

}
