package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import cdm.base.math.functions.Abs;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceFormat;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.jfsa.AmountAndDirection106__1;
import iso20022.auth030.jfsa.SecuritiesTransactionPrice17Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetPric.GetPricDefault.class)
public abstract class GetPric implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;

	/**
	* @param drrReport 
	* @return pric 
	*/
	public SecuritiesTransactionPrice17Choice__1 evaluate(JFSATransactionReport drrReport) {
		SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder pricBuilder = doEvaluate(drrReport);
		
		final SecuritiesTransactionPrice17Choice__1 pric;
		if (pricBuilder == null) {
			pric = null;
		} else {
			pric = pricBuilder.build();
			objectValidator.validate(SecuritiesTransactionPrice17Choice__1.class, pric);
		}
		
		return pric;
	}

	protected abstract SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetPricDefault extends GetPric {
		@Override
		protected SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder doEvaluate(JFSATransactionReport drrReport) {
			SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder pric = SecuritiesTransactionPrice17Choice__1.builder();
			return assignOutput(pric, drrReport);
		}
		
		protected SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder assignOutput(SecuritiesTransactionPrice17Choice__1.SecuritiesTransactionPrice17Choice__1Builder pric, JFSATransactionReport drrReport) {
			pric = toBuilder(MapperS.of(drrReport)
				.mapSingleToItem(item -> {
					Boolean ifThenElseResult = null;
					if (lessThan(item.<PriceFormat>map("getPrice", jFSATransactionReport -> jFSATransactionReport.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
						ifThenElseResult = false;
					}
					return MapperS.of(SecuritiesTransactionPrice17Choice__1.builder()
						.setMntryVal(AmountAndDirection106__1.builder()
							.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
								.setValue(abs.evaluate(item.<PriceFormat>map("getPrice", jFSATransactionReport -> jFSATransactionReport.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
								.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPriceCurrency", jFSATransactionReport -> jFSATransactionReport.getPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
								.build())
							.setSgn(ifThenElseResult)
							.build())
						.setDcml(item.<PriceFormat>map("getPrice", jFSATransactionReport -> jFSATransactionReport.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
						.build());
				}).get());
			
			return Optional.ofNullable(pric)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
