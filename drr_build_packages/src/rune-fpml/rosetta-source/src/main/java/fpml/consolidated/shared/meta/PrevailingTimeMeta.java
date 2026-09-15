package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.PrevailingTime;
import fpml.consolidated.shared.validation.PrevailingTimeTypeFormatValidator;
import fpml.consolidated.shared.validation.PrevailingTimeValidator;
import fpml.consolidated.shared.validation.exists.PrevailingTimeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PrevailingTime.class)
public class PrevailingTimeMeta implements RosettaMetaData<PrevailingTime> {

	@Override
	public List<Validator<? super PrevailingTime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PrevailingTime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PrevailingTime> validator(ValidatorFactory factory) {
		return factory.<PrevailingTime>create(PrevailingTimeValidator.class);
	}

	@Override
	public Validator<? super PrevailingTime> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PrevailingTime>create(PrevailingTimeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PrevailingTime> validator() {
		return new PrevailingTimeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PrevailingTime> typeFormatValidator() {
		return new PrevailingTimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PrevailingTime, Set<String>> onlyExistsValidator() {
		return new PrevailingTimeOnlyExistsValidator();
	}
}
