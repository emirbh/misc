package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.ActionTypeEnum;
import drr.standards.iso.ReportLevelEnum;
import iso20022.auth030.fca.ModificationLevel1Code;
import iso20022.auth030.fca.ModificationLevel1Code__1;
import iso20022.auth030.fca.TradeData42__1;
import iso20022.auth030.fca.TradeData42__2;
import iso20022.auth030.fca.TradeData42__3;
import iso20022.auth030.fca.TradeData42__4;
import iso20022.auth030.fca.TradeData42__5;
import iso20022.auth030.fca.TradeData42__6;
import iso20022.auth030.fca.TradeData42__7;
import iso20022.auth030.fca.TradeData42__8;
import iso20022.auth030.fca.TradeReport32Choice__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_TradeReport32Choice__1.Create_TradeReport32Choice__1Default.class)
public abstract class Create_TradeReport32Choice__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_CommonTradeDataReport69__1 create_CommonTradeDataReport69__1;
	@Inject protected Create_CommonTradeDataReport69__2 create_CommonTradeDataReport69__2;
	@Inject protected Create_CommonTradeDataReport69__3 create_CommonTradeDataReport69__3;
	@Inject protected Create_CommonTradeDataReport69__4 create_CommonTradeDataReport69__4;
	@Inject protected Create_CommonTradeDataReport69__5 create_CommonTradeDataReport69__5;
	@Inject protected Create_CommonTradeDataReport69__6 create_CommonTradeDataReport69__6;
	@Inject protected Create_CommonTradeDataReport69__7 create_CommonTradeDataReport69__7;
	@Inject protected Create_CounterpartySpecificData36__1 create_CounterpartySpecificData36__1;
	@Inject protected Create_CounterpartySpecificData36__2 create_CounterpartySpecificData36__2;
	@Inject protected Create_CounterpartySpecificData36__3 create_CounterpartySpecificData36__3;
	@Inject protected Create_CounterpartySpecificData36__4 create_CounterpartySpecificData36__4;
	@Inject protected Create_CounterpartySpecificData36__5 create_CounterpartySpecificData36__5;

	/**
	* @param drrReport 
	* @return rpt 
	*/
	public TradeReport32Choice__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
		TradeReport32Choice__1.TradeReport32Choice__1Builder rptBuilder = doEvaluate(drrReport);
		
		final TradeReport32Choice__1 rpt;
		if (rptBuilder == null) {
			rpt = null;
		} else {
			rpt = rptBuilder.build();
			objectValidator.validate(TradeReport32Choice__1.class, rpt);
		}
		
		return rpt;
	}

	protected abstract TradeReport32Choice__1.TradeReport32Choice__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	protected abstract MapperS<ActionTypeEnum> actionType(FCAUKEMIRTransactionReport drrReport);

	protected abstract MapperS<ReportLevelEnum> lvl(FCAUKEMIRTransactionReport drrReport);

	public static class Create_TradeReport32Choice__1Default extends Create_TradeReport32Choice__1 {
		@Override
		protected TradeReport32Choice__1.TradeReport32Choice__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			TradeReport32Choice__1.TradeReport32Choice__1Builder rpt = TradeReport32Choice__1.builder();
			return assignOutput(rpt, drrReport);
		}
		
		protected TradeReport32Choice__1.TradeReport32Choice__1Builder assignOutput(TradeReport32Choice__1.TradeReport32Choice__1Builder rpt, FCAUKEMIRTransactionReport drrReport) {
			TradeData42__1 ifThenElseResult0 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.NEWT), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = TradeData42__1.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__1.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport69__1.evaluate(drrReport))
					.setLvl(lvl(drrReport).checkedMap("to-enum", e -> ModificationLevel1Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.build();
			}
			TradeData42__2 ifThenElseResult1 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.MODI), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = TradeData42__2.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__2.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport69__2.evaluate(drrReport))
					.setLvl(lvl(drrReport).checkedMap("to-enum", e -> ModificationLevel1Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.build();
			}
			TradeData42__3 ifThenElseResult2 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.CORR), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = TradeData42__3.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__1.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport69__3.evaluate(drrReport))
					.setLvl(lvl(drrReport).checkedMap("to-enum", e -> ModificationLevel1Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.build();
			}
			TradeData42__4 ifThenElseResult3 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.TERM), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = TradeData42__4.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__3.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport69__4.evaluate(drrReport))
					.setLvl(lvl(drrReport).checkedMap("to-enum", e -> ModificationLevel1Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.build();
			}
			TradeData42__5 ifThenElseResult4 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.POSC), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = TradeData42__5.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__4.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport69__5.evaluate(drrReport))
					.setLvl(lvl(drrReport).checkedMap("to-enum", e -> ModificationLevel1Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
					.build();
			}
			TradeData42__6 ifThenElseResult5 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.VALU), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult5 = TradeData42__6.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__5.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport69__6.evaluate(drrReport))
					.setLvl(lvl(drrReport).checkedMap("to-enum", e -> ModificationLevel1Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.build();
			}
			TradeData42__7 ifThenElseResult6 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.EROR), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult6 = TradeData42__7.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__3.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport69__6.evaluate(drrReport))
					.setLvl(lvl(drrReport).checkedMap("to-enum", e -> ModificationLevel1Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.build();
			}
			TradeData42__8 ifThenElseResult7 = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.REVI), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult7 = TradeData42__8.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__1.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport69__7.evaluate(drrReport))
					.setLvl(lvl(drrReport).checkedMap("to-enum", e -> ModificationLevel1Code.valueOf(e.name()), IllegalArgumentException.class).get())
					.build();
			}
			rpt = toBuilder(TradeReport32Choice__1.builder()
				.setNew(ifThenElseResult0)
				.setMod(ifThenElseResult1)
				.setCrrctn(ifThenElseResult2)
				.setTermntn(ifThenElseResult3)
				.setPosCmpnt(ifThenElseResult4)
				.setValtnUpd(ifThenElseResult5)
				.setErr(ifThenElseResult6)
				.setRvv(ifThenElseResult7)
				.build());
			
			return Optional.ofNullable(rpt)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<ActionTypeEnum> actionType(FCAUKEMIRTransactionReport drrReport) {
			return MapperS.of(drrReport).<ActionTypeEnum>map("getActionType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getActionType());
		}
		
		@Override
		protected MapperS<ReportLevelEnum> lvl(FCAUKEMIRTransactionReport drrReport) {
			return MapperS.of(drrReport).<ReportLevelEnum>map("getLevel", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getLevel());
		}
	}
}
