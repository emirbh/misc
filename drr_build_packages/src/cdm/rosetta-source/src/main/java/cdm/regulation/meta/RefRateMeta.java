package cdm.regulation.meta;

import cdm.regulation.RefRate;
import cdm.regulation.validation.RefRateTypeFormatValidator;
import cdm.regulation.validation.RefRateValidator;
import cdm.regulation.validation.exists.RefRateOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=RefRate.class)
public class RefRateMeta implements RosettaMetaData<RefRate> {

	@Override
	public List<Validator<? super RefRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RefRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RefRate> validator(ValidatorFactory factory) {
		return factory.<RefRate>create(RefRateValidator.class);
	}

	@Override
	public Validator<? super RefRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RefRate>create(RefRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RefRate> validator() {
		return new RefRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RefRate> typeFormatValidator() {
		return new RefRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RefRate, Set<String>> onlyExistsValidator() {
		return new RefRateOnlyExistsValidator();
	}
}
