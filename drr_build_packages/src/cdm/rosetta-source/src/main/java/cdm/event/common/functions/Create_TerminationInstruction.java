package cdm.event.common.functions;

import cdm.base.datetime.AdjustableOrRelativeDate;
import cdm.base.math.NonNegativeQuantitySchedule;
import cdm.base.math.QuantityChangeDirectionEnum;
import cdm.base.math.UnitType;
import cdm.base.math.metafields.FieldWithMetaNonNegativeQuantitySchedule;
import cdm.base.staticdata.identifier.Identifier;
import cdm.event.common.PrimitiveInstruction;
import cdm.event.common.QuantityChangeInstruction;
import cdm.event.common.Trade;
import cdm.event.common.TradeState;
import cdm.observable.asset.PriceQuantity;
import cdm.product.template.TradeLot;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_TerminationInstruction.Create_TerminationInstructionDefault.class)
public abstract class Create_TerminationInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param tradeState The original trade to be termintaed.
	* @param effectiveDate Date of Termination
	* @return instruction 
	*/
	public PrimitiveInstruction evaluate(TradeState tradeState, AdjustableOrRelativeDate effectiveDate) {
		PrimitiveInstruction.PrimitiveInstructionBuilder instructionBuilder = doEvaluate(tradeState, effectiveDate);
		
		final PrimitiveInstruction instruction;
		if (instructionBuilder == null) {
			instruction = null;
		} else {
			instruction = instructionBuilder.build();
			objectValidator.validate(PrimitiveInstruction.class, instruction);
		}
		
		return instruction;
	}

	protected abstract PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(TradeState tradeState, AdjustableOrRelativeDate effectiveDate);

	protected abstract MapperC<? extends NonNegativeQuantitySchedule> changeQuantity(TradeState tradeState, AdjustableOrRelativeDate effectiveDate);

	protected abstract MapperS<? extends PriceQuantity> changePriceQuantity(TradeState tradeState, AdjustableOrRelativeDate effectiveDate);

	public static class Create_TerminationInstructionDefault extends Create_TerminationInstruction {
		@Override
		protected PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(TradeState tradeState, AdjustableOrRelativeDate effectiveDate) {
			PrimitiveInstruction.PrimitiveInstructionBuilder instruction = PrimitiveInstruction.builder();
			return assignOutput(instruction, tradeState, effectiveDate);
		}
		
		protected PrimitiveInstruction.PrimitiveInstructionBuilder assignOutput(PrimitiveInstruction.PrimitiveInstructionBuilder instruction, TradeState tradeState, AdjustableOrRelativeDate effectiveDate) {
			instruction
				.setQuantityChange(QuantityChangeInstruction.builder()
					.setChange(new ArrayList<>(changePriceQuantity(tradeState, effectiveDate).getMulti()))
					.setDirection(QuantityChangeDirectionEnum.REPLACE)
					.setLotIdentifier(Collections.<Identifier>emptyList())
					.build());
			
			return Optional.ofNullable(instruction)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends NonNegativeQuantitySchedule> changeQuantity(TradeState tradeState, AdjustableOrRelativeDate effectiveDate) {
			final MapperC<NonNegativeQuantitySchedule> thenArg = MapperS.of(MapperS.of(tradeState).<Trade>map("getTrade", _tradeState -> _tradeState.getTrade()).<TradeLot>mapC("getTradeLot", trade -> trade.getTradeLot()).get()).<PriceQuantity>mapC("getPriceQuantity", tradeLot -> tradeLot.getPriceQuantity()).<FieldWithMetaNonNegativeQuantitySchedule>mapC("getQuantity", priceQuantity -> priceQuantity.getQuantity())
				.mapItem(item -> MapperS.of(NonNegativeQuantitySchedule.builder()
					.setValue(new BigDecimal("0.0"))
					.setUnit(item.<NonNegativeQuantitySchedule>map("Type coercion", fieldWithMetaNonNegativeQuantitySchedule -> fieldWithMetaNonNegativeQuantitySchedule == null ? null : fieldWithMetaNonNegativeQuantitySchedule.getValue()).<UnitType>map("getUnit", nonNegativeQuantitySchedule -> nonNegativeQuantitySchedule.getUnit()).get())
					.build()));
			return distinct(thenArg);
		}
		
		@Override
		protected MapperS<? extends PriceQuantity> changePriceQuantity(TradeState tradeState, AdjustableOrRelativeDate effectiveDate) {
			return MapperS.of(PriceQuantity.builder()
				.setQuantityValue(new ArrayList<>(changeQuantity(tradeState, effectiveDate).getMulti()))
				.setEffectiveDate(effectiveDate)
				.build());
		}
	}
}
