package cdm.legaldocumentation.master.isda.meta;

import cdm.legaldocumentation.master.isda.SpecifiedEntities;
import cdm.legaldocumentation.master.isda.validation.SpecifiedEntitiesTypeFormatValidator;
import cdm.legaldocumentation.master.isda.validation.SpecifiedEntitiesValidator;
import cdm.legaldocumentation.master.isda.validation.exists.SpecifiedEntitiesOnlyExistsValidator;
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
@RosettaMeta(model=SpecifiedEntities.class)
public class SpecifiedEntitiesMeta implements RosettaMetaData<SpecifiedEntities> {

	@Override
	public List<Validator<? super SpecifiedEntities>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SpecifiedEntities, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SpecifiedEntities> validator(ValidatorFactory factory) {
		return factory.<SpecifiedEntities>create(SpecifiedEntitiesValidator.class);
	}

	@Override
	public Validator<? super SpecifiedEntities> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SpecifiedEntities>create(SpecifiedEntitiesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SpecifiedEntities> validator() {
		return new SpecifiedEntitiesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SpecifiedEntities> typeFormatValidator() {
		return new SpecifiedEntitiesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SpecifiedEntities, Set<String>> onlyExistsValidator() {
		return new SpecifiedEntitiesOnlyExistsValidator();
	}
}
