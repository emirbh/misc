package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.DualCurrencyFeature;
import fpml.consolidated.fx.DualCurrencyStrikePrice;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DualCurrencyFeatureValidator implements Validator<DualCurrencyFeature> {

	private List<ComparisonResult> getComparisonResults(DualCurrencyFeature o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingDate", (ZonedDateTime) o.getFixingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixingTime", (BusinessCenterTime) o.getFixingTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("strike", (DualCurrencyStrikePrice) o.getStrike() != null ? 1 : 0, 0, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestAtRisk", (Boolean) o.getInterestAtRisk() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DualCurrencyFeature o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DualCurrencyFeature", ValidationResult.ValidationType.CARDINALITY, "DualCurrencyFeature", path, "", res.getError());
				}
				return success("DualCurrencyFeature", ValidationResult.ValidationType.CARDINALITY, "DualCurrencyFeature", path, "");
			})
			.collect(toList());
	}

}
