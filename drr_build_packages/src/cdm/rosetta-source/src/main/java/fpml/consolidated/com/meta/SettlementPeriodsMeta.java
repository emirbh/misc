package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.SettlementPeriods;
import fpml.consolidated.com.validation.SettlementPeriodsTypeFormatValidator;
import fpml.consolidated.com.validation.SettlementPeriodsValidator;
import fpml.consolidated.com.validation.datarule.SettlementPeriodsChoice;
import fpml.consolidated.com.validation.exists.SettlementPeriodsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementPeriods.class)
public class SettlementPeriodsMeta implements RosettaMetaData<SettlementPeriods> {

	@Override
	public List<Validator<? super SettlementPeriods>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SettlementPeriods>create(SettlementPeriodsChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SettlementPeriods, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementPeriods> validator(ValidatorFactory factory) {
		return factory.<SettlementPeriods>create(SettlementPeriodsValidator.class);
	}

	@Override
	public Validator<? super SettlementPeriods> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementPeriods>create(SettlementPeriodsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPeriods> validator() {
		return new SettlementPeriodsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPeriods> typeFormatValidator() {
		return new SettlementPeriodsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPeriods, Set<String>> onlyExistsValidator() {
		return new SettlementPeriodsOnlyExistsValidator();
	}
}
