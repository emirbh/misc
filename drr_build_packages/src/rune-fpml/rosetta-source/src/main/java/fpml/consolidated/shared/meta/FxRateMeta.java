package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.FxRate;
import fpml.consolidated.shared.validation.FxRateTypeFormatValidator;
import fpml.consolidated.shared.validation.FxRateValidator;
import fpml.consolidated.shared.validation.exists.FxRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxRate.class)
public class FxRateMeta implements RosettaMetaData<FxRate> {

	@Override
	public List<Validator<? super FxRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxRate> validator(ValidatorFactory factory) {
		return factory.<FxRate>create(FxRateValidator.class);
	}

	@Override
	public Validator<? super FxRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxRate>create(FxRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxRate> validator() {
		return new FxRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxRate> typeFormatValidator() {
		return new FxRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxRate, Set<String>> onlyExistsValidator() {
		return new FxRateOnlyExistsValidator();
	}
}
