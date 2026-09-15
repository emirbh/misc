package drr.projection.dtcc.rds.harmonized.sec.rewrite.trade.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.SECTransactionReportTrade;
import iso20022.dtcc.rds.harmonized.HarmonizedRepeatableData;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_SubmissionHarmonizedRepeatableData_Trade.Create_SubmissionHarmonizedRepeatableData_TradeDefault.class)
public abstract class Create_SubmissionHarmonizedRepeatableData_Trade implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected RequiresUpFrontFeeProjection requiresUpFrontFeeProjection;

	/**
	* @param drrReport 
	* @param commonHarmonized 
	* @return harmonized 
	*/
	public HarmonizedRepeatableData evaluate(SECTransactionReportTrade drrReport, HarmonizedRepeatableData commonHarmonized) {
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

	protected abstract HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder doEvaluate(SECTransactionReportTrade drrReport, HarmonizedRepeatableData commonHarmonized);

	protected abstract MapperS<Boolean> needsUpfrontFee(SECTransactionReportTrade drrReport, HarmonizedRepeatableData commonHarmonized);

	public static class Create_SubmissionHarmonizedRepeatableData_TradeDefault extends Create_SubmissionHarmonizedRepeatableData_Trade {
		@Override
		protected HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder doEvaluate(SECTransactionReportTrade drrReport, HarmonizedRepeatableData commonHarmonized) {
			HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder harmonized = HarmonizedRepeatableData.builder();
			return assignOutput(harmonized, drrReport, commonHarmonized);
		}
		
		protected HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder assignOutput(HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder harmonized, SECTransactionReportTrade drrReport, HarmonizedRepeatableData commonHarmonized) {
			harmonized = toBuilder(commonHarmonized, () -> HarmonizedRepeatableData.builder());
			
			harmonized
				.addClearingSwapUsiId(MapperS.of(drrReport).<String>mapC("getClearingSwapUSIs", sECTransactionReportTrade -> sECTransactionReportTrade.getClearingSwapUSIs()).getMulti());
			
			harmonized
				.addCdeOtherPaymentDate(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", sECTransactionReportTrade -> sECTransactionReportTrade.getOtherPayment()).<Date>map("getDate", otherPayment -> otherPayment.getDate()).getMulti());
			
			harmonized
				.addCdeOtherPaymentPayer(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", sECTransactionReportTrade -> sECTransactionReportTrade.getOtherPayment()).<String>map("getPayer", otherPayment -> otherPayment.getPayer()).getMulti());
			
			harmonized
				.addCdeOtherPaymentReceiver(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", sECTransactionReportTrade -> sECTransactionReportTrade.getOtherPayment()).<String>map("getReceiver", otherPayment -> otherPayment.getReceiver()).getMulti());
			
			harmonized
				.addOtherPaymentPayerIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReportTrade -> sECTransactionReportTrade.getDtccAdditionalFields()).<String>mapC("getOtherPaymentPayerIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOtherPaymentPayerIDType()).getMulti());
			
			harmonized
				.addOtherPaymentReceiverIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReportTrade -> sECTransactionReportTrade.getDtccAdditionalFields()).<String>mapC("getOtherPaymentReceiverIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOtherPaymentReceiverIDType()).getMulti());
			
			final List<String> ifThenElseResult0;
			if (needsUpfrontFee(drrReport, commonHarmonized).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getBuyerIdentifier", sECTransactionReportTrade -> sECTransactionReportTrade.getBuyerIdentifier()).getMulti();
			} else {
				ifThenElseResult0 = Collections.<String>emptyList();
			}
			harmonized
				.addCdeOtherPaymentPayer(ifThenElseResult0);
			
			final List<String> ifThenElseResult1;
			if (needsUpfrontFee(drrReport, commonHarmonized).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(drrReport).<String>map("getSellerIdentifier", sECTransactionReportTrade -> sECTransactionReportTrade.getSellerIdentifier()).getMulti();
			} else {
				ifThenElseResult1 = Collections.<String>emptyList();
			}
			harmonized
				.addCdeOtherPaymentReceiver(ifThenElseResult1);
			
			final List<Date> ifThenElseResult2;
			if (needsUpfrontFee(drrReport, commonHarmonized).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<Date>map("getEffectiveDate", sECTransactionReportTrade -> sECTransactionReportTrade.getEffectiveDate()).getMulti();
			} else {
				ifThenElseResult2 = Collections.<Date>emptyList();
			}
			harmonized
				.addCdeOtherPaymentDate(ifThenElseResult2);
			
			final List<String> ifThenElseResult3;
			if (needsUpfrontFee(drrReport, commonHarmonized).getOrDefault(false)) {
				final String string0 = "LEI";
				ifThenElseResult3 = string0 == null ? Collections.<String>emptyList() : Collections.singletonList(string0);
			} else {
				ifThenElseResult3 = Collections.<String>emptyList();
			}
			harmonized
				.addOtherPaymentPayerIdType(ifThenElseResult3);
			
			final List<String> ifThenElseResult4;
			if (needsUpfrontFee(drrReport, commonHarmonized).getOrDefault(false)) {
				final String string1 = "LEI";
				ifThenElseResult4 = string1 == null ? Collections.<String>emptyList() : Collections.singletonList(string1);
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
		protected MapperS<Boolean> needsUpfrontFee(SECTransactionReportTrade drrReport, HarmonizedRepeatableData commonHarmonized) {
			return MapperS.of(requiresUpFrontFeeProjection.evaluate(drrReport));
		}
	}
}
