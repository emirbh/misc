package fpml.consolidated.generic.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.QuoteBasisEnum;
import fpml.consolidated.generic.GenericProductQuotedCurrencyPair;
import fpml.consolidated.shared.Currency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class GenericProductQuotedCurrencyPairValidator implements Validator<GenericProductQuotedCurrencyPair> {

	private List<ComparisonResult> getComparisonResults(GenericProductQuotedCurrencyPair o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("currency1", (Currency) o.getCurrency1() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency2", (Currency) o.getCurrency2() != null ? 1 : 0, 1, 1), 
				checkCardinality("quoteBasis", (QuoteBasisEnum) o.getQuoteBasis() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, GenericProductQuotedCurrencyPair o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("GenericProductQuotedCurrencyPair", ValidationResult.ValidationType.CARDINALITY, "GenericProductQuotedCurrencyPair", path, "", res.getError());
				}
				return success("GenericProductQuotedCurrencyPair", ValidationResult.ValidationType.CARDINALITY, "GenericProductQuotedCurrencyPair", path, "");
			})
			.collect(toList());
	}

}
