package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.KeyInfo;
import fpml.consolidated.validation.KeyInfoTypeFormatValidator;
import fpml.consolidated.validation.KeyInfoValidator;
import fpml.consolidated.validation.exists.KeyInfoOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=KeyInfo.class)
public class KeyInfoMeta implements RosettaMetaData<KeyInfo> {

	@Override
	public List<Validator<? super KeyInfo>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super KeyInfo, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super KeyInfo> validator(ValidatorFactory factory) {
		return factory.<KeyInfo>create(KeyInfoValidator.class);
	}

	@Override
	public Validator<? super KeyInfo> typeFormatValidator(ValidatorFactory factory) {
		return factory.<KeyInfo>create(KeyInfoTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super KeyInfo> validator() {
		return new KeyInfoValidator();
	}

	@Deprecated
	@Override
	public Validator<? super KeyInfo> typeFormatValidator() {
		return new KeyInfoTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super KeyInfo, Set<String>> onlyExistsValidator() {
		return new KeyInfoOnlyExistsValidator();
	}
}
