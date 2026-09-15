package drr.projection.iso20022.asic.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.trade.basket.BasketConstituentsReport;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.common.trade.underlier.UnderlyingIdentificationTypeEnum;
import iso20022.auth030.asic.BasketConstituents3__1;
import iso20022.auth030.asic.ContractType15__1;
import iso20022.auth030.asic.CurrencyExchange23__1;
import iso20022.auth030.asic.CustomBasket4__1;
import iso20022.auth030.asic.FinancialInstrumentContractType2Code;
import iso20022.auth030.asic.GenericIdentification184;
import iso20022.auth030.asic.InstrumentIdentification6Choice__1;
import iso20022.auth030.asic.ProductType4Code__1;
import iso20022.auth030.asic.SecurityIdentification41Choice__1;
import iso20022.auth030.asic.SecurityIdentification46__1;
import iso20022.auth030.asic.UniqueProductIdentifier2Choice__1;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(Create_ContractType15__1.Create_ContractType15__1Default.class)
public abstract class Create_ContractType15__1 implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;

	/**
	* @param drrReport 
	* @return ctrctData 
	*/
	public ContractType15__1 evaluate(ASICTransactionReport drrReport) {
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

	protected abstract ContractType15__1.ContractType15__1Builder doEvaluate(ASICTransactionReport drrReport);

	public static class Create_ContractType15__1Default extends Create_ContractType15__1 {
		@Override
		protected ContractType15__1.ContractType15__1Builder doEvaluate(ASICTransactionReport drrReport) {
			ContractType15__1.ContractType15__1Builder ctrctData = ContractType15__1.builder();
			return assignOutput(ctrctData, drrReport);
		}
		
		protected ContractType15__1.ContractType15__1Builder assignOutput(ContractType15__1.ContractType15__1Builder ctrctData, ASICTransactionReport drrReport) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", aSICTransactionReport -> aSICTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.I), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getUnderlyingIdentification", aSICTransactionReport -> aSICTransactionReport.getUnderlyingIdentification()).get();
			}
			CustomBasket4__1 ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", aSICTransactionReport -> aSICTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.B), CardinalityOperator.All).getOrDefault(false)) {
				String ifThenElseResult1 = null;
				if (exists(MapperS.of(drrReport).<String>map("getBasketStructurerID", aSICTransactionReport -> aSICTransactionReport.getBasketStructurerID())).getOrDefault(false)) {
					ifThenElseResult1 = MapperS.of(drrReport).<String>map("getBasketStructurerID", aSICTransactionReport -> aSICTransactionReport.getBasketStructurerID()).get();
				}
				String ifThenElseResult2 = null;
				if (exists(MapperS.of(drrReport).<String>map("getCustomBasketCode", aSICTransactionReport -> aSICTransactionReport.getCustomBasketCode())).getOrDefault(false)) {
					ifThenElseResult2 = MapperS.of(drrReport).<String>map("getCustomBasketCode", aSICTransactionReport -> aSICTransactionReport.getCustomBasketCode()).get();
				}
				ifThenElseResult3 = CustomBasket4__1.builder()
					.setStrr(ifThenElseResult1)
					.setId(ifThenElseResult2)
					.setCnsttnts(MapperS.of(drrReport).<BasketConstituentsReport>mapC("getBasketConstituents", aSICTransactionReport -> aSICTransactionReport.getBasketConstituents())
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
								.build());
						}).getMulti())
					.build();
			}
			GenericIdentification184 ifThenElseResult4 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", aSICTransactionReport -> aSICTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.O), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult4 = GenericIdentification184.builder()
					.setId(MapperS.of(drrReport).<String>map("getUnderlyingIdOther", aSICTransactionReport -> aSICTransactionReport.getUnderlyingIdOther()).get())
					.setSrc(MapperS.of(drrReport).<AssetIdTypeEnum>map("getUnderlyingIdOtherSource", aSICTransactionReport -> aSICTransactionReport.getUnderlyingIdOtherSource()).map("to-string", AssetIdTypeEnum::toDisplayString).get())
					.build();
			}
			final CurrencyExchange23__1 ifThenElseResult5;
			if (areEqual(MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString), MapperS.of("Not Modelled"), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult5 = null;
			} else {
				ifThenElseResult5 = CurrencyExchange23__1.builder()
					.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg2", aSICTransactionReport -> aSICTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build();
			}
			ctrctData = toBuilder(ContractType15__1.builder()
				.setCtrctTp(MapperS.of(drrReport).<CommonContractType>map("getContractType", aSICTransactionReport -> aSICTransactionReport.getContractType()).checkedMap("to-enum", e -> FinancialInstrumentContractType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setAsstClss(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", aSICTransactionReport -> aSICTransactionReport.getAssetClass()).checkedMap("to-enum", e -> ProductType4Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
				.setPdctId(SecurityIdentification46__1.builder()
					.setUnqPdctIdr(UniqueProductIdentifier2Choice__1.builder()
						.setId(MapperS.of(drrReport).<String>map("getUniqueProductIdentifier", aSICTransactionReport -> aSICTransactionReport.getUniqueProductIdentifier()).get())
						.build())
					.build())
				.setUndrlygInstrm(SecurityIdentification41Choice__1.builder()
					.setIsin(ifThenElseResult0)
					.setBskt(ifThenElseResult3)
					.setOthr(ifThenElseResult4)
					.build())
				.setSttlmCcy(CurrencyExchange23__1.builder()
					.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setSttlmCcyScndLeg(ifThenElseResult5)
				.build());
			
			return Optional.ofNullable(ctrctData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
