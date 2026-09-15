package cdm.ingest.fpml.confirmation.product.fra.functions;

import cdm.ingest.fpml.confirmation.other.functions.MapDiscountingTypeEnum;
import cdm.product.asset.DiscountingMethod;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.FraDiscountingEnum;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapFraDiscountingMethod.MapFraDiscountingMethodDefault.class)
public abstract class MapFraDiscountingMethod implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapDiscountingTypeEnum mapDiscountingTypeEnum;

	/**
	* @param fpmlFraDiscounting 
	* @return discountingMethod 
	*/
	public DiscountingMethod evaluate(FraDiscountingEnum fpmlFraDiscounting) {
		DiscountingMethod.DiscountingMethodBuilder discountingMethodBuilder = doEvaluate(fpmlFraDiscounting);
		
		final DiscountingMethod discountingMethod;
		if (discountingMethodBuilder == null) {
			discountingMethod = null;
		} else {
			discountingMethod = discountingMethodBuilder.build();
			objectValidator.validate(DiscountingMethod.class, discountingMethod);
		}
		
		return discountingMethod;
	}

	protected abstract DiscountingMethod.DiscountingMethodBuilder doEvaluate(FraDiscountingEnum fpmlFraDiscounting);

	public static class MapFraDiscountingMethodDefault extends MapFraDiscountingMethod {
		@Override
		protected DiscountingMethod.DiscountingMethodBuilder doEvaluate(FraDiscountingEnum fpmlFraDiscounting) {
			DiscountingMethod.DiscountingMethodBuilder discountingMethod = DiscountingMethod.builder();
			return assignOutput(discountingMethod, fpmlFraDiscounting);
		}
		
		protected DiscountingMethod.DiscountingMethodBuilder assignOutput(DiscountingMethod.DiscountingMethodBuilder discountingMethod, FraDiscountingEnum fpmlFraDiscounting) {
			discountingMethod = toBuilder(DiscountingMethod.builder()
				.setDiscountingType(mapDiscountingTypeEnum.evaluate(MapperS.of(fpmlFraDiscounting).map("to-string", FraDiscountingEnum::toDisplayString).get()))
				.build());
			
			return Optional.ofNullable(discountingMethod)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
