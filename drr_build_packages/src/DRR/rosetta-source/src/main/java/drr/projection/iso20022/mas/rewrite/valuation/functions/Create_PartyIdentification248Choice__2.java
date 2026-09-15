package drr.projection.iso20022.mas.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.valuation.MASValuationReport;
import iso20022.auth030.mas.GenericIdentification175__1;
import iso20022.auth030.mas.LegalPersonIdentification1__2;
import iso20022.auth030.mas.NaturalPersonIdentification2__1;
import iso20022.auth030.mas.NaturalPersonIdentification3__1;
import iso20022.auth030.mas.PartyIdentification248Choice__2;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_PartyIdentification248Choice__2.Create_PartyIdentification248Choice__2Default.class)
public abstract class Create_PartyIdentification248Choice__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__2 create_OrganisationIdentification15Choice__2;

	/**
	* @param drrReport 
	* @return id 
	*/
	public PartyIdentification248Choice__2 evaluate(MASValuationReport drrReport) {
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

	protected abstract PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder doEvaluate(MASValuationReport drrReport);

	public static class Create_PartyIdentification248Choice__2Default extends Create_PartyIdentification248Choice__2 {
		@Override
		protected PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder doEvaluate(MASValuationReport drrReport) {
			PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder id = PartyIdentification248Choice__2.builder();
			return assignOutput(id, drrReport);
		}
		
		protected PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder assignOutput(PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder id, MASValuationReport drrReport) {
			LegalPersonIdentification1__2 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", mASValuationReport -> mASValuationReport.getCounterparty2IdentifierType()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = LegalPersonIdentification1__2.builder()
					.setId(create_OrganisationIdentification15Choice__2.evaluate(MapperS.of(drrReport).<String>map("getCounterparty2", mASValuationReport -> mASValuationReport.getCounterparty2()).get()))
					.build();
			}
			NaturalPersonIdentification3__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", mASValuationReport -> mASValuationReport.getCounterparty2IdentifierType()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = NaturalPersonIdentification3__1.builder()
					.setId(NaturalPersonIdentification2__1.builder()
						.setId(GenericIdentification175__1.builder()
							.setId(MapperS.of(drrReport).<String>map("getCounterparty2", mASValuationReport -> mASValuationReport.getCounterparty2()).get())
							.build())
						.build())
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
