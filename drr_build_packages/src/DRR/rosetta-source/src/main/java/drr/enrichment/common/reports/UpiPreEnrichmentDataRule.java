package drr.enrichment.common.reports;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.ReportableInformationBase;
import drr.base.trade.TransactionReportInstructionBase;
import drr.enrichment.common.EnrichmentData;
import drr.enrichment.upi.AnnaDsbUpiRequestAndType;
import drr.enrichment.upi.AnnaDsbUpiRequestTypeEnum;
import drr.enrichment.upi.UpiData;
import drr.enrichment.upi.functions.Create_AnnaDsbUpiRequestFromReportableEvent;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UpiPreEnrichmentDataRule.UpiPreEnrichmentDataRuleDefault.class)
public abstract class UpiPreEnrichmentDataRule implements ReportFunction<TransactionReportInstructionBase, AnnaDsbUpiRequestAndType> {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_AnnaDsbUpiRequestFromReportableEvent create_AnnaDsbUpiRequestFromReportableEvent;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public AnnaDsbUpiRequestAndType evaluate(TransactionReportInstructionBase input) {
		AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder outputBuilder = doEvaluate(input);
		
		final AnnaDsbUpiRequestAndType output;
		if (outputBuilder == null) {
			output = null;
		} else {
			output = outputBuilder.build();
			objectValidator.validate(AnnaDsbUpiRequestAndType.class, output);
		}
		
		return output;
	}

	protected abstract AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder doEvaluate(TransactionReportInstructionBase input);

	public static class UpiPreEnrichmentDataRuleDefault extends UpiPreEnrichmentDataRule {
		@Override
		protected AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder doEvaluate(TransactionReportInstructionBase input) {
			AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder output = AnnaDsbUpiRequestAndType.builder();
			return assignOutput(output, input);
		}
		
		protected AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder assignOutput(AnnaDsbUpiRequestAndType.AnnaDsbUpiRequestAndTypeBuilder output, TransactionReportInstructionBase input) {
			if (notExists(MapperS.of(input).<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformationBase -> reportableInformationBase.getEnrichment()).<UpiData>mapC("getUpiData", enrichmentData -> enrichmentData.getUpiData()).<Boolean>map("getUpiValidation", upiData -> upiData.getUpiValidation())).orNullSafe(areEqual(MapperS.of(input).<ReportableInformationBase>map("getReportableInformation", transactionReportInstructionBase -> transactionReportInstructionBase.getReportableInformation()).<EnrichmentData>map("getEnrichment", reportableInformationBase -> reportableInformationBase.getEnrichment()).<UpiData>mapC("getUpiData", enrichmentData -> enrichmentData.getUpiData()).<Boolean>map("getUpiValidation", upiData -> upiData.getUpiValidation()), MapperS.of(true), CardinalityOperator.Any)).getOrDefault(false)) {
				output = toBuilder(MapperS.of(input)
					.mapSingleToItem(item -> {
						if (areEqual(MapperS.of(create_AnnaDsbUpiRequestFromReportableEvent.evaluate(item.get())).<AnnaDsbUpiRequestTypeEnum>map("getRequestType", annaDsbUpiRequestAndType -> annaDsbUpiRequestAndType.getRequestType()), MapperS.of(AnnaDsbUpiRequestTypeEnum.PRODUCT_REQUEST), CardinalityOperator.All).getOrDefault(false)) {
							return MapperS.of(create_AnnaDsbUpiRequestFromReportableEvent.evaluate(item.get()));
						}
						return MapperS.<AnnaDsbUpiRequestAndType>ofNull();
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
