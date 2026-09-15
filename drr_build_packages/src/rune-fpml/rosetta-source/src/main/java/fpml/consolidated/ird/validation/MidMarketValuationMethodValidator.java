package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.CsaTypeEnum;
import fpml.consolidated.ird.MidMarketValuationMethod;
import fpml.consolidated.shared.BenchmarkRate;
import fpml.consolidated.shared.CashSettlementReferenceBanks;
import fpml.consolidated.shared.Currency;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class MidMarketValuationMethodValidator implements Validator<MidMarketValuationMethod> {

	private List<ComparisonResult> getComparisonResults(MidMarketValuationMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashSettlementCurrency", (List<? extends Currency>) o.getCashSettlementCurrency() == null ? 0 : o.getCashSettlementCurrency().size(), 0, 2), 
				checkCardinality("applicableCsa", (CsaTypeEnum) o.getApplicableCsa() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlementReferenceBanks", (CashSettlementReferenceBanks) o.getCashSettlementReferenceBanks() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashCollateralCurrency", (Currency) o.getCashCollateralCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashCollateralInterestRate", (BenchmarkRate) o.getCashCollateralInterestRate() != null ? 1 : 0, 0, 1), 
				checkCardinality("agreedDiscountRate", (BenchmarkRate) o.getAgreedDiscountRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, MidMarketValuationMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("MidMarketValuationMethod", ValidationResult.ValidationType.CARDINALITY, "MidMarketValuationMethod", path, "", res.getError());
				}
				return success("MidMarketValuationMethod", ValidationResult.ValidationType.CARDINALITY, "MidMarketValuationMethod", path, "");
			})
			.collect(toList());
	}

}
