package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

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
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.dtcc.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.hkma.dtcc.AmountAndDirection106__1;
import iso20022.auth030.hkma.dtcc.AmountAndDirection106__2;
import iso20022.auth030.hkma.dtcc.PriceData2__1;
import iso20022.auth030.hkma.dtcc.Schedule1__1;
import iso20022.auth030.hkma.dtcc.SecuritiesTransactionPrice17Choice__1;
import iso20022.auth030.hkma.dtcc.SecuritiesTransactionPrice17Choice__2;
import iso20022.auth030.hkma.dtcc.UnitOfMeasure8Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetTxPric.GetTxPricDefault.class)
public abstract class GetTxPric implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;

	/**
	* @param drrReport 
	* @return txPric 
	*/
	public PriceData2__1 evaluate(HKMATransactionReport drrReport) {
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

	protected abstract PriceData2__1.PriceData2__1Builder doEvaluate(HKMATransactionReport drrReport);

	public static class GetTxPricDefault extends GetTxPric {
		@Override
		protected PriceData2__1.PriceData2__1Builder doEvaluate(HKMATransactionReport drrReport) {
			PriceData2__1.PriceData2__1Builder txPric = PriceData2__1.builder();
			return assignOutput(txPric, drrReport);
		}
		
		protected PriceData2__1.PriceData2__1Builder assignOutput(PriceData2__1.PriceData2__1Builder txPric, HKMATransactionReport drrReport) {
			txPric = toBuilder(PriceData2__1.builder()
				.setPric(MapperS.of(drrReport)
					.mapSingleToItem(item -> {
						Boolean ifThenElseResult = null;
						if (lessThan(item.<PriceFormat>map("getPrice", hKMATransactionReport -> hKMATransactionReport.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult = false;
						}
						return MapperS.of(SecuritiesTransactionPrice17Choice__1.builder()
							.setMntryVal(AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getPrice", hKMATransactionReport -> hKMATransactionReport.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPriceCurrency", hKMATransactionReport -> hKMATransactionReport.getPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
									.build())
								.setSgn(ifThenElseResult)
								.build())
							.setDcml(item.<PriceFormat>map("getPrice", hKMATransactionReport -> hKMATransactionReport.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
							.build());
					}).get())
				.setUnitOfMeasr(UnitOfMeasure8Choice__1.builder()
					.setCd(MapperS.of(drrReport).<String>map("getPriceUnitOfMeasure", hKMATransactionReport -> hKMATransactionReport.getPriceUnitOfMeasure()).get())
					.build())
				.setSchdlPrd(MapperS.of(drrReport).<PricePeriod>mapC("getPriceSchedule", hKMATransactionReport -> hKMATransactionReport.getPriceSchedule())
					.mapItem(item -> MapperS.of(Schedule1__1.builder()
						.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()).get())
						.setUadjstdEndDt(item.<Date>map("getEndDate", pricePeriod -> pricePeriod.getEndDate()).get())
						.setPric(SecuritiesTransactionPrice17Choice__2.builder()
							.setMntryVal(AmountAndDirection106__2.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPriceCurrency", hKMATransactionReport -> hKMATransactionReport.getPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
									.build())
								.build())
							.setDcml(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
							.build())
						.build())).getMulti())
				.build());
			
			return Optional.ofNullable(txPric)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
