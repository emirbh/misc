package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import cdm.base.math.functions.Abs;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.tr.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.hkma.tr.AmountAndDirection106__2;
import iso20022.auth030.hkma.tr.NotionalAmount5__1;
import iso20022.auth030.hkma.tr.NotionalAmount6__1;
import iso20022.auth030.hkma.tr.NotionalAmountLegs5__1;
import iso20022.auth030.hkma.tr.Schedule11__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetNtnlAmt.GetNtnlAmtDefault.class)
public abstract class GetNtnlAmt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;

	/**
	* @param drrReport 
	* @return ntnlAmt 
	*/
	public NotionalAmountLegs5__1 evaluate(HKMATransactionReport drrReport) {
		NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder ntnlAmtBuilder = doEvaluate(drrReport);
		
		final NotionalAmountLegs5__1 ntnlAmt;
		if (ntnlAmtBuilder == null) {
			ntnlAmt = null;
		} else {
			ntnlAmt = ntnlAmtBuilder.build();
			objectValidator.validate(NotionalAmountLegs5__1.class, ntnlAmt);
		}
		
		return ntnlAmt;
	}

	protected abstract NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder doEvaluate(HKMATransactionReport drrReport);

	public static class GetNtnlAmtDefault extends GetNtnlAmt {
		@Override
		protected NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder doEvaluate(HKMATransactionReport drrReport) {
			NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder ntnlAmt = NotionalAmountLegs5__1.builder();
			return assignOutput(ntnlAmt, drrReport);
		}
		
		protected NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder assignOutput(NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder ntnlAmt, HKMATransactionReport drrReport) {
			Boolean ifThenElseResult0 = null;
			if (lessThan(MapperS.of(drrReport).<CommonLeg>map("getLeg1", hKMATransactionReport -> hKMATransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = false;
			}
			Boolean ifThenElseResult1 = null;
			if (lessThan(MapperS.of(drrReport).<CommonLeg>map("getLeg2", hKMATransactionReport -> hKMATransactionReport.getLeg2()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = false;
			}
			ntnlAmt = toBuilder(NotionalAmountLegs5__1.builder()
				.setFrstLeg(NotionalAmount5__1.builder()
					.setAmt(AmountAndDirection106__2.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
							.setValue(abs.evaluate(MapperS.of(drrReport).<CommonLeg>map("getLeg1", hKMATransactionReport -> hKMATransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()).get()))
							.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg1", hKMATransactionReport -> hKMATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
							.build())
						.setSgn(ifThenElseResult0)
						.build())
					.setSchdlPrd(MapperS.of(drrReport).<CommonLeg>map("getLeg1", hKMATransactionReport -> hKMATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule())
						.mapItem(item -> {
							Boolean ifThenElseResult = null;
							if (lessThan(item.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
								ifThenElseResult = false;
							}
							return MapperS.of(Schedule11__1.builder()
								.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).get())
								.setUadjstdEndDt(item.<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate()).get())
								.setAmt(AmountAndDirection106__2.builder()
									.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
										.setValue(abs.evaluate(item.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).get()))
										.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg1", hKMATransactionReport -> hKMATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
										.build())
									.setSgn(ifThenElseResult)
									.build())
								.build());
						}).getMulti())
					.build())
				.setScndLeg(NotionalAmount6__1.builder()
					.setAmt(AmountAndDirection106__2.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
							.setValue(abs.evaluate(MapperS.of(drrReport).<CommonLeg>map("getLeg2", hKMATransactionReport -> hKMATransactionReport.getLeg2()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()).get()))
							.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg2", hKMATransactionReport -> hKMATransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
							.build())
						.setSgn(ifThenElseResult1)
						.build())
					.setSchdlPrd(MapperS.of(drrReport).<CommonLeg>map("getLeg2", hKMATransactionReport -> hKMATransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule())
						.mapItem(item -> {
							Boolean ifThenElseResult = null;
							if (lessThan(item.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
								ifThenElseResult = false;
							}
							return MapperS.of(Schedule11__1.builder()
								.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).get())
								.setUadjstdEndDt(item.<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate()).get())
								.setAmt(AmountAndDirection106__2.builder()
									.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
										.setValue(abs.evaluate(item.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).get()))
										.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg2", hKMATransactionReport -> hKMATransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
										.build())
									.setSgn(ifThenElseResult)
									.build())
								.build());
						}).getMulti())
					.build())
				.build());
			
			return Optional.ofNullable(ntnlAmt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
