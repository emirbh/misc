package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Person;
import fpml.consolidated.shared.validation.PersonTypeFormatValidator;
import fpml.consolidated.shared.validation.PersonValidator;
import fpml.consolidated.shared.validation.datarule.PersonChoice;
import fpml.consolidated.shared.validation.exists.PersonOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Person.class)
public class PersonMeta implements RosettaMetaData<Person> {

	@Override
	public List<Validator<? super Person>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Person>create(PersonChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Person, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Person> validator(ValidatorFactory factory) {
		return factory.<Person>create(PersonValidator.class);
	}

	@Override
	public Validator<? super Person> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Person>create(PersonTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Person> validator() {
		return new PersonValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Person> typeFormatValidator() {
		return new PersonTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Person, Set<String>> onlyExistsValidator() {
		return new PersonOnlyExistsValidator();
	}
}
