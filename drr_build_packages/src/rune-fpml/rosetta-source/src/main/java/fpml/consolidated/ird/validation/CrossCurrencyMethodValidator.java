package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.ird.CrossCurrencyMethod;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CrossCurrencyMethodValidator implements Validator<CrossCurrencyMethod> {

	private List<ComparisonResult> getComparisonResults(CrossCurrencyMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashSettlementReferenceBanks", (CashSettlementReferenceBanks) o.getCashSettlementReferenceBanks() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlementCurrency", (List<? extends Currency>) o.getCashSettlementCurrency() == null ? 0 : o.getCashSettlementCurrency().size(), 0, 2), 
				checkCardinality("quotationRateType", (QuotationRateTypeEnum) o.getQuotationRateType() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CrossCurrencyMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CrossCurrencyMethod", ValidationResult.ValidationType.CARDINALITY, "CrossCurrencyMethod", path, "", res.getError());
				}
				return success("CrossCurrencyMethod", ValidationResult.ValidationType.CARDINALITY, "CrossCurrencyMethod", path, "");
			})
			.collect(toList());
	}

}
