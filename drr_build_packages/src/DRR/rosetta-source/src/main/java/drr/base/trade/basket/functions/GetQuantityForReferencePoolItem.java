package drr.base.trade.basket.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import cdm.product.asset.ReferencePoolItem;
import cdm.product.template.ConstituentWeight;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(GetQuantityForReferencePoolItem.GetQuantityForReferencePoolItemDefault.class)
public abstract class GetQuantityForReferencePoolItem implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param constituent 
	* @return result 
	*/
	public NonNegativeQuantitySchedule evaluate(ReferencePoolItem constituent) {
		NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder resultBuilder = doEvaluate(constituent);
		
		final NonNegativeQuantitySchedule result;
		if (resultBuilder == null) {
			result = null;
		} else {
			result = resultBuilder.build();
			objectValidator.validate(NonNegativeQuantitySchedule.class, result);
		}
		
		return result;
	}

	protected abstract NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(ReferencePoolItem constituent);

	public static class GetQuantityForReferencePoolItemDefault extends GetQuantityForReferencePoolItem {
		@Override
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder doEvaluate(ReferencePoolItem constituent) {
			NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder result = NonNegativeQuantitySchedule.builder();
			return assignOutput(result, constituent);
		}
		
		protected NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder assignOutput(NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder result, ReferencePoolItem constituent) {
			result = toBuilder(NonNegativeQuantitySchedule.builder()
				.setValue(MapperS.of(constituent).<ConstituentWeight>map("getConstituentWeight", referencePoolItem -> referencePoolItem.getConstituentWeight()).<BigDecimal>map("getBasketPercentage", constituentWeight -> constituentWeight.getBasketPercentage()).get())
				.setUnit(UnitType.builder()
					.setFinancialUnit(FinancialUnitEnum.WEIGHT)
					.build())
				.build());
			
			return Optional.ofNullable(result)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
