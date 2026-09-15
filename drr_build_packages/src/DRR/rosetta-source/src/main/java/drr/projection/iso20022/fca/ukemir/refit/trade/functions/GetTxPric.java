package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

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
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import iso20022.auth030.fca.ActiveOrHistoricCurrencyAnd13DecimalAmount__1;
import iso20022.auth030.fca.AmountAndDirection106__1;
import iso20022.auth030.fca.PriceData2__1;
import iso20022.auth030.fca.Schedule1__1;
import iso20022.auth030.fca.SecuritiesTransactionPrice17Choice__1;
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
	public PriceData2__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
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

	protected abstract PriceData2__1.PriceData2__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetTxPricDefault extends GetTxPric {
		@Override
		protected PriceData2__1.PriceData2__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			PriceData2__1.PriceData2__1Builder txPric = PriceData2__1.builder();
			return assignOutput(txPric, drrReport);
		}
		
		protected PriceData2__1.PriceData2__1Builder assignOutput(PriceData2__1.PriceData2__1Builder txPric, FCAUKEMIRTransactionReport drrReport) {
			txPric
				.setPric(MapperS.of(drrReport)
					.mapSingleToItem(item -> {
						Boolean ifThenElseResult = null;
						if (lessThan(item.<PriceFormat>map("getPrice", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult = false;
						}
						return MapperS.of(SecuritiesTransactionPrice17Choice__1.builder()
							.setMntryVal(AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount__1.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getPrice", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPriceCurrency", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
									.build())
								.setSgn(ifThenElseResult)
								.build())
							.setPctg(item.<PriceFormat>map("getPrice", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()).get())
							.build());
					}).get());
			
			txPric
				.addSchdlPrd(MapperS.of(drrReport).<PricePeriod>mapC("getPriceSchedule", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPriceSchedule())
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
									.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount__1.builder()
										.setValue(abs.evaluate(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
										.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPriceCurrency", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
										.build())
									.setSgn(ifThenElseResult)
									.build())
								.setPctg(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()).get())
								.build())
							.build());
					}).getMulti());
			
			return Optional.ofNullable(txPric)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
