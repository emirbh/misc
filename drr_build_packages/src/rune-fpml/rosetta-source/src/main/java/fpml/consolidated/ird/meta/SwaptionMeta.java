package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.Swaption;
import fpml.consolidated.ird.validation.SwaptionTypeFormatValidator;
import fpml.consolidated.ird.validation.SwaptionValidator;
import fpml.consolidated.ird.validation.datarule.SwaptionChoice;
import fpml.consolidated.ird.validation.exists.SwaptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=Swaption.class)
public class SwaptionMeta implements RosettaMetaData<Swaption> {

	@Override
	public List<Validator<? super Swaption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Swaption>create(SwaptionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Swaption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Swaption> validator(ValidatorFactory factory) {
		return factory.<Swaption>create(SwaptionValidator.class);
	}

	@Override
	public Validator<? super Swaption> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Swaption>create(SwaptionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Swaption> validator() {
		return new SwaptionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Swaption> typeFormatValidator() {
		return new SwaptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Swaption, Set<String>> onlyExistsValidator() {
		return new SwaptionOnlyExistsValidator();
	}
}
