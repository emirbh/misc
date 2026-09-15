package drr.projection.dtcc.rds.harmonized.cftc.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.cftc.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.cftc.rewrite.trade.CFTCTransactionReport;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.trade.CommonLeg;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.PaymentType4Code;
import iso20022.dtcc.rds.harmonized.HarmonizedRepeatableData;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;


@ImplementedBy(Create_SubmissionHarmonizedRepeatableData.Create_SubmissionHarmonizedRepeatableDataDefault.class)
public abstract class Create_SubmissionHarmonizedRepeatableData implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected RequiresUpFrontFeeProjection requiresUpFrontFeeProjection;

	/**
	* @param drrReport 
	* @return harmonized 
	*/
	public HarmonizedRepeatableData evaluate(CFTCTransactionReport drrReport) {
		HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder harmonizedBuilder = doEvaluate(drrReport);
		
		final HarmonizedRepeatableData harmonized;
		if (harmonizedBuilder == null) {
			harmonized = null;
		} else {
			harmonized = harmonizedBuilder.build();
			objectValidator.validate(HarmonizedRepeatableData.class, harmonized);
		}
		
		return harmonized;
	}

	protected abstract HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder doEvaluate(CFTCTransactionReport drrReport);

	protected abstract MapperS<Boolean> needsUpfrontFee(CFTCTransactionReport drrReport);

	public static class Create_SubmissionHarmonizedRepeatableDataDefault extends Create_SubmissionHarmonizedRepeatableData {
		@Override
		protected HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder doEvaluate(CFTCTransactionReport drrReport) {
			HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder harmonized = HarmonizedRepeatableData.builder();
			return assignOutput(harmonized, drrReport);
		}
		
		protected HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder assignOutput(HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder harmonized, CFTCTransactionReport drrReport) {
			harmonized = toBuilder(HarmonizedRepeatableData.builder()
				.setCdeOtherPaymentAmount(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", cFTCTransactionReport -> cFTCTransactionReport.getOtherPayment()).<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount()).getMulti())
				.setCdeOtherPaymentCurrency(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", cFTCTransactionReport -> cFTCTransactionReport.getOtherPayment()).<ISOCurrencyCodeEnum>map("getCurrency", otherPayment -> otherPayment.getCurrency())
					.mapItem(item -> item.map("to-string", ISOCurrencyCodeEnum::toDisplayString)).getMulti())
				.setCdeOtherPaymentType(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", cFTCTransactionReport -> cFTCTransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType())
					.mapItem(item -> item.map("to-string", PaymentType4Code::toDisplayString)).getMulti())
				.setClearingExceptionTypeParty2(MapperS.of(drrReport).<ClearingExceptionsAndExemptionsEnum>mapC("getClearingExceptionsAndExemptionsCounterparty2", cFTCTransactionReport -> cFTCTransactionReport.getClearingExceptionsAndExemptionsCounterparty2())
					.mapItem(item -> item.map("to-string", ClearingExceptionsAndExemptionsEnum::toDisplayString)).getMulti())
				.setLeg1QuantityFrequency(MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<FrequencyPeriodEnum>map("getQuantityFrequency", commonLeg -> commonLeg.getQuantityFrequency()).map("to-string", FrequencyPeriodEnum::toDisplayString).getMulti())
				.setTradeParty1ReportingDestination(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cFTCTransactionReport -> cFTCTransactionReport.getDtccAdditionalFields()).<SupervisoryBodyEnum>mapC("getTradeParty1ReportingDestination", dTCCAdditionalFields -> dTCCAdditionalFields.getTradeParty1ReportingDestination())
					.mapItem(item -> item.map("to-string", SupervisoryBodyEnum::toDisplayString)).getMulti())
				.build(), () -> HarmonizedRepeatableData.builder());
			
			final List<String> ifThenElseResult0;
			if (needsUpfrontFee(drrReport).getOrDefault(false)) {
				final String string = "UFRO";
				ifThenElseResult0 = string == null ? Collections.<String>emptyList() : Collections.singletonList(string);
			} else {
				ifThenElseResult0 = Collections.<String>emptyList();
			}
			harmonized
				.addCdeOtherPaymentType(ifThenElseResult0);
			
			final List<BigDecimal> ifThenElseResult1;
			if (needsUpfrontFee(drrReport).getOrDefault(false)) {
				ifThenElseResult1 = Collections.singletonList(BigDecimal.valueOf(0));
			} else {
				ifThenElseResult1 = Collections.<BigDecimal>emptyList();
			}
			harmonized
				.addCdeOtherPaymentAmount(ifThenElseResult1);
			
			final List<String> ifThenElseResult2;
			if (needsUpfrontFee(drrReport).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<CommonLeg>map("getLeg1", cFTCTransactionReport -> cFTCTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", commonLeg -> commonLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).getMulti();
			} else {
				ifThenElseResult2 = Collections.<String>emptyList();
			}
			harmonized
				.addCdeOtherPaymentCurrency(ifThenElseResult2);
			
			return Optional.ofNullable(harmonized)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<Boolean> needsUpfrontFee(CFTCTransactionReport drrReport) {
			return MapperS.of(requiresUpFrontFeeProjection.evaluate(drrReport));
		}
	}
}
