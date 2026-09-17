package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.FinancialUnitEnum;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.option.shared.OptionBaseExtended;
import fpml.consolidated.shared.Currency;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapOptionBaseExtendedQuantityListWithLocation.MapOptionBaseExtendedQuantityListWithLocationDefault.class)
public abstract class MapOptionBaseExtendedQuantityListWithLocation implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithLocation createQuantityWithLocation;
	@Inject protected MapMoneyToQuantity mapMoneyToQuantity;
	@Inject protected MapNumberOfOptionsAndOptionEntitlementToQuantity mapNumberOfOptionsAndOptionEntitlementToQuantity;

	/**
	* @param fpmlOptionBaseExtended 
	* @return quantityList 
	*/
	public List<? extends FieldWithMetaNonNegativeQuantitySchedule> evaluate(OptionBaseExtended fpmlOptionBaseExtended) {
		List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityListBuilder = doEvaluate(fpmlOptionBaseExtended);
		
		final List<? extends FieldWithMetaNonNegativeQuantitySchedule> quantityList;
		if (quantityListBuilder == null) {
			quantityList = null;
		} else {
			quantityList = quantityListBuilder.stream().map(FieldWithMetaNonNegativeQuantitySchedule::build).collect(Collectors.toList());
			objectValidator.validate(FieldWithMetaNonNegativeQuantitySchedule.class, quantityList);
		}
		
		return quantityList;
	}

	protected abstract List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(OptionBaseExtended fpmlOptionBaseExtended);

	public static class MapOptionBaseExtendedQuantityListWithLocationDefault extends MapOptionBaseExtendedQuantityListWithLocation {
		@Override
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> doEvaluate(OptionBaseExtended fpmlOptionBaseExtended) {
			List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityList = new ArrayList<>();
			return assignOutput(quantityList, fpmlOptionBaseExtended);
		}
		
		protected List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> assignOutput(List<FieldWithMetaNonNegativeQuantitySchedule.FieldWithMetaNonNegativeQuantityScheduleBuilder> quantityList, OptionBaseExtended fpmlOptionBaseExtended) {
			if (exists(MapperS.of(fpmlOptionBaseExtended).<Money>map("getNotionalAmount", optionBaseExtended -> optionBaseExtended.getNotionalAmount())).getOrDefault(false)) {
				final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule0 = createQuantityWithLocation.evaluate(mapMoneyToQuantity.evaluate(MapperS.of(fpmlOptionBaseExtended).<Money>map("getNotionalAmount", optionBaseExtended -> optionBaseExtended.getNotionalAmount()).get()), createQuantityKey.evaluate("notionalAmount", null));
				if (fieldWithMetaNonNegativeQuantitySchedule0 == null) {
					quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
				} else {
					quantityList.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule0)));
				}
			} else {
				quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			}
			
			if (exists(MapperS.of(fpmlOptionBaseExtended).<BigDecimal>map("getNumberOfOptions", optionBaseExtended -> optionBaseExtended.getNumberOfOptions())).getOrDefault(false)) {
				final FieldWithMetaNonNegativeQuantitySchedule fieldWithMetaNonNegativeQuantitySchedule1 = createQuantityWithLocation.evaluate(mapNumberOfOptionsAndOptionEntitlementToQuantity.evaluate(MapperS.of(fpmlOptionBaseExtended).<BigDecimal>map("getNumberOfOptions", optionBaseExtended -> optionBaseExtended.getNumberOfOptions()).get(), FinancialUnitEnum.CONTRACT, MapperS.of(fpmlOptionBaseExtended).<BigDecimal>map("getOptionEntitlement", optionBaseExtended -> optionBaseExtended.getOptionEntitlement()).get(), MapperS.of(fpmlOptionBaseExtended).<Currency>map("getEntitlementCurrency", optionBaseExtended -> optionBaseExtended.getEntitlementCurrency()).get()), createQuantityKey.evaluate("numberOfOptions", null));
				if (fieldWithMetaNonNegativeQuantitySchedule1 == null) {
					quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
				} else {
					quantityList.addAll(toBuilder(Collections.singletonList(fieldWithMetaNonNegativeQuantitySchedule1)));
				}
			} else {
				quantityList.addAll(toBuilder(Collections.<FieldWithMetaNonNegativeQuantitySchedule>emptyList()));
			}
			
			return Optional.ofNullable(quantityList)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
	}
}
