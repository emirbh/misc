package drr.enrichment.common.test.functions;

import cdm.base.staticdata.party.Party;
import cdm.base.staticdata.party.PartyIdentifier;
import cdm.base.staticdata.party.PartyIdentifierTypeEnum;
import cdm.event.workflow.WorkflowStep;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RuneLabelProvider;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.transform.Enrich;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.enrichment.common.test.labels.Enrich_TransactionReportInstructionTestPackPreEnrichLabelProvider;
import drr.enrichment.lei.functions.API_GetLeiData;
import drr.regulation.common.ReportableEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iso.functions.API_GetMicData;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@RuneLabelProvider(labelProvider=Enrich_TransactionReportInstructionTestPackPreEnrichLabelProvider.class)
@Enrich()
@ImplementedBy(Enrich_TransactionReportInstructionTestPackPreEnrich.Enrich_TransactionReportInstructionTestPackPreEnrichDefault.class)
public abstract class Enrich_TransactionReportInstructionTestPackPreEnrich implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected API_GetLeiData aPI_GetLeiData;
	@Inject protected API_GetMicData aPI_GetMicData;
	@Inject protected Enrich_TransactionReportInstructionTestPackDefault enrich_TransactionReportInstructionTestPackDefault;

	/**
	* @param reportableEvent Reportable event containing a proposed business event (i.e. the output sample from an Ingestion).
	* @return preEnrichedTransactionReportInstruction Transaction report instruction containing business event and a reporting side (i.e. the input sample for a Report).
	*/
	public TransactionReportInstruction evaluate(ReportableEvent reportableEvent) {
		TransactionReportInstruction.TransactionReportInstructionBuilder preEnrichedTransactionReportInstructionBuilder = doEvaluate(reportableEvent);
		
		final TransactionReportInstruction preEnrichedTransactionReportInstruction;
		if (preEnrichedTransactionReportInstructionBuilder == null) {
			preEnrichedTransactionReportInstruction = null;
		} else {
			preEnrichedTransactionReportInstruction = preEnrichedTransactionReportInstructionBuilder.build();
			objectValidator.validate(TransactionReportInstruction.class, preEnrichedTransactionReportInstruction);
		}
		
		return preEnrichedTransactionReportInstruction;
	}

	protected abstract TransactionReportInstruction.TransactionReportInstructionBuilder doEvaluate(ReportableEvent reportableEvent);

	public static class Enrich_TransactionReportInstructionTestPackPreEnrichDefault extends Enrich_TransactionReportInstructionTestPackPreEnrich {
		@Override
		protected TransactionReportInstruction.TransactionReportInstructionBuilder doEvaluate(ReportableEvent reportableEvent) {
			TransactionReportInstruction.TransactionReportInstructionBuilder preEnrichedTransactionReportInstruction = TransactionReportInstruction.builder();
			return assignOutput(preEnrichedTransactionReportInstruction, reportableEvent);
		}
		
		protected TransactionReportInstruction.TransactionReportInstructionBuilder assignOutput(TransactionReportInstruction.TransactionReportInstructionBuilder preEnrichedTransactionReportInstruction, ReportableEvent reportableEvent) {
			preEnrichedTransactionReportInstruction = toBuilder(enrich_TransactionReportInstructionTestPackDefault.evaluate(reportableEvent), () -> TransactionReportInstruction.builder());
			
			final MapperC<PartyIdentifier> thenArg0 = MapperS.of(preEnrichedTransactionReportInstruction).<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<Party>mapC("getParty", workflowStep -> workflowStep.getParty()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId())
				.filterItemNullSafe(item -> areEqual(item.<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.LEI), CardinalityOperator.All).get());
			final MapperC<PartyIdentifier> thenArg1 = distinctIgnoringPrecision(thenArg0);
			preEnrichedTransactionReportInstruction
				.getOrCreateReportableInformation()
				.getOrCreateEnrichment()
				.addLeiData(thenArg1
					.mapItem(item -> {
						final FieldWithMetaString fieldWithMetaString = item.<FieldWithMetaString>map("getIdentifier", partyIdentifier -> partyIdentifier.getIdentifier()).get();
						return MapperS.of(aPI_GetLeiData.evaluate((fieldWithMetaString == null ? null : fieldWithMetaString.getValue())));
					}).getMulti());
			
			final MapperC<PartyIdentifier> thenArg2 = MapperS.of(preEnrichedTransactionReportInstruction).<WorkflowStep>map("getOriginatingWorkflowStep", transactionReportInstruction -> transactionReportInstruction.getOriginatingWorkflowStep()).<Party>mapC("getParty", workflowStep -> workflowStep.getParty()).<PartyIdentifier>mapC("getPartyId", party -> party.getPartyId())
				.filterItemNullSafe(item -> areEqual(item.<PartyIdentifierTypeEnum>map("getIdentifierType", partyIdentifier -> partyIdentifier.getIdentifierType()), MapperS.of(PartyIdentifierTypeEnum.MIC), CardinalityOperator.All).get());
			final MapperC<PartyIdentifier> thenArg3 = distinctIgnoringPrecision(thenArg2);
			preEnrichedTransactionReportInstruction
				.getOrCreateReportableInformation()
				.getOrCreateEnrichment()
				.addMicData(thenArg3
					.mapItem(item -> {
						final FieldWithMetaString fieldWithMetaString = item.<FieldWithMetaString>map("getIdentifier", partyIdentifier -> partyIdentifier.getIdentifier()).get();
						return MapperS.of(aPI_GetMicData.evaluate((fieldWithMetaString == null ? null : fieldWithMetaString.getValue())));
					}).getMulti());
			
			return Optional.ofNullable(preEnrichedTransactionReportInstruction)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
