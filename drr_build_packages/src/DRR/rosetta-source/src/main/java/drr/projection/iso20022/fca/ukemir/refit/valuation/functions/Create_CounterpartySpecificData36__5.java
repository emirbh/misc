package drr.projection.iso20022.fca.ukemir.refit.valuation.functions;

import cdm.base.math.functions.Abs;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import drr.standards.iso.ValuationType1Code;
import iso20022.auth030.fca.ActiveOrHistoricCurrencyAnd5DecimalAmount__1;
import iso20022.auth030.fca.AmountAndDirection109__2;
import iso20022.auth030.fca.ContractValuationData8__2;
import iso20022.auth030.fca.CounterpartySpecificData36__5;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_CounterpartySpecificData36__5.Create_CounterpartySpecificData36__5Default.class)
public abstract class Create_CounterpartySpecificData36__5 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;
	@Inject protected Create_TradeCounterpartyReport20__2 create_TradeCounterpartyReport20__2;

	/**
	* @param drrReport 
	* @return ctrPtySpcfcData 
	*/
	public CounterpartySpecificData36__5 evaluate(FCAValuationReport drrReport) {
		CounterpartySpecificData36__5.CounterpartySpecificData36__5Builder ctrPtySpcfcDataBuilder = doEvaluate(drrReport);
		
		final CounterpartySpecificData36__5 ctrPtySpcfcData;
		if (ctrPtySpcfcDataBuilder == null) {
			ctrPtySpcfcData = null;
		} else {
			ctrPtySpcfcData = ctrPtySpcfcDataBuilder.build();
			objectValidator.validate(CounterpartySpecificData36__5.class, ctrPtySpcfcData);
		}
		
		return ctrPtySpcfcData;
	}

	protected abstract CounterpartySpecificData36__5.CounterpartySpecificData36__5Builder doEvaluate(FCAValuationReport drrReport);

	public static class Create_CounterpartySpecificData36__5Default extends Create_CounterpartySpecificData36__5 {
		@Override
		protected CounterpartySpecificData36__5.CounterpartySpecificData36__5Builder doEvaluate(FCAValuationReport drrReport) {
			CounterpartySpecificData36__5.CounterpartySpecificData36__5Builder ctrPtySpcfcData = CounterpartySpecificData36__5.builder();
			return assignOutput(ctrPtySpcfcData, drrReport);
		}
		
		protected CounterpartySpecificData36__5.CounterpartySpecificData36__5Builder assignOutput(CounterpartySpecificData36__5.CounterpartySpecificData36__5Builder ctrPtySpcfcData, FCAValuationReport drrReport) {
			Boolean ifThenElseResult = null;
			if (lessThan(MapperS.of(drrReport).<BigDecimal>map("getValuationAmount", fCAValuationReport -> fCAValuationReport.getValuationAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = false;
			}
			ctrPtySpcfcData = toBuilder(CounterpartySpecificData36__5.builder()
				.setCtrPty(create_TradeCounterpartyReport20__2.evaluate(drrReport))
				.setValtn(ContractValuationData8__2.builder()
					.setCtrctVal(AmountAndDirection109__2.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount__1.builder()
							.setValue(abs.evaluate(MapperS.of(drrReport).<BigDecimal>map("getValuationAmount", fCAValuationReport -> fCAValuationReport.getValuationAmount()).get()))
							.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getValuationCurrency", fCAValuationReport -> fCAValuationReport.getValuationCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
							.build())
						.setSgn(ifThenElseResult)
						.build())
					.setTmStmp(MapperS.of(drrReport).<ZonedDateTime>map("getValuationTimestamp", fCAValuationReport -> fCAValuationReport.getValuationTimestamp()).get())
					.setTp(MapperS.of(drrReport).<ValuationType1Code>map("getValuationMethod", fCAValuationReport -> fCAValuationReport.getValuationMethod()).checkedMap("to-enum", e -> iso20022.auth030.fca.ValuationType1Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.setDlta(MapperS.of(drrReport).<BigDecimal>map("getDelta", fCAValuationReport -> fCAValuationReport.getDelta()).get())
					.build())
				.setRptgTmStmp(MapperS.of(drrReport).<ZonedDateTime>map("getReportingTimestamp", fCAValuationReport -> fCAValuationReport.getReportingTimestamp()).get())
				.build());
			
			return Optional.ofNullable(ctrPtySpcfcData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
