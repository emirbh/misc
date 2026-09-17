package fpml.consolidated.option.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.option.shared.MarketDisruption;
import fpml.consolidated.option.shared.validation.MarketDisruptionTypeFormatValidator;
import fpml.consolidated.option.shared.validation.MarketDisruptionValidator;
import fpml.consolidated.option.shared.validation.exists.MarketDisruptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MarketDisruption.class)
public class MarketDisruptionMeta implements RosettaMetaData<MarketDisruption> {

	@Override
	public List<Validator<? super MarketDisruption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MarketDisruption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MarketDisruption> validator(ValidatorFactory factory) {
		return factory.<MarketDisruption>create(MarketDisruptionValidator.class);
	}

	@Override
	public Validator<? super MarketDisruption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MarketDisruption>create(MarketDisruptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MarketDisruption> validator() {
		return new MarketDisruptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MarketDisruption> typeFormatValidator() {
		return new MarketDisruptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MarketDisruption, Set<String>> onlyExistsValidator() {
		return new MarketDisruptionOnlyExistsValidator();
	}
}
