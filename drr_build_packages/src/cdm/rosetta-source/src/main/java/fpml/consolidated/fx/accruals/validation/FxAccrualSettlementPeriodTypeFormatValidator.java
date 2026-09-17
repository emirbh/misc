package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrualSettlementPeriod;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAccrualSettlementPeriodTypeFormatValidator implements Validator<FxAccrualSettlementPeriod> {

	private List<ComparisonResult> getComparisonResults(FxAccrualSettlementPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualSettlementPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualSettlementPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriod", path, "", res.getError());
				}
				return success("FxAccrualSettlementPeriod", ValidationResult.ValidationType.TYPE_FORMAT, "FxAccrualSettlementPeriod", path, "");
			})
			.collect(toList());
	}

}
