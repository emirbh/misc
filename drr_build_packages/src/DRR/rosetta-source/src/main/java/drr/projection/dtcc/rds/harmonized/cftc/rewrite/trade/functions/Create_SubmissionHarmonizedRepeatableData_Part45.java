package drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCPart45TransactionReport;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.dtcc.trade.ProductGradeReport;
import iso20022.dtcc.rds.harmonized.HarmonizedRepeatableData;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_SubmissionHarmonizedRepeatableData_Part45.Create_SubmissionHarmonizedRepeatableData_Part45Default.class)
public abstract class Create_SubmissionHarmonizedRepeatableData_Part45 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected RequiresUpFrontFeeProjection requiresUpFrontFeeProjection;

	/**
	* @param drrReport 
	* @param commonHarmonized 
	* @return harmonized 
	*/
	public HarmonizedRepeatableData evaluate(CFTCPart45TransactionReport drrReport, HarmonizedRepeatableData commonHarmonized) {
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder harmonizedBuilder = doEvaluate(drrReport, commonHarmonized);
		
		final HarmonizedRepeatableData harmonized;
		if (harmonizedBuilder == null) {
			harmonized = null;
		} else {
			harmonized = harmonizedBuilder.build();
			objectValidator.validate(HarmonizedRepeatableData.class, harmonized);
		}
		
		return harmonized;
	}

	protected abstract HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder doEvaluate(CFTCPart45TransactionReport drrReport, HarmonizedRepeatableData commonHarmonized);

	protected abstract MapperS<Boolean> needsUpfrontFee(CFTCPart45TransactionReport drrReport, HarmonizedRepeatableData commonHarmonized);

	public static class Create_SubmissionHarmonizedRepeatableData_Part45Default extends Create_SubmissionHarmonizedRepeatableData_Part45 {
		@Override
		protected HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder doEvaluate(CFTCPart45TransactionReport drrReport, HarmonizedRepeatableData commonHarmonized) {
			HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder harmonized = HarmonizedRepeatableData.builder();
			return assignOutput(harmonized, drrReport, commonHarmonized);
		}
		
		protected HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder assignOutput(HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder harmonized, CFTCPart45TransactionReport drrReport, HarmonizedRepeatableData commonHarmonized) {
			harmonized = toBuilder(commonHarmonized, () -> HarmonizedRepeatableData.builder());
			
			harmonized
				.addCdeOtherPaymentPayer(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getOtherPayment()).<String>map("getPayer", otherPayment -> otherPayment.getPayer()).getMulti());
			
			harmonized
				.addCdeOtherPaymentReceiver(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getOtherPayment()).<String>map("getReceiver", otherPayment -> otherPayment.getReceiver()).getMulti());
			
			harmonized
				.addCdeOtherPaymentDate(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getOtherPayment()).<Date>map("getDate", otherPayment -> otherPayment.getDate()).getMulti());
			
			harmonized
				.addClearingExceptionTypeParty2(MapperS.of(drrReport).<ClearingExceptionsAndExemptionsEnum>mapC("getClearingExceptionsAndExemptionsCounterparty2", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getClearingExceptionsAndExemptionsCounterparty2())
					.mapItem(item -> item.map("to-string", ClearingExceptionsAndExemptionsEnum::toDisplayString)).getMulti());
			
			final List<String> ifThenElseResult0;
			if (needsUpfrontFee(drrReport, commonHarmonized).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getBuyerIdentifier", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getBuyerIdentifier()).getMulti();
			} else {
				ifThenElseResult0 = Collections.<String>emptyList();
			}
			harmonized
				.addCdeOtherPaymentPayer(ifThenElseResult0);
			
			final List<String> ifThenElseResult1;
			if (needsUpfrontFee(drrReport, commonHarmonized).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(drrReport).<String>map("getSellerIdentifier", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getSellerIdentifier()).getMulti();
			} else {
				ifThenElseResult1 = Collections.<String>emptyList();
			}
			harmonized
				.addCdeOtherPaymentReceiver(ifThenElseResult1);
			
			final List<Date> ifThenElseResult2;
			if (needsUpfrontFee(drrReport, commonHarmonized).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<Date>map("getEffectiveDate", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getEffectiveDate()).getMulti();
			} else {
				ifThenElseResult2 = Collections.<Date>emptyList();
			}
			harmonized
				.addCdeOtherPaymentDate(ifThenElseResult2);
			
			harmonized
				.addClearingSwapUsiId(MapperS.of(drrReport).<String>mapC("getClearingSwapUSIs", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getClearingSwapUSIs()).getMulti());
			
			harmonized
				.addOtherPaymentPayerIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getDtccAdditionalFields()).<String>mapC("getOtherPaymentPayerIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOtherPaymentPayerIDType()).getMulti());
			
			harmonized
				.addOtherPaymentReceiverIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getDtccAdditionalFields()).<String>mapC("getOtherPaymentReceiverIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOtherPaymentReceiverIDType()).getMulti());
			
			harmonized
				.addTradeParty2ReportingDestination(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getDtccAdditionalFields()).<SupervisoryBodyEnum>mapC("getTradeParty2ReportingDestination", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty2ReportingDestination())
					.mapItem(item -> item.map("to-string", SupervisoryBodyEnum::toDisplayString)).getMulti());
			
			harmonized
				.addProductGrade(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getDtccAdditionalFields()).<ProductGradeReport>mapC("getProductGrade", dTCCAdditionalFields -> dTCCAdditionalFields.getProductGrade()).<String>mapC("getProductGrade", productGradeReport -> productGradeReport.getProductGrade()).getMulti());
			
			final List<String> ifThenElseResult3;
			if (needsUpfrontFee(drrReport, commonHarmonized).getOrDefault(false)) {
				ifThenElseResult3 = MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getDtccAdditionalFields()).<String>mapC("getOtherPaymentPayerIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOtherPaymentPayerIDType()).getMulti();
			} else {
				ifThenElseResult3 = Collections.<String>emptyList();
			}
			harmonized
				.addOtherPaymentPayerIdType(ifThenElseResult3);
			
			final List<String> ifThenElseResult4;
			if (needsUpfrontFee(drrReport, commonHarmonized).getOrDefault(false)) {
				ifThenElseResult4 = MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCPart45TransactionReport -> cFTCPart45TransactionReport.getDtccAdditionalFields()).<String>mapC("getOtherPaymentReceiverIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOtherPaymentReceiverIDType()).getMulti();
			} else {
				ifThenElseResult4 = Collections.<String>emptyList();
			}
			harmonized
				.addOtherPaymentReceiverIdType(ifThenElseResult4);
			
			return Optional.ofNullable(harmonized)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<Boolean> needsUpfrontFee(CFTCPart45TransactionReport drrReport, HarmonizedRepeatableData commonHarmonized) {
			return MapperS.of(requiresUpFrontFeeProjection.evaluate(drrReport));
		}
	}
}
