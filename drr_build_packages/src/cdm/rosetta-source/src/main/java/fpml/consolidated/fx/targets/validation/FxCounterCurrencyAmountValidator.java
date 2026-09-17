package fpml.consolidated.fx.targets.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fx.targets.FxCounterCurrencyAmount;
import fpml.consolidated.fx.targets.FxStrikeReference;
import fpml.consolidated.shared.Currency;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class FxCounterCurrencyAmountValidator implements Validator<FxCounterCurrencyAmount> {

	private List<ComparisonResult> getComparisonResults(FxCounterCurrencyAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("initialValue", (BigDecimal) o.getInitialValue() != null ? 1 : 0, 1, 1), 
				checkCardinality("currency", (Currency) o.getCurrency() != null ? 1 : 0, 1, 1), 
				checkCardinality("strikeReference", (FxStrikeReference) o.getStrikeReference() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, FxCounterCurrencyAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("FxCounterCurrencyAmount", ValidationResult.ValidationType.CARDINALITY, "FxCounterCurrencyAmount", path, "", res.getError());
				}
				return success("FxCounterCurrencyAmount", ValidationResult.ValidationType.CARDINALITY, "FxCounterCurrencyAmount", path, "");
			})
			.collect(toList());
	}

}
