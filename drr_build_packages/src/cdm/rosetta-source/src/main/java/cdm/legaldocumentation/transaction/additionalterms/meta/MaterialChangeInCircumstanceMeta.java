package cdm.legaldocumentation.transaction.additionalterms.meta;

import cdm.legaldocumentation.transaction.additionalterms.MaterialChangeInCircumstance;
import cdm.legaldocumentation.transaction.additionalterms.validation.MaterialChangeInCircumstanceTypeFormatValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.MaterialChangeInCircumstanceValidator;
import cdm.legaldocumentation.transaction.additionalterms.validation.exists.MaterialChangeInCircumstanceOnlyExistsValidator;
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
@RosettaMeta(model=MaterialChangeInCircumstance.class)
public class MaterialChangeInCircumstanceMeta implements RosettaMetaData<MaterialChangeInCircumstance> {

	@Override
	public List<Validator<? super MaterialChangeInCircumstance>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MaterialChangeInCircumstance, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MaterialChangeInCircumstance> validator(ValidatorFactory factory) {
		return factory.<MaterialChangeInCircumstance>create(MaterialChangeInCircumstanceValidator.class);
	}

	@Override
	public Validator<? super MaterialChangeInCircumstance> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MaterialChangeInCircumstance>create(MaterialChangeInCircumstanceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MaterialChangeInCircumstance> validator() {
		return new MaterialChangeInCircumstanceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MaterialChangeInCircumstance> typeFormatValidator() {
		return new MaterialChangeInCircumstanceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MaterialChangeInCircumstance, Set<String>> onlyExistsValidator() {
		return new MaterialChangeInCircumstanceOnlyExistsValidator();
	}
}
