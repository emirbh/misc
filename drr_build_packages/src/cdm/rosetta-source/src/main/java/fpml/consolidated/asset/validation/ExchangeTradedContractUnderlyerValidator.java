package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.ExchangeTradedContractUnderlyer;
import fpml.consolidated.shared.FloatingRateIndex;
import fpml.consolidated.shared.Period;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ExchangeTradedContractUnderlyerValidator implements Validator<ExchangeTradedContractUnderlyer> {

	private List<ComparisonResult> getComparisonResults(ExchangeTradedContractUnderlyer o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("floatingRateIndex", (FloatingRateIndex) o.getFloatingRateIndex() != null ? 1 : 0, 0, 1), 
				checkCardinality("indexTenor", (Period) o.getIndexTenor() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ExchangeTradedContractUnderlyer o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ExchangeTradedContractUnderlyer", ValidationResult.ValidationType.CARDINALITY, "ExchangeTradedContractUnderlyer", path, "", res.getError());
				}
				return success("ExchangeTradedContractUnderlyer", ValidationResult.ValidationType.CARDINALITY, "ExchangeTradedContractUnderlyer", path, "");
			})
			.collect(toList());
	}

}
