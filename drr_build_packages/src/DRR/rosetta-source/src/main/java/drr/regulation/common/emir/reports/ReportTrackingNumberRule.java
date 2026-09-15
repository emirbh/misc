package drr.regulation.common.emir.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.PositionForEvent;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.emir.functions.IsMicXOFF;
import drr.regulation.common.emir.functions.IsMicXXXX;
import drr.regulation.common.functions.GetReportTrackingNumber;
import drr.regulation.common.functions.GetVenueOfExecution;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ReportTrackingNumberRule.ReportTrackingNumberRuleDefault.class)
public abstract class ReportTrackingNumberRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetReportTrackingNumber getReportTrackingNumber;
	@Inject protected GetVenueOfExecution getVenueOfExecution;
	@Inject protected IsMicXOFF isMicXOFF;
	@Inject protected IsMicXXXX isMicXXXX;
	@Inject protected PositionForEvent positionForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class ReportTrackingNumberRuleDefault extends ReportTrackingNumberRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (exists(MapperS.of(getVenueOfExecution.evaluate(item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get()))).andNullSafe(notExists(MapperS.of(positionForEvent.evaluate(item.get())))).andNullSafe(areEqual(MapperS.of(isMicXOFF.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(isMicXXXX.evaluate(item.get())), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
						return MapperS.of(getReportTrackingNumber.evaluate(item.get()));
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
