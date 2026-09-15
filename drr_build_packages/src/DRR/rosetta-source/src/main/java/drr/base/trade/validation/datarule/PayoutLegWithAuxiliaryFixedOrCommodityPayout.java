package drr.base.trade.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import drr.base.trade.PayoutLeg;
import drr.base.trade.PayoutLegWithAuxiliary;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 7.7.0
 */
@RosettaDataRule("PayoutLegWithAuxiliaryFixedOrCommodityPayout")
@ImplementedBy(PayoutLegWithAuxiliaryFixedOrCommodityPayout.Default.class)
public interface PayoutLegWithAuxiliaryFixedOrCommodityPayout extends Validator<PayoutLegWithAuxiliary> {
	
	String NAME = "PayoutLegWithAuxiliaryFixedOrCommodityPayout";
	String DEFINITION = "auxiliaryLeg -> fixedPricePayout only exists or auxiliaryLeg -> commodityPayout only exists";
	
	class Default implements PayoutLegWithAuxiliaryFixedOrCommodityPayout {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PayoutLegWithAuxiliary payoutLegWithAuxiliary) {
			ComparisonResult result = executeDataRule(payoutLegWithAuxiliary);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PayoutLegWithAuxiliary", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PayoutLegWithAuxiliary", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PayoutLegWithAuxiliary payoutLegWithAuxiliary) {
			try {
				return onlyExists(MapperS.of(payoutLegWithAuxiliary).<PayoutLeg>map("getAuxiliaryLeg", _payoutLegWithAuxiliary -> _payoutLegWithAuxiliary.getAuxiliaryLeg()), Arrays.asList("creditDefaultPayout", "optionPayout", "settlementPayout", "performancePayout", "interestRatePayout", "cashflow", "fixedPricePayout", "commodityPayout"), Arrays.asList("fixedPricePayout")).orNullSafe(onlyExists(MapperS.of(payoutLegWithAuxiliary).<PayoutLeg>map("getAuxiliaryLeg", _payoutLegWithAuxiliary -> _payoutLegWithAuxiliary.getAuxiliaryLeg()), Arrays.asList("creditDefaultPayout", "optionPayout", "settlementPayout", "performancePayout", "interestRatePayout", "cashflow", "fixedPricePayout", "commodityPayout"), Arrays.asList("commodityPayout")));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PayoutLegWithAuxiliaryFixedOrCommodityPayout {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PayoutLegWithAuxiliary payoutLegWithAuxiliary) {
			return Collections.emptyList();
		}
	}
}
