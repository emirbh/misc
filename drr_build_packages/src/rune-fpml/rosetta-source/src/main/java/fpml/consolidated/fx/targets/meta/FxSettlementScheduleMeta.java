package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxSchedule;
import fpml.consolidated.fx.targets.FxSettlementSchedule;
import fpml.consolidated.fx.targets.validation.FxSettlementScheduleTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxSettlementScheduleValidator;
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
import fpml.consolidated.fx.targets.validation.exists.FxSettlementScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxSettlementSchedule.class)
public class FxSettlementScheduleMeta implements RosettaMetaData<FxSettlementSchedule> {

	@Override
	public List<Validator<? super FxSettlementSchedule>> dataRules(ValidatorFactory factory) {
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
	public List<Function<? super FxSettlementSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxSettlementSchedule> validator(ValidatorFactory factory) {
		return factory.<FxSettlementSchedule>create(FxSettlementScheduleValidator.class);
	}

	@Override
	public Validator<? super FxSettlementSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxSettlementSchedule>create(FxSettlementScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxSettlementSchedule> validator() {
		return new FxSettlementScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxSettlementSchedule> typeFormatValidator() {
		return new FxSettlementScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSettlementSchedule, Set<String>> onlyExistsValidator() {
		return new FxSettlementScheduleOnlyExistsValidator();
	}
}
