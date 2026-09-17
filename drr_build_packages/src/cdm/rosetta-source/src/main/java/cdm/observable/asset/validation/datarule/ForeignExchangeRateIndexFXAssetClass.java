package cdm.observable.asset.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.observable.asset.ForeignExchangeRateIndex;
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
@RosettaDataRule("ForeignExchangeRateIndexFXAssetClass")
@ImplementedBy(ForeignExchangeRateIndexFXAssetClass.Default.class)
public interface ForeignExchangeRateIndexFXAssetClass extends Validator<ForeignExchangeRateIndex> {
	
	String NAME = "ForeignExchangeRateIndexFXAssetClass";
	String DEFINITION = "assetClass = AssetClassEnum -> ForeignExchange";
	
	class Default implements ForeignExchangeRateIndexFXAssetClass {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ForeignExchangeRateIndex foreignExchangeRateIndex) {
			ComparisonResult result = executeDataRule(foreignExchangeRateIndex);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ForeignExchangeRateIndex", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ForeignExchangeRateIndex", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ForeignExchangeRateIndex foreignExchangeRateIndex) {
			try {
				return areEqual(MapperS.of(foreignExchangeRateIndex).<AssetClassEnum>map("getAssetClass", _foreignExchangeRateIndex -> _foreignExchangeRateIndex.getAssetClass()), MapperS.of(AssetClassEnum.FOREIGN_EXCHANGE), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ForeignExchangeRateIndexFXAssetClass {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ForeignExchangeRateIndex foreignExchangeRateIndex) {
			return Collections.emptyList();
		}
	}
}
