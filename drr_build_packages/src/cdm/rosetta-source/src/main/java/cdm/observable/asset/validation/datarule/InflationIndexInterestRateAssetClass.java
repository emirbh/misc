package cdm.observable.asset.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.observable.asset.InflationIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("InflationIndexInterestRateAssetClass")
@ImplementedBy(InflationIndexInterestRateAssetClass.Default.class)
public interface InflationIndexInterestRateAssetClass extends Validator<InflationIndex> {
	
	String NAME = "InflationIndexInterestRateAssetClass";
	String DEFINITION = "assetClass = AssetClassEnum -> InterestRate";
	
	class Default implements InflationIndexInterestRateAssetClass {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InflationIndex inflationIndex) {
			ComparisonResult result = executeDataRule(inflationIndex);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InflationIndex", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InflationIndex", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(InflationIndex inflationIndex) {
			try {
				return areEqual(MapperS.of(inflationIndex).<AssetClassEnum>map("getAssetClass", _inflationIndex -> _inflationIndex.getAssetClass()), MapperS.of(AssetClassEnum.INTEREST_RATE), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InflationIndexInterestRateAssetClass {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InflationIndex inflationIndex) {
			return Collections.emptyList();
		}
	}
}
