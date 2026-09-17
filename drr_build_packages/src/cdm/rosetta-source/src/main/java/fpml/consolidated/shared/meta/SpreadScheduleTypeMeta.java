package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.SpreadScheduleType;
import fpml.consolidated.shared.validation.SpreadScheduleTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.SpreadScheduleTypeValidator;
import fpml.consolidated.shared.validation.exists.SpreadScheduleTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SpreadScheduleType.class)
public class SpreadScheduleTypeMeta implements RosettaMetaData<SpreadScheduleType> {

	@Override
	public List<Validator<? super SpreadScheduleType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SpreadScheduleType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SpreadScheduleType> validator(ValidatorFactory factory) {
		return factory.<SpreadScheduleType>create(SpreadScheduleTypeValidator.class);
	}

	@Override
	public Validator<? super SpreadScheduleType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SpreadScheduleType>create(SpreadScheduleTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SpreadScheduleType> validator() {
		return new SpreadScheduleTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SpreadScheduleType> typeFormatValidator() {
		return new SpreadScheduleTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SpreadScheduleType, Set<String>> onlyExistsValidator() {
		return new SpreadScheduleTypeOnlyExistsValidator();
	}
}
