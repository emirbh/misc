package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.UnitType;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.asset.BasketConstituent;
import fpml.consolidated.asset.ConstituentWeight;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapBasketConstituentQuantity.MapBasketConstituentQuantityDefault.class)
public abstract class MapBasketConstituentQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param fpmlBasketConstituent 
	* @return quantity 
	*/
	public List<? extends NonNegativeQuantitySchedule> evaluate(BasketConstituent fpmlBasketConstituent) {
		List<NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder> quantityBuilder = doEvaluate(fpmlBasketConstituent);
		
		final List<? extends NonNegativeQuantitySchedule> quantity;
		if (quantityBuilder == null) {
			quantity = null;
		} else {
			quantity = quantityBuilder.stream().map(NonNegativeQuantitySchedule::build).collect(Collectors.toList());
			objectValidator.validate(NonNegativeQuantitySchedule.class, quantity);
		}
		
		return quantity;
	}

	protected abstract List<NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder> doEvaluate(BasketConstituent fpmlBasketConstituent);

	public static class MapBasketConstituentQuantityDefault extends MapBasketConstituentQuantity {
		@Override
		protected List<NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder> doEvaluate(BasketConstituent fpmlBasketConstituent) {
			List<NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder> quantity = new ArrayList<>();
			return assignOutput(quantity, fpmlBasketConstituent);
		}
		
		protected List<NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder> assignOutput(List<NonNegativeQuantitySchedule.NonNegativeQuantityScheduleBuilder> quantity, BasketConstituent fpmlBasketConstituent) {
			FinancialUnitEnum ifThenElseResult = null;
			if (exists(MapperS.of(fpmlBasketConstituent).<ConstituentWeight>map("getConstituentWeight", basketConstituent -> basketConstituent.getConstituentWeight()).<BigDecimal>map("getBasketPercentage", constituentWeight -> constituentWeight.getBasketPercentage())).getOrDefault(false)) {
				ifThenElseResult = FinancialUnitEnum.WEIGHT;
			}
			final NonNegativeQuantitySchedule nonNegativeQuantitySchedule = NonNegativeQuantitySchedule.builder()
				.setValue(MapperS.of(fpmlBasketConstituent).<ConstituentWeight>map("getConstituentWeight", basketConstituent -> basketConstituent.getConstituentWeight()).<BigDecimal>map("getBasketPercentage", constituentWeight -> constituentWeight.getBasketPercentage()).get())
				.setUnit(UnitType.builder()
					.setFinancialUnit(ifThenElseResult)
					.build())
				.build();
			if (nonNegativeQuantitySchedule == null) {
				quantity.addAll(toBuilder(Collections.<NonNegativeQuantitySchedule>emptyList()));
			} else {
				quantity.addAll(toBuilder(Collections.singletonList(nonNegativeQuantitySchedule)));
			}
			
			return Optional.ofNullable(quantity)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
