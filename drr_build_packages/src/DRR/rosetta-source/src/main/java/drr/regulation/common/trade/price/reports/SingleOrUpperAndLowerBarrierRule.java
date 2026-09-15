package drr.regulation.common.trade.price.reports;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.event.Trigger;
import cdm.observable.event.TriggerEvent;
import cdm.product.template.Knock;
import cdm.product.template.OptionFeature;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.price.BarrierPrice;
import drr.regulation.common.trade.price.SingleOrUpperAndLowerBarrier;
import drr.regulation.common.trade.price.functions.BarrierFromTriggerEvent;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SingleOrUpperAndLowerBarrierRule.SingleOrUpperAndLowerBarrierRuleDefault.class)
public abstract class SingleOrUpperAndLowerBarrierRule implements ReportFunction<TransactionReportInstruction, SingleOrUpperAndLowerBarrier> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected BarrierFromTriggerEvent barrierFromTriggerEvent;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected ProductForEvent productForEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public SingleOrUpperAndLowerBarrier evaluate(TransactionReportInstruction input) {
		SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder outputBuilder = doEvaluate(input);
		
		final SingleOrUpperAndLowerBarrier output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(SingleOrUpperAndLowerBarrier.class, output);
		}
		
		return output;
	}

	protected abstract SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder doEvaluate(TransactionReportInstruction input);

	public static class SingleOrUpperAndLowerBarrierRuleDefault extends SingleOrUpperAndLowerBarrierRule {
		@Override
		protected SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder doEvaluate(TransactionReportInstruction input) {
			SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder output = SingleOrUpperAndLowerBarrier.builder();
			return assignOutput(output, input);
		}
		
		protected SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder assignOutput(SingleOrUpperAndLowerBarrier.SingleOrUpperAndLowerBarrierBuilder output, TransactionReportInstruction input) {
			final MapperS<Knock> thenArg0 = MapperS.of(MapperS.of(economicTermsForProduct.evaluate(productForEvent.evaluate(input))).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<OptionFeature>map("getFeature", optionPayout -> optionPayout.getFeature()).<Knock>map("getKnock", optionFeature -> optionFeature.getKnock());
			BarrierPrice ifThenElseResult = null;
			if (areEqual(MapperS.of(MapperC.<TriggerEvent>of(thenArg0.<TriggerEvent>mapC("getKnockIn", knock -> knock.getKnockIn()), thenArg0.<TriggerEvent>mapC("getKnockOut", knock -> knock.getKnockOut())).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = barrierFromTriggerEvent.evaluate(MapperC.<TriggerEvent>of(thenArg0.<TriggerEvent>mapC("getKnockIn", knock -> knock.getKnockIn()), thenArg0.<TriggerEvent>mapC("getKnockOut", knock -> knock.getKnockOut())).get());
			}
			final MapperS<TriggerEvent> thenArg1;
			if (greaterThan(MapperS.of(MapperC.<TriggerEvent>of(thenArg0.<TriggerEvent>mapC("getKnockIn", knock -> knock.getKnockIn()), thenArg0.<TriggerEvent>mapC("getKnockOut", knock -> knock.getKnockOut())).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				thenArg1 = MapperC.<TriggerEvent>of(thenArg0.<TriggerEvent>mapC("getKnockIn", knock -> knock.getKnockIn()), thenArg0.<TriggerEvent>mapC("getKnockOut", knock -> knock.getKnockOut()))
					.min(item -> item.<Trigger>map("getTrigger", triggerEvent -> triggerEvent.getTrigger()).<PriceSchedule>mapC("getLevel", trigger -> trigger.getLevel()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())
						.min());
			} else {
				thenArg1 = MapperS.<TriggerEvent>ofNull();
			}
			final MapperS<TriggerEvent> thenArg2;
			if (greaterThan(MapperS.of(MapperC.<TriggerEvent>of(thenArg0.<TriggerEvent>mapC("getKnockIn", knock -> knock.getKnockIn()), thenArg0.<TriggerEvent>mapC("getKnockOut", knock -> knock.getKnockOut())).resultCount()), MapperS.of(1), CardinalityOperator.All).getOrDefault(false)) {
				thenArg2 = MapperC.<TriggerEvent>of(thenArg0.<TriggerEvent>mapC("getKnockIn", knock -> knock.getKnockIn()), thenArg0.<TriggerEvent>mapC("getKnockOut", knock -> knock.getKnockOut()))
					.max(item -> item.<Trigger>map("getTrigger", triggerEvent -> triggerEvent.getTrigger()).<PriceSchedule>mapC("getLevel", trigger -> trigger.getLevel()).<BigDecimal>map("getValue", priceSchedule -> priceSchedule.getValue())
						.max());
			} else {
				thenArg2 = MapperS.<TriggerEvent>ofNull();
			}
			output = toBuilder(MapperS.of(SingleOrUpperAndLowerBarrier.builder()
				.set_single(ifThenElseResult)
				.setLower(MapperS.of(barrierFromTriggerEvent.evaluate(thenArg1.get())).get())
				.setUpper(MapperS.of(barrierFromTriggerEvent.evaluate(thenArg2.get())).get())
				.build()).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
