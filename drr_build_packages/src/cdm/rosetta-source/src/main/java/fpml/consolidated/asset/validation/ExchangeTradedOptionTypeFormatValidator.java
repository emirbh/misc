package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.ExchangeTradedOption;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkNumber;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static java.util.stream.Collectors.toList;

public class ExchangeTradedOptionTypeFormatValidator implements Validator<ExchangeTradedOption> {

	private List<ComparisonResult> getComparisonResults(ExchangeTradedOption o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 1, empty(), empty()), 
				checkNumber("multiplier", o.getMultiplier(), empty(), empty(), of(new BigDecimal("0")), empty()), 
				checkString("contractReference", o.getContractReference(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeTradedOption o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExchangeTradedOption", ValidationResult.ValidationType.TYPE_FORMAT, "ExchangeTradedOption", path, "", res.getError());
				}
				return success("ExchangeTradedOption", ValidationResult.ValidationType.TYPE_FORMAT, "ExchangeTradedOption", path, "");
			})
			.collect(toList());
	}

}
