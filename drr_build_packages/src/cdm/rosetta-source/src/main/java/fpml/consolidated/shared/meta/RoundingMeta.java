package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.Rounding;
import fpml.consolidated.shared.validation.RoundingTypeFormatValidator;
import fpml.consolidated.shared.validation.RoundingValidator;
import fpml.consolidated.shared.validation.exists.RoundingOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Rounding.class)
public class RoundingMeta implements RosettaMetaData<Rounding> {

	@Override
	public List<Validator<? super Rounding>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Rounding, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Rounding> validator(ValidatorFactory factory) {
		return factory.<Rounding>create(RoundingValidator.class);
	}

	@Override
	public Validator<? super Rounding> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Rounding>create(RoundingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Rounding> validator() {
		return new RoundingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Rounding> typeFormatValidator() {
		return new RoundingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Rounding, Set<String>> onlyExistsValidator() {
		return new RoundingOnlyExistsValidator();
	}
}
