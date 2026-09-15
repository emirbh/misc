package drr.projection.dtcc.rds.harmonized.csa.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.basket.BasketConstituentsReport;
import drr.base.trade.payment.OtherPayment;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.quantity.NotionalPeriod;
import drr.regulation.common.ClearingExceptionsAndExemptionsEnum;
import drr.regulation.common.dtcc.trade.ProductGradeReport;
import drr.regulation.common.dtcc.trade.UnderlyingAssetReport;
import drr.regulation.csa.rewrite.dtcc.trade.DTCCAdditionalFields;
import drr.regulation.csa.rewrite.trade.CSALeg;
import drr.regulation.csa.rewrite.trade.CSATransactionReport;
import drr.standards.iso.FrequencyPeriodEnum;
import drr.standards.iso.PaymentType4Code;
import iso20022.dtcc.rds.harmonized.HarmonizedRepeatableData;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_SubmissionHarmonizedRepeatableData.Create_SubmissionHarmonizedRepeatableDataDefault.class)
public abstract class Create_SubmissionHarmonizedRepeatableData implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return harmonized 
	*/
	public HarmonizedRepeatableData evaluate(CSATransactionReport drrReport) {
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

	protected abstract HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder doEvaluate(CSATransactionReport drrReport);

	protected abstract MapperS<Boolean> needsUpfrontFee(CSATransactionReport drrReport);

	public static class Create_SubmissionHarmonizedRepeatableDataDefault extends Create_SubmissionHarmonizedRepeatableData {
		@Override
		protected HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder doEvaluate(CSATransactionReport drrReport) {
			HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder harmonized = HarmonizedRepeatableData.builder();
			return assignOutput(harmonized, drrReport);
		}
		
		protected HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder assignOutput(HarmonizedRepeatableData.HarmonizedRepeatableDataBuilder harmonized, CSATransactionReport drrReport) {
			final MapperC<BasketConstituentsReport> thenArg = MapperS.of(drrReport).<BasketConstituentsReport>mapC("getBasketConstituents", cSATransactionReport -> cSATransactionReport.getBasketConstituents());
			harmonized = toBuilder(HarmonizedRepeatableData.builder()
				.setUnderlyingAssetId(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<UnderlyingAssetReport>mapC("getUnderlyingAsset", dTCCAdditionalFields -> dTCCAdditionalFields.getUnderlyingAsset()).<String>map("getUnderlyingAssetID", underlyingAssetReport -> underlyingAssetReport.getUnderlyingAssetID()).getMulti())
				.setUnderlyingAssetIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<UnderlyingAssetReport>mapC("getUnderlyingAsset", dTCCAdditionalFields -> dTCCAdditionalFields.getUnderlyingAsset()).<String>map("getUnderlyingAssetIDType", underlyingAssetReport -> underlyingAssetReport.getUnderlyingAssetIDType()).getMulti())
				.setUnderlyingAssetName(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>mapC("getUnderlyingAssetName", dTCCAdditionalFields -> dTCCAdditionalFields.getUnderlyingAssetName()).getMulti())
				.setCdeOtherPaymentPayer(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", cSATransactionReport -> cSATransactionReport.getOtherPayment()).<String>map("getPayer", otherPayment -> otherPayment.getPayer()).getMulti())
				.setCdeOtherPaymentReceiver(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", cSATransactionReport -> cSATransactionReport.getOtherPayment()).<String>map("getReceiver", otherPayment -> otherPayment.getReceiver()).getMulti())
				.setCdeOtherPaymentAmount(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", cSATransactionReport -> cSATransactionReport.getOtherPayment()).<BigDecimal>map("getAmount", otherPayment -> otherPayment.getAmount()).getMulti())
				.setCdeOtherPaymentCurrency(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", cSATransactionReport -> cSATransactionReport.getOtherPayment()).<ISOCurrencyCodeEnum>map("getCurrency", otherPayment -> otherPayment.getCurrency())
					.mapItem(item -> item.map("to-string", ISOCurrencyCodeEnum::toDisplayString)).getMulti())
				.setCdeOtherPaymentDate(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", cSATransactionReport -> cSATransactionReport.getOtherPayment()).<Date>map("getDate", otherPayment -> otherPayment.getDate()).getMulti())
				.setCdeOtherPaymentType(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", cSATransactionReport -> cSATransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType())
					.mapItem(item -> item.map("to-string", PaymentType4Code::toDisplayString)).getMulti())
				.setOtherPaymentPayerIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>mapC("getOtherPaymentPayerIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOtherPaymentPayerIDType()).getMulti())
				.setOtherPaymentReceiverIdType(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<String>mapC("getOtherPaymentReceiverIDType", dTCCAdditionalFields -> dTCCAdditionalFields.getOtherPaymentReceiverIDType()).getMulti())
				.setCdeEffectiveDateOfNotionalQuantityOfLeg1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", cSALeg -> cSALeg.getNotionalQuantitySchedule()).<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).getMulti())
				.setCdeEffectiveDateOfNotionalQuantityOfLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", cSALeg -> cSALeg.getNotionalQuantitySchedule()).<Date>map("getEffectiveDate", notionalPeriod -> notionalPeriod.getEffectiveDate()).getMulti())
				.setCdeEndDateOfNotionalQuantityOfLeg1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", cSALeg -> cSALeg.getNotionalQuantitySchedule()).<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate()).getMulti())
				.setCdeEndDateOfNotionalQuantityOfLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", cSALeg -> cSALeg.getNotionalQuantitySchedule()).<Date>map("getEndDate", notionalPeriod -> notionalPeriod.getEndDate()).getMulti())
				.setCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg1(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", cSALeg -> cSALeg.getNotionalQuantitySchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).getMulti())
				.setCdeNotionalQuantityInEffectOnAssociatedEffectiveDateOfLeg2(MapperS.of(drrReport).<CSALeg>map("getLeg2", cSATransactionReport -> cSATransactionReport.getLeg2()).<NotionalPeriod>mapC("getNotionalQuantitySchedule", cSALeg -> cSALeg.getNotionalQuantitySchedule()).<BigDecimal>map("getValue", notionalPeriod -> notionalPeriod.getValue()).getMulti())
				.setCdeBasketConstituentsIdentifier(MapperS.of(drrReport).<BasketConstituentsReport>mapC("getBasketConstituents", cSATransactionReport -> cSATransactionReport.getBasketConstituents()).<String>map("getIdentifier", basketConstituentsReport -> basketConstituentsReport.getIdentifier()).getMulti())
				.setCdeBasketConstituentsIdentifierSource(thenArg
					.mapItem(item -> item.<AssetIdTypeEnum>map("getSource", basketConstituentsReport -> basketConstituentsReport.getSource()).map("to-string", AssetIdTypeEnum::toDisplayString)).getMulti())
				.setCdeBasketConstituentsNumberOfUnits(MapperS.of(drrReport).<BasketConstituentsReport>mapC("getBasketConstituents", cSATransactionReport -> cSATransactionReport.getBasketConstituents()).<BigDecimal>map("getNumberOfUnits", basketConstituentsReport -> basketConstituentsReport.getNumberOfUnits()).getMulti())
				.setCdeBasketConstituentsUnitOfMeasure(MapperS.of(drrReport).<BasketConstituentsReport>mapC("getBasketConstituents", cSATransactionReport -> cSATransactionReport.getBasketConstituents()).<String>map("getUnitOfMeasure", basketConstituentsReport -> basketConstituentsReport.getUnitOfMeasure()).getMulti())
				.setProductGrade(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<ProductGradeReport>mapC("getProductGrade", dTCCAdditionalFields -> dTCCAdditionalFields.getProductGrade()).<String>mapC("getProductGrade", productGradeReport -> productGradeReport.getProductGrade()).getMulti())
				.setClearingExceptionTypeParty2(MapperS.of(drrReport).<ClearingExceptionsAndExemptionsEnum>mapC("getClearingExceptionsAndExemptionsCounterparty2", cSATransactionReport -> cSATransactionReport.getClearingExceptionsAndExemptionsCounterparty2())
					.mapItem(item -> item.map("to-string", ClearingExceptionsAndExemptionsEnum::toDisplayString)).getMulti())
				.setLeg1QuantityFrequency(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<FrequencyPeriodEnum>map("getQuantityFrequency", cSALeg -> cSALeg.getQuantityFrequency()).map("to-string", FrequencyPeriodEnum::toDisplayString).getMulti())
				.setTradeParty1LocalCounterpartyJurisdiction(MapperS.of(drrReport).<String>mapC("getJurisdictionOfCounterparty1", cSATransactionReport -> cSATransactionReport.getJurisdictionOfCounterparty1()).getMulti())
				.setTradeParty2LocalCounterpartyJurisdiction(MapperS.of(drrReport).<String>mapC("getJurisdictionOfCounterparty2", cSATransactionReport -> cSATransactionReport.getJurisdictionOfCounterparty2()).getMulti())
				.build(), () -> HarmonizedRepeatableData.builder());
			
			final List<String> ifThenElseResult0;
			if (needsUpfrontFee(drrReport).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getBuyerIdentifier", cSATransactionReport -> cSATransactionReport.getBuyerIdentifier()).getMulti();
			} else {
				ifThenElseResult0 = Collections.<String>emptyList();
			}
			harmonized
				.addCdeOtherPaymentPayer(ifThenElseResult0);
			
			final List<String> ifThenElseResult1;
			if (needsUpfrontFee(drrReport).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(drrReport).<String>map("getSellerIdentifier", cSATransactionReport -> cSATransactionReport.getSellerIdentifier()).getMulti();
			} else {
				ifThenElseResult1 = Collections.<String>emptyList();
			}
			harmonized
				.addCdeOtherPaymentReceiver(ifThenElseResult1);
			
			final List<String> ifThenElseResult2;
			if (needsUpfrontFee(drrReport).getOrDefault(false)) {
				final String string0 = "UFRO";
				ifThenElseResult2 = string0 == null ? Collections.<String>emptyList() : Collections.singletonList(string0);
			} else {
				ifThenElseResult2 = Collections.<String>emptyList();
			}
			harmonized
				.addCdeOtherPaymentType(ifThenElseResult2);
			
			final List<BigDecimal> ifThenElseResult3;
			if (needsUpfrontFee(drrReport).getOrDefault(false)) {
				ifThenElseResult3 = Collections.singletonList(BigDecimal.valueOf(0));
			} else {
				ifThenElseResult3 = Collections.<BigDecimal>emptyList();
			}
			harmonized
				.addCdeOtherPaymentAmount(ifThenElseResult3);
			
			final List<String> ifThenElseResult4;
			if (needsUpfrontFee(drrReport).getOrDefault(false)) {
				ifThenElseResult4 = MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getNotionalCurrency", cSALeg -> cSALeg.getNotionalCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).getMulti();
			} else {
				ifThenElseResult4 = Collections.<String>emptyList();
			}
			harmonized
				.addCdeOtherPaymentCurrency(ifThenElseResult4);
			
			final List<Date> ifThenElseResult5;
			if (needsUpfrontFee(drrReport).getOrDefault(false)) {
				ifThenElseResult5 = MapperS.of(drrReport).<Date>map("getEffectiveDate", cSATransactionReport -> cSATransactionReport.getEffectiveDate()).getMulti();
			} else {
				ifThenElseResult5 = Collections.<Date>emptyList();
			}
			harmonized
				.addCdeOtherPaymentDate(ifThenElseResult5);
			
			final List<String> ifThenElseResult6;
			if (needsUpfrontFee(drrReport).getOrDefault(false)) {
				final String string1 = "LEI";
				ifThenElseResult6 = string1 == null ? Collections.<String>emptyList() : Collections.singletonList(string1);
			} else {
				ifThenElseResult6 = Collections.<String>emptyList();
			}
			harmonized
				.addOtherPaymentPayerIdType(ifThenElseResult6);
			
			final List<String> ifThenElseResult7;
			if (needsUpfrontFee(drrReport).getOrDefault(false)) {
				final String string2 = "LEI";
				ifThenElseResult7 = string2 == null ? Collections.<String>emptyList() : Collections.singletonList(string2);
			} else {
				ifThenElseResult7 = Collections.<String>emptyList();
			}
			harmonized
				.addOtherPaymentReceiverIdType(ifThenElseResult7);
			
			return Optional.ofNullable(harmonized)
				.map(o -> o.prune())
				.orElse(null);
		}
		
		@Override
		protected MapperS<Boolean> needsUpfrontFee(CSATransactionReport drrReport) {
			return notExists(MapperS.of(drrReport).<OtherPayment>mapC("getOtherPayment", cSATransactionReport -> cSATransactionReport.getOtherPayment()).<PaymentType4Code>map("getPaymentType", otherPayment -> otherPayment.getPaymentType())).andNullSafe(areEqual(MapperS.of(drrReport).<DTCCAdditionalFields>map("getDtccAdditionalFields", cSATransactionReport -> cSATransactionReport.getDtccAdditionalFields()).<AssetClassEnum>map("getPrimaryAssetClass", dTCCAdditionalFields -> dTCCAdditionalFields.getPrimaryAssetClass()).map("to-string", AssetClassEnum::toDisplayString), MapperS.of("Credit"), CardinalityOperator.All)).andNullSafe(notExists(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<BigDecimal>map("getFixedRate", cSALeg -> cSALeg.getFixedRate()))).andNullSafe(notExists(MapperS.of(drrReport).<CSALeg>map("getLeg1", cSATransactionReport -> cSATransactionReport.getLeg1()).<PriceFormat>map("getSpread", cSALeg -> cSALeg.getSpread()))).asMapper();
		}
	}
}
