package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.Deal;
import fpml.consolidated.loan.DealIdentifier;
import fpml.consolidated.loan.DealSummary;
import fpml.consolidated.loan.LoanLegalAction;
import fpml.consolidated.loan.LoanLegalActionStatement;
import fpml.consolidated.loan.LoanLegalActionStatementChoice0;
import fpml.consolidated.loan.LoanLegalActionStatementChoice1;
import fpml.consolidated.loan.LoanLegalActionStatementChoice2;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class LoanLegalActionStatementOnlyExistsValidator implements ValidatorWithArg<LoanLegalActionStatement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends LoanLegalActionStatement> ValidationResult<LoanLegalActionStatement> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("fpmlVersion", ExistenceChecker.isSet((String) o.getFpmlVersion()))
				.put("expectedBuild", ExistenceChecker.isSet((Integer) o.getExpectedBuild()))
				.put("actualBuild", ExistenceChecker.isSet((Integer) o.getActualBuild()))
				.put("header", ExistenceChecker.isSet((RequestMessageHeader) o.getHeader()))
				.put("validation", ExistenceChecker.isSet((List<? extends Validation>) o.getValidation()))
				.put("isCorrection", ExistenceChecker.isSet((Boolean) o.getIsCorrection()))
				.put("parentCorrelationId", ExistenceChecker.isSet((CorrelationId) o.getParentCorrelationId()))
				.put("correlationId", ExistenceChecker.isSet((List<? extends CorrelationId>) o.getCorrelationId()))
				.put("sequenceNumber", ExistenceChecker.isSet((Integer) o.getSequenceNumber()))
				.put("onBehalfOf", ExistenceChecker.isSet((List<? extends OnBehalfOf>) o.getOnBehalfOf()))
				.put("statementDate", ExistenceChecker.isSet((ZonedDateTime) o.getStatementDate()))
				.put("comments", ExistenceChecker.isSet((String) o.getComments()))
				.put("legalAction", ExistenceChecker.isSet((LoanLegalAction) o.getLegalAction()))
				.put("dealIdentifier", ExistenceChecker.isSet((DealIdentifier) o.getDealIdentifier()))
				.put("dealSummary", ExistenceChecker.isSet((DealSummary) o.getDealSummary()))
				.put("deal", ExistenceChecker.isSet((Deal) o.getDeal()))
				.put("loanLegalActionStatementChoice0", ExistenceChecker.isSet((List<? extends LoanLegalActionStatementChoice0>) o.getLoanLegalActionStatementChoice0()))
				.put("loanLegalActionStatementChoice1", ExistenceChecker.isSet((List<? extends LoanLegalActionStatementChoice1>) o.getLoanLegalActionStatementChoice1()))
				.put("loanLegalActionStatementChoice2", ExistenceChecker.isSet((List<? extends LoanLegalActionStatementChoice2>) o.getLoanLegalActionStatementChoice2()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("LoanLegalActionStatement", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalActionStatement", path, "");
		}
		return failure("LoanLegalActionStatement", ValidationResult.ValidationType.ONLY_EXISTS, "LoanLegalActionStatement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
