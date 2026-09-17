package cdm.observable.asset.validation.datarule;

import cdm.base.staticdata.asset.common.AssetClassEnum;
import cdm.observable.asset.OtherIndex;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
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
@RosettaDataRule("OtherIndexAssetClassRequired")
@ImplementedBy(OtherIndexAssetClassRequired.Default.class)
public interface OtherIndexAssetClassRequired extends Validator<OtherIndex> {
	
	String NAME = "OtherIndexAssetClassRequired";
	String DEFINITION = "assetClass exists";
	
	class Default implements OtherIndexAssetClassRequired {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OtherIndex otherIndex) {
			ComparisonResult result = executeDataRule(otherIndex);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "OtherIndex", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "OtherIndex", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(OtherIndex otherIndex) {
			try {
				return exists(MapperS.of(otherIndex).<AssetClassEnum>map("getAssetClass", _otherIndex -> _otherIndex.getAssetClass()));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements OtherIndexAssetClassRequired {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, OtherIndex otherIndex) {
			return Collections.emptyList();
		}
	}
}
