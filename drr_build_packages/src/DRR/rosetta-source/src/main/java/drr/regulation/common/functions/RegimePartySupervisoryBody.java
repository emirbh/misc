package drr.regulation.common.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.regulation.common.JurisdictionPartyInformation;
import drr.regulation.common.ReportableJurisdictionInformation;
import drr.regulation.common.SupervisoryBodyEnum;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(RegimePartySupervisoryBody.RegimePartySupervisoryBodyDefault.class)
public abstract class RegimePartySupervisoryBody implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param jurisdictionInformation 
	* @param supervisoryBody 
	* @return partyReference 
	*/
	public List<? extends Party> evaluate(List<? extends ReportableJurisdictionInformation> jurisdictionInformation, SupervisoryBodyEnum supervisoryBody) {
		List<Party.PartyBuilder> partyReferenceBuilder = doEvaluate(jurisdictionInformation, supervisoryBody);
		
		final List<? extends Party> partyReference;
		if (partyReferenceBuilder == null) {
			partyReference = null;
		} else {
			partyReference = partyReferenceBuilder.stream().map(Party::build).collect(Collectors.toList());
			objectValidator.validate(Party.class, partyReference);
		}
		
		return partyReference;
	}

	protected abstract List<Party.PartyBuilder> doEvaluate(List<? extends ReportableJurisdictionInformation> jurisdictionInformation, SupervisoryBodyEnum supervisoryBody);

	public static class RegimePartySupervisoryBodyDefault extends RegimePartySupervisoryBody {
		@Override
		protected List<Party.PartyBuilder> doEvaluate(List<? extends ReportableJurisdictionInformation> jurisdictionInformation, SupervisoryBodyEnum supervisoryBody) {
			if (jurisdictionInformation == null) {
				jurisdictionInformation = Collections.emptyList();
			}
			List<Party.PartyBuilder> partyReference = new ArrayList<>();
			return assignOutput(partyReference, jurisdictionInformation, supervisoryBody);
		}
		
		protected List<Party.PartyBuilder> assignOutput(List<Party.PartyBuilder> partyReference, List<? extends ReportableJurisdictionInformation> jurisdictionInformation, SupervisoryBodyEnum supervisoryBody) {
			final MapperC<ReportableJurisdictionInformation> thenArg0 = MapperC.<ReportableJurisdictionInformation>of(jurisdictionInformation);
			final MapperC<ReportableJurisdictionInformation> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(MapperS.of(supervisoryBody), MapperS.of(supervisoryBody), CardinalityOperator.All).get());
			final MapperS<ReportableJurisdictionInformation> thenArg2 = MapperS.of(thenArg1.get());
			partyReference = toBuilder(thenArg2
				.mapSingleToList(item -> item.<JurisdictionPartyInformation>mapC("getPartyInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getPartyInformation()).<ReferenceWithMetaParty>map("getPartyReference", jurisdictionPartyInformation -> jurisdictionPartyInformation.getPartyReference())).<Party>map("Type coercion", referenceWithMetaParty -> referenceWithMetaParty.getValue()).getMulti());
			
			return Optional.ofNullable(partyReference)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
