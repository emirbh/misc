package drr.standards.iosco.cde.version2.payment.functions;

import cdm.event.common.Transfer;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import drr.base.trade.ReportableEventBase;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(OptionPremiumOnEventDate.OptionPremiumOnEventDateDefault.class)
public abstract class OptionPremiumOnEventDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected drr.standards.iosco.cde.version1.payment.functions.OptionPremiumOnEventDate optionPremiumOnEventDate;

	/**
	* @param reportableEvent 
	* @return optionPremium 
	*/
	public Transfer evaluate(ReportableEventBase reportableEvent) {
		Transfer.TransferBuilder optionPremiumBuilder = doEvaluate(reportableEvent);
		
		final Transfer optionPremium;
		if (optionPremiumBuilder == null) {
			optionPremium = null;
		} else {
			optionPremium = optionPremiumBuilder.build();
			objectValidator.validate(Transfer.class, optionPremium);
		}
		
		return optionPremium;
	}

	protected abstract Transfer.TransferBuilder doEvaluate(ReportableEventBase reportableEvent);

	public static class OptionPremiumOnEventDateDefault extends OptionPremiumOnEventDate {
		@Override
		protected Transfer.TransferBuilder doEvaluate(ReportableEventBase reportableEvent) {
			Transfer.TransferBuilder optionPremium = Transfer.builder();
			return assignOutput(optionPremium, reportableEvent);
		}
		
		protected Transfer.TransferBuilder assignOutput(Transfer.TransferBuilder optionPremium, ReportableEventBase reportableEvent) {
			optionPremium = toBuilder(optionPremiumOnEventDate.evaluate(reportableEvent));
			
			return Optional.ofNullable(optionPremium)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
