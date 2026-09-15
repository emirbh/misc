package drr.enrichment.upi.functions;

import cdm.base.staticdata.party.LegalEntity;
import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ReferenceInformation;
import cdm.product.asset.ReferencePair;
import cdm.product.asset.ReferencePool;
import cdm.product.asset.ReferencePoolItem;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import javax.inject.Inject;


@ImplementedBy(GetCreditUnderlierLEI.GetCreditUnderlierLEIDefault.class)
public abstract class GetCreditUnderlierLEI implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected FilterEntityIdByScheme filterEntityIdByScheme;

	/**
	* @param economicTerms 
	* @return result 
	*/
	public String evaluate(EconomicTerms economicTerms) {
		String result = doEvaluate(economicTerms);
		
		return result;
	}

	protected abstract String doEvaluate(EconomicTerms economicTerms);

	public static class GetCreditUnderlierLEIDefault extends GetCreditUnderlierLEI {
		@Override
		protected String doEvaluate(EconomicTerms economicTerms) {
			String result = null;
			return assignOutput(result, economicTerms);
		}
		
		protected String assignOutput(String result, EconomicTerms economicTerms) {
			final MapperC<LegalEntity> thenArg0 = MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<LegalEntity>map("getReferenceEntity", referenceInformation -> referenceInformation.getReferenceEntity());
			final MapperS<LegalEntity> thenArg1 = MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<ReferencePool>map("getReferencePool", basketReferenceInformation -> basketReferenceInformation.getReferencePool()).<ReferencePoolItem>mapC("getReferencePoolItem", referencePool -> referencePool.getReferencePoolItem())
				.first().<ReferencePair>map("getReferencePair", referencePoolItem -> referencePoolItem.getReferencePair()).<LegalEntity>map("getReferenceEntity", referencePair -> referencePair.getReferenceEntity());
			result = MapperC.<String>of(thenArg0
				.mapItem(item -> MapperS.of(filterEntityIdByScheme.evaluate(item.get(), "http://www.fpml.org/coding-scheme/external/iso17442"))), thenArg1
				.mapSingleToItem(item -> MapperS.of(filterEntityIdByScheme.evaluate(item.get(), "http://www.fpml.org/coding-scheme/external/iso17442")))).get();
			
			return result;
		}
	}
}
