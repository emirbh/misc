package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.CurrencyExchange23__1;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetSttlmCcy.GetSttlmCcyDefault.class)
public abstract class GetSttlmCcy implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return sttlmCcy 
	*/
	public CurrencyExchange23__1 evaluate(JFSATransactionReport drrReport) {
		CurrencyExchange23__1.CurrencyExchange23__1Builder sttlmCcyBuilder = doEvaluate(drrReport);
		
		final CurrencyExchange23__1 sttlmCcy;
		if (sttlmCcyBuilder == null) {
			sttlmCcy = null;
		} else {
			sttlmCcy = sttlmCcyBuilder.build();
			objectValidator.validate(CurrencyExchange23__1.class, sttlmCcy);
		}
		
		return sttlmCcy;
	}

	protected abstract CurrencyExchange23__1.CurrencyExchange23__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetSttlmCcyDefault extends GetSttlmCcy {
		@Override
		protected CurrencyExchange23__1.CurrencyExchange23__1Builder doEvaluate(JFSATransactionReport drrReport) {
			CurrencyExchange23__1.CurrencyExchange23__1Builder sttlmCcy = CurrencyExchange23__1.builder();
			return assignOutput(sttlmCcy, drrReport);
		}
		
		protected CurrencyExchange23__1.CurrencyExchange23__1Builder assignOutput(CurrencyExchange23__1.CurrencyExchange23__1Builder sttlmCcy, JFSATransactionReport drrReport) {
			sttlmCcy = toBuilder(CurrencyExchange23__1.builder()
				.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setFxgDt(MapperS.of(drrReport).<CommonLeg>map("getLeg1", jFSATransactionReport -> jFSATransactionReport.getLeg1()).<ZonedDateTime>map("getFixingDate", commonLeg -> commonLeg.getFixingDate()).get())
				.build());
			
			return Optional.ofNullable(sttlmCcy)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
