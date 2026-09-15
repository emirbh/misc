package drr.enrichment.common.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.upi.AnnaDsbUpiRequestTypeEnum;
import drr.enrichment.upi.UpiData;
import drr.enrichment.upi.functions.API_AnnaDsbRetrieveUpi;
import drr.enrichment.upi.functions.Create_AnnaDsbUpiRequestFromReportableEvent;
import drr.regulation.common.ReportableInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.standards.iosco.upi.AnnaDsbUpiRecord;
import drr.standards.iosco.upi.AnnaDsbUpiRequest;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UpiPostEnrichmentDataRule.UpiPostEnrichmentDataRuleDefault.class)
public abstract class UpiPostEnrichmentDataRule implements ReportFunction<TransactionReportInstruction, AnnaDsbUpiRecord> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected API_AnnaDsbRetrieveUpi aPI_AnnaDsbRetrieveUpi;
	@Inject protected Create_AnnaDsbUpiRequestFromReportableEvent create_AnnaDsbUpiRequestFromReportableEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public AnnaDsbUpiRecord evaluate(TransactionReportInstruction input) {
		AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder outputBuilder = doEvaluate(input);
		
		final AnnaDsbUpiRecord output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(AnnaDsbUpiRecord.class, output);
		}
		
		return output;
	}

	protected abstract AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder doEvaluate(TransactionReportInstruction input);

	public static class UpiPostEnrichmentDataRuleDefault extends UpiPostEnrichmentDataRule {
		@Override
		protected AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder doEvaluate(TransactionReportInstruction input) {
			AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder output = AnnaDsbUpiRecord.builder();
			return assignOutput(output, input);
		}
		
		protected AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder assignOutput(AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder output, TransactionReportInstruction input) {
			if (notExists(MapperS.of(input).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformation -> reportableInformation.getEnrichment()).<UpiData>mapC("getUpiData", enrichmentData -> enrichmentData.getUpiData()).<Boolean>map("getUpiValidation", upiData -> upiData.getUpiValidation())).orNullSafe(areEqual(MapperS.of(input).<ReportableInformation>map("getReportableInformation", transactionReportInstruction -> transactionReportInstruction.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformation -> reportableInformation.getEnrichment()).<UpiData>mapC("getUpiData", enrichmentData -> enrichmentData.getUpiData()).<Boolean>map("getUpiValidation", upiData -> upiData.getUpiValidation()), MapperS.of(true), CardinalityOperator.Any)).getOrDefault(false)) {
				output = toBuilder(MapperS.of(input)
					.mapSingleToItem(item -> {
						if (areEqual(MapperS.of(create_AnnaDsbUpiRequestFromReportableEvent.evaluate(item.get())).<AnnaDsbUpiRequestTypeEnum>map("getRequestType", annaDsbUpiRequestAndType -> annaDsbUpiRequestAndType.getRequestType()), MapperS.of(AnnaDsbUpiRequestTypeEnum.PRODUCT_REQUEST), CardinalityOperator.All).getOrDefault(false)) {
							return MapperS.of(aPI_AnnaDsbRetrieveUpi.evaluate(MapperS.of(create_AnnaDsbUpiRequestFromReportableEvent.evaluate(item.get())).<AnnaDsbUpiRequest>map("getRequest", annaDsbUpiRequestAndType -> annaDsbUpiRequestAndType.getRequest()).get()));
						}
						return MapperS.<AnnaDsbUpiRecord>ofNull();
					}).get());
			} else {
				output = null;
			}
			
			return Optional.ofNullable(output)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
