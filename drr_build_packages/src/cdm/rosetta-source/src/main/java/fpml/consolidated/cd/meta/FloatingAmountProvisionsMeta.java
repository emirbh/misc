package fpml.consolidated.cd.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.cd.FloatingAmountProvisions;
import fpml.consolidated.cd.validation.FloatingAmountProvisionsTypeFormatValidator;
import fpml.consolidated.cd.validation.FloatingAmountProvisionsValidator;
import fpml.consolidated.cd.validation.exists.FloatingAmountProvisionsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FloatingAmountProvisions.class)
public class FloatingAmountProvisionsMeta implements RosettaMetaData<FloatingAmountProvisions> {

	@Override
	public List<Validator<? super FloatingAmountProvisions>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingAmountProvisions, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingAmountProvisions> validator(ValidatorFactory factory) {
		return factory.<FloatingAmountProvisions>create(FloatingAmountProvisionsValidator.class);
	}

	@Override
	public Validator<? super FloatingAmountProvisions> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingAmountProvisions>create(FloatingAmountProvisionsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingAmountProvisions> validator() {
		return new FloatingAmountProvisionsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingAmountProvisions> typeFormatValidator() {
		return new FloatingAmountProvisionsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingAmountProvisions, Set<String>> onlyExistsValidator() {
		return new FloatingAmountProvisionsOnlyExistsValidator();
	}
}
