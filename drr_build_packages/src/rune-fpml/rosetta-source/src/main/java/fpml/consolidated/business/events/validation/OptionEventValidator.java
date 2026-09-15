package fpml.consolidated.business.events.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.business.events.KnockOutRateObservation;
import fpml.consolidated.business.events.NoTouchRateObservation;
import fpml.consolidated.business.events.OptionEvent;
import fpml.consolidated.business.events.TouchRateObservation;
import fpml.consolidated.business.events.TriggerRateObservation;
import fpml.consolidated.doc.Trade;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class OptionEventValidator implements Validator<OptionEvent> {

	private List<ComparisonResult> getComparisonResults(OptionEvent o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("originalTrade", (Trade) o.getOriginalTrade() != null ? 1 : 0, 0, 1), 
				checkCardinality("knockIn", (TriggerRateObservation) o.getKnockIn() != null ? 1 : 0, 0, 1), 
				checkCardinality("knockOut", (KnockOutRateObservation) o.getKnockOut() != null ? 1 : 0, 0, 1), 
				checkCardinality("touch", (List<? extends TouchRateObservation>) o.getTouch() == null ? 0 : o.getTouch().size(), 0, 2), 
				checkCardinality("noTouch", (NoTouchRateObservation) o.getNoTouch() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, OptionEvent o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("OptionEvent", ValidationResult.ValidationType.CARDINALITY, "OptionEvent", path, "", res.getError());
				}
				return success("OptionEvent", ValidationResult.ValidationType.CARDINALITY, "OptionEvent", path, "");
			})
			.collect(toList());
	}

}
