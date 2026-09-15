package drr.regulation.common.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.metafields.FieldWithMetaSupervisoryBodyEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(FilterPartyInformationBySupervisoryBody.FilterPartyInformationBySupervisoryBodyDefault.class)
public abstract class FilterPartyInformationBySupervisoryBody implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param regimePartyInformation 
	* @param jurisdiction 
	* @return filteredPartyInformation 
	*/
	public List<? extends JurisdictionPartyInformation> evaluate(ReportableJurisdictionInformation regimePartyInformation, SupervisoryBodyEnum jurisdiction) {
		List<JurisdictionPartyInformation.JurisdictionPartyInformationBuilder> filteredPartyInformationBuilder = doEvaluate(regimePartyInformation, jurisdiction);
		
		final List<? extends JurisdictionPartyInformation> filteredPartyInformation;
		if (filteredPartyInformationBuilder == null) {
			filteredPartyInformation = null;
		} else {
			filteredPartyInformation = filteredPartyInformationBuilder.stream().map(JurisdictionPartyInformation::build).collect(Collectors.toList());
			objectValidator.validate(JurisdictionPartyInformation.class, filteredPartyInformation);
		}
		
		return filteredPartyInformation;
	}

	protected abstract List<JurisdictionPartyInformation.JurisdictionPartyInformationBuilder> doEvaluate(ReportableJurisdictionInformation regimePartyInformation, SupervisoryBodyEnum jurisdiction);

	public static class FilterPartyInformationBySupervisoryBodyDefault extends FilterPartyInformationBySupervisoryBody {
		@Override
		protected List<JurisdictionPartyInformation.JurisdictionPartyInformationBuilder> doEvaluate(ReportableJurisdictionInformation regimePartyInformation, SupervisoryBodyEnum jurisdiction) {
			List<JurisdictionPartyInformation.JurisdictionPartyInformationBuilder> filteredPartyInformation = new ArrayList<>();
			return assignOutput(filteredPartyInformation, regimePartyInformation, jurisdiction);
		}
		
		protected List<JurisdictionPartyInformation.JurisdictionPartyInformationBuilder> assignOutput(List<JurisdictionPartyInformation.JurisdictionPartyInformationBuilder> filteredPartyInformation, ReportableJurisdictionInformation regimePartyInformation, SupervisoryBodyEnum jurisdiction) {
			final MapperS<ReportableJurisdictionInformation> thenArg = MapperS.of(regimePartyInformation)
				.filterSingleNullSafe(item -> areEqual(item.<FieldWithMetaSupervisoryBodyEnum>map("getSupervisoryBody", reportableJurisdictionInformation -> reportableJurisdictionInformation.getSupervisoryBody()).<SupervisoryBodyEnum>map("Type coercion", fieldWithMetaSupervisoryBodyEnum -> fieldWithMetaSupervisoryBodyEnum == null ? null : fieldWithMetaSupervisoryBodyEnum.getValue()), MapperS.of(jurisdiction), CardinalityOperator.All).get());
			filteredPartyInformation.addAll(toBuilder(thenArg.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).getMulti()));
			
			return Optional.ofNullable(filteredPartyInformation)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
