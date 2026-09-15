package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.TelephoneNumber;
import fpml.consolidated.shared.validation.TelephoneNumberTypeFormatValidator;
import fpml.consolidated.shared.validation.TelephoneNumberValidator;
import fpml.consolidated.shared.validation.exists.TelephoneNumberOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TelephoneNumber.class)
public class TelephoneNumberMeta implements RosettaMetaData<TelephoneNumber> {

	@Override
	public List<Validator<? super TelephoneNumber>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TelephoneNumber, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TelephoneNumber> validator(ValidatorFactory factory) {
		return factory.<TelephoneNumber>create(TelephoneNumberValidator.class);
	}

	@Override
	public Validator<? super TelephoneNumber> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TelephoneNumber>create(TelephoneNumberTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TelephoneNumber> validator() {
		return new TelephoneNumberValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TelephoneNumber> typeFormatValidator() {
		return new TelephoneNumberTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TelephoneNumber, Set<String>> onlyExistsValidator() {
		return new TelephoneNumberOnlyExistsValidator();
	}
}
