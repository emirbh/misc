package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.SimmException;
import cdm.legaldocumentation.csa.validation.SimmExceptionTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.SimmExceptionValidator;
import cdm.legaldocumentation.csa.validation.exists.SimmExceptionOnlyExistsValidator;
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
@RosettaMeta(model=SimmException.class)
public class SimmExceptionMeta implements RosettaMetaData<SimmException> {

	@Override
	public List<Validator<? super SimmException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SimmException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SimmException> validator(ValidatorFactory factory) {
		return factory.<SimmException>create(SimmExceptionValidator.class);
	}

	@Override
	public Validator<? super SimmException> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SimmException>create(SimmExceptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SimmException> validator() {
		return new SimmExceptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SimmException> typeFormatValidator() {
		return new SimmExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SimmException, Set<String>> onlyExistsValidator() {
		return new SimmExceptionOnlyExistsValidator();
	}
}
