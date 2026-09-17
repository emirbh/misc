package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrualSettlementPeriodPayoff;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAccrualSettlementPeriodPayoffTypeFormatValidator implements Validator<FxAccrualSettlementPeriodPayoff> {

	private List<ComparisonResult> getComparisonResults(FxAccrualSettlementPeriodPayoff o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualSettlementPeriodPayoff o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualSettlementPeriodPayoff", ValidationResult.ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriodPayoff", path, "", res.getError());
				}
				return success("FxAccrualSettlementPeriodPayoff", ValidationResult.ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriodPayoff", path, "");
			})
			.collect(toList());
	}

}
