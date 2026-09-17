package fpml.consolidated.loan.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.FxTerms;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.QuotedCurrencyPair;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxTermsValidator implements Validator<FxTerms> {

	private List<ComparisonResult> getComparisonResults(FxTerms o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("quotedCurrencyPair", (QuotedCurrencyPair) o.getQuotedCurrencyPair() != null ? 1 : 0, 1, 1), 
				checkCardinality("fixingDate", (ZonedDateTime) o.getFixingDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxSpotRateSource", (FxSpotRateSource) o.getFxSpotRateSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("rate", (BigDecimal) o.getRate() != null ? 1 : 0, 1, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxTerms o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxTerms", ValidationResult.ValidationType.CARDINALITY, "FxTerms", path, "", res.getError());
				}
				return success("FxTerms", ValidationResult.ValidationType.CARDINALITY, "FxTerms", path, "");
			})
			.collect(toList());
	}

}
