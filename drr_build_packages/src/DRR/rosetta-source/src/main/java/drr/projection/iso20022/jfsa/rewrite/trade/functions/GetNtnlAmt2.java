package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.jfsa.AmountAndDirection106__2;
import iso20022.auth030.jfsa.NotionalAmount5__2;
import iso20022.auth030.jfsa.NotionalAmount6__2;
import iso20022.auth030.jfsa.NotionalAmountLegs5__2;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetNtnlAmt2.GetNtnlAmt2Default.class)
public abstract class GetNtnlAmt2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return ntnlAmt 
	*/
	public NotionalAmountLegs5__2 evaluate(JFSATransactionReport drrReport) {
		NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder ntnlAmtBuilder = doEvaluate(drrReport);
		
		final NotionalAmountLegs5__2 ntnlAmt;
		if (ntnlAmtBuilder == null) {
			ntnlAmt = null;
		} else {
			ntnlAmt = ntnlAmtBuilder.build();
			objectValidator.validate(NotionalAmountLegs5__2.class, ntnlAmt);
		}
		
		return ntnlAmt;
	}

	protected abstract NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetNtnlAmt2Default extends GetNtnlAmt2 {
		@Override
		protected NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder doEvaluate(JFSATransactionReport drrReport) {
			NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder ntnlAmt = NotionalAmountLegs5__2.builder();
			return assignOutput(ntnlAmt, drrReport);
		}
		
		protected NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder assignOutput(NotionalAmountLegs5__2.NotionalAmountLegs5__2Builder ntnlAmt, JFSATransactionReport drrReport) {
			ntnlAmt = toBuilder(NotionalAmountLegs5__2.builder()
				.setFrstLeg(NotionalAmount5__2.builder()
					.setAmt(AmountAndDirection106__2.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
							.setValue(MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()).get())
							.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
							.build())
						.build())
					.build())
				.setScndLeg(NotionalAmount6__2.builder()
					.setAmt(AmountAndDirection106__2.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
							.setValue(MapperS.of(drrReport).<CommonLeg>map("getLeg2", jFSATransactionReport -> jFSATransactionReport.getLeg2()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()).get())
							.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg2", jFSATransactionReport -> jFSATransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
							.build())
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(ntnlAmt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
