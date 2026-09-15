package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

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
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.IndexEnum;
import iso20022.auth030.fca.BasketConstituents3__1;
import iso20022.auth030.fca.ContractType14__1;
import iso20022.auth030.fca.CurrencyExchange23__1;
import iso20022.auth030.fca.CustomBasket4__1;
import iso20022.auth030.fca.FinancialInstrumentContractType2Code;
import iso20022.auth030.fca.IndexIdentification1__1;
import iso20022.auth030.fca.InstrumentIdentification6Choice__1;
import iso20022.auth030.fca.ProductType4Code__1;
import iso20022.auth030.fca.SecurityIdentification41Choice__1;
import iso20022.auth030.fca.SecurityIdentification46__1;
import iso20022.auth030.fca.UniqueProductIdentifier2Choice__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_ContractType14__1.Create_ContractType14__1Default.class)
public abstract class Create_ContractType14__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected SubString subString;

	/**
	* @param drrReport 
	* @return ctrctData 
	*/
	public ContractType14__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
		ContractType14__1.ContractType14__1Builder ctrctDataBuilder = doEvaluate(drrReport);
		
		final ContractType14__1 ctrctData;
		if (ctrctDataBuilder == null) {
			ctrctData = null;
		} else {
			ctrctData = ctrctDataBuilder.build();
			objectValidator.validate(ContractType14__1.class, ctrctData);
		}
		
		return ctrctData;
	}

	protected abstract ContractType14__1.ContractType14__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class Create_ContractType14__1Default extends Create_ContractType14__1 {
		@Override
		protected ContractType14__1.ContractType14__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			ContractType14__1.ContractType14__1Builder ctrctData = ContractType14__1.builder();
			return assignOutput(ctrctData, drrReport);
		}
		
		protected ContractType14__1.ContractType14__1Builder assignOutput(ContractType14__1.ContractType14__1Builder ctrctData, FCAUKEMIRTransactionReport drrReport) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.I), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getUnderlyingIdentification", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getUnderlyingIdentification()).get();
			}
			String ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(drrReport).<IndexEnum>mapC("getIndicatorOfTheUnderlyingIndex", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getIndicatorOfTheUnderlyingIndex())
					.last().map("to-string", IndexEnum::toDisplayString).get();
			}
			String ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<String>map("getNameOfTheUnderlyingIndex", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getNameOfTheUnderlyingIndex()).get();
			}
			String ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = MapperS.of(drrReport).<String>map("getUnderlyingIdentification", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getUnderlyingIdentification()).get();
			}
			ctrctData = toBuilder(ContractType14__1.builder()
				.setPdctId(SecurityIdentification46__1.builder()
					.setIsin(MapperS.of(drrReport).<String>map("getIsin", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getIsin()).get())
					.setUnqPdctIdr(UniqueProductIdentifier2Choice__1.builder()
						.setId(MapperS.of(drrReport).<String>map("getUniqueProductIdentifier", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getUniqueProductIdentifier()).get())
						.build())
					.build())
				.setPdctClssfctn(MapperS.of(drrReport).<String>map("getProductClassification", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getProductClassification()).get())
				.setCtrctTp(MapperS.of(drrReport).<CommonContractType>map("getContractType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getContractType()).checkedMap("to-enum", e -> FinancialInstrumentContractType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setAsstClss(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()).checkedMap("to-enum", e -> ProductType4Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
				.setDerivBasedOnCrptAsst(MapperS.of(drrReport).<Boolean>map("getCryptoAssetUnderlyingIndicator", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getCryptoAssetUnderlyingIndicator()).get())
				.setUndrlygInstrm(SecurityIdentification41Choice__1.builder()
					.setIsin(ifThenElseResult0)
					.setIndx(IndexIdentification1__1.builder()
						.setIndx(ifThenElseResult1)
						.setNm(ifThenElseResult2)
						.setIsin(ifThenElseResult3)
						.build())
					.setBskt(CustomBasket4__1.builder()
						.setStrr(subString.evaluate(MapperS.of(drrReport).<String>map("getCustomBasketCode", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getCustomBasketCode()).get(), 1, 20))
						.setId(subString.evaluate(MapperS.of(drrReport).<String>map("getCustomBasketCode", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getCustomBasketCode()).get(), 21, 52))
						.setCnsttnts(MapperS.of(drrReport).<BasketConstituentsReport>mapC("getBasketConstituents", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getBasketConstituents()).<String>map("getIdentifier", basketConstituentsReport -> basketConstituentsReport.getIdentifier())
							.mapItem(item -> MapperS.of(BasketConstituents3__1.builder()
								.setInstrmId(InstrumentIdentification6Choice__1.builder()
									.setIsin(item.get())
									.build())
								.build())).getMulti())
						.build())
					.build())
				.setSttlmCcy(CurrencyExchange23__1.builder()
					.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg1", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setSttlmCcyScndLeg(CurrencyExchange23__1.builder()
					.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg2", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.build());
			
			return Optional.ofNullable(ctrctData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
