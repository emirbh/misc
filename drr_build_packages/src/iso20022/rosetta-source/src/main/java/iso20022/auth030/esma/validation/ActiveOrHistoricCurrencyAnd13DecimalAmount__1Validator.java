package iso20022.auth030.esma.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.esma.ActiveOrHistoricCurrencyAnd13DecimalAmount__1;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ActiveOrHistoricCurrencyAnd13DecimalAmount__1Validator implements Validator<ActiveOrHistoricCurrencyAnd13DecimalAmount__1> {

	private List<ComparisonResult> getComparisonResults(ActiveOrHistoricCurrencyAnd13DecimalAmount__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("value", (BigDecimal) o.getValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("ccy", (String) o.getCcy() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ActiveOrHistoricCurrencyAnd13DecimalAmount__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ActiveOrHistoricCurrencyAnd13DecimalAmount__1", ValidationResult.ValidationType.CARDINALITY, "ActiveOrHistoricCurrencyAnd13DecimalAmount__1", path, "", res.getError());
				}
				return success("ActiveOrHistoricCurrencyAnd13DecimalAmount__1", ValidationResult.ValidationType.CARDINALITY, "ActiveOrHistoricCurrencyAnd13DecimalAmount__1", path, "");
			})
			.collect(toList());
	}

}
