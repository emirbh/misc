package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.ExchangeTradedFund;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkString;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Optional.empty;
import static java.util.stream.Collectors.toList;

public class ExchangeTradedFundTypeFormatValidator implements Validator<ExchangeTradedFund> {

	private List<ComparisonResult> getComparisonResults(ExchangeTradedFund o) {
		return Lists.<ComparisonResult>newArrayList(
				checkString("description", o.getDescription(), 1, empty(), empty()), 
				checkString("fundManager", o.getFundManager(), 1, empty(), empty())
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeTradedFund o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExchangeTradedFund", ValidationResult.ValidationType.TYPE_FORMAT, "ExchangeTradedFund", path, "", res.getError());
				}
				return success("ExchangeTradedFund", ValidationResult.ValidationType.TYPE_FORMAT, "ExchangeTradedFund", path, "");
			})
			.collect(toList());
	}

}
