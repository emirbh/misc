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
import fpml.consolidated.recordkeeping.processes.RegulatoryClassificationPart45_2012;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("RegulatoryClassificationPart45_2012Choice")
@ImplementedBy(RegulatoryClassificationPart45_2012Choice.Default.class)
public interface RegulatoryClassificationPart45_2012Choice extends Validator<RegulatoryClassificationPart45_2012> {
	
	String NAME = "RegulatoryClassificationPart45_2012Choice";
	String DEFINITION = "endUserExceptionDeclaration is absent or endUserException is absent and endUserExceptionReason is absent";
	
	class Default implements RegulatoryClassificationPart45_2012Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationPart45_2012 regulatoryClassificationPart45_2012) {
			ComparisonResult result = executeDataRule(regulatoryClassificationPart45_2012);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "RegulatoryClassificationPart45_2012", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "RegulatoryClassificationPart45_2012", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(RegulatoryClassificationPart45_2012 regulatoryClassificationPart45_2012) {
			try {
				return notExists(MapperS.of(regulatoryClassificationPart45_2012).<EndUserExceptionDeclaration>map("getEndUserExceptionDeclaration", _regulatoryClassificationPart45_2012 -> _regulatoryClassificationPart45_2012.getEndUserExceptionDeclaration())).orNullSafe(notExists(MapperS.of(regulatoryClassificationPart45_2012).<Boolean>map("getEndUserException", _regulatoryClassificationPart45_2012 -> _regulatoryClassificationPart45_2012.getEndUserException())).andNullSafe(notExists(MapperS.of(regulatoryClassificationPart45_2012).<ClearingExceptionReason>mapC("getEndUserExceptionReason", _regulatoryClassificationPart45_2012 -> _regulatoryClassificationPart45_2012.getEndUserExceptionReason()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements RegulatoryClassificationPart45_2012Choice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, RegulatoryClassificationPart45_2012 regulatoryClassificationPart45_2012) {
			return Collections.emptyList();
		}
	}
}
