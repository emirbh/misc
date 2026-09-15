package drr.regulation.fca.ukemir.refit.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportingSide;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.functions.ExtractPartyResponsibleForReportingIdentifier;
import drr.regulation.common.functions.IsRegulatedMarketOrThirdCountryEquivalentMarket;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(EntityResponsibleForReportingRule.EntityResponsibleForReportingRuleDefault.class)
public abstract class EntityResponsibleForReportingRule implements ReportFunction<CollateralReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ExtractPartyResponsibleForReportingIdentifier extractPartyResponsibleForReportingIdentifier;
	@Inject protected IsRegulatedMarketOrThirdCountryEquivalentMarket isRegulatedMarketOrThirdCountryEquivalentMarket;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(CollateralReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(CollateralReportInstruction input);

	public static class EntityResponsibleForReportingRuleDefault extends EntityResponsibleForReportingRule {
		@Override
		protected String doEvaluate(CollateralReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(isRegulatedMarketOrThirdCountryEquivalentMarket.evaluate(item.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).get(), RegimeNameEnum.UKEMIR)), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(extractPartyResponsibleForReportingIdentifier.evaluate(item.<ReportingSide>map("getReportingSide", collateralReportInstruction -> collateralReportInstruction.getReportingSide()).get()));
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
