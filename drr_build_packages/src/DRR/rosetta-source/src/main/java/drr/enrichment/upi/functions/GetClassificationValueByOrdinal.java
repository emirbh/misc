package drr.enrichment.upi.functions;

import cdm.base.staticdata.asset.common.TaxonomyClassification;
import cdm.base.staticdata.asset.common.TaxonomyValue;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperC;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(GetClassificationValueByOrdinal.GetClassificationValueByOrdinalDefault.class)
public abstract class GetClassificationValueByOrdinal implements RosettaFunction {

	/**
	* @param taxonomyValue 
	* @param o 
	* @return classificationValue 
	*/
	public String evaluate(TaxonomyValue taxonomyValue, Integer o) {
		String classificationValue = doEvaluate(taxonomyValue, o);
		
		return classificationValue;
	}

	protected abstract String doEvaluate(TaxonomyValue taxonomyValue, Integer o);

	public static class GetClassificationValueByOrdinalDefault extends GetClassificationValueByOrdinal {
		@Override
		protected String doEvaluate(TaxonomyValue taxonomyValue, Integer o) {
			String classificationValue = null;
			return assignOutput(classificationValue, taxonomyValue, o);
		}
		
		protected String assignOutput(String classificationValue, TaxonomyValue taxonomyValue, Integer o) {
			final MapperC<TaxonomyClassification> thenArg0 = MapperS.of(taxonomyValue).<TaxonomyClassification>mapC("getClassification", _taxonomyValue -> _taxonomyValue.getClassification())
				.filterItemNullSafe(item -> areEqual(item.<Integer>map("getOrdinal", taxonomyClassification -> taxonomyClassification.getOrdinal()), MapperS.of(o), CardinalityOperator.All).get());
			final MapperS<TaxonomyClassification> thenArg1 = MapperS.of(distinctIgnoringPrecision(thenArg0).get());
			classificationValue = thenArg1
				.mapSingleToItem(item -> item.<String>map("getValue", taxonomyClassification -> taxonomyClassification.getValue())).get();
			
			return classificationValue;
		}
	}
}
