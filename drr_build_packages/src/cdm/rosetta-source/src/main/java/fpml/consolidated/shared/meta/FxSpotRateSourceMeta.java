package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.FxSpotRateSource;
import fpml.consolidated.shared.validation.FxSpotRateSourceTypeFormatValidator;
import fpml.consolidated.shared.validation.FxSpotRateSourceValidator;
import fpml.consolidated.shared.validation.exists.FxSpotRateSourceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxSpotRateSource.class)
public class FxSpotRateSourceMeta implements RosettaMetaData<FxSpotRateSource> {

	@Override
	public List<Validator<? super FxSpotRateSource>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FxSpotRateSource, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxSpotRateSource> validator(ValidatorFactory factory) {
		return factory.<FxSpotRateSource>create(FxSpotRateSourceValidator.class);
	}

	@Override
	public Validator<? super FxSpotRateSource> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxSpotRateSource>create(FxSpotRateSourceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxSpotRateSource> validator() {
		return new FxSpotRateSourceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxSpotRateSource> typeFormatValidator() {
		return new FxSpotRateSourceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxSpotRateSource, Set<String>> onlyExistsValidator() {
		return new FxSpotRateSourceOnlyExistsValidator();
	}
}
