package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.Transform;
import fpml.consolidated.validation.TransformTypeFormatValidator;
import fpml.consolidated.validation.TransformValidator;
import fpml.consolidated.validation.exists.TransformOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Transform.class)
public class TransformMeta implements RosettaMetaData<Transform> {

	@Override
	public List<Validator<? super Transform>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Transform, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Transform> validator(ValidatorFactory factory) {
		return factory.<Transform>create(TransformValidator.class);
	}

	@Override
	public Validator<? super Transform> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Transform>create(TransformTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Transform> validator() {
		return new TransformValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Transform> typeFormatValidator() {
		return new TransformTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Transform, Set<String>> onlyExistsValidator() {
		return new TransformOnlyExistsValidator();
	}
}
