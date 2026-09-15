package drr.projection.iso20022.mas.rewrite.trade.functions;

import cdm.base.math.functions.Abs;
import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import drr.base.trade.price.PriceFormat;
import drr.base.trade.price.PricePeriod;
import drr.base.util.string.functions.StringLength;
import drr.base.util.string.functions.SubString;
import drr.regulation.common.CommonAssetClass;
import drr.regulation.common.CommonContractType;
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.mas.rewrite.trade.MASTransactionReport;
import drr.standards.iso.OptionStyleEnum;
import drr.standards.iso.OptionTypeCode;
import iso20022.auth030.mas.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.mas.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.mas.AmountAndDirection106__1;
import iso20022.auth030.mas.ExerciseDate1Choice__1;
import iso20022.auth030.mas.OptionOrSwaption11__1;
import iso20022.auth030.mas.OptionStyle6Code;
import iso20022.auth030.mas.OptionType2Code;
import iso20022.auth030.mas.Schedule4__1;
import iso20022.auth030.mas.SecuritiesTransactionPrice17Choice__1;
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
	@Inject protected StringLength stringLength;
	@Inject protected SubString subString;

	/**
	* @param drrReport 
	* @return optn 
	*/
	public OptionOrSwaption11__1 evaluate(MASTransactionReport drrReport) {
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

	protected abstract OptionOrSwaption11__1.OptionOrSwaption11__1Builder doEvaluate(MASTransactionReport drrReport);

	public static class GetOptnDefault extends GetOptn {
		@Override
		protected OptionOrSwaption11__1.OptionOrSwaption11__1Builder doEvaluate(MASTransactionReport drrReport) {
			OptionOrSwaption11__1.OptionOrSwaption11__1Builder optn = OptionOrSwaption11__1.builder();
			return assignOutput(optn, drrReport);
		}
		
		protected OptionOrSwaption11__1.OptionOrSwaption11__1Builder assignOutput(OptionOrSwaption11__1.OptionOrSwaption11__1Builder optn, MASTransactionReport drrReport) {
			final String ifThenElseResult;
			if (exists(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", mASTransactionReport -> mASTransactionReport.getOptionPremiumCurrency())).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", mASTransactionReport -> mASTransactionReport.getOptionPremiumCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get();
			} else if (areEqual(MapperS.of(drrReport).<BigDecimal>map("getOptionPremiumAmount", mASTransactionReport -> mASTransactionReport.getOptionPremiumAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<CommonLeg>map("getLeg1", mASTransactionReport -> mASTransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get();
			} else {
				ifThenElseResult = null;
			}
			optn = toBuilder(OptionOrSwaption11__1.builder()
				.setTp(MapperS.of(drrReport).<OptionTypeCode>map("getOptionType", mASTransactionReport -> mASTransactionReport.getOptionType()).checkedMap("to-enum", e -> OptionType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setExrcStyle(MapperS.of(drrReport).<OptionStyleEnum>map("getOptionStyle", mASTransactionReport -> mASTransactionReport.getOptionStyle()).checkedMap("to-enum", e -> OptionStyle6Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setExrcDt(ExerciseDate1Choice__1.builder()
					.setFrstExrcDt(MapperS.of(drrReport).<Date>map("getFirstExerciseDate", mASTransactionReport -> mASTransactionReport.getFirstExerciseDate()).get())
					.build())
				.setStrkPric(MapperS.of(drrReport)
					.mapSingleToItem(item -> {
						String ifThenElseResult0 = null;
						if (areEqual(MapperS.of(drrReport).<CommonContractType>map("getContractType", mASTransactionReport -> mASTransactionReport.getContractType()), MapperS.of(CommonContractType.OPTN), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(drrReport).<CommonContractType>map("getContractType", mASTransactionReport -> mASTransactionReport.getContractType()), MapperS.of(CommonContractType.SWPT), CardinalityOperator.All)).andNullSafe(areEqual(areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", mASTransactionReport -> mASTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.INTR), CardinalityOperator.All), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
							if (greaterThan(MapperS.of(stringLength.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", mASTransactionReport -> mASTransactionReport.getStrikePriceCurrency()).get())), MapperS.of(3), CardinalityOperator.All).getOrDefault(false)) {
								ifThenElseResult0 = subString.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", mASTransactionReport -> mASTransactionReport.getStrikePriceCurrency()).get(), 5, 3);
							} else {
								ifThenElseResult0 = MapperS.of(drrReport).<String>map("getStrikePriceCurrency", mASTransactionReport -> mASTransactionReport.getStrikePriceCurrency()).get();
							}
						}
						Boolean ifThenElseResult1 = null;
						if (lessThan(item.<PriceFormat>map("getStrikePrice", mASTransactionReport -> mASTransactionReport.getStrikePrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult1 = false;
						}
						return MapperS.of(SecuritiesTransactionPrice17Choice__1.builder()
							.setMntryVal(AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getStrikePrice", mASTransactionReport -> mASTransactionReport.getStrikePrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(ifThenElseResult0)
									.build())
								.setSgn(ifThenElseResult1)
								.build())
							.setDcml(item.<PriceFormat>map("getStrikePrice", mASTransactionReport -> mASTransactionReport.getStrikePrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
							.build());
					}).get())
				.setStrkPricSchdl(MapperS.of(drrReport).<PricePeriod>mapC("getStrikePriceSchedule", mASTransactionReport -> mASTransactionReport.getStrikePriceSchedule())
					.mapItem(item -> {
						AmountAndDirection106__1 ifThenElseResult2 = null;
						if (exists(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary())).getOrDefault(false)) {
							String ifThenElseResult0 = null;
							if (areEqual(MapperS.of(drrReport).<CommonContractType>map("getContractType", mASTransactionReport -> mASTransactionReport.getContractType()), MapperS.of(CommonContractType.OPTN), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(drrReport).<CommonContractType>map("getContractType", mASTransactionReport -> mASTransactionReport.getContractType()), MapperS.of(CommonContractType.SWPT), CardinalityOperator.All)).andNullSafe(areEqual(areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", mASTransactionReport -> mASTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.CURR), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", mASTransactionReport -> mASTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.INTR), CardinalityOperator.All)), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
								ifThenElseResult0 = MapperS.of(drrReport).<String>map("getStrikePriceCurrency", mASTransactionReport -> mASTransactionReport.getStrikePriceCurrency()).map("to-string", Object::toString).get();
							}
							Boolean ifThenElseResult1 = null;
							if (lessThan(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
								ifThenElseResult1 = false;
							}
							ifThenElseResult2 = AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(ifThenElseResult0)
									.build())
								.setSgn(ifThenElseResult1)
								.build();
						}
						BigDecimal ifThenElseResult3 = null;
						if (exists(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal())).getOrDefault(false)) {
							ifThenElseResult3 = item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get();
						}
						return MapperS.of(Schedule4__1.builder()
							.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()).get())
							.setUadjstdEndDt(item.<Date>map("getEndDate", pricePeriod -> pricePeriod.getEndDate()).get())
							.setPric(SecuritiesTransactionPrice17Choice__1.builder()
								.setMntryVal(ifThenElseResult2)
								.setDcml(ifThenElseResult3)
								.build())
							.build());
					}).getMulti())
				.setCallAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(drrReport).<BigDecimal>map("getCallAmount", mASTransactionReport -> mASTransactionReport.getCallAmount()).get())
					.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getCallCurrency", mASTransactionReport -> mASTransactionReport.getCallCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setPutAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(drrReport).<BigDecimal>map("getPutAmount", mASTransactionReport -> mASTransactionReport.getPutAmount()).get())
					.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPutCurrency", mASTransactionReport -> mASTransactionReport.getPutCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setPrmAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(drrReport).<BigDecimal>map("getOptionPremiumAmount", mASTransactionReport -> mASTransactionReport.getOptionPremiumAmount()).get())
					.setCcy(ifThenElseResult)
					.build())
				.build());
			
			return Optional.ofNullable(optn)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
