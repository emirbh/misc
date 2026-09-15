package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import iso20022.auth030.mas.TradeData43__1;
import iso20022.auth030.mas.TradeData43__2;
import iso20022.auth030.mas.TradeData43__3;
import iso20022.auth030.mas.TradeData43__4;
import iso20022.auth030.mas.TradeData43__5;
import iso20022.auth030.mas.TradeData43__6;
import iso20022.auth030.mas.TradeData43__7;
import iso20022.auth030.mas.TradeReport33Choice__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_TradeReport33Choice__1.Create_TradeReport33Choice__1Default.class)
public abstract class Create_TradeReport33Choice__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_CommonTradeDataReport71__1 create_CommonTradeDataReport71__1;
	@Inject protected Create_CommonTradeDataReport71__2 create_CommonTradeDataReport71__2;
	@Inject protected Create_CommonTradeDataReport71__3 create_CommonTradeDataReport71__3;
	@Inject protected Create_CommonTradeDataReport71__4 create_CommonTradeDataReport71__4;
	@Inject protected Create_CommonTradeDataReport71__5 create_CommonTradeDataReport71__5;
	@Inject protected Create_CommonTradeDataReport71__6 create_CommonTradeDataReport71__6;
	@Inject protected Create_CommonTradeDataReport71__7 create_CommonTradeDataReport71__7;
	@Inject protected Create_CounterpartySpecificData36__1 create_CounterpartySpecificData36__1;
	@Inject protected Create_CounterpartySpecificData36__2 create_CounterpartySpecificData36__2;
	@Inject protected Create_CounterpartySpecificData36__3 create_CounterpartySpecificData36__3;
	@Inject protected Create_TechnicalAttributes5__1 create_TechnicalAttributes5__1;

	/**
	* @param drrReport 
	* @return rpt 
	*/
	public TradeReport33Choice__1 evaluate(MASTransactionReport drrReport) {
		TradeReport33Choice__1.TradeReport33Choice__1Builder rptBuilder = doEvaluate(drrReport);
		
		final TradeReport33Choice__1 rpt;
		if (rptBuilder == null) {
			rpt = null;
		} else {
			rpt = rptBuilder.build();
			objectValidator.validate(TradeReport33Choice__1.class, rpt);
		}
		
		return rpt;
	}

	protected abstract TradeReport33Choice__1.TradeReport33Choice__1Builder doEvaluate(MASTransactionReport drrReport);

	protected abstract MapperS<ActionTypeEnum> actionType(MASTransactionReport drrReport);

	public static class Create_TradeReport33Choice__1Default extends Create_TradeReport33Choice__1 {
		@Override
		protected TradeReport33Choice__1.TradeReport33Choice__1Builder doEvaluate(MASTransactionReport drrReport) {
			TradeReport33Choice__1.TradeReport33Choice__1Builder rpt = TradeReport33Choice__1.builder();
			return assignOutput(rpt, drrReport);
		}
		
		protected TradeReport33Choice__1.TradeReport33Choice__1Builder assignOutput(TradeReport33Choice__1.TradeReport33Choice__1Builder rpt, MASTransactionReport drrReport) {
			TradeData43__1 ifThenElseResult0 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = TradeData43__1.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__1.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport71__1.evaluate(drrReport))
					.setTechAttrbts(create_TechnicalAttributes5__1.evaluate(drrReport))
					.build();
			}
			TradeData43__2 ifThenElseResult1 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.MODI), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = TradeData43__2.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__1.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport71__2.evaluate(drrReport))
					.setTechAttrbts(create_TechnicalAttributes5__1.evaluate(drrReport))
					.build();
			}
			TradeData43__3 ifThenElseResult2 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.CORR), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = TradeData43__3.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__1.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport71__3.evaluate(drrReport))
					.setTechAttrbts(create_TechnicalAttributes5__1.evaluate(drrReport))
					.build();
			}
			TradeData43__4 ifThenElseResult3 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = TradeData43__4.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__2.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport71__4.evaluate(drrReport))
					.setTechAttrbts(create_TechnicalAttributes5__1.evaluate(drrReport))
					.build();
			}
			TradeData43__5 ifThenElseResult4 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.VALU), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = TradeData43__5.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__3.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport71__5.evaluate(drrReport))
					.setTechAttrbts(create_TechnicalAttributes5__1.evaluate(drrReport))
					.build();
			}
			TradeData43__6 ifThenElseResult5 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.EROR), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult5 = TradeData43__6.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__2.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport71__6.evaluate(drrReport))
					.setTechAttrbts(create_TechnicalAttributes5__1.evaluate(drrReport))
					.build();
			}
			TradeData43__3 ifThenElseResult6 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.REVI), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult6 = TradeData43__3.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__1.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport71__3.evaluate(drrReport))
					.setTechAttrbts(create_TechnicalAttributes5__1.evaluate(drrReport))
					.build();
			}
			TradeData43__7 ifThenElseResult7 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.PRTO), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult7 = TradeData43__7.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__2.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport71__7.evaluate(drrReport))
					.setTechAttrbts(create_TechnicalAttributes5__1.evaluate(drrReport))
					.build();
			}
			rpt = toBuilder(TradeReport33Choice__1.builder()
				.setNew(ifThenElseResult0)
				.setMod(ifThenElseResult1)
				.setCrrctn(ifThenElseResult2)
				.setTermntn(ifThenElseResult3)
				.setValtnUpd(ifThenElseResult4)
				.setErr(ifThenElseResult5)
				.setRvv(ifThenElseResult6)
				.setPortOut(ifThenElseResult7)
				.build());
			
			return Optional.ofNullable(rpt)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<ActionTypeEnum> actionType(MASTransactionReport drrReport) {
			return MapperS.of(drrReport).<ActionTypeEnum>map("getActionType", mASTransactionReport -> mASTransactionReport.getActionType());
		}
	}
}
