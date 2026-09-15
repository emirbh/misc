package drr.regulation.esma.emir.refit.trade.reports;

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

@ImplementedBy(IntragroupRule.IntragroupRuleDefault.class)
public abstract class IntragroupRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.regulation.common.trade.party.reports.IntragroupRule intragroupRule;
	@Inject protected IsRegulatedMarketOrThirdCountryEquivalentMarket isRegulatedMarketOrThirdCountryEquivalentMarket;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction input);

	public static class IntragroupRuleDefault extends IntragroupRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(isRegulatedMarketOrThirdCountryEquivalentMarket.evaluate(item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get(), RegimeNameEnum.EMIR)), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(intragroupRule.evaluate(item.get()));
					}
					return MapperS.<Boolean>ofNull();
				}).get();
			
			return output;
		}
	}
}
