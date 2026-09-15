package drr.base.trade.validation;

import cdm.product.asset.CommodityPayout;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.Cashflow;
import cdm.product.template.FixedPricePayout;
import cdm.product.template.OptionPayout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.SettlementPayout;
import com.google.common.collect.Lists;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.PayoutLeg;
import java.util.List;

import static com.google.common.base.Strings.isNullOrEmpty;
import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.checkCardinality;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.stream.Collectors.toList;

public class PayoutLegValidator implements Validator<PayoutLeg> {

	private List<ComparisonResult> getComparisonResults(PayoutLeg o) {
		return Lists.<ComparisonResult>newArrayList(
				checkCardinality("creditDefaultPayout", (CreditDefaultPayout) o.getCreditDefaultPayout() != null ? 1 : 0, 0, 1), 
				checkCardinality("optionPayout", (OptionPayout) o.getOptionPayout() != null ? 1 : 0, 0, 1), 
				checkCardinality("settlementPayout", (SettlementPayout) o.getSettlementPayout() != null ? 1 : 0, 0, 1), 
				checkCardinality("performancePayout", (PerformancePayout) o.getPerformancePayout() != null ? 1 : 0, 0, 1), 
				checkCardinality("interestRatePayout", (InterestRatePayout) o.getInterestRatePayout() != null ? 1 : 0, 0, 1), 
				checkCardinality("cashflow", (Cashflow) o.getCashflow() != null ? 1 : 0, 0, 1), 
				checkCardinality("fixedPricePayout", (FixedPricePayout) o.getFixedPricePayout() != null ? 1 : 0, 0, 1), 
				checkCardinality("commodityPayout", (CommodityPayout) o.getCommodityPayout() != null ? 1 : 0, 0, 1)
			);
	}

	@Override
	public List<ValidationResult<?>> getValidationResults(RosettaPath path, PayoutLeg o) {
		return getComparisonResults(o)
			.stream()
			.map(res -> {
				if (!isNullOrEmpty(res.getError())) {
					return failure("PayoutLeg", ValidationResult.ValidationType.CARDINALITY, "PayoutLeg", path, "", res.getError());
				}
				return success("PayoutLeg", ValidationResult.ValidationType.CARDINALITY, "PayoutLeg", path, "");
			})
			.collect(toList());
	}

}
