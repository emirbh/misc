package drr.regulation.common.trade.index.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.DebtEconomics;
import cdm.base.staticdata.asset.common.DebtSeniorityEnum;
import cdm.base.staticdata.asset.common.DebtType;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.Security;
import cdm.observable.asset.CreditIndex;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.CreditSeniorityEnum;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ReferenceInformation;
import cdm.product.asset.ReferenceObligation;
import cdm.product.asset.ReferencePair;
import cdm.product.asset.ReferencePool;
import cdm.product.asset.ReferencePoolItem;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.PerformancePayout;
import cdm.product.template.Product;
import cdm.product.template.Underlier;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.qualification.product.functions.IsCredit;
import drr.base.qualification.product.functions.IsCreditDefaultSwapBasket;
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.qualification.product.functions.IsTotalReturnSwapDebtUnderlier;
import drr.base.trade.ReportableEventBase;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.functions.ProductForEvent;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.standards.iso.SeniorityEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetSeniority.GetSeniorityDefault.class)
public abstract class GetSeniority implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCredit isCredit;
	@Inject protected IsCreditDefaultSwapBasket isCreditDefaultSwapBasket;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected IsTotalReturnSwapDebtUnderlier isTotalReturnSwapDebtUnderlier;
	@Inject protected ProductForEvent productForEvent;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param reportableEvent 
	* @return result 
	*/
	public SeniorityEnum evaluate(ReportableEventBase reportableEvent) {
		SeniorityEnum result = doEvaluate(reportableEvent);
		
		return result;
	}

	protected abstract SeniorityEnum doEvaluate(ReportableEventBase reportableEvent);

	protected abstract MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent);

	protected abstract MapperC<? extends CreditIndex> indexReferenceInformation(ReportableEventBase reportableEvent);

	protected abstract MapperC<? extends ReferenceInformation> referenceInformation(ReportableEventBase reportableEvent);

	protected abstract MapperC<? extends BasketReferenceInformation> basketReferenceInformation(ReportableEventBase reportableEvent);

	protected abstract MapperS<CreditSeniorityEnum> creditSeniority(ReportableEventBase reportableEvent);

	protected abstract MapperC<DebtSeniorityEnum> debtSeniority(ReportableEventBase reportableEvent);

	protected abstract MapperC<DebtSeniorityEnum> basketSeniority(ReportableEventBase reportableEvent);

	public static class GetSeniorityDefault extends GetSeniority {
		@Override
		protected SeniorityEnum doEvaluate(ReportableEventBase reportableEvent) {
			SeniorityEnum result = null;
			return assignOutput(result, reportableEvent);
		}
		
		protected SeniorityEnum assignOutput(SeniorityEnum result, ReportableEventBase reportableEvent) {
			if (areEqual(creditSeniority(reportableEvent), MapperS.of(CreditSeniorityEnum.SENIOR_UN_SEC), CardinalityOperator.All).orNullSafe(areEqual(creditSeniority(reportableEvent), MapperS.of(CreditSeniorityEnum.SENIOR_SEC), CardinalityOperator.All)).orNullSafe(areEqual(creditSeniority(reportableEvent), MapperS.of(CreditSeniorityEnum.SENIOR_LOSS_ABSORBING_CAPACITY), CardinalityOperator.All)).orNullSafe(areEqual(debtSeniority(reportableEvent), MapperS.of(DebtSeniorityEnum.SENIOR), CardinalityOperator.Any)).orNullSafe(areEqual(basketSeniority(reportableEvent), MapperS.of(DebtSeniorityEnum.SENIOR), CardinalityOperator.All)).getOrDefault(false)) {
				result = SeniorityEnum.SNDB;
			} else if (areEqual(creditSeniority(reportableEvent), MapperS.of(CreditSeniorityEnum.SUB_TIER_3), CardinalityOperator.All).orNullSafe(areEqual(creditSeniority(reportableEvent), MapperS.of(CreditSeniorityEnum.SUB_UPPER_TIER_2), CardinalityOperator.All)).orNullSafe(areEqual(creditSeniority(reportableEvent), MapperS.of(CreditSeniorityEnum.SUB_LOWER_TIER_2), CardinalityOperator.All)).orNullSafe(areEqual(creditSeniority(reportableEvent), MapperS.of(CreditSeniorityEnum.SUB_TIER_1), CardinalityOperator.All)).orNullSafe(areEqual(debtSeniority(reportableEvent), MapperS.of(DebtSeniorityEnum.SUBORDINATED), CardinalityOperator.Any)).orNullSafe(areEqual(basketSeniority(reportableEvent), MapperS.of(DebtSeniorityEnum.SUBORDINATED), CardinalityOperator.All)).getOrDefault(false)) {
				result = SeniorityEnum.SBOD;
			} else if (areEqual(creditSeniority(reportableEvent), MapperS.of(CreditSeniorityEnum.OTHER), CardinalityOperator.All).orNullSafe(areEqual(debtSeniority(reportableEvent), MapperS.of(DebtSeniorityEnum.SECURED), CardinalityOperator.Any)).orNullSafe(exists(basketSeniority(reportableEvent))).getOrDefault(false)) {
				result = SeniorityEnum.OTHR;
			} else {
				result = null;
			}
			
			return result;
		}
		
		@Override
		protected MapperS<? extends NonTransferableProduct> product(ReportableEventBase reportableEvent) {
			return MapperS.of(productForEvent.evaluate(reportableEvent));
		}
		
		@Override
		protected MapperC<? extends CreditIndex> indexReferenceInformation(ReportableEventBase reportableEvent) {
			final Boolean boolean0 = isCreditSwaption.evaluate(product(reportableEvent).get());
			if ((boolean0 == null ? false : boolean0)) {
				return MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation());
			}
			final Boolean boolean1 = isCredit.evaluate(product(reportableEvent).get());
			if ((boolean1 == null ? false : boolean1)) {
				return MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<CreditIndex>map("getIndexReferenceInformation", generalTerms -> generalTerms.getIndexReferenceInformation());
			}
			return MapperC.<CreditIndex>ofNull();
		}
		
		@Override
		protected MapperC<? extends ReferenceInformation> referenceInformation(ReportableEventBase reportableEvent) {
			final Boolean boolean0 = isCreditSwaption.evaluate(product(reportableEvent).get());
			if ((boolean0 == null ? false : boolean0)) {
				return MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation());
			}
			final Boolean boolean1 = isCredit.evaluate(product(reportableEvent).get());
			if ((boolean1 == null ? false : boolean1)) {
				return MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation());
			}
			return MapperC.<ReferenceInformation>ofNull();
		}
		
		@Override
		protected MapperC<? extends BasketReferenceInformation> basketReferenceInformation(ReportableEventBase reportableEvent) {
			final Boolean boolean0 = isCreditSwaption.evaluate(product(reportableEvent).get());
			if ((boolean0 == null ? false : boolean0)) {
				return MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product(reportableEvent).get())).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation());
			}
			final Boolean boolean1 = isCreditDefaultSwapBasket.evaluate(product(reportableEvent).get());
			if ((boolean1 == null ? false : boolean1)) {
				return MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation());
			}
			return MapperC.<BasketReferenceInformation>ofNull();
		}
		
		@Override
		protected MapperS<CreditSeniorityEnum> creditSeniority(ReportableEventBase reportableEvent) {
			return MapperS.of(indexReferenceInformation(reportableEvent).<CreditSeniorityEnum>map("getSeniority", creditIndex -> creditIndex.getSeniority()).get());
		}
		
		@Override
		protected MapperC<DebtSeniorityEnum> debtSeniority(ReportableEventBase reportableEvent) {
			if (exists(referenceInformation(reportableEvent)).getOrDefault(false)) {
				return referenceInformation(reportableEvent).<ReferenceObligation>mapC("getReferenceObligation", _referenceInformation -> _referenceInformation.getReferenceObligation()).<Security>map("getSecurity", referenceObligation -> referenceObligation.getSecurity()).<DebtType>map("getDebtType", security -> security.getDebtType()).<DebtEconomics>mapC("getDebtEconomics", debtType -> debtType.getDebtEconomics()).<DebtSeniorityEnum>map("getDebtSeniority", debtEconomics -> debtEconomics.getDebtSeniority());
			}
			final Boolean _boolean = isTotalReturnSwapDebtUnderlier.evaluate(product(reportableEvent).get());
			if ((_boolean == null ? false : _boolean)) {
				return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(product(reportableEvent).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()).<DebtType>map("getDebtType", security -> security.getDebtType()).<DebtEconomics>mapC("getDebtEconomics", debtType -> debtType.getDebtEconomics()).<DebtSeniorityEnum>map("getDebtSeniority", debtEconomics -> debtEconomics.getDebtSeniority());
			}
			return MapperC.<DebtSeniorityEnum>ofNull();
		}
		
		@Override
		protected MapperC<DebtSeniorityEnum> basketSeniority(ReportableEventBase reportableEvent) {
			if (exists(basketReferenceInformation(reportableEvent)).getOrDefault(false)) {
				return basketReferenceInformation(reportableEvent).<ReferencePool>map("getReferencePool", _basketReferenceInformation -> _basketReferenceInformation.getReferencePool()).<ReferencePoolItem>mapC("getReferencePoolItem", referencePool -> referencePool.getReferencePoolItem()).<ReferencePair>map("getReferencePair", referencePoolItem -> referencePoolItem.getReferencePair()).<ReferenceObligation>map("getReferenceObligation", referencePair -> referencePair.getReferenceObligation()).<Security>map("getSecurity", referenceObligation -> referenceObligation.getSecurity()).<DebtType>map("getDebtType", security -> security.getDebtType()).<DebtEconomics>mapC("getDebtEconomics", debtType -> debtType.getDebtEconomics()).<DebtSeniorityEnum>map("getDebtSeniority", debtEconomics -> debtEconomics.getDebtSeniority());
			}
			return MapperC.<DebtSeniorityEnum>ofNull();
		}
	}
}
