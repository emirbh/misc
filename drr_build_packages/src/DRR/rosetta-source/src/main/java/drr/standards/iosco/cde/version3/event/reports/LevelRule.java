package drr.standards.iosco.cde.version3.event.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.PositionForEvent;
import drr.base.trade.functions.TradeForEvent;
import drr.standards.iso.ReportLevelEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(LevelRule.LevelRuleDefault.class)
public abstract class LevelRule implements ReportFunction<ReportableEventBase, ReportLevelEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected PositionForEvent positionForEvent;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ReportLevelEnum evaluate(ReportableEventBase input) {
		ReportLevelEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract ReportLevelEnum doEvaluate(ReportableEventBase input);

	public static class LevelRuleDefault extends LevelRule {
		@Override
		protected ReportLevelEnum doEvaluate(ReportableEventBase input) {
			ReportLevelEnum output = null;
			return assignOutput(output, input);
		}
		
		protected ReportLevelEnum assignOutput(ReportLevelEnum output, ReportableEventBase input) {
			if (exists(MapperS.of(tradeForEvent.evaluate(input))).getOrDefault(false)) {
				output = MapperS.of(input)
					.mapSingleToItem(item -> MapperS.of(ReportLevelEnum.TCTN)).get();
			} else if (exists(MapperS.of(positionForEvent.evaluate(input))).getOrDefault(false)) {
				output = MapperS.of(input)
					.mapSingleToItem(item -> MapperS.of(ReportLevelEnum.PSTN)).get();
			} else {
				output = null;
			}
			
			return output;
		}
	}
}
