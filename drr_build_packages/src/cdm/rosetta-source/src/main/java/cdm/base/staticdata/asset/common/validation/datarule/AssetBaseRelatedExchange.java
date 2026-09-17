package cdm.base.staticdata.asset.common.validation.datarule;

import cdm.base.staticdata.asset.common.AssetBase;
import cdm.base.staticdata.party.LegalEntity;
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
@RosettaDataRule("AssetBaseRelatedExchange")
@ImplementedBy(AssetBaseRelatedExchange.Default.class)
public interface AssetBaseRelatedExchange extends Validator<AssetBase> {
	
	String NAME = "AssetBaseRelatedExchange";
	String DEFINITION = "if exchange is absent then relatedExchange is absent";
	
	class Default implements AssetBaseRelatedExchange {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetBase assetBase) {
			ComparisonResult result = executeDataRule(assetBase);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetBase", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "AssetBase", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(AssetBase assetBase) {
			try {
				if (notExists(MapperS.of(assetBase).<LegalEntity>map("getExchange", _assetBase -> _assetBase.getExchange())).getOrDefault(false)) {
					return notExists(MapperS.of(assetBase).<LegalEntity>mapC("getRelatedExchange", _assetBase -> _assetBase.getRelatedExchange()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetBaseRelatedExchange {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetBase assetBase) {
			return Collections.emptyList();
		}
	}
}
