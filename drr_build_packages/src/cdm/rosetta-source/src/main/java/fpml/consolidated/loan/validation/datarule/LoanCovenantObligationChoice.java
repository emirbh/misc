package fpml.consolidated.loan.validation.datarule;

import com.google.inject.ImplementedBy;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;
import fpml.consolidated.loan.LoanCovenantObligation;
import fpml.consolidated.loan.LoanCovenantObligationAccountingDetails;
import fpml.consolidated.loan.LoanCovenantObligationCategoryType;
import fpml.consolidated.loan.LoanCovenantObligationReference;
import fpml.consolidated.loan.LoanCovenantObligationTriggerCriteriaDetails;
import fpml.consolidated.loan.LoanCovenantObligationType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.rosetta.model.lib.expression.ExpressionOperatorsNullSafe.*;

/**
 * @version 2.1.1
 */
@RosettaDataRule("LoanCovenantObligationChoice")
@ImplementedBy(LoanCovenantObligationChoice.Default.class)
public interface LoanCovenantObligationChoice extends Validator<LoanCovenantObligation> {
	
	String NAME = "LoanCovenantObligationChoice";
	String DEFINITION = "if deemedCovenantReference exists then category is absent and ^type is absent and loanCovenantObligationChoice is absent and triggerCriteria is absent and accountingDetails is absent else if category exists or ^type exists then category exists and ^type exists and deemedCovenantReference is absent else False";
	
	class Default implements LoanCovenantObligationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligation loanCovenantObligation) {
			ComparisonResult result = executeDataRule(loanCovenantObligation);
			if (result.getOrDefault(true)) {
				return Arrays.asList(ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanCovenantObligation", path, DEFINITION));
			}
			
			String failureMessage = result.getError();
			if (failureMessage == null || failureMessage.contains("Null") || failureMessage == "") {
				failureMessage = "Condition has failed.";
			}
			return Arrays.asList(ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "LoanCovenantObligation", path, DEFINITION, failureMessage));
		}
		
		private ComparisonResult executeDataRule(LoanCovenantObligation loanCovenantObligation) {
			try {
				if (exists(MapperS.of(loanCovenantObligation).<LoanCovenantObligationReference>map("getDeemedCovenantReference", _loanCovenantObligation -> _loanCovenantObligation.getDeemedCovenantReference())).getOrDefault(false)) {
					return notExists(MapperS.of(loanCovenantObligation).<LoanCovenantObligationCategoryType>map("getCategory", _loanCovenantObligation -> _loanCovenantObligation.getCategory())).andNullSafe(notExists(MapperS.of(loanCovenantObligation).<LoanCovenantObligationType>map("getType", _loanCovenantObligation -> _loanCovenantObligation._getType()))).andNullSafe(notExists(MapperS.of(loanCovenantObligation).<fpml.consolidated.loan.LoanCovenantObligationChoice>mapC("getLoanCovenantObligationChoice", _loanCovenantObligation -> _loanCovenantObligation.getLoanCovenantObligationChoice()))).andNullSafe(notExists(MapperS.of(loanCovenantObligation).<LoanCovenantObligationTriggerCriteriaDetails>map("getTriggerCriteria", _loanCovenantObligation -> _loanCovenantObligation.getTriggerCriteria()))).andNullSafe(notExists(MapperS.of(loanCovenantObligation).<LoanCovenantObligationAccountingDetails>map("getAccountingDetails", _loanCovenantObligation -> _loanCovenantObligation.getAccountingDetails())));
				}
				if (exists(MapperS.of(loanCovenantObligation).<LoanCovenantObligationCategoryType>map("getCategory", _loanCovenantObligation -> _loanCovenantObligation.getCategory())).orNullSafe(exists(MapperS.of(loanCovenantObligation).<LoanCovenantObligationType>map("getType", _loanCovenantObligation -> _loanCovenantObligation._getType()))).getOrDefault(false)) {
					return exists(MapperS.of(loanCovenantObligation).<LoanCovenantObligationCategoryType>map("getCategory", _loanCovenantObligation -> _loanCovenantObligation.getCategory())).andNullSafe(exists(MapperS.of(loanCovenantObligation).<LoanCovenantObligationType>map("getType", _loanCovenantObligation -> _loanCovenantObligation._getType()))).andNullSafe(notExists(MapperS.of(loanCovenantObligation).<LoanCovenantObligationReference>map("getDeemedCovenantReference", _loanCovenantObligation -> _loanCovenantObligation.getDeemedCovenantReference())));
				}
				return ComparisonResult.ofNullSafe(MapperS.of(false));
			}
			catch (Exception ex) {
				return ComparisonResult.failure(ex.getMessage());
			}
		}
	}
	
	@SuppressWarnings("unused")
	class NoOp implements LoanCovenantObligationChoice {
	
		@Override
		public List<ValidationResult<?>> getValidationResults(RosettaPath path, LoanCovenantObligation loanCovenantObligation) {
			return Collections.emptyList();
		}
	}
}
