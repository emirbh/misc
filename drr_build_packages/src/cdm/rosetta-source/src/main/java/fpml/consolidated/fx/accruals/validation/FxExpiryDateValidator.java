package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxExpiryDate;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.BusinessDayAdjustments;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxExpiryDateValidator implements Validator<FxExpiryDate> {

	private List<ComparisonResult> getComparisonResults(FxExpiryDate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dateAdjustments", (BusinessDayAdjustments) o.getDateAdjustments() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedDate", (ZonedDateTime) o.getAdjustedDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("expiryTime", (BusinessCenterTime) o.getExpiryTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxExpiryDate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxExpiryDate", ValidationResult.ValidationType.CARDINALITY, "FxExpiryDate", path, "", res.getError());
				}
				return success("FxExpiryDate", ValidationResult.ValidationType.CARDINALITY, "FxExpiryDate", path, "");
			})
			.collect(toList());
	}

}
