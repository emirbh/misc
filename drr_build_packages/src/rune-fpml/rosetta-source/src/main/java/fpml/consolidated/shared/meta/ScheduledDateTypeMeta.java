package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ScheduledDateType;
import fpml.consolidated.shared.validation.ScheduledDateTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.ScheduledDateTypeValidator;
import fpml.consolidated.shared.validation.exists.ScheduledDateTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ScheduledDateType.class)
public class ScheduledDateTypeMeta implements RosettaMetaData<ScheduledDateType> {

	@Override
	public List<Validator<? super ScheduledDateType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ScheduledDateType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ScheduledDateType> validator(ValidatorFactory factory) {
		return factory.<ScheduledDateType>create(ScheduledDateTypeValidator.class);
	}

	@Override
	public Validator<? super ScheduledDateType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ScheduledDateType>create(ScheduledDateTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ScheduledDateType> validator() {
		return new ScheduledDateTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ScheduledDateType> typeFormatValidator() {
		return new ScheduledDateTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ScheduledDateType, Set<String>> onlyExistsValidator() {
		return new ScheduledDateTypeOnlyExistsValidator();
	}
}
