package drr.projection.iso20022.fca.ukemir.refit.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import iso20022.auth030.fca.GenericIdentification175__2;
import iso20022.auth030.fca.LegalPersonIdentification1__1;
import iso20022.auth030.fca.NaturalPersonIdentification2__1;
import iso20022.auth030.fca.NaturalPersonIdentification3__1;
import iso20022.auth030.fca.PartyIdentification248Choice__2;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_PartyIdentification248Choice__2.Create_PartyIdentification248Choice__2Default.class)
public abstract class Create_PartyIdentification248Choice__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__1 create_OrganisationIdentification15Choice__1;

	/**
	* @param drrReport 
	* @return id 
	*/
	public PartyIdentification248Choice__2 evaluate(FCAValuationReport drrReport) {
		PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder idBuilder = doEvaluate(drrReport);
		
		final PartyIdentification248Choice__2 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(PartyIdentification248Choice__2.class, id);
		}
		
		return id;
	}

	protected abstract PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder doEvaluate(FCAValuationReport drrReport);

	public static class Create_PartyIdentification248Choice__2Default extends Create_PartyIdentification248Choice__2 {
		@Override
		protected PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder doEvaluate(FCAValuationReport drrReport) {
			PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder id = PartyIdentification248Choice__2.builder();
			return assignOutput(id, drrReport);
		}
		
		protected PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder assignOutput(PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder id, FCAValuationReport drrReport) {
			LegalPersonIdentification1__1 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", fCAValuationReport -> fCAValuationReport.getCounterparty2IdentifierType()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = LegalPersonIdentification1__1.builder()
					.setId(create_OrganisationIdentification15Choice__1.evaluate(MapperS.of(drrReport).<String>map("getCounterparty2", fCAValuationReport -> fCAValuationReport.getCounterparty2()).get()))
					.build();
			}
			NaturalPersonIdentification3__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", fCAValuationReport -> fCAValuationReport.getCounterparty2IdentifierType()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = NaturalPersonIdentification3__1.builder()
					.setId(NaturalPersonIdentification2__1.builder()
						.setId(GenericIdentification175__2.builder()
							.setId(MapperS.of(drrReport).<String>map("getCounterparty2", fCAValuationReport -> fCAValuationReport.getCounterparty2()).get())
							.build())
						.build())
					.setCtry(null)
					.build();
			}
			id = toBuilder(PartyIdentification248Choice__2.builder()
				.setLgl(ifThenElseResult0)
				.setNtrl(ifThenElseResult1)
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
