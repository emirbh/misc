package drr.projection.iso20022.mas.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import iso20022.auth030.mas.GenericIdentification175__1;
import iso20022.auth030.mas.OrganisationIdentification15Choice__3;
import iso20022.auth030.mas.OrganisationIdentification38__2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetExctnAgt.GetExctnAgtDefault.class)
public abstract class GetExctnAgt implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return exctnAgt 
	*/
	public List<? extends OrganisationIdentification15Choice__3> evaluate(MASTransactionReport drrReport) {
		List<OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder> exctnAgtBuilder = doEvaluate(drrReport);
		
		final List<? extends OrganisationIdentification15Choice__3> exctnAgt;
		if (exctnAgtBuilder == null) {
			exctnAgt = null;
		} else {
			exctnAgt = exctnAgtBuilder.stream().map(OrganisationIdentification15Choice__3::build).collect(Collectors.toList());
			objectValidator.validate(OrganisationIdentification15Choice__3.class, exctnAgt);
		}
		
		return exctnAgt;
	}

	protected abstract List<OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder> doEvaluate(MASTransactionReport drrReport);

	public static class GetExctnAgtDefault extends GetExctnAgt {
		@Override
		protected List<OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder> doEvaluate(MASTransactionReport drrReport) {
			List<OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder> exctnAgt = new ArrayList<>();
			return assignOutput(exctnAgt, drrReport);
		}
		
		protected List<OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder> assignOutput(List<OrganisationIdentification15Choice__3.OrganisationIdentification15Choice__3Builder> exctnAgt, MASTransactionReport drrReport) {
			if (exists(MapperS.of(drrReport).<String>map("getExecutionAgentCounterparty1", mASTransactionReport -> mASTransactionReport.getExecutionAgentCounterparty1())).getOrDefault(false)) {
				String ifThenElseResult0 = null;
				if (notEqual(MapperS.of(drrReport).<String>map("getExecutionAgentCounterparty1", mASTransactionReport -> mASTransactionReport.getExecutionAgentCounterparty1()), MapperS.of("NOAP"), CardinalityOperator.Any).getOrDefault(false)) {
					ifThenElseResult0 = MapperS.of(drrReport).<String>map("getExecutionAgentCounterparty1", mASTransactionReport -> mASTransactionReport.getExecutionAgentCounterparty1()).get();
				}
				String ifThenElseResult1 = null;
				if (areEqual(MapperS.of(drrReport).<String>map("getExecutionAgentCounterparty1", mASTransactionReport -> mASTransactionReport.getExecutionAgentCounterparty1()), MapperS.of("NOAP"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult1 = MapperS.of(drrReport).<String>map("getExecutionAgentCounterparty1", mASTransactionReport -> mASTransactionReport.getExecutionAgentCounterparty1()).get();
				}
				final OrganisationIdentification15Choice__3 organisationIdentification15Choice__30 = OrganisationIdentification15Choice__3.builder()
					.setLei(ifThenElseResult0)
					.setOthr(OrganisationIdentification38__2.builder()
						.setId(GenericIdentification175__1.builder()
							.setId(ifThenElseResult1)
							.build())
						.build())
					.build();
				if (organisationIdentification15Choice__30 == null) {
					exctnAgt.addAll(toBuilder(Collections.<OrganisationIdentification15Choice__3>emptyList()));
				} else {
					exctnAgt.addAll(toBuilder(Collections.singletonList(organisationIdentification15Choice__30)));
				}
			} else {
				exctnAgt.addAll(toBuilder(Collections.<OrganisationIdentification15Choice__3>emptyList()));
			}
			
			if (exists(MapperS.of(drrReport).<String>map("getExecutionAgentCounterparty2", mASTransactionReport -> mASTransactionReport.getExecutionAgentCounterparty2())).getOrDefault(false)) {
				final OrganisationIdentification15Choice__3 organisationIdentification15Choice__31 = OrganisationIdentification15Choice__3.builder()
					.setLei(MapperS.of(drrReport).<String>map("getExecutionAgentCounterparty2", mASTransactionReport -> mASTransactionReport.getExecutionAgentCounterparty2()).get())
					.build();
				if (organisationIdentification15Choice__31 == null) {
					exctnAgt.addAll(toBuilder(Collections.<OrganisationIdentification15Choice__3>emptyList()));
				} else {
					exctnAgt.addAll(toBuilder(Collections.singletonList(organisationIdentification15Choice__31)));
				}
			} else {
				exctnAgt.addAll(toBuilder(Collections.<OrganisationIdentification15Choice__3>emptyList()));
			}
			
			return Optional.ofNullable(exctnAgt)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
