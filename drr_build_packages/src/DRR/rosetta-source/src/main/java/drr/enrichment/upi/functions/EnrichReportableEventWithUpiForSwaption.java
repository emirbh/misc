package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.common.ProductIdTypeEnum;
import cdm.base.staticdata.asset.common.ProductIdentifier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.ReportableEvent;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(EnrichReportableEventWithUpiForSwaption.EnrichReportableEventWithUpiForSwaptionDefault.class)
public abstract class EnrichReportableEventWithUpiForSwaption implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportableEvent 
	* @param upi 
	* @return enrichedReportableEvent 
	*/
	public ReportableEvent evaluate(ReportableEvent reportableEvent, String upi) {
		ReportableEvent.ReportableEventBuilder enrichedReportableEventBuilder = doEvaluate(reportableEvent, upi);
		
		final ReportableEvent enrichedReportableEvent;
		if (enrichedReportableEventBuilder == null) {
			enrichedReportableEvent = null;
		} else {
			enrichedReportableEvent = enrichedReportableEventBuilder.build();
			objectValidator.validate(ReportableEvent.class, enrichedReportableEvent);
		}
		
		return enrichedReportableEvent;
	}

	protected abstract ReportableEvent.ReportableEventBuilder doEvaluate(ReportableEvent reportableEvent, String upi);

	protected abstract MapperS<? extends ProductIdentifier> addProductIdentifier(ReportableEvent reportableEvent, String upi);

	public static class EnrichReportableEventWithUpiForSwaptionDefault extends EnrichReportableEventWithUpiForSwaption {
		@Override
		protected ReportableEvent.ReportableEventBuilder doEvaluate(ReportableEvent reportableEvent, String upi) {
			ReportableEvent.ReportableEventBuilder enrichedReportableEvent = ReportableEvent.builder();
			return assignOutput(enrichedReportableEvent, reportableEvent, upi);
		}
		
		protected ReportableEvent.ReportableEventBuilder assignOutput(ReportableEvent.ReportableEventBuilder enrichedReportableEvent, ReportableEvent reportableEvent, String upi) {
			enrichedReportableEvent = toBuilder(reportableEvent, () -> ReportableEvent.builder());
			
			enrichedReportableEvent
				.getOrCreateOriginatingWorkflowStep()
				.getOrCreateBusinessEvent()
				.getOrCreateInstruction(0)
				.getOrCreateBefore().getOrCreateValue()
				.getOrCreateTrade()
				.getOrCreateProduct()
				.getOrCreateEconomicTerms()
				.getOrCreatePayout(0)
				.getOrCreateOptionPayout()
				.getOrCreateUnderlier()
				.getOrCreateProduct()
				.getOrCreateNonTransferableProduct()
				.addIdentifier(addProductIdentifier(reportableEvent, upi).getMulti());
			
			enrichedReportableEvent
				.getOrCreateOriginatingWorkflowStep()
				.getOrCreateBusinessEvent()
				.getOrCreateAfter(0)
				.getOrCreateTrade()
				.getOrCreateProduct()
				.getOrCreateEconomicTerms()
				.getOrCreatePayout(0)
				.getOrCreateOptionPayout()
				.getOrCreateUnderlier()
				.getOrCreateProduct()
				.getOrCreateNonTransferableProduct()
				.addIdentifier(addProductIdentifier(reportableEvent, upi).getMulti());
			
			return Optional.ofNullable(enrichedReportableEvent)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ProductIdentifier> addProductIdentifier(ReportableEvent reportableEvent, String upi) {
			return MapperS.of(ProductIdentifier.builder()
				.setIdentifierValue(upi)
				.setSource(ProductIdTypeEnum.UPI)
				.build());
		}
	}
}
