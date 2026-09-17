package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.Transforms;
import fpml.consolidated.validation.TransformsTypeFormatValidator;
import fpml.consolidated.validation.TransformsValidator;
import fpml.consolidated.validation.exists.TransformsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Transforms.class)
public class TransformsMeta implements RosettaMetaData<Transforms> {

	@Override
	public List<Validator<? super Transforms>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Transforms, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Transforms> validator(ValidatorFactory factory) {
		return factory.<Transforms>create(TransformsValidator.class);
	}

	@Override
	public Validator<? super Transforms> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Transforms>create(TransformsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Transforms> validator() {
		return new TransformsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Transforms> typeFormatValidator() {
		return new TransformsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Transforms, Set<String>> onlyExistsValidator() {
		return new TransformsOnlyExistsValidator();
	}
}
