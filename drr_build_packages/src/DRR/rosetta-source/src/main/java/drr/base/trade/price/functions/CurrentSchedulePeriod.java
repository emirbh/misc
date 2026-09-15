package drr.base.trade.price.functions;

import cdm.base.datetime.DateRange;
import cdm.event.common.BusinessEvent;
import cdm.event.workflow.WorkflowStep;
import cdm.product.asset.CommodityPayout;
import cdm.product.qualification.functions.Qualify_Commodity_Forward;
import cdm.product.qualification.functions.Qualify_Commodity_Option;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.EconomicTerms;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.SchedulePeriod;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(CurrentSchedulePeriod.CurrentSchedulePeriodDefault.class)
public abstract class CurrentSchedulePeriod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_Commodity_Forward qualify_Commodity_Forward;
	@Inject protected Qualify_Commodity_Option qualify_Commodity_Option;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;

	/**
	* @param reportableEvent 
	* @return schedulePeriod 
	*/
	public SchedulePeriod evaluate(ReportableEventBase reportableEvent) {
		SchedulePeriod.SchedulePeriodBuilder schedulePeriodBuilder = doEvaluate(reportableEvent);
		
		final SchedulePeriod schedulePeriod;
		if (schedulePeriodBuilder == null) {
			schedulePeriod = null;
		} else {
			schedulePeriod = schedulePeriodBuilder.build();
			objectValidator.validate(SchedulePeriod.class, schedulePeriod);
		}
		
		return schedulePeriod;
	}

	protected abstract SchedulePeriod.SchedulePeriodBuilder doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<Date> eventDate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends EconomicTerms> product(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends CalculationSchedule> schedule(ReportableEventBase reportableEvent);

	public static class CurrentSchedulePeriodDefault extends CurrentSchedulePeriod {
		@Override
		protected SchedulePeriod.SchedulePeriodBuilder doEvaluate(ReportableEventBase reportableEvent) {
			SchedulePeriod.SchedulePeriodBuilder schedulePeriod = SchedulePeriod.builder();
			return assignOutput(schedulePeriod, reportableEvent);
		}
		
		protected SchedulePeriod.SchedulePeriodBuilder assignOutput(SchedulePeriod.SchedulePeriodBuilder schedulePeriod, ReportableEventBase reportableEvent) {
			if (lessThanEquals(eventDate(reportableEvent), schedule(reportableEvent).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<DateRange>map("getCalculationPeriod", _schedulePeriod -> _schedulePeriod.getCalculationPeriod()).<Date>map("getStartDate", dateRange -> dateRange.getStartDate())
				.min(), CardinalityOperator.All).getOrDefault(false)) {
				schedulePeriod = toBuilder(schedule(reportableEvent).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod())
					.min(item -> item.<DateRange>map("getCalculationPeriod", _schedulePeriod -> _schedulePeriod.getCalculationPeriod()).<Date>map("getStartDate", dateRange -> dateRange.getStartDate())).get());
			} else if (greaterThanEquals(eventDate(reportableEvent), schedule(reportableEvent).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<DateRange>map("getCalculationPeriod", _schedulePeriod -> _schedulePeriod.getCalculationPeriod()).<Date>map("getEndDate", dateRange -> dateRange.getEndDate())
				.max(), CardinalityOperator.All).getOrDefault(false)) {
				schedulePeriod = toBuilder(schedule(reportableEvent).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod())
					.max(item -> item.<DateRange>map("getCalculationPeriod", _schedulePeriod -> _schedulePeriod.getCalculationPeriod()).<Date>map("getStartDate", dateRange -> dateRange.getStartDate())).get());
			} else {
				final MapperC<SchedulePeriod> thenArg0 = schedule(reportableEvent).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod());
				final MapperC<SchedulePeriod> thenArg1 = thenArg0
					.filterItemNullSafe(item -> lessThanEquals(item.<DateRange>map("getCalculationPeriod", _schedulePeriod -> _schedulePeriod.getCalculationPeriod()).<Date>map("getStartDate", dateRange -> dateRange.getStartDate()), eventDate(reportableEvent), CardinalityOperator.All).andNullSafe(greaterThanEquals(item.<DateRange>map("getCalculationPeriod", _schedulePeriod -> _schedulePeriod.getCalculationPeriod()).<Date>map("getEndDate", dateRange -> dateRange.getEndDate()), eventDate(reportableEvent), CardinalityOperator.All)).get());
				schedulePeriod = toBuilder(MapperS.of(thenArg1.get()).get());
			}
			
			return Optional.ofNullable(schedulePeriod)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<Date> eventDate(ReportableEventBase reportableEvent) {
			return MapperS.of(reportableEvent).<WorkflowStep>map("getOriginatingWorkflowStep", reportableEventBase -> reportableEventBase.getOriginatingWorkflowStep()).<BusinessEvent>map("getBusinessEvent", workflowStep -> workflowStep.getBusinessEvent()).<Date>map("getEventDate", businessEvent -> businessEvent.getEventDate());
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> product(ReportableEventBase reportableEvent) {
			return MapperS.of(economicTermsForProduct.evaluate(productForEvent.evaluate(reportableEvent)));
		}
		
		@Override
		protected MapperS<? extends CalculationSchedule> schedule(ReportableEventBase reportableEvent) {
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(product(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(product(reportableEvent).get())))).getOrDefault(false)) {
				return product(reportableEvent).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<CalculationSchedule>map("getSchedule", commodityPayout -> commodityPayout.getSchedule())
					.first();
			}
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Option.evaluate(product(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swaption.evaluate(product(reportableEvent).get())))).getOrDefault(false)) {
				return MapperS.of(product(reportableEvent).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<CalculationSchedule>map("getSchedule", optionPayout -> optionPayout.getSchedule());
			}
			final Boolean _boolean = qualify_Commodity_Forward.evaluate(product(reportableEvent).get());
			if ((_boolean == null ? false : _boolean)) {
				return MapperS.of(product(reportableEvent).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<CalculationSchedule>map("getSchedule", settlementPayout -> settlementPayout.getSchedule());
			}
			return MapperS.<CalculationSchedule>ofNull();
		}
	}
}
