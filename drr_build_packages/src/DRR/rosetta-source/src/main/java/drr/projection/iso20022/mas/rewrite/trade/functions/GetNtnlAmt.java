package drr.projection.iso20022.mas.rewrite.trade.functions;

import cdm.base.math.functions.Abs;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import iso20022.auth030.mas.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.mas.AmountAndDirection106__2;
import iso20022.auth030.mas.NotionalAmount5__1;
import iso20022.auth030.mas.NotionalAmount6__1;
import iso20022.auth030.mas.NotionalAmountLegs5__1;
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
	public NotionalAmountLegs5__1 evaluate(MASTransactionReport drrReport) {
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

	protected abstract NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder doEvaluate(MASTransactionReport drrReport);

	public static class GetNtnlAmtDefault extends GetNtnlAmt {
		@Override
		protected NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder doEvaluate(MASTransactionReport drrReport) {
			NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder ntnlAmt = NotionalAmountLegs5__1.builder();
			return assignOutput(ntnlAmt, drrReport);
		}
		
		protected NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder assignOutput(NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder ntnlAmt, MASTransactionReport drrReport) {
			Boolean ifThenElseResult0 = null;
			if (lessThan(MapperS.of(drrReport).<CommonLeg>map("getLeg1", mASTransactionReport -> mASTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = false;
			}
			Boolean ifThenElseResult1 = null;
			if (lessThan(MapperS.of(drrReport).<CommonLeg>map("getLeg2", mASTransactionReport -> mASTransactionReport.getLeg2()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = false;
			}
			ntnlAmt = toBuilder(NotionalAmountLegs5__1.builder()
				.setFrstLeg(NotionalAmount5__1.builder()
					.setAmt(AmountAndDirection106__2.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
							.setValue(abs.evaluate(MapperS.of(drrReport).<CommonLeg>map("getLeg1", mASTransactionReport -> mASTransactionReport.getLeg1()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()).get()))
							.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg1", mASTransactionReport -> mASTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
							.build())
						.setSgn(ifThenElseResult0)
						.build())
					.build())
				.setScndLeg(NotionalAmount6__1.builder()
					.setAmt(AmountAndDirection106__2.builder()
						.setAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
							.setValue(abs.evaluate(MapperS.of(drrReport).<CommonLeg>map("getLeg2", mASTransactionReport -> mASTransactionReport.getLeg2()).<BigDecimal>map("getNotionalAmount", commonLeg -> commonLeg.getNotionalAmount()).get()))
							.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg2", mASTransactionReport -> mASTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
							.build())
						.setSgn(ifThenElseResult1)
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(ntnlAmt)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
