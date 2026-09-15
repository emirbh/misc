package drr.regulation.common.trade.underlier.functions;

import cdm.base.staticdata.party.EntityIdentifier;
import cdm.base.staticdata.party.EntityIdentifierTypeEnum;
import cdm.base.staticdata.party.LegalEntity;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import cdm.product.asset.ReferenceInformation;
import cdm.product.template.NonTransferableProduct;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import drr.base.trade.functions.EconomicTermsForProduct;
import drr.base.trade.underlier.functions.UnderlierForProduct;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetUnderlierLEIForCredit.GetUnderlierLEIForCreditDefault.class)
public abstract class GetUnderlierLEIForCredit implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected EconomicTermsForProduct economicTermsForProduct;
	@Inject protected UnderlierForProduct underlierForProduct;

	/**
	* @param product 
	* @return lei 
	*/
	public List<String> evaluate(NonTransferableProduct product) {
		List<String> lei = doEvaluate(product);
		
		return lei;
	}

	protected abstract List<String> doEvaluate(NonTransferableProduct product);

	public static class GetUnderlierLEIForCreditDefault extends GetUnderlierLEIForCredit {
		@Override
		protected List<String> doEvaluate(NonTransferableProduct product) {
			List<String> lei = new ArrayList<>();
			return assignOutput(lei, product);
		}
		
		protected List<String> assignOutput(List<String> lei, NonTransferableProduct product) {
			final MapperC<EntityIdentifier> thenArg0;
			if (exists(MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<LegalEntity>map("getReferenceEntity", referenceInformation -> referenceInformation.getReferenceEntity()).<EntityIdentifier>mapC("getEntityIdentifier", legalEntity -> legalEntity.getEntityIdentifier())).getOrDefault(false)) {
				thenArg0 = MapperS.of(economicTermsForProduct.evaluate(product)).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<LegalEntity>map("getReferenceEntity", referenceInformation -> referenceInformation.getReferenceEntity()).<EntityIdentifier>mapC("getEntityIdentifier", legalEntity -> legalEntity.getEntityIdentifier());
			} else if (exists(MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<LegalEntity>map("getReferenceEntity", referenceInformation -> referenceInformation.getReferenceEntity()).<EntityIdentifier>mapC("getEntityIdentifier", legalEntity -> legalEntity.getEntityIdentifier())).getOrDefault(false)) {
				thenArg0 = MapperS.of(economicTermsForProduct.evaluate(MapperS.of(underlierForProduct.evaluate(product)).<Product>map("getProduct", underlier -> underlier.getProduct()).<NonTransferableProduct>map("getNonTransferableProduct", _product -> _product.getNonTransferableProduct()).get())).<Payout>mapC("getPayout", economicTerms -> economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", payout -> payout.getCreditDefaultPayout()).<GeneralTerms>map("getGeneralTerms", creditDefaultPayout -> creditDefaultPayout.getGeneralTerms()).<ReferenceInformation>map("getReferenceInformation", generalTerms -> generalTerms.getReferenceInformation()).<LegalEntity>map("getReferenceEntity", referenceInformation -> referenceInformation.getReferenceEntity()).<EntityIdentifier>mapC("getEntityIdentifier", legalEntity -> legalEntity.getEntityIdentifier());
			} else {
				thenArg0 = MapperC.<EntityIdentifier>ofNull();
			}
			final MapperC<EntityIdentifier> thenArg1 = thenArg0
				.filterItemNullSafe(item -> areEqual(item.<EntityIdentifierTypeEnum>map("getIdentifierType", entityIdentifier -> entityIdentifier.getIdentifierType()), MapperS.of(EntityIdentifierTypeEnum.LEI), CardinalityOperator.All).get());
			lei.addAll(thenArg1
				.mapItem(item -> item.<FieldWithMetaString>map("getIdentifier", entityIdentifier -> entityIdentifier.getIdentifier())).<String>map("Type coercion", fieldWithMetaString -> fieldWithMetaString.getValue()).getMulti());
			
			return lei;
		}
	}
}
