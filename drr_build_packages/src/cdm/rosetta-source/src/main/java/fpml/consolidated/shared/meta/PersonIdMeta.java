package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PersonId;
import fpml.consolidated.shared.validation.PersonIdTypeFormatValidator;
import fpml.consolidated.shared.validation.PersonIdValidator;
import fpml.consolidated.shared.validation.exists.PersonIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PersonId.class)
public class PersonIdMeta implements RosettaMetaData<PersonId> {

	@Override
	public List<Validator<? super PersonId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PersonId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PersonId> validator(ValidatorFactory factory) {
		return factory.<PersonId>create(PersonIdValidator.class);
	}

	@Override
	public Validator<? super PersonId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PersonId>create(PersonIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PersonId> validator() {
		return new PersonIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PersonId> typeFormatValidator() {
		return new PersonIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PersonId, Set<String>> onlyExistsValidator() {
		return new PersonIdOnlyExistsValidator();
	}
}
