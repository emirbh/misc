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


@ImplementedBy(GetPutAmt.GetPutAmtDefault.class)
public abstract class GetPutAmt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return putAmt 
	*/
	public ActiveOrHistoricCurrencyAnd5DecimalAmount evaluate(JFSATransactionReport drrReport) {
		ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder putAmtBuilder = doEvaluate(drrReport);
		
		final ActiveOrHistoricCurrencyAnd5DecimalAmount putAmt;
		if (putAmtBuilder == null) {
			putAmt = null;
		} else {
			putAmt = putAmtBuilder.build();
			objectValidator.validate(ActiveOrHistoricCurrencyAnd5DecimalAmount.class, putAmt);
		}
		
		return putAmt;
	}

	protected abstract ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder doEvaluate(JFSATransactionReport drrReport);

	public static class GetPutAmtDefault extends GetPutAmt {
		@Override
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder doEvaluate(JFSATransactionReport drrReport) {
			ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder putAmt = ActiveOrHistoricCurrencyAnd5DecimalAmount.builder();
			return assignOutput(putAmt, drrReport);
		}
		
		protected ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder assignOutput(ActiveOrHistoricCurrencyAnd5DecimalAmount.ActiveOrHistoricCurrencyAnd5DecimalAmountBuilder putAmt, JFSATransactionReport drrReport) {
			putAmt = toBuilder(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
				.setValue(MapperS.of(drrReport).<BigDecimal>map("getPutAmount", jFSATransactionReport -> jFSATransactionReport.getPutAmount()).get())
				.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPutCurrency", jFSATransactionReport -> jFSATransactionReport.getPutCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.build());
			
			return Optional.ofNullable(putAmt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
