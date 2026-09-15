package drr.base.trade.price.functions;

import cdm.event.common.Trade;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(SingleTradeLot.SingleTradeLotDefault.class)
public abstract class SingleTradeLot implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param trade 
	* @return singleTradeLot 
	*/
	public TradeLot evaluate(Trade trade) {
		TradeLot.TradeLotBuilder singleTradeLotBuilder = doEvaluate(trade);
		
		final TradeLot singleTradeLot;
		if (singleTradeLotBuilder == null) {
			singleTradeLot = null;
		} else {
			singleTradeLot = singleTradeLotBuilder.build();
			objectValidator.validate(TradeLot.class, singleTradeLot);
		}
		
		return singleTradeLot;
	}

	protected abstract TradeLot.TradeLotBuilder doEvaluate(Trade trade);

	public static class SingleTradeLotDefault extends SingleTradeLot {
		@Override
		protected TradeLot.TradeLotBuilder doEvaluate(Trade trade) {
			TradeLot.TradeLotBuilder singleTradeLot = TradeLot.builder();
			return assignOutput(singleTradeLot, trade);
		}
		
		protected TradeLot.TradeLotBuilder assignOutput(TradeLot.TradeLotBuilder singleTradeLot, Trade trade) {
			singleTradeLot = toBuilder(MapperS.of(trade).<TradeLot>mapC("getTradeLot", _trade -> _trade.getTradeLot()).get());
			
			return Optional.ofNullable(singleTradeLot)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
