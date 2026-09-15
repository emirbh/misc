package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.DeClear;
import fpml.consolidated.business.events.validation.DeClearTypeFormatValidator;
import fpml.consolidated.business.events.validation.DeClearValidator;
import fpml.consolidated.business.events.validation.exists.DeClearOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DeClear.class)
public class DeClearMeta implements RosettaMetaData<DeClear> {

	@Override
	public List<Validator<? super DeClear>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DeClear, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DeClear> validator(ValidatorFactory factory) {
		return factory.<DeClear>create(DeClearValidator.class);
	}

	@Override
	public Validator<? super DeClear> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DeClear>create(DeClearTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DeClear> validator() {
		return new DeClearValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DeClear> typeFormatValidator() {
		return new DeClearTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DeClear, Set<String>> onlyExistsValidator() {
		return new DeClearOnlyExistsValidator();
	}
}
