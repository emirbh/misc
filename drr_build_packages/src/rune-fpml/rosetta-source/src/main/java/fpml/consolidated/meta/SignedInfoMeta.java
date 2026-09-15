package fpml.consolidated.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.SignedInfo;
import fpml.consolidated.validation.SignedInfoTypeFormatValidator;
import fpml.consolidated.validation.SignedInfoValidator;
import fpml.consolidated.validation.exists.SignedInfoOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SignedInfo.class)
public class SignedInfoMeta implements RosettaMetaData<SignedInfo> {

	@Override
	public List<Validator<? super SignedInfo>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SignedInfo, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SignedInfo> validator(ValidatorFactory factory) {
		return factory.<SignedInfo>create(SignedInfoValidator.class);
	}

	@Override
	public Validator<? super SignedInfo> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SignedInfo>create(SignedInfoTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SignedInfo> validator() {
		return new SignedInfoValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SignedInfo> typeFormatValidator() {
		return new SignedInfoTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SignedInfo, Set<String>> onlyExistsValidator() {
		return new SignedInfoOnlyExistsValidator();
	}
}
