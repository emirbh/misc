package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.PriceSourceDisruption;
import fpml.consolidated.ird.validation.PriceSourceDisruptionTypeFormatValidator;
import fpml.consolidated.ird.validation.PriceSourceDisruptionValidator;
import fpml.consolidated.ird.validation.exists.PriceSourceDisruptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=PriceSourceDisruption.class)
public class PriceSourceDisruptionMeta implements RosettaMetaData<PriceSourceDisruption> {

	@Override
	public List<Validator<? super PriceSourceDisruption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PriceSourceDisruption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PriceSourceDisruption> validator(ValidatorFactory factory) {
		return factory.<PriceSourceDisruption>create(PriceSourceDisruptionValidator.class);
	}

	@Override
	public Validator<? super PriceSourceDisruption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PriceSourceDisruption>create(PriceSourceDisruptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PriceSourceDisruption> validator() {
		return new PriceSourceDisruptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PriceSourceDisruption> typeFormatValidator() {
		return new PriceSourceDisruptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PriceSourceDisruption, Set<String>> onlyExistsValidator() {
		return new PriceSourceDisruptionOnlyExistsValidator();
	}
}
