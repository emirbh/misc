package cdm.observable.asset.fro.meta;

import cdm.observable.asset.fro.FloatingRateIndexExternalMap;
import cdm.observable.asset.fro.validation.FloatingRateIndexExternalMapTypeFormatValidator;
import cdm.observable.asset.fro.validation.FloatingRateIndexExternalMapValidator;
import cdm.observable.asset.fro.validation.exists.FloatingRateIndexExternalMapOnlyExistsValidator;
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
@RosettaMeta(model=FloatingRateIndexExternalMap.class)
public class FloatingRateIndexExternalMapMeta implements RosettaMetaData<FloatingRateIndexExternalMap> {

	@Override
	public List<Validator<? super FloatingRateIndexExternalMap>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateIndexExternalMap, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRateIndexExternalMap> validator(ValidatorFactory factory) {
		return factory.<FloatingRateIndexExternalMap>create(FloatingRateIndexExternalMapValidator.class);
	}

	@Override
	public Validator<? super FloatingRateIndexExternalMap> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingRateIndexExternalMap>create(FloatingRateIndexExternalMapTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndexExternalMap> validator() {
		return new FloatingRateIndexExternalMapValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndexExternalMap> typeFormatValidator() {
		return new FloatingRateIndexExternalMapTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateIndexExternalMap, Set<String>> onlyExistsValidator() {
		return new FloatingRateIndexExternalMapOnlyExistsValidator();
	}
}
