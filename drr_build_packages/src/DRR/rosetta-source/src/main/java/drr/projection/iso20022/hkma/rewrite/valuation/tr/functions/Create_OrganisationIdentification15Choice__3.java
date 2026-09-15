package drr.projection.iso20022.hkma.rewrite.valuation.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import iso20022.auth030.hkma.tr.GenericIdentification175__2;
import iso20022.auth030.hkma.tr.HKTRPartyScheme;
import iso20022.auth030.hkma.tr.OrganisationIdentification15Choice__3;
import iso20022.auth030.hkma.tr.OrganisationIdentification38__2;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_OrganisationIdentification15Choice__3.Create_OrganisationIdentification15Choice__3Default.class)
public abstract class Create_OrganisationIdentification15Choice__3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param idFormat 
	* @param idFromReport 
	* @param schemeName 
	* @return id 
	*/
	public OrganisationIdentification15Choice__3 evaluate(PartyIdentifierFormat2Enum idFormat, String idFromReport, String schemeName) {
		OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder idBuilder = doEvaluate(idFormat, idFromReport, schemeName);
		
		final OrganisationIdentification15Choice__3 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(OrganisationIdentification15Choice__3.class, id);
		}
		
		return id;
	}

	protected abstract OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder doEvaluate(PartyIdentifierFormat2Enum idFormat, String idFromReport, String schemeName);

	public static class Create_OrganisationIdentification15Choice__3Default extends Create_OrganisationIdentification15Choice__3 {
		@Override
		protected OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder doEvaluate(PartyIdentifierFormat2Enum idFormat, String idFromReport, String schemeName) {
			OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder id = OrganisationIdentification15Choice__3.builder();
			return assignOutput(id, idFormat, idFromReport, schemeName);
		}
		
		protected OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder assignOutput(OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder id, PartyIdentifierFormat2Enum idFormat, String idFromReport, String schemeName) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(idFormat), MapperS.of(PartyIdentifierFormat2Enum.LEI), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = idFromReport;
			}
			OrganisationIdentification38__2 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(idFormat), MapperS.of(PartyIdentifierFormat2Enum.OTHER), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = OrganisationIdentification38__2.builder()
					.setId(GenericIdentification175__2.builder()
						.setId(idFromReport)
						.setSchmeNm(MapperS.of(schemeName).checkedMap("to-enum", HKTRPartyScheme::fromDisplayName, IllegalArgumentException.class).get())
						.build())
					.build();
			}
			String ifThenElseResult2 = null;
			if (areEqual(MapperS.of(idFormat), MapperS.of(PartyIdentifierFormat2Enum.SWIFTBIC), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = idFromReport;
			}
			id = toBuilder(OrganisationIdentification15Choice__3.builder()
				.setLei(ifThenElseResult0)
				.setOthr(ifThenElseResult1)
				.setAnyBIC(ifThenElseResult2)
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
