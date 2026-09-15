package drr.projection.iso20022.mas.rewrite.trade.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
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
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import iso20022.auth030.mas.BasketConstituents3__1;
import iso20022.auth030.mas.ContractType15__1;
import iso20022.auth030.mas.CurrencyExchange23__1;
import iso20022.auth030.mas.CustomBasket4__1;
import iso20022.auth030.mas.FinancialInstrumentContractType2Code;
import iso20022.auth030.mas.GenericIdentification184;
import iso20022.auth030.mas.IndexIdentification1__1;
import iso20022.auth030.mas.InstrumentIdentification6Choice__1;
import iso20022.auth030.mas.ProductType4Code__1;
import iso20022.auth030.mas.SecurityIdentification41Choice__1;
import iso20022.auth030.mas.SecurityIdentification46__1;
import iso20022.auth030.mas.UniqueProductIdentifier2Choice__1;
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
	public ContractType15__1 evaluate(MASTransactionReport drrReport) {
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

	protected abstract ContractType15__1.ContractType15__1Builder doEvaluate(MASTransactionReport drrReport);

	public static class Create_ContractType15__1Default extends Create_ContractType15__1 {
		@Override
		protected ContractType15__1.ContractType15__1Builder doEvaluate(MASTransactionReport drrReport) {
			ContractType15__1.ContractType15__1Builder ctrctData = ContractType15__1.builder();
			return assignOutput(ctrctData, drrReport);
		}
		
		protected ContractType15__1.ContractType15__1Builder assignOutput(ContractType15__1.ContractType15__1Builder ctrctData, MASTransactionReport drrReport) {
			String ifThenElseResult0 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", mASTransactionReport -> mASTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.I), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult0 = MapperS.of(drrReport).<String>map("getUnderlyingIdentification", mASTransactionReport -> mASTransactionReport.getUnderlyingIdentification()).get();
			}
			CustomBasket4__1 ifThenElseResult1 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", mASTransactionReport -> mASTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.B), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult1 = CustomBasket4__1.builder()
					.setCnsttnts(MapperS.of(drrReport).<BasketConstituentsReport>mapC("getBasketConstituents", mASTransactionReport -> mASTransactionReport.getBasketConstituents())
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
			IndexIdentification1__1 ifThenElseResult2 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", mASTransactionReport -> mASTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.X), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult2 = IndexIdentification1__1.builder()
					.setIsin(MapperS.of(drrReport).<String>map("getUnderlyingIdentification", mASTransactionReport -> mASTransactionReport.getUnderlyingIdentification()).get())
					.setNm(MapperS.of(drrReport).<String>map("getNameOfTheUnderlyingIndex", mASTransactionReport -> mASTransactionReport.getNameOfTheUnderlyingIndex()).get())
					.build();
			}
			GenericIdentification184 ifThenElseResult3 = null;
			if (areEqual(MapperS.of(drrReport).<UnderlyingIdentificationTypeEnum>map("getUnderlyingIdentificationType", mASTransactionReport -> mASTransactionReport.getUnderlyingIdentificationType()), MapperS.of(UnderlyingIdentificationTypeEnum.O), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult3 = GenericIdentification184.builder()
					.setId(MapperS.of(drrReport).<String>map("getUnderlyingIdOther", mASTransactionReport -> mASTransactionReport.getUnderlyingIdOther()).get())
					.setSrc(MapperS.of(drrReport).<AssetIdTypeEnum>map("getUnderlyingIdOtherSource", mASTransactionReport -> mASTransactionReport.getUnderlyingIdOtherSource()).map("to-string", AssetIdTypeEnum::toDisplayString).get())
					.build();
			}
			ctrctData = toBuilder(ContractType15__1.builder()
				.setCtrctTp(MapperS.of(drrReport).<CommonContractType>map("getContractType", mASTransactionReport -> mASTransactionReport.getContractType()).checkedMap("to-enum", e -> FinancialInstrumentContractType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setAsstClss(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", mASTransactionReport -> mASTransactionReport.getAssetClass()).checkedMap("to-enum", e -> ProductType4Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
				.setPdctId(SecurityIdentification46__1.builder()
					.setUnqPdctIdr(UniqueProductIdentifier2Choice__1.builder()
						.setId(MapperS.of(drrReport).<String>map("getUniqueProductIdentifier", mASTransactionReport -> mASTransactionReport.getUniqueProductIdentifier()).get())
						.build())
					.build())
				.setUndrlygInstrm(SecurityIdentification41Choice__1.builder()
					.setIsin(ifThenElseResult0)
					.setBskt(ifThenElseResult1)
					.setIndx(ifThenElseResult2)
					.setOthr(ifThenElseResult3)
					.build())
				.setSttlmCcy(CurrencyExchange23__1.builder()
					.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg1", mASTransactionReport -> mASTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setSttlmCcyScndLeg(CurrencyExchange23__1.builder()
					.setCcy(MapperS.of(drrReport).<CommonLeg>map("getLeg2", mASTransactionReport -> mASTransactionReport.getLeg2()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.build());
			
			return Optional.ofNullable(ctrctData)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
