package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ClearingException;
import drr.regulation.common.validation.ClearingExceptionTypeFormatValidator;
import drr.regulation.common.validation.ClearingExceptionValidator;
import drr.regulation.common.validation.datarule.ClearingExceptionClearingException;
import drr.regulation.common.validation.exists.ClearingExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ClearingException.class)
public class ClearingExceptionMeta implements RosettaMetaData<ClearingException> {

	@Override
	public List<Validator<? super ClearingException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ClearingException>create(ClearingExceptionClearingException.class)
		);
	}
	
	@Override
	public List<Function<? super ClearingException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ClearingException> validator(ValidatorFactory factory) {
		return factory.<ClearingException>create(ClearingExceptionValidator.class);
	}

	@Override
	public Validator<? super ClearingException> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ClearingException>create(ClearingExceptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ClearingException> validator() {
		return new ClearingExceptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ClearingException> typeFormatValidator() {
		return new ClearingExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ClearingException, Set<String>> onlyExistsValidator() {
		return new ClearingExceptionOnlyExistsValidator();
	}
}
