package drr.regulation.common.emir.functions;

import cdm.base.datetime.DayOfWeekEnum;
import cdm.base.math.Quantity;
import cdm.base.math.UnitType;
import cdm.observable.asset.Price;
import cdm.product.asset.AssetDeliveryInformation;
import cdm.product.asset.AssetDeliveryPeriods;
import cdm.product.asset.AssetDeliveryProfile;
import cdm.product.asset.AssetDeliveryProfileBlock;
import cdm.product.asset.BankHolidayTreatmentEnum;
import cdm.product.asset.CalculationScheduleDeliveryPeriods;
import cdm.product.asset.CommodityPayout;
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
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.ModelObjectValidator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperListOfLists;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.records.Date;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.qualification.product.functions.IsSingleCommodityPayoutProduct;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.regulation.common.CommodityTimeUnitEnum;
import drr.regulation.common.RegimeNameEnum;
import drr.regulation.common.ReportableDelivery;
import drr.regulation.common.SupervisoryBodyEnum;
import drr.regulation.common.TransactionInformation;
import drr.regulation.common.TransactionReportInstruction;
import drr.regulation.common.functions.Create_DeliveryBlock;
import drr.regulation.common.functions.GetTransactionInformationForRegime;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetReportableDelivery.GetReportableDeliveryDefault.class)
public abstract class GetReportableDelivery implements RosettaFunction {
	
	@Inject protected ModelObjectValidator objectValidator;
	
	// RosettaFunction dependencies
	//
	@Inject protected Create_DeliveryBlock create_DeliveryBlock;
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected GetTransactionInformationForRegime getTransactionInformationForRegime;
	@Inject protected IsSingleCommodityPayoutProduct isSingleCommodityPayoutProduct;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_Commodity_Forward qualify_Commodity_Forward;
	@Inject protected Qualify_Commodity_Option qualify_Commodity_Option;
	@Inject protected Qualify_Commodity_Swap_Basis qualify_Commodity_Swap_Basis;
	@Inject protected Qualify_Commodity_Swap_FixedFloat qualify_Commodity_Swap_FixedFloat;
	@Inject protected Qualify_Commodity_Swaption qualify_Commodity_Swaption;

	/**
	* @param transaction 
	* @return reportableDelivery 
	*/
	public List<? extends ReportableDelivery> evaluate(TransactionReportInstruction transaction) {
		List<ReportableDelivery.ReportableDeliveryBuilder> reportableDeliveryBuilder = doEvaluate(transaction);
		
		final List<? extends ReportableDelivery> reportableDelivery;
		if (reportableDeliveryBuilder == null) {
			reportableDelivery = null;
		} else {
			reportableDelivery = reportableDeliveryBuilder.stream().map(ReportableDelivery::build).collect(Collectors.toList());
			objectValidator.validate(ReportableDelivery.class, reportableDelivery);
		}
		
		return reportableDelivery;
	}

	protected abstract List<ReportableDelivery.ReportableDeliveryBuilder> doEvaluate(TransactionReportInstruction transaction);

	protected abstract MapperS<? extends NonTransferableProduct> product(TransactionReportInstruction transaction);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(TransactionReportInstruction transaction);

	protected abstract MapperS<? extends AssetDeliveryInformation> delivery(TransactionReportInstruction transaction);

	protected abstract MapperS<? extends CalculationSchedule> customizedSchedule(TransactionReportInstruction transaction);

	protected abstract MapperS<CommodityTimeUnitEnum> duration(TransactionReportInstruction transaction);

	public static class GetReportableDeliveryDefault extends GetReportableDelivery {
		@Override
		protected List<ReportableDelivery.ReportableDeliveryBuilder> doEvaluate(TransactionReportInstruction transaction) {
			List<ReportableDelivery.ReportableDeliveryBuilder> reportableDelivery = new ArrayList<>();
			return assignOutput(reportableDelivery, transaction);
		}
		
		protected List<ReportableDelivery.ReportableDeliveryBuilder> assignOutput(List<ReportableDelivery.ReportableDeliveryBuilder> reportableDelivery, TransactionReportInstruction transaction) {
			if (exists(customizedSchedule(transaction)).getOrDefault(false)) {
				final MapperListOfLists<ReportableDelivery> thenArg = customizedSchedule(transaction).<SchedulePeriod>mapC("getSchedulePeriod", calculationSchedule -> calculationSchedule.getSchedulePeriod())
					.mapItemToList(schedulePeriod -> {
						final MapperListOfLists<ReportableDelivery> _thenArg = schedulePeriod.<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", _schedulePeriod -> _schedulePeriod.getDeliveryPeriod()).<AssetDeliveryProfile>mapC("getProfile", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getProfile())
							.mapItemToList(deliveryProfile -> deliveryProfile.<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock())
								.mapItem(deliveryBlock -> {
									final Quantity ifThenElseResult0;
									if (exists(schedulePeriod.<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", _schedulePeriod -> _schedulePeriod.getDeliveryPeriod()).<Quantity>map("getDeliveryCapacity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getDeliveryCapacity())).getOrDefault(false)) {
										ifThenElseResult0 = schedulePeriod.<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", _schedulePeriod -> _schedulePeriod.getDeliveryPeriod()).<Quantity>map("getDeliveryCapacity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getDeliveryCapacity()).get();
									} else if (exists(deliveryBlock.<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity())).getOrDefault(false)) {
										ifThenElseResult0 = deliveryBlock.<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity()).get();
									} else {
										ifThenElseResult0 = null;
									}
									final BigDecimal ifThenElseResult1;
									if (exists(schedulePeriod.<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", _schedulePeriod -> _schedulePeriod.getDeliveryPeriod()).<Price>map("getPriceTimeIntervalQuantity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getPriceTimeIntervalQuantity())).getOrDefault(false)) {
										ifThenElseResult1 = schedulePeriod.<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", _schedulePeriod -> _schedulePeriod.getDeliveryPeriod()).<Price>map("getPriceTimeIntervalQuantity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getPriceTimeIntervalQuantity()).<BigDecimal>map("getValue", price -> price.getValue()).get();
									} else if (exists(deliveryBlock.<Price>map("getPriceTimeIntervalQuantity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getPriceTimeIntervalQuantity())).getOrDefault(false)) {
										ifThenElseResult1 = deliveryBlock.<Price>map("getPriceTimeIntervalQuantity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getPriceTimeIntervalQuantity()).<BigDecimal>map("getValue", price -> price.getValue()).get();
									} else {
										ifThenElseResult1 = null;
									}
									final String ifThenElseResult2;
									if (exists(schedulePeriod.<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", _schedulePeriod -> _schedulePeriod.getDeliveryPeriod()).<Price>map("getPriceTimeIntervalQuantity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getPriceTimeIntervalQuantity())).getOrDefault(false)) {
										final FieldWithMetaString fieldWithMetaString0 = schedulePeriod.<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", _schedulePeriod -> _schedulePeriod.getDeliveryPeriod()).<Price>map("getPriceTimeIntervalQuantity", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getPriceTimeIntervalQuantity()).<UnitType>map("getUnit", price -> price.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
										ifThenElseResult2 = fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue();
									} else if (exists(deliveryBlock.<Price>map("getPriceTimeIntervalQuantity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getPriceTimeIntervalQuantity())).getOrDefault(false)) {
										final FieldWithMetaString fieldWithMetaString1 = deliveryBlock.<Price>map("getPriceTimeIntervalQuantity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getPriceTimeIntervalQuantity()).<UnitType>map("getUnit", price -> price.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
										ifThenElseResult2 = fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue();
									} else {
										ifThenElseResult2 = null;
									}
									return MapperS.of(create_DeliveryBlock.evaluate(deliveryBlock.<LocalTime>map("getStartTime", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getStartTime()).get(), deliveryBlock.<LocalTime>map("getEndTime", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getEndTime()).get(), schedulePeriod.<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", _schedulePeriod -> _schedulePeriod.getDeliveryPeriod()).<Date>map("getStartDate", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getStartDate()).get(), schedulePeriod.<CalculationScheduleDeliveryPeriods>map("getDeliveryPeriod", _schedulePeriod -> _schedulePeriod.getDeliveryPeriod()).<Date>map("getEndDate", calculationScheduleDeliveryPeriods -> calculationScheduleDeliveryPeriods.getEndDate()).get(), deliveryProfile.<BankHolidayTreatmentEnum>map("getBankHolidaysTreatment", assetDeliveryProfile -> assetDeliveryProfile.getBankHolidaysTreatment()).get(), duration(transaction).get(), deliveryBlock.<DayOfWeekEnum>mapC("getDayOfWeek", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDayOfWeek()).getMulti(), ifThenElseResult0, ifThenElseResult1, ifThenElseResult2));
								}));
						return _thenArg
							.flattenList();
					});
				reportableDelivery.addAll(toBuilder(thenArg
					.flattenList().getMulti()));
			} else {
				reportableDelivery.addAll(toBuilder(delivery(transaction).<AssetDeliveryPeriods>map("getPeriods", assetDeliveryInformation -> assetDeliveryInformation.getPeriods())
					.mapSingleToList(periods -> {
						final MapperListOfLists<ReportableDelivery> _thenArg = periods.<AssetDeliveryProfile>mapC("getProfile", assetDeliveryPeriods -> assetDeliveryPeriods.getProfile())
							.mapItemToList(deliveryProfile -> deliveryProfile.<AssetDeliveryProfileBlock>mapC("getBlock", assetDeliveryProfile -> assetDeliveryProfile.getBlock())
								.mapItem(deliveryBlock -> {
									final Quantity ifThenElseResult;
									if (exists(delivery(transaction).<Quantity>map("getDeliveryCapacity", assetDeliveryInformation -> assetDeliveryInformation.getDeliveryCapacity())).getOrDefault(false)) {
										ifThenElseResult = delivery(transaction).<Quantity>map("getDeliveryCapacity", assetDeliveryInformation -> assetDeliveryInformation.getDeliveryCapacity()).get();
									} else if (exists(deliveryBlock.<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity())).getOrDefault(false)) {
										ifThenElseResult = deliveryBlock.<Quantity>map("getDeliveryCapacity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDeliveryCapacity()).get();
									} else {
										ifThenElseResult = null;
									}
									final FieldWithMetaString fieldWithMetaString = deliveryBlock.<Price>map("getPriceTimeIntervalQuantity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getPriceTimeIntervalQuantity()).<UnitType>map("getUnit", price -> price.getUnit()).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
									return MapperS.of(create_DeliveryBlock.evaluate(deliveryBlock.<LocalTime>map("getStartTime", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getStartTime()).get(), deliveryBlock.<LocalTime>map("getEndTime", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getEndTime()).get(), periods.<Date>map("getStartDate", assetDeliveryPeriods -> assetDeliveryPeriods.getStartDate()).get(), periods.<Date>map("getEndDate", assetDeliveryPeriods -> assetDeliveryPeriods.getEndDate()).get(), deliveryProfile.<BankHolidayTreatmentEnum>map("getBankHolidaysTreatment", assetDeliveryProfile -> assetDeliveryProfile.getBankHolidaysTreatment()).get(), duration(transaction).get(), deliveryBlock.<DayOfWeekEnum>mapC("getDayOfWeek", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getDayOfWeek()).getMulti(), ifThenElseResult, deliveryBlock.<Price>map("getPriceTimeIntervalQuantity", assetDeliveryProfileBlock -> assetDeliveryProfileBlock.getPriceTimeIntervalQuantity()).<BigDecimal>map("getValue", price -> price.getValue()).get(), (fieldWithMetaString == null ? null : fieldWithMetaString.getValue())));
								}));
						return _thenArg
							.flattenList();
					}).getMulti()));
			}
			
			return Optional.ofNullable(reportableDelivery)
				.map(o -> o.stream().map(i -> i.prune()).collect(Collectors.toList()))
				.orElse(null);
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(TransactionReportInstruction transaction) {
			return MapperS.of(productForEvent.evaluate(transaction));
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(TransactionReportInstruction transaction) {
			return MapperS.of(economicTermsForProduct.evaluate(product(transaction).get()));
		}
		
		@Override
		protected MapperS<? extends AssetDeliveryInformation> delivery(TransactionReportInstruction transaction) {
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTerms(transaction).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTerms(transaction).get())))).getOrDefault(false)) {
				return economicTerms(transaction).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<AssetDeliveryInformation>map("getDelivery", commodityPayout -> commodityPayout.getDelivery())
					.first();
			}
			final Boolean boolean0 = qualify_Commodity_Option.evaluate(economicTerms(transaction).get());
			if ((boolean0 == null ? false : boolean0)) {
				return MapperS.of(economicTerms(transaction).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<AssetDeliveryInformation>map("getDelivery", optionPayout -> optionPayout.getDelivery()).get());
			}
			final Boolean boolean1 = qualify_Commodity_Swaption.evaluate(economicTerms(transaction).get());
			if ((boolean1 == null ? false : boolean1)) {
				return MapperS.of(economicTermsForProduct.evaluate(economicTerms(transaction).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<Underlier>map("getUnderlier", optionPayout -> optionPayout.getUnderlier()).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<AssetDeliveryInformation>map("getDelivery", commodityPayout -> commodityPayout.getDelivery())
					.first();
			}
			final Boolean boolean2 = isSingleCommodityPayoutProduct.evaluate(product(transaction).get());
			if ((boolean2 == null ? false : boolean2)) {
				return MapperS.of(economicTerms(transaction).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).get()).<AssetDeliveryInformation>map("getDelivery", commodityPayout -> commodityPayout.getDelivery());
			}
			final Boolean boolean3 = qualify_Commodity_Forward.evaluate(economicTerms(transaction).get());
			if ((boolean3 == null ? false : boolean3)) {
				return MapperS.of(economicTerms(transaction).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<AssetDeliveryInformation>map("getDelivery", settlementPayout -> settlementPayout.getDelivery());
			}
			return MapperS.<AssetDeliveryInformation>ofNull();
		}
		
		@Override
		protected MapperS<? extends CalculationSchedule> customizedSchedule(TransactionReportInstruction transaction) {
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_FixedFloat.evaluate(economicTerms(transaction).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swap_Basis.evaluate(economicTerms(transaction).get())))).getOrDefault(false)) {
				return economicTerms(transaction).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).<CalculationSchedule>map("getSchedule", commodityPayout -> commodityPayout.getSchedule())
					.first();
			}
			if (ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Option.evaluate(economicTerms(transaction).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_Commodity_Swaption.evaluate(economicTerms(transaction).get())))).getOrDefault(false)) {
				return MapperS.of(economicTerms(transaction).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).get()).<CalculationSchedule>map("getSchedule", optionPayout -> optionPayout.getSchedule());
			}
			final Boolean boolean0 = isSingleCommodityPayoutProduct.evaluate(product(transaction).get());
			if ((boolean0 == null ? false : boolean0)) {
				return MapperS.of(economicTerms(transaction).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CommodityPayout>map("getCommodityPayout", payout -> payout.getCommodityPayout()).get()).<CalculationSchedule>map("getSchedule", commodityPayout -> commodityPayout.getSchedule());
			}
			final Boolean boolean1 = qualify_Commodity_Forward.evaluate(economicTerms(transaction).get());
			if ((boolean1 == null ? false : boolean1)) {
				return MapperS.of(economicTerms(transaction).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).get()).<CalculationSchedule>map("getSchedule", settlementPayout -> settlementPayout.getSchedule());
			}
			return MapperS.<CalculationSchedule>ofNull();
		}
		
		@Override
		protected MapperS<CommodityTimeUnitEnum> duration(TransactionReportInstruction transaction) {
			return MapperS.of(getTransactionInformationForRegime.evaluate(transaction, RegimeNameEnum.EMIR, SupervisoryBodyEnum.ESMA)).<TransactionInformation>map("getTransactionInformation", reportableJurisdictionInformation -> reportableJurisdictionInformation.getTransactionInformation()).<CommodityTimeUnitEnum>map("getDuration", transactionInformation -> transactionInformation.getDuration());
		}
	}
}
