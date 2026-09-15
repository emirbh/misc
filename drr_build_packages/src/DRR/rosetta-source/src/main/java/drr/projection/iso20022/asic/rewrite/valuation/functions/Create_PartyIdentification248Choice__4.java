package drr.projection.iso20022.asic.rewrite.valuation.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.valuation.ASICValuationReport;
import iso20022.auth030.asic.GenericIdentification175__1;
import iso20022.auth030.asic.LegalPersonIdentification1__4;
import iso20022.auth030.asic.NaturalPersonIdentification2__1;
import iso20022.auth030.asic.NaturalPersonIdentification3__3;
import iso20022.auth030.asic.PartyIdentification248Choice__4;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_PartyIdentification248Choice__4.Create_PartyIdentification248Choice__4Default.class)
public abstract class Create_PartyIdentification248Choice__4 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__2 create_OrganisationIdentification15Choice__2;

	/**
	* @param drrReport 
	* @return id 
	*/
	public PartyIdentification248Choice__4 evaluate(ASICValuationReport drrReport) {
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

	protected abstract PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder doEvaluate(ASICValuationReport drrReport);

	public static class Create_PartyIdentification248Choice__4Default extends Create_PartyIdentification248Choice__4 {
		@Override
		protected PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder doEvaluate(ASICValuationReport drrReport) {
			PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder id = PartyIdentification248Choice__4.builder();
			return assignOutput(id, drrReport);
		}
		
		protected PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder assignOutput(PartyIdentification248Choice__4.PartyIdentification248Choice__4Builder id, ASICValuationReport drrReport) {
			LegalPersonIdentification1__4 ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", aSICValuationReport -> aSICValuationReport.getCounterparty2IdentifierType()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = LegalPersonIdentification1__4.builder()
					.setId(create_OrganisationIdentification15Choice__2.evaluate(MapperS.of(drrReport).<String>map("getCounterparty2", aSICValuationReport -> aSICValuationReport.getCounterparty2()).get()))
					.build();
			}
			NaturalPersonIdentification3__3 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", aSICValuationReport -> aSICValuationReport.getCounterparty2IdentifierType()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = NaturalPersonIdentification3__3.builder()
					.setId(NaturalPersonIdentification2__1.builder()
						.setId(GenericIdentification175__1.builder()
							.setId(MapperS.of(drrReport).<String>map("getCounterparty2", aSICValuationReport -> aSICValuationReport.getCounterparty2()).get())
							.build())
						.build())
					.build();
			}
			id = toBuilder(PartyIdentification248Choice__4.builder()
				.setLgl(ifThenElseResult0)
				.setNtrl(ifThenElseResult1)
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
