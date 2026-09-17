package cdm.product.asset.validation.datarule;

import cdm.product.asset.ReferencePool;
import cdm.product.asset.ReferencePoolItem;
import cdm.product.template.ConstituentWeight;
import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 6.23.0
 */
@RosettaDataRule("ReferencePoolFpML_cd_44_basketPercentage")
@ImplementedBy(ReferencePoolFpML_cd_44_basketPercentage.Default.class)
public interface ReferencePoolFpML_cd_44_basketPercentage extends Validator<ReferencePool> {
	
	String NAME = "ReferencePoolFpML_cd_44_basketPercentage";
	String DEFINITION = "if referencePoolItem -> constituentWeight -> basketPercentage exists then referencePoolItem -> constituentWeight -> openUnits is absent";
	
	class Default implements ReferencePoolFpML_cd_44_basketPercentage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferencePool referencePool) {
			ComparisonResult result = executeDataRule(referencePool);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferencePool", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "ReferencePool", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(ReferencePool referencePool) {
			try {
				if (exists(MapperS.of(referencePool).<ReferencePoolItem>mapC("getReferencePoolItem", _referencePool -> _referencePool.getReferencePoolItem()).<ConstituentWeight>map("getConstituentWeight", referencePoolItem -> referencePoolItem.getConstituentWeight()).<BigDecimal>map("getBasketPercentage", constituentWeight -> constituentWeight.getBasketPercentage())).getOrDefault(false)) {
					return notExists(MapperS.of(referencePool).<ReferencePoolItem>mapC("getReferencePoolItem", _referencePool -> _referencePool.getReferencePoolItem()).<ConstituentWeight>map("getConstituentWeight", referencePoolItem -> referencePoolItem.getConstituentWeight()).<BigDecimal>map("getOpenUnits", constituentWeight -> constituentWeight.getOpenUnits()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements ReferencePoolFpML_cd_44_basketPercentage {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, ReferencePool referencePool) {
			return Collections.emptyList();
		}
	}
}
