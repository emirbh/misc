package drr.projection.iso20022.hkma.rewrite.trade.dtcc.functions;

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
import drr.regulation.common.trade.CommonLeg;
import drr.regulation.hkma.rewrite.trade.HKMATransactionReport;
import drr.standards.iso.EmbeddedOptionTypeEnum;
import drr.standards.iso.OptionStyleEnum;
import drr.standards.iso.OptionTypeCode;
import iso20022.auth030.hkma.dtcc.ActiveOrHistoricCurrencyAnd13DecimalAmount;
import iso20022.auth030.hkma.dtcc.ActiveOrHistoricCurrencyAnd5DecimalAmount;
import iso20022.auth030.hkma.dtcc.AmountAndDirection106__1;
import iso20022.auth030.hkma.dtcc.AmountAndDirection106__2;
import iso20022.auth030.hkma.dtcc.EmbeddedType1Code;
import iso20022.auth030.hkma.dtcc.ExerciseDate1Choice__1;
import iso20022.auth030.hkma.dtcc.OptionOrSwaption11__1;
import iso20022.auth030.hkma.dtcc.OptionStyle6Code;
import iso20022.auth030.hkma.dtcc.OptionType2Code;
import iso20022.auth030.hkma.dtcc.Schedule4__1;
import iso20022.auth030.hkma.dtcc.SecuritiesTransactionPrice17Choice__1;
import iso20022.auth030.hkma.dtcc.SecuritiesTransactionPrice17Choice__2;
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
	public OptionOrSwaption11__1 evaluate(HKMATransactionReport drrReport) {
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

	protected abstract OptionOrSwaption11__1.OptionOrSwaption11__1Builder doEvaluate(HKMATransactionReport drrReport);

	public static class GetOptnDefault extends GetOptn {
		@Override
		protected OptionOrSwaption11__1.OptionOrSwaption11__1Builder doEvaluate(HKMATransactionReport drrReport) {
			OptionOrSwaption11__1.OptionOrSwaption11__1Builder optn = OptionOrSwaption11__1.builder();
			return assignOutput(optn, drrReport);
		}
		
		protected OptionOrSwaption11__1.OptionOrSwaption11__1Builder assignOutput(OptionOrSwaption11__1.OptionOrSwaption11__1Builder optn, HKMATransactionReport drrReport) {
			final String ifThenElseResult;
			if (exists(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", hKMATransactionReport -> hKMATransactionReport.getOptionPremiumCurrency())).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getOptionPremiumCurrency", hKMATransactionReport -> hKMATransactionReport.getOptionPremiumCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get();
			} else if (areEqual(MapperS.of(drrReport).<BigDecimal>map("getOptionPremiumAmount", hKMATransactionReport -> hKMATransactionReport.getOptionPremiumAmount()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
				ifThenElseResult = MapperS.of(drrReport).<CommonLeg>map("getLeg1", hKMATransactionReport -> hKMATransactionReport.getLeg1()).<ISOCurrencyCodeEnum>map("getSettlementCurrency", commonLeg -> commonLeg.getSettlementCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get();
			} else {
				ifThenElseResult = null;
			}
			optn = toBuilder(OptionOrSwaption11__1.builder()
				.setStrkPric(MapperS.of(drrReport)
					.mapSingleToItem(item -> {
						final String ifThenElseResult0;
						if (greaterThan(MapperS.of(stringLength.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", hKMATransactionReport -> hKMATransactionReport.getStrikePriceCurrency()).get())), MapperS.of(3), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult0 = MapperS.of(subString.evaluate(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", hKMATransactionReport -> hKMATransactionReport.getStrikePriceCurrency()).get(), 5, 3)).map("to-string", Object::toString).get();
						} else {
							ifThenElseResult0 = MapperS.of(drrReport).<String>map("getStrikePriceCurrency", hKMATransactionReport -> hKMATransactionReport.getStrikePriceCurrency()).map("to-string", Object::toString).get();
						}
						Boolean ifThenElseResult1 = null;
						if (lessThan(item.<PriceFormat>map("getStrikePrice", hKMATransactionReport -> hKMATransactionReport.getStrikePrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()), MapperS.of(BigDecimal.valueOf(0)), CardinalityOperator.All).getOrDefault(false)) {
							ifThenElseResult1 = false;
						}
						return MapperS.of(SecuritiesTransactionPrice17Choice__1.builder()
							.setMntryVal(AmountAndDirection106__1.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
									.setValue(abs.evaluate(item.<PriceFormat>map("getStrikePrice", hKMATransactionReport -> hKMATransactionReport.getStrikePrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get()))
									.setCcy(ifThenElseResult0)
									.build())
								.setSgn(ifThenElseResult1)
								.build())
							.setDcml(item.<PriceFormat>map("getStrikePrice", hKMATransactionReport -> hKMATransactionReport.getStrikePrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
							.build());
					}).get())
				.setCallAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(drrReport).<BigDecimal>map("getCallAmount", hKMATransactionReport -> hKMATransactionReport.getCallAmount()).get())
					.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getCallCurrency", hKMATransactionReport -> hKMATransactionReport.getCallCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setPutAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(drrReport).<BigDecimal>map("getPutAmount", hKMATransactionReport -> hKMATransactionReport.getPutAmount()).get())
					.setCcy(MapperS.of(drrReport).<ISOCurrencyCodeEnum>map("getPutCurrency", hKMATransactionReport -> hKMATransactionReport.getPutCurrency()).map("to-string", ISOCurrencyCodeEnum::toDisplayString).get())
					.build())
				.setPrmAmt(ActiveOrHistoricCurrencyAnd5DecimalAmount.builder()
					.setValue(MapperS.of(drrReport).<BigDecimal>map("getOptionPremiumAmount", hKMATransactionReport -> hKMATransactionReport.getOptionPremiumAmount()).get())
					.setCcy(ifThenElseResult)
					.build())
				.setPrmPmtDt(MapperS.of(drrReport).<Date>map("getOptionPremiumPaymentDate", hKMATransactionReport -> hKMATransactionReport.getOptionPremiumPaymentDate()).get())
				.setMtrtyDtOfUndrlyg(MapperS.of(drrReport).<Date>map("getMaturityDateOfTheUnderlying", hKMATransactionReport -> hKMATransactionReport.getMaturityDateOfTheUnderlying()).get())
				.setBrrrLvls(create_OptionBarrierLevel1Choice__1.evaluate(drrReport))
				.setTp(MapperS.of(drrReport).<OptionTypeCode>map("getOptionType", hKMATransactionReport -> hKMATransactionReport.getOptionType()).checkedMap("to-enum", e -> OptionType2Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setMbddTp(MapperS.of(drrReport).<EmbeddedOptionTypeEnum>map("getEmbeddedOptionType", hKMATransactionReport -> hKMATransactionReport.getEmbeddedOptionType()).checkedMap("to-enum", e -> EmbeddedType1Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setExrcStyle(MapperS.of(drrReport).<OptionStyleEnum>map("getOptionStyle", hKMATransactionReport -> hKMATransactionReport.getOptionStyle()).checkedMap("to-enum", e -> OptionStyle6Code.valueOf(e.name()), IllegalArgumentException.class).get())
				.setExrcDt(ExerciseDate1Choice__1.builder()
					.setFrstExrcDt(MapperS.of(drrReport).<Date>map("getFirstExerciseDate", hKMATransactionReport -> hKMATransactionReport.getFirstExerciseDate()).get())
					.build())
				.setStrkPricSchdl(MapperS.of(drrReport).<PricePeriod>mapC("getStrikePriceSchedule", hKMATransactionReport -> hKMATransactionReport.getStrikePriceSchedule())
					.mapItem(item -> MapperS.of(Schedule4__1.builder()
						.setUadjstdFctvDt(item.<Date>map("getEffectiveDate", pricePeriod -> pricePeriod.getEffectiveDate()).get())
						.setUadjstdEndDt(item.<Date>map("getEndDate", pricePeriod -> pricePeriod.getEndDate()).get())
						.setPric(SecuritiesTransactionPrice17Choice__2.builder()
							.setMntryVal(AmountAndDirection106__2.builder()
								.setAmt(ActiveOrHistoricCurrencyAnd13DecimalAmount.builder()
									.setValue(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getMonetary", priceFormat -> priceFormat.getMonetary()).get())
									.setCcy(MapperS.of(drrReport).<String>map("getStrikePriceCurrency", hKMATransactionReport -> hKMATransactionReport.getStrikePriceCurrency()).get())
									.build())
								.build())
							.setDcml(item.<PriceFormat>map("getPrice", pricePeriod -> pricePeriod.getPrice()).<BigDecimal>map("getDecimal", priceFormat -> priceFormat.getDecimal()).get())
							.build())
						.build())).getMulti())
				.build());
			
			return Optional.ofNullable(optn)
				.map(o -> o.prune())
				.orElse(null);
		}
	}
}
