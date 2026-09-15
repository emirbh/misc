package drr.projection.iso20022.asic.rewrite.margin.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.asic.rewrite.margin.ASICMarginReport;
import iso20022.auth108.asic.GenericIdentification175__1;
import iso20022.auth108.asic.OrganisationIdentification15Choice__2;
import iso20022.auth108.asic.OrganisationIdentification38__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_OrganisationIdentification15Choice__2.Create_OrganisationIdentification15Choice__2Default.class)
public abstract class Create_OrganisationIdentification15Choice__2 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return id 
	*/
	public OrganisationIdentification15Choice__2 evaluate(ASICMarginReport drrReport) {
		OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder idBuilder = doEvaluate(drrReport);
		
		final OrganisationIdentification15Choice__2 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(OrganisationIdentification15Choice__2.class, id);
		}
		
		return id;
	}

	protected abstract OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder doEvaluate(ASICMarginReport drrReport);

	public static class Create_OrganisationIdentification15Choice__2Default extends Create_OrganisationIdentification15Choice__2 {
		@Override
		protected OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder doEvaluate(ASICMarginReport drrReport) {
			OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder id = OrganisationIdentification15Choice__2.builder();
			return assignOutput(id, drrReport);
		}
		
		protected OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder assignOutput(OrganisationIdentification15Choice__2.OrganisationIdentification15Choice__2Builder id, ASICMarginReport drrReport) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", aSICMarginReport -> aSICMarginReport.getCounterparty2IdentifierType()), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getCounterparty2", aSICMarginReport -> aSICMarginReport.getCounterparty2()).get();
			}
			OrganisationIdentification38__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<Boolean>map("getCounterparty2IdentifierType", aSICMarginReport -> aSICMarginReport.getCounterparty2IdentifierType()), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = OrganisationIdentification38__1.builder()
					.setId(GenericIdentification175__1.builder()
						.setId(MapperS.of(drrReport).<String>map("getCounterparty2", aSICMarginReport -> aSICMarginReport.getCounterparty2()).get())
						.build())
					.build();
			}
			id = toBuilder(OrganisationIdentification15Choice__2.builder()
				.setLei(ifThenElseResult0)
				.setOthr(ifThenElseResult1)
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
