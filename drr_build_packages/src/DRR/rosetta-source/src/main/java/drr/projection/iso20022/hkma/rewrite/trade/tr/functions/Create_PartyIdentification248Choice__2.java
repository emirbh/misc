package drr.projection.iso20022.hkma.rewrite.trade.tr.functions;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.party.PartyIdentifierFormat2Enum;
import drr.regulation.common.HKTRPartyScheme;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.tr.GenericIdentification175__1;
import iso20022.auth030.hkma.tr.LegalPersonIdentification1__2;
import iso20022.auth030.hkma.tr.NaturalPersonIdentification2__1;
import iso20022.auth030.hkma.tr.NaturalPersonIdentification3__1;
import iso20022.auth030.hkma.tr.PartyIdentification248Choice__2;
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
	public PartyIdentification248Choice__2 evaluate(HKMATransactionReport drrReport) {
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

	protected abstract PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder doEvaluate(HKMATransactionReport drrReport);

	public static class Create_PartyIdentification248Choice__2Default extends Create_PartyIdentification248Choice__2 {
		@Override
		protected PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder doEvaluate(HKMATransactionReport drrReport) {
			PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder id = PartyIdentification248Choice__2.builder();
			return assignOutput(id, drrReport);
		}
		
		protected PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder assignOutput(PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder id, HKMATransactionReport drrReport) {
			NaturalPersonIdentification3__1 ifThenElseResult = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", hKMATransactionReport -> hKMATransactionReport.getCounterparty2IdentifierType()), MapperS.of(false), CardinalityOperator.All).andNullSafe(areEqual(MapperS.of(drrReport).<PartyIdentifierFormat2Enum>map("getCounterparty2IdentifierFormat", hKMATransactionReport -> hKMATransactionReport.getCounterparty2IdentifierFormat()), MapperS.of(PartyIdentifierFormat2Enum.NATURAL_PERSON), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult = NaturalPersonIdentification3__1.builder()
					.setId(NaturalPersonIdentification2__1.builder()
						.setId(GenericIdentification175__1.builder()
							.setId(MapperS.of(drrReport).<String>map("getCounterparty2", hKMATransactionReport -> hKMATransactionReport.getCounterparty2()).get())
							.build())
						.build())
					.setCtry(MapperS.of(drrReport).<ISOCountryCodeEnum>map("getCountryOfTheCounterparty2", hKMATransactionReport -> hKMATransactionReport.getCountryOfTheCounterparty2()).map("to-string", ISOCountryCodeEnum::toDisplayString).get())
					.build();
			}
			id = toBuilder(PartyIdentification248Choice__2.builder()
				.setLgl(LegalPersonIdentification1__2.builder()
					.setId(create_OrganisationIdentification15Choice__2.evaluate(drrReport, MapperS.of(drrReport).<PartyIdentifierFormat2Enum>map("getCounterparty2IdentifierFormat", hKMATransactionReport -> hKMATransactionReport.getCounterparty2IdentifierFormat()).get(), MapperS.of(drrReport).<String>map("getCounterparty2", hKMATransactionReport -> hKMATransactionReport.getCounterparty2()).get(), MapperS.of(drrReport).<HKTRPartyScheme>map("getCounterparty2SchemeName", hKMATransactionReport -> hKMATransactionReport.getCounterparty2SchemeName()).get()))
					.setCtry(MapperS.of(drrReport).<ISOCountryCodeEnum>map("getCountryOfTheCounterparty2", hKMATransactionReport -> hKMATransactionReport.getCountryOfTheCounterparty2()).map("to-string", ISOCountryCodeEnum::toDisplayString).get())
					.build())
				.setNtrl(ifThenElseResult)
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
