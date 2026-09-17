package fpml.consolidated.fx.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.Postponement;
import fpml.consolidated.fx.validation.PostponementTypeFormatValidator;
import fpml.consolidated.fx.validation.PostponementValidator;
import fpml.consolidated.fx.validation.exists.PostponementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Postponement.class)
public class PostponementMeta implements RosettaMetaData<Postponement> {

	@Override
	public List<Validator<? super Postponement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Postponement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Postponement> validator(ValidatorFactory factory) {
		return factory.<Postponement>create(PostponementValidator.class);
	}

	@Override
	public Validator<? super Postponement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Postponement>create(PostponementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Postponement> validator() {
		return new PostponementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Postponement> typeFormatValidator() {
		return new PostponementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Postponement, Set<String>> onlyExistsValidator() {
		return new PostponementOnlyExistsValidator();
	}
}
