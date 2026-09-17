package cdm.legaldocumentation.master.isda.meta;

import cdm.legaldocumentation.master.isda.SpecifiedEntity;
import cdm.legaldocumentation.master.isda.validation.SpecifiedEntityTypeFormatValidator;
import cdm.legaldocumentation.master.isda.validation.SpecifiedEntityValidator;
import cdm.legaldocumentation.master.isda.validation.datarule.SpecifiedEntityMaterialSubsidiary;
import cdm.legaldocumentation.master.isda.validation.datarule.SpecifiedEntityOtherSpecifiedEntity;
import cdm.legaldocumentation.master.isda.validation.datarule.SpecifiedEntitySpecifiedEntity;
import cdm.legaldocumentation.master.isda.validation.exists.SpecifiedEntityOnlyExistsValidator;
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
@RosettaMeta(model=SpecifiedEntity.class)
public class SpecifiedEntityMeta implements RosettaMetaData<SpecifiedEntity> {

	@Override
	public List<Validator<? super SpecifiedEntity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<SpecifiedEntity>create(SpecifiedEntitySpecifiedEntity.class),
			factory.<SpecifiedEntity>create(SpecifiedEntityMaterialSubsidiary.class),
			factory.<SpecifiedEntity>create(SpecifiedEntityOtherSpecifiedEntity.class)
		);
	}
	
	@Override
	public List<Function<? super SpecifiedEntity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super SpecifiedEntity> validator(ValidatorFactory factory) {
		return factory.<SpecifiedEntity>create(SpecifiedEntityValidator.class);
	}

	@Override
	public Validator<? super SpecifiedEntity> typeFormatValidator(ValidatorFactory factory) {
		return factory.<SpecifiedEntity>create(SpecifiedEntityTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super SpecifiedEntity> validator() {
		return new SpecifiedEntityValidator();
	}

	@Deprecated
	@Override
	public Validator<? super SpecifiedEntity> typeFormatValidator() {
		return new SpecifiedEntityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SpecifiedEntity, Set<String>> onlyExistsValidator() {
		return new SpecifiedEntityOnlyExistsValidator();
	}
}
