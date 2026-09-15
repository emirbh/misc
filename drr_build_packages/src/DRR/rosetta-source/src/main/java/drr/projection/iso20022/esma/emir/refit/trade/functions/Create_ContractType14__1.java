package drr.projection.iso20022.esma.emir.refit.trade.functions;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.basket.BasketConstituentsReport;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import drr.regulation.esma.emir.refit.trade.ESMAEMIRTransactionReport;
import drr.standards.iso.IndexEnum;
import iso20022.auth030.esma.BasketConstituents3__1;
import iso20022.auth030.esma.ContractType14__1;
import iso20022.auth030.esma.CurrencyExchange23__1;
import iso20022.auth030.esma.CustomBasket4__1;
import iso20022.auth030.esma.FinancialInstrumentContractType2Code;
import iso20022.auth030.esma.FloatingRateIndex1Code;
import iso20022.auth030.esma.IndexIdentification1__1;
import iso20022.auth030.esma.InstrumentIdentification6Choice__1;
import iso20022.auth030.esma.ProductType4Code__1;
import iso20022.auth030.esma.SecurityIdentification41Choice__1;
import iso20022.auth030.esma.SecurityIdentification46__1;
import iso20022.auth030.esma.UniqueProductIdentifier2Choice__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_ContractType14__1.Create_ContractType14__1Default.class)
public abstract class Create_ContractType14__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return ctrctData 
	*/
	public ContractType14__1 evaluate(ESMAEMIRTransactionReport drrReport) {
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

	protected abstract ContractType14__1.ContractType14__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport);

	public static class Create_ContractType14__1Default extends Create_ContractType14__1 {
		@Override
		protected ContractType14__1.ContractType14__1Builder doEvaluate(ESMAEMIRTransactionReport drrReport) {
			ContractType14__1.ContractType14__1Builder ctrctData = ContractType14__1.builder();
			return assignOutput(ctrctData, drrReport);
		}
		
		protected ContractType14__1.ContractType14__1Builder assignOutput(ContractType14__1.ContractType14__1Builder ctrctData, ESMAEMIRTransactionReport drrReport) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.I), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getUnderlyingIdentification", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getUnderlyingIdentification()).get();
			}
			FloatingRateIndex1Code ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = MapperS.of(drrReport).<IndexEnum>mapC("getIndicatorOfTheUnderlyingIndex", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getIndicatorOfTheUnderlyingIndex())
					.last().checkedMap("to-enum", e -> FloatingRateIndex1Code.valueOf(e.name()), IllegalArgumentException.class).get();
			}
			String ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = MapperS.of(drrReport).<String>map("getNameOfTheUnderlyingIndex", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getNameOfTheUnderlyingIndex()).get();
			}
			ctrctData = toBuilder(ContractType14__1.builder()
				.setPdctId(SecurityIdentification46__1.builder()
					.setIsin(MapperS.of(drrReport).<String>map("getIsin", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getIsin()).get())
					.setUnqPdctIdr(UniqueProductIdentifier2Choice__1.builder()
						.setId(MapperS.of(drrReport).<String>map("getUniqueProductIdentifier", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getUniqueProductIdentifier()).get())
						.build())
					.build())
				.setPdctClssfctn(MapperS.of(drrReport).<String>map("getProductClassification", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getProductClassification()).get())
				.setCtrctTp(MapperS.of(drrReport).<CommonContractType>map("getContractType", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getContractType()).checkedMap("to-enum", e -> FinancialInstrumentContractType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setAsstClss(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getAssetClass()).checkedMap("to-enum", e -> ProductType4Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
				.setDerivBasedOnCrptAsst(MapperS.of(drrReport).<Boolean>map("getCryptoAssetUnderlyingIndicator", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getCryptoAssetUnderlyingIndicator()).get())
				.setUndrlygInstrm(SecurityIdentification41Choice__1.builder()
					.setIsin(ifThenElseResult0)
					.setIndx(IndexIdentification1__1.builder()
						.setIndx(ifThenElseResult1)
						.setNm(ifThenElseResult2)
						.build())
					.setBskt(CustomBasket4__1.builder()
						.setId(MapperS.of(drrReport).<String>map("getCustomBasketCode", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getCustomBasketCode()).get())
						.setCnsttnts(MapperS.of(drrReport).<BasketConstituentsReport>mapC("getBasketConstituents", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getBasketConstituents()).<String>map("getIdentifier", basketConstituentsReport -> basketConstituentsReport.getIdentifier())
							.mapItem(item -> MapperS.of(BasketConstituents3__1.builder()
								.setInstrmId(InstrumentIdentification6Choice__1.builder()
									.setIsin(item.get())
									.build())
								.build())).getMulti())
						.build())
					.build())
				.setSttlmCcy(CurrencyExchange23__1.builder()
					.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg1", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setSttlmCcyScndLeg(CurrencyExchange23__1.builder()
					.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg2", eSMAEMIRTransactionReport -> eSMAEMIRTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.build());
			
			return Optional.ofNullable(ctrctData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
