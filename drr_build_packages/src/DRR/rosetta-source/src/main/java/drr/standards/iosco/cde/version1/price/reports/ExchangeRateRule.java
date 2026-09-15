package drr.standards.iosco.cde.version1.price.reports;

import cdm.base.math.ArithmeticOperationEnum;
import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.PriceTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.TransactionReportInstructionBase;
import drr.base.trade.price.functions.Contract_Price;
import drr.standards.iosco.cde.version1.price.functions.StrikePrice;
import drr.standards.iso.functions.FormatToBaseOne18Rate;
import java.math.BigDecimal;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExchangeRateRule.ExchangeRateRuleDefault.class)
public abstract class ExchangeRateRule implements ReportFunction<TransactionReportInstructionBase, BigDecimal> {
	
	// RosettaFunction dependencies
	//
	@Inject protected Contract_Price contract_Price;
	@Inject protected FormatToBaseOne18Rate formatToBaseOne18Rate;
	@Inject protected StrikePrice strikePrice;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public BigDecimal evaluate(TransactionReportInstructionBase input) {
		BigDecimal output = doEvaluate(input);
		
		return output;
	}

	protected abstract BigDecimal doEvaluate(TransactionReportInstructionBase input);

	public static class ExchangeRateRuleDefault extends ExchangeRateRule {
		@Override
		protected BigDecimal doEvaluate(TransactionReportInstructionBase input) {
			BigDecimal output = null;
			return assignOutput(output, input);
		}
		
		protected BigDecimal assignOutput(BigDecimal output, TransactionReportInstructionBase input) {
			final MapperC<PriceSchedule> thenArg0 = MapperC.<PriceSchedule>of(MapperC.<PriceSchedule>of(contract_Price.evaluate(input)), MapperS.of(strikePrice.evaluate(input)))
				.filterItemNullSafe(item -> areEqual(item.<PriceTypeEnum>map("getPriceType", priceSchedule -> priceSchedule.getPriceType()), MapperS.of(PriceTypeEnum.EXCHANGE_RATE), CardinalityOperator.All).andNullSafe(notExists(item.<ArithmeticOperationEnum>map("getArithmeticOperator", priceSchedule -> priceSchedule.getArithmeticOperator()))).get());
			final MapperS<PriceSchedule> thenArg1 = thenArg0
				.last();
			final MapperS<BigDecimal> thenArg2 = thenArg1
				.mapSingleToItem(item -> item.<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue()));
			output = MapperS.of(formatToBaseOne18Rate.evaluate(thenArg2.get())).get();
			
			return output;
		}
	}
}
