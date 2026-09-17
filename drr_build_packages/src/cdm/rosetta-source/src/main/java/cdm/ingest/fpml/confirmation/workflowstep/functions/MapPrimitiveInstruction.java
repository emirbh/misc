package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.event.common.PrimitiveInstruction;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.business.events.TradeAmendmentContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradeNovationContent;
import fpml.consolidated.doc.Trade;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapPrimitiveInstruction.MapPrimitiveInstructionDefault.class)
public abstract class MapPrimitiveInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapAmendmentToPrimitiveInstruction mapAmendmentToPrimitiveInstruction;
	@Inject protected MapNovationToPrimitiveInstruction mapNovationToPrimitiveInstruction;
	@Inject protected MapTerminationToPrimitiveInstruction mapTerminationToPrimitiveInstruction;
	@Inject protected MapTradeToPrimitiveInstruction mapTradeToPrimitiveInstruction;

	/**
	* @param fpmlTrade 
	* @param fpmlNovation 
	* @param fpmlTermination 
	* @param fpmlAmendment 
	* @return primitiveInstruction 
	*/
	public PrimitiveInstruction evaluate(Trade fpmlTrade, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment) {
		PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstructionBuilder = doEvaluate(fpmlTrade, fpmlNovation, fpmlTermination, fpmlAmendment);
		
		final PrimitiveInstruction primitiveInstruction;
		if (primitiveInstructionBuilder == null) {
			primitiveInstruction = null;
		} else {
			primitiveInstruction = primitiveInstructionBuilder.build();
			objectValidator.validate(PrimitiveInstruction.class, primitiveInstruction);
		}
		
		return primitiveInstruction;
	}

	protected abstract PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(Trade fpmlTrade, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment);

	public static class MapPrimitiveInstructionDefault extends MapPrimitiveInstruction {
		@Override
		protected PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(Trade fpmlTrade, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment) {
			PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstruction = PrimitiveInstruction.builder();
			return assignOutput(primitiveInstruction, fpmlTrade, fpmlNovation, fpmlTermination, fpmlAmendment);
		}
		
		protected PrimitiveInstruction.PrimitiveInstructionBuilder assignOutput(PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstruction, Trade fpmlTrade, TradeNovationContent fpmlNovation, TradeNotionalChange fpmlTermination, TradeAmendmentContent fpmlAmendment) {
			if (exists(MapperS.of(fpmlNovation)).getOrDefault(false)) {
				primitiveInstruction = toBuilder(mapNovationToPrimitiveInstruction.evaluate(fpmlNovation));
			} else if (exists(MapperS.of(fpmlTermination)).getOrDefault(false)) {
				primitiveInstruction = toBuilder(mapTerminationToPrimitiveInstruction.evaluate(fpmlTrade, fpmlTermination));
			} else if (exists(MapperS.of(fpmlAmendment)).getOrDefault(false)) {
				primitiveInstruction = toBuilder(mapAmendmentToPrimitiveInstruction.evaluate(fpmlTrade, fpmlAmendment));
			} else if (exists(MapperS.of(fpmlTrade)).getOrDefault(false)) {
				primitiveInstruction = toBuilder(mapTradeToPrimitiveInstruction.evaluate(fpmlTrade));
			} else {
				primitiveInstruction = null;
			}
			
			return Optional.ofNullable(primitiveInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
