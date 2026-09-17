package fpml.consolidated.repo.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.repo.RelativePrice;
import fpml.consolidated.repo.validation.RelativePriceTypeFormatValidator;
import fpml.consolidated.repo.validation.RelativePriceValidator;
import fpml.consolidated.repo.validation.exists.RelativePriceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=RelativePrice.class)
public class RelativePriceMeta implements RosettaMetaData<RelativePrice> {

	@Override
	public List<Validator<? super RelativePrice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RelativePrice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RelativePrice> validator(ValidatorFactory factory) {
		return factory.<RelativePrice>create(RelativePriceValidator.class);
	}

	@Override
	public Validator<? super RelativePrice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RelativePrice>create(RelativePriceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RelativePrice> validator() {
		return new RelativePriceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RelativePrice> typeFormatValidator() {
		return new RelativePriceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RelativePrice, Set<String>> onlyExistsValidator() {
		return new RelativePriceOnlyExistsValidator();
	}
}
