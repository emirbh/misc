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


@ImplementedBy(GetSttlmCcyScndLeg.GetSttlmCcyScndLegDefault.class)
public abstract class GetSttlmCcyScndLeg implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return sttlmCcyScndLeg 
	*/
	public CurrencyExchange23__1 evaluate(JFSATransactionReport drrReport) {
		CurrencyExchange23__1.CurrencyExchange23__1Builder sttlmCcyScndLegBuilder = doEvaluate(drrReport);
		
		final CurrencyExchange23__1 sttlmCcyScndLeg;
		if (sttlmCcyScndLegBuilder == null) {
			sttlmCcyScndLeg = null;
		} else {
			sttlmCcyScndLeg = sttlmCcyScndLegBuilder.build();
			objectValidator.validate(CurrencyExchange23__1.class, sttlmCcyScndLeg);
		}
		
		return sttlmCcyScndLeg;
	}

	protected abstract CurrencyExchange23__1.CurrencyExchange23__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetSttlmCcyScndLegDefault extends GetSttlmCcyScndLeg {
		@Override
		protected CurrencyExchange23__1.CurrencyExchange23__1Builder doEvaluate(JFSATransactionReport drrReport) {
			CurrencyExchange23__1.CurrencyExchange23__1Builder sttlmCcyScndLeg = CurrencyExchange23__1.builder();
			return assignOutput(sttlmCcyScndLeg, drrReport);
		}
		
		protected CurrencyExchange23__1.CurrencyExchange23__1Builder assignOutput(CurrencyExchange23__1.CurrencyExchange23__1Builder sttlmCcyScndLeg, JFSATransactionReport drrReport) {
			sttlmCcyScndLeg = toBuilder(CurrencyExchange23__1.builder()
				.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg2", jFSATransactionReport -> jFSATransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
				.setFxgDt(MapperS.of(drrReport).<CommonLeg>map("getLeg2", jFSATransactionReport -> jFSATransactionReport.getLeg2()).<ZonedDateTime>map("getFixingDate", commonLeg -> commonLeg.getFixingDate()).get())
				.build());
			
			return Optional.ofNullable(sttlmCcyScndLeg)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
