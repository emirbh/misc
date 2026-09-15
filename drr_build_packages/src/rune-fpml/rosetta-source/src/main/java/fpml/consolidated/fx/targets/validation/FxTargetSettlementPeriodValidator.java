package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxTargetSettlementPeriod;
import fpml.consolidated.fx.targets.FxTargetSettlementPeriodPayoff;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTargetSettlementPeriodValidator implements Validator<FxTargetSettlementPeriod> {

	private List<ComparisonResult> getComparisonResults(FxTargetSettlementPeriod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("expiryDate", (ZonedDateTime) o.getExpiryDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("settlementDate", (ZonedDateTime) o.getSettlementDate() != null ? 1 : 0, 1, 1), 
				checkCardinality("notionalAmount", (BigDecimal) o.getNotionalAmount() != null ? 1 : 0, 1, 1), 
				checkCardinality("pivot", (BigDecimal) o.getPivot() != null ? 1 : 0, 0, 1), 
				checkCardinality("payoff", (List<? extends FxTargetSettlementPeriodPayoff>) o.getPayoff() == null ? 0 : o.getPayoff().size(), 1, 0)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTargetSettlementPeriod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTargetSettlementPeriod", ValidationResult.ValidationType.CARDINALITY, "FxTargetSettlementPeriod", path, "", res.getError());
				}
				return success("FxTargetSettlementPeriod", ValidationResult.ValidationType.CARDINALITY, "FxTargetSettlementPeriod", path, "");
			})
			.collect(toList());
	}

}
