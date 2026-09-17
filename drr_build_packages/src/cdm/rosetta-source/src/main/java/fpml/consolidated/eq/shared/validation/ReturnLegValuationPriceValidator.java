package fpml.consolidated.eq.shared.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.asset.ActualPrice;
import fpml.consolidated.asset.Commission;
import fpml.consolidated.asset.FxConversion;
import fpml.consolidated.asset.QuotationCharacteristics;
import fpml.consolidated.eq.shared.EquityValuation;
import fpml.consolidated.eq.shared.ReturnLegValuationPrice;
import fpml.consolidated.shared.AmountReference;
import fpml.consolidated.shared.DeterminationMethod;
import java.math.BigDecimal;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class ReturnLegValuationPriceValidator implements Validator<ReturnLegValuationPrice> {

	private List<ComparisonResult> getComparisonResults(ReturnLegValuationPrice o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("commission", (Commission) o.getCommission() != null ? 1 : 0, 0, 1), 
				checkCardinality("determinationMethod", (DeterminationMethod) o.getDeterminationMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("grossPrice", (ActualPrice) o.getGrossPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("netPrice", (ActualPrice) o.getNetPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("accruedInterestPrice", (BigDecimal) o.getAccruedInterestPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("fxConversion", (FxConversion) o.getFxConversion() != null ? 1 : 0, 0, 1), 
				checkCardinality("amountRelativeTo", (AmountReference) o.getAmountRelativeTo() != null ? 1 : 0, 0, 1), 
				checkCardinality("cleanNetPrice", (BigDecimal) o.getCleanNetPrice() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotationCharacteristics", (QuotationCharacteristics) o.getQuotationCharacteristics() != null ? 1 : 0, 0, 1), 
				checkCardinality("valuationRules", (EquityValuation) o.getValuationRules() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReturnLegValuationPrice o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("ReturnLegValuationPrice", ValidationResult.ValidationType.CARDINALITY, "ReturnLegValuationPrice", path, "", res.getError());
				}
				return success("ReturnLegValuationPrice", ValidationResult.ValidationType.CARDINALITY, "ReturnLegValuationPrice", path, "");
			})
			.collect(toList());
	}

}
