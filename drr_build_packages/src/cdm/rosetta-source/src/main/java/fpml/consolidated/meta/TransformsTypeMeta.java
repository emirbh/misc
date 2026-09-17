package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.TransformsType;
import fpml.consolidated.validation.TransformsTypeTypeFormatValidator;
import fpml.consolidated.validation.TransformsTypeValidator;
import fpml.consolidated.validation.exists.TransformsTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=TransformsType.class)
public class TransformsTypeMeta implements RosettaMetaData<TransformsType> {

	@Override
	public List<Validator<? super TransformsType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TransformsType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super TransformsType> validator(ValidatorFactory factory) {
		return factory.<TransformsType>create(TransformsTypeValidator.class);
	}

	@Override
	public Validator<? super TransformsType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<TransformsType>create(TransformsTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super TransformsType> validator() {
		return new TransformsTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super TransformsType> typeFormatValidator() {
		return new TransformsTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TransformsType, Set<String>> onlyExistsValidator() {
		return new TransformsTypeOnlyExistsValidator();
	}
}
