package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrualSettlementPeriod;
import fpml.consolidated.fx.accruals.FxAccrualSettlementPeriodSchedule;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAccrualSettlementPeriodScheduleValidator implements Validator<FxAccrualSettlementPeriodSchedule> {

	private List<ComparisonResult> getComparisonResults(FxAccrualSettlementPeriodSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("settlementPeriod", (List<? extends FxAccrualSettlementPeriod>) o.getSettlementPeriod() == null ? 0 : o.getSettlementPeriod().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrualSettlementPeriodSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrualSettlementPeriodSchedule", ValidationResult.ValidationType.CARDINALITY, "FxAccrualSettlementPeriodSchedule", path, "", res.getError());
				}
				return success("FxAccrualSettlementPeriodSchedule", ValidationResult.ValidationType.CARDINALITY, "FxAccrualSettlementPeriodSchedule", path, "");
			})
			.collect(toList());
	}

}
