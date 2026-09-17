package fpml.consolidated.asset.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.ActualPrice;
import fpml.consolidated.asset.Commission;
import fpml.consolidated.asset.FxConversion;
import fpml.consolidated.asset.Price;
import fpml.consolidated.asset.QuotationCharacteristics;
import fpml.consolidated.shared.AmountReference;
import fpml.consolidated.shared.DeterminationMethod;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PriceValidator implements Validator<Price> {

	private List<ComparisonResult> getComparisonResults(Price o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commission", (Commission) o.getCommission() != null ? 1 : 0, 0, 1), 
				checkCardinality("determinationMethod", (DeterminationMethod) o.getDeterminationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("grossPrice", (ActualPrice) o.getGrossPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("netPrice", (ActualPrice) o.getNetPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("accruedInterestPrice", (BigDecimal) o.getAccruedInterestPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxConversion", (FxConversion) o.getFxConversion() != null ? 1 : 0, 0, 1), 
				checkCardinality("amountRelativeTo", (AmountReference) o.getAmountRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("cleanNetPrice", (BigDecimal) o.getCleanNetPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotationCharacteristics", (QuotationCharacteristics) o.getQuotationCharacteristics() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, Price o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("Price", ValidationResult.ValidationType.CARDINALITY, "Price", path, "", res.getError());
				}
				return success("Price", ValidationResult.ValidationType.CARDINALITY, "Price", path, "");
			})
			.collect(toList());
	}

}
