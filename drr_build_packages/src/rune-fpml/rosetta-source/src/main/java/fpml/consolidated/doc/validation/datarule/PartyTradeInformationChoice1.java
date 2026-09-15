package fpml.consolidated.doc.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.doc.ClearingExceptionReason;
import fpml.consolidated.doc.EndUserExceptionDeclaration;
import fpml.consolidated.doc.PartyTradeInformation;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("PartyTradeInformationChoice1")
@ImplementedBy(PartyTradeInformationChoice1.Default.class)
public interface PartyTradeInformationChoice1 extends Validator<PartyTradeInformation> {
	
	String NAME = "PartyTradeInformationChoice1";
	String DEFINITION = "endUserExceptionDeclaration is absent or endUserException is absent and endUserExceptionReason is absent";
	
	class Default implements PartyTradeInformationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyTradeInformation partyTradeInformation) {
			ComparisonResult result = executeDataRule(partyTradeInformation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyTradeInformation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PartyTradeInformation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(PartyTradeInformation partyTradeInformation) {
			try {
				return notExists(MapperS.of(partyTradeInformation).<EndUserExceptionDeclaration>map("getEndUserExceptionDeclaration", _partyTradeInformation -> _partyTradeInformation.getEndUserExceptionDeclaration())).orNullSafe(notExists(MapperS.of(partyTradeInformation).<Boolean>map("getEndUserException", _partyTradeInformation -> _partyTradeInformation.getEndUserException())).andNullSafe(notExists(MapperS.of(partyTradeInformation).<ClearingExceptionReason>mapC("getEndUserExceptionReason", _partyTradeInformation -> _partyTradeInformation.getEndUserExceptionReason()))));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements PartyTradeInformationChoice1 {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, PartyTradeInformation partyTradeInformation) {
			return Collections.emptyList();
		}
	}
}
