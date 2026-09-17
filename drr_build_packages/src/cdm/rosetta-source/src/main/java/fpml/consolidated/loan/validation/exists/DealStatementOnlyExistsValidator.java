package fpml.consolidated.loan.validation.exists;

import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.loan.Deal;
import fpml.consolidated.loan.DealStatement;
import fpml.consolidated.loan.DealStatementChoice0;
import fpml.consolidated.loan.DealStatementChoice1;
import fpml.consolidated.loan.DealStatementChoice2;
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

public class DealStatementOnlyExistsValidator implements ValidatorWithArg<DealStatement, Set<String>> {

	/* Casting is required to ensure types are output to ensure recompilation in Rosetta */
	@Override
	public <T2 extends DealStatement> ValidationResult<DealStatement> validate(RosettaPath path, T2 o, Set<String> fields) {
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
				.put("deal", ExistenceChecker.isSet((Deal) o.getDeal()))
				.put("dealStatementChoice0", ExistenceChecker.isSet((List<? extends DealStatementChoice0>) o.getDealStatementChoice0()))
				.put("dealStatementChoice1", ExistenceChecker.isSet((List<? extends DealStatementChoice1>) o.getDealStatementChoice1()))
				.put("dealStatementChoice2", ExistenceChecker.isSet((List<? extends DealStatementChoice2>) o.getDealStatementChoice2()))
				.put("party", ExistenceChecker.isSet((List<? extends Party>) o.getParty()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("DealStatement", ValidationResult.ValidationType.ONLY_EXISTS, "DealStatement", path, "");
		}
		return failure("DealStatement", ValidationResult.ValidationType.ONLY_EXISTS, "DealStatement", path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
