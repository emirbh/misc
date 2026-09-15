package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.ForecastRateIndex;
import fpml.consolidated.shared.validation.ForecastRateIndexTypeFormatValidator;
import fpml.consolidated.shared.validation.ForecastRateIndexValidator;
import fpml.consolidated.shared.validation.exists.ForecastRateIndexOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ForecastRateIndex.class)
public class ForecastRateIndexMeta implements RosettaMetaData<ForecastRateIndex> {

	@Override
	public List<Validator<? super ForecastRateIndex>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ForecastRateIndex, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ForecastRateIndex> validator(ValidatorFactory factory) {
		return factory.<ForecastRateIndex>create(ForecastRateIndexValidator.class);
	}

	@Override
	public Validator<? super ForecastRateIndex> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ForecastRateIndex>create(ForecastRateIndexTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ForecastRateIndex> validator() {
		return new ForecastRateIndexValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ForecastRateIndex> typeFormatValidator() {
		return new ForecastRateIndexTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ForecastRateIndex, Set<String>> onlyExistsValidator() {
		return new ForecastRateIndexOnlyExistsValidator();
	}
}
