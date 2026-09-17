package cdm.product.template.meta;

import cdm.product.template.MandatoryEarlyTermination;
import cdm.product.template.validation.MandatoryEarlyTerminationTypeFormatValidator;
import cdm.product.template.validation.MandatoryEarlyTerminationValidator;
import cdm.product.template.validation.datarule.MandatoryEarlyTerminationMandatoryEarlyTerminationCalculationAgent;
import cdm.product.template.validation.exists.MandatoryEarlyTerminationOnlyExistsValidator;
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
@RosettaMeta(model=MandatoryEarlyTermination.class)
public class MandatoryEarlyTerminationMeta implements RosettaMetaData<MandatoryEarlyTermination> {

	@Override
	public List<Validator<? super MandatoryEarlyTermination>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MandatoryEarlyTermination>create(MandatoryEarlyTerminationMandatoryEarlyTerminationCalculationAgent.class)
		);
	}
	
	@Override
	public List<Function<? super MandatoryEarlyTermination, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MandatoryEarlyTermination> validator(ValidatorFactory factory) {
		return factory.<MandatoryEarlyTermination>create(MandatoryEarlyTerminationValidator.class);
	}

	@Override
	public Validator<? super MandatoryEarlyTermination> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MandatoryEarlyTermination>create(MandatoryEarlyTerminationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MandatoryEarlyTermination> validator() {
		return new MandatoryEarlyTerminationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MandatoryEarlyTermination> typeFormatValidator() {
		return new MandatoryEarlyTerminationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MandatoryEarlyTermination, Set<String>> onlyExistsValidator() {
		return new MandatoryEarlyTerminationOnlyExistsValidator();
	}
}
