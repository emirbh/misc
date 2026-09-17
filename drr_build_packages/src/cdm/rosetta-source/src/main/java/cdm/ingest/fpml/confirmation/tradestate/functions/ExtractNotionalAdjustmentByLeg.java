package cdm.ingest.fpml.confirmation.tradestate.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.eq.shared.ReturnLeg;
import fpml.consolidated.eq.shared.ReturnSwap;
import fpml.consolidated.eq.shared.ReturnSwapBase;
import fpml.consolidated.fpmlenum.NotionalAdjustmentEnum;
import fpml.consolidated.fpmlreturn.swaps.EquitySwapTransactionSupplement;
import fpml.consolidated.shared.DirectionalLeg;
import fpml.consolidated.shared.Product;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractNotionalAdjustmentByLeg.ExtractNotionalAdjustmentByLegDefault.class)
public abstract class ExtractNotionalAdjustmentByLeg implements RosettaFunction {

	/**
	* @param fpmlTrade 
	* @return adjustment 
	*/
	public String evaluate(Trade fpmlTrade) {
		String adjustment = doEvaluate(fpmlTrade);
		
		return adjustment;
	}

	protected abstract String doEvaluate(Trade fpmlTrade);

	protected abstract MapperS<? extends ReturnSwapBase> fpmlProduct(Trade fpmlTrade);

	public static class ExtractNotionalAdjustmentByLegDefault extends ExtractNotionalAdjustmentByLeg {
		@Override
		protected String doEvaluate(Trade fpmlTrade) {
			String adjustment = null;
			return assignOutput(adjustment, fpmlTrade);
		}
		
		protected String assignOutput(String adjustment, Trade fpmlTrade) {
			final MapperC<String> thenArg = fpmlProduct(fpmlTrade).<DirectionalLeg>mapC("getReturnSwapLeg", returnSwapBase -> returnSwapBase.getReturnSwapLeg())
				.mapItem(item -> {
					final DirectionalLeg switchArgument = item.get();
					if (switchArgument == null) {
						return MapperS.<String>ofNull();
					}
					if (switchArgument instanceof ReturnLeg) {
						final ReturnLeg returnLeg = (ReturnLeg) switchArgument;
						return MapperS.of(returnLeg).<NotionalAdjustmentEnum>map("getNotionalAdjustments", _returnLeg -> _returnLeg.getNotionalAdjustments()).map("to-string", NotionalAdjustmentEnum::toDisplayString);
					}
					return MapperS.<String>ofNull();
				});
			adjustment = MapperS.of(distinct(thenArg).get()).get();
			
			return adjustment;
		}
		
		@Override
		protected MapperS<? extends ReturnSwapBase> fpmlProduct(Trade fpmlTrade) {
			final Product switchArgument = MapperS.of(fpmlTrade).<Product>map("getProduct", trade -> trade.getProduct()).get();
			if (switchArgument == null) {
				return MapperS.<ReturnSwapBase>ofNull();
			}
			if (switchArgument instanceof EquitySwapTransactionSupplement) {
				final EquitySwapTransactionSupplement equitySwapTransactionSupplement = (EquitySwapTransactionSupplement) switchArgument;
				return MapperS.of(equitySwapTransactionSupplement);
			}
			if (switchArgument instanceof ReturnSwap) {
				final ReturnSwap returnSwap = (ReturnSwap) switchArgument;
				return MapperS.of(returnSwap);
			}
			return MapperS.<ReturnSwapBase>ofNull();
		}
	}
}
