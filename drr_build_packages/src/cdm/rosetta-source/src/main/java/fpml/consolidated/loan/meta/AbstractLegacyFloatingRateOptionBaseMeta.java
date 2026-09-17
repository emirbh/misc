package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLegacyFloatingRateOptionBase;
import fpml.consolidated.loan.validation.AbstractLegacyFloatingRateOptionBaseTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLegacyFloatingRateOptionBaseValidator;
import fpml.consolidated.loan.validation.exists.AbstractLegacyFloatingRateOptionBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLegacyFloatingRateOptionBase.class)
public class AbstractLegacyFloatingRateOptionBaseMeta implements RosettaMetaData<AbstractLegacyFloatingRateOptionBase> {

	@Override
	public List<Validator<? super AbstractLegacyFloatingRateOptionBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLegacyFloatingRateOptionBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLegacyFloatingRateOptionBase> validator(ValidatorFactory factory) {
		return factory.<AbstractLegacyFloatingRateOptionBase>create(AbstractLegacyFloatingRateOptionBaseValidator.class);
	}

	@Override
	public Validator<? super AbstractLegacyFloatingRateOptionBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLegacyFloatingRateOptionBase>create(AbstractLegacyFloatingRateOptionBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLegacyFloatingRateOptionBase> validator() {
		return new AbstractLegacyFloatingRateOptionBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLegacyFloatingRateOptionBase> typeFormatValidator() {
		return new AbstractLegacyFloatingRateOptionBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLegacyFloatingRateOptionBase, Set<String>> onlyExistsValidator() {
		return new AbstractLegacyFloatingRateOptionBaseOnlyExistsValidator();
	}
}
