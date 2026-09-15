package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxAccrual;
import fpml.consolidated.fx.accruals.FxAccrualRegion;
import fpml.consolidated.fx.accruals.FxFixingSchedule;
import fpml.consolidated.fx.accruals.FxRateObservable;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAccrualValidator implements Validator<FxAccrual> {

	private List<ComparisonResult> getComparisonResults(FxAccrual o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("observable", (List<? extends FxRateObservable>) o.getObservable() == null ? 0 : o.getObservable().size(), 1, 0), 
				checkCardinality("accrualRegion", (List<? extends FxAccrualRegion>) o.getAccrualRegion() == null ? 0 : o.getAccrualRegion().size(), 1, 0), 
				checkCardinality("fixingSchedule", (FxFixingSchedule) o.getFixingSchedule() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAccrual o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAccrual", ValidationResult.ValidationType.CARDINALITY, "FxAccrual", path, "", res.getError());
				}
				return success("FxAccrual", ValidationResult.ValidationType.CARDINALITY, "FxAccrual", path, "");
			})
			.collect(toList());
	}

}
