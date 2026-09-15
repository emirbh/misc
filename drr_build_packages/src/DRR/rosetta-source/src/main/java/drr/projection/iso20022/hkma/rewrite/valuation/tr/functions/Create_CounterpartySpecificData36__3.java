package drr.projection.iso20022.hkma.rewrite.valuation.tr.functions;

import cdm.base.math.functions.Abs;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.valuation.HKMAValuationReport;
import drr.standards.iso.ValuationType1Code;
import iso20022.auth030.hkma.tr.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.hkma.tr.AmountAndDirection109__1;
import iso20022.auth030.hkma.tr.ContractValuationData8__1;
import iso20022.auth030.hkma.tr.CounterpartySpecificData36__3;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_CounterpartySpecificData36__3.Create_CounterpartySpecificData36__3Default.class)
public abstract class Create_CounterpartySpecificData36__3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;
	@Inject protected Create_TradeCounterpartyReport20__2 create_TradeCounterpartyReport20__2;

	/**
	* @param drrReport 
	* @return ctrPtySpcfcData 
	*/
	public CounterpartySpecificData36__3 evaluate(HKMAValuationReport drrReport) {
		CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder ctrPtySpcfcDataBuilder = doEvaluate(drrReport);
		
		final CounterpartySpecificData36__3 ctrPtySpcfcData;
		if (ctrPtySpcfcDataBuilder == null) {
			ctrPtySpcfcData = null;
		} else {
			ctrPtySpcfcData = ctrPtySpcfcDataBuilder.build();
			objectValidator.validate(CounterpartySpecificData36__3.class, ctrPtySpcfcData);
		}
		
		return ctrPtySpcfcData;
	}

	protected abstract CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder doEvaluate(HKMAValuationReport drrReport);

	public static class Create_CounterpartySpecificData36__3Default extends Create_CounterpartySpecificData36__3 {
		@Override
		protected CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder doEvaluate(HKMAValuationReport drrReport) {
			CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder ctrPtySpcfcData = CounterpartySpecificData36__3.builder();
			return assignOutput(ctrPtySpcfcData, drrReport);
		}
		
		protected CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder assignOutput(CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder ctrPtySpcfcData, HKMAValuationReport drrReport) {
			Boolean ifThenElseResult = null;
			if (lessThan(MapperS.of(drrReport).<BigDecimal>map("getValuationAmount", hKMAValuationReport -> hKMAValuationReport.getValuationAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = false;
			}
			ctrPtySpcfcData = toBuilder(CounterpartySpecificData36__3.builder()
				.setCtrPty(create_TradeCounterpartyReport20__2.evaluate(drrReport))
				.setValtn(ContractValuationData8__1.builder()
					.setCtrctVal(AmountAndDirection109__1.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
							.setValue(abs.evaluate(MapperS.of(drrReport).<BigDecimal>map("getValuationAmount", hKMAValuationReport -> hKMAValuationReport.getValuationAmount()).get()))
							.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getValuationCurrency", hKMAValuationReport -> hKMAValuationReport.getValuationCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
							.build())
						.setSgn(ifThenElseResult)
						.build())
					.setTmStmp(MapperS.of(drrReport).<ZonedDateTime>map("getValuationTimestamp", hKMAValuationReport -> hKMAValuationReport.getValuationTimestamp()).get())
					.setTp(MapperS.of(drrReport).<ValuationType1Code>map("getValuationMethod", hKMAValuationReport -> hKMAValuationReport.getValuationMethod()).checkedMap("to-enum", e -> iso20022.auth030.hkma.tr.ValuationType1Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.setDlta(MapperS.of(drrReport).<BigDecimal>map("getDelta", hKMAValuationReport -> hKMAValuationReport.getDelta()).get())
					.build())
				.setRptgTmStmp(MapperS.of(drrReport).<ZonedDateTime>map("getReportingTimestamp", hKMAValuationReport -> hKMAValuationReport.getReportingTimestamp()).get())
				.build());
			
			return Optional.ofNullable(ctrPtySpcfcData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
