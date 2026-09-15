package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.base.math.QuantityChangeDirectionEnum;
import cdm.base.staticdata.party.Counterparty;
import cdm.event.common.PrimitiveInstruction;
import cdm.ingest.fpml.confirmation.party.functions.MapCounterpartyList;
import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.Payment;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapTerminationToPrimitiveInstruction.MapTerminationToPrimitiveInstructionDefault.class)
public abstract class MapTerminationToPrimitiveInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterpartyList mapCounterpartyList;
	@Inject protected MapQuantityChangeInstruction mapQuantityChangeInstruction;
	@Inject protected MapTransferInstruction mapTransferInstruction;

	/**
	* @param fpmlTrade 
	* @param fpmlTermination 
	* @return primitiveInstruction 
	*/
	public PrimitiveInstruction evaluate(Trade fpmlTrade, TradeNotionalChange fpmlTermination) {
		PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstructionBuilder = doEvaluate(fpmlTrade, fpmlTermination);
		
		final PrimitiveInstruction primitiveInstruction;
		if (primitiveInstructionBuilder == null) {
			primitiveInstruction = null;
		} else {
			primitiveInstruction = primitiveInstructionBuilder.build();
			objectValidator.validate(PrimitiveInstruction.class, primitiveInstruction);
		}
		
		return primitiveInstruction;
	}

	protected abstract PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(Trade fpmlTrade, TradeNotionalChange fpmlTermination);

	protected abstract MapperC<? extends Counterparty> counterpartyList(Trade fpmlTrade, TradeNotionalChange fpmlTermination);

	protected abstract MapperC<? extends Payment> terminationPayment(Trade fpmlTrade, TradeNotionalChange fpmlTermination);

	protected abstract MapperS<FeeTypeEnum> transferExpression(Trade fpmlTrade, TradeNotionalChange fpmlTermination);

	public static class MapTerminationToPrimitiveInstructionDefault extends MapTerminationToPrimitiveInstruction {
		@Override
		protected PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(Trade fpmlTrade, TradeNotionalChange fpmlTermination) {
			PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstruction = PrimitiveInstruction.builder();
			return assignOutput(primitiveInstruction, fpmlTrade, fpmlTermination);
		}
		
		protected PrimitiveInstruction.PrimitiveInstructionBuilder assignOutput(PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstruction, Trade fpmlTrade, TradeNotionalChange fpmlTermination) {
			primitiveInstruction = toBuilder(PrimitiveInstruction.builder()
				.setQuantityChange(mapQuantityChangeInstruction.evaluate(fpmlTermination, null, QuantityChangeDirectionEnum.REPLACE))
				.setTransfer(mapTransferInstruction.evaluate(terminationPayment(fpmlTrade, fpmlTermination).getMulti(), transferExpression(fpmlTrade, fpmlTermination).get()))
				.build());
			
			return Optional.ofNullable(primitiveInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends Counterparty> counterpartyList(Trade fpmlTrade, TradeNotionalChange fpmlTermination) {
			return MapperC.<Counterparty>of(mapCounterpartyList.evaluate(fpmlTrade));
		}
		
		@Override
		protected MapperC<? extends Payment> terminationPayment(Trade fpmlTrade, TradeNotionalChange fpmlTermination) {
			return MapperS.of(fpmlTermination).<Payment>mapC("getPayment", tradeNotionalChange -> tradeNotionalChange.getPayment());
		}
		
		@Override
		protected MapperS<FeeTypeEnum> transferExpression(Trade fpmlTrade, TradeNotionalChange fpmlTermination) {
			if (exists(MapperS.of(fpmlTermination)).getOrDefault(false)) {
				return MapperS.of(FeeTypeEnum.TERMINATION);
			}
			return MapperS.<FeeTypeEnum>ofNull();
		}
	}
}
