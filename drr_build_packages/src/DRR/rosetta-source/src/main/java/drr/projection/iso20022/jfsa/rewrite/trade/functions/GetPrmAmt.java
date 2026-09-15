package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetPrmAmt.GetPrmAmtDefault.class)
public abstract class GetPrmAmt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return prmAmt 
	*/
	public ActiveOrHistoricCurrencyAnd5DecimalAmount evaluate(JFSATransactionReport drrReport) {
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder prmAmtBuilder = doEvaluate(drrReport);
		
		final ActiveOrHistoricCurrencyAnd5DecimalAmount prmAmt;
		if (prmAmtBuilder == null) {
			prmAmt = null;
		} else {
			prmAmt = prmAmtBuilder.build();
			objectValidator.validate(ActiveOrHistoricCurrencyAnd5DecimalAmount.class, prmAmt);
		}
		
		return prmAmt;
	}

	protected abstract ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder doEvaluate(JFSATransactionReport drrReport);

	public static class GetPrmAmtDefault extends GetPrmAmt {
		@Override
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder doEvaluate(JFSATransactionReport drrReport) {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder prmAmt = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			return assignOutput(prmAmt, drrReport);
		}
		
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder assignOutput(ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder prmAmt, JFSATransactionReport drrReport) {
			final String ifThenElseResult;
			if (exists(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", jFSATransactionReport -> jFSATransactionReport.getOptionPremiumCurrency())).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", jFSATransactionReport -> jFSATransactionReport.getOptionPremiumCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get();
			} else if (areEqual(MapperS.of(drrReport).<BigDecimal>map("getOptionPremiumAmount", jFSATransactionReport -> jFSATransactionReport.getOptionPremiumAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get();
			} else {
				ifThenElseResult = null;
			}
			prmAmt = toBuilder(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
				.setValue(MapperS.of(drrReport).<BigDecimal>map("getOptionPremiumAmount", jFSATransactionReport -> jFSATransactionReport.getOptionPremiumAmount()).get())
				.setCcy(ifThenElseResult)
				.build());
			
			return Optional.ofNullable(prmAmt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
