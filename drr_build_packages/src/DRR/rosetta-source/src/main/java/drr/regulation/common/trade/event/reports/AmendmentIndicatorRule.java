package drr.regulation.common.trade.event.reports;

import cdm.event.common.BusinessEvent;
import cdm.event.common.EventIntentEnum;
import cdm.event.qualification.functions.Qualify_Allocation;
import cdm.event.qualification.functions.Qualify_CashTransfer;
import cdm.event.qualification.functions.Qualify_Compression;
import cdm.event.qualification.functions.Qualify_CorporateActionDetermined;
import cdm.event.qualification.functions.Qualify_CreditEventDetermined;
import cdm.event.qualification.functions.Qualify_Exercise;
import cdm.event.qualification.functions.Qualify_Increase;
import cdm.event.qualification.functions.Qualify_IndexTransition;
import cdm.event.qualification.functions.Qualify_PartialNovation;
import cdm.event.qualification.functions.Qualify_PartialTermination;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.qualification.event.functions.IsActionTypeMODI;
import drr.regulation.common.TransactionReportInstruction;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(AmendmentIndicatorRule.AmendmentIndicatorRuleDefault.class)
public abstract class AmendmentIndicatorRule implements ReportFunction<TransactionReportInstruction, Boolean> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsActionTypeMODI isActionTypeMODI;
	@Inject protected Qualify_Allocation qualify_Allocation;
	@Inject protected Qualify_CashTransfer qualify_CashTransfer;
	@Inject protected Qualify_Compression qualify_Compression;
	@Inject protected Qualify_CorporateActionDetermined qualify_CorporateActionDetermined;
	@Inject protected Qualify_CreditEventDetermined qualify_CreditEventDetermined;
	@Inject protected Qualify_Exercise qualify_Exercise;
	@Inject protected Qualify_Increase qualify_Increase;
	@Inject protected Qualify_IndexTransition qualify_IndexTransition;
	@Inject protected Qualify_PartialNovation qualify_PartialNovation;
	@Inject protected Qualify_PartialTermination qualify_PartialTermination;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public Boolean evaluate(TransactionReportInstruction input) {
		Boolean output = doEvaluate(input);
		
		return output;
	}

	protected abstract Boolean doEvaluate(TransactionReportInstruction input);

	public static class AmendmentIndicatorRuleDefault extends AmendmentIndicatorRule {
		@Override
		protected Boolean doEvaluate(TransactionReportInstruction input) {
			Boolean output = null;
			return assignOutput(output, input);
		}
		
		protected Boolean assignOutput(Boolean output, TransactionReportInstruction input) {
			final MapperS<BusinessEvent> thenArg = MapperS.of(input)
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(isActionTypeMODI.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						return item.<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent());
					}
					return MapperS.<BusinessEvent>ofNull();
				});
			output = thenArg
				.mapSingleToItem(item -> {
					if (areEqual(MapperS.of(qualify_PartialNovation.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(true);
					}
					if (areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.NOVATION), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(true);
					}
					if (areEqual(MapperS.of(qualify_PartialTermination.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(true);
					}
					if (areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.DECREASE), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(true);
					}
					if (areEqual(MapperS.of(qualify_Compression.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(false);
					}
					if (areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.COMPRESSION), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(false);
					}
					if (areEqual(MapperS.of(qualify_Allocation.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(false);
					}
					if (areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.ALLOCATION), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(false);
					}
					if (areEqual(MapperS.of(qualify_Increase.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(true);
					}
					if (areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.INCREASE), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(true);
					}
					if (areEqual(MapperS.of(qualify_Exercise.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(false);
					}
					if (areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.OPTION_EXERCISE), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(false);
					}
					if (areEqual(MapperS.of(qualify_CashTransfer.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(false);
					}
					if (areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.CONTRACT_TERMS_AMENDMENT), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(true);
					}
					final Boolean boolean0 = qualify_CorporateActionDetermined.evaluate(item.get());
					if ((boolean0 == null ? false : boolean0)) {
						return MapperS.of(true);
					}
					if (areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.CORPORATE_ACTION_ADJUSTMENT), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(true);
					}
					final Boolean boolean1 = qualify_CreditEventDetermined.evaluate(item.get());
					if ((boolean1 == null ? false : boolean1)) {
						return MapperS.of(true);
					}
					if (areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.CREDIT_EVENT), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(true);
					}
					if (areEqual(MapperS.of(qualify_IndexTransition.evaluate(item.get())), MapperS.of(true), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(true);
					}
					if (areEqual(item.<EventIntentEnum>map("getIntent", businessEvent -> businessEvent.getIntent()), MapperS.of(EventIntentEnum.INDEX_TRANSITION), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of(true);
					}
					return MapperS.<Boolean>ofNull();
				}).get();
			
			return output;
		}
	}
}
