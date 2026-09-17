package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.DividendPayout;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class DividendPayoutValidator implements Validator<DividendPayout> {

	private List<ComparisonResult> getComparisonResults(DividendPayout o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("dividendPayoutRatio", (BigDecimal) o.getDividendPayoutRatio() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPayoutRatioCash", (BigDecimal) o.getDividendPayoutRatioCash() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPayoutRatioNonCash", (BigDecimal) o.getDividendPayoutRatioNonCash() != null ? 1 : 0, 0, 1), 
				checkCardinality("dividendPayoutConditions", (String) o.getDividendPayoutConditions() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, DividendPayout o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("DividendPayout", ValidationResult.ValidationType.CARDINALITY, "DividendPayout", path, "", res.getError());
				}
				return success("DividendPayout", ValidationResult.ValidationType.CARDINALITY, "DividendPayout", path, "");
			})
			.collect(toList());
	}

}
