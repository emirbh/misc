package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.TriggerConditionEnum;
import fpml.consolidated.fx.FxTriggerBase;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTriggerBaseValidator implements Validator<FxTriggerBase> {

	private List<ComparisonResult> getComparisonResults(FxTriggerBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("triggerCondition", (TriggerConditionEnum) o.getTriggerCondition() != null ? 1 : 0, 1, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 0, 1), 
				checkCardinality("triggerRate", (BigDecimal) o.getTriggerRate() != null ? 1 : 0, 1, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTriggerBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTriggerBase", ValidationResult.ValidationType.CARDINALITY, "FxTriggerBase", path, "", res.getError());
				}
				return success("FxTriggerBase", ValidationResult.ValidationType.CARDINALITY, "FxTriggerBase", path, "");
			})
			.collect(toList());
	}

}
