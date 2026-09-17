package cdm.legaldocumentation.csa.meta;

import cdm.legaldocumentation.csa.BespokeCalculationDate;
import cdm.legaldocumentation.csa.validation.BespokeCalculationDateTypeFormatValidator;
import cdm.legaldocumentation.csa.validation.BespokeCalculationDateValidator;
import cdm.legaldocumentation.csa.validation.datarule.BespokeCalculationDateCalculationDateImTerms;
import cdm.legaldocumentation.csa.validation.exists.BespokeCalculationDateOnlyExistsValidator;
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
@RosettaMeta(model=BespokeCalculationDate.class)
public class BespokeCalculationDateMeta implements RosettaMetaData<BespokeCalculationDate> {

	@Override
	public List<Validator<? super BespokeCalculationDate>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<BespokeCalculationDate>create(BespokeCalculationDateCalculationDateImTerms.class)
		);
	}
	
	@Override
	public List<Function<? super BespokeCalculationDate, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BespokeCalculationDate> validator(ValidatorFactory factory) {
		return factory.<BespokeCalculationDate>create(BespokeCalculationDateValidator.class);
	}

	@Override
	public Validator<? super BespokeCalculationDate> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BespokeCalculationDate>create(BespokeCalculationDateTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BespokeCalculationDate> validator() {
		return new BespokeCalculationDateValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BespokeCalculationDate> typeFormatValidator() {
		return new BespokeCalculationDateTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BespokeCalculationDate, Set<String>> onlyExistsValidator() {
		return new BespokeCalculationDateOnlyExistsValidator();
	}
}
