package cdm.legaldocumentation.master.isda.meta;

import cdm.legaldocumentation.master.isda.AutomaticEarlyTermination;
import cdm.legaldocumentation.master.isda.validation.AutomaticEarlyTerminationTypeFormatValidator;
import cdm.legaldocumentation.master.isda.validation.AutomaticEarlyTerminationValidator;
import cdm.legaldocumentation.master.isda.validation.datarule.AutomaticEarlyTerminationFallbackAET;
import cdm.legaldocumentation.master.isda.validation.datarule.AutomaticEarlyTerminationIndemnity;
import cdm.legaldocumentation.master.isda.validation.exists.AutomaticEarlyTerminationOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=AutomaticEarlyTermination.class)
public class AutomaticEarlyTerminationMeta implements RosettaMetaData<AutomaticEarlyTermination> {

	@Override
	public List<Validator<? super AutomaticEarlyTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<AutomaticEarlyTermination>create(AutomaticEarlyTerminationFallbackAET.class),
			factory.<AutomaticEarlyTermination>create(AutomaticEarlyTerminationIndemnity.class)
		);
	}
	
	@Override
	public List<Function<? super AutomaticEarlyTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AutomaticEarlyTermination> validator(ValidatorFactory factory) {
		return factory.<AutomaticEarlyTermination>create(AutomaticEarlyTerminationValidator.class);
	}

	@Override
	public Validator<? super AutomaticEarlyTermination> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AutomaticEarlyTermination>create(AutomaticEarlyTerminationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AutomaticEarlyTermination> validator() {
		return new AutomaticEarlyTerminationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AutomaticEarlyTermination> typeFormatValidator() {
		return new AutomaticEarlyTerminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AutomaticEarlyTermination, Set<String>> onlyExistsValidator() {
		return new AutomaticEarlyTerminationOnlyExistsValidator();
	}
}
