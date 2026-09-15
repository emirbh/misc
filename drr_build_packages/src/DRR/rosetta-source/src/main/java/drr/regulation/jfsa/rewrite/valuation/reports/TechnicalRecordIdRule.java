package drr.regulation.jfsa.rewrite.valuation.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ValuationReportInstruction;
import drr.regulation.common.trade.link.functions.TechnicalRecordId;
import drr.regulation.common.valuation.datetime.reports.ReportingTimestampRule;
import javax.inject.Inject;


@ImplementedBy(TechnicalRecordIdRule.TechnicalRecordIdRuleDefault.class)
public abstract class TechnicalRecordIdRule implements ReportFunction<ValuationReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected TechnicalRecordId technicalRecordId;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(ValuationReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(ValuationReportInstruction input);

	public static class TechnicalRecordIdRuleDefault extends TechnicalRecordIdRule {
		@Override
		protected String doEvaluate(ValuationReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, ValuationReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (MapperS.of(technicalRecordId.evaluate(item.<ReportableInformation>map("getReportableInformation", valuationReportInstruction -> valuationReportInstruction.getReportableInformation()).get(), RegimeNameEnum.JFSA)).<Boolean>map("getIsUnique", _technicalRecordId -> _technicalRecordId.getIsUnique()).getOrDefault(false)) {
						return MapperS.of(technicalRecordId.evaluate(item.<ReportableInformation>map("getReportableInformation", valuationReportInstruction -> valuationReportInstruction.getReportableInformation()).get(), RegimeNameEnum.JFSA)).<FieldWithMetaString>map("getId", _technicalRecordId -> _technicalRecordId.getId()).<String>map("Type coercion", fieldWithMetaString0 -> fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue());
					}
					return MapperMaths.<String, String, String>add(MapperMaths.<String, String, String>add(MapperS.of(technicalRecordId.evaluate(item.<ReportableInformation>map("getReportableInformation", valuationReportInstruction -> valuationReportInstruction.getReportableInformation()).get(), RegimeNameEnum.JFSA)).<FieldWithMetaString>map("getId", _technicalRecordId -> _technicalRecordId.getId()).<String>map("Type coercion", fieldWithMetaString1 -> fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()), MapperS.of("_")), MapperS.of(reportingTimestampRule.evaluate(item.get())).map("to-string", Object::toString));
				}).get();
			
			return output;
		}
	}
}
