package drr.regulation.fca.ukemir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.IsRegulatedMarketOrThirdCountryEquivalentMarket;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EntityResponsibleForReportingRule.EntityResponsibleForReportingRuleDefault.class)
public abstract class EntityResponsibleForReportingRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.party.reports.EntityResponsibleForReportingRule entityResponsibleForReportingRule;
	@Inject protected IsRegulatedMarketOrThirdCountryEquivalentMarket isRegulatedMarketOrThirdCountryEquivalentMarket;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class EntityResponsibleForReportingRuleDefault extends EntityResponsibleForReportingRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(isRegulatedMarketOrThirdCountryEquivalentMarket.evaluate(item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get(), RegimeNameEnum.UKEMIR)), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(entityResponsibleForReportingRule.evaluate(item.get()));
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
