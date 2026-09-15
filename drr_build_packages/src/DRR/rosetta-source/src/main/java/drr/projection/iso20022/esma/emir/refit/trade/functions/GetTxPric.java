package drr.projection.iso20022.esma.emir.refit.trade.functions;

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
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import iso20022.auth030.esma.ActiveOrHistoricCurrencyAnd13DecimalAmount__1;
import iso20022.auth030.esma.ActiveOrHistoricCurrencyAnd19DecimalAmount;
import iso20022.auth030.esma.AmountAndDirection106;
import iso20022.auth030.esma.AmountAndDirection106__1;
import iso20022.auth030.esma.PriceData2__1;
import iso20022.auth030.esma.Schedule1;
import iso20022.auth030.esma.SecuritiesTransactionPrice17Choice;
import iso20022.auth030.esma.SecuritiesTransactionPrice17Choice__1;
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
	public PriceData2__1 evaluate(ESMAEMIRTransactionReport drrReport) {
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

	protected abstract PriceData2__1.PriceData2__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetTxPricDefault extends GetTxPric {
		@Override
		protected PriceData2__1.PriceData2__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			PriceData2__1.PriceData2__1Builder txPric = PriceData2__1.builder();
			return assignOutput(txPric, drrReport);
		}
		
		protected PriceData2__1.PriceData2__1Builder assignOutput(PriceData2__1.PriceData2__1Builder txPric, ESMAEMIRTransactionReport drrReport) {
			txPric
				.setPric(MapperS.of(drrReport)
					.mapSingleToItem(item -> {
						Boolean ifThenElseResult = null;
						if (lessThan(item.<PriceFormat>map("getPrice", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult = false;
						}
						return MapperS.of(SecuritiesTransactionPrice17Choice__1.builder()
							.setMntryVal(AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount__1.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getPrice", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPriceCurrency", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
									.build())
								.setSgn(ifThenElseResult)
								.build())
							.setPctg(item.<PriceFormat>map("getPrice", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getPrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()).get())
							.build());
					}).get());
			
			txPric
				.addSchdlPrd(MapperS.of(drrReport).<PricePeriod>mapC("getPriceSchedule", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getPriceSchedule())
					.mapItem(item -> {
						Boolean ifThenElseResult = null;
						if (lessThan(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult = false;
						}
						return MapperS.of(Schedule1.builder()
							.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()).get())
							.setUadjstdEndDt(item.<Date>map("getEndDate", pricePeriod -> pricePeriod.getEndDate()).get())
							.setPric(SecuritiesTransactionPrice17Choice.builder()
								.setMntryVal(AmountAndDirection106.builder()
									.setAmt(ActiveOrHistoricCurrencyAnd19DecimalAmount.builder()
										.setValue(abs.evaluate(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
										.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPriceCurrency", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getPriceCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
										.build())
									.setSgn(ifThenElseResult)
									.build())
								.setPctg(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()).get())
								.setDcml(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
								.build())
							.build());
					}).getMulti());
			
			return Optional.ofNullable(txPric)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
