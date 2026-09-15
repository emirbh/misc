package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.OffsetPrevailingTime;
import fpml.consolidated.shared.validation.OffsetPrevailingTimeTypeFormatValidator;
import fpml.consolidated.shared.validation.OffsetPrevailingTimeValidator;
import fpml.consolidated.shared.validation.exists.OffsetPrevailingTimeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=OffsetPrevailingTime.class)
public class OffsetPrevailingTimeMeta implements RosettaMetaData<OffsetPrevailingTime> {

	@Override
	public List<Validator<? super OffsetPrevailingTime>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OffsetPrevailingTime, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super OffsetPrevailingTime> validator(ValidatorFactory factory) {
		return factory.<OffsetPrevailingTime>create(OffsetPrevailingTimeValidator.class);
	}

	@Override
	public Validator<? super OffsetPrevailingTime> typeFormatValidator(ValidatorFactory factory) {
		return factory.<OffsetPrevailingTime>create(OffsetPrevailingTimeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super OffsetPrevailingTime> validator() {
		return new OffsetPrevailingTimeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super OffsetPrevailingTime> typeFormatValidator() {
		return new OffsetPrevailingTimeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OffsetPrevailingTime, Set<String>> onlyExistsValidator() {
		return new OffsetPrevailingTimeOnlyExistsValidator();
	}
}
