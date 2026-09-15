package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.common.Asset;
import cdm.base.staticdata.asset.common.DebtEconomics;
import cdm.base.staticdata.asset.common.DebtSeniorityEnum;
import cdm.base.staticdata.asset.common.DebtType;
import cdm.base.staticdata.asset.common.Instrument;
import cdm.base.staticdata.asset.common.Security;
import cdm.observable.asset.Observable;
import cdm.observable.asset.metafields.ReferenceWithMetaObservable;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ReferenceInformation;
import cdm.product.asset.ReferenceObligation;
import cdm.product.template.EconomicTerms;
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
import drr.base.qualification.product.functions.IsCreditSwaption;
import drr.base.qualification.product.functions.IsTotalReturnSwapDebtUnderlier;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import drr.standards.iosco.upi.AnnaDsbDebtSeniorityEnum;
import drr.standards.iosco.upi.AnnaDsbUseCaseEnum;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(DebtSeniority.DebtSeniorityDefault.class)
public abstract class DebtSeniority implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected IsCredit isCredit;
	@Inject protected IsCreditSwaption isCreditSwaption;
	@Inject protected IsTotalReturnSwapDebtUnderlier isTotalReturnSwapDebtUnderlier;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param product 
	* @param useCase 
	* @return result 
	*/
	public AnnaDsbDebtSeniorityEnum evaluate(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase) {
		AnnaDsbDebtSeniorityEnum result = doEvaluate(product, useCase);
		
		return result;
	}

	protected abstract AnnaDsbDebtSeniorityEnum doEvaluate(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase);

	protected abstract MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase);

	protected abstract MapperC<? extends ReferenceInformation> referenceInformation(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase);

	protected abstract MapperC<DebtSeniorityEnum> debtSeniority(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase);

	public static class DebtSeniorityDefault extends DebtSeniority {
		@Override
		protected AnnaDsbDebtSeniorityEnum doEvaluate(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase) {
			AnnaDsbDebtSeniorityEnum result = null;
			return assignOutput(result, product, useCase);
		}
		
		protected AnnaDsbDebtSeniorityEnum assignOutput(AnnaDsbDebtSeniorityEnum result, NonTransferableProduct product, AnnaDsbUseCaseEnum useCase) {
			if (areEqual(debtSeniority(product, useCase), MapperS.of(DebtSeniorityEnum.SENIOR), CardinalityOperator.Any).getOrDefault(false)) {
				result = AnnaDsbDebtSeniorityEnum.SNDB;
			} else if (areEqual(debtSeniority(product, useCase), MapperS.of(DebtSeniorityEnum.SUBORDINATED), CardinalityOperator.Any).getOrDefault(false)) {
				result = AnnaDsbDebtSeniorityEnum.SBOD;
			} else if (areEqual(debtSeniority(product, useCase), MapperS.of(DebtSeniorityEnum.SECURED), CardinalityOperator.Any).getOrDefault(false)) {
				result = AnnaDsbDebtSeniorityEnum.MZZD;
			} else if (areEqual(MapperS.of(useCase), MapperS.of(AnnaDsbUseCaseEnum.NON_STANDARD), CardinalityOperator.All).orNullSafe(areEqual(MapperS.of(useCase), MapperS.of(AnnaDsbUseCaseEnum.TOTAL_RETURN_SWAP), CardinalityOperator.All)).getOrDefault(false)) {
				result = AnnaDsbDebtSeniorityEnum.SNDB;
			} else {
				result = AnnaDsbDebtSeniorityEnum.SNDB;
			}
			
			return result;
		}
		
		@Override
		protected MapperS<? extends EconomicTerms> economicTerms(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase) {
			return MapperS.of(product).<EconomicTerms>map("getEconomicTerms", nonTransferableProduct -> nonTransferableProduct.getEconomicTerms());
		}
		
		@Override
		protected MapperC<? extends ReferenceInformation> referenceInformation(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase) {
			final Boolean boolean0 = isCredit.evaluate(product);
			if ((boolean0 == null ? false : boolean0)) {
				return MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation());
			}
			final Boolean boolean1 = isCreditSwaption.evaluate(product);
			if ((boolean1 == null ? false : boolean1)) {
				return MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation());
			}
			return MapperC.<ReferenceInformation>ofNull();
		}
		
		@Override
		protected MapperC<DebtSeniorityEnum> debtSeniority(NonTransferableProduct product, AnnaDsbUseCaseEnum useCase) {
			if (exists(referenceInformation(product, useCase)).getOrDefault(false)) {
				return referenceInformation(product, useCase).<ReferenceObligation>mapC("getReferenceObligation", _referenceInformation -> _referenceInformation.getReferenceObligation()).<Security>map("getSecurity", referenceObligation -> referenceObligation.getSecurity()).<DebtType>map("getDebtType", security -> security.getDebtType()).<DebtEconomics>mapC("getDebtEconomics", debtType -> debtType.getDebtEconomics()).<DebtSeniorityEnum>map("getDebtSeniority", debtEconomics -> debtEconomics.getDebtSeniority());
			}
			final Boolean _boolean = isTotalReturnSwapDebtUnderlier.evaluate(product);
			if ((_boolean == null ? false : _boolean)) {
				return MapperS.of(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<PerformancePayout>map("getPerformancePayout", payout -> payout.getPerformancePayout()).get()).<Underlier>map("getUnderlier", performancePayout -> performancePayout.getUnderlier()).<ReferenceWithMetaObservable>map("getObservable", underlier -> underlier.getObservable()).<Observable>map("Type coercion", referenceWithMetaObservable -> referenceWithMetaObservable == null ? null : referenceWithMetaObservable.getValue()).<Asset>map("getAsset", observable -> observable.getAsset()).<Instrument>map("getInstrument", asset -> asset.getInstrument()).<Security>map("getSecurity", instrument -> instrument.getSecurity()).<DebtType>map("getDebtType", security -> security.getDebtType()).<DebtEconomics>mapC("getDebtEconomics", debtType -> debtType.getDebtEconomics()).<DebtSeniorityEnum>map("getDebtSeniority", debtEconomics -> debtEconomics.getDebtSeniority());
			}
			return MapperC.<DebtSeniorityEnum>ofNull();
		}
	}
}
