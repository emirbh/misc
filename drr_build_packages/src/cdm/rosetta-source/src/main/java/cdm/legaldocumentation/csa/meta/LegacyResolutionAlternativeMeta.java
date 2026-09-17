package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.LegacyResolutionAlternative;
import cdm.legaldocumentation.csa.validation.LegacyResolutionAlternativeTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.LegacyResolutionAlternativeValidator;
import cdm.legaldocumentation.csa.validation.datarule.LegacyResolutionAlternativeAdditionalLanguage;
import cdm.legaldocumentation.csa.validation.datarule.LegacyResolutionAlternativeSplitDifferenceAmount;
import cdm.legaldocumentation.csa.validation.exists.LegacyResolutionAlternativeOnlyExistsValidator;
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
@RosettaMeta(model=LegacyResolutionAlternative.class)
public class LegacyResolutionAlternativeMeta implements RosettaMetaData<LegacyResolutionAlternative> {

	@Override
	public List<Validator<? super LegacyResolutionAlternative>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<LegacyResolutionAlternative>create(LegacyResolutionAlternativeAdditionalLanguage.class),
			factory.<LegacyResolutionAlternative>create(LegacyResolutionAlternativeSplitDifferenceAmount.class)
		);
	}
	
	@Override
	public List<Function<? super LegacyResolutionAlternative, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super LegacyResolutionAlternative> validator(ValidatorFactory factory) {
		return factory.<LegacyResolutionAlternative>create(LegacyResolutionAlternativeValidator.class);
	}

	@Override
	public Validator<? super LegacyResolutionAlternative> typeFormatValidator(ValidatorFactory factory) {
		return factory.<LegacyResolutionAlternative>create(LegacyResolutionAlternativeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super LegacyResolutionAlternative> validator() {
		return new LegacyResolutionAlternativeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super LegacyResolutionAlternative> typeFormatValidator() {
		return new LegacyResolutionAlternativeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super LegacyResolutionAlternative, Set<String>> onlyExistsValidator() {
		return new LegacyResolutionAlternativeOnlyExistsValidator();
	}
}
