package cdm.observable.asset.fro.meta;

import cdm.observable.asset.fro.FloatingRateIndexMap;
import cdm.observable.asset.fro.validation.FloatingRateIndexMapTypeFormatValidator;
import cdm.observable.asset.fro.validation.FloatingRateIndexMapValidator;
import cdm.observable.asset.fro.validation.datarule.FloatingRateIndexMapChoice;
import cdm.observable.asset.fro.validation.exists.FloatingRateIndexMapOnlyExistsValidator;
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
@RosettaMeta(model=FloatingRateIndexMap.class)
public class FloatingRateIndexMapMeta implements RosettaMetaData<FloatingRateIndexMap> {

	@Override
	public List<Validator<? super FloatingRateIndexMap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FloatingRateIndexMap>create(FloatingRateIndexMapChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FloatingRateIndexMap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRateIndexMap> validator(ValidatorFactory factory) {
		return factory.<FloatingRateIndexMap>create(FloatingRateIndexMapValidator.class);
	}

	@Override
	public Validator<? super FloatingRateIndexMap> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingRateIndexMap>create(FloatingRateIndexMapTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndexMap> validator() {
		return new FloatingRateIndexMapValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndexMap> typeFormatValidator() {
		return new FloatingRateIndexMapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateIndexMap, Set<String>> onlyExistsValidator() {
		return new FloatingRateIndexMapOnlyExistsValidator();
	}
}
