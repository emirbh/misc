package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.WithdrawalReason;
import fpml.consolidated.business.events.validation.WithdrawalReasonTypeFormatValidator;
import fpml.consolidated.business.events.validation.WithdrawalReasonValidator;
import fpml.consolidated.business.events.validation.exists.WithdrawalReasonOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=WithdrawalReason.class)
public class WithdrawalReasonMeta implements RosettaMetaData<WithdrawalReason> {

	@Override
	public List<Validator<? super WithdrawalReason>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super WithdrawalReason, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super WithdrawalReason> validator(ValidatorFactory factory) {
		return factory.<WithdrawalReason>create(WithdrawalReasonValidator.class);
	}

	@Override
	public Validator<? super WithdrawalReason> typeFormatValidator(ValidatorFactory factory) {
		return factory.<WithdrawalReason>create(WithdrawalReasonTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super WithdrawalReason> validator() {
		return new WithdrawalReasonValidator();
	}

	@Deprecated
	@Override
	public Validator<? super WithdrawalReason> typeFormatValidator() {
		return new WithdrawalReasonTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super WithdrawalReason, Set<String>> onlyExistsValidator() {
		return new WithdrawalReasonOnlyExistsValidator();
	}
}
