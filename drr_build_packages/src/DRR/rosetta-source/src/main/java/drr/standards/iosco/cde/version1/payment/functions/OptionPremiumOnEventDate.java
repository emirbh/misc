package drr.standards.iosco.cde.version1.payment.functions;

import cdm.base.datetime.AdjustableOrAdjustedOrRelativeDate;
import cdm.event.common.BusinessEvent;
import cdm.event.common.TradeState;
import cdm.event.common.Transfer;
import cdm.event.common.TransferExpression;
import cdm.event.common.TransferState;
import cdm.event.workflow.WorkflowStep;
import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.ReportableEventBase;
import drr.base.util.datetime.functions.AdjustableOrAdjustedOrRelativeDateResolution;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OptionPremiumOnEventDate.OptionPremiumOnEventDateDefault.class)
public abstract class OptionPremiumOnEventDate implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected AdjustableOrAdjustedOrRelativeDateResolution adjustableOrAdjustedOrRelativeDateResolution;

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

	protected abstract MapperS<Date> eventDate(ReportableEventBase reportableEvent);

	protected abstract MapperC<? extends Transfer> premiums(ReportableEventBase reportableEvent);

	public static class OptionPremiumOnEventDateDefault extends OptionPremiumOnEventDate {
		@Override
		protected Transfer.TransferBuilder doEvaluate(ReportableEventBase reportableEvent) {
			Transfer.TransferBuilder optionPremium = Transfer.builder();
			return assignOutput(optionPremium, reportableEvent);
		}
		
		protected Transfer.TransferBuilder assignOutput(Transfer.TransferBuilder optionPremium, ReportableEventBase reportableEvent) {
			if (areEqual(MapperS.of(premiums(reportableEvent).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				optionPremium = toBuilder(premiums(reportableEvent).get());
			} else if (greaterThan(MapperS.of(premiums(reportableEvent).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				optionPremium = toBuilder(premiums(reportableEvent)
					.max(item -> MapperS.of(adjustableOrAdjustedOrRelativeDateResolution.evaluate(item.<AdjustableOrAdjustedOrRelativeDate>map("getSettlementDate", transfer -> transfer.getSettlementDate()).get()))).get());
			} else {
				optionPremium = null;
			}
			
			return Optional.ofNullable(optionPremium)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<Date> eventDate(ReportableEventBase reportableEvent) {
			return MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<Date>map("getEventDate", businessEvent -> businessEvent.getEventDate());
		}
		
		@Override
		protected MapperC<? extends Transfer> premiums(ReportableEventBase reportableEvent) {
			final MapperC<TransferState> thenArg = MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<TradeState>mapC("getAfter", businessEvent -> businessEvent.getAfter()).<TransferState>mapC("getTransferHistory", tradeState -> tradeState.getTransferHistory())
				.filterItemNullSafe(item -> areEqual(item.<Transfer>map("getTransfer", transferState -> transferState.getTransfer()).<TransferExpression>map("getTransferExpression", transfer -> transfer.getTransferExpression()).<FeeTypeEnum>map("getPriceTransfer", transferExpression -> transferExpression.getPriceTransfer()), MapperS.of(FeeTypeEnum.PREMIUM), CardinalityOperator.All).get());
			return thenArg.<Transfer>map("getTransfer", transferState -> transferState.getTransfer());
		}
	}
}
