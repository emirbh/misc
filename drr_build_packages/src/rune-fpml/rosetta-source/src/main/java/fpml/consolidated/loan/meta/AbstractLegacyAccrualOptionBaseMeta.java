package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractLegacyAccrualOptionBase;
import fpml.consolidated.loan.validation.AbstractLegacyAccrualOptionBaseTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractLegacyAccrualOptionBaseValidator;
import fpml.consolidated.loan.validation.exists.AbstractLegacyAccrualOptionBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractLegacyAccrualOptionBase.class)
public class AbstractLegacyAccrualOptionBaseMeta implements RosettaMetaData<AbstractLegacyAccrualOptionBase> {

	@Override
	public List<Validator<? super AbstractLegacyAccrualOptionBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractLegacyAccrualOptionBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractLegacyAccrualOptionBase> validator(ValidatorFactory factory) {
		return factory.<AbstractLegacyAccrualOptionBase>create(AbstractLegacyAccrualOptionBaseValidator.class);
	}

	@Override
	public Validator<? super AbstractLegacyAccrualOptionBase> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractLegacyAccrualOptionBase>create(AbstractLegacyAccrualOptionBaseTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLegacyAccrualOptionBase> validator() {
		return new AbstractLegacyAccrualOptionBaseValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractLegacyAccrualOptionBase> typeFormatValidator() {
		return new AbstractLegacyAccrualOptionBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractLegacyAccrualOptionBase, Set<String>> onlyExistsValidator() {
		return new AbstractLegacyAccrualOptionBaseOnlyExistsValidator();
	}
}
