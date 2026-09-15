package drr.regulation.common.emir.reports;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.trade.price.PriceNotationEnum;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg2Rule;
import drr.standards.iosco.cde.version3.price.reports.SpreadNotationEnumRule;
import drr.standards.iosco.cde.version3.price.reports.SpreadRule;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SpreadOfLeg2NotationRule.SpreadOfLeg2NotationRuleDefault.class)
public abstract class SpreadOfLeg2NotationRule implements ReportFunction<TransactionReportInstruction, PriceNotationEnum> {
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected NameOfTheFloatingRateOfLeg2Rule nameOfTheFloatingRateOfLeg2Rule;
	@Inject protected PayoutLeg2Rule payoutLeg2Rule;
	@Inject protected SpreadNotationEnumRule spreadNotationEnumRule;
	@Inject protected SpreadRule spreadRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceNotationEnum evaluate(TransactionReportInstruction input) {
		PriceNotationEnum output = doEvaluate(input);
		
		return output;
	}

	protected abstract PriceNotationEnum doEvaluate(TransactionReportInstruction input);

	public static class SpreadOfLeg2NotationRuleDefault extends SpreadOfLeg2NotationRule {
		@Override
		protected PriceNotationEnum doEvaluate(TransactionReportInstruction input) {
			PriceNotationEnum output = null;
			return assignOutput(output, input);
		}
		
		protected PriceNotationEnum assignOutput(PriceNotationEnum output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = thenArg
				.mapSingleToItem(item -> {
					final PriceSchedule priceSchedule = spreadRule.evaluate(payoutLeg2Rule.evaluate(item.get()));
					if ((priceSchedule == null ? exists(MapperS.<ReferenceWithMetaPriceSchedule>ofNull()).getOrDefault(false) : exists(MapperS.of(ReferenceWithMetaPriceSchedule.builder().setValue(priceSchedule).build())).getOrDefault(false))) {
						return MapperS.of(spreadNotationEnumRule.evaluate(payoutLeg2Rule.evaluate(item.get())));
					}
					final String string = nameOfTheFloatingRateOfLeg2Rule.evaluate(item.get());
					if ((string == null ? exists(MapperS.<FieldWithMetaString>ofNull()).getOrDefault(false) : exists(MapperS.of(FieldWithMetaString.builder().setValue(string).build())).getOrDefault(false))) {
						return MapperS.of(PriceNotationEnum.BASIS);
					}
					return MapperS.<PriceNotationEnum>ofNull();
				}).get();
			
			return output;
		}
	}
}
