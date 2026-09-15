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

@ImplementedBy(ExtractReportSubmittingParty.ExtractReportSubmittingPartyDefault.class)
public abstract class ExtractReportSubmittingParty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param reportingSide 
	* @return reportSubmittingParty 
	*/
	public Party evaluate(ReportingSide reportingSide) {
		Party.PartyBuilder reportSubmittingPartyBuilder = doEvaluate(reportingSide);
		
		final Party reportSubmittingParty;
		if (reportSubmittingPartyBuilder == null) {
			reportSubmittingParty = null;
		} else {
			reportSubmittingParty = reportSubmittingPartyBuilder.build();
			objectValidator.validate(Party.class, reportSubmittingParty);
		}
		
		return reportSubmittingParty;
	}

	protected abstract Party.PartyBuilder doEvaluate(ReportingSide reportingSide);

	protected abstract MapperS<? extends ReferenceWithMetaParty> reportSubmittingPartyFromReportingSide(ReportingSide reportingSide);

	public static class ExtractReportSubmittingPartyDefault extends ExtractReportSubmittingParty {
		@Override
		protected Party.PartyBuilder doEvaluate(ReportingSide reportingSide) {
			Party.PartyBuilder reportSubmittingParty = Party.builder();
			return assignOutput(reportSubmittingParty, reportingSide);
		}
		
		protected Party.PartyBuilder assignOutput(Party.PartyBuilder reportSubmittingParty, ReportingSide reportingSide) {
			if (exists(MapperS.of(reportingSide).<ReferenceWithMetaParty>map("getReportSubmittingParty", _reportingSide -> _reportingSide.getReportSubmittingParty())).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty0 = MapperS.of(reportingSide).<ReferenceWithMetaParty>map("getReportSubmittingParty", _reportingSide -> _reportingSide.getReportSubmittingParty()).get();
				if (referenceWithMetaParty0 == null) {
					reportSubmittingParty = null;
				} else {
					reportSubmittingParty = toBuilder(referenceWithMetaParty0.getValue());
				}
			} else {
				final ReferenceWithMetaParty referenceWithMetaParty1 = MapperS.of(reportingSide).<ReferenceWithMetaParty>map("getReportingParty", _reportingSide -> _reportingSide.getReportingParty()).get();
				if (referenceWithMetaParty1 == null) {
					reportSubmittingParty = null;
				} else {
					reportSubmittingParty = toBuilder(referenceWithMetaParty1.getValue());
				}
			}
			
			return Optional.ofNullable(reportSubmittingParty)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends ReferenceWithMetaParty> reportSubmittingPartyFromReportingSide(ReportingSide reportingSide) {
			return MapperS.of(reportingSide).<ReferenceWithMetaParty>map("getReportSubmittingParty", _reportingSide -> _reportingSide.getReportSubmittingParty());
		}
	}
}
