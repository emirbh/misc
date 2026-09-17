package fpml.consolidated.msg.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.msg.ExceptionMessageHeader;
import fpml.consolidated.msg.validation.ExceptionMessageHeaderTypeFormatValidator;
import fpml.consolidated.msg.validation.ExceptionMessageHeaderValidator;
import fpml.consolidated.msg.validation.exists.ExceptionMessageHeaderOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ExceptionMessageHeader.class)
public class ExceptionMessageHeaderMeta implements RosettaMetaData<ExceptionMessageHeader> {

	@Override
	public List<Validator<? super ExceptionMessageHeader>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ExceptionMessageHeader, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExceptionMessageHeader> validator(ValidatorFactory factory) {
		return factory.<ExceptionMessageHeader>create(ExceptionMessageHeaderValidator.class);
	}

	@Override
	public Validator<? super ExceptionMessageHeader> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExceptionMessageHeader>create(ExceptionMessageHeaderTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExceptionMessageHeader> validator() {
		return new ExceptionMessageHeaderValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExceptionMessageHeader> typeFormatValidator() {
		return new ExceptionMessageHeaderTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExceptionMessageHeader, Set<String>> onlyExistsValidator() {
		return new ExceptionMessageHeaderOnlyExistsValidator();
	}
}
