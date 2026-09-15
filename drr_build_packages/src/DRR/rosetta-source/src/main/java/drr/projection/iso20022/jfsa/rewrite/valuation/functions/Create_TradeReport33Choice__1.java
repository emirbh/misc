package drr.projection.iso20022.jfsa.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.valuation.JFSAValuationReport;
import drr.standards.iso.ActionTypeEnum;
import iso20022.auth030.jfsa.TradeData43__5;
import iso20022.auth030.jfsa.TradeReport33Choice__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_TradeReport33Choice__1.Create_TradeReport33Choice__1Default.class)
public abstract class Create_TradeReport33Choice__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_CommonTradeDataReport71__5 create_CommonTradeDataReport71__5;
	@Inject protected Create_CounterpartySpecificData36__2 create_CounterpartySpecificData36__2;
	@Inject protected Create_TechnicalAttributes5__1 create_TechnicalAttributes5__1;

	/**
	* @param drrReport 
	* @return rpt 
	*/
	public TradeReport33Choice__1 evaluate(JFSAValuationReport drrReport) {
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

	protected abstract TradeReport33Choice__1.TradeReport33Choice__1Builder doEvaluate(JFSAValuationReport drrReport);

	protected abstract MapperS<ActionTypeEnum> actionType(JFSAValuationReport drrReport);

	public static class Create_TradeReport33Choice__1Default extends Create_TradeReport33Choice__1 {
		@Override
		protected TradeReport33Choice__1.TradeReport33Choice__1Builder doEvaluate(JFSAValuationReport drrReport) {
			TradeReport33Choice__1.TradeReport33Choice__1Builder rpt = TradeReport33Choice__1.builder();
			return assignOutput(rpt, drrReport);
		}
		
		protected TradeReport33Choice__1.TradeReport33Choice__1Builder assignOutput(TradeReport33Choice__1.TradeReport33Choice__1Builder rpt, JFSAValuationReport drrReport) {
			TradeData43__5 ifThenElseResult = null;
			if (areEqual(actionType(drrReport), MapperS.of(ActionTypeEnum.VALU), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = TradeData43__5.builder()
					.setCtrPtySpcfcData(create_CounterpartySpecificData36__2.evaluate(drrReport))
					.setCmonTradData(create_CommonTradeDataReport71__5.evaluate(drrReport))
					.setTechAttrbts(create_TechnicalAttributes5__1.evaluate(drrReport))
					.build();
			}
			rpt = toBuilder(TradeReport33Choice__1.builder()
				.setValtnUpd(ifThenElseResult)
				.build());
			
			return Optional.ofNullable(rpt)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<ActionTypeEnum> actionType(JFSAValuationReport drrReport) {
			return MapperS.of(drrReport).<ActionTypeEnum>map("getActionType", jFSAValuationReport -> jFSAValuationReport.getActionType());
		}
	}
}
