package cdm.legaldocumentation.master.validation.datarule;

import cdm.legaldocumentation.master.MasterAgreementVariableSet;
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
@RosettaDataRule("MasterAgreementVariableSetVariableSetExists")
@ImplementedBy(MasterAgreementVariableSetVariableSetExists.Default.class)
public interface MasterAgreementVariableSetVariableSetExists extends Validator<MasterAgreementVariableSet> {
	
	String NAME = "MasterAgreementVariableSetVariableSetExists";
	String DEFINITION = "if variableSet exists then name is absent and value is absent";
	
	class Default implements MasterAgreementVariableSetVariableSetExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreementVariableSet masterAgreementVariableSet) {
			ComparisonResult result = executeDataRule(masterAgreementVariableSet);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "MasterAgreementVariableSet", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "MasterAgreementVariableSet", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(MasterAgreementVariableSet masterAgreementVariableSet) {
			try {
				if (exists(MapperS.of(masterAgreementVariableSet).<MasterAgreementVariableSet>mapC("getVariableSet", _masterAgreementVariableSet -> _masterAgreementVariableSet.getVariableSet())).getOrDefault(false)) {
					return notExists(MapperS.of(masterAgreementVariableSet).<String>map("getName", _masterAgreementVariableSet -> _masterAgreementVariableSet.getName())).andNullSafe(notExists(MapperS.of(masterAgreementVariableSet).<String>map("getValue", _masterAgreementVariableSet -> _masterAgreementVariableSet.getValue())));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements MasterAgreementVariableSetVariableSetExists {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, MasterAgreementVariableSet masterAgreementVariableSet) {
			return Collections.emptyList();
		}
	}
}
