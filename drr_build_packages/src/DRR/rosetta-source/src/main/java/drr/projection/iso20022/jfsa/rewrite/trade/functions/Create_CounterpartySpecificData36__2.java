package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import cdm.base.math.functions.Abs;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import drr.standards.iso.ValuationType1Code;
import iso20022.auth030.jfsa.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.jfsa.AmountAndDirection109__1;
import iso20022.auth030.jfsa.ContractValuationData8__1;
import iso20022.auth030.jfsa.CounterpartySpecificData36__2;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_CounterpartySpecificData36__2.Create_CounterpartySpecificData36__2Default.class)
public abstract class Create_CounterpartySpecificData36__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;
	@Inject protected Create_TradeCounterpartyReport20__2 create_TradeCounterpartyReport20__2;

	/**
	* @param drrReport 
	* @return ctrPtySpcfcData 
	*/
	public CounterpartySpecificData36__2 evaluate(JFSATransactionReport drrReport) {
		CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder ctrPtySpcfcDataBuilder = doEvaluate(drrReport);
		
		final CounterpartySpecificData36__2 ctrPtySpcfcData;
		if (ctrPtySpcfcDataBuilder == null) {
			ctrPtySpcfcData = null;
		} else {
			ctrPtySpcfcData = ctrPtySpcfcDataBuilder.build();
			objectValidator.validate(CounterpartySpecificData36__2.class, ctrPtySpcfcData);
		}
		
		return ctrPtySpcfcData;
	}

	protected abstract CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder doEvaluate(JFSATransactionReport drrReport);

	public static class Create_CounterpartySpecificData36__2Default extends Create_CounterpartySpecificData36__2 {
		@Override
		protected CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder doEvaluate(JFSATransactionReport drrReport) {
			CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder ctrPtySpcfcData = CounterpartySpecificData36__2.builder();
			return assignOutput(ctrPtySpcfcData, drrReport);
		}
		
		protected CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder assignOutput(CounterpartySpecificData36__2.CounterpartySpecificData36__2Builder ctrPtySpcfcData, JFSATransactionReport drrReport) {
			Boolean ifThenElseResult = null;
			if (lessThan(MapperS.of(drrReport).<BigDecimal>map("getValuationAmount", jFSATransactionReport -> jFSATransactionReport.getValuationAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = false;
			}
			ctrPtySpcfcData = toBuilder(CounterpartySpecificData36__2.builder()
				.setCtrPty(create_TradeCounterpartyReport20__2.evaluate(drrReport))
				.setValtn(ContractValuationData8__1.builder()
					.setCtrctVal(AmountAndDirection109__1.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
							.setValue(abs.evaluate(MapperS.of(drrReport).<BigDecimal>map("getValuationAmount", jFSATransactionReport -> jFSATransactionReport.getValuationAmount()).get()))
							.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getValuationCurrency", jFSATransactionReport -> jFSATransactionReport.getValuationCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
							.build())
						.setSgn(ifThenElseResult)
						.build())
					.setTmStmp(MapperS.of(drrReport).<ZonedDateTime>map("getValuationTimestamp", jFSATransactionReport -> jFSATransactionReport.getValuationTimestamp()).get())
					.setTp(MapperS.of(drrReport).<ValuationType1Code>map("getValuationMethod", jFSATransactionReport -> jFSATransactionReport.getValuationMethod()).checkedMap("to-enum", e -> iso20022.auth030.jfsa.ValuationType1Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.setDlta(MapperS.of(drrReport).<BigDecimal>map("getDelta", jFSATransactionReport -> jFSATransactionReport.getDelta()).get())
					.build())
				.setRptgTmStmp(MapperS.of(drrReport).<ZonedDateTime>map("getReportingTimestamp", jFSATransactionReport -> jFSATransactionReport.getReportingTimestamp()).get())
				.build());
			
			return Optional.ofNullable(ctrPtySpcfcData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
