package drr.enrichment.common.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.enrichment.common.EnrichmentData;
import drr.regulation.common.CollateralReportInstruction;
import drr.regulation.common.ReportableInformation;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(CollateralEnrichmentDataRule.CollateralEnrichmentDataRuleDefault.class)
public abstract class CollateralEnrichmentDataRule implements ReportFunction<CollateralReportInstruction, EnrichmentData> {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public EnrichmentData evaluate(CollateralReportInstruction input) {
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

	protected abstract EnrichmentData.EnrichmentDataBuilder doEvaluate(CollateralReportInstruction input);

	public static class CollateralEnrichmentDataRuleDefault extends CollateralEnrichmentDataRule {
		@Override
		protected EnrichmentData.EnrichmentDataBuilder doEvaluate(CollateralReportInstruction input) {
			EnrichmentData.EnrichmentDataBuilder output = EnrichmentData.builder();
			return assignOutput(output, input);
		}
		
		protected EnrichmentData.EnrichmentDataBuilder assignOutput(EnrichmentData.EnrichmentDataBuilder output, CollateralReportInstruction input) {
			output = toBuilder(MapperS.of(input)
				.mapSingleToItem(item -> item.<ReportableInformation>map("getReportableInformation", collateralReportInstruction -> collateralReportInstruction.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformation -> reportableInformation.getEnrichment())).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
