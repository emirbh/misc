package drr.standards.iosco.cde.version3.price.reports;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.observable.asset.PriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.price.functions.Contract_Price;
import drr.base.trade.price.functions.CurrencyPairOrCurrencyFromPrice;
import drr.standards.iosco.cde.version3.price.functions.StrikePrice;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExchangeRateBasisRule.ExchangeRateBasisRuleDefault.class)
public abstract class ExchangeRateBasisRule implements ReportFunction<TransactionReportInstructionBase, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Contract_Price contract_Price;
	@Inject protected CurrencyPairOrCurrencyFromPrice currencyPairOrCurrencyFromPrice;
	@Inject protected StrikePrice strikePrice;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstructionBase input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstructionBase input);

	public static class ExchangeRateBasisRuleDefault extends ExchangeRateBasisRule {
		@Override
		protected String doEvaluate(TransactionReportInstructionBase input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstructionBase input) {
			final MapperC<PriceSchedule> thenArg0 = MapperC.<PriceSchedule>of(MapperC.<PriceSchedule>of(contract_Price.evaluate(input)), MapperS.of(strikePrice.evaluate(input)))
				.filterItemNullSafe(item -> notExists(item.<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator())).get());
			final MapperS<PriceSchedule> thenArg1 = thenArg0
				.last();
			output = MapperS.of(currencyPairOrCurrencyFromPrice.evaluate(thenArg1.get(), false)).get();
			
			return output;
		}
	}
}
