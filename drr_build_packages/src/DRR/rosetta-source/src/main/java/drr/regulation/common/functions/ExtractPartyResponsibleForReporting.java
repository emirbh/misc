package drr.regulation.common.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportingSide;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(ExtractPartyResponsibleForReporting.ExtractPartyResponsibleForReportingDefault.class)
public abstract class ExtractPartyResponsibleForReporting implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportingSide 
	* @return partyResponsibleForReporting 
	*/
	public Party evaluate(ReportingSide reportingSide) {
		Party.PartyBuilder partyResponsibleForReportingBuilder = doEvaluate(reportingSide);
		
		final Party partyResponsibleForReporting;
		if (partyResponsibleForReportingBuilder == null) {
			partyResponsibleForReporting = null;
		} else {
			partyResponsibleForReporting = partyResponsibleForReportingBuilder.build();
			objectValidator.validate(Party.class, partyResponsibleForReporting);
		}
		
		return partyResponsibleForReporting;
	}

	protected abstract Party.PartyBuilder doEvaluate(ReportingSide reportingSide);

	public static class ExtractPartyResponsibleForReportingDefault extends ExtractPartyResponsibleForReporting {
		@Override
		protected Party.PartyBuilder doEvaluate(ReportingSide reportingSide) {
			Party.PartyBuilder partyResponsibleForReporting = Party.builder();
			return assignOutput(partyResponsibleForReporting, reportingSide);
		}
		
		protected Party.PartyBuilder assignOutput(Party.PartyBuilder partyResponsibleForReporting, ReportingSide reportingSide) {
			if (exists(MapperS.of(reportingSide).<ReferenceWithMetaParty>map("getPartyResponsibleForReporting", _reportingSide -> _reportingSide.getPartyResponsibleForReporting())).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty0 = MapperS.of(reportingSide).<ReferenceWithMetaParty>map("getPartyResponsibleForReporting", _reportingSide -> _reportingSide.getPartyResponsibleForReporting()).get();
				if (referenceWithMetaParty0 == null) {
					partyResponsibleForReporting = null;
				} else {
					partyResponsibleForReporting = toBuilder(referenceWithMetaParty0.getValue());
				}
			} else {
				final ReferenceWithMetaParty referenceWithMetaParty1 = MapperS.of(reportingSide).<ReferenceWithMetaParty>map("getReportingParty", _reportingSide -> _reportingSide.getReportingParty()).get();
				if (referenceWithMetaParty1 == null) {
					partyResponsibleForReporting = null;
				} else {
					partyResponsibleForReporting = toBuilder(referenceWithMetaParty1.getValue());
				}
			}
			
			return Optional.ofNullable(partyResponsibleForReporting)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
