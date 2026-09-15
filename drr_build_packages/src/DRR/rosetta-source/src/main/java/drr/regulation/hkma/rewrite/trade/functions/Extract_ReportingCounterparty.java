package drr.regulation.hkma.rewrite.trade.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaParty;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.ReportingSide;
import drr.regulation.common.TransactionReportInstruction;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Extract_ReportingCounterparty.Extract_ReportingCounterpartyDefault.class)
public abstract class Extract_ReportingCounterparty implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param transactionReportInstruction 
	* @return party 
	*/
	public Party evaluate(TransactionReportInstruction transactionReportInstruction) {
		Party.PartyBuilder partyBuilder = doEvaluate(transactionReportInstruction);
		
		final Party party;
		if (partyBuilder == null) {
			party = null;
		} else {
			party = partyBuilder.build();
			objectValidator.validate(Party.class, party);
		}
		
		return party;
	}

	protected abstract Party.PartyBuilder doEvaluate(TransactionReportInstruction transactionReportInstruction);

	public static class Extract_ReportingCounterpartyDefault extends Extract_ReportingCounterparty {
		@Override
		protected Party.PartyBuilder doEvaluate(TransactionReportInstruction transactionReportInstruction) {
			Party.PartyBuilder party = Party.builder();
			return assignOutput(party, transactionReportInstruction);
		}
		
		protected Party.PartyBuilder assignOutput(Party.PartyBuilder party, TransactionReportInstruction transactionReportInstruction) {
			if (exists(MapperS.of(transactionReportInstruction).<ReportingSide>map("getReportingSide", _transactionReportInstruction -> _transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty())).getOrDefault(false)) {
				final ReferenceWithMetaParty referenceWithMetaParty = MapperS.of(transactionReportInstruction).<ReportingSide>map("getReportingSide", _transactionReportInstruction -> _transactionReportInstruction.getReportingSide()).<ReferenceWithMetaParty>map("getReportingCounterparty", reportingSide -> reportingSide.getReportingCounterparty()).get();
				if (referenceWithMetaParty == null) {
					party = null;
				} else {
					party = toBuilder(referenceWithMetaParty.getValue());
				}
			} else {
				party = null;
			}
			
			return Optional.ofNullable(party)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
