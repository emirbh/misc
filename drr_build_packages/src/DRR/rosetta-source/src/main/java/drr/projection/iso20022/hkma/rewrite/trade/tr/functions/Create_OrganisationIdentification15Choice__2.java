package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.common.HKTRPartyScheme;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.tr.GenericIdentification175__2;
import iso20022.auth030.hkma.tr.OrganisationIdentification15Choice__2;
import iso20022.auth030.hkma.tr.OrganisationIdentification38__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_OrganisationIdentification15Choice__2.Create_OrganisationIdentification15Choice__2Default.class)
public abstract class Create_OrganisationIdentification15Choice__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @param idFormat 
	* @param idFromReport 
	* @param schemeName 
	* @return id 
	*/
	public OrganisationIdentification15Choice__2 evaluate(HKMATransactionReport drrReport, PartyIdentifierFormat2Enum idFormat, String idFromReport, HKTRPartyScheme schemeName) {
		OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder idBuilder = doEvaluate(drrReport, idFormat, idFromReport, schemeName);
		
		final OrganisationIdentification15Choice__2 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(OrganisationIdentification15Choice__2.class, id);
		}
		
		return id;
	}

	protected abstract OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder doEvaluate(HKMATransactionReport drrReport, PartyIdentifierFormat2Enum idFormat, String idFromReport, HKTRPartyScheme schemeName);

	public static class Create_OrganisationIdentification15Choice__2Default extends Create_OrganisationIdentification15Choice__2 {
		@Override
		protected OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder doEvaluate(HKMATransactionReport drrReport, PartyIdentifierFormat2Enum idFormat, String idFromReport, HKTRPartyScheme schemeName) {
			OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder id = OrganisationIdentification15Choice__2.builder();
			return assignOutput(id, drrReport, idFormat, idFromReport, schemeName);
		}
		
		protected OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder assignOutput(OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder id, HKMATransactionReport drrReport, PartyIdentifierFormat2Enum idFormat, String idFromReport, HKTRPartyScheme schemeName) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(idFormat), MapperS.of(PartyIdentifierFormat2Enum.LEI), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = idFromReport;
			}
			OrganisationIdentification38__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(idFormat), MapperS.of(PartyIdentifierFormat2Enum.OTHER), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = OrganisationIdentification38__1.builder()
					.setId(GenericIdentification175__2.builder()
						.setId(idFromReport)
						.setSchmeNm(MapperS.of(schemeName).checkedMap("to-enum", e -> iso20022.auth030.hkma.tr.HKTRPartyScheme.valueOf(e.name()), IllegalArgumentException.class).get())
						.build())
					.setNm(MapperS.of(drrReport).<String>map("getCounterparty2Name", hKMATransactionReport -> hKMATransactionReport.getCounterparty2Name()).get())
					.build();
			}
			String ifThenElseResult2 = null;
			if (areEqual(MapperS.of(idFormat), MapperS.of(PartyIdentifierFormat2Enum.SWIFTBIC), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = idFromReport;
			}
			id = toBuilder(OrganisationIdentification15Choice__2.builder()
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
