package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PersonRole;
import fpml.consolidated.shared.validation.PersonRoleTypeFormatValidator;
import fpml.consolidated.shared.validation.PersonRoleValidator;
import fpml.consolidated.shared.validation.exists.PersonRoleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PersonRole.class)
public class PersonRoleMeta implements RosettaMetaData<PersonRole> {

	@Override
	public List<Validator<? super PersonRole>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PersonRole, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PersonRole> validator(ValidatorFactory factory) {
		return factory.<PersonRole>create(PersonRoleValidator.class);
	}

	@Override
	public Validator<? super PersonRole> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PersonRole>create(PersonRoleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PersonRole> validator() {
		return new PersonRoleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PersonRole> typeFormatValidator() {
		return new PersonRoleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PersonRole, Set<String>> onlyExistsValidator() {
		return new PersonRoleOnlyExistsValidator();
	}
}
