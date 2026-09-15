package drr.base.trade.basket.functions;

import cdm.product.asset.BasketReferenceInformation;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.asset.GeneralTerms;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;


@ImplementedBy(CreditBasketIdentifier.CreditBasketIdentifierDefault.class)
public abstract class CreditBasketIdentifier implements RosettaFunction {

	/**
	* @param creditDefaultPayout 
	* @return identifier 
	*/
	public String evaluate(CreditDefaultPayout creditDefaultPayout) {
		String identifier = doEvaluate(creditDefaultPayout);
		
		return identifier;
	}

	protected abstract String doEvaluate(CreditDefaultPayout creditDefaultPayout);

	public static class CreditBasketIdentifierDefault extends CreditBasketIdentifier {
		@Override
		protected String doEvaluate(CreditDefaultPayout creditDefaultPayout) {
			String identifier = null;
			return assignOutput(identifier, creditDefaultPayout);
		}
		
		protected String assignOutput(String identifier, CreditDefaultPayout creditDefaultPayout) {
			final FieldWithMetaString fieldWithMetaString = MapperS.of(creditDefaultPayout).<GeneralTerms>map("getGeneralTerms", _creditDefaultPayout -> _creditDefaultPayout.getGeneralTerms()).<BasketReferenceInformation>map("getBasketReferenceInformation", generalTerms -> generalTerms.getBasketReferenceInformation()).<FieldWithMetaString>mapC("getBasketId", basketReferenceInformation -> basketReferenceInformation.getBasketId())
				.first().get();
			if (fieldWithMetaString == null) {
				identifier = null;
			} else {
				identifier = fieldWithMetaString.getValue();
			}
			
			return identifier;
		}
	}
}
