package iso20022.auth030.mas.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.mas.ExchangeRateBasis1;
import java.util.List;
import java.util.regex.Pattern;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ExchangeRateBasis1TypeFormatValidator implements Validator<ExchangeRateBasis1> {

	private List<ComparisonResult> getComparisonResults(ExchangeRateBasis1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("baseCcy", o.getBaseCcy(), 0, empty(), of(Pattern.compile("[A-Z]{3,3}"))), 
				checkString("qtdCcy", o.getQtdCcy(), 0, empty(), of(Pattern.compile("[A-Z]{3,3}")))
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeRateBasis1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExchangeRateBasis1", ValidationResult.ValidationType.TYPE_FORMAT, "ExchangeRateBasis1", path, "", res.getError());
				}
				return success("ExchangeRateBasis1", ValidationResult.ValidationType.TYPE_FORMAT, "ExchangeRateBasis1", path, "");
			})
			.collect(toList());
	}

}
