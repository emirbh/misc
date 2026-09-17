package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.EEPRiskPeriod;
import fpml.consolidated.com.validation.EEPRiskPeriodTypeFormatValidator;
import fpml.consolidated.com.validation.EEPRiskPeriodValidator;
import fpml.consolidated.com.validation.exists.EEPRiskPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=EEPRiskPeriod.class)
public class EEPRiskPeriodMeta implements RosettaMetaData<EEPRiskPeriod> {

	@Override
	public List<Validator<? super EEPRiskPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super EEPRiskPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super EEPRiskPeriod> validator(ValidatorFactory factory) {
		return factory.<EEPRiskPeriod>create(EEPRiskPeriodValidator.class);
	}

	@Override
	public Validator<? super EEPRiskPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<EEPRiskPeriod>create(EEPRiskPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super EEPRiskPeriod> validator() {
		return new EEPRiskPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super EEPRiskPeriod> typeFormatValidator() {
		return new EEPRiskPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EEPRiskPeriod, Set<String>> onlyExistsValidator() {
		return new EEPRiskPeriodOnlyExistsValidator();
	}
}
