package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.AccountReference;
import fpml.consolidated.shared.validation.AccountReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.AccountReferenceValidator;
import fpml.consolidated.shared.validation.exists.AccountReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AccountReference.class)
public class AccountReferenceMeta implements RosettaMetaData<AccountReference> {

	@Override
	public List<Validator<? super AccountReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AccountReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AccountReference> validator(ValidatorFactory factory) {
		return factory.<AccountReference>create(AccountReferenceValidator.class);
	}

	@Override
	public Validator<? super AccountReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AccountReference>create(AccountReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AccountReference> validator() {
		return new AccountReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AccountReference> typeFormatValidator() {
		return new AccountReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AccountReference, Set<String>> onlyExistsValidator() {
		return new AccountReferenceOnlyExistsValidator();
	}
}
