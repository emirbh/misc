package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.option.shared.OptionBaseExtended;
import fpml.consolidated.shared.Money;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapOptionBaseExtendedQuantityListWithAddress.MapOptionBaseExtendedQuantityListWithAddressDefault.class)
public abstract class MapOptionBaseExtendedQuantityListWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithAddress createQuantityWithAddress;

	/**
	* @param fpmlOptionBaseExtended 
	* @return quantityList 
	*/
	public ReferenceWithMetaNonNegativeQuantitySchedule evaluate(OptionBaseExtended fpmlOptionBaseExtended) {
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityListBuilder = doEvaluate(fpmlOptionBaseExtended);
		
		final ReferenceWithMetaNonNegativeQuantitySchedule quantityList;
		if (quantityListBuilder == null) {
			quantityList = null;
		} else {
			quantityList = quantityListBuilder.build();
			objectValidator.validate(ReferenceWithMetaNonNegativeQuantitySchedule.class, quantityList);
		}
		
		return quantityList;
	}

	protected abstract ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(OptionBaseExtended fpmlOptionBaseExtended);

	public static class MapOptionBaseExtendedQuantityListWithAddressDefault extends MapOptionBaseExtendedQuantityListWithAddress {
		@Override
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(OptionBaseExtended fpmlOptionBaseExtended) {
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityList = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(quantityList, fpmlOptionBaseExtended);
		}
		
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder assignOutput(ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityList, OptionBaseExtended fpmlOptionBaseExtended) {
			if (exists(MapperS.of(fpmlOptionBaseExtended).<Money>map("getNotionalAmount", optionBaseExtended -> optionBaseExtended.getNotionalAmount())).getOrDefault(false)) {
				quantityList = toBuilder(createQuantityWithAddress.evaluate(createQuantityKey.evaluate("notionalAmount", null)));
			} else if (exists(MapperS.of(fpmlOptionBaseExtended).<BigDecimal>map("getNumberOfOptions", optionBaseExtended -> optionBaseExtended.getNumberOfOptions())).getOrDefault(false)) {
				quantityList = toBuilder(createQuantityWithAddress.evaluate(createQuantityKey.evaluate("numberOfOptions", null)));
			} else {
				quantityList = toBuilder(ReferenceWithMetaNonNegativeQuantitySchedule.builder().build());
			}
			
			return Optional.ofNullable(quantityList)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
