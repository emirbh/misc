package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxWeightedFixingSchedule;
import fpml.consolidated.fx.accruals.validation.FxWeightedFixingScheduleTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxWeightedFixingScheduleValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxWeightedFixingScheduleChoice0;
import fpml.consolidated.fx.accruals.validation.datarule.FxWeightedFixingScheduleChoice1;
import fpml.consolidated.fx.accruals.validation.datarule.FxWeightedFixingScheduleChoice2;
import fpml.consolidated.fx.accruals.validation.datarule.FxWeightedFixingScheduleChoice3;
import fpml.consolidated.fx.accruals.validation.datarule.FxWeightedFixingScheduleChoice4;
import fpml.consolidated.fx.accruals.validation.datarule.FxWeightedFixingScheduleChoice5;
import fpml.consolidated.fx.accruals.validation.datarule.FxWeightedFixingScheduleChoice6;
import fpml.consolidated.fx.accruals.validation.datarule.FxWeightedFixingScheduleChoice7;
import fpml.consolidated.fx.accruals.validation.datarule.FxWeightedFixingScheduleChoice8;
import fpml.consolidated.fx.accruals.validation.exists.FxWeightedFixingScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxWeightedFixingSchedule.class)
public class FxWeightedFixingScheduleMeta implements RosettaMetaData<FxWeightedFixingSchedule> {

	@Override
	public List<Validator<? super FxWeightedFixingSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxWeightedFixingSchedule>create(FxWeightedFixingScheduleChoice0.class),
			factory.<FxWeightedFixingSchedule>create(FxWeightedFixingScheduleChoice1.class),
			factory.<FxWeightedFixingSchedule>create(FxWeightedFixingScheduleChoice2.class),
			factory.<FxWeightedFixingSchedule>create(FxWeightedFixingScheduleChoice3.class),
			factory.<FxWeightedFixingSchedule>create(FxWeightedFixingScheduleChoice4.class),
			factory.<FxWeightedFixingSchedule>create(FxWeightedFixingScheduleChoice5.class),
			factory.<FxWeightedFixingSchedule>create(FxWeightedFixingScheduleChoice6.class),
			factory.<FxWeightedFixingSchedule>create(FxWeightedFixingScheduleChoice7.class),
			factory.<FxWeightedFixingSchedule>create(FxWeightedFixingScheduleChoice8.class)
		);
	}
	
	@Override
	public List<Function<? super FxWeightedFixingSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxWeightedFixingSchedule> validator(ValidatorFactory factory) {
		return factory.<FxWeightedFixingSchedule>create(FxWeightedFixingScheduleValidator.class);
	}

	@Override
	public Validator<? super FxWeightedFixingSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxWeightedFixingSchedule>create(FxWeightedFixingScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxWeightedFixingSchedule> validator() {
		return new FxWeightedFixingScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxWeightedFixingSchedule> typeFormatValidator() {
		return new FxWeightedFixingScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxWeightedFixingSchedule, Set<String>> onlyExistsValidator() {
		return new FxWeightedFixingScheduleOnlyExistsValidator();
	}
}
