package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.ExecutionLocation;
import cdm.legaldocumentation.csa.validation.ExecutionLocationTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.ExecutionLocationValidator;
import cdm.legaldocumentation.csa.validation.datarule.ExecutionLocationDutyPayerLanguage;
import cdm.legaldocumentation.csa.validation.datarule.ExecutionLocationDutyPaymentLanguage;
import cdm.legaldocumentation.csa.validation.datarule.ExecutionLocationOtherLanguage;
import cdm.legaldocumentation.csa.validation.exists.ExecutionLocationOnlyExistsValidator;
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
@RosettaMeta(model=ExecutionLocation.class)
public class ExecutionLocationMeta implements RosettaMetaData<ExecutionLocation> {

	@Override
	public List<Validator<? super ExecutionLocation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ExecutionLocation>create(ExecutionLocationDutyPayerLanguage.class),
			factory.<ExecutionLocation>create(ExecutionLocationDutyPaymentLanguage.class),
			factory.<ExecutionLocation>create(ExecutionLocationOtherLanguage.class)
		);
	}
	
	@Override
	public List<Function<? super ExecutionLocation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExecutionLocation> validator(ValidatorFactory factory) {
		return factory.<ExecutionLocation>create(ExecutionLocationValidator.class);
	}

	@Override
	public Validator<? super ExecutionLocation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExecutionLocation>create(ExecutionLocationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionLocation> validator() {
		return new ExecutionLocationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExecutionLocation> typeFormatValidator() {
		return new ExecutionLocationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExecutionLocation, Set<String>> onlyExistsValidator() {
		return new ExecutionLocationOnlyExistsValidator();
	}
}
