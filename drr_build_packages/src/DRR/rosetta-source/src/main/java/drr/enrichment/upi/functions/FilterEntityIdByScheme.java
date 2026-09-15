package drr.enrichment.upi.functions;

import cdm.base.staticdata.party.LegalEntity;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;


@ImplementedBy(FilterEntityIdByScheme.FilterEntityIdBySchemeDefault.class)
public abstract class FilterEntityIdByScheme implements RosettaFunction {

	/**
	* @param legalEntity 
	* @param scheme 
	* @return result 
	*/
	public String evaluate(LegalEntity legalEntity, String scheme) {
		String result = doEvaluate(legalEntity, scheme);
		
		return result;
	}

	protected abstract String doEvaluate(LegalEntity legalEntity, String scheme);

	public static class FilterEntityIdBySchemeDefault extends FilterEntityIdByScheme {
		@Override
		protected String doEvaluate(LegalEntity legalEntity, String scheme) {
			String result = null;
			return assignOutput(result, legalEntity, scheme);
		}
		
		protected String assignOutput(String result, LegalEntity legalEntity, String scheme) {
			return result;
		}
	}
}
