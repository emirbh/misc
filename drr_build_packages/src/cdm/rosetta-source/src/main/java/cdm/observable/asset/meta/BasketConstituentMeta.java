package cdm.observable.asset.meta;

import cdm.observable.asset.BasketConstituent;
import cdm.observable.asset.Observable;
import cdm.observable.asset.validation.BasketConstituentTypeFormatValidator;
import cdm.observable.asset.validation.BasketConstituentValidator;
import cdm.observable.asset.validation.datarule.BasketConstituentBasketsOfBaskets;
import cdm.observable.asset.validation.datarule.ObservableChoice;
import cdm.observable.asset.validation.exists.BasketConstituentOnlyExistsValidator;
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
@RosettaMeta(model=BasketConstituent.class)
public class BasketConstituentMeta implements RosettaMetaData<BasketConstituent> {

	@Override
	public List<Validator<? super BasketConstituent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Observable>create(ObservableChoice.class),
			factory.<BasketConstituent>create(BasketConstituentBasketsOfBaskets.class)
		);
	}
	
	@Override
	public List<Function<? super BasketConstituent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BasketConstituent> validator(ValidatorFactory factory) {
		return factory.<BasketConstituent>create(BasketConstituentValidator.class);
	}

	@Override
	public Validator<? super BasketConstituent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BasketConstituent>create(BasketConstituentTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BasketConstituent> validator() {
		return new BasketConstituentValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BasketConstituent> typeFormatValidator() {
		return new BasketConstituentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketConstituent, Set<String>> onlyExistsValidator() {
		return new BasketConstituentOnlyExistsValidator();
	}
}
