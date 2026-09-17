package cdm.product.template.validation.datarule;

import cdm.product.template.EconomicTerms;
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


/**
 * @version 6.23.0
 */
@RosettaDataRule("EconomicTermsFpML_cd_27")
@ImplementedBy(EconomicTermsFpML_cd_27.Default.class)
public interface EconomicTermsFpML_cd_27 extends Validator<EconomicTerms> {
	
	String NAME = "EconomicTermsFpML_cd_27";
	String DEFINITION = "True";
	
	class Default implements EconomicTermsFpML_cd_27 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EconomicTerms economicTerms) {
			ComparisonResult result = executeDataRule(economicTerms);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "EconomicTerms", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(EconomicTerms economicTerms) {
			try {
				return ComparisonResult.ofNullSafe(MapperS.of(true));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements EconomicTermsFpML_cd_27 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, EconomicTerms economicTerms) {
			return Collections.emptyList();
		}
	}
}
