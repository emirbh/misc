package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.FxBusinessCenterDateTime;
import fpml.consolidated.shared.BusinessCenterTime;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxBusinessCenterDateTimeValidator implements Validator<FxBusinessCenterDateTime> {

	private List<ComparisonResult> getComparisonResults(FxBusinessCenterDateTime o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("date", (ZonedDateTime) o.getDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("time", (BusinessCenterTime) o.getTime() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxBusinessCenterDateTime o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxBusinessCenterDateTime", ValidationResult.ValidationType.CARDINALITY, "FxBusinessCenterDateTime", path, "", res.getError());
				}
				return success("FxBusinessCenterDateTime", ValidationResult.ValidationType.CARDINALITY, "FxBusinessCenterDateTime", path, "");
			})
			.collect(toList());
	}

}
