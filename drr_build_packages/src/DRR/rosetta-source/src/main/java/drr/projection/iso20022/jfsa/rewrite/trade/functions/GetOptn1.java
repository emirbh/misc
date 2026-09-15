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
import drr.base.util.string.functions.StringLength;
import drr.base.util.string.functions.SubString;
import drr.regulation.common.trade.price.BarrierPrice;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.jfsa.AmountAndDirection106__1;
import iso20022.auth030.jfsa.OptionBarrierLevel1Choice__1;
import iso20022.auth030.jfsa.OptionMultipleBarrierLevels1__1;
import iso20022.auth030.jfsa.OptionOrSwaption11__1;
import iso20022.auth030.jfsa.Schedule4__1;
import iso20022.auth030.jfsa.SecuritiesTransactionPrice17Choice__1;
import iso20022.auth030.jfsa.SecuritiesTransactionPrice23Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetOptn1.GetOptn1Default.class)
public abstract class GetOptn1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;
	@Inject protected GetCallAmt getCallAmt;
	@Inject protected GetExrcDt getExrcDt;
	@Inject protected GetExrcStyle getExrcStyle;
	@Inject protected GetMbddTp getMbddTp;
	@Inject protected GetMtrtyDtOfUndrlyg getMtrtyDtOfUndrlyg;
	@Inject protected GetPrmAmt getPrmAmt;
	@Inject protected GetPrmPmtDt getPrmPmtDt;
	@Inject protected GetPutAmt getPutAmt;
	@Inject protected GetStrkPric getStrkPric;
	@Inject protected GetTp getTp;
	@Inject protected StringLength stringLength;
	@Inject protected SubString subString;

	/**
	* @param drrReport 
	* @return optn 
	*/
	public OptionOrSwaption11__1 evaluate(JFSATransactionReport drrReport) {
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder optnBuilder = doEvaluate(drrReport);
		
		final OptionOrSwaption11__1 optn;
		if (optnBuilder == null) {
			optn = null;
		} else {
			optn = optnBuilder.build();
			objectValidator.validate(OptionOrSwaption11__1.class, optn);
		}
		
		return optn;
	}

	protected abstract OptionOrSwaption11__1.OptionOrSwaption11__1Builder doEvaluate(JFSATransactionReport drrReport);

	public static class GetOptn1Default extends GetOptn1 {
		@Override
		protected OptionOrSwaption11__1.OptionOrSwaption11__1Builder doEvaluate(JFSATransactionReport drrReport) {
			OptionOrSwaption11__1.OptionOrSwaption11__1Builder optn = OptionOrSwaption11__1.builder();
			return assignOutput(optn, drrReport);
		}
		
		protected OptionOrSwaption11__1.OptionOrSwaption11__1Builder assignOutput(OptionOrSwaption11__1.OptionOrSwaption11__1Builder optn, JFSATransactionReport drrReport) {
			Boolean ifThenElseResult0 = null;
			if (lessThan(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", jFSATransactionReport -> jFSATransactionReport.getBarrier()).<BarrierPrice>map("get_single", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.get_single()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = false;
			}
			Boolean ifThenElseResult1 = null;
			if (lessThan(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", jFSATransactionReport -> jFSATransactionReport.getBarrier()).<BarrierPrice>map("getLower", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getLower()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = false;
			}
			Boolean ifThenElseResult2 = null;
			if (lessThan(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", jFSATransactionReport -> jFSATransactionReport.getBarrier()).<BarrierPrice>map("getUpper", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getUpper()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = false;
			}
			optn = toBuilder(OptionOrSwaption11__1.builder()
				.setTp(getTp.evaluate(drrReport))
				.setMbddTp(getMbddTp.evaluate(drrReport))
				.setExrcStyle(getExrcStyle.evaluate(drrReport))
				.setExrcDt(getExrcDt.evaluate(drrReport))
				.setStrkPric(getStrkPric.evaluate(drrReport))
				.setStrkPricSchdl(MapperS.of(drrReport).<PricePeriod>mapC("getStrikePriceSchedule", jFSATransactionReport -> jFSATransactionReport.getStrikePriceSchedule())
					.mapItem(item -> {
						AmountAndDirection106__1 _ifThenElseResult2 = null;
						if (exists(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary())).getOrDefault(false)) {
							final String _ifThenElseResult0;
							if (greaterThan(MapperS.of(stringLength.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", jFSATransactionReport -> jFSATransactionReport.getStrikePriceCurrency()).get())), MapperS.of(3), CardinalityOperator.All).getOrDefault(false)) {
								_ifThenElseResult0 = subString.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", jFSATransactionReport -> jFSATransactionReport.getStrikePriceCurrency()).get(), 5, 3);
							} else {
								_ifThenElseResult0 = MapperS.of(drrReport).<String>map("getStrikePriceCurrency", jFSATransactionReport -> jFSATransactionReport.getStrikePriceCurrency()).get();
							}
							Boolean _ifThenElseResult1 = null;
							if (lessThan(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
								_ifThenElseResult1 = false;
							}
							_ifThenElseResult2 = AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(_ifThenElseResult0)
									.build())
								.setSgn(_ifThenElseResult1)
								.build();
						}
						BigDecimal ifThenElseResult3 = null;
						if (exists(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal())).getOrDefault(false)) {
							ifThenElseResult3 = item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get();
						}
						return MapperS.of(Schedule4__1.builder()
							.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()).get())
							.setUadjstdEndDt(item.<Date>map("getEndDate", pricePeriod -> pricePeriod.getEndDate()).get())
							.setPric(SecuritiesTransactionPrice17Choice__1.builder()
								.setMntryVal(_ifThenElseResult2)
								.setDcml(ifThenElseResult3)
								.build())
							.build());
					}).getMulti())
				.setCallAmt(getCallAmt.evaluate(drrReport))
				.setPutAmt(getPutAmt.evaluate(drrReport))
				.setPrmAmt(getPrmAmt.evaluate(drrReport))
				.setPrmPmtDt(getPrmPmtDt.evaluate(drrReport))
				.setMtrtyDtOfUndrlyg(getMtrtyDtOfUndrlyg.evaluate(drrReport))
				.setBrrrLvls(OptionBarrierLevel1Choice__1.builder()
					.setSngl(SecuritiesTransactionPrice23Choice__1.builder()
						.setMntryVal(AmountAndDirection106__1.builder()
							.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
								.setValue(abs.evaluate(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", jFSATransactionReport -> jFSATransactionReport.getBarrier()).<BarrierPrice>map("get_single", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.get_single()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
								.setCcy(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", jFSATransactionReport -> jFSATransactionReport.getBarrier()).<BarrierPrice>map("get_single", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.get_single()).<ISOCurrencyCodeEnum>map("getCurrency", barrierPrice -> barrierPrice.getCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
								.build())
							.setSgn(ifThenElseResult0)
							.build())
						.setDcml(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", jFSATransactionReport -> jFSATransactionReport.getBarrier()).<BarrierPrice>map("get_single", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.get_single()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
						.build())
					.setMltpl(OptionMultipleBarrierLevels1__1.builder()
						.setLwrLvl(SecuritiesTransactionPrice23Choice__1.builder()
							.setMntryVal(AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
									.setValue(abs.evaluate(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", jFSATransactionReport -> jFSATransactionReport.getBarrier()).<BarrierPrice>map("getLower", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getLower()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", jFSATransactionReport -> jFSATransactionReport.getBarrier()).<BarrierPrice>map("getLower", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getLower()).<ISOCurrencyCodeEnum>map("getCurrency", barrierPrice -> barrierPrice.getCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
									.build())
								.setSgn(ifThenElseResult1)
								.build())
							.setDcml(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", jFSATransactionReport -> jFSATransactionReport.getBarrier()).<BarrierPrice>map("getLower", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getLower()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
							.build())
						.setUpperLvl(SecuritiesTransactionPrice23Choice__1.builder()
							.setMntryVal(AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
									.setValue(abs.evaluate(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", jFSATransactionReport -> jFSATransactionReport.getBarrier()).<BarrierPrice>map("getUpper", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getUpper()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", jFSATransactionReport -> jFSATransactionReport.getBarrier()).<BarrierPrice>map("getUpper", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getUpper()).<ISOCurrencyCodeEnum>map("getCurrency", barrierPrice -> barrierPrice.getCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
									.build())
								.setSgn(ifThenElseResult2)
								.build())
							.setDcml(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", jFSATransactionReport -> jFSATransactionReport.getBarrier()).<BarrierPrice>map("getUpper", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getUpper()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
							.build())
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(optn)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
