package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.SettlementPeriodFixingDates;
import fpml.consolidated.fx.targets.validation.SettlementPeriodFixingDatesTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.SettlementPeriodFixingDatesValidator;
import fpml.consolidated.fx.targets.validation.datarule.SettlementPeriodFixingDatesChoice;
import fpml.consolidated.fx.targets.validation.exists.SettlementPeriodFixingDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementPeriodFixingDates.class)
public class SettlementPeriodFixingDatesMeta implements RosettaMetaData<SettlementPeriodFixingDates> {

	@Override
	public List<Validator<? super SettlementPeriodFixingDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SettlementPeriodFixingDates>create(SettlementPeriodFixingDatesChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SettlementPeriodFixingDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementPeriodFixingDates> validator(ValidatorFactory factory) {
		return factory.<SettlementPeriodFixingDates>create(SettlementPeriodFixingDatesValidator.class);
	}

	@Override
	public Validator<? super SettlementPeriodFixingDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementPeriodFixingDates>create(SettlementPeriodFixingDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPeriodFixingDates> validator() {
		return new SettlementPeriodFixingDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPeriodFixingDates> typeFormatValidator() {
		return new SettlementPeriodFixingDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPeriodFixingDates, Set<String>> onlyExistsValidator() {
		return new SettlementPeriodFixingDatesOnlyExistsValidator();
	}
}
