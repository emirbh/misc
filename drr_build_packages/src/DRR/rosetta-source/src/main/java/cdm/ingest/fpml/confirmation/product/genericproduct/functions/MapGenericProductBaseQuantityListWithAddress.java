package cdm.ingest.fpml.confirmation.product.genericproduct.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityKey;
import cdm.ingest.fpml.confirmation.pricequantity.functions.CreateQuantityWithAddress;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.generic.GenericProduct;
import fpml.consolidated.shared.CashflowNotional;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapGenericProductBaseQuantityListWithAddress.MapGenericProductBaseQuantityListWithAddressDefault.class)
public abstract class MapGenericProductBaseQuantityListWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithAddress createQuantityWithAddress;

	/**
	* @param fpmlGenericProduct 
	* @return quantityList 
	*/
	public ReferenceWithMetaNonNegativeQuantitySchedule evaluate(GenericProduct fpmlGenericProduct) {
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityListBuilder = doEvaluate(fpmlGenericProduct);
		
		final ReferenceWithMetaNonNegativeQuantitySchedule quantityList;
		if (quantityListBuilder == null) {
			quantityList = null;
		} else {
			quantityList = quantityListBuilder.build();
			objectValidator.validate(ReferenceWithMetaNonNegativeQuantitySchedule.class, quantityList);
		}
		
		return quantityList;
	}

	protected abstract ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(GenericProduct fpmlGenericProduct);

	public static class MapGenericProductBaseQuantityListWithAddressDefault extends MapGenericProductBaseQuantityListWithAddress {
		@Override
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(GenericProduct fpmlGenericProduct) {
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityList = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(quantityList, fpmlGenericProduct);
		}
		
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder assignOutput(ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityList, GenericProduct fpmlGenericProduct) {
			if (exists(MapperS.of(fpmlGenericProduct).<CashflowNotional>mapC("getNotional", genericProduct -> genericProduct.getNotional())).getOrDefault(false)) {
				quantityList = toBuilder(createQuantityWithAddress.evaluate(createQuantityKey.evaluate("notional", null)));
			} else {
				quantityList = toBuilder(ReferenceWithMetaNonNegativeQuantitySchedule.builder().build());
			}
			
			return Optional.ofNullable(quantityList)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
