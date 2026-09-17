package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.base.math.QuantityChangeDirectionEnum;
import cdm.event.common.QuantityChangeInstruction;
import cdm.observable.asset.PriceQuantity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapQuantityChangeInstruction.MapQuantityChangeInstructionDefault.class)
public abstract class MapQuantityChangeInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapPriceQuantity mapPriceQuantity;

	/**
	* @param fpmlTradeNotionalChange 
	* @param fpmlNovation 
	* @param quantityChangeDirection 
	* @return quantityChange 
	*/
	public QuantityChangeInstruction evaluate(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation, QuantityChangeDirectionEnum quantityChangeDirection) {
		QuantityChangeInstruction.QuantityChangeInstructionBuilder quantityChangeBuilder = doEvaluate(fpmlTradeNotionalChange, fpmlNovation, quantityChangeDirection);
		
		final QuantityChangeInstruction quantityChange;
		if (quantityChangeBuilder == null) {
			quantityChange = null;
		} else {
			quantityChange = quantityChangeBuilder.build();
			objectValidator.validate(QuantityChangeInstruction.class, quantityChange);
		}
		
		return quantityChange;
	}

	protected abstract QuantityChangeInstruction.QuantityChangeInstructionBuilder doEvaluate(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation, QuantityChangeDirectionEnum quantityChangeDirection);

	protected abstract MapperC<? extends PriceQuantity> changeAmount(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation, QuantityChangeDirectionEnum quantityChangeDirection);

	public static class MapQuantityChangeInstructionDefault extends MapQuantityChangeInstruction {
		@Override
		protected QuantityChangeInstruction.QuantityChangeInstructionBuilder doEvaluate(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation, QuantityChangeDirectionEnum quantityChangeDirection) {
			QuantityChangeInstruction.QuantityChangeInstructionBuilder quantityChange = QuantityChangeInstruction.builder();
			return assignOutput(quantityChange, fpmlTradeNotionalChange, fpmlNovation, quantityChangeDirection);
		}
		
		protected QuantityChangeInstruction.QuantityChangeInstructionBuilder assignOutput(QuantityChangeInstruction.QuantityChangeInstructionBuilder quantityChange, TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation, QuantityChangeDirectionEnum quantityChangeDirection) {
			if (exists(changeAmount(fpmlTradeNotionalChange, fpmlNovation, quantityChangeDirection)).getOrDefault(false)) {
				quantityChange = toBuilder(QuantityChangeInstruction.builder()
					.setChange(new ArrayList<>(changeAmount(fpmlTradeNotionalChange, fpmlNovation, quantityChangeDirection).getMulti()))
					.setDirection(quantityChangeDirection)
					.build());
			} else {
				quantityChange = null;
			}
			
			return Optional.ofNullable(quantityChange)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends PriceQuantity> changeAmount(TradeNotionalChange fpmlTradeNotionalChange, TradeNovationContent fpmlNovation, QuantityChangeDirectionEnum quantityChangeDirection) {
			return MapperC.<PriceQuantity>of(mapPriceQuantity.evaluate(fpmlTradeNotionalChange, fpmlNovation));
		}
	}
}
