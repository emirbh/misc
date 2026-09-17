package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.SettlementPeriodsStep;
import fpml.consolidated.com.validation.SettlementPeriodsStepTypeFormatValidator;
import fpml.consolidated.com.validation.SettlementPeriodsStepValidator;
import fpml.consolidated.com.validation.exists.SettlementPeriodsStepOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementPeriodsStep.class)
public class SettlementPeriodsStepMeta implements RosettaMetaData<SettlementPeriodsStep> {

	@Override
	public List<Validator<? super SettlementPeriodsStep>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementPeriodsStep, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementPeriodsStep> validator(ValidatorFactory factory) {
		return factory.<SettlementPeriodsStep>create(SettlementPeriodsStepValidator.class);
	}

	@Override
	public Validator<? super SettlementPeriodsStep> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementPeriodsStep>create(SettlementPeriodsStepTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPeriodsStep> validator() {
		return new SettlementPeriodsStepValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPeriodsStep> typeFormatValidator() {
		return new SettlementPeriodsStepTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPeriodsStep, Set<String>> onlyExistsValidator() {
		return new SettlementPeriodsStepOnlyExistsValidator();
	}
}
