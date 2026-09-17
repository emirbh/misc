package fpml.consolidated.ird.validation;

import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.ird.CashPriceMethod;
import fpml.consolidated.ird.CashSettlement;
import fpml.consolidated.ird.CashSettlementPaymentDate;
import fpml.consolidated.ird.CollateralizedCashPriceMethod;
import fpml.consolidated.ird.CrossCurrencyMethod;
import fpml.consolidated.ird.MidMarketValuation;
import fpml.consolidated.ird.ReplacementValue;
import fpml.consolidated.ird.YieldCurveMethod;
import fpml.consolidated.shared.BusinessCenterTime;
import fpml.consolidated.shared.RelativeDateOffset;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class CashSettlementValidator implements Validator<CashSettlement> {

	private List<ComparisonResult> getComparisonResults(CashSettlement o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("id", (String) o.getId() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlementValuationTime", (BusinessCenterTime) o.getCashSettlementValuationTime() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlementValuationDate", (RelativeDateOffset) o.getCashSettlementValuationDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashSettlementPaymentDate", (CashSettlementPaymentDate) o.getCashSettlementPaymentDate() != null ? 1 : 0, 0, 1), 
				checkCardinality("midMarketValuation", (MidMarketValuation) o.getMidMarketValuation() != null ? 1 : 0, 0, 1), 
				checkCardinality("replacementValue", (ReplacementValue) o.getReplacementValue() != null ? 1 : 0, 0, 1), 
				checkCardinality("parYieldCurveUnadjustedMethod", (YieldCurveMethod) o.getParYieldCurveUnadjustedMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("collateralizedCashPriceMethod", (CollateralizedCashPriceMethod) o.getCollateralizedCashPriceMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashPriceMethod", (CashPriceMethod) o.getCashPriceMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashPriceAlternateMethod", (CashPriceMethod) o.getCashPriceAlternateMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("parYieldCurveAdjustedMethod", (YieldCurveMethod) o.getParYieldCurveAdjustedMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("zeroCouponYieldAdjustedMethod", (YieldCurveMethod) o.getZeroCouponYieldAdjustedMethod() != null ? 1 : 0, 0, 1), 
				checkCardinality("crossCurrencyMethod", (CrossCurrencyMethod) o.getCrossCurrencyMethod() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, CashSettlement o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("CashSettlement", ValidationResult.ValidationType.CARDINALITY, "CashSettlement", path, "", res.getError());
				}
				return success("CashSettlement", ValidationResult.ValidationType.CARDINALITY, "CashSettlement", path, "");
			})
			.collect(toList());
	}

}
