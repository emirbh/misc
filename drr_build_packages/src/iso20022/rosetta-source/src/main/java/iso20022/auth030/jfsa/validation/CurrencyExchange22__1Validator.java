package iso20022.auth030.jfsa.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import iso20022.auth030.jfsa.CurrencyExchange22__1;
import iso20022.auth030.jfsa.ExchangeRateBasis1Choice__1;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CurrencyExchange22__1Validator implements Validator<CurrencyExchange22__1> {

	private List<ComparisonResult> getComparisonResults(CurrencyExchange22__1 o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("xchgRate", (BigDecimal) o.getXchgRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("xchgRateBsis", (ExchangeRateBasis1Choice__1) o.getXchgRateBsis() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CurrencyExchange22__1 o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CurrencyExchange22__1", ValidationResult.ValidationType.CARDINALITY, "CurrencyExchange22__1", path, "", res.getError());
				}
				return success("CurrencyExchange22__1", ValidationResult.ValidationType.CARDINALITY, "CurrencyExchange22__1", path, "");
			})
			.collect(toList());
	}

}
