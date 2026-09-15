package drr.enrichment.upi.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.string.functions.ReplaceAll;
import drr.standards.iosco.upi.codesets.AnnaDsbMrktCreditIndexEnum;
import javax.inject.Inject;


@ImplementedBy(TranslateIndexNameToId.TranslateIndexNameToIdDefault.class)
public abstract class TranslateIndexNameToId implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected ReplaceAll replaceAll;

	/**
	* @param name 
	* @return enumValue 
	*/
	public String evaluate(String name) {
		String enumValue = doEvaluate(name);
		
		return enumValue;
	}

	protected abstract String doEvaluate(String name);

	public static class TranslateIndexNameToIdDefault extends TranslateIndexNameToId {
		@Override
		protected String doEvaluate(String name) {
			String enumValue = null;
			return assignOutput(enumValue, name);
		}
		
		protected String assignOutput(String enumValue, String name) {
			enumValue = MapperS.of(replaceAll.evaluate(name, " SERIES.*$", "")).checkedMap("to-enum", AnnaDsbMrktCreditIndexEnum::fromDisplayName, IllegalArgumentException.class).map("to-string", AnnaDsbMrktCreditIndexEnum::toDisplayString).get();
			
			return enumValue;
		}
	}
}
