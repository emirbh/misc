package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.string.functions.SubString;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.CommonAssetClass;
import iso20022.auth030.asic.CurrencyExchange22__1;
import iso20022.auth030.asic.ExchangeRateBasis1;
import iso20022.auth030.asic.ExchangeRateBasis1Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetCcy.GetCcyDefault.class)
public abstract class GetCcy implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected SubString subString;

	/**
	* @param drrReport 
	* @return ccy 
	*/
	public CurrencyExchange22__1 evaluate(ASICTransactionReport drrReport) {
		CurrencyExchange22__1.CurrencyExchange22__1Builder ccyBuilder = doEvaluate(drrReport);
		
		final CurrencyExchange22__1 ccy;
		if (ccyBuilder == null) {
			ccy = null;
		} else {
			ccy = ccyBuilder.build();
			objectValidator.validate(CurrencyExchange22__1.class, ccy);
		}
		
		return ccy;
	}

	protected abstract CurrencyExchange22__1.CurrencyExchange22__1Builder doEvaluate(ASICTransactionReport drrReport);

	public static class GetCcyDefault extends GetCcy {
		@Override
		protected CurrencyExchange22__1.CurrencyExchange22__1Builder doEvaluate(ASICTransactionReport drrReport) {
			CurrencyExchange22__1.CurrencyExchange22__1Builder ccy = CurrencyExchange22__1.builder();
			return assignOutput(ccy, drrReport);
		}
		
		protected CurrencyExchange22__1.CurrencyExchange22__1Builder assignOutput(CurrencyExchange22__1.CurrencyExchange22__1Builder ccy, ASICTransactionReport drrReport) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", aSICTransactionReport -> aSICTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.CURR), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = subString.evaluate(MapperS.of(drrReport).<String>map("getExchangeRateBasis", aSICTransactionReport -> aSICTransactionReport.getExchangeRateBasis()).get(), 1, 3);
			}
			String ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", aSICTransactionReport -> aSICTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.CURR), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = subString.evaluate(MapperS.of(drrReport).<String>map("getExchangeRateBasis", aSICTransactionReport -> aSICTransactionReport.getExchangeRateBasis()).get(), 5, 3);
			}
			ccy = toBuilder(CurrencyExchange22__1.builder()
				.setXchgRate(MapperS.of(drrReport).<BigDecimal>map("getExchangeRate", aSICTransactionReport -> aSICTransactionReport.getExchangeRate()).get())
				.setXchgRateBsis(ExchangeRateBasis1Choice__1.builder()
					.setCcyPair(ExchangeRateBasis1.builder()
						.setBaseCcy(ifThenElseResult0)
						.setQtdCcy(ifThenElseResult1)
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(ccy)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
