package fpml.consolidated.fx.accruals.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.FxAveragingMethodEnum;
import fpml.consolidated.fx.accruals.FxAverageStrike;
import fpml.consolidated.fx.accruals.FxWeightedFixingSchedule;
import fpml.consolidated.shared.FxInformationSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxAverageStrikeValidator implements Validator<FxAverageStrike> {

	private List<ComparisonResult> getComparisonResults(FxAverageStrike o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1), 
				checkCardinality("informationSource", (FxInformationSource) o.getInformationSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingSchedule", (FxWeightedFixingSchedule) o.getFixingSchedule() != null ? 1 : 0, 1, 1), 
				checkCardinality("averagingMethod", (FxAveragingMethodEnum) o.getAveragingMethod() != null ? 1 : 0, 1, 1), 
				checkCardinality("precision", (Integer) o.getPrecision() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeAdjustment", (BigDecimal) o.getStrikeAdjustment() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxAverageStrike o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxAverageStrike", ValidationResult.ValidationType.CARDINALITY, "FxAverageStrike", path, "", res.getError());
				}
				return success("FxAverageStrike", ValidationResult.ValidationType.CARDINALITY, "FxAverageStrike", path, "");
			})
			.collect(toList());
	}

}
