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
@RosettaDataRule("AssetBaseExchangeListed")
@ImplementedBy(AssetBaseExchangeListed.Default.class)
public interface AssetBaseExchangeListed extends Validator<AssetBase> {
	
	String NAME = "AssetBaseExchangeListed";
	String DEFINITION = "if exchange exists then isExchangeListed";
	
	class Default implements AssetBaseExchangeListed {
	
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
				if (exists(MapperS.of(assetBase).<LegalEntity>map("getExchange", _assetBase -> _assetBase.getExchange())).getOrDefault(false)) {
					return ComparisonResult.ofNullSafe(MapperS.of(assetBase).<Boolean>map("getIsExchangeListed", _assetBase -> _assetBase.getIsExchangeListed()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements AssetBaseExchangeListed {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, AssetBase assetBase) {
			return Collections.emptyList();
		}
	}
}
