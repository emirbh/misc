package fpml.consolidated.doc.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.doc.UnprocessedElementWrapper;
import fpml.consolidated.doc.validation.UnprocessedElementWrapperTypeFormatValidator;
import fpml.consolidated.doc.validation.UnprocessedElementWrapperValidator;
import fpml.consolidated.doc.validation.exists.UnprocessedElementWrapperOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=UnprocessedElementWrapper.class)
public class UnprocessedElementWrapperMeta implements RosettaMetaData<UnprocessedElementWrapper> {

	@Override
	public List<Validator<? super UnprocessedElementWrapper>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super UnprocessedElementWrapper, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super UnprocessedElementWrapper> validator(ValidatorFactory factory) {
		return factory.<UnprocessedElementWrapper>create(UnprocessedElementWrapperValidator.class);
	}

	@Override
	public Validator<? super UnprocessedElementWrapper> typeFormatValidator(ValidatorFactory factory) {
		return factory.<UnprocessedElementWrapper>create(UnprocessedElementWrapperTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super UnprocessedElementWrapper> validator() {
		return new UnprocessedElementWrapperValidator();
	}

	@Deprecated
	@Override
	public Validator<? super UnprocessedElementWrapper> typeFormatValidator() {
		return new UnprocessedElementWrapperTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super UnprocessedElementWrapper, Set<String>> onlyExistsValidator() {
		return new UnprocessedElementWrapperOnlyExistsValidator();
	}
}
