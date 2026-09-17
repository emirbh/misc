package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.FxConversion;
import fpml.consolidated.asset.validation.FxConversionTypeFormatValidator;
import fpml.consolidated.asset.validation.FxConversionValidator;
import fpml.consolidated.asset.validation.datarule.FxConversionChoice;
import fpml.consolidated.asset.validation.exists.FxConversionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FxConversion.class)
public class FxConversionMeta implements RosettaMetaData<FxConversion> {

	@Override
	public List<Validator<? super FxConversion>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FxConversion>create(FxConversionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxConversion, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FxConversion> validator(ValidatorFactory factory) {
		return factory.<FxConversion>create(FxConversionValidator.class);
	}

	@Override
	public Validator<? super FxConversion> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FxConversion>create(FxConversionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FxConversion> validator() {
		return new FxConversionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FxConversion> typeFormatValidator() {
		return new FxConversionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxConversion, Set<String>> onlyExistsValidator() {
		return new FxConversionOnlyExistsValidator();
	}
}
