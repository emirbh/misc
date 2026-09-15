package drr.regulation.esma.emir.refit.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.functions.ExtractPartyResponsibleForReportingIdentifier;
import drr.regulation.common.functions.IsRegulatedMarketOrThirdCountryEquivalentMarket;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EntityResponsibleForReportingRule.EntityResponsibleForReportingRuleDefault.class)
public abstract class EntityResponsibleForReportingRule implements ReportFunction<ValuationReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartyResponsibleForReportingIdentifier extractPartyResponsibleForReportingIdentifier;
	@Inject protected IsRegulatedMarketOrThirdCountryEquivalentMarket isRegulatedMarketOrThirdCountryEquivalentMarket;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(ValuationReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(ValuationReportInstruction input);

	public static class EntityResponsibleForReportingRuleDefault extends EntityResponsibleForReportingRule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(isRegulatedMarketOrThirdCountryEquivalentMarket.evaluate(item.<ReportableInformation>map("getReportableInformation", valuationReportInstruction -> valuationReportInstruction.getReportableInformation()).get(), RegimeNameEnum.EMIR)), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(extractPartyResponsibleForReportingIdentifier.evaluate(item.<ReportingSide>map("getReportingSide", valuationReportInstruction -> valuationReportInstruction.getReportingSide()).get()));
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
