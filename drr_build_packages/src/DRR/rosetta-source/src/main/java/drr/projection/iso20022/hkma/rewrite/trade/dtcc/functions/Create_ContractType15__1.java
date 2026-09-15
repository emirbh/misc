package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.basket.BasketConstituentsReport;
import drr.base.util.string.functions.SubString;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import iso20022.auth030.hkma.dtcc.BasketConstituents3__1;
import iso20022.auth030.hkma.dtcc.ContractType15__1;
import iso20022.auth030.hkma.dtcc.CurrencyExchange23__1;
import iso20022.auth030.hkma.dtcc.CustomBasket4__1;
import iso20022.auth030.hkma.dtcc.FinancialInstrumentContractType2Code;
import iso20022.auth030.hkma.dtcc.GenericIdentification184;
import iso20022.auth030.hkma.dtcc.GenericIdentification185__1;
import iso20022.auth030.hkma.dtcc.IndexIdentification1__1;
import iso20022.auth030.hkma.dtcc.InstrumentIdentification6Choice__1;
import iso20022.auth030.hkma.dtcc.ProductType4Code__1;
import iso20022.auth030.hkma.dtcc.SecurityIdentification41Choice__1;
import iso20022.auth030.hkma.dtcc.SecurityIdentification46__1;
import iso20022.auth030.hkma.dtcc.UniqueProductIdentifier2Choice__1;
import iso20022.auth030.hkma.dtcc.UnitOfMeasure8Choice__1;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_ContractType15__1.Create_ContractType15__1Default.class)
public abstract class Create_ContractType15__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected SubString subString;

	/**
	* @param drrReport 
	* @return ctrctData 
	*/
	public ContractType15__1 evaluate(HKMATransactionReport drrReport) {
		ContractType15__1.ContractType15__1Builder ctrctDataBuilder = doEvaluate(drrReport);
		
		final ContractType15__1 ctrctData;
		if (ctrctDataBuilder == null) {
			ctrctData = null;
		} else {
			ctrctData = ctrctDataBuilder.build();
			objectValidator.validate(ContractType15__1.class, ctrctData);
		}
		
		return ctrctData;
	}

	protected abstract ContractType15__1.ContractType15__1Builder doEvaluate(HKMATransactionReport drrReport);

	public static class Create_ContractType15__1Default extends Create_ContractType15__1 {
		@Override
		protected ContractType15__1.ContractType15__1Builder doEvaluate(HKMATransactionReport drrReport) {
			ContractType15__1.ContractType15__1Builder ctrctData = ContractType15__1.builder();
			return assignOutput(ctrctData, drrReport);
		}
		
		protected ContractType15__1.ContractType15__1Builder assignOutput(ContractType15__1.ContractType15__1Builder ctrctData, HKMATransactionReport drrReport) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", hKMATransactionReport -> hKMATransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.I), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getUnderlyingIdentification", hKMATransactionReport -> hKMATransactionReport.getUnderlyingIdentification()).get();
			}
			CustomBasket4__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", hKMATransactionReport -> hKMATransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.B), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = CustomBasket4__1.builder()
					.setStrr(subString.evaluate(MapperS.of(drrReport).<String>map("getCustomBasketCode", hKMATransactionReport -> hKMATransactionReport.getCustomBasketCode()).get(), 1, 20))
					.setId(subString.evaluate(MapperS.of(drrReport).<String>map("getCustomBasketCode", hKMATransactionReport -> hKMATransactionReport.getCustomBasketCode()).get(), 21, 52))
					.setCnsttnts(MapperS.of(drrReport).<BasketConstituentsReport>mapC("getBasketConstituents", hKMATransactionReport -> hKMATransactionReport.getBasketConstituents())
						.mapItem(item -> {
							String _ifThenElseResult0 = null;
							if (areEqual(item.<AssetIdTypeEnum>map("getSource", basketConstituentsReport -> basketConstituentsReport.getSource()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.All).getOrDefault(false)) {
								_ifThenElseResult0 = item.<String>map("getIdentifier", basketConstituentsReport -> basketConstituentsReport.getIdentifier()).get();
							}
							GenericIdentification184 _ifThenElseResult1 = null;
							if (notEqual(item.<AssetIdTypeEnum>map("getSource", basketConstituentsReport -> basketConstituentsReport.getSource()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.Any).getOrDefault(false)) {
								_ifThenElseResult1 = GenericIdentification184.builder()
									.setId(item.<String>map("getIdentifier", basketConstituentsReport -> basketConstituentsReport.getIdentifier()).get())
									.setSrc(item.<AssetIdTypeEnum>map("getSource", basketConstituentsReport -> basketConstituentsReport.getSource()).map("to-string", AssetIdTypeEnum::toDisplayString).get())
									.build();
							}
							return MapperS.of(BasketConstituents3__1.builder()
								.setInstrmId(InstrumentIdentification6Choice__1.builder()
									.setIsin(_ifThenElseResult0)
									.setOthrId(_ifThenElseResult1)
									.build())
								.setQty(MapperS.of(drrReport).<BasketConstituentsReport>mapC("getBasketConstituents", hKMATransactionReport -> hKMATransactionReport.getBasketConstituents()).<BigDecimal>map("getNumberOfUnits", basketConstituentsReport -> basketConstituentsReport.getNumberOfUnits()).get())
								.setUnitOfMeasr(UnitOfMeasure8Choice__1.builder()
									.setCd(MapperS.of(MapperS.of(drrReport).<BasketConstituentsReport>mapC("getBasketConstituents", hKMATransactionReport -> hKMATransactionReport.getBasketConstituents()).<String>map("getUnitOfMeasure", basketConstituentsReport -> basketConstituentsReport.getUnitOfMeasure()).get()).map("to-string", Object::toString).get())
									.build())
								.build());
						}).getMulti())
					.build();
			}
			String ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", hKMATransactionReport -> hKMATransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<String>map("getUnderlyingIdentification", hKMATransactionReport -> hKMATransactionReport.getUnderlyingIdentification()).get();
			}
			String ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", hKMATransactionReport -> hKMATransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = MapperS.of(drrReport).<String>map("getNameOfTheUnderlyingIndex", hKMATransactionReport -> hKMATransactionReport.getNameOfTheUnderlyingIndex()).get();
			}
			GenericIdentification184 ifThenElseResult4 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", hKMATransactionReport -> hKMATransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.O), CardinalityOperator.All).andNullSafe(exists(MapperS.of(drrReport).<String>map("getUnderlyingIdOther", hKMATransactionReport -> hKMATransactionReport.getUnderlyingIdOther()))).getOrDefault(false)) {
				ifThenElseResult4 = GenericIdentification184.builder()
					.setId(MapperS.of(drrReport).<String>map("getUnderlyingIdOther", hKMATransactionReport -> hKMATransactionReport.getUnderlyingIdOther()).get())
					.setSrc(MapperS.of(drrReport).<AssetIdTypeEnum>map("getUnderlyingIdOtherSource", hKMATransactionReport -> hKMATransactionReport.getUnderlyingIdOtherSource()).map("to-string", AssetIdTypeEnum::toDisplayString).get())
					.build();
			}
			final CurrencyExchange23__1 ifThenElseResult5;
			if (areEqual(MapperS.of(drrReport).<CommonLeg>map("getLeg2", hKMATransactionReport -> hKMATransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of("Not Modelled"), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult5 = null;
			} else {
				ifThenElseResult5 = CurrencyExchange23__1.builder()
					.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg2", hKMATransactionReport -> hKMATransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.setFxgDt(MapperS.of(drrReport).<CommonLeg>map("getLeg2", hKMATransactionReport -> hKMATransactionReport.getLeg2()).<ZonedDateTime>map("getFixingDate", commonLeg -> commonLeg.getFixingDate()).get())
					.build();
			}
			ctrctData = toBuilder(ContractType15__1.builder()
				.setCtrctTp(MapperS.of(drrReport).<CommonContractType>map("getContractType", hKMATransactionReport -> hKMATransactionReport.getContractType()).checkedMap("to-enum", e -> FinancialInstrumentContractType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setAsstClss(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", hKMATransactionReport -> hKMATransactionReport.getAssetClass()).checkedMap("to-enum", e -> ProductType4Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
				.setPdctId(SecurityIdentification46__1.builder()
					.setUnqPdctIdr(UniqueProductIdentifier2Choice__1.builder()
						.setId(MapperS.of(drrReport).<String>map("getUniqueProductIdentifier", hKMATransactionReport -> hKMATransactionReport.getUniqueProductIdentifier()).get())
						.setPrtry(GenericIdentification185__1.builder()
							.setId(MapperS.of(drrReport).<String>map("getUniqueProductIdentifierProprietary", hKMATransactionReport -> hKMATransactionReport.getUniqueProductIdentifierProprietary()).get())
							.setSchmeNm(null)
							.build())
						.build())
					.setPdctDesc(MapperS.of(drrReport).<String>map("getProductDescription", hKMATransactionReport -> hKMATransactionReport.getProductDescription()).get())
					.build())
				.setUndrlygInstrm(SecurityIdentification41Choice__1.builder()
					.setIsin(ifThenElseResult0)
					.setBskt(ifThenElseResult1)
					.setIndx(IndexIdentification1__1.builder()
						.setIsin(ifThenElseResult2)
						.setNm(ifThenElseResult3)
						.build())
					.setOthr(ifThenElseResult4)
					.build())
				.setSttlmCcy(CurrencyExchange23__1.builder()
					.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg1", hKMATransactionReport -> hKMATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.setFxgDt(MapperS.of(drrReport).<CommonLeg>map("getLeg1", hKMATransactionReport -> hKMATransactionReport.getLeg1()).<ZonedDateTime>map("getFixingDate", commonLeg -> commonLeg.getFixingDate()).get())
					.build())
				.setSttlmCcyScndLeg(ifThenElseResult5)
				.setUndrlygAsstTradgPltfmIdr(MapperS.of(drrReport).<String>map("getUnderlyingAssetTradingPlatformIdentifier", hKMATransactionReport -> hKMATransactionReport.getUnderlyingAssetTradingPlatformIdentifier()).get())
				.setUndrlygAsstPricSrc(MapperS.of(drrReport).<String>map("getUnderlyingAssetPriceSource", hKMATransactionReport -> hKMATransactionReport.getUnderlyingAssetPriceSource()).get())
				.setPlcOfSttlm(MapperS.of(drrReport).<ISOCountryCodeEnum>map("getSettlementLocation", hKMATransactionReport -> hKMATransactionReport.getSettlementLocation()).map("to-string", ISOCountryCodeEnum::toDisplayString).get())
				.setDerivBasedOnCrptAsst(MapperS.of(drrReport).<Boolean>map("getCryptoAssetUnderlyingIndicator", hKMATransactionReport -> hKMATransactionReport.getCryptoAssetUnderlyingIndicator()).get())
				.build());
			
			return Optional.ofNullable(ctrctData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
