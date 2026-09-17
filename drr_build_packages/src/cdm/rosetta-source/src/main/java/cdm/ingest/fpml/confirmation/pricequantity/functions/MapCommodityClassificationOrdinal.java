package cdm.ingest.fpml.confirmation.pricequantity.functions;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(MapCommodityClassificationOrdinal.MapCommodityClassificationOrdinalDefault.class)
public abstract class MapCommodityClassificationOrdinal implements RosettaFunction {

	/**
	* @param scheme 
	* @return result 
	*/
	public Integer evaluate(String scheme) {
		Integer result = doEvaluate(scheme);
		
		return result;
	}

	protected abstract Integer doEvaluate(String scheme);

	public static class MapCommodityClassificationOrdinalDefault extends MapCommodityClassificationOrdinal {
		@Override
		protected Integer doEvaluate(String scheme) {
			Integer result = null;
			return assignOutput(result, scheme);
		}
		
		protected Integer assignOutput(Integer result, String scheme) {
			final MapperS<String> switchArgument = MapperS.of(scheme);
			if (switchArgument.get() == null) {
				result = null;
			} else if (areEqual(switchArgument, MapperS.of("http://www.fpml.org/coding-scheme/esma-emir-refit-layer-1-commodity-classification"), CardinalityOperator.All).get()) {
				result = 1;
			} else if (areEqual(switchArgument, MapperS.of("http://www.fpml.org/coding-scheme/esma-emir-refit-layer-2-commodity-classification"), CardinalityOperator.All).get()) {
				result = 2;
			} else if (areEqual(switchArgument, MapperS.of("http://www.fpml.org/coding-scheme/esma-emir-refit-layer-3-commodity-classification"), CardinalityOperator.All).get()) {
				result = 3;
			} else if (areEqual(switchArgument, MapperS.of("http://www.fpml.org/coding-scheme/isda-layer-1-commodity-classification"), CardinalityOperator.All).get()) {
				result = 1;
			} else if (areEqual(switchArgument, MapperS.of("http://www.fpml.org/coding-scheme/isda-layer-2-commodity-classification"), CardinalityOperator.All).get()) {
				result = 2;
			} else if (areEqual(switchArgument, MapperS.of("http://www.fpml.org/coding-scheme/isda-layer-3-commodity-classification"), CardinalityOperator.All).get()) {
				result = 3;
			} else {
				result = null;
			}
			
			return result;
		}
	}
}
