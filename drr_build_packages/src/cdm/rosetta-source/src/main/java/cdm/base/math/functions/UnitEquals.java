package cdm.base.math.functions;

import cdm.base.math.UnitType;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.metafields.FieldWithMetaString;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(UnitEquals.UnitEqualsDefault.class)
public abstract class UnitEquals implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected StringEquals stringEquals;

	/**
	* @param u1 
	* @param u2 
	* @return result 
	*/
	public Boolean evaluate(UnitType u1, UnitType u2) {
		Boolean result = doEvaluate(u1, u2);
		
		return result;
	}

	protected abstract Boolean doEvaluate(UnitType u1, UnitType u2);

	public static class UnitEqualsDefault extends UnitEquals {
		@Override
		protected Boolean doEvaluate(UnitType u1, UnitType u2) {
			Boolean result = null;
			return assignOutput(result, u1, u2);
		}
		
		protected Boolean assignOutput(Boolean result, UnitType u1, UnitType u2) {
			if (exists(MapperS.of(u1).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency())).getOrDefault(false)) {
				final FieldWithMetaString fieldWithMetaString0 = MapperS.of(u1).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
				final FieldWithMetaString fieldWithMetaString1 = MapperS.of(u2).<FieldWithMetaString>map("getCurrency", unitType -> unitType.getCurrency()).get();
				result = stringEquals.evaluate((fieldWithMetaString0 == null ? null : fieldWithMetaString0.getValue()), (fieldWithMetaString1 == null ? null : fieldWithMetaString1.getValue()));
			} else {
				result = areEqual(MapperS.of(u1), MapperS.of(u2), CardinalityOperator.All).get();
			}
			
			return result;
		}
	}
}
