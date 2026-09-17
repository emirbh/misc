package fpml.consolidated.recordkeeping.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.recordkeeping.processes.InapplicableRegulation;
import fpml.consolidated.reg.fpmlreporting.shared.RegulationName;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("InapplicableRegulationChoice")
@ImplementedBy(InapplicableRegulationChoice.Default.class)
public interface InapplicableRegulationChoice extends Validator<InapplicableRegulation> {
	
	String NAME = "InapplicableRegulationChoice";
	String DEFINITION = "if supervisoryBody is absent then regulation exists";
	
	class Default implements InapplicableRegulationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InapplicableRegulation inapplicableRegulation) {
			ComparisonResult result = executeDataRule(inapplicableRegulation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "InapplicableRegulation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "InapplicableRegulation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(InapplicableRegulation inapplicableRegulation) {
			try {
				if (notExists(MapperS.of(inapplicableRegulation).<String>map("getSupervisoryBody", _inapplicableRegulation -> _inapplicableRegulation.getSupervisoryBody())).getOrDefault(false)) {
					return exists(MapperS.of(inapplicableRegulation).<RegulationName>mapC("getRegulation", _inapplicableRegulation -> _inapplicableRegulation.getRegulation()));
				}
				return ComparisonResult.ofEmpty();
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements InapplicableRegulationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, InapplicableRegulation inapplicableRegulation) {
			return Collections.emptyList();
		}
	}
}
