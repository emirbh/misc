package drr.regulation.fca.ukemir.refit.trade.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetVenueOfExecution;
import drr.standards.iso.MicData;
import drr.standards.iso.functions.GetOrFetchMicData;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ReportTrackingNumberRule.ReportTrackingNumberRuleDefault.class)
public abstract class ReportTrackingNumberRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetOrFetchMicData getOrFetchMicData;
	@Inject protected GetVenueOfExecution getVenueOfExecution;
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected drr.regulation.common.emir.reports.ReportTrackingNumberRule reportTrackingNumberRule;

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
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(getOrFetchMicData.evaluate(item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformation -> reportableInformation.getEnrichment()).<MicData>mapC("getMicData", enrichmentData -> enrichmentData.getMicData()).getMulti(), getVenueOfExecution.evaluate(item.<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).get()))).<String>map("getCountryCode", micData -> micData.getCountryCode()), MapperS.of("GB"), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(reportTrackingNumberRule.evaluate(item.get()));
					}
					return MapperS.<String>ofNull();
				}).get();
			
			return output;
		}
	}
}
