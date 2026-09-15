package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.CurrencyExchange23__1;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class CurrencyExchange23__1TypeFormatValidator implements Validator<CurrencyExchange23__1> {

	private List<ComparisonResult> getComparisonResults(CurrencyExchange23__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("ccy", o.getCcy(), 0, empty(), of(Pattern.compile("[A-Z]{3,3}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CurrencyExchange23__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CurrencyExchange23__1", ValidationResult.ValidationType.TYPE_FORMAT, "CurrencyExchange23__1", path, "", res.getError());
				}
				return success("CurrencyExchange23__1", ValidationResult.ValidationType.TYPE_FORMAT, "CurrencyExchange23__1", path, "");
			})
			.collect(toList());
	}

}
