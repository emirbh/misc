package cdm.observable.asset.fro.meta;

import cdm.observable.asset.fro.FloatingRateIndexMappings;
import cdm.observable.asset.fro.validation.FloatingRateIndexMappingsTypeFormatValidator;
import cdm.observable.asset.fro.validation.FloatingRateIndexMappingsValidator;
import cdm.observable.asset.fro.validation.exists.FloatingRateIndexMappingsOnlyExistsValidator;
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
@RosettaMeta(model=FloatingRateIndexMappings.class)
public class FloatingRateIndexMappingsMeta implements RosettaMetaData<FloatingRateIndexMappings> {

	@Override
	public List<Validator<? super FloatingRateIndexMappings>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateIndexMappings, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRateIndexMappings> validator(ValidatorFactory factory) {
		return factory.<FloatingRateIndexMappings>create(FloatingRateIndexMappingsValidator.class);
	}

	@Override
	public Validator<? super FloatingRateIndexMappings> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingRateIndexMappings>create(FloatingRateIndexMappingsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndexMappings> validator() {
		return new FloatingRateIndexMappingsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndexMappings> typeFormatValidator() {
		return new FloatingRateIndexMappingsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateIndexMappings, Set<String>> onlyExistsValidator() {
		return new FloatingRateIndexMappingsOnlyExistsValidator();
	}
}
