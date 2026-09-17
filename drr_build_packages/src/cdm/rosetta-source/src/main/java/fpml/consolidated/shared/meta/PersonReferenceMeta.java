package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PersonReference;
import fpml.consolidated.shared.validation.PersonReferenceTypeFormatValidator;
import fpml.consolidated.shared.validation.PersonReferenceValidator;
import fpml.consolidated.shared.validation.exists.PersonReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PersonReference.class)
public class PersonReferenceMeta implements RosettaMetaData<PersonReference> {

	@Override
	public List<Validator<? super PersonReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PersonReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PersonReference> validator(ValidatorFactory factory) {
		return factory.<PersonReference>create(PersonReferenceValidator.class);
	}

	@Override
	public Validator<? super PersonReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PersonReference>create(PersonReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PersonReference> validator() {
		return new PersonReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PersonReference> typeFormatValidator() {
		return new PersonReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PersonReference, Set<String>> onlyExistsValidator() {
		return new PersonReferenceOnlyExistsValidator();
	}
}
