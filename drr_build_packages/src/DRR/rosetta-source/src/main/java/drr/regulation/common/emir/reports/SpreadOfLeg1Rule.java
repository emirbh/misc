package drr.regulation.common.emir.reports;

import cdm.observable.asset.PriceSchedule;
import cdm.observable.asset.metafields.ReferenceWithMetaPriceSchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.event.functions.IsAllowableAction;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.functions.PriceFormatFromNotation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.trade.reports.PayoutLeg1Rule;
import drr.standards.iosco.cde.version3.price.reports.SpreadRule;
import drr.standards.iosco.cde.version3.price.reports.SpreadValueRule;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(SpreadOfLeg1Rule.SpreadOfLeg1RuleDefault.class)
public abstract class SpreadOfLeg1Rule implements ReportFunction<TransactionReportInstruction, PriceFormat> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected IsAllowableAction isAllowableAction;
	@Inject protected NameOfTheFloatingRateOfLeg1Rule nameOfTheFloatingRateOfLeg1Rule;
	@Inject protected PayoutLeg1Rule payoutLeg1Rule;
	@Inject protected PriceFormatFromNotation priceFormatFromNotation;
	@Inject protected SpreadOfLeg1NotationRule spreadOfLeg1NotationRule;
	@Inject protected SpreadRule spreadRule;
	@Inject protected SpreadValueRule spreadValueRule;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public PriceFormat evaluate(TransactionReportInstruction input) {
		PriceFormat.PriceFormatBuilder outputBuilder = doEvaluate(input);
		
		final PriceFormat output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(PriceFormat.class, output);
		}
		
		return output;
	}

	protected abstract PriceFormat.PriceFormatBuilder doEvaluate(TransactionReportInstruction input);

	public static class SpreadOfLeg1RuleDefault extends SpreadOfLeg1Rule {
		@Override
		protected PriceFormat.PriceFormatBuilder doEvaluate(TransactionReportInstruction input) {
			PriceFormat.PriceFormatBuilder output = PriceFormat.builder();
			return assignOutput(output, input);
		}
		
		protected PriceFormat.PriceFormatBuilder assignOutput(PriceFormat.PriceFormatBuilder output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableAction.evaluate(item.get()));
			output = toBuilder(thenArg
				.mapSingleToItem(item -> {
					final PriceSchedule priceSchedule = spreadRule.evaluate(payoutLeg1Rule.evaluate(item.get()));
					if ((priceSchedule == null ? exists(MapperS.<ReferenceWithMetaPriceSchedule>ofNull()).getOrDefault(false) : exists(MapperS.of(ReferenceWithMetaPriceSchedule.builder().setValue(priceSchedule).build())).getOrDefault(false))) {
						return MapperS.of(priceFormatFromNotation.evaluate(spreadValueRule.evaluate(payoutLeg1Rule.evaluate(item.get())), spreadOfLeg1NotationRule.evaluate(item.get())));
					}
					final String string = nameOfTheFloatingRateOfLeg1Rule.evaluate(item.get());
					if ((string == null ? exists(MapperS.<FieldWithMetaString>ofNull()).getOrDefault(false) : exists(MapperS.of(FieldWithMetaString.builder().setValue(string).build())).getOrDefault(false))) {
						return MapperS.of(PriceFormat.builder()
							.setBasis(BigDecimal.valueOf(0))
							.build());
					}
					return MapperS.<PriceFormat>ofNull();
				}).get());
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
