package drr.projection.iso20022.hkma.rewrite.valuation.tr.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.common.HKTRPartyScheme;
import drr.regulation.hkma.rewrite.valuation.HKMAValuationReport;
import iso20022.auth030.hkma.tr.GenericIdentification175__1;
import iso20022.auth030.hkma.tr.LegalPersonIdentification1__5;
import iso20022.auth030.hkma.tr.NaturalPersonIdentification2__1;
import iso20022.auth030.hkma.tr.NaturalPersonIdentification3__2;
import iso20022.auth030.hkma.tr.PartyIdentification248Choice__5;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_PartyIdentification248Choice__5.Create_PartyIdentification248Choice__5Default.class)
public abstract class Create_PartyIdentification248Choice__5 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_OrganisationIdentification15Choice__2 create_OrganisationIdentification15Choice__2;

	/**
	* @param drrReport 
	* @return id 
	*/
	public PartyIdentification248Choice__5 evaluate(HKMAValuationReport drrReport) {
		PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder idBuilder = doEvaluate(drrReport);
		
		final PartyIdentification248Choice__5 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(PartyIdentification248Choice__5.class, id);
		}
		
		return id;
	}

	protected abstract PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder doEvaluate(HKMAValuationReport drrReport);

	public static class Create_PartyIdentification248Choice__5Default extends Create_PartyIdentification248Choice__5 {
		@Override
		protected PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder doEvaluate(HKMAValuationReport drrReport) {
			PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder id = PartyIdentification248Choice__5.builder();
			return assignOutput(id, drrReport);
		}
		
		protected PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder assignOutput(PartyIdentification248Choice__5.PartyIdentification248Choice__5Builder id, HKMAValuationReport drrReport) {
			NaturalPersonIdentification3__2 ifThenElseResult = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", hKMAValuationReport -> hKMAValuationReport.getCounterparty2IdentifierType()), MapperS.of(false), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<PartyIdentifierFormat2Enum>map("getCounterparty2IdentifierFormat", hKMAValuationReport -> hKMAValuationReport.getCounterparty2IdentifierFormat()), MapperS.of(PartyIdentifierFormat2Enum.NATURAL_PERSON), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult = NaturalPersonIdentification3__2.builder()
					.setId(NaturalPersonIdentification2__1.builder()
						.setId(GenericIdentification175__1.builder()
							.setId(MapperS.of(drrReport).<String>map("getCounterparty2", hKMAValuationReport -> hKMAValuationReport.getCounterparty2()).get())
							.build())
						.build())
					.build();
			}
			id = toBuilder(PartyIdentification248Choice__5.builder()
				.setLgl(LegalPersonIdentification1__5.builder()
					.setId(create_OrganisationIdentification15Choice__2.evaluate(drrReport, MapperS.of(drrReport).<PartyIdentifierFormat2Enum>map("getCounterparty2IdentifierFormat", hKMAValuationReport -> hKMAValuationReport.getCounterparty2IdentifierFormat()).get(), MapperS.of(drrReport).<String>map("getCounterparty2", hKMAValuationReport -> hKMAValuationReport.getCounterparty2()).get(), MapperS.of(drrReport).<HKTRPartyScheme>map("getCounterparty2SchemeName", hKMAValuationReport -> hKMAValuationReport.getCounterparty2SchemeName()).map("to-string", HKTRPartyScheme::toDisplayString).get()))
					.build())
				.setNtrl(ifThenElseResult)
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
