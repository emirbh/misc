package fpml.consolidated.fx.accruals.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.accruals.FxAccrualSettlementPeriodSchedule;
import fpml.consolidated.fx.accruals.validation.FxAccrualSettlementPeriodScheduleTypeFormatValidator;
import fpml.consolidated.fx.accruals.validation.FxAccrualSettlementPeriodScheduleValidator;
import fpml.consolidated.fx.accruals.validation.exists.FxAccrualSettlementPeriodScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxAccrualSettlementPeriodSchedule.class)
public class FxAccrualSettlementPeriodScheduleMeta implements RosettaMetaData<FxAccrualSettlementPeriodSchedule> {

	@Override
	public List<Validator<? super FxAccrualSettlementPeriodSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxAccrualSettlementPeriodSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxAccrualSettlementPeriodSchedule> validator(ValidatorFactory factory) {
		return factory.<FxAccrualSettlementPeriodSchedule>create(FxAccrualSettlementPeriodScheduleValidator.class);
	}

	@Override
	public Validator<? super FxAccrualSettlementPeriodSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxAccrualSettlementPeriodSchedule>create(FxAccrualSettlementPeriodScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualSettlementPeriodSchedule> validator() {
		return new FxAccrualSettlementPeriodScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxAccrualSettlementPeriodSchedule> typeFormatValidator() {
		return new FxAccrualSettlementPeriodScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualSettlementPeriodSchedule, Set<String>> onlyExistsValidator() {
		return new FxAccrualSettlementPeriodScheduleOnlyExistsValidator();
	}
}
