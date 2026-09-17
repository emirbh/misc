package fpml.consolidated.fx.targets.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.fx.targets.SettlementPeriod;
import fpml.consolidated.fx.targets.validation.SettlementPeriodTypeFormatValidator;
import fpml.consolidated.fx.targets.validation.SettlementPeriodValidator;
import fpml.consolidated.fx.targets.validation.exists.SettlementPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=SettlementPeriod.class)
public class SettlementPeriodMeta implements RosettaMetaData<SettlementPeriod> {

	@Override
	public List<Validator<? super SettlementPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SettlementPeriod> validator(ValidatorFactory factory) {
		return factory.<SettlementPeriod>create(SettlementPeriodValidator.class);
	}

	@Override
	public Validator<? super SettlementPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SettlementPeriod>create(SettlementPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPeriod> validator() {
		return new SettlementPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SettlementPeriod> typeFormatValidator() {
		return new SettlementPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementPeriod, Set<String>> onlyExistsValidator() {
		return new SettlementPeriodOnlyExistsValidator();
	}
}
