package cdm.ingest.fpml.confirmation.workflowstep.functions;

import cdm.base.staticdata.party.Counterparty;
import cdm.event.common.ContractFormationInstruction;
import cdm.event.common.PrimitiveInstruction;
import cdm.ingest.fpml.confirmation.legal.functions.MapLegalAgreementList;
import cdm.ingest.fpml.confirmation.party.functions.MapCounterpartyList;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.shared.Documentation;
import java.util.ArrayList;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(MapTradeToPrimitiveInstruction.MapTradeToPrimitiveInstructionDefault.class)
public abstract class MapTradeToPrimitiveInstruction implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected MapCounterpartyList mapCounterpartyList;
	@Inject protected MapLegalAgreementList mapLegalAgreementList;

	/**
	* @param fpmlTrade 
	* @return primitiveInstruction 
	*/
	public PrimitiveInstruction evaluate(Trade fpmlTrade) {
		PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstructionBuilder = doEvaluate(fpmlTrade);
		
		final PrimitiveInstruction primitiveInstruction;
		if (primitiveInstructionBuilder == null) {
			primitiveInstruction = null;
		} else {
			primitiveInstruction = primitiveInstructionBuilder.build();
			objectValidator.validate(PrimitiveInstruction.class, primitiveInstruction);
		}
		
		return primitiveInstruction;
	}

	protected abstract PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(Trade fpmlTrade);

	protected abstract MapperC<? extends Counterparty> counterpartyList(Trade fpmlTrade);

	public static class MapTradeToPrimitiveInstructionDefault extends MapTradeToPrimitiveInstruction {
		@Override
		protected PrimitiveInstruction.PrimitiveInstructionBuilder doEvaluate(Trade fpmlTrade) {
			PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstruction = PrimitiveInstruction.builder();
			return assignOutput(primitiveInstruction, fpmlTrade);
		}
		
		protected PrimitiveInstruction.PrimitiveInstructionBuilder assignOutput(PrimitiveInstruction.PrimitiveInstructionBuilder primitiveInstruction, Trade fpmlTrade) {
			primitiveInstruction = toBuilder(PrimitiveInstruction.builder()
				.setContractFormation(ContractFormationInstruction.builder()
					.setLegalAgreement(new ArrayList(mapLegalAgreementList.evaluate(MapperS.of(fpmlTrade).<Documentation>map("getDocumentation", trade -> trade.getDocumentation()).get(), counterpartyList(fpmlTrade).getMulti())))
					.build())
				.build());
			
			return Optional.ofNullable(primitiveInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperC<? extends Counterparty> counterpartyList(Trade fpmlTrade) {
			return MapperC.<Counterparty>of(mapCounterpartyList.evaluate(fpmlTrade));
		}
	}
}
