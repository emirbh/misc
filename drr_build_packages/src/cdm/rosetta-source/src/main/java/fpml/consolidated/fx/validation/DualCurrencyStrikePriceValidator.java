package fpml.consolidated.fx.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.DualCurrencyStrikeQuoteBasisEnum;
import fpml.consolidated.fx.DualCurrencyStrikePrice;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DualCurrencyStrikePriceValidator implements Validator<DualCurrencyStrikePrice> {

	private List<ComparisonResult> getComparisonResults(DualCurrencyStrikePrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("rate", (BigDecimal) o.getRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("strikeQuoteBasis", (DualCurrencyStrikeQuoteBasisEnum) o.getStrikeQuoteBasis() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DualCurrencyStrikePrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DualCurrencyStrikePrice", ValidationResult.ValidationType.CARDINALITY, "DualCurrencyStrikePrice", path, "", res.getError());
				}
				return success("DualCurrencyStrikePrice", ValidationResult.ValidationType.CARDINALITY, "DualCurrencyStrikePrice", path, "");
			})
			.collect(toList());
	}

}
