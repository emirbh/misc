package fpml.consolidated.generic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.generic.GenericProductQuotedCurrencyPair;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GenericProductQuotedCurrencyPairTypeFormatValidator implements Validator<GenericProductQuotedCurrencyPair> {

	private List<ComparisonResult> getComparisonResults(GenericProductQuotedCurrencyPair o) {
		return Lists.<ComparisonResult>newArrayList(
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericProductQuotedCurrencyPair o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericProductQuotedCurrencyPair", ValidationResult.ValidationType.TYPE_FORMAT, "GenericProductQuotedCurrencyPair", path, "", res.getError());
				}
				return success("GenericProductQuotedCurrencyPair", ValidationResult.ValidationType.TYPE_FORMAT, "GenericProductQuotedCurrencyPair", path, "");
			})
			.collect(toList());
	}

}
