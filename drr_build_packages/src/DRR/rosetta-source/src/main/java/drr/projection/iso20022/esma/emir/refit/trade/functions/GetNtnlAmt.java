package drr.projection.iso20022.esma.emir.refit.trade.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import iso20022.auth030.esma.ActiveOrHistoricCurrencyAnd5DecimalAmount__1;
import iso20022.auth030.esma.AmountAndDirection106__2;
import iso20022.auth030.esma.NotionalAmount5__1;
import iso20022.auth030.esma.NotionalAmount6__1;
import iso20022.auth030.esma.NotionalAmountLegs5__1;
import iso20022.auth030.esma.Schedule11__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetNtnlAmt.GetNtnlAmtDefault.class)
public abstract class GetNtnlAmt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return ntnlAmt 
	*/
	public NotionalAmountLegs5__1 evaluate(ESMAEMIRTransactionReport drrReport) {
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

	protected abstract NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class GetNtnlAmtDefault extends GetNtnlAmt {
		@Override
		protected NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder ntnlAmt = NotionalAmountLegs5__1.builder();
			return assignOutput(ntnlAmt, drrReport);
		}
		
		protected NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder assignOutput(NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder ntnlAmt, ESMAEMIRTransactionReport drrReport) {
			ntnlAmt = toBuilder(NotionalAmountLegs5__1.builder()
				.setFrstLeg(NotionalAmount5__1.builder()
					.setAmt(AmountAndDirection106__2.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount__1.builder()
							.setValue(MapperS.of(drrReport).<CommonLeg>map("getLeg1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()).get())
							.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
							.build())
						.build())
					.setSchdlPrd(MapperS.of(drrReport).<CommonLeg>map("getLeg1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule())
						.mapItem(item -> MapperS.of(Schedule11__1.builder()
							.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).get())
							.setAmt(AmountAndDirection106__2.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount__1.builder()
									.setValue(item.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).get())
									.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
									.build())
								.build())
							.build())).getMulti())
					.build())
				.setScndLeg(NotionalAmount6__1.builder()
					.setAmt(AmountAndDirection106__2.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount__1.builder()
							.setValue(MapperS.of(drrReport).<CommonLeg>map("getLeg2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg2()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()).get())
							.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
							.build())
						.build())
					.setSchdlPrd(MapperS.of(drrReport).<CommonLeg>map("getLeg2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalAmountSchedule", commonLeg -> commonLeg.getNotionalAmountSchedule())
						.mapItem(item -> MapperS.of(Schedule11__1.builder()
							.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).get())
							.setAmt(AmountAndDirection106__2.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount__1.builder()
									.setValue(item.<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).get())
									.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
									.build())
								.build())
							.build())).getMulti())
					.build())
				.build());
			
			return Optional.ofNullable(ntnlAmt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
