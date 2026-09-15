package drr.enrichment.common.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ValuationReportInstruction;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(ValuationEnrichmentDataRule.ValuationEnrichmentDataRuleDefault.class)
public abstract class ValuationEnrichmentDataRule implements ReportFunction<ValuationReportInstruction, EnrichmentData> {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public EnrichmentData evaluate(ValuationReportInstruction input) {
		EnrichmentData.EnrichmentDataBuilder outputBuilder = doEvaluate(input);
		
		final EnrichmentData output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(EnrichmentData.class, output);
		}
		
		return output;
	}

	protected abstract EnrichmentData.EnrichmentDataBuilder doEvaluate(ValuationReportInstruction input);

	public static class ValuationEnrichmentDataRuleDefault extends ValuationEnrichmentDataRule {
		@Override
		protected EnrichmentData.EnrichmentDataBuilder doEvaluate(ValuationReportInstruction input) {
			EnrichmentData.EnrichmentDataBuilder output = EnrichmentData.builder();
			return assignOutput(output, input);
		}
		
		protected EnrichmentData.EnrichmentDataBuilder assignOutput(EnrichmentData.EnrichmentDataBuilder output, ValuationReportInstruction input) {
			output = toBuilder(MapperS.of(input)
				.mapSingleToItem(item -> item.<ReportableInformation>map("getReportableInformation", valuationReportInstruction -> valuationReportInstruction.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformation -> reportableInformation.getEnrichment())).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
