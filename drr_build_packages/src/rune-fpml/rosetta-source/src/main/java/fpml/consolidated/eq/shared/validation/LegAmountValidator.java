package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.LegAmount;
import fpml.consolidated.shared.AdjustableRelativeOrPeriodicDates;
import fpml.consolidated.shared.DeterminationMethod;
import fpml.consolidated.shared.Formula;
import fpml.consolidated.shared.IdentifiedCurrency;
import fpml.consolidated.shared.IdentifiedCurrencyReference;
import fpml.consolidated.shared.ReferenceAmount;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class LegAmountValidator implements Validator<LegAmount> {

	private List<ComparisonResult> getComparisonResults(LegAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("currency", (IdentifiedCurrency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("determinationMethod", (DeterminationMethod) o.getDeterminationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("currencyReference", (IdentifiedCurrencyReference) o.getCurrencyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("referenceAmount", (ReferenceAmount) o.getReferenceAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("formula", (Formula) o.getFormula() != null ? 1 : 0, 0, 1), 
				checkCardinality("encodedDescription", (String) o.getEncodedDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationDates", (AdjustableRelativeOrPeriodicDates) o.getCalculationDates() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, LegAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("LegAmount", ValidationResult.ValidationType.CARDINALITY, "LegAmount", path, "", res.getError());
				}
				return success("LegAmount", ValidationResult.ValidationType.CARDINALITY, "LegAmount", path, "");
			})
			.collect(toList());
	}

}
