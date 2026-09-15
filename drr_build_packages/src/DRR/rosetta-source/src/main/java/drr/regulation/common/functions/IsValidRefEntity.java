package drr.regulation.common.functions;

import cdm.base.staticdata.asset.common.ISOCountryCodeEnum;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.functions.RosettaFunction;
import com.rosetta.model.lib.mapper.MapperS;
import drr.base.util.string.functions.StringContains;
import drr.base.util.string.functions.SubString;
import javax.inject.Inject;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

@ImplementedBy(IsValidRefEntity.IsValidRefEntityDefault.class)
public abstract class IsValidRefEntity implements RosettaFunction {
	
	// RosettaFunction dependencies
	//
	@Inject protected StringContains stringContains;
	@Inject protected SubString subString;

	/**
	* @param refEntity 
	* @return validRefEntity 
	*/
	public Boolean evaluate(String refEntity) {
		Boolean validRefEntity = doEvaluate(refEntity);
		
		return validRefEntity;
	}

	protected abstract Boolean doEvaluate(String refEntity);

	protected abstract MapperS<Boolean> validFormat(String refEntity);

	protected abstract MapperS<Boolean> validCountryCode(String refEntity);

	public static class IsValidRefEntityDefault extends IsValidRefEntity {
		@Override
		protected Boolean doEvaluate(String refEntity) {
			Boolean validRefEntity = null;
			return assignOutput(validRefEntity, refEntity);
		}
		
		protected Boolean assignOutput(Boolean validRefEntity, String refEntity) {
			validRefEntity = ComparisonResult.ofNullSafe(validCountryCode(refEntity)).andNullSafe(ComparisonResult.ofNullSafe(validFormat(refEntity))).get();
			
			return validRefEntity;
		}
		
		@Override
		protected MapperS<Boolean> validFormat(String refEntity) {
			return MapperS.of(stringContains.evaluate(refEntity, "[A-Z]{2}(-[A-Z]{3})?"));
		}
		
		@Override
		protected MapperS<Boolean> validCountryCode(String refEntity) {
			return exists(MapperS.of(subString.evaluate(refEntity, 1, 2)).checkedMap("to-enum", ISOCountryCodeEnum::fromDisplayName, IllegalArgumentException.class)).asMapper();
		}
	}
}
