package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.FxTargetSettlementPeriodSchedule;
import fpml.consolidated.fx.targets.validation.FxTargetSettlementPeriodScheduleTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.FxTargetSettlementPeriodScheduleValidator;
import fpml.consolidated.fx.targets.validation.exists.FxTargetSettlementPeriodScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxTargetSettlementPeriodSchedule.class)
public class FxTargetSettlementPeriodScheduleMeta implements RosettaMetaData<FxTargetSettlementPeriodSchedule> {

	@Override
	public List<Validator<? super FxTargetSettlementPeriodSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxTargetSettlementPeriodSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxTargetSettlementPeriodSchedule> validator(ValidatorFactory factory) {
		return factory.<FxTargetSettlementPeriodSchedule>create(FxTargetSettlementPeriodScheduleValidator.class);
	}

	@Override
	public Validator<? super FxTargetSettlementPeriodSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxTargetSettlementPeriodSchedule>create(FxTargetSettlementPeriodScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetSettlementPeriodSchedule> validator() {
		return new FxTargetSettlementPeriodScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxTargetSettlementPeriodSchedule> typeFormatValidator() {
		return new FxTargetSettlementPeriodScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxTargetSettlementPeriodSchedule, Set<String>> onlyExistsValidator() {
		return new FxTargetSettlementPeriodScheduleOnlyExistsValidator();
	}
}
