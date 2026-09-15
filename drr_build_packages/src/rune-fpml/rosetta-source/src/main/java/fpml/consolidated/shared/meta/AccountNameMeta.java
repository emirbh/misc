package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AccountName;
import fpml.consolidated.shared.validation.AccountNameTypeFormatValidator;
import fpml.consolidated.shared.validation.AccountNameValidator;
import fpml.consolidated.shared.validation.exists.AccountNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AccountName.class)
public class AccountNameMeta implements RosettaMetaData<AccountName> {

	@Override
	public List<Validator<? super AccountName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccountName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccountName> validator(ValidatorFactory factory) {
		return factory.<AccountName>create(AccountNameValidator.class);
	}

	@Override
	public Validator<? super AccountName> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AccountName>create(AccountNameTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AccountName> validator() {
		return new AccountNameValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AccountName> typeFormatValidator() {
		return new AccountNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccountName, Set<String>> onlyExistsValidator() {
		return new AccountNameOnlyExistsValidator();
	}
}
