package drr.regulation.asic.rewrite.margin.reports;

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


@ImplementedBy(TechnicalRecordIdRule.TechnicalRecordIdRuleDefault.class)
public abstract class TechnicalRecordIdRule implements ReportFunction<CollateralReportInstruction, String> {
	
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

	public static class TechnicalRecordIdRuleDefault extends TechnicalRecordIdRule {
		@Override
		protected String doEvaluate(CollateralReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, CollateralReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (MapperS.of(technicalRecordId.evaluate(item.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).get(), RegimeNameEnum.ASIC)).<Boolean>map("getIsUnique", _technicalRecordId -> _technicalRecordId.getIsUnique()).getOrDefault(false)) {
						return MapperS.of(technicalRecordId.evaluate(item.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).get(), RegimeNameEnum.ASIC)).<FieldWithMetaString>map("getId", _technicalRecordId -> _technicalRecordId.getId()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue());
					}
					return MapperMaths.<String, String, String>add(MapperMaths.<String, String, String>add(MapperS.of(technicalRecordId.evaluate(item.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).get(), RegimeNameEnum.ASIC)).<FieldWithMetaString>map("getId", _technicalRecordId -> _technicalRecordId.getId()).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), MapperS.of("_")), MapperS.of(reportingTimestampRule.evaluate(item.get())).map("to-string", Object::toString));
				}).get();
			
			return output;
		}
	}
}
