package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.CollateralAccessBreach;
import cdm.legaldocumentation.csa.validation.CollateralAccessBreachTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.CollateralAccessBreachValidator;
import cdm.legaldocumentation.csa.validation.datarule.CollateralAccessBreachCabEndDateTerms;
import cdm.legaldocumentation.csa.validation.exists.CollateralAccessBreachOnlyExistsValidator;
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
@RosettaMeta(model=CollateralAccessBreach.class)
public class CollateralAccessBreachMeta implements RosettaMetaData<CollateralAccessBreach> {

	@Override
	public List<Validator<? super CollateralAccessBreach>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CollateralAccessBreach>create(CollateralAccessBreachCabEndDateTerms.class)
		);
	}
	
	@Override
	public List<Function<? super CollateralAccessBreach, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CollateralAccessBreach> validator(ValidatorFactory factory) {
		return factory.<CollateralAccessBreach>create(CollateralAccessBreachValidator.class);
	}

	@Override
	public Validator<? super CollateralAccessBreach> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CollateralAccessBreach>create(CollateralAccessBreachTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CollateralAccessBreach> validator() {
		return new CollateralAccessBreachValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CollateralAccessBreach> typeFormatValidator() {
		return new CollateralAccessBreachTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralAccessBreach, Set<String>> onlyExistsValidator() {
		return new CollateralAccessBreachOnlyExistsValidator();
	}
}
