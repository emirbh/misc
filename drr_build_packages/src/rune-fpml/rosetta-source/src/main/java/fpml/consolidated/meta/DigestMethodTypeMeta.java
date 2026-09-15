package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.DigestMethodType;
import fpml.consolidated.validation.DigestMethodTypeTypeFormatValidator;
import fpml.consolidated.validation.DigestMethodTypeValidator;
import fpml.consolidated.validation.exists.DigestMethodTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DigestMethodType.class)
public class DigestMethodTypeMeta implements RosettaMetaData<DigestMethodType> {

	@Override
	public List<Validator<? super DigestMethodType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DigestMethodType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DigestMethodType> validator(ValidatorFactory factory) {
		return factory.<DigestMethodType>create(DigestMethodTypeValidator.class);
	}

	@Override
	public Validator<? super DigestMethodType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DigestMethodType>create(DigestMethodTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DigestMethodType> validator() {
		return new DigestMethodTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DigestMethodType> typeFormatValidator() {
		return new DigestMethodTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DigestMethodType, Set<String>> onlyExistsValidator() {
		return new DigestMethodTypeOnlyExistsValidator();
	}
}
