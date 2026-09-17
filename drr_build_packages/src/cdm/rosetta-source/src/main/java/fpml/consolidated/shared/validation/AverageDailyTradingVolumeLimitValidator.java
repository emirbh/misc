package fpml.consolidated.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.shared.AverageDailyTradingVolumeLimit;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AverageDailyTradingVolumeLimitValidator implements Validator<AverageDailyTradingVolumeLimit> {

	private List<ComparisonResult> getComparisonResults(AverageDailyTradingVolumeLimit o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("limitationPercentage", (BigDecimal) o.getLimitationPercentage() != null ? 1 : 0, 0, 1), 
				checkCardinality("limitationPeriod", (Integer) o.getLimitationPeriod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AverageDailyTradingVolumeLimit o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AverageDailyTradingVolumeLimit", ValidationResult.ValidationType.CARDINALITY, "AverageDailyTradingVolumeLimit", path, "", res.getError());
				}
				return success("AverageDailyTradingVolumeLimit", ValidationResult.ValidationType.CARDINALITY, "AverageDailyTradingVolumeLimit", path, "");
			})
			.collect(toList());
	}

}
