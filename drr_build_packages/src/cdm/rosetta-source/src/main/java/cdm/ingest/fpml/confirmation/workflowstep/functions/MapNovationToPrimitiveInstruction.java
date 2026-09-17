package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.event.common.PrimitiveInstruction;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.business.events.TradeNovationContent;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapNovationToPrimitiveInstruction.MapNovationToPrimitiveInstructionDefault.class)
public abstract class MapNovationToPrimitiveInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapBreakdown mapBreakdown;

	/**
	* @param fpmlNovation 
	* @return primitiveInstruction 
	*/
	public PrimitiveInstruction evaluate(TradeNovationContent fpmlNovation) {
		PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstructionBuilder = doEvaluate(fpmlNovation);
		
		final PrimitiveInstruction primitiveInstruction;
		if (primitiveInstructionBuilder == null) {
			primitiveInstruction = null;
		} else {
			primitiveInstruction = primitiveInstructionBuilder.build();
			objectValidator.validate(PrimitiveInstruction.class, primitiveInstruction);
		}
		
		return primitiveInstruction;
	}

	protected abstract PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(TradeNovationContent fpmlNovation);

	public static class MapNovationToPrimitiveInstructionDefault extends MapNovationToPrimitiveInstruction {
		@Override
		protected PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(TradeNovationContent fpmlNovation) {
			PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstruction = PrimitiveInstruction.builder();
			return assignOutput(primitiveInstruction, fpmlNovation);
		}
		
		protected PrimitiveInstruction.PrimitiveInstructionBuilder assignOutput(PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstruction, TradeNovationContent fpmlNovation) {
			primitiveInstruction
				.getOrCreateSplit()
				.addBreakdown(MapperS.of(fpmlNovation)
					.mapSingleToList(item -> MapperC.<PrimitiveInstruction>of(mapBreakdown.evaluate(item.get()))).getMulti());
			
			return Optional.ofNullable(primitiveInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
