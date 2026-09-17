package fpml.consolidated.recordkeeping.processes.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ClearingExceptionReason;
import fpml.consolidated.doc.EndUserExceptionDeclaration;
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart45_2019;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RegulatoryClassificationPart45_2019Choice")
@ImplementedBy(RegulatoryClassificationPart45_2019Choice.Default.class)
public interface RegulatoryClassificationPart45_2019Choice extends Validator<RegulatoryClassificationPart45_2019> {
	
	String NAME = "RegulatoryClassificationPart45_2019Choice";
	String DEFINITION = "endUserExceptionDeclaration is absent or endUserException is absent and endUserExceptionReason is absent";
	
	class Default implements RegulatoryClassificationPart45_2019Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationPart45_2019 regulatoryClassificationPart45_2019) {
			ComparisonResult result = executeDataRule(regulatoryClassificationPart45_2019);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RegulatoryClassificationPart45_2019", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RegulatoryClassificationPart45_2019", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RegulatoryClassificationPart45_2019 regulatoryClassificationPart45_2019) {
			try {
				return notExists(MapperS.of(regulatoryClassificationPart45_2019).<EndUserExceptionDeclaration>map("getEndUserExceptionDeclaration", _regulatoryClassificationPart45_2019 -> _regulatoryClassificationPart45_2019.getEndUserExceptionDeclaration())).orNullSafe(notExists(MapperS.of(regulatoryClassificationPart45_2019).<Boolean>map("getEndUserException", _regulatoryClassificationPart45_2019 -> _regulatoryClassificationPart45_2019.getEndUserException())).andNullSafe(notExists(MapperS.of(regulatoryClassificationPart45_2019).<ClearingExceptionReason>mapC("getEndUserExceptionReason", _regulatoryClassificationPart45_2019 -> _regulatoryClassificationPart45_2019.getEndUserExceptionReason()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RegulatoryClassificationPart45_2019Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationPart45_2019 regulatoryClassificationPart45_2019) {
			return Collections.emptyList();
		}
	}
}
