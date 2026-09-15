package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

import cdm.base.math.functions.Abs;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.price.PriceFormat;
import drr.regulation.common.trade.price.BarrierPrice;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.dtcc.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.hkma.dtcc.AmountAndDirection106__1;
import iso20022.auth030.hkma.dtcc.OptionBarrierLevel1Choice__1;
import iso20022.auth030.hkma.dtcc.OptionMultipleBarrierLevels1__1;
import iso20022.auth030.hkma.dtcc.SecuritiesTransactionPrice23Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_OptionBarrierLevel1Choice__1.Create_OptionBarrierLevel1Choice__1Default.class)
public abstract class Create_OptionBarrierLevel1Choice__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;

	/**
	* @param drrReport 
	* @return brrrLvls 
	*/
	public OptionBarrierLevel1Choice__1 evaluate(HKMATransactionReport drrReport) {
		OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder brrrLvlsBuilder = doEvaluate(drrReport);
		
		final OptionBarrierLevel1Choice__1 brrrLvls;
		if (brrrLvlsBuilder == null) {
			brrrLvls = null;
		} else {
			brrrLvls = brrrLvlsBuilder.build();
			objectValidator.validate(OptionBarrierLevel1Choice__1.class, brrrLvls);
		}
		
		return brrrLvls;
	}

	protected abstract OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder doEvaluate(HKMATransactionReport drrReport);

	public static class Create_OptionBarrierLevel1Choice__1Default extends Create_OptionBarrierLevel1Choice__1 {
		@Override
		protected OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder doEvaluate(HKMATransactionReport drrReport) {
			OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder brrrLvls = OptionBarrierLevel1Choice__1.builder();
			return assignOutput(brrrLvls, drrReport);
		}
		
		protected OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder assignOutput(OptionBarrierLevel1Choice__1.OptionBarrierLevel1Choice__1Builder brrrLvls, HKMATransactionReport drrReport) {
			brrrLvls = toBuilder(OptionBarrierLevel1Choice__1.builder()
				.setSngl(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", hKMATransactionReport -> hKMATransactionReport.getBarrier())
					.mapSingleToItem(item -> {
						Boolean ifThenElseResult = null;
						if (lessThan(item.<BarrierPrice>map("get_single", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.get_single()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult = false;
						}
						return MapperS.of(SecuritiesTransactionPrice23Choice__1.builder()
							.setMntryVal(AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
									.setValue(abs.evaluate(item.<BarrierPrice>map("get_single", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.get_single()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(item.<BarrierPrice>map("get_single", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.get_single()).<ISOCurrencyCodeEnum>map("getCurrency", barrierPrice -> barrierPrice.getCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
									.build())
								.setSgn(ifThenElseResult)
								.build())
							.setDcml(item.<BarrierPrice>map("get_single", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.get_single()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
							.build());
					}).get())
				.setMltpl(OptionMultipleBarrierLevels1__1.builder()
					.setLwrLvl(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", hKMATransactionReport -> hKMATransactionReport.getBarrier())
						.mapSingleToItem(item -> {
							Boolean ifThenElseResult = null;
							if (lessThan(item.<BarrierPrice>map("getLower", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getLower()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
								ifThenElseResult = false;
							}
							return MapperS.of(SecuritiesTransactionPrice23Choice__1.builder()
								.setMntryVal(AmountAndDirection106__1.builder()
									.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
										.setValue(abs.evaluate(item.<BarrierPrice>map("getLower", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getLower()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
										.setCcy(item.<BarrierPrice>map("getLower", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getLower()).<ISOCurrencyCodeEnum>map("getCurrency", barrierPrice -> barrierPrice.getCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
										.build())
									.setSgn(ifThenElseResult)
									.build())
								.setDcml(item.<BarrierPrice>map("getLower", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getLower()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
								.build());
						}).get())
					.setUpperLvl(MapperS.of(drrReport).<SingleOrUpperAndLowerBarrier>map("getBarrier", hKMATransactionReport -> hKMATransactionReport.getBarrier())
						.mapSingleToItem(item -> {
							Boolean ifThenElseResult = null;
							if (lessThan(item.<BarrierPrice>map("getUpper", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getUpper()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
								ifThenElseResult = false;
							}
							return MapperS.of(SecuritiesTransactionPrice23Choice__1.builder()
								.setMntryVal(AmountAndDirection106__1.builder()
									.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
										.setValue(abs.evaluate(item.<BarrierPrice>map("getUpper", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getUpper()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
										.setCcy(item.<BarrierPrice>map("getUpper", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getUpper()).<ISOCurrencyCodeEnum>map("getCurrency", barrierPrice -> barrierPrice.getCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
										.build())
									.setSgn(ifThenElseResult)
									.build())
								.setDcml(item.<BarrierPrice>map("getUpper", singleOrUpperAndLowerBarrier -> singleOrUpperAndLowerBarrier.getUpper()).<PriceFormat>map("getPrice", barrierPrice -> barrierPrice.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
								.build());
						}).get())
					.build())
				.build());
			
			return Optional.ofNullable(brrrLvls)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
