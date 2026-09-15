package iso20022.auth030.asic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.asic.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ActiveOrHistoricCurrencyAnd13DecimalAmountTypeFormatValidator implements Validator<ActiveOrHistoricCurrencyAnd13DecimalAmount> {

	private List<ComparisonResult> getComparisonResults(ActiveOrHistoricCurrencyAnd13DecimalAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkNumber("value", o.getValue(), of(18), of(13), of(new BigDecimal("0")), empty()), 
				checkString("ccy", o.getCcy(), 0, empty(), of(Pattern.compile("[A-Z]{3,3}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ActiveOrHistoricCurrencyAnd13DecimalAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ActiveOrHistoricCurrencyAnd13DecimalAmount", ValidationResult.ValidationType.TYPE_FORMAT, "ActiveOrHistoricCurrencyAnd13DecimalAmount", path, "", res.getError());
				}
				return success("ActiveOrHistoricCurrencyAnd13DecimalAmount", ValidationResult.ValidationType.TYPE_FORMAT, "ActiveOrHistoricCurrencyAnd13DecimalAmount", path, "");
			})
			.collect(toList());
	}

}
