package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CreditQuality;
import fpml.consolidated.asset.validation.CreditQualityTypeFormatValidator;
import fpml.consolidated.asset.validation.CreditQualityValidator;
import fpml.consolidated.asset.validation.exists.CreditQualityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditQuality.class)
public class CreditQualityMeta implements RosettaMetaData<CreditQuality> {

	@Override
	public List<Validator<? super CreditQuality>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditQuality, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditQuality> validator(ValidatorFactory factory) {
		return factory.<CreditQuality>create(CreditQualityValidator.class);
	}

	@Override
	public Validator<? super CreditQuality> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditQuality>create(CreditQualityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditQuality> validator() {
		return new CreditQualityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditQuality> typeFormatValidator() {
		return new CreditQualityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditQuality, Set<String>> onlyExistsValidator() {
		return new CreditQualityOnlyExistsValidator();
	}
}
