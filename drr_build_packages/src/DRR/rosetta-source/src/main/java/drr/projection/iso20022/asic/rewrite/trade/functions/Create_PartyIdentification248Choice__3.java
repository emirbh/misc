package drr.projection.iso20022.asic.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.asic.GenericIdentification175__1;
import iso20022.auth030.asic.LegalPersonIdentification1__3;
import iso20022.auth030.asic.NaturalPersonIdentification2__2;
import iso20022.auth030.asic.NaturalPersonIdentification3__2;
import iso20022.auth030.asic.PartyIdentification248Choice__3;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_PartyIdentification248Choice__3.Create_PartyIdentification248Choice__3Default.class)
public abstract class Create_PartyIdentification248Choice__3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__3 create_OrganisationIdentification15Choice__3;

	/**
	* @param leiIndicator 
	* @param idFromReport 
	* @return id 
	*/
	public PartyIdentification248Choice__3 evaluate(Boolean leiIndicator, String idFromReport) {
		PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder idBuilder = doEvaluate(leiIndicator, idFromReport);
		
		final PartyIdentification248Choice__3 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(PartyIdentification248Choice__3.class, id);
		}
		
		return id;
	}

	protected abstract PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder doEvaluate(Boolean leiIndicator, String idFromReport);

	public static class Create_PartyIdentification248Choice__3Default extends Create_PartyIdentification248Choice__3 {
		@Override
		protected PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder doEvaluate(Boolean leiIndicator, String idFromReport) {
			PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder id = PartyIdentification248Choice__3.builder();
			return assignOutput(id, leiIndicator, idFromReport);
		}
		
		protected PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder assignOutput(PartyIdentification248Choice__3.PartyIdentification248Choice__3Builder id, Boolean leiIndicator, String idFromReport) {
			NaturalPersonIdentification3__2 ifThenElseResult = null;
			if (areEqual(MapperS.of(leiIndicator), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = NaturalPersonIdentification3__2.builder()
					.setId(NaturalPersonIdentification2__2.builder()
						.setId(GenericIdentification175__1.builder()
							.setId(idFromReport)
							.build())
						.build())
					.build();
			}
			id = toBuilder(PartyIdentification248Choice__3.builder()
				.setLgl(LegalPersonIdentification1__3.builder()
					.setId(create_OrganisationIdentification15Choice__3.evaluate(leiIndicator, idFromReport))
					.build())
				.setNtrl(ifThenElseResult)
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
