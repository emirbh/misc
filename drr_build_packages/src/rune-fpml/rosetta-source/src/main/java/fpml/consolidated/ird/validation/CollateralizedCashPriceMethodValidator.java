package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.fpmlenum.QuotationRateTypeEnum;
import fpml.consolidated.ird.CollateralizedCashPriceMethod;
import fpml.consolidated.shared.BenchmarkRate;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.MutuallyAgreedClearinghouse;
import fpml.consolidated.shared.SettlementRateSource;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CollateralizedCashPriceMethodValidator implements Validator<CollateralizedCashPriceMethod> {

	private List<ComparisonResult> getComparisonResults(CollateralizedCashPriceMethod o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("cashSettlementCurrency", (Currency) o.getCashSettlementCurrency() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementRateSource", (SettlementRateSource) o.getSettlementRateSource() != null ? 1 : 0, 0, 1), 
				checkCardinality("quotationRateType", (QuotationRateTypeEnum) o.getQuotationRateType() != null ? 1 : 0, 0, 1), 
				checkCardinality("mutuallyAgreedClearinghouse", (MutuallyAgreedClearinghouse) o.getMutuallyAgreedClearinghouse() != null ? 1 : 0, 0, 1), 
				checkCardinality("agreedDiscountRate", (BenchmarkRate) o.getAgreedDiscountRate() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CollateralizedCashPriceMethod o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CollateralizedCashPriceMethod", ValidationResult.ValidationType.CARDINALITY, "CollateralizedCashPriceMethod", path, "", res.getError());
				}
				return success("CollateralizedCashPriceMethod", ValidationResult.ValidationType.CARDINALITY, "CollateralizedCashPriceMethod", path, "");
			})
			.collect(toList());
	}

}
