package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetSettlementPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetSettlementPeriodTypeFormatValidator implements Validator<FxTargetSettlementPeriod> {

	private List<ComparisonResult> getComparisonResults(FxTargetSettlementPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetSettlementPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetSettlementPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "FxTargetSettlementPeriod", path, "", res.getError());
				}
				return success("FxTargetSettlementPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "FxTargetSettlementPeriod", path, "");
			})
			.collect(toList());
	}

}
