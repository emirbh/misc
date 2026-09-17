package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ClearingRefused;
import fpml.consolidated.confirmation.processes.validation.ClearingRefusedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ClearingRefusedValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ClearingRefusedChoice;
import fpml.consolidated.confirmation.processes.validation.exists.ClearingRefusedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ClearingRefused.class)
public class ClearingRefusedMeta implements RosettaMetaData<ClearingRefused> {

	@Override
	public List<Validator<? super ClearingRefused>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ClearingRefused>create(ClearingRefusedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ClearingRefused, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingRefused> validator(ValidatorFactory factory) {
		return factory.<ClearingRefused>create(ClearingRefusedValidator.class);
	}

	@Override
	public Validator<? super ClearingRefused> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingRefused>create(ClearingRefusedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingRefused> validator() {
		return new ClearingRefusedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingRefused> typeFormatValidator() {
		return new ClearingRefusedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingRefused, Set<String>> onlyExistsValidator() {
		return new ClearingRefusedOnlyExistsValidator();
	}
}
