package cdm.ingest.fpml.confirmation.product.returnswap.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import cdm.ingest.fpml.confirmation.common.functions.MapResolvablePriceQuantityReference;
import cdm.ingest.fpml.confirmation.pricequantity.functions.MapNotionalAmountToQuantityWithAddress;
import cdm.product.common.settlement.ResolvablePriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.eq.shared.ReturnSwapNotional;
import fpml.consolidated.shared.Leg;
import fpml.consolidated.shared.NotionalAmount;
import fpml.consolidated.shared.ReturnSwapNotionalAmountReference;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapResolvablePriceQuantity.MapResolvablePriceQuantityDefault.class)
public abstract class MapResolvablePriceQuantity implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapNotionalAmountToQuantityWithAddress mapNotionalAmountToQuantityWithAddress;
	@Inject protected MapResolvablePriceQuantityReference mapResolvablePriceQuantityReference;

	/**
	* @param fpmlReturnSwapNotional 
	* @param fpmlReset 
	* @param fpmlLeg 
	* @param fpmlOtherReturnSwapNotional 
	* @param fpmlOtherLeg 
	* @return resolvablePriceQuantity 
	*/
	public ResolvablePriceQuantity evaluate(ReturnSwapNotional fpmlReturnSwapNotional, Boolean fpmlReset, Leg fpmlLeg, ReturnSwapNotional fpmlOtherReturnSwapNotional, Leg fpmlOtherLeg) {
		ResolvablePriceQuantity.ResolvablePriceQuantityBuilder resolvablePriceQuantityBuilder = doEvaluate(fpmlReturnSwapNotional, fpmlReset, fpmlLeg, fpmlOtherReturnSwapNotional, fpmlOtherLeg);
		
		final ResolvablePriceQuantity resolvablePriceQuantity;
		if (resolvablePriceQuantityBuilder == null) {
			resolvablePriceQuantity = null;
		} else {
			resolvablePriceQuantity = resolvablePriceQuantityBuilder.build();
			objectValidator.validate(ResolvablePriceQuantity.class, resolvablePriceQuantity);
		}
		
		return resolvablePriceQuantity;
	}

	protected abstract ResolvablePriceQuantity.ResolvablePriceQuantityBuilder doEvaluate(ReturnSwapNotional fpmlReturnSwapNotional, Boolean fpmlReset, Leg fpmlLeg, ReturnSwapNotional fpmlOtherReturnSwapNotional, Leg fpmlOtherLeg);

	public static class MapResolvablePriceQuantityDefault extends MapResolvablePriceQuantity {
		@Override
		protected ResolvablePriceQuantity.ResolvablePriceQuantityBuilder doEvaluate(ReturnSwapNotional fpmlReturnSwapNotional, Boolean fpmlReset, Leg fpmlLeg, ReturnSwapNotional fpmlOtherReturnSwapNotional, Leg fpmlOtherLeg) {
			ResolvablePriceQuantity.ResolvablePriceQuantityBuilder resolvablePriceQuantity = ResolvablePriceQuantity.builder();
			return assignOutput(resolvablePriceQuantity, fpmlReturnSwapNotional, fpmlReset, fpmlLeg, fpmlOtherReturnSwapNotional, fpmlOtherLeg);
		}
		
		protected ResolvablePriceQuantity.ResolvablePriceQuantityBuilder assignOutput(ResolvablePriceQuantity.ResolvablePriceQuantityBuilder resolvablePriceQuantity, ReturnSwapNotional fpmlReturnSwapNotional, Boolean fpmlReset, Leg fpmlLeg, ReturnSwapNotional fpmlOtherReturnSwapNotional, Leg fpmlOtherLeg) {
			final ReferenceWithMetaNonNegativeQuantitySchedule ifThenElseResult0;
			if (exists(MapperS.of(fpmlReturnSwapNotional).<NotionalAmount>map("getNotionalAmount", returnSwapNotional -> returnSwapNotional.getNotionalAmount()).<BigDecimal>map("getAmount", notionalAmount -> notionalAmount.getAmount())).getOrDefault(false)) {
				ifThenElseResult0 = mapNotionalAmountToQuantityWithAddress.evaluate(MapperS.of(fpmlReturnSwapNotional).<NotionalAmount>map("getNotionalAmount", returnSwapNotional -> returnSwapNotional.getNotionalAmount()).<BigDecimal>map("getAmount", notionalAmount -> notionalAmount.getAmount()).get(), fpmlLeg);
			} else if (exists(MapperS.of(fpmlReturnSwapNotional).<ReturnSwapNotionalAmountReference>map("getRelativeNotionalAmount", returnSwapNotional -> returnSwapNotional.getRelativeNotionalAmount()).<String>map("getHref", returnSwapNotionalAmountReference -> returnSwapNotionalAmountReference.getHref())).andNullSafe(areEqual(MapperS.of(fpmlReturnSwapNotional).<ReturnSwapNotionalAmountReference>map("getRelativeNotionalAmount", returnSwapNotional -> returnSwapNotional.getRelativeNotionalAmount()).<String>map("getHref", returnSwapNotionalAmountReference -> returnSwapNotionalAmountReference.getHref()), MapperS.of(fpmlOtherReturnSwapNotional).<NotionalAmount>map("getNotionalAmount", returnSwapNotional -> returnSwapNotional.getNotionalAmount()).<String>map("getId", notionalAmount -> notionalAmount.getId()), CardinalityOperator.All)).getOrDefault(false)) {
				ifThenElseResult0 = mapNotionalAmountToQuantityWithAddress.evaluate(MapperS.of(fpmlOtherReturnSwapNotional).<NotionalAmount>map("getNotionalAmount", returnSwapNotional -> returnSwapNotional.getNotionalAmount()).<BigDecimal>map("getAmount", notionalAmount -> notionalAmount.getAmount()).get(), fpmlOtherLeg);
			} else {
				ifThenElseResult0 = ReferenceWithMetaNonNegativeQuantitySchedule.builder().build();
			}
			Boolean ifThenElseResult1 = null;
			if (exists(MapperS.of(fpmlReturnSwapNotional).<NotionalAmount>map("getNotionalAmount", returnSwapNotional -> returnSwapNotional.getNotionalAmount()).<BigDecimal>map("getAmount", notionalAmount -> notionalAmount.getAmount())).getOrDefault(false)) {
				ifThenElseResult1 = fpmlReset;
			}
			final ResolvablePriceQuantity.ResolvablePriceQuantityBuilder withMetaArgument = ResolvablePriceQuantity.builder()
				.setQuantitySchedule(ifThenElseResult0)
				.setQuantityReference(mapResolvablePriceQuantityReference.evaluate(MapperS.of(fpmlReturnSwapNotional).<ReturnSwapNotionalAmountReference>map("getRelativeNotionalAmount", returnSwapNotional -> returnSwapNotional.getRelativeNotionalAmount()).<String>map("getHref", returnSwapNotionalAmountReference -> returnSwapNotionalAmountReference.getHref()).get()))
				.setReset(ifThenElseResult1)
				.build() == null ? null : ResolvablePriceQuantity.builder()
				.setQuantitySchedule(ifThenElseResult0)
				.setQuantityReference(mapResolvablePriceQuantityReference.evaluate(MapperS.of(fpmlReturnSwapNotional).<ReturnSwapNotionalAmountReference>map("getRelativeNotionalAmount", returnSwapNotional -> returnSwapNotional.getRelativeNotionalAmount()).<String>map("getHref", returnSwapNotionalAmountReference -> returnSwapNotionalAmountReference.getHref()).get()))
				.setReset(ifThenElseResult1)
				.build().toBuilder();
			withMetaArgument.getOrCreateMeta().setExternalKey(MapperS.of(fpmlReturnSwapNotional).<NotionalAmount>map("getNotionalAmount", returnSwapNotional -> returnSwapNotional.getNotionalAmount()).<String>map("getId", notionalAmount -> notionalAmount.getId()).get());
			resolvablePriceQuantity = toBuilder(withMetaArgument);
			
			return Optional.ofNullable(resolvablePriceQuantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
