package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.PrincipalExchange;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PrincipalExchangeValidator implements Validator<PrincipalExchange> {

	private List<ComparisonResult> getComparisonResults(PrincipalExchange o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("unadjustedPrincipalExchangeDate", (ZonedDateTime) o.getUnadjustedPrincipalExchangeDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("adjustedPrincipalExchangeDate", (ZonedDateTime) o.getAdjustedPrincipalExchangeDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("principalExchangeAmount", (BigDecimal) o.getPrincipalExchangeAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("discountFactor", (BigDecimal) o.getDiscountFactor() != null ? 1 : 0, 0, 1), 
				checkCardinality("presentValuePrincipalExchangeAmount", (Money) o.getPresentValuePrincipalExchangeAmount() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PrincipalExchange o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PrincipalExchange", ValidationResult.ValidationType.CARDINALITY, "PrincipalExchange", path, "", res.getError());
				}
				return success("PrincipalExchange", ValidationResult.ValidationType.CARDINALITY, "PrincipalExchange", path, "");
			})
			.collect(toList());
	}

}
