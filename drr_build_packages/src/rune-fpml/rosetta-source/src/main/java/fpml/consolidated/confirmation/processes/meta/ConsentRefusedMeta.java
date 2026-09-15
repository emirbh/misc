package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ConsentRefused;
import fpml.consolidated.confirmation.processes.validation.ConsentRefusedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ConsentRefusedValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ConsentRefusedChoice;
import fpml.consolidated.confirmation.processes.validation.exists.ConsentRefusedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ConsentRefused.class)
public class ConsentRefusedMeta implements RosettaMetaData<ConsentRefused> {

	@Override
	public List<Validator<? super ConsentRefused>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ConsentRefused>create(ConsentRefusedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ConsentRefused, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ConsentRefused> validator(ValidatorFactory factory) {
		return factory.<ConsentRefused>create(ConsentRefusedValidator.class);
	}

	@Override
	public Validator<? super ConsentRefused> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ConsentRefused>create(ConsentRefusedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ConsentRefused> validator() {
		return new ConsentRefusedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ConsentRefused> typeFormatValidator() {
		return new ConsentRefusedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ConsentRefused, Set<String>> onlyExistsValidator() {
		return new ConsentRefusedOnlyExistsValidator();
	}
}
