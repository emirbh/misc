package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxFixingSchedule;
import fpml.consolidated.fx.accruals.validation.FxFixingScheduleTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxFixingScheduleValidator;
import fpml.consolidated.fx.accruals.validation.datarule.FxFixingScheduleChoice0;
import fpml.consolidated.fx.accruals.validation.datarule.FxFixingScheduleChoice1;
import fpml.consolidated.fx.accruals.validation.datarule.FxFixingScheduleChoice2;
import fpml.consolidated.fx.accruals.validation.datarule.FxFixingScheduleChoice3;
import fpml.consolidated.fx.accruals.validation.datarule.FxFixingScheduleChoice4;
import fpml.consolidated.fx.accruals.validation.datarule.FxFixingScheduleChoice5;
import fpml.consolidated.fx.accruals.validation.datarule.FxFixingScheduleChoice6;
import fpml.consolidated.fx.accruals.validation.datarule.FxFixingScheduleChoice7;
import fpml.consolidated.fx.accruals.validation.datarule.FxFixingScheduleChoice8;
import fpml.consolidated.fx.accruals.validation.exists.FxFixingScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxFixingSchedule.class)
public class FxFixingScheduleMeta implements RosettaMetaData<FxFixingSchedule> {

	@Override
	public List<Validator<? super FxFixingSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxFixingSchedule>create(FxFixingScheduleChoice0.class),
			factory.<FxFixingSchedule>create(FxFixingScheduleChoice1.class),
			factory.<FxFixingSchedule>create(FxFixingScheduleChoice2.class),
			factory.<FxFixingSchedule>create(FxFixingScheduleChoice3.class),
			factory.<FxFixingSchedule>create(FxFixingScheduleChoice4.class),
			factory.<FxFixingSchedule>create(FxFixingScheduleChoice5.class),
			factory.<FxFixingSchedule>create(FxFixingScheduleChoice6.class),
			factory.<FxFixingSchedule>create(FxFixingScheduleChoice7.class),
			factory.<FxFixingSchedule>create(FxFixingScheduleChoice8.class)
		);
	}
	
	@Override
	public List<Function<? super FxFixingSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxFixingSchedule> validator(ValidatorFactory factory) {
		return factory.<FxFixingSchedule>create(FxFixingScheduleValidator.class);
	}

	@Override
	public Validator<? super FxFixingSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxFixingSchedule>create(FxFixingScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxFixingSchedule> validator() {
		return new FxFixingScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxFixingSchedule> typeFormatValidator() {
		return new FxFixingScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxFixingSchedule, Set<String>> onlyExistsValidator() {
		return new FxFixingScheduleOnlyExistsValidator();
	}
}
