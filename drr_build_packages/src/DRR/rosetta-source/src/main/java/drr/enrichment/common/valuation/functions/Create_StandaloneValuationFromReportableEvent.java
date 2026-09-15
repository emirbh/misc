package drr.enrichment.common.valuation.functions;

import cdm.base.staticdata.identifier.Identifier;
import cdm.event.workflow.WorkflowStep;
import cdm.product.collateral.Collateral;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.functions.TradeForEvent;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.ReportableValuation;
import drr.standards.iosco.cde.version3.event.reports.LevelRule;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_StandaloneValuationFromReportableEvent.Create_StandaloneValuationFromReportableEventDefault.class)
public abstract class Create_StandaloneValuationFromReportableEvent implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_ValuationDetailsFromReportableEvent create_ValuationDetailsFromReportableEvent;
	@Inject protected LevelRule levelRule;
	@Inject protected TradeForEvent tradeForEvent;

	/**
	* @param reportableEvent 
	* @param regimeNameEnum 
	* @return standaloneValuation 
	*/
	public ReportableValuation evaluate(ReportableEvent reportableEvent, RegimeNameEnum regimeNameEnum) {
		ReportableValuation.ReportableValuationBuilder standaloneValuationBuilder = doEvaluate(reportableEvent, regimeNameEnum);
		
		final ReportableValuation standaloneValuation;
		if (standaloneValuationBuilder == null) {
			standaloneValuation = null;
		} else {
			standaloneValuation = standaloneValuationBuilder.build();
			objectValidator.validate(ReportableValuation.class, standaloneValuation);
		}
		
		return standaloneValuation;
	}

	protected abstract ReportableValuation.ReportableValuationBuilder doEvaluate(ReportableEvent reportableEvent, RegimeNameEnum regimeNameEnum);

	public static class Create_StandaloneValuationFromReportableEventDefault extends Create_StandaloneValuationFromReportableEvent {
		@Override
		protected ReportableValuation.ReportableValuationBuilder doEvaluate(ReportableEvent reportableEvent, RegimeNameEnum regimeNameEnum) {
			ReportableValuation.ReportableValuationBuilder standaloneValuation = ReportableValuation.builder();
			return assignOutput(standaloneValuation, reportableEvent, regimeNameEnum);
		}
		
		protected ReportableValuation.ReportableValuationBuilder assignOutput(ReportableValuation.ReportableValuationBuilder standaloneValuation, ReportableEvent reportableEvent, RegimeNameEnum regimeNameEnum) {
			standaloneValuation = toBuilder(ReportableValuation.builder()
				.setValuationDetails(create_ValuationDetailsFromReportableEvent.evaluate(reportableEvent, regimeNameEnum))
				.setReportableInformation(MapperS.of(reportableEvent).<ReportableInformation>map("getReportableInformation", _reportableEvent -> _reportableEvent.getReportableInformation()).get())
				.setCollateralDetails(MapperS.of(tradeForEvent.evaluate(reportableEvent)).<Collateral>map("getCollateral", trade -> trade.getCollateral()).get())
				.setEventIdentifier(MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", _reportableEvent -> _reportableEvent.getOriginatingWorkflowStep()).<Identifier>mapC("getEventIdentifier", workflowStep -> workflowStep.getEventIdentifier()).getMulti())
				.setLevel(levelRule.evaluate(reportableEvent))
				.build());
			
			return Optional.ofNullable(standaloneValuation)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
