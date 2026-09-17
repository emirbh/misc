package cdm.observable.asset.meta;

import cdm.observable.asset.ValuationMethod;
import cdm.observable.asset.validation.ValuationMethodTypeFormatValidator;
import cdm.observable.asset.validation.ValuationMethodValidator;
import cdm.observable.asset.validation.datarule.ValuationMethodDealer;
import cdm.observable.asset.validation.datarule.ValuationMethodFpML_cd_37;
import cdm.observable.asset.validation.exists.ValuationMethodOnlyExistsValidator;
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
@RosettaMeta(model=ValuationMethod.class)
public class ValuationMethodMeta implements RosettaMetaData<ValuationMethod> {

	@Override
	public List<Validator<? super ValuationMethod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ValuationMethod>create(ValuationMethodFpML_cd_37.class),
			factory.<ValuationMethod>create(ValuationMethodDealer.class)
		);
	}
	
	@Override
	public List<Function<? super ValuationMethod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationMethod> validator(ValidatorFactory factory) {
		return factory.<ValuationMethod>create(ValuationMethodValidator.class);
	}

	@Override
	public Validator<? super ValuationMethod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuationMethod>create(ValuationMethodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuationMethod> validator() {
		return new ValuationMethodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuationMethod> typeFormatValidator() {
		return new ValuationMethodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationMethod, Set<String>> onlyExistsValidator() {
		return new ValuationMethodOnlyExistsValidator();
	}
}
