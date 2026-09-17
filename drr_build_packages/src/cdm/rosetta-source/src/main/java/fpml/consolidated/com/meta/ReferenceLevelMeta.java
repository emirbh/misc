package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.ReferenceLevel;
import fpml.consolidated.com.validation.ReferenceLevelTypeFormatValidator;
import fpml.consolidated.com.validation.ReferenceLevelValidator;
import fpml.consolidated.com.validation.exists.ReferenceLevelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReferenceLevel.class)
public class ReferenceLevelMeta implements RosettaMetaData<ReferenceLevel> {

	@Override
	public List<Validator<? super ReferenceLevel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReferenceLevel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReferenceLevel> validator(ValidatorFactory factory) {
		return factory.<ReferenceLevel>create(ReferenceLevelValidator.class);
	}

	@Override
	public Validator<? super ReferenceLevel> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReferenceLevel>create(ReferenceLevelTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReferenceLevel> validator() {
		return new ReferenceLevelValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReferenceLevel> typeFormatValidator() {
		return new ReferenceLevelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferenceLevel, Set<String>> onlyExistsValidator() {
		return new ReferenceLevelOnlyExistsValidator();
	}
}
