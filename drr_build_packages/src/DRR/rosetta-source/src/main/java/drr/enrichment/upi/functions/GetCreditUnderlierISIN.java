package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.common.AssetIdTypeEnum;
import cdm.base.staticdata.asset.common.AssetIdentifier;
import cdm.base.staticdata.asset.common.Loan;
import cdm.base.staticdata.asset.common.Security;
import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ReferenceInformation;
import cdm.product.asset.ReferenceObligation;
import cdm.product.asset.ReferencePair;
import cdm.product.asset.ReferencePool;
import cdm.product.asset.ReferencePoolItem;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetCreditUnderlierISIN.GetCreditUnderlierISINDefault.class)
public abstract class GetCreditUnderlierISIN implements RosettaFunction {

	/**
	* @param economicTerms 
	* @return result 
	*/
	public String evaluate(EconomicTerms economicTerms) {
		String result = doEvaluate(economicTerms);
		
		return result;
	}

	protected abstract String doEvaluate(EconomicTerms economicTerms);

	public static class GetCreditUnderlierISINDefault extends GetCreditUnderlierISIN {
		@Override
		protected String doEvaluate(EconomicTerms economicTerms) {
			String result = null;
			return assignOutput(result, economicTerms);
		}
		
		protected String assignOutput(String result, EconomicTerms economicTerms) {
			final MapperC<AssetIdentifier> thenArg0 = MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<ReferenceObligation>mapC("getReferenceObligation", referenceInformation -> referenceInformation.getReferenceObligation()).<Security>map("getSecurity", referenceObligation -> referenceObligation.getSecurity()).<AssetIdentifier>mapC("getIdentifier", security -> security.getIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.All).get());
			final MapperC<AssetIdentifier> thenArg1 = MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<ReferenceObligation>mapC("getReferenceObligation", referenceInformation -> referenceInformation.getReferenceObligation()).<Loan>map("getLoan", referenceObligation -> referenceObligation.getLoan()).<AssetIdentifier>mapC("getIdentifier", loan -> loan.getIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.All).get());
			final MapperC<AssetIdentifier> thenArg2 = MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<ReferencePool>map("getReferencePool", basketReferenceInformation -> basketReferenceInformation.getReferencePool()).<ReferencePoolItem>mapC("getReferencePoolItem", referencePool -> referencePool.getReferencePoolItem())
				.first().<ReferencePair>map("getReferencePair", referencePoolItem -> referencePoolItem.getReferencePair()).<ReferenceObligation>map("getReferenceObligation", referencePair -> referencePair.getReferenceObligation()).<Security>map("getSecurity", referenceObligation -> referenceObligation.getSecurity()).<AssetIdentifier>mapC("getIdentifier", security -> security.getIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.All).get());
			final MapperC<AssetIdentifier> thenArg3 = MapperS.of(economicTerms).<Payout>mapC("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<ReferencePool>map("getReferencePool", basketReferenceInformation -> basketReferenceInformation.getReferencePool()).<ReferencePoolItem>mapC("getReferencePoolItem", referencePool -> referencePool.getReferencePoolItem())
				.first().<ReferencePair>map("getReferencePair", referencePoolItem -> referencePoolItem.getReferencePair()).<ReferenceObligation>map("getReferenceObligation", referencePair -> referencePair.getReferenceObligation()).<Loan>map("getLoan", referenceObligation -> referenceObligation.getLoan()).<AssetIdentifier>mapC("getIdentifier", loan -> loan.getIdentifier())
				.filterItemNullSafe(item -> areEqual(item.<AssetIdTypeEnum>map("getIdentifierType", assetIdentifier -> assetIdentifier.getIdentifierType()), MapperS.of(AssetIdTypeEnum.ISIN), CardinalityOperator.All).get());
			final FieldWithMetaString fieldWithMetaString = MapperC.<FieldWithMetaString>of(thenArg0
				.first()
				.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())), thenArg1
				.first()
				.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())), thenArg2
				.first()
				.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier())), thenArg3
				.first()
				.mapSingleToItem(item -> item.<FieldWithMetaString>map("getIdentifier", assetIdentifier -> assetIdentifier.getIdentifier()))).get();
			if (fieldWithMetaString == null) {
				result = null;
			} else {
				result = fieldWithMetaString.getValue();
			}
			
			return result;
		}
	}
}
