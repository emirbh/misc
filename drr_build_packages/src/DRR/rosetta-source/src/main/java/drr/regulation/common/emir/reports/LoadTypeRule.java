package drr.regulation.common.emir.reports;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.Commodity;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.AssetDeliveryInformation;
import cdm.product.asset.AssetDeliveryPeriods;
import cdm.product.asset.AssetDeliveryProfile;
import cdm.product.asset.CalculationScheduleDeliveryPeriods;
import cdm.product.asset.CommodityPayout;
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
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.reports.ReportFunction;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.GetLoadType;
import drr.standards.iso.EnergyLoadType1Code;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(LoadTypeRule.LoadTypeRuleDefault.class)
public abstract class LoadTypeRule implements ReportFunction<TransactionReportInstruction, EnergyLoadType1Code> {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected GetLoadType getLoadType;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_Commodity_Option qualify_Commodity_Option;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;

	/**
	* @param input 
	* @return output 
	*/
	@Override
	public EnergyLoadType1Code evaluate(TransactionReportInstruction input) {
		EnergyLoadType1Code output = doEvaluate(input);
		
		return output;
	}

	protected abstract EnergyLoadType1Code doEvaluate(TransactionReportInstruction input);

	public static class LoadTypeRuleDefault extends LoadTypeRule {
		@Override
		protected EnergyLoadType1Code doEvaluate(TransactionReportInstruction input) {
			EnergyLoadType1Code output = null;
			return assignOutput(output, input);
		}
		
		protected EnergyLoadType1Code assignOutput(EnergyLoadType1Code output, TransactionReportInstruction input) {
			final MapperS<EconomicTerms> thenArg0 = MapperS.of(input)
				.mapSingleToItem(item -> MapperS.of(economicTermsForProduct.evaluate(productForEvent.evaluate(item.get()))));
			final MapperC<AssetDeliveryProfile> thenArg1 = thenArg0
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
					if (exists(item.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<Underlier>map("getUnderlier", settlementPayout -> settlementPayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Commodity>map("getCommodity", asset -> asset.getCommodity())).getOrDefault(false)) {
						final MapperS<SettlementPayout> thenArg3 = MapperS.of(item.<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get());
						return thenArg3
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
					return MapperC.<AssetDeliveryProfile>ofNull();
				});
			final MapperC<EnergyLoadType1Code> thenArg2 = thenArg1
				.mapItem(item -> MapperS.of(getLoadType.evaluate(item.get())));
			output = MapperS.of(distinctIgnoringPrecision(thenArg2).get()).checkedMap("to-enum", e -> EnergyLoadType1Code.valueOf(e.name()), IllegalArgumentException.class).get();
			
			return output;
		}
	}
}
