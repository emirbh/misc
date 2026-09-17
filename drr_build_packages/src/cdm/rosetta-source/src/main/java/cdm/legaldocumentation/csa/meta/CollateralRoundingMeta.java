package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CollateralRounding;
import cdm.legaldocumentation.csa.validation.CollateralRoundingTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CollateralRoundingValidator;
import cdm.legaldocumentation.csa.validation.exists.CollateralRoundingOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=CollateralRounding.class)
public class CollateralRoundingMeta implements RosettaMetaData<CollateralRounding> {

	@Override
	public List<Validator<? super CollateralRounding>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CollateralRounding, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralRounding> validator(ValidatorFactory factory) {
		return factory.<CollateralRounding>create(CollateralRoundingValidator.class);
	}

	@Override
	public Validator<? super CollateralRounding> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralRounding>create(CollateralRoundingTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralRounding> validator() {
		return new CollateralRoundingValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralRounding> typeFormatValidator() {
		return new CollateralRoundingTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralRounding, Set<String>> onlyExistsValidator() {
		return new CollateralRoundingOnlyExistsValidator();
	}
}
