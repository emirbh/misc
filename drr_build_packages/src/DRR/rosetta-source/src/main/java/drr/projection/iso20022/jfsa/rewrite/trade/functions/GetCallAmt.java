package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetCallAmt.GetCallAmtDefault.class)
public abstract class GetCallAmt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return callAmt 
	*/
	public ActiveOrHistoricCurrencyAnd5DecimalAmount evaluate(JFSATransactionReport drrReport) {
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder callAmtBuilder = doEvaluate(drrReport);
		
		final ActiveOrHistoricCurrencyAnd5DecimalAmount callAmt;
		if (callAmtBuilder == null) {
			callAmt = null;
		} else {
			callAmt = callAmtBuilder.build();
			objectValidator.validate(ActiveOrHistoricCurrencyAnd5DecimalAmount.class, callAmt);
		}
		
		return callAmt;
	}

	protected abstract ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder doEvaluate(JFSATransactionReport drrReport);

	public static class GetCallAmtDefault extends GetCallAmt {
		@Override
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder doEvaluate(JFSATransactionReport drrReport) {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder callAmt = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			return assignOutput(callAmt, drrReport);
		}
		
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder assignOutput(ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder callAmt, JFSATransactionReport drrReport) {
			callAmt = toBuilder(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
				.setValue(MapperS.of(drrReport).<BigDecimal>map("getCallAmount", jFSATransactionReport -> jFSATransactionReport.getCallAmount()).get())
				.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getCallCurrency", jFSATransactionReport -> jFSATransactionReport.getCallCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.build());
			
			return Optional.ofNullable(callAmt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
