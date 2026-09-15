package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ConsentGranted;
import fpml.consolidated.confirmation.processes.validation.ConsentGrantedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ConsentGrantedValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ConsentGrantedChoice;
import fpml.consolidated.confirmation.processes.validation.exists.ConsentGrantedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ConsentGranted.class)
public class ConsentGrantedMeta implements RosettaMetaData<ConsentGranted> {

	@Override
	public List<Validator<? super ConsentGranted>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ConsentGranted>create(ConsentGrantedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ConsentGranted, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConsentGranted> validator(ValidatorFactory factory) {
		return factory.<ConsentGranted>create(ConsentGrantedValidator.class);
	}

	@Override
	public Validator<? super ConsentGranted> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ConsentGranted>create(ConsentGrantedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ConsentGranted> validator() {
		return new ConsentGrantedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ConsentGranted> typeFormatValidator() {
		return new ConsentGrantedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConsentGranted, Set<String>> onlyExistsValidator() {
		return new ConsentGrantedOnlyExistsValidator();
	}
}
