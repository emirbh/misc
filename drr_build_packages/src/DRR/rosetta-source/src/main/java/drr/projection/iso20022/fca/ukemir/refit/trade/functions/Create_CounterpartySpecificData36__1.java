package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import cdm.base.math.functions.Abs;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.ValuationType1Code;
import iso20022.auth030.fca.ActiveOrHistoricCurrencyAnd5DecimalAmount__1;
import iso20022.auth030.fca.AmountAndDirection109__1;
import iso20022.auth030.fca.ContractValuationData8__1;
import iso20022.auth030.fca.CounterpartySpecificData36__1;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_CounterpartySpecificData36__1.Create_CounterpartySpecificData36__1Default.class)
public abstract class Create_CounterpartySpecificData36__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;
	@Inject protected Create_TradeCounterpartyReport20__1 create_TradeCounterpartyReport20__1;

	/**
	* @param drrReport 
	* @return ctrPtySpcfcData 
	*/
	public CounterpartySpecificData36__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
		CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder ctrPtySpcfcDataBuilder = doEvaluate(drrReport);
		
		final CounterpartySpecificData36__1 ctrPtySpcfcData;
		if (ctrPtySpcfcDataBuilder == null) {
			ctrPtySpcfcData = null;
		} else {
			ctrPtySpcfcData = ctrPtySpcfcDataBuilder.build();
			objectValidator.validate(CounterpartySpecificData36__1.class, ctrPtySpcfcData);
		}
		
		return ctrPtySpcfcData;
	}

	protected abstract CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class Create_CounterpartySpecificData36__1Default extends Create_CounterpartySpecificData36__1 {
		@Override
		protected CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder ctrPtySpcfcData = CounterpartySpecificData36__1.builder();
			return assignOutput(ctrPtySpcfcData, drrReport);
		}
		
		protected CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder assignOutput(CounterpartySpecificData36__1.CounterpartySpecificData36__1Builder ctrPtySpcfcData, FCAUKEMIRTransactionReport drrReport) {
			Boolean ifThenElseResult = null;
			if (lessThan(MapperS.of(drrReport).<BigDecimal>map("getValuationAmount", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getValuationAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = false;
			}
			ctrPtySpcfcData = toBuilder(CounterpartySpecificData36__1.builder()
				.setCtrPty(create_TradeCounterpartyReport20__1.evaluate(drrReport))
				.setValtn(ContractValuationData8__1.builder()
					.setCtrctVal(AmountAndDirection109__1.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount__1.builder()
							.setValue(abs.evaluate(MapperS.of(drrReport).<BigDecimal>map("getValuationAmount", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getValuationAmount()).get()))
							.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getValuationCurrency", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getValuationCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
							.build())
						.setSgn(ifThenElseResult)
						.build())
					.setTmStmp(MapperS.of(drrReport).<ZonedDateTime>map("getValuationTimestamp", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getValuationTimestamp()).get())
					.setTp(MapperS.of(drrReport).<ValuationType1Code>map("getValuationMethod", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getValuationMethod()).checkedMap("to-enum", e -> iso20022.auth030.fca.ValuationType1Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.setDlta(MapperS.of(drrReport).<BigDecimal>map("getDelta", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getDelta()).get())
					.build())
				.setRptgTmStmp(MapperS.of(drrReport).<ZonedDateTime>map("getReportingTimestamp", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getReportingTimestamp()).get())
				.build());
			
			return Optional.ofNullable(ctrPtySpcfcData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
