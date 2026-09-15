package drr.regulation.cftc.rewrite.margin.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.margin.datetime.reports.ReportingTimestampRule;
import drr.regulation.common.trade.link.functions.TechnicalRecordId;
import javax.inject.Inject;


@ImplementedBy(DTCC_MessageIDRule.DTCC_MessageIDRuleDefault.class)
public abstract class DTCC_MessageIDRule implements ReportFunction<CollateralReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected TechnicalRecordId technicalRecordId;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(CollateralReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(CollateralReportInstruction input);

	public static class DTCC_MessageIDRuleDefault extends DTCC_MessageIDRule {
		@Override
		protected String doEvaluate(CollateralReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (MapperS.of(technicalRecordId.evaluate(item.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).get(), RegimeNameEnum.DODD_FRANK_ACT)).<Boolean>map("getIsUnique", _technicalRecordId -> _technicalRecordId.getIsUnique()).getOrDefault(false)) {
						return MapperS.of(technicalRecordId.evaluate(item.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).get(), RegimeNameEnum.DODD_FRANK_ACT)).<FieldWithMetaString>map("getId", _technicalRecordId -> _technicalRecordId.getId()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue());
					}
					return MapperMaths.<String, String, String>add(MapperS.of(technicalRecordId.evaluate(item.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).get(), RegimeNameEnum.DODD_FRANK_ACT)).<FieldWithMetaString>map("getId", _technicalRecordId -> _technicalRecordId.getId()).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), MapperS.of(reportingTimestampRule.evaluate(item.get())).map("to-string", Object::toString));
				}).get();
			
			return output;
		}
	}
}
