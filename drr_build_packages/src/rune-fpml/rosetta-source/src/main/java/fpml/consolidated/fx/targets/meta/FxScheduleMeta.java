package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxSchedule;
import fpml.consolidated.fx.targets.validation.FxScheduleTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxScheduleValidator;
import fpml.consolidated.fx.targets.validation.datarule.FxScheduleChoice0;
import fpml.consolidated.fx.targets.validation.datarule.FxScheduleChoice1;
import fpml.consolidated.fx.targets.validation.datarule.FxScheduleChoice2;
import fpml.consolidated.fx.targets.validation.datarule.FxScheduleChoice3;
import fpml.consolidated.fx.targets.validation.datarule.FxScheduleChoice4;
import fpml.consolidated.fx.targets.validation.datarule.FxScheduleChoice5;
import fpml.consolidated.fx.targets.validation.datarule.FxScheduleChoice6;
import fpml.consolidated.fx.targets.validation.datarule.FxScheduleChoice7;
import fpml.consolidated.fx.targets.validation.datarule.FxScheduleChoice8;
import fpml.consolidated.fx.targets.validation.datarule.FxScheduleChoice9;
import fpml.consolidated.fx.targets.validation.exists.FxScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxSchedule.class)
public class FxScheduleMeta implements RosettaMetaData<FxSchedule> {

	@Override
	public List<Validator<? super FxSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxSchedule>create(FxScheduleChoice0.class),
			factory.<FxSchedule>create(FxScheduleChoice1.class),
			factory.<FxSchedule>create(FxScheduleChoice2.class),
			factory.<FxSchedule>create(FxScheduleChoice3.class),
			factory.<FxSchedule>create(FxScheduleChoice4.class),
			factory.<FxSchedule>create(FxScheduleChoice5.class),
			factory.<FxSchedule>create(FxScheduleChoice6.class),
			factory.<FxSchedule>create(FxScheduleChoice7.class),
			factory.<FxSchedule>create(FxScheduleChoice8.class),
			factory.<FxSchedule>create(FxScheduleChoice9.class)
		);
	}
	
	@Override
	public List<Function<? super FxSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxSchedule> validator(ValidatorFactory factory) {
		return factory.<FxSchedule>create(FxScheduleValidator.class);
	}

	@Override
	public Validator<? super FxSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxSchedule>create(FxScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxSchedule> validator() {
		return new FxScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxSchedule> typeFormatValidator() {
		return new FxScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSchedule, Set<String>> onlyExistsValidator() {
		return new FxScheduleOnlyExistsValidator();
	}
}
