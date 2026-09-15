package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.IdentifiedRate;
import fpml.consolidated.shared.validation.IdentifiedRateTypeFormatValidator;
import fpml.consolidated.shared.validation.IdentifiedRateValidator;
import fpml.consolidated.shared.validation.exists.IdentifiedRateOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=IdentifiedRate.class)
public class IdentifiedRateMeta implements RosettaMetaData<IdentifiedRate> {

	@Override
	public List<Validator<? super IdentifiedRate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IdentifiedRate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IdentifiedRate> validator(ValidatorFactory factory) {
		return factory.<IdentifiedRate>create(IdentifiedRateValidator.class);
	}

	@Override
	public Validator<? super IdentifiedRate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IdentifiedRate>create(IdentifiedRateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IdentifiedRate> validator() {
		return new IdentifiedRateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IdentifiedRate> typeFormatValidator() {
		return new IdentifiedRateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IdentifiedRate, Set<String>> onlyExistsValidator() {
		return new IdentifiedRateOnlyExistsValidator();
	}
}
