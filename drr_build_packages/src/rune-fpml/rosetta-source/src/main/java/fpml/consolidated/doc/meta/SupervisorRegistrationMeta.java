package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.SupervisorRegistration;
import fpml.consolidated.doc.validation.SupervisorRegistrationTypeFormatValidator;
import fpml.consolidated.doc.validation.SupervisorRegistrationValidator;
import fpml.consolidated.doc.validation.exists.SupervisorRegistrationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SupervisorRegistration.class)
public class SupervisorRegistrationMeta implements RosettaMetaData<SupervisorRegistration> {

	@Override
	public List<Validator<? super SupervisorRegistration>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SupervisorRegistration, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SupervisorRegistration> validator(ValidatorFactory factory) {
		return factory.<SupervisorRegistration>create(SupervisorRegistrationValidator.class);
	}

	@Override
	public Validator<? super SupervisorRegistration> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SupervisorRegistration>create(SupervisorRegistrationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SupervisorRegistration> validator() {
		return new SupervisorRegistrationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SupervisorRegistration> typeFormatValidator() {
		return new SupervisorRegistrationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SupervisorRegistration, Set<String>> onlyExistsValidator() {
		return new SupervisorRegistrationOnlyExistsValidator();
	}
}
