package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.eq.shared.ReturnSwapAmount;
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

public class ReturnSwapAmountValidator implements Validator<ReturnSwapAmount> {

	private List<ComparisonResult> getComparisonResults(ReturnSwapAmount o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("currency", (IdentifiedCurrency) o.getCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("determinationMethod", (DeterminationMethod) o.getDeterminationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("currencyReference", (IdentifiedCurrencyReference) o.getCurrencyReference() != null ? 1 : 0, 0, 1), 
				checkCardinality("referenceAmount", (ReferenceAmount) o.getReferenceAmount() != null ? 1 : 0, 0, 1), 
				checkCardinality("formula", (Formula) o.getFormula() != null ? 1 : 0, 0, 1), 
				checkCardinality("encodedDescription", (String) o.getEncodedDescription() != null ? 1 : 0, 0, 1), 
				checkCardinality("calculationDates", (AdjustableRelativeOrPeriodicDates) o.getCalculationDates() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlement", (Boolean) o.getCashSettlement() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionsExchangeDividends", (Boolean) o.getOptionsExchangeDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("additionalDividends", (Boolean) o.getAdditionalDividends() != null ? 1 : 0, 0, 1), 
				checkCardinality("allDividends", (Boolean) o.getAllDividends() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnSwapAmount o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnSwapAmount", ValidationResult.ValidationType.CARDINALITY, "ReturnSwapAmount", path, "", res.getError());
				}
				return success("ReturnSwapAmount", ValidationResult.ValidationType.CARDINALITY, "ReturnSwapAmount", path, "");
			})
			.collect(toList());
	}

}
