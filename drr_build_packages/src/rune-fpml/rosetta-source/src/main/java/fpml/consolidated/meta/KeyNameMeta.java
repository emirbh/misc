package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.KeyName;
import fpml.consolidated.validation.KeyNameTypeFormatValidator;
import fpml.consolidated.validation.KeyNameValidator;
import fpml.consolidated.validation.exists.KeyNameOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=KeyName.class)
public class KeyNameMeta implements RosettaMetaData<KeyName> {

	@Override
	public List<Validator<? super KeyName>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super KeyName, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super KeyName> validator(ValidatorFactory factory) {
		return factory.<KeyName>create(KeyNameValidator.class);
	}

	@Override
	public Validator<? super KeyName> typeFormatValidator(ValidatorFactory factory) {
		return factory.<KeyName>create(KeyNameTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super KeyName> validator() {
		return new KeyNameValidator();
	}

	@Deprecated
	@Override
	public Validator<? super KeyName> typeFormatValidator() {
		return new KeyNameTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super KeyName, Set<String>> onlyExistsValidator() {
		return new KeyNameOnlyExistsValidator();
	}
}
