package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AccountType;
import fpml.consolidated.shared.validation.AccountTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.AccountTypeValidator;
import fpml.consolidated.shared.validation.exists.AccountTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AccountType.class)
public class AccountTypeMeta implements RosettaMetaData<AccountType> {

	@Override
	public List<Validator<? super AccountType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccountType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccountType> validator(ValidatorFactory factory) {
		return factory.<AccountType>create(AccountTypeValidator.class);
	}

	@Override
	public Validator<? super AccountType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AccountType>create(AccountTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AccountType> validator() {
		return new AccountTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AccountType> typeFormatValidator() {
		return new AccountTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccountType, Set<String>> onlyExistsValidator() {
		return new AccountTypeOnlyExistsValidator();
	}
}
