package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.tr.GenericIdentification175__1;
import iso20022.auth030.hkma.tr.LegalPersonIdentification1__4;
import iso20022.auth030.hkma.tr.OrganisationIdentification15Choice__5;
import iso20022.auth030.hkma.tr.OrganisationIdentification38__4;
import iso20022.auth030.hkma.tr.PartyIdentification248Choice__4;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_PartyIdentification248Choice__4.Create_PartyIdentification248Choice__4Default.class)
public abstract class Create_PartyIdentification248Choice__4 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return id 
	*/
	public PartyIdentification248Choice__4 evaluate(HKMATransactionReport drrReport) {
		PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder idBuilder = doEvaluate(drrReport);
		
		final PartyIdentification248Choice__4 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(PartyIdentification248Choice__4.class, id);
		}
		
		return id;
	}

	protected abstract PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder doEvaluate(HKMATransactionReport drrReport);

	public static class Create_PartyIdentification248Choice__4Default extends Create_PartyIdentification248Choice__4 {
		@Override
		protected PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder doEvaluate(HKMATransactionReport drrReport) {
			PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder id = PartyIdentification248Choice__4.builder();
			return assignOutput(id, drrReport);
		}
		
		protected PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder assignOutput(PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder id, HKMATransactionReport drrReport) {
			id = toBuilder(PartyIdentification248Choice__4.builder()
				.setLgl(LegalPersonIdentification1__4.builder()
					.setId(OrganisationIdentification15Choice__5.builder()
						.setOthr(OrganisationIdentification38__4.builder()
							.setId(GenericIdentification175__1.builder()
								.setId(MapperS.of(drrReport).<String>map("getBeneficiary", hKMATransactionReport -> hKMATransactionReport.getBeneficiary()).get())
								.build())
							.build())
						.build())
					.build())
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
