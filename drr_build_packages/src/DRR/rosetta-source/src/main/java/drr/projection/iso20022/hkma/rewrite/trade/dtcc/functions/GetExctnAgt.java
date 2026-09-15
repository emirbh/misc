package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.dtcc.GenericIdentification175__1;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification15Choice__6;
import iso20022.auth030.hkma.dtcc.OrganisationIdentification38__4;
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
	public List<? extends OrganisationIdentification15Choice__6> evaluate(HKMATransactionReport drrReport) {
		List<OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder> exctnAgtBuilder = doEvaluate(drrReport);
		
		final List<? extends OrganisationIdentification15Choice__6> exctnAgt;
		if (exctnAgtBuilder == null) {
			exctnAgt = null;
		} else {
			exctnAgt = exctnAgtBuilder.stream().map(OrganisationIdentification15Choice__6::build).collect(Collectors.toList());
			objectValidator.validate(OrganisationIdentification15Choice__6.class, exctnAgt);
		}
		
		return exctnAgt;
	}

	protected abstract List<OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder> doEvaluate(HKMATransactionReport drrReport);

	public static class GetExctnAgtDefault extends GetExctnAgt {
		@Override
		protected List<OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder> doEvaluate(HKMATransactionReport drrReport) {
			List<OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder> exctnAgt = new ArrayList<>();
			return assignOutput(exctnAgt, drrReport);
		}
		
		protected List<OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder> assignOutput(List<OrganisationIdentification15Choice__6.OrganisationIdentification15Choice__6Builder> exctnAgt, HKMATransactionReport drrReport) {
			if (exists(MapperS.of(drrReport).<String>map("getExecutionAgentCounterparty1", hKMATransactionReport -> hKMATransactionReport.getExecutionAgentCounterparty1())).getOrDefault(false)) {
				String ifThenElseResult0 = null;
				if (notEqual(MapperS.of(drrReport).<String>map("getExecutionAgentCounterparty1", hKMATransactionReport -> hKMATransactionReport.getExecutionAgentCounterparty1()), MapperS.of("NOAP"), CardinalityOperator.Any).getOrDefault(false)) {
					ifThenElseResult0 = MapperS.of(drrReport).<String>map("getExecutionAgentCounterparty1", hKMATransactionReport -> hKMATransactionReport.getExecutionAgentCounterparty1()).get();
				}
				String ifThenElseResult1 = null;
				if (areEqual(MapperS.of(drrReport).<String>map("getExecutionAgentCounterparty1", hKMATransactionReport -> hKMATransactionReport.getExecutionAgentCounterparty1()), MapperS.of("NOAP"), CardinalityOperator.All).getOrDefault(false)) {
					ifThenElseResult1 = MapperS.of(drrReport).<String>map("getExecutionAgentCounterparty1", hKMATransactionReport -> hKMATransactionReport.getExecutionAgentCounterparty1()).get();
				}
				final OrganisationIdentification15Choice__6 organisationIdentification15Choice__60 = OrganisationIdentification15Choice__6.builder()
					.setLei(ifThenElseResult0)
					.setOthr(OrganisationIdentification38__4.builder()
						.setId(GenericIdentification175__1.builder()
							.setId(ifThenElseResult1)
							.build())
						.build())
					.build();
				if (organisationIdentification15Choice__60 == null) {
					exctnAgt.addAll(toBuilder(Collections.<OrganisationIdentification15Choice__6>emptyList()));
				} else {
					exctnAgt.addAll(toBuilder(Collections.singletonList(organisationIdentification15Choice__60)));
				}
			} else {
				exctnAgt.addAll(toBuilder(Collections.<OrganisationIdentification15Choice__6>emptyList()));
			}
			
			if (exists(MapperS.of(drrReport).<String>map("getExecutionAgentCounterparty2", hKMATransactionReport -> hKMATransactionReport.getExecutionAgentCounterparty2())).getOrDefault(false)) {
				final OrganisationIdentification15Choice__6 organisationIdentification15Choice__61 = OrganisationIdentification15Choice__6.builder()
					.setLei(MapperS.of(drrReport).<String>map("getExecutionAgentCounterparty2", hKMATransactionReport -> hKMATransactionReport.getExecutionAgentCounterparty2()).get())
					.build();
				if (organisationIdentification15Choice__61 == null) {
					exctnAgt.addAll(toBuilder(Collections.<OrganisationIdentification15Choice__6>emptyList()));
				} else {
					exctnAgt.addAll(toBuilder(Collections.singletonList(organisationIdentification15Choice__61)));
				}
			} else {
				exctnAgt.addAll(toBuilder(Collections.<OrganisationIdentification15Choice__6>emptyList()));
			}
			
			return Optional.ofNullable(exctnAgt)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
