package drr.regulation.common.functions;

import cdm.base.staticdata.asset.common.ProductTaxonomy;
import cdm.base.staticdata.asset.common.TaxonomySourceEnum;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.InterestRatePayout;
import cdm.product.common.settlement.CashSettlementTerms;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.common.settlement.SettlementTypeEnum;
import cdm.product.qualification.functions.Qualify_AssetClass_Credit;
import cdm.product.qualification.functions.Qualify_BaseProduct_CrossCurrency;
import cdm.product.qualification.functions.Qualify_BaseProduct_IRSwap;
import cdm.product.qualification.functions.Qualify_BaseProduct_Inflation;
import cdm.product.qualification.functions.Qualify_ForeignExchange_NDS;
import cdm.product.qualification.functions.Qualify_ForeignExchange_Swap;
import cdm.product.template.EconomicTerms;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.OptionPayout;
import cdm.product.template.Payout;
import cdm.product.template.SettlementPayout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.ProductForEvent;
import drr.standards.iosco.upi.AnnaDsbDeliveryTypeEnum;
import drr.standards.iosco.upi.AnnaDsbInstrumentTypeEnum;
import drr.standards.iosco.upi.AnnaDsbUseCaseEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetDeliveryTypeDSBRecord.GetDeliveryTypeDSBRecordDefault.class)
public abstract class GetDeliveryTypeDSBRecord implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected GetDSBRecord getDSBRecord;
	@Inject protected GetInstrumentType getInstrumentType;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected Qualify_AssetClass_Credit qualify_AssetClass_Credit;
	@Inject protected Qualify_BaseProduct_CrossCurrency qualify_BaseProduct_CrossCurrency;
	@Inject protected Qualify_BaseProduct_IRSwap qualify_BaseProduct_IRSwap;
	@Inject protected Qualify_BaseProduct_Inflation qualify_BaseProduct_Inflation;
	@Inject protected Qualify_ForeignExchange_NDS qualify_ForeignExchange_NDS;
	@Inject protected Qualify_ForeignExchange_Swap qualify_ForeignExchange_Swap;

	/**
	* @param reportableEvent 
	* @return deliveryType 
	*/
	public AnnaDsbDeliveryTypeEnum evaluate(ReportableEventBase reportableEvent) {
		AnnaDsbDeliveryTypeEnum deliveryType = doEvaluate(reportableEvent);
		
		return deliveryType;
	}

	protected abstract AnnaDsbDeliveryTypeEnum doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent);

	protected abstract MapperS<AnnaDsbInstrumentTypeEnum> instrumentType(ReportableEventBase reportableEvent);

	protected abstract MapperS<AnnaDsbUseCaseEnum> useCase(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends FieldWithMetaString> isdaTaxonomy(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends SettlementTerms> settlementTerms(ReportableEventBase reportableEvent);

	public static class GetDeliveryTypeDSBRecordDefault extends GetDeliveryTypeDSBRecord {
		@Override
		protected AnnaDsbDeliveryTypeEnum doEvaluate(ReportableEventBase reportableEvent) {
			AnnaDsbDeliveryTypeEnum deliveryType = null;
			return assignOutput(deliveryType, reportableEvent);
		}
		
		protected AnnaDsbDeliveryTypeEnum assignOutput(AnnaDsbDeliveryTypeEnum deliveryType, ReportableEventBase reportableEvent) {
			if (areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NDF), CardinalityOperator.All).orNullSafe(areEqual(useCase(reportableEvent), MapperS.of(AnnaDsbUseCaseEnum.NDO), CardinalityOperator.All)).getOrDefault(false)) {
				deliveryType = null;
			} else {
				final Boolean boolean0 = qualify_ForeignExchange_NDS.evaluate(economicTerms(reportableEvent).get());
				if ((boolean0 == null ? false : boolean0)) {
					deliveryType = AnnaDsbDeliveryTypeEnum.CASH;
				} else {
					final Boolean boolean1 = qualify_ForeignExchange_Swap.evaluate(economicTerms(reportableEvent).get());
					if ((boolean1 == null ? false : boolean1)) {
						deliveryType = AnnaDsbDeliveryTypeEnum.PHYS;
					} else if (areEqual(settlementTerms(reportableEvent).<SettlementTypeEnum>map("getSettlementType", _settlementTerms -> _settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH), CardinalityOperator.All).getOrDefault(false)) {
						deliveryType = AnnaDsbDeliveryTypeEnum.CASH;
					} else if (areEqual(settlementTerms(reportableEvent).<SettlementTypeEnum>map("getSettlementType", _settlementTerms -> _settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.CASH_OR_PHYSICAL), CardinalityOperator.All).getOrDefault(false)) {
						deliveryType = AnnaDsbDeliveryTypeEnum.OPTL;
					} else if (areEqual(settlementTerms(reportableEvent).<SettlementTypeEnum>map("getSettlementType", _settlementTerms -> _settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.PHYSICAL), CardinalityOperator.All).getOrDefault(false)) {
						deliveryType = AnnaDsbDeliveryTypeEnum.PHYS;
					} else if (areEqual(settlementTerms(reportableEvent).<SettlementTypeEnum>map("getSettlementType", _settlementTerms -> _settlementTerms.getSettlementType()), MapperS.of(SettlementTypeEnum.ELECTION), CardinalityOperator.All).getOrDefault(false)) {
						deliveryType = AnnaDsbDeliveryTypeEnum.OPTL;
					} else if (notExists(settlementTerms(reportableEvent).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms())).andNullSafe(exists(settlementTerms(reportableEvent).<CashSettlementTerms>mapC("getCashSettlementTerms", _settlementTerms -> _settlementTerms.getCashSettlementTerms()))).getOrDefault(false)) {
						deliveryType = AnnaDsbDeliveryTypeEnum.CASH;
					} else if (exists(settlementTerms(reportableEvent).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms())).andNullSafe(exists(settlementTerms(reportableEvent).<CashSettlementTerms>mapC("getCashSettlementTerms", _settlementTerms -> _settlementTerms.getCashSettlementTerms()))).getOrDefault(false)) {
						deliveryType = AnnaDsbDeliveryTypeEnum.OPTL;
					} else if (exists(settlementTerms(reportableEvent).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms())).andNullSafe(notExists(settlementTerms(reportableEvent).<CashSettlementTerms>mapC("getCashSettlementTerms", _settlementTerms -> _settlementTerms.getCashSettlementTerms()))).getOrDefault(false)) {
						deliveryType = AnnaDsbDeliveryTypeEnum.PHYS;
					} else if (areEqual(instrumentType(reportableEvent), MapperS.of(AnnaDsbInstrumentTypeEnum.OPTION), CardinalityOperator.All).orNullSafe(areEqual(instrumentType(reportableEvent), MapperS.of(AnnaDsbInstrumentTypeEnum.FORWARD), CardinalityOperator.All)).getOrDefault(false)) {
						deliveryType = AnnaDsbDeliveryTypeEnum.PHYS;
					} else if (ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_IRSwap.evaluate(economicTerms(reportableEvent).get()))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_CrossCurrency.evaluate(economicTerms(reportableEvent).get())))).orNullSafe(ComparisonResult.ofNullSafe(MapperS.of(qualify_BaseProduct_Inflation.evaluate(economicTerms(reportableEvent).get())))).getOrDefault(false)) {
						deliveryType = AnnaDsbDeliveryTypeEnum.PHYS;
					} else {
						final Boolean boolean2 = qualify_AssetClass_Credit.evaluate(economicTerms(reportableEvent).get());
						if ((boolean2 == null ? false : boolean2)) {
							deliveryType = AnnaDsbDeliveryTypeEnum.OPTL;
						} else {
							deliveryType = AnnaDsbDeliveryTypeEnum.CASH;
						}
					}
				}
			}
			
			return deliveryType;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			return MapperS.of(productForEvent.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(ReportableEventBase reportableEvent) {
			return product(reportableEvent).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
		
		@Override
		protected MapperS<AnnaDsbInstrumentTypeEnum> instrumentType(ReportableEventBase reportableEvent) {
			return MapperS.of(getInstrumentType.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperS<AnnaDsbUseCaseEnum> useCase(ReportableEventBase reportableEvent) {
			return MapperS.of(getDSBRecord.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperS<? extends FieldWithMetaString> isdaTaxonomy(ReportableEventBase reportableEvent) {
			final MapperC<ProductTaxonomy> thenArg0 = product(reportableEvent).<ProductTaxonomy>mapC("getTaxonomy", nonTransferableProduct -> nonTransferableProduct.getTaxonomy())
				.filterItemNullSafe(item -> areEqual(item.<TaxonomySourceEnum>map("getSource", productTaxonomy -> productTaxonomy.getSource()), MapperS.of(TaxonomySourceEnum.ISDA), CardinalityOperator.All).andNullSafe(exists(item.<TaxonomyValue>map("getValue", productTaxonomy -> productTaxonomy.getValue()).<FieldWithMetaString>map("getName", taxonomyValue -> taxonomyValue.getName()))).get());
			final MapperS<ProductTaxonomy> thenArg1 = thenArg0
				.first();
			return thenArg1.<TaxonomyValue>map("getValue", productTaxonomy -> productTaxonomy.getValue()).<FieldWithMetaString>map("getName", taxonomyValue -> taxonomyValue.getName());
		}
		
		@Override
		protected MapperS<? extends SettlementTerms> settlementTerms(ReportableEventBase reportableEvent) {
			return MapperC.<SettlementTerms>of(economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<SettlementPayout>map("getSettlementPayout", payout -> payout.getSettlementPayout()).<SettlementTerms>map("getSettlementTerms", settlementPayout -> settlementPayout.getSettlementTerms()), economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<OptionPayout>map("getOptionPayout", payout -> payout.getOptionPayout()).<SettlementTerms>map("getSettlementTerms", optionPayout -> optionPayout.getSettlementTerms()), economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<InterestRatePayout>map("getInterestRatePayout", payout -> payout.getInterestRatePayout()).<SettlementTerms>map("getSettlementTerms", interestRatePayout -> interestRatePayout.getSettlementTerms()), economicTerms(reportableEvent).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", creditDefaultPayout -> creditDefaultPayout.getSettlementTerms()))
				.first();
		}
	}
}
