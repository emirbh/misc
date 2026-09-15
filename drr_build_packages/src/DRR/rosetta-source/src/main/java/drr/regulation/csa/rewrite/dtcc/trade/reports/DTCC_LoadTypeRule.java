package drr.regulation.csa.rewrite.dtcc.trade.reports;

import cdm.product.asset.AssetDeliveryInformation;
import cdm.product.asset.AssetDeliveryPeriods;
import cdm.product.asset.AssetDeliveryProfile;
import cdm.product.asset.CalculationScheduleDeliveryPeriods;
import cdm.product.asset.CommodityPayout;
import cdm.product.asset.LoadTypeEnum;
import cdm.product.qualification.functions.Qualify_AssetClass_Commodity;
import cdm.product.qualification.functions.Qualify_Commodity_Forward;
import cdm.product.qualification.functions.Qualify_Commodity_Option;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_Basis;
import cdm.product.qualification.functions.Qualify_Commodity_Swap_FixedFloat;
import cdm.product.qualification.functions.Qualify_Commodity_Swaption;
import cdm.product.template.CalculationSchedule;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.SchedulePeriod;
import cdm.product.template.SettlementPayout;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.csa.rewrite.trade.functions.IsAllowableActionForCSA;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DTCC_LoadTypeRule.DTCC_LoadTypeRuleDefault.class)
public abstract class DTCC_LoadTypeRule implements ReportFunction<TransactionReportInstruction, String> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsAllowableActionForCSA isAllowableActionForCSA;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Commodity qualify_AssetClass_Commodity;
	@Inject protected Qualify_Commodity_Forward qualify_Commodity_Forward;
	@Inject protected Qualify_Commodity_Option qualify_Commodity_Option;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public String evaluate(TransactionReportInstruction input) {
		String output = doEvaluate(input);
		
		return output;
	}

	protected abstract String doEvaluate(TransactionReportInstruction input);

	public static class DTCC_LoadTypeRuleDefault extends DTCC_LoadTypeRule {
		@Override
		protected String doEvaluate(TransactionReportInstruction input) {
			String output = null;
			return assignOutput(output, input);
		}
		
		protected String assignOutput(String output, TransactionReportInstruction input) {
			final MapperS<TransactionReportInstruction> thenArg0 = MapperS.of(input)
				.filterSingleNullSafe(item -> isAllowableActionForCSA.evaluate(item.get()));
			final MapperS<EconomicTerms> thenArg1 = thenArg0
				.mapSingleToItem(item -> MapperS.of(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get()))));
			final MapperS<EconomicTerms> thenArg2 = thenArg1
				.filterSingleNullSafe(item -> qualify_AssetClass_Commodity.evaluate(item.get()));
			final MapperC<AssetDeliveryProfile> thenArg3 = thenArg2
				.mapSingleToList(item -> {
					if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(item.get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(item.get())))).getOrDefault(false)) {
						final MapperS<CommodityPayout> _thenArg0 = item.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout())
							.first();
						return _thenArg0
							.mapSingleToList(_item -> {
								if (exists(_item.<AssetDeliveryInformation>map("getDelivery", commodityPayout -> commodityPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile())).getOrDefault(false)) {
									return _item.<AssetDeliveryInformation>map("getDelivery", commodityPayout -> commodityPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile());
								}
								if (exists(_item.<CalculationSchedule>map("getSchedule", commodityPayout -> commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile())).getOrDefault(false)) {
									return _item.<CalculationSchedule>map("getSchedule", commodityPayout -> commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile());
								}
								return MapperC.<AssetDeliveryProfile>ofNull();
							});
					}
					final Boolean boolean0 = qualify_Commodity_Swaption.evaluate(item.get());
					if ((boolean0 == null ? false : boolean0)) {
						final MapperS<CommodityPayout> _thenArg1 = MapperS.of(economicTermsForProduct.evaluate(item.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", product -> product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout())
							.first();
						return _thenArg1
							.mapSingleToList(_item -> {
								if (exists(_item.<AssetDeliveryInformation>map("getDelivery", commodityPayout -> commodityPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile())).getOrDefault(false)) {
									return _item.<AssetDeliveryInformation>map("getDelivery", commodityPayout -> commodityPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile());
								}
								if (exists(_item.<CalculationSchedule>map("getSchedule", commodityPayout -> commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile())).getOrDefault(false)) {
									return _item.<CalculationSchedule>map("getSchedule", commodityPayout -> commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile());
								}
								return MapperC.<AssetDeliveryProfile>ofNull();
							});
					}
					final Boolean boolean1 = qualify_Commodity_Option.evaluate(item.get());
					if ((boolean1 == null ? false : boolean1)) {
						final MapperS<OptionPayout> _thenArg2 = MapperS.of(item.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get());
						return _thenArg2
							.mapSingleToList(_item -> {
								if (exists(_item.<AssetDeliveryInformation>map("getDelivery", optionPayout -> optionPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile())).getOrDefault(false)) {
									return _item.<AssetDeliveryInformation>map("getDelivery", optionPayout -> optionPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile());
								}
								if (exists(_item.<CalculationSchedule>map("getSchedule", optionPayout -> optionPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile())).getOrDefault(false)) {
									return _item.<CalculationSchedule>map("getSchedule", optionPayout -> optionPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile());
								}
								return MapperC.<AssetDeliveryProfile>ofNull();
							});
					}
					final Boolean boolean2 = qualify_Commodity_Forward.evaluate(item.get());
					if ((boolean2 == null ? false : boolean2)) {
						final MapperS<SettlementPayout> _thenArg3 = MapperS.of(item.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get());
						return _thenArg3
							.mapSingleToList(_item -> {
								if (exists(_item.<AssetDeliveryInformation>map("getDelivery", settlementPayout -> settlementPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile())).getOrDefault(false)) {
									return _item.<AssetDeliveryInformation>map("getDelivery", settlementPayout -> settlementPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile());
								}
								if (exists(_item.<CalculationSchedule>map("getSchedule", settlementPayout -> settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile())).getOrDefault(false)) {
									return _item.<CalculationSchedule>map("getSchedule", settlementPayout -> settlementPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile());
								}
								return MapperC.<AssetDeliveryProfile>ofNull();
							});
					}
					final MapperS<CommodityPayout> _thenArg4 = MapperS.of(item.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).get());
					return _thenArg4
						.mapSingleToList(_item -> {
							if (exists(_item.<AssetDeliveryInformation>map("getDelivery", commodityPayout -> commodityPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile())).getOrDefault(false)) {
								return _item.<AssetDeliveryInformation>map("getDelivery", commodityPayout -> commodityPayout.getDelivery()).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods()).<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile());
							}
							if (exists(_item.<CalculationSchedule>map("getSchedule", commodityPayout -> commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile())).getOrDefault(false)) {
								return _item.<CalculationSchedule>map("getSchedule", commodityPayout -> commodityPayout.getSchedule()).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod()).<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", schedulePeriod -> schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile());
							}
							return MapperC.<AssetDeliveryProfile>ofNull();
						});
				});
			final MapperC<String> thenArg4 = thenArg3
				.mapItem(item -> {
					if (areEqual(item.<LoadTypeEnum>map("getLoadType", assetDeliveryProfile -> assetDeliveryProfile.getLoadType()), MapperS.of(LoadTypeEnum.BASE_LOAD), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("Base");
					}
					if (areEqual(item.<LoadTypeEnum>map("getLoadType", assetDeliveryProfile -> assetDeliveryProfile.getLoadType()), MapperS.of(LoadTypeEnum.PEAK_LOAD), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("Peak");
					}
					if (areEqual(item.<LoadTypeEnum>map("getLoadType", assetDeliveryProfile -> assetDeliveryProfile.getLoadType()), MapperS.of(LoadTypeEnum.OFF_PEAK), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("OffPeak");
					}
					if (areEqual(item.<LoadTypeEnum>map("getLoadType", assetDeliveryProfile -> assetDeliveryProfile.getLoadType()), MapperS.of(LoadTypeEnum.BLOCK_HOURS), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("BlockHours");
					}
					if (areEqual(item.<LoadTypeEnum>map("getLoadType", assetDeliveryProfile -> assetDeliveryProfile.getLoadType()), MapperS.of(LoadTypeEnum.SHAPED), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("Shaped");
					}
					if (areEqual(item.<LoadTypeEnum>map("getLoadType", assetDeliveryProfile -> assetDeliveryProfile.getLoadType()), MapperS.of(LoadTypeEnum.GAS_DAY), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("Gas Day");
					}
					if (areEqual(item.<LoadTypeEnum>map("getLoadType", assetDeliveryProfile -> assetDeliveryProfile.getLoadType()), MapperS.of(LoadTypeEnum.OTHER), CardinalityOperator.All).getOrDefault(false)) {
						return MapperS.of("Custom");
					}
					return MapperS.<String>ofNull();
				});
			output = MapperS.of(distinctIgnoringPrecision(thenArg4).get()).get();
			
			return output;
		}
	}
}
