package cdm.observable.asset.fro.meta;

import cdm.observable.asset.fro.FloatingRateIndexExternalMappings;
import cdm.observable.asset.fro.validation.FloatingRateIndexExternalMappingsTypeFormatValidator;
import cdm.observable.asset.fro.validation.FloatingRateIndexExternalMappingsValidator;
import cdm.observable.asset.fro.validation.exists.FloatingRateIndexExternalMappingsOnlyExistsValidator;
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
@RosettaMeta(model=FloatingRateIndexExternalMappings.class)
public class FloatingRateIndexExternalMappingsMeta implements RosettaMetaData<FloatingRateIndexExternalMappings> {

	@Override
	public List<Validator<? super FloatingRateIndexExternalMappings>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FloatingRateIndexExternalMappings, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FloatingRateIndexExternalMappings> validator(ValidatorFactory factory) {
		return factory.<FloatingRateIndexExternalMappings>create(FloatingRateIndexExternalMappingsValidator.class);
	}

	@Override
	public Validator<? super FloatingRateIndexExternalMappings> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FloatingRateIndexExternalMappings>create(FloatingRateIndexExternalMappingsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndexExternalMappings> validator() {
		return new FloatingRateIndexExternalMappingsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FloatingRateIndexExternalMappings> typeFormatValidator() {
		return new FloatingRateIndexExternalMappingsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FloatingRateIndexExternalMappings, Set<String>> onlyExistsValidator() {
		return new FloatingRateIndexExternalMappingsOnlyExistsValidator();
	}
}
