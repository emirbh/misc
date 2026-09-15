package drr.enrichment.upi.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.regulation.common.ReportableEvent;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Enrich_ReportableEventWithUpi.Enrich_ReportableEventWithUpiDefault.class)
public abstract class Enrich_ReportableEventWithUpi implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Enrich_ReportableEventWithUpiFromAnnaDsb enrich_ReportableEventWithUpiFromAnnaDsb;

	/**
	* @param reportableEvent 
	* @param upiRecord 
	* @return reportableEventWithUpi 
	*/
	public ReportableEvent evaluate(ReportableEvent reportableEvent, AnnaDsbUpiRecord upiRecord) {
		ReportableEvent.ReportableEventBuilder reportableEventWithUpiBuilder = doEvaluate(reportableEvent, upiRecord);
		
		final ReportableEvent reportableEventWithUpi;
		if (reportableEventWithUpiBuilder == null) {
			reportableEventWithUpi = null;
		} else {
			reportableEventWithUpi = reportableEventWithUpiBuilder.build();
			objectValidator.validate(ReportableEvent.class, reportableEventWithUpi);
		}
		
		return reportableEventWithUpi;
	}

	protected abstract ReportableEvent.ReportableEventBuilder doEvaluate(ReportableEvent reportableEvent, AnnaDsbUpiRecord upiRecord);

	public static class Enrich_ReportableEventWithUpiDefault extends Enrich_ReportableEventWithUpi {
		@Override
		protected ReportableEvent.ReportableEventBuilder doEvaluate(ReportableEvent reportableEvent, AnnaDsbUpiRecord upiRecord) {
			ReportableEvent.ReportableEventBuilder reportableEventWithUpi = ReportableEvent.builder();
			return assignOutput(reportableEventWithUpi, reportableEvent, upiRecord);
		}
		
		protected ReportableEvent.ReportableEventBuilder assignOutput(ReportableEvent.ReportableEventBuilder reportableEventWithUpi, ReportableEvent reportableEvent, AnnaDsbUpiRecord upiRecord) {
			reportableEventWithUpi = toBuilder(enrich_ReportableEventWithUpiFromAnnaDsb.evaluate(reportableEvent, upiRecord, null));
			
			return Optional.ofNullable(reportableEventWithUpi)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
