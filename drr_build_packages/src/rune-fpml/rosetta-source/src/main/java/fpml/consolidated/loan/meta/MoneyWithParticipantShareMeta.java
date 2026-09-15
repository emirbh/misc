package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.MoneyWithParticipantShare;
import fpml.consolidated.loan.validation.MoneyWithParticipantShareTypeFormatValidator;
import fpml.consolidated.loan.validation.MoneyWithParticipantShareValidator;
import fpml.consolidated.loan.validation.exists.MoneyWithParticipantShareOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MoneyWithParticipantShare.class)
public class MoneyWithParticipantShareMeta implements RosettaMetaData<MoneyWithParticipantShare> {

	@Override
	public List<Validator<? super MoneyWithParticipantShare>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MoneyWithParticipantShare, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MoneyWithParticipantShare> validator(ValidatorFactory factory) {
		return factory.<MoneyWithParticipantShare>create(MoneyWithParticipantShareValidator.class);
	}

	@Override
	public Validator<? super MoneyWithParticipantShare> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MoneyWithParticipantShare>create(MoneyWithParticipantShareTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MoneyWithParticipantShare> validator() {
		return new MoneyWithParticipantShareValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MoneyWithParticipantShare> typeFormatValidator() {
		return new MoneyWithParticipantShareTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MoneyWithParticipantShare, Set<String>> onlyExistsValidator() {
		return new MoneyWithParticipantShareOnlyExistsValidator();
	}
}
