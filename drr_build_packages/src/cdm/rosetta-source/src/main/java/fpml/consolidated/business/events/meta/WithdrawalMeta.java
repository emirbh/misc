package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.Withdrawal;
import fpml.consolidated.business.events.validation.WithdrawalTypeFormatValidator;
import fpml.consolidated.business.events.validation.WithdrawalValidator;
import fpml.consolidated.business.events.validation.datarule.WithdrawalChoice;
import fpml.consolidated.business.events.validation.exists.WithdrawalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Withdrawal.class)
public class WithdrawalMeta implements RosettaMetaData<Withdrawal> {

	@Override
	public List<Validator<? super Withdrawal>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Withdrawal>create(WithdrawalChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Withdrawal, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Withdrawal> validator(ValidatorFactory factory) {
		return factory.<Withdrawal>create(WithdrawalValidator.class);
	}

	@Override
	public Validator<? super Withdrawal> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Withdrawal>create(WithdrawalTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Withdrawal> validator() {
		return new WithdrawalValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Withdrawal> typeFormatValidator() {
		return new WithdrawalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Withdrawal, Set<String>> onlyExistsValidator() {
		return new WithdrawalOnlyExistsValidator();
	}
}
