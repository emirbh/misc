package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.ActiveOrHistoricCurrencyAnd20Amount;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ActiveOrHistoricCurrencyAnd20AmountValidator implements Validator<ActiveOrHistoricCurrencyAnd20Amount> {

	private List<ComparisonResult> getComparisonResults(ActiveOrHistoricCurrencyAnd20Amount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (BigDecimal) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("ccy", (String) o.getCcy() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ActiveOrHistoricCurrencyAnd20Amount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ActiveOrHistoricCurrencyAnd20Amount", ValidationResult.ValidationType.CARDINALITY, "ActiveOrHistoricCurrencyAnd20Amount", path, "", res.getError());
				}
				return success("ActiveOrHistoricCurrencyAnd20Amount", ValidationResult.ValidationType.CARDINALITY, "ActiveOrHistoricCurrencyAnd20Amount", path, "");
			})
			.collect(toList());
	}

}
