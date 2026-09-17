package cdm.observable.asset.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.observable.asset.EquityIndex;
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
@RosettaDataRule("EquityIndexEquityAssetClass")
@ImplementedBy(EquityIndexEquityAssetClass.Default.class)
public interface EquityIndexEquityAssetClass extends Validator<EquityIndex> {
	
	String NAME = "EquityIndexEquityAssetClass";
	String DEFINITION = "assetClass = AssetClassEnum -> Equity";
	
	class Default implements EquityIndexEquityAssetClass {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityIndex equityIndex) {
			ComparisonResult result = executeDataRule(equityIndex);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityIndex", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EquityIndex", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EquityIndex equityIndex) {
			try {
				return areEqual(MapperS.of(equityIndex).<AssetClassEnum>map("getAssetClass", _equityIndex -> _equityIndex.getAssetClass()), MapperS.of(AssetClassEnum.EQUITY), CardinalityOperator.All);
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EquityIndexEquityAssetClass {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EquityIndex equityIndex) {
			return Collections.emptyList();
		}
	}
}
