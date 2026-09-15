package drr.projection.iso20022.asic.rewrite.trade.functions;

import cdm.base.math.functions.Abs;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.price.PriceFormat;
import drr.base.util.string.functions.StringLength;
import drr.base.util.string.functions.SubString;
import drr.regulation.asic.rewrite.trade.ASICTransactionReport;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.CommonLeg;
import iso20022.auth030.asic.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.asic.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.asic.AmountAndDirection106__1;
import iso20022.auth030.asic.OptionOrSwaption11__1;
import iso20022.auth030.asic.SecuritiesTransactionPrice17Choice__1;
import java.math.BigDecimal;
import java.util.Optional;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetOptn.GetOptnDefault.class)
public abstract class GetOptn implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Abs abs;
	@Inject protected Create_OptionBarrierLevel1Choice__1 create_OptionBarrierLevel1Choice__1;
	@Inject protected StringLength stringLength;
	@Inject protected SubString subString;

	/**
	* @param drrReport 
	* @return optn 
	*/
	public OptionOrSwaption11__1 evaluate(ASICTransactionReport drrReport) {
		OptionOrSwaption11__1.OptionOrSwaption11__1Builder optnBuilder = doEvaluate(drrReport);
		
		final OptionOrSwaption11__1 optn;
		if (optnBuilder == null) {
			optn = null;
		} else {
			optn = optnBuilder.build();
			objectValidator.validate(OptionOrSwaption11__1.class, optn);
		}
		
		return optn;
	}

	protected abstract OptionOrSwaption11__1.OptionOrSwaption11__1Builder doEvaluate(ASICTransactionReport drrReport);

	public static class GetOptnDefault extends GetOptn {
		@Override
		protected OptionOrSwaption11__1.OptionOrSwaption11__1Builder doEvaluate(ASICTransactionReport drrReport) {
			OptionOrSwaption11__1.OptionOrSwaption11__1Builder optn = OptionOrSwaption11__1.builder();
			return assignOutput(optn, drrReport);
		}
		
		protected OptionOrSwaption11__1.OptionOrSwaption11__1Builder assignOutput(OptionOrSwaption11__1.OptionOrSwaption11__1Builder optn, ASICTransactionReport drrReport) {
			final String ifThenElseResult;
			if (exists(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", aSICTransactionReport -> aSICTransactionReport.getOptionPremiumCurrency())).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", aSICTransactionReport -> aSICTransactionReport.getOptionPremiumCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get();
			} else if (areEqual(MapperS.of(drrReport).<BigDecimal>map("getOptionPremiumAmount", aSICTransactionReport -> aSICTransactionReport.getOptionPremiumAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<CommonLeg>map("getLeg1", aSICTransactionReport -> aSICTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get();
			} else {
				ifThenElseResult = null;
			}
			optn = toBuilder(OptionOrSwaption11__1.builder()
				.setStrkPric(MapperS.of(drrReport)
					.mapSingleToItem(item -> {
						String ifThenElseResult0 = null;
						if (areEqual(MapperS.of(drrReport).<CommonContractType>map("getContractType", aSICTransactionReport -> aSICTransactionReport.getContractType()), MapperS.of(CommonContractType.OPTN), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(drrReport).<CommonContractType>map("getContractType", aSICTransactionReport -> aSICTransactionReport.getContractType()), MapperS.of(CommonContractType.SWPT), CardinalityOperator.All)).andNullSafe(areEqual(areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", aSICTransactionReport -> aSICTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.INTR), CardinalityOperator.All), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
							if (greaterThan(MapperS.of(stringLength.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", aSICTransactionReport -> aSICTransactionReport.getStrikePriceCurrency()).get())), MapperS.of(3), CardinalityOperator.All).getOrDefault(false)) {
								ifThenElseResult0 = subString.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", aSICTransactionReport -> aSICTransactionReport.getStrikePriceCurrency()).get(), 5, 3);
							} else {
								ifThenElseResult0 = MapperS.of(drrReport).<String>map("getStrikePriceCurrency", aSICTransactionReport -> aSICTransactionReport.getStrikePriceCurrency()).get();
							}
						}
						Boolean ifThenElseResult1 = null;
						if (lessThan(item.<PriceFormat>map("getStrikePrice", aSICTransactionReport -> aSICTransactionReport.getStrikePrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult1 = false;
						}
						return MapperS.of(SecuritiesTransactionPrice17Choice__1.builder()
							.setMntryVal(AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getStrikePrice", aSICTransactionReport -> aSICTransactionReport.getStrikePrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(ifThenElseResult0)
									.build())
								.setSgn(ifThenElseResult1)
								.build())
							.setDcml(item.<PriceFormat>map("getStrikePrice", aSICTransactionReport -> aSICTransactionReport.getStrikePrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
							.build());
					}).get())
				.setCallAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(drrReport).<BigDecimal>map("getCallAmount", aSICTransactionReport -> aSICTransactionReport.getCallAmount()).get())
					.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getCallCurrency", aSICTransactionReport -> aSICTransactionReport.getCallCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setPutAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(drrReport).<BigDecimal>map("getPutAmount", aSICTransactionReport -> aSICTransactionReport.getPutAmount()).get())
					.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPutCurrency", aSICTransactionReport -> aSICTransactionReport.getPutCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setPrmAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(drrReport).<BigDecimal>map("getOptionPremiumAmount", aSICTransactionReport -> aSICTransactionReport.getOptionPremiumAmount()).get())
					.setCcy(ifThenElseResult)
					.build())
				.setPrmPmtDt(MapperS.of(drrReport).<Date>map("getOptionPremiumPaymentDate", aSICTransactionReport -> aSICTransactionReport.getOptionPremiumPaymentDate()).get())
				.setMtrtyDtOfUndrlyg(MapperS.of(drrReport).<Date>map("getMaturityDateOfTheUnderlying", aSICTransactionReport -> aSICTransactionReport.getMaturityDateOfTheUnderlying()).get())
				.setBrrrLvls(create_OptionBarrierLevel1Choice__1.evaluate(drrReport))
				.build());
			
			return Optional.ofNullable(optn)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
