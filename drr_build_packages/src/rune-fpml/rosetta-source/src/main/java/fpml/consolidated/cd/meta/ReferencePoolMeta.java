package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.ReferencePool;
import fpml.consolidated.cd.validation.ReferencePoolTypeFormatValidator;
import fpml.consolidated.cd.validation.ReferencePoolValidator;
import fpml.consolidated.cd.validation.exists.ReferencePoolOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReferencePool.class)
public class ReferencePoolMeta implements RosettaMetaData<ReferencePool> {

	@Override
	public List<Validator<? super ReferencePool>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReferencePool, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReferencePool> validator(ValidatorFactory factory) {
		return factory.<ReferencePool>create(ReferencePoolValidator.class);
	}

	@Override
	public Validator<? super ReferencePool> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReferencePool>create(ReferencePoolTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReferencePool> validator() {
		return new ReferencePoolValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReferencePool> typeFormatValidator() {
		return new ReferencePoolTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReferencePool, Set<String>> onlyExistsValidator() {
		return new ReferencePoolOnlyExistsValidator();
	}
}
