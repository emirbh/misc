package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CoalStandardQuality;
import fpml.consolidated.com.validation.CoalStandardQualityTypeFormatValidator;
import fpml.consolidated.com.validation.CoalStandardQualityValidator;
import fpml.consolidated.com.validation.exists.CoalStandardQualityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CoalStandardQuality.class)
public class CoalStandardQualityMeta implements RosettaMetaData<CoalStandardQuality> {

	@Override
	public List<Validator<? super CoalStandardQuality>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalStandardQuality, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CoalStandardQuality> validator(ValidatorFactory factory) {
		return factory.<CoalStandardQuality>create(CoalStandardQualityValidator.class);
	}

	@Override
	public Validator<? super CoalStandardQuality> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CoalStandardQuality>create(CoalStandardQualityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CoalStandardQuality> validator() {
		return new CoalStandardQualityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CoalStandardQuality> typeFormatValidator() {
		return new CoalStandardQualityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalStandardQuality, Set<String>> onlyExistsValidator() {
		return new CoalStandardQualityOnlyExistsValidator();
	}
}
