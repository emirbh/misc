package drr.regulation.common.trade.contract.reports;

import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iso.DeliveryTypeEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DeliveryTypeFromSettlementRule.DeliveryTypeFromSettlementRuleDefault.class)
public abstract class DeliveryTypeFromSettlementRule implements ReportFunction<SettlementTerms, DeliveryTypeEnum> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public DeliveryTypeEnum evaluate(SettlementTerms input) {
		DeliveryTypeEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract DeliveryTypeEnum doEvaluate(SettlementTerms input);

	public static class DeliveryTypeFromSettlementRuleDefault extends DeliveryTypeFromSettlementRule {
		@Override
		protected DeliveryTypeEnum doEvaluate(SettlementTerms input) {
			DeliveryTypeEnum output = null;
			return assignOutput(output, input);
		}
		
		protected DeliveryTypeEnum assignOutput(DeliveryTypeEnum output, SettlementTerms input) {
			if (areEqual(MapperS.of(input).<SettlementTypeEnum>map("getSettlementType", settlementTerms -> settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH), CardinalityOperator.All).orNullSafe(exists(MapperS.of(input).<CashSettlementTerms>mapC("getCashSettlementTerms", settlementTerms -> settlementTerms.getCashSettlementTerms()))).getOrDefault(false)) {
				output = DeliveryTypeEnum.CASH;
			} else if (areEqual(MapperS.of(input).<SettlementTypeEnum>map("getSettlementType", settlementTerms -> settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.PHYSICAL), CardinalityOperator.All).orNullSafe(exists(MapperS.of(input).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", settlementTerms -> settlementTerms.getPhysicalSettlementTerms()))).getOrDefault(false)) {
				output = DeliveryTypeEnum.PHYS;
			} else if (areEqual(MapperS.of(input).<SettlementTypeEnum>map("getSettlementType", settlementTerms -> settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH_OR_PHYSICAL), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(input).<SettlementTypeEnum>map("getSettlementType", settlementTerms -> settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.ELECTION), CardinalityOperator.All)).getOrDefault(false)) {
				output = DeliveryTypeEnum.OPTL;
			} else {
				output = null;
			}
			
			return output;
		}
	}
}
