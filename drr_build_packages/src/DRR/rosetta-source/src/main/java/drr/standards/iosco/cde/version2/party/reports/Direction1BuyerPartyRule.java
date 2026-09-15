package drr.standards.iosco.cde.version2.party.reports;

import cdm.base.staticdata.party.Party;
import cdm.event.common.Trade;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.standards.iosco.cde.version1.party.functions.Direction1BuyerParty;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Direction1BuyerPartyRule.Direction1BuyerPartyRuleDefault.class)
public abstract class Direction1BuyerPartyRule implements ReportFunction<Trade, Party> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Direction1BuyerParty direction1BuyerParty;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Party evaluate(Trade input) {
		Party.PartyBuilder outputBuilder = doEvaluate(input);
		
		final Party output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(Party.class, output);
		}
		
		return output;
	}

	protected abstract Party.PartyBuilder doEvaluate(Trade input);

	public static class Direction1BuyerPartyRuleDefault extends Direction1BuyerPartyRule {
		@Override
		protected Party.PartyBuilder doEvaluate(Trade input) {
			Party.PartyBuilder output = Party.builder();
			return assignOutput(output, input);
		}
		
		protected Party.PartyBuilder assignOutput(Party.PartyBuilder output, Trade input) {
			output = toBuilder(direction1BuyerParty.evaluate(input));
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
