package drr.projection.dtcc.rds.harmonized.sec.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.payment.OtherPayment;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.dtcc.trade.UnderlyingAssetReport;
import drr.regulation.sec.rewrite.dtcc.DTCCAdditionalFields;
import drr.regulation.sec.rewrite.trade.SECLeg;
import drr.regulation.sec.rewrite.trade.SECTransactionReport;
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
	public HarmonizedRepeatableData evaluate(SECTransactionReport drrReport) {
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

	protected abstract HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder doEvaluate(SECTransactionReport drrReport);

	protected abstract MapperS<Boolean> needsUpfrontFee(SECTransactionReport drrReport);

	public static class Create_SubmissionHarmonizedRepeatableDataDefault extends Create_SubmissionHarmonizedRepeatableData {
		@Override
		protected HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder doEvaluate(SECTransactionReport drrReport) {
			HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder harmonized = HarmonizedRepeatableData.builder();
			return assignOutput(harmonized, drrReport);
		}
		
		protected HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder assignOutput(HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder harmonized, SECTransactionReport drrReport) {
			harmonized = toBuilder(HarmonizedRepeatableData.builder()
				.setClearingExceptionTypeParty2(MapperS.of(drrReport).<ClearingExceptionsAndExemptionsEnum>mapC("getClearingExceptionsAndExemptionsCounterparty2", sECTransactionReport -> sECTransactionReport.getClearingExceptionsAndExemptionsCounterparty2())
					.mapItem(item -> item.map("to-string", ClearingExceptionsAndExemptionsEnum::toDisplayString)).getMulti())
				.setCdeOtherPaymentType(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", sECTransactionReport -> sECTransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType())
					.mapItem(item -> item.map("to-string", PaymentType4Code::toDisplayString)).getMulti())
				.setCdeOtherPaymentAmount(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", sECTransactionReport -> sECTransactionReport.getOtherPayment()).<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount()).getMulti())
				.setCdeOtherPaymentCurrency(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", sECTransactionReport -> sECTransactionReport.getOtherPayment()).<ISOCurrencyCodeEnum>map("getCurrency", otherPayment -> otherPayment.getCurrency())
					.mapItem(item -> item.map("to-string", ISOCurrencyCodeEnum::toDisplayString)).getMulti())
				.setUnderlyingAssetId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReport -> sECTransactionReport.getDtccAdditionalFields()).<UnderlyingAssetReport>mapC("getUnderlyingAsset", dTCCAdditionalFields -> dTCCAdditionalFields.getUnderlyingAsset()).<String>map("getUnderlyingAssetID", underlyingAssetReport -> underlyingAssetReport.getUnderlyingAssetID()).getMulti())
				.setUnderlyingAssetIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReport -> sECTransactionReport.getDtccAdditionalFields()).<UnderlyingAssetReport>mapC("getUnderlyingAsset", dTCCAdditionalFields -> dTCCAdditionalFields.getUnderlyingAsset()).<String>map("getUnderlyingAssetIDType", underlyingAssetReport -> underlyingAssetReport.getUnderlyingAssetIDType()).getMulti())
				.setUnderlyingAssetName(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", sECTransactionReport -> sECTransactionReport.getDtccAdditionalFields()).<String>mapC("getUnderlyingAssetName", dTCCAdditionalFields -> dTCCAdditionalFields.getUnderlyingAssetName()).getMulti())
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
				ifThenElseResult2 = MapperS.of(drrReport).<SECLeg>map("getLeg1", sECTransactionReport -> sECTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", sECLeg -> sECLeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).getMulti();
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
		protected MapperS<Boolean> needsUpfrontFee(SECTransactionReport drrReport) {
			return MapperS.of(requiresUpFrontFeeProjection.evaluate(drrReport));
		}
	}
}
