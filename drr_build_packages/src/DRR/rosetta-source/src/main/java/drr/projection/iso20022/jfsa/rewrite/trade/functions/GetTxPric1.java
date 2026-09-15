package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import cdm.base.math.functions.Abs;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PricePeriod;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.jfsa.AmountAndDirection106__1;
import iso20022.auth030.jfsa.PriceData2__1;
import iso20022.auth030.jfsa.Schedule1__1;
import iso20022.auth030.jfsa.SecuritiesTransactionPrice17Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetTxPric1.GetTxPric1Default.class)
public abstract class GetTxPric1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;
	@Inject protected Create_UnitOfMeasure8Choice__1 create_UnitOfMeasure8Choice__1;
	@Inject protected GetPric getPric;

	/**
	* @param drrReport 
	* @return txPric 
	*/
	public PriceData2__1 evaluate(JFSATransactionReport drrReport) {
		PriceData2__1.PriceData2__1Builder txPricBuilder = doEvaluate(drrReport);
		
		final PriceData2__1 txPric;
		if (txPricBuilder == null) {
			txPric = null;
		} else {
			txPric = txPricBuilder.build();
			objectValidator.validate(PriceData2__1.class, txPric);
		}
		
		return txPric;
	}

	protected abstract PriceData2__1.PriceData2__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetTxPric1Default extends GetTxPric1 {
		@Override
		protected PriceData2__1.PriceData2__1Builder doEvaluate(JFSATransactionReport drrReport) {
			PriceData2__1.PriceData2__1Builder txPric = PriceData2__1.builder();
			return assignOutput(txPric, drrReport);
		}
		
		protected PriceData2__1.PriceData2__1Builder assignOutput(PriceData2__1.PriceData2__1Builder txPric, JFSATransactionReport drrReport) {
			txPric = toBuilder(PriceData2__1.builder()
				.setPric(getPric.evaluate(drrReport))
				.setSchdlPrd(MapperS.of(drrReport).<PricePeriod>mapC("getPriceSchedule", jFSATransactionReport -> jFSATransactionReport.getPriceSchedule())
					.mapItem(item -> {
						Boolean ifThenElseResult = null;
						if (lessThan(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult = false;
						}
						return MapperS.of(Schedule1__1.builder()
							.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()).get())
							.setUadjstdEndDt(item.<Date>map("getEndDate", pricePeriod -> pricePeriod.getEndDate()).get())
							.setPric(SecuritiesTransactionPrice17Choice__1.builder()
								.setMntryVal(AmountAndDirection106__1.builder()
									.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
										.setValue(abs.evaluate(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
										.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPriceCurrency", jFSATransactionReport -> jFSATransactionReport.getPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
										.build())
									.setSgn(ifThenElseResult)
									.build())
								.setDcml(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
								.build())
							.build());
					}).getMulti())
				.setUnitOfMeasr(create_UnitOfMeasure8Choice__1.evaluate(MapperS.of(drrReport).<String>map("getPriceUnitOfMeasure", jFSATransactionReport -> jFSATransactionReport.getPriceUnitOfMeasure()).get()))
				.build());
			
			return Optional.ofNullable(txPric)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
