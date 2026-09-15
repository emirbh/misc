package drr.ingest.fpml.recordkeeping.reportableinfo.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.event.ReportableActionEnum;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapReportableActionEnum.MapReportableActionEnumDefault.class)
public abstract class MapReportableActionEnum implements RosettaFunction {

	/**
	* @param reason 
	* @return reportableAction 
	*/
	public ReportableActionEnum evaluate(String reason) {
		ReportableActionEnum reportableAction = doEvaluate(reason);
		
		return reportableAction;
	}

	protected abstract ReportableActionEnum doEvaluate(String reason);

	public static class MapReportableActionEnumDefault extends MapReportableActionEnum {
		@Override
		protected ReportableActionEnum doEvaluate(String reason) {
			ReportableActionEnum reportableAction = null;
			return assignOutput(reportableAction, reason);
		}
		
		protected ReportableActionEnum assignOutput(ReportableActionEnum reportableAction, String reason) {
			final MapperS<String> switchArgument = MapperS.of(reason);
			if (switchArgument.get() == null) {
				reportableAction = null;
			} else if (areEqual(switchArgument, MapperS.of("RaisedInError"), CardinalityOperator.All).get()) {
				reportableAction = ReportableActionEnum.ERROR;
			} else {
				reportableAction = null;
			}
			
			return reportableAction;
		}
	}
}
