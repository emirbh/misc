package drr.regulation.asic.rewrite.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.MapperMaths;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.link.functions.TechnicalRecordId;
import drr.standards.iosco.cde.version3.datetime.reports.ReportingTimestampRule;
import javax.inject.Inject;


@ImplementedBy(TechnicalRecordIdRule.TechnicalRecordIdRuleDefault.class)
public abstract class TechnicalRecordIdRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected ReportingTimestampRule reportingTimestampRule;
	@Inject protected TechnicalRecordId technicalRecordId;

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

	public static class TechnicalRecordIdRuleDefault extends TechnicalRecordIdRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			output = MapperS.of(input)
				.mapSingleToItem(ReportableEvent -> {
					if (MapperS.of(technicalRecordId.evaluate(MapperS.of(input).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get(), RegimeNameEnum.ASIC)).<Boolean>map("getIsUnique", _technicalRecordId -> _technicalRecordId.getIsUnique()).getOrDefault(false)) {
						return MapperS.of(technicalRecordId.evaluate(MapperS.of(input).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get(), RegimeNameEnum.ASIC)).<FieldWithMetaString>map("getId", _technicalRecordId -> _technicalRecordId.getId()).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString == null ? null : fieldWithMetaString.getValue());
					}
					final MapperS<FieldWithMetaString> thenArg = MapperS.of(technicalRecordId.evaluate(MapperS.of(input).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get(), RegimeNameEnum.ASIC)).<FieldWithMetaString>map("getId", _technicalRecordId -> _technicalRecordId.getId());
					return thenArg
						.mapSingleToItem(item -> MapperMaths.<String, String, String>add(MapperMaths.<String, String, String>add(item.<String>map("Type coercion", _fieldWithMetaString -> _fieldWithMetaString == null ? null : _fieldWithMetaString.getValue()), MapperS.of("_")), MapperS.of(reportingTimestampRule.evaluate(ReportableEvent.get())).map("to-string", Object::toString)));
				}).get();
			
			return output;
		}
	}
}
