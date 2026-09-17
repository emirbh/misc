package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.InitialMargin;
import fpml.consolidated.repo.validation.InitialMarginTypeFormatValidator;
import fpml.consolidated.repo.validation.InitialMarginValidator;
import fpml.consolidated.repo.validation.exists.InitialMarginOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=InitialMargin.class)
public class InitialMarginMeta implements RosettaMetaData<InitialMargin> {

	@Override
	public List<Validator<? super InitialMargin>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super InitialMargin, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super InitialMargin> validator(ValidatorFactory factory) {
		return factory.<InitialMargin>create(InitialMarginValidator.class);
	}

	@Override
	public Validator<? super InitialMargin> typeFormatValidator(ValidatorFactory factory) {
		return factory.<InitialMargin>create(InitialMarginTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super InitialMargin> validator() {
		return new InitialMarginValidator();
	}

	@Deprecated
	@Override
	public Validator<? super InitialMargin> typeFormatValidator() {
		return new InitialMarginTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super InitialMargin, Set<String>> onlyExistsValidator() {
		return new InitialMarginOnlyExistsValidator();
	}
}
