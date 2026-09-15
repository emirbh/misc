package drr.projection.iso20022.jfsa.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.jfsa.rewrite.trade.JFSATransactionReport;
import iso20022.auth030.jfsa.GenericIdentification175__1;
import iso20022.auth030.jfsa.LegalPersonIdentification1__2;
import iso20022.auth030.jfsa.NaturalPersonIdentification2__1;
import iso20022.auth030.jfsa.NaturalPersonIdentification3__1;
import iso20022.auth030.jfsa.OrganisationIdentification15Choice__2;
import iso20022.auth030.jfsa.OrganisationIdentification38__1;
import iso20022.auth030.jfsa.PartyIdentification248Choice__2;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_PartyIdentification248Choice__2.Create_PartyIdentification248Choice__2Default.class)
public abstract class Create_PartyIdentification248Choice__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return id 
	*/
	public PartyIdentification248Choice__2 evaluate(JFSATransactionReport drrReport) {
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

	protected abstract PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder doEvaluate(JFSATransactionReport drrReport);

	public static class Create_PartyIdentification248Choice__2Default extends Create_PartyIdentification248Choice__2 {
		@Override
		protected PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder doEvaluate(JFSATransactionReport drrReport) {
			PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder id = PartyIdentification248Choice__2.builder();
			return assignOutput(id, drrReport);
		}
		
		protected PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder assignOutput(PartyIdentification248Choice__2.PartyIdentification248Choice__2Builder id, JFSATransactionReport drrReport) {
			LegalPersonIdentification1__2 ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", jFSATransactionReport -> jFSATransactionReport.getCounterparty2IdentifierType()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				String ifThenElseResult0 = null;
				if (areEqual(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", jFSATransactionReport -> jFSATransactionReport.getCounterparty2IdentifierType()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult0 = MapperS.of(drrReport).<String>map("getCounterparty2", jFSATransactionReport -> jFSATransactionReport.getCounterparty2()).get();
				}
				OrganisationIdentification38__1 ifThenElseResult1 = null;
				if (areEqual(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", jFSATransactionReport -> jFSATransactionReport.getCounterparty2IdentifierType()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult1 = OrganisationIdentification38__1.builder()
						.setId(GenericIdentification175__1.builder()
							.setId(MapperS.of(drrReport).<String>map("getCounterparty2", jFSATransactionReport -> jFSATransactionReport.getCounterparty2()).get())
							.build())
						.build();
				}
				ifThenElseResult2 = LegalPersonIdentification1__2.builder()
					.setId(OrganisationIdentification15Choice__2.builder()
						.setLei(ifThenElseResult0)
						.setOthr(ifThenElseResult1)
						.build())
					.build();
			}
			NaturalPersonIdentification3__1 ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", jFSATransactionReport -> jFSATransactionReport.getCounterparty2IdentifierType()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = NaturalPersonIdentification3__1.builder()
					.setId(NaturalPersonIdentification2__1.builder()
						.setId(GenericIdentification175__1.builder()
							.setId(MapperS.of(drrReport).<String>map("getCounterparty2", jFSATransactionReport -> jFSATransactionReport.getCounterparty2()).get())
							.build())
						.build())
					.build();
			}
			id = toBuilder(PartyIdentification248Choice__2.builder()
				.setLgl(ifThenElseResult2)
				.setNtrl(ifThenElseResult3)
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
