package drr.regulation.common.margin.collateral.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.margin.CollateralDetails;
import drr.regulation.common.CollateralReportInstruction;
import java.time.ZonedDateTime;


@ImplementedBy(CollateralTimestampRule.CollateralTimestampRuleDefault.class)
public abstract class CollateralTimestampRule implements ReportFunction<CollateralReportInstruction, ZonedDateTime> {

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public ZonedDateTime evaluate(CollateralReportInstruction input) {
		ZonedDateTime output = doEvaluate(input);
		
		return output;
	}

	protected abstract ZonedDateTime doEvaluate(CollateralReportInstruction input);

	public static class CollateralTimestampRuleDefault extends CollateralTimestampRule {
		@Override
		protected ZonedDateTime doEvaluate(CollateralReportInstruction input) {
			ZonedDateTime output = null;
			return assignOutput(output, input);
		}
		
		protected ZonedDateTime assignOutput(ZonedDateTime output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> item.<CollateralDetails>map("getCollateralDetails", collateralReportInstruction -> collateralReportInstruction.getCollateralDetails()).<ZonedDateTime>map("getCollateralTimestamp", collateralDetails -> collateralDetails.getCollateralTimestamp())).get();
			
			return output;
		}
	}
}
