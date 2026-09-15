package cdm.ingest.fpml.confirmation.pricequantity.functions;

import cdm.base.math.metafields.ReferenceWithMetaNonNegativeQuantitySchedule;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.fpmlenum.StrikeQuoteBasisEnum;
import fpml.consolidated.fx.FxOption;
import fpml.consolidated.fx.FxStrikePrice;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapFxOptionQuantityWithAddress.MapFxOptionQuantityWithAddressDefault.class)
public abstract class MapFxOptionQuantityWithAddress implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected CreateQuantityKey createQuantityKey;
	@Inject protected CreateQuantityWithAddress createQuantityWithAddress;

	/**
	* @param fpmlFxOption 
	* @return quantity 
	*/
	public ReferenceWithMetaNonNegativeQuantitySchedule evaluate(FxOption fpmlFxOption) {
		ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantityBuilder = doEvaluate(fpmlFxOption);
		
		final ReferenceWithMetaNonNegativeQuantitySchedule quantity;
		if (quantityBuilder == null) {
			quantity = null;
		} else {
			quantity = quantityBuilder.build();
			objectValidator.validate(ReferenceWithMetaNonNegativeQuantitySchedule.class, quantity);
		}
		
		return quantity;
	}

	protected abstract ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(FxOption fpmlFxOption);

	public static class MapFxOptionQuantityWithAddressDefault extends MapFxOptionQuantityWithAddress {
		@Override
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder doEvaluate(FxOption fpmlFxOption) {
			ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantity = ReferenceWithMetaNonNegativeQuantitySchedule.builder();
			return assignOutput(quantity, fpmlFxOption);
		}
		
		protected ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder assignOutput(ReferenceWithMetaNonNegativeQuantitySchedule.ReferenceWithMetaNonNegativeQuantityScheduleBuilder quantity, FxOption fpmlFxOption) {
			if (areEqual(MapperS.of(fpmlFxOption).<FxStrikePrice>map("getStrike", fxOption -> fxOption.getStrike()).<StrikeQuoteBasisEnum>map("getStrikeQuoteBasis", fxStrikePrice -> fxStrikePrice.getStrikeQuoteBasis()), MapperS.of(StrikeQuoteBasisEnum.CALL_CURRENCY_PER_PUT_CURRENCY), CardinalityOperator.All).getOrDefault(false)) {
				quantity = toBuilder(createQuantityWithAddress.evaluate(createQuantityKey.evaluate("putCurrencyAmount", null)));
			} else {
				quantity = toBuilder(createQuantityWithAddress.evaluate(createQuantityKey.evaluate("callCurrencyAmount", null)));
			}
			
			return Optional.ofNullable(quantity)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
