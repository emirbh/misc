package fpml.consolidated.option.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.option.shared.AveragingObservationList;
import fpml.consolidated.option.shared.AveragingPeriod;
import fpml.consolidated.option.shared.MarketDisruption;
import fpml.consolidated.shared.DateTimeList;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class AveragingPeriodValidator implements Validator<AveragingPeriod> {

	private List<ComparisonResult> getComparisonResults(AveragingPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("averagingDateTimes", (DateTimeList) o.getAveragingDateTimes() != null ? 1 : 0, 0, 1), 
				checkCardinality("averagingObservations", (AveragingObservationList) o.getAveragingObservations() != null ? 1 : 0, 0, 1), 
				checkCardinality("marketDisruption", (MarketDisruption) o.getMarketDisruption() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, AveragingPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("AveragingPeriod", ValidationResult.ValidationType.CARDINALITY, "AveragingPeriod", path, "", res.getError());
				}
				return success("AveragingPeriod", ValidationResult.ValidationType.CARDINALITY, "AveragingPeriod", path, "");
			})
			.collect(toList());
	}

}
