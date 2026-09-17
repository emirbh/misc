package cdm.observable.asset.meta;

import cdm.observable.asset.Observable;
import cdm.observable.asset.validation.ObservableTypeFormatValidator;
import cdm.observable.asset.validation.ObservableValidator;
import cdm.observable.asset.validation.datarule.ObservableChoice;
import cdm.observable.asset.validation.exists.ObservableOnlyExistsValidator;
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
@RosettaMeta(model=Observable.class)
public class ObservableMeta implements RosettaMetaData<Observable> {

	@Override
	public List<Validator<? super Observable>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<Observable>create(ObservableChoice.class)
		);
	}
	
	@Override
	public List<Function<? super Observable, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Observable> validator(ValidatorFactory factory) {
		return factory.<Observable>create(ObservableValidator.class);
	}

	@Override
	public Validator<? super Observable> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Observable>create(ObservableTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Observable> validator() {
		return new ObservableValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Observable> typeFormatValidator() {
		return new ObservableTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Observable, Set<String>> onlyExistsValidator() {
		return new ObservableOnlyExistsValidator();
	}
}
