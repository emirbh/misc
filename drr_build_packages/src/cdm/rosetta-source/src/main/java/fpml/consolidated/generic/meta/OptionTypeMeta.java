package fpml.consolidated.generic.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.generic.OptionType;
import fpml.consolidated.generic.validation.OptionTypeTypeFormatValidator;
import fpml.consolidated.generic.validation.OptionTypeValidator;
import fpml.consolidated.generic.validation.exists.OptionTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OptionType.class)
public class OptionTypeMeta implements RosettaMetaData<OptionType> {

	@Override
	public List<Validator<? super OptionType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OptionType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OptionType> validator(ValidatorFactory factory) {
		return factory.<OptionType>create(OptionTypeValidator.class);
	}

	@Override
	public Validator<? super OptionType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OptionType>create(OptionTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OptionType> validator() {
		return new OptionTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OptionType> typeFormatValidator() {
		return new OptionTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OptionType, Set<String>> onlyExistsValidator() {
		return new OptionTypeOnlyExistsValidator();
	}
}
