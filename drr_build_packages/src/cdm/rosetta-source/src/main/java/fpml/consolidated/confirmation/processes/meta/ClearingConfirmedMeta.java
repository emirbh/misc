package fpml.consolidated.confirmation.processes.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.confirmation.processes.ClearingConfirmed;
import fpml.consolidated.confirmation.processes.validation.ClearingConfirmedTypeFormatValidator;
import fpml.consolidated.confirmation.processes.validation.ClearingConfirmedValidator;
import fpml.consolidated.confirmation.processes.validation.datarule.ClearingConfirmedChoice;
import fpml.consolidated.confirmation.processes.validation.exists.ClearingConfirmedOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ClearingConfirmed.class)
public class ClearingConfirmedMeta implements RosettaMetaData<ClearingConfirmed> {

	@Override
	public List<Validator<? super ClearingConfirmed>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ClearingConfirmed>create(ClearingConfirmedChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ClearingConfirmed, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingConfirmed> validator(ValidatorFactory factory) {
		return factory.<ClearingConfirmed>create(ClearingConfirmedValidator.class);
	}

	@Override
	public Validator<? super ClearingConfirmed> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingConfirmed>create(ClearingConfirmedTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingConfirmed> validator() {
		return new ClearingConfirmedValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingConfirmed> typeFormatValidator() {
		return new ClearingConfirmedTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingConfirmed, Set<String>> onlyExistsValidator() {
		return new ClearingConfirmedOnlyExistsValidator();
	}
}
