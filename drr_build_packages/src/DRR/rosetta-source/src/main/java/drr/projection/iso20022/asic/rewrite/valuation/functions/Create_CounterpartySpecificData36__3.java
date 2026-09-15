package drr.projection.iso20022.asic.rewrite.valuation.functions;

import cdm.base.math.functions.Abs;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.valuation.ASICValuationReport;
import drr.standards.iso.ValuationType1Code;
import iso20022.auth030.asic.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.asic.AmountAndDirection109__1;
import iso20022.auth030.asic.ContractValuationData8__1;
import iso20022.auth030.asic.CounterpartySpecificData36__3;
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
	@Inject protected Create_TradeCounterpartyReport20__3 create_TradeCounterpartyReport20__3;

	/**
	* @param drrReport 
	* @return ctrPtySpcfcData 
	*/
	public CounterpartySpecificData36__3 evaluate(ASICValuationReport drrReport) {
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

	protected abstract CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder doEvaluate(ASICValuationReport drrReport);

	public static class Create_CounterpartySpecificData36__3Default extends Create_CounterpartySpecificData36__3 {
		@Override
		protected CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder doEvaluate(ASICValuationReport drrReport) {
			CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder ctrPtySpcfcData = CounterpartySpecificData36__3.builder();
			return assignOutput(ctrPtySpcfcData, drrReport);
		}
		
		protected CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder assignOutput(CounterpartySpecificData36__3.CounterpartySpecificData36__3Builder ctrPtySpcfcData, ASICValuationReport drrReport) {
			Boolean ifThenElseResult = null;
			if (lessThan(MapperS.of(drrReport).<BigDecimal>map("getValuationAmount", aSICValuationReport -> aSICValuationReport.getValuationAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = false;
			}
			ctrPtySpcfcData = toBuilder(CounterpartySpecificData36__3.builder()
				.setCtrPty(create_TradeCounterpartyReport20__3.evaluate(drrReport))
				.setRptgTmStmp(MapperS.of(drrReport).<ZonedDateTime>map("getReportingTimestamp", aSICValuationReport -> aSICValuationReport.getReportingTimestamp()).get())
				.setValtn(ContractValuationData8__1.builder()
					.setCtrctVal(AmountAndDirection109__1.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
							.setValue(abs.evaluate(MapperS.of(drrReport).<BigDecimal>map("getValuationAmount", aSICValuationReport -> aSICValuationReport.getValuationAmount()).get()))
							.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getValuationCurrency", aSICValuationReport -> aSICValuationReport.getValuationCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
							.build())
						.setSgn(ifThenElseResult)
						.build())
					.setTmStmp(MapperS.of(drrReport).<ZonedDateTime>map("getValuationTimestamp", aSICValuationReport -> aSICValuationReport.getValuationTimestamp()).get())
					.setTp(MapperS.of(drrReport).<ValuationType1Code>map("getValuationMethod", aSICValuationReport -> aSICValuationReport.getValuationMethod()).checkedMap("to-enum", e -> iso20022.auth030.asic.ValuationType1Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.setDlta(MapperS.of(drrReport).<BigDecimal>map("getDelta", aSICValuationReport -> aSICValuationReport.getDelta()).get())
					.build())
				.build());
			
			return Optional.ofNullable(ctrPtySpcfcData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
