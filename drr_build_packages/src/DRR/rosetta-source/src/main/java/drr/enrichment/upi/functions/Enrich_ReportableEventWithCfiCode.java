package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.regulation.common.ReportableEvent;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Enrich_ReportableEventWithCfiCode.Enrich_ReportableEventWithCfiCodeDefault.class)
public abstract class Enrich_ReportableEventWithCfiCode implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableEvent 
	* @param cfiCode 
	* @return enrichedReportableEvent 
	*/
	public ReportableEvent evaluate(ReportableEvent reportableEvent, String cfiCode) {
		ReportableEvent.ReportableEventBuilder enrichedReportableEventBuilder = doEvaluate(reportableEvent, cfiCode);
		
		final ReportableEvent enrichedReportableEvent;
		if (enrichedReportableEventBuilder == null) {
			enrichedReportableEvent = null;
		} else {
			enrichedReportableEvent = enrichedReportableEventBuilder.build();
			objectValidator.validate(ReportableEvent.class, enrichedReportableEvent);
		}
		
		return enrichedReportableEvent;
	}

	protected abstract ReportableEvent.ReportableEventBuilder doEvaluate(ReportableEvent reportableEvent, String cfiCode);

	public static class Enrich_ReportableEventWithCfiCodeDefault extends Enrich_ReportableEventWithCfiCode {
		@Override
		protected ReportableEvent.ReportableEventBuilder doEvaluate(ReportableEvent reportableEvent, String cfiCode) {
			ReportableEvent.ReportableEventBuilder enrichedReportableEvent = ReportableEvent.builder();
			return assignOutput(enrichedReportableEvent, reportableEvent, cfiCode);
		}
		
		protected ReportableEvent.ReportableEventBuilder assignOutput(ReportableEvent.ReportableEventBuilder enrichedReportableEvent, ReportableEvent reportableEvent, String cfiCode) {
			enrichedReportableEvent = toBuilder(reportableEvent, () -> ReportableEvent.builder());
			
			enrichedReportableEvent
				.getOrCreateOriginatingWorkflowStep()
				.getOrCreateBusinessEvent()
				.getOrCreateInstruction(0)
				.getOrCreateBefore().getOrCreateValue()
				.getOrCreateTrade()
				.getOrCreateProduct()
				.getOrCreateTaxonomy(0)
				.getOrCreateValue()
				.setName((cfiCode == null ? FieldWithMetaString.builder().build() : FieldWithMetaString.builder().setValue(cfiCode).build()));
			
			enrichedReportableEvent
				.getOrCreateOriginatingWorkflowStep()
				.getOrCreateBusinessEvent()
				.getOrCreateInstruction(0)
				.getOrCreateBefore().getOrCreateValue()
				.getOrCreateTrade()
				.getOrCreateProduct()
				.getOrCreateTaxonomy(0)
				.setSource(TaxonomySourceEnum.CFI);
			
			return Optional.ofNullable(enrichedReportableEvent)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
