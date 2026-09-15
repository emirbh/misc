package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import iso20022.auth030.mas.GenericIdentification175__1;
import iso20022.auth030.mas.OrganisationIdentification15Choice__3;
import iso20022.auth030.mas.OrganisationIdentification38__2;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_OrganisationIdentification15Choice__3.Create_OrganisationIdentification15Choice__3Default.class)
public abstract class Create_OrganisationIdentification15Choice__3 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param leiIndicator 
	* @param idFromReport 
	* @return id 
	*/
	public OrganisationIdentification15Choice__3 evaluate(Boolean leiIndicator, String idFromReport) {
		OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder idBuilder = doEvaluate(leiIndicator, idFromReport);
		
		final OrganisationIdentification15Choice__3 id;
		if (idBuilder == null) {
			id = null;
		} else {
			id = idBuilder.build();
			objectValidator.validate(OrganisationIdentification15Choice__3.class, id);
		}
		
		return id;
	}

	protected abstract OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder doEvaluate(Boolean leiIndicator, String idFromReport);

	public static class Create_OrganisationIdentification15Choice__3Default extends Create_OrganisationIdentification15Choice__3 {
		@Override
		protected OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder doEvaluate(Boolean leiIndicator, String idFromReport) {
			OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder id = OrganisationIdentification15Choice__3.builder();
			return assignOutput(id, leiIndicator, idFromReport);
		}
		
		protected OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder assignOutput(OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder id, Boolean leiIndicator, String idFromReport) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(leiIndicator), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = idFromReport;
			}
			OrganisationIdentification38__2 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(leiIndicator), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = OrganisationIdentification38__2.builder()
					.setId(GenericIdentification175__1.builder()
						.setId(idFromReport)
						.build())
					.build();
			}
			id = toBuilder(OrganisationIdentification15Choice__3.builder()
				.setLei(ifThenElseResult0)
				.setOthr(ifThenElseResult1)
				.build());
			
			return Optional.ofNullable(id)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
