package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.event.common.PrimitiveInstruction;
import cdm.observable.asset.FeeTypeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.Payment;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapAmendmentToPrimitiveInstruction.MapAmendmentToPrimitiveInstructionDefault.class)
public abstract class MapAmendmentToPrimitiveInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapTransferInstruction mapTransferInstruction;

	/**
	* @param fpmlTrade 
	* @param fpmlAmendment 
	* @return primitiveInstruction 
	*/
	public PrimitiveInstruction evaluate(Trade fpmlTrade, TradeAmendmentContent fpmlAmendment) {
		PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstructionBuilder = doEvaluate(fpmlTrade, fpmlAmendment);
		
		final PrimitiveInstruction primitiveInstruction;
		if (primitiveInstructionBuilder == null) {
			primitiveInstruction = null;
		} else {
			primitiveInstruction = primitiveInstructionBuilder.build();
			objectValidator.validate(PrimitiveInstruction.class, primitiveInstruction);
		}
		
		return primitiveInstruction;
	}

	protected abstract PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(Trade fpmlTrade, TradeAmendmentContent fpmlAmendment);

	protected abstract MapperC<? extends Payment> payment(Trade fpmlTrade, TradeAmendmentContent fpmlAmendment);

	protected abstract MapperS<FeeTypeEnum> feeType(Trade fpmlTrade, TradeAmendmentContent fpmlAmendment);

	public static class MapAmendmentToPrimitiveInstructionDefault extends MapAmendmentToPrimitiveInstruction {
		@Override
		protected PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(Trade fpmlTrade, TradeAmendmentContent fpmlAmendment) {
			PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstruction = PrimitiveInstruction.builder();
			return assignOutput(primitiveInstruction, fpmlTrade, fpmlAmendment);
		}
		
		protected PrimitiveInstruction.PrimitiveInstructionBuilder assignOutput(PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstruction, Trade fpmlTrade, TradeAmendmentContent fpmlAmendment) {
			primitiveInstruction = toBuilder(PrimitiveInstruction.builder()
				.setTransfer(mapTransferInstruction.evaluate(payment(fpmlTrade, fpmlAmendment).getMulti(), feeType(fpmlTrade, fpmlAmendment).get()))
				.build());
			
			return Optional.ofNullable(primitiveInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends Payment> payment(Trade fpmlTrade, TradeAmendmentContent fpmlAmendment) {
			return MapperS.of(fpmlAmendment).<Payment>mapC("getPayment", tradeAmendmentContent -> tradeAmendmentContent.getPayment());
		}
		
		@Override
		protected MapperS<FeeTypeEnum> feeType(Trade fpmlTrade, TradeAmendmentContent fpmlAmendment) {
			if (exists(payment(fpmlTrade, fpmlAmendment)).getOrDefault(false)) {
				return MapperS.of(FeeTypeEnum.RENEGOTIATION);
			}
			return MapperS.<FeeTypeEnum>ofNull();
		}
	}
}
