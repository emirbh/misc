package drr.standards.iosco.cde.version1.quantity.functions;

import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import cdm.product.template.OptionPayout;
import cdm.product.template.OptionTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(OptionAmountAndCurrency.OptionAmountAndCurrencyDefault.class)
public abstract class OptionAmountAndCurrency implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param optionPayout 
	* @param tradeLotQuantity 
	* @param optionType 
	* @return quantitySchedule 
	*/
	public NonNegativeQuantitySchedule evaluate(OptionPayout optionPayout, List<? extends NonNegativeQuantitySchedule> tradeLotQuantity, OptionTypeEnum optionType) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantityScheduleBuilder = doEvaluate(optionPayout, tradeLotQuantity, optionType);
		
		final NonNegativeQuantitySchedule quantitySchedule;
		if (quantityScheduleBuilder == null) {
			quantitySchedule = null;
		} else {
			quantitySchedule = quantityScheduleBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, quantitySchedule);
		}
		
		return quantitySchedule;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(OptionPayout optionPayout, List<? extends NonNegativeQuantitySchedule> tradeLotQuantity, OptionTypeEnum optionType);

	protected abstract MapperC<? extends NonNegativeQuantitySchedule> quantityFromTrade(OptionPayout optionPayout, List<? extends NonNegativeQuantitySchedule> tradeLotQuantity, OptionTypeEnum optionType);

	public static class OptionAmountAndCurrencyDefault extends OptionAmountAndCurrency {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(OptionPayout optionPayout, List<? extends NonNegativeQuantitySchedule> tradeLotQuantity, OptionTypeEnum optionType) {
			if (tradeLotQuantity == null) {
				tradeLotQuantity = Collections.emptyList();
			}
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantitySchedule = NonNegativeQuantitySchedule.builder();
			return assignOutput(quantitySchedule, optionPayout, tradeLotQuantity, optionType);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder quantitySchedule, OptionPayout optionPayout, List<? extends NonNegativeQuantitySchedule> tradeLotQuantity, OptionTypeEnum optionType) {
			if (areEqual(MapperS.of(optionPayout).<OptionTypeEnum>map("getOptionType", _optionPayout -> _optionPayout.getOptionType()), MapperS.of(optionType), CardinalityOperator.All).getOrDefault(false)) {
				final ReferenceWithMetaNonNegativeQuantitySchedule referenceWithMetaNonNegativeQuantitySchedule = MapperS.of(optionPayout).<ResolvablePriceQuantity>map("getPriceQuantity", _optionPayout -> _optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).get();
				if (referenceWithMetaNonNegativeQuantitySchedule == null) {
					quantitySchedule = null;
				} else {
					quantitySchedule = toBuilder(referenceWithMetaNonNegativeQuantitySchedule.getValue());
				}
			} else {
				quantitySchedule = toBuilder(quantityFromTrade(optionPayout, tradeLotQuantity, optionType).get());
			}
			
			return Optional.ofNullable(quantitySchedule)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends NonNegativeQuantitySchedule> quantityFromTrade(OptionPayout optionPayout, List<? extends NonNegativeQuantitySchedule> tradeLotQuantity, OptionTypeEnum optionType) {
			final MapperC<NonNegativeQuantitySchedule> thenArg = MapperC.<NonNegativeQuantitySchedule>of(tradeLotQuantity);
			return thenArg
				.filterItemNullSafe(item -> notEqual(item.<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()), MapperS.of(optionPayout).<ResolvablePriceQuantity>map("getPriceQuantity", _optionPayout -> _optionPayout.getPriceQuantity()).<ReferenceWithMetaNonNegativeQuantitySchedule>map("getQuantitySchedule", resolvablePriceQuantity -> resolvablePriceQuantity.getQuantitySchedule()).<NonNegativeQuantitySchedule>map("Type coercion", referenceWithMetaNonNegativeQuantitySchedule -> referenceWithMetaNonNegativeQuantitySchedule == null ? null : referenceWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()), CardinalityOperator.Any).get());
		}
	}
}
