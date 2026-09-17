package fpml.consolidated.generic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.generic.GenericProductExchangeRate;
import fpml.consolidated.generic.GenericProductQuotedCurrencyPair;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GenericProductExchangeRateValidator implements Validator<GenericProductExchangeRate> {

	private List<ComparisonResult> getComparisonResults(GenericProductExchangeRate o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quotedCurrencyPair", (GenericProductQuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1), 
				checkCardinality("rate", (BigDecimal) o.getRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("spotRate", (BigDecimal) o.getSpotRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("forwardPoints", (BigDecimal) o.getForwardPoints() != null ? 1 : 0, 0, 1), 
				checkCardinality("pointValue", (BigDecimal) o.getPointValue() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericProductExchangeRate o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericProductExchangeRate", ValidationResult.ValidationType.CARDINALITY, "GenericProductExchangeRate", path, "", res.getError());
				}
				return success("GenericProductExchangeRate", ValidationResult.ValidationType.CARDINALITY, "GenericProductExchangeRate", path, "");
			})
			.collect(toList());
	}

}
