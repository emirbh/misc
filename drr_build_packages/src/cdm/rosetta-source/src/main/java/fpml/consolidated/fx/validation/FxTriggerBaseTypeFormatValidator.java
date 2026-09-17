package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxTriggerBase;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class FxTriggerBaseTypeFormatValidator implements Validator<FxTriggerBase> {

	private List<ComparisonResult> getComparisonResults(FxTriggerBase o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("triggerRate", o.getTriggerRate(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkNumber("spotRate", o.getSpotRate(), empty(), empty(), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTriggerBase o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTriggerBase", ValidationResult.ValidationType.TYPE_FORMAT, "FxTriggerBase", path, "", res.getError());
				}
				return success("FxTriggerBase", ValidationResult.ValidationType.TYPE_FORMAT, "FxTriggerBase", path, "");
			})
			.collect(toList());
	}

}
