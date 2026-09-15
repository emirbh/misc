package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.accruals.FxFixingSchedule;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class FxFixingScheduleTypeFormatValidator implements Validator<FxFixingSchedule> {

	private List<ComparisonResult> getComparisonResults(FxFixingSchedule o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("numberOfFixings", o.getNumberOfFixings(), empty(), of(0), of(new BigDecimal("0")), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxFixingSchedule o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxFixingSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "FxFixingSchedule", path, "", res.getError());
				}
				return success("FxFixingSchedule", ValidationResult.ValidationType.TYPE_FORMAT, "FxFixingSchedule", path, "");
			})
			.collect(toList());
	}

}
