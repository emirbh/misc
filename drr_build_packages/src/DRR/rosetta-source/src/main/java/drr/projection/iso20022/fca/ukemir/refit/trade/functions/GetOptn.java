package drr.projection.iso20022.fca.ukemir.refit.trade.functions;

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
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRTransactionReport;
import drr.standards.iso.OptionStyleEnum;
import drr.standards.iso.OptionTypeCode;
import iso20022.auth030.fca.ActiveOrHistoricCurrencyAnd13DecimalAmount__1;
import iso20022.auth030.fca.ActiveOrHistoricCurrencyAnd5DecimalAmount__1;
import iso20022.auth030.fca.AmountAndDirection106__1;
import iso20022.auth030.fca.OptionOrSwaption10__1;
import iso20022.auth030.fca.OptionStyle6Code__1;
import iso20022.auth030.fca.OptionType2Code;
import iso20022.auth030.fca.Schedule4__1;
import iso20022.auth030.fca.SecuritiesTransactionPrice17Choice__1;
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
	public OptionOrSwaption10__1 evaluate(FCAUKEMIRTransactionReport drrReport) {
		OptionOrSwaption10__1.OptionOrSwaption10__1Builder optnBuilder = doEvaluate(drrReport);
		
		final OptionOrSwaption10__1 optn;
		if (optnBuilder == null) {
			optn = null;
		} else {
			optn = optnBuilder.build();
			objectValidator.validate(OptionOrSwaption10__1.class, optn);
		}
		
		return optn;
	}

	protected abstract OptionOrSwaption10__1.OptionOrSwaption10__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport);

	public static class GetOptnDefault extends GetOptn {
		@Override
		protected OptionOrSwaption10__1.OptionOrSwaption10__1Builder doEvaluate(FCAUKEMIRTransactionReport drrReport) {
			OptionOrSwaption10__1.OptionOrSwaption10__1Builder optn = OptionOrSwaption10__1.builder();
			return assignOutput(optn, drrReport);
		}
		
		protected OptionOrSwaption10__1.OptionOrSwaption10__1Builder assignOutput(OptionOrSwaption10__1.OptionOrSwaption10__1Builder optn, FCAUKEMIRTransactionReport drrReport) {
			optn = toBuilder(OptionOrSwaption10__1.builder()
				.setTp(MapperS.of(drrReport).<OptionTypeCode>map("getOptionType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getOptionType()).checkedMap("to-enum", e -> OptionType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setExrcStyle(MapperS.of(drrReport).<OptionStyleEnum>map("getOptionStyle", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getOptionStyle()).checkedMap("to-enum", e -> OptionStyle6Code__1.valueOf(e.name()), IllegalArgumentException.class).get())
				.setStrkPric(MapperS.of(drrReport)
					.mapSingleToItem(item -> {
						String ifThenElseResult0 = null;
						if (areEqual(areEqual(MapperS.of(drrReport).<CommonContractType>map("getContractType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getContractType()), MapperS.of(CommonContractType.OPTN), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(drrReport).<CommonContractType>map("getContractType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getContractType()), MapperS.of(CommonContractType.SWPT), CardinalityOperator.All)).andNullSafe(areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.INTR), CardinalityOperator.All)), MapperS.of(false), CardinalityOperator.All).getOrDefault(false)) {
							if (greaterThan(MapperS.of(stringLength.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getStrikePriceCurrency()).get())), MapperS.of(3), CardinalityOperator.All).getOrDefault(false)) {
								ifThenElseResult0 = subString.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getStrikePriceCurrency()).get(), 5, 3);
							} else {
								ifThenElseResult0 = MapperS.of(drrReport).<String>map("getStrikePriceCurrency", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getStrikePriceCurrency()).get();
							}
						}
						Boolean ifThenElseResult1 = null;
						if (lessThan(item.<PriceFormat>map("getStrikePrice", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getStrikePrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult1 = false;
						}
						return MapperS.of(SecuritiesTransactionPrice17Choice__1.builder()
							.setMntryVal(AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount__1.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getStrikePrice", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getStrikePrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(ifThenElseResult0)
									.build())
								.setSgn(ifThenElseResult1)
								.build())
							.setPctg(item.<PriceFormat>map("getStrikePrice", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getStrikePrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()).get())
							.build());
					}).get())
				.setStrkPricSchdl(MapperS.of(drrReport).<PricePeriod>mapC("getStrikePriceSchedule", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getStrikePriceSchedule())
					.mapItem(item -> {
						AmountAndDirection106__1 ifThenElseResult2 = null;
						if (exists(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary())).getOrDefault(false)) {
							String ifThenElseResult0 = null;
							if (areEqual(MapperS.of(drrReport).<CommonContractType>map("getContractType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getContractType()), MapperS.of(CommonContractType.OPTN), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(drrReport).<CommonContractType>map("getContractType", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getContractType()), MapperS.of(CommonContractType.SWPT), CardinalityOperator.All)).andNullSafe(areEqual(areEqual(MapperS.of(drrReport).<CommonAssetClass>map("getAssetClass", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getAssetClass()), MapperS.of(CommonAssetClass.INTR), CardinalityOperator.All), MapperS.of(false), CardinalityOperator.All)).getOrDefault(false)) {
								if (greaterThan(MapperS.of(stringLength.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getStrikePriceCurrency()).get())), MapperS.of(3), CardinalityOperator.All).getOrDefault(false)) {
									ifThenElseResult0 = subString.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getStrikePriceCurrency()).get(), 5, 3);
								} else {
									ifThenElseResult0 = MapperS.of(drrReport).<String>map("getStrikePriceCurrency", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getStrikePriceCurrency()).get();
								}
							}
							Boolean ifThenElseResult1 = null;
							if (lessThan(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
								ifThenElseResult1 = false;
							}
							ifThenElseResult2 = AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount__1.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(ifThenElseResult0)
									.build())
								.setSgn(ifThenElseResult1)
								.build();
						}
						BigDecimal ifThenElseResult3 = null;
						if (exists(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage())).getOrDefault(false)) {
							ifThenElseResult3 = item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getPercentage", priceFormat -> priceFormat.getPercentage()).get();
						}
						return MapperS.of(Schedule4__1.builder()
							.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()).get())
							.setUadjstdEndDt(item.<Date>map("getEndDate", pricePeriod -> pricePeriod.getEndDate()).get())
							.setPric(SecuritiesTransactionPrice17Choice__1.builder()
								.setMntryVal(ifThenElseResult2)
								.setPctg(ifThenElseResult3)
								.build())
							.build());
					}).getMulti())
				.setPrmAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount__1.builder()
					.setValue(MapperS.of(drrReport).<BigDecimal>map("getOptionPremiumAmount", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getOptionPremiumAmount()).get())
					.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getOptionPremiumCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setPrmPmtDt(MapperS.of(drrReport).<Date>map("getOptionPremiumPaymentDate", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getOptionPremiumPaymentDate()).get())
				.setMtrtyDtOfUndrlyg(MapperS.of(drrReport).<Date>map("getMaturityDateOfTheUnderlying", fCAUKEMIRTransactionReport -> fCAUKEMIRTransactionReport.getMaturityDateOfTheUnderlying()).get())
				.build());
			
			return Optional.ofNullable(optn)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
